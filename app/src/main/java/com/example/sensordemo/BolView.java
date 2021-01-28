package com.example.sensordemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.SensorEvent;
import android.view.View;

public class BolView extends View {

    private Paint ballPaint;
    public float x;
    public float y;
    private int viewWidth;
    private int viewHight;

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
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);




        canvas.drawCircle(x,y,CIRCLE_RADIUS,ballPaint);
        ballPaint.setTextSize(32);
        invalidate();
    }

}
