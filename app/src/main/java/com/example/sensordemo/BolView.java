package com.example.sensordemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.SensorEvent;
import android.view.View;

public class BolView extends View {

    private Paint ballPaint;
    private Paint redBalls;


    public float x;
    public float y;
    private int viewWidth;
    private int viewHight;
    private int punkty;
    public int ballPointX=100;
    public int ballPointY=200;

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    private static final int CIRCLE_RADIUS=50;


    public BolView(Context context) {
        super(context);
        ballPaint=new Paint();
        ballPaint.setColor(Color.RED);
        redBalls=new Paint();
        redBalls.setColor(Color.BLACK);



    }
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        viewWidth=w;
        viewHight=h;
    }

    public void onSensorEvent(SensorEvent event){


        if(x <= CIRCLE_RADIUS){
            x = CIRCLE_RADIUS;
        }
        if(x >= viewWidth - CIRCLE_RADIUS){
            x = viewWidth - CIRCLE_RADIUS;


        }

        if(y <= CIRCLE_RADIUS){
            y = CIRCLE_RADIUS;
        }
        if(y >= viewHight - CIRCLE_RADIUS){
            y = viewHight - CIRCLE_RADIUS;

        }

        if(x==ballPointX && y==ballPointY){
            punkty++;


        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);



        canvas.drawCircle(ballPointX,ballPointY,CIRCLE_RADIUS,ballPaint);
        canvas.drawCircle(x,y,CIRCLE_RADIUS,ballPaint);

       // canvas.drawCircle(ballPointX,ballPointY,CIRCLE_RADIUS,ballPaint);




        canvas.drawText("Punkty " + punkty,viewWidth/2-100,viewHight/2,ballPaint);
        ballPaint.setTextSize(32);
        invalidate();
    }

}
