package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private static ImageView clockFace;
    public static int getClockWidth()
    {
        return clockFace.getWidth();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Clock c = (Clock) findViewById(R.id.clock);
        clockFace= (ImageView) findViewById(R.id.Clockface);
        c.setTime(3,30,45);

    }
}