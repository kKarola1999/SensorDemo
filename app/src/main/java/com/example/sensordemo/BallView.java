package com.example.sensordemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.SensorEvent;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class BallView extends View {

    private Paint ballPaint;
    private Paint redBalls;
    private Paint text;



    public float x;
    public float y;
    private int viewWidth;
    private int viewHight;
    private int punkty;
    public int ballPointX = 200;
    public int ballPointY = 600;
    private static final int CIRCLE_RADIUS = 50;
    private SoundEffect sound;

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }


    public BallView(Context context) {
        super(context);
        ballPaint = new Paint();
        ballPaint.setColor(Color.RED);
        redBalls = new Paint();
        redBalls.setColor(Color.GREEN);
        redBalls.setStyle(Paint.Style.STROKE);
        redBalls.setStrokeWidth(15);
        text = new Paint();
        text.setTextSize(60);
        text.setAntiAlias(true);
        text.setColor(Color.BLUE);
        sound=new SoundEffect(context);


    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        viewWidth = w;
        viewHight = h;
    }

    public void onSensorEvent(SensorEvent event) {


        if (x <= CIRCLE_RADIUS) {
            x = CIRCLE_RADIUS;
        }
        if (x >= viewWidth - CIRCLE_RADIUS) {
            x = viewWidth - CIRCLE_RADIUS;


        }

        if (y <= CIRCLE_RADIUS) {
            y = CIRCLE_RADIUS;
        }
        if (y >= viewHight - CIRCLE_RADIUS) {
            y = viewHight - CIRCLE_RADIUS;

        }

        if ((x > ballPointX - CIRCLE_RADIUS && x < ballPointX + CIRCLE_RADIUS) && (y > ballPointY - CIRCLE_RADIUS) && y < ballPointY + CIRCLE_RADIUS) {
            punkty++;
            ballPointX = (int) (Math.random() * (viewWidth - CIRCLE_RADIUS * 2) + CIRCLE_RADIUS * 2);
            ballPointY = (int) (Math.random() * viewHight - CIRCLE_RADIUS * 2) + CIRCLE_RADIUS * 2;
            sound.playHitSound();


        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        canvas.drawCircle(ballPointX, ballPointY, CIRCLE_RADIUS, redBalls);
        canvas.drawCircle(x, y, CIRCLE_RADIUS, ballPaint);
        canvas.drawText("Punkty " + punkty, viewWidth / 2 - 100, viewHight / 2, text);

        invalidate();
    }

}