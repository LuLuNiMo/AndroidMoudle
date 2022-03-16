package com.example.library;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;

public class ProgressDialog2 {
    private Activity a;


    public ProgressDialog2(Activity a) {
        this.a = a;
    }

    //一般款-預設
    public ProgressDialog OrdinaryProgressDialog(int style,String text) {
        ProgressDialog progressD = new ProgressDialog(a);
        progressD.setProgressStyle(style);
        progressD.setTitle(text);
        progressD.setIcon(R.drawable.process);
        progressD.setProgressNumberFormat("");
        progressD.setCancelable(false);
        progressD.setIndeterminate(false);
        progressD.setMax(100);
        return progressD;
    }

    //一般款
    public ProgressDialog OrdinaryProgressDialog(int style,String text,int icon) {
        ProgressDialog progressD = new ProgressDialog(a);
        progressD.setProgressStyle(style);
        progressD.setTitle(text);
        progressD.setIcon(icon);
        progressD.setProgressNumberFormat("");
        progressD.setCancelable(false);
        progressD.setIndeterminate(false);
        progressD.setMax(100);
        return progressD;
    }



    //漸層色
    @SuppressLint("UseCompatLoadingForDrawables")
    public ProgressDialog GradientProgressDiagram(String s,int style,int colorStyle,int icon) {
        ProgressDialog progressD = new ProgressDialog(a);
        progressD.setProgressStyle(style);  //設置進度條風格
        progressD.setTitle(s);
       progressD.setProgressDrawable(a.getDrawable(colorStyle));
        progressD.setIcon(icon);
        progressD.setProgressNumberFormat("");
        progressD.setCancelable(false);
        progressD.setIndeterminate(false);//設置進度條是否明確
        progressD.setMax(100);
        return progressD;
    }

    //一般款 左右跑來跑去
    public ProgressDialog HORIZONTAL_shakeProgressDiagram(String t,int icon) {
        ProgressDialog progressD = new ProgressDialog(a);
        progressD.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressD.setCancelable(false);
        progressD.setTitle(t);
        progressD.setCancelable(false);
        progressD.setProgressNumberFormat("");
        progressD.setProgressPercentFormat(null);
        progressD.setMax(100);
        progressD.setIndeterminate(true); //左右亂跑
        progressD.setIcon(icon);

        return progressD;
    }




}
