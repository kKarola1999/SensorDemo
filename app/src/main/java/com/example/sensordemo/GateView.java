package com.example.sensordemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

public class GateView extends View {
    private Paint gatePaint;
    private  float x ;
    private  float y ;
    private int viewWidth;
    private int viewHight;
    private int Score = 0;

    private  static  final int GATE_RADIUS = 50;

    public GateView(Context context) {
        super(context);
        gatePaint = new Paint ();
        gatePaint.setColor((Color.GREEN));
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        viewHight = h;
        viewWidth = w;
    }

    public void checkIfScore (float xB, float yB){
        if (x==xB && y==yB){
            Score++;
            invalidate();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float x = (int) (Math.random()*(viewWidth));
        float y = (int) (Math.random()*viewHight);
        canvas.drawText("Punkty" + Score,viewHight/2,viewWidth/2,gatePaint);
        gatePaint.setTextSize(50);

        canvas.drawCircle(x,y,GATE_RADIUS,gatePaint);
    }
}
