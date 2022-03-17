package com.example.androidmoudle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;

import com.example.library.MoudleInfos;
import com.example.library.MoudleProgressDialog;


public class MainActivity extends AppCompatActivity {
    private ProgressDialog d;
    int i = 0;
    private Handler timeHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        timeHandler = new Handler();
        d = new MoudleProgressDialog(this).HORIZONTAL_shakeProgressDiagram("123",MoudleInfos.image_process);
    d.show();

        timeHandler.postDelayed(timeer, 100);


    }


    private Runnable timeer = new Runnable() {
        @Override
        public void run() {
            timeHandler.postDelayed(this, 100);
            i++;
            d.setProgress(i);

        }
    };


}