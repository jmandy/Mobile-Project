package com.example.jmand.lab4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class Draw extends View {

    Paint paint;
    Path path;
    float x_pt, y_pt;



    public Draw(Context context) {
        super(context);
        init();
    }

    public Draw(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

        private void moveTouch(float x, float y) {
        float dx = Math.abs(x - x_pt); //distance of x and x_pt
        float dy = Math.abs(y - y_pt); //distance of y and y_pt

        if (dx >= 7 || dy >= 7) {
            path.quadTo(x_pt, y_pt, (x + x_pt) / 2, (y + y_pt) / 2);
            this.x_pt = x;//set x_pt
            this.y_pt = y;//set y_pt
        }

    }




    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float x = event.getX();//get X position
        float y = event.getY();//get Y position

        if(event.getAction()==MotionEvent.ACTION_DOWN){
            path.moveTo(x, y);
            this.x_pt = x;
            this.y_pt = y;
            invalidate();
        }
        else if(event.getAction()== MotionEvent.ACTION_UP){
            path.lineTo(x_pt, y_pt);
            invalidate();
        }
        else if(event.getAction()==MotionEvent.ACTION_MOVE){
            moveTouch(x, y);
            invalidate();
        }
        return true;
    }



    //paint method
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path, paint);
    }

    public void init() {
        paint = new Paint();
        path = new Path();
        paint.setColor(Color.BLUE);//Draw color blue
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(7);
    }





}
