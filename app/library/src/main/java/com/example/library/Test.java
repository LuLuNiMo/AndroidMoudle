package com.example.library;

import android.content.Context;
import android.widget.Toast;

public class Test {
    private Context c;

    public Test(Context c) {
        this.c = c;
    }

    public void Show(String s){
        Toast.makeText(c,s,Toast.LENGTH_SHORT).show();
    }

}
