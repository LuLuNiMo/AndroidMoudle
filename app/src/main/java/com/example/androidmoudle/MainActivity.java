package com.example.androidmoudle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;

import com.example.library.AlterSweetDialog;
import com.example.library.MoudleInfos;
import com.example.library.MoudleNotification;
import com.example.library.MoudleOtherHelper;
import com.example.library.MoudleProgressDialog;
import com.example.library.Moudle_NetWorkHandle;


public class MainActivity extends AppCompatActivity {
    //private ProgressDialog d;
    //int i = 0;
    //private Handler timeHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


  /*      timeHandler = new Handler();
        d = new MoudleProgressDialog(this).GradientProgressDiagram("", ProgressDialog.STYLE_HORIZONTAL, MoudleInfos.Progress_Blue,
                MoudleInfos.image_process);
        d.show();

        timeHandler.postDelayed(timeer, 300);


        new AlterSweetDialog(this).ShowOne("Title","可輸入文字",vv->{},R.drawable.moudle_group_edit);
*/

    }


  /*  private Runnable timeer = new Runnable() {
        @Override
        public void run() {
            timeHandler.postDelayed(this, 300);
            i++;
            d.setProgress(i);

        }
    };*/


}