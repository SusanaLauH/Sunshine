package com.example.android.sunshine.app;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/**
 * Created by SusanaLauH on 3/12/2015.
 */
public class MyView extends View {

/*
 if (AccesibilityManager.getInstance(context).isEnabled()){
            sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED);
        }
 */
    String windSpeedDir = "";
    public MyView(Context context) {
        super(context);

    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, AttributeSet attrs, int defaultStyle) {
        super(context, attrs, defaultStyle);
    }

    @Override
    protected void onMeasure(int wMeasureSpec, int hMeasureSpec) {
        setMeasuredDimension(wMeasureSpec, hMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        //sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED);

        float w, h, cx, cy, radius;
        w = getWidth();
        h = getHeight();
        cx = w/2;
        cy = h/2;
        radius = cx/4;


        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(0xFF33B5E5);
        paint.setStrokeWidth(4);

        Paint textPaint = new Paint();
        textPaint.setStyle(Paint.Style.STROKE);
        textPaint.setColor(0xFF33B5E5);
        textPaint.setStrokeWidth(2);
        textPaint.setTextSize(18);

        canvas.drawCircle(cx, cy, radius, paint);
        canvas.drawText("S", cx, cy + radius - 5, textPaint );
        canvas.drawText("N", cx, cy - radius + 5, textPaint );
        canvas.drawText("W", cx - radius, cy, textPaint );
        canvas.drawText("E", cx + radius - 10, cy, textPaint );
        canvas.drawLine(cx -radius, cy, cx + radius, cy, paint);
        canvas.drawLine(cx, cy - radius, cx, cy + radius, paint);

    }


    @Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent ev){
        ev.getText().add(windSpeedDir);
        return true;
    }

}
