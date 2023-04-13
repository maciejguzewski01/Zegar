package com.example.lab3;

import android.graphics.Color;
import android.view.View;
import android.graphics.Canvas;
import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;


public class Clock extends View {

    private int hour, minute;
    private double second;

    private Paint p;

    public Clock(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        second=0;
        minute=0;
        hour=0;

        p=new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setColor(Color.RED);




    }




    public void setTime(int h, int m, int s)
    {
        if((h<0)||(h>24)||(m<0)||(m>59)||(s<0)||(s>59)) return;
        if(h>12)
        {
            switch(h)
            {
                case 13:
                    h=1;
                break;
                case 14:
                    h=2;
                    break;
                case 15:
                    h=3;
                    break;
                case 16:
                    h=4;
                    break;
                case 17:
                    h=5;
                    break;
                case 18:
                    h=6;
                    break;
                case 19:
                    h=7;
                    break;
                case 20:
                    h=8;
                    break;
                case 21:
                    h=9;
                    break;
                case 22:
                    h=10;
                    break;
                case 23:
                    h=11;
                    break;
                case 24:
                    h=0;
                    break;
            }
        }
        else if(h==12) h=0;
        hour=h;
        minute=m;
        second=s;
    }


    @Override
    protected void onDraw(Canvas canvas)
    {


        super.onDraw(canvas);
        int center_width=this.getWidth()/2;
        int center_height=this.getHeight()/2;

//angles of seconds, minutes and hour
        double seconds_angle=(double)(second)*(6.0/360.0)*2.0*Math.PI;
        double minutes_angle=(double)minute*(6.0/360.0)*2.0*Math.PI;
        double hour_angle=(double)hour*(1.0/12.0)*2.0*Math.PI+((1.0/12.0)*((double) minute/60.0)*2.0*Math.PI);

        int size=MainActivity.getClockWidth()/2;



p.setStrokeWidth(10);


        canvas.drawLine( center_width,center_height, (float) (center_width+(size*Math.sin(seconds_angle))),(float) (center_height-(size*Math.cos(seconds_angle))),p); //seconds
        canvas.drawLine(center_width,center_height, (float) (center_width+(size*Math.sin(minutes_angle))),(float) (center_height-(size*Math.cos(minutes_angle))),p);  //minutes
        canvas.drawLine(center_width,center_height, (float) (center_width+(size*Math.sin(hour_angle))),(float) (center_height-(size*Math.cos(hour_angle))),p); //hours





    }


}