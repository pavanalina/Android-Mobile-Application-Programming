package com.example.lab4wallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Button btnChange;
    Timer myTimer;
    WallpaperManager wpManger;
    Drawable drawable;
    int prev=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnChange=findViewById(R.id.btnChange);
        wpManger=WallpaperManager.getInstance(this);
        myTimer=new Timer();

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWallPaper();
            }
        });
    }
    public  void setWallPaper()
    {
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (prev==1)
                {
                    drawable=getResources().getDrawable(R.drawable.a);
                    prev=2;
                }
               else if (prev==2)
                {
                    drawable=getResources().getDrawable(R.drawable.b);
                    prev=3;
                }
                else if (prev==3)
                {
                    drawable=getResources().getDrawable(R.drawable.c);
                    prev=4;
                }
                else if (prev==4)
                {
                    drawable=getResources().getDrawable(R.drawable.d);
                    prev=5;
                }
                else if (prev==5)
                {
                    drawable=getResources().getDrawable(R.drawable.e);
                    prev=6;
                }
                else if (prev==6)
                {
                    drawable=getResources().getDrawable(R.drawable.f);
                    prev=7;
                }
                else if (prev==7)
                {
                    drawable=getResources().getDrawable(R.drawable.g);
                    prev=8;
                }
                else if (prev==8)
                {
                    drawable=getResources().getDrawable(R.drawable.h);
                    prev=1;
                }
                Bitmap wallpaper=((BitmapDrawable)drawable).getBitmap();
                try {
                    wpManger.setBitmap(wallpaper);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        },0,30000);

    }
}