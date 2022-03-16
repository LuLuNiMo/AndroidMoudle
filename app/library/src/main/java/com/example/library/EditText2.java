package com.example.library;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class EditText2 extends androidx.appcompat.widget.AppCompatEditText {

    @SuppressLint("UseCompatLoadingForDrawables")
    public EditText2(Context context) {
        super(context);
        this.setBackground(context.getDrawable(R.drawable.tvstyle));
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public EditText2(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.setBackground(context.getDrawable(R.drawable.tvstyle));
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public EditText2(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setBackground(context.getDrawable(R.drawable.tvstyle));
    }


}
