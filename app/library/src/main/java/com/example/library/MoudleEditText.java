package com.example.library;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MoudleEditText extends androidx.appcompat.widget.AppCompatEditText {

    @SuppressLint("UseCompatLoadingForDrawables")
    public MoudleEditText(Context context) {
        super(context);
        this.setBackground(context.getDrawable(R.drawable.moudle_tvstyle));
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public MoudleEditText(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.setBackground(context.getDrawable(R.drawable.moudle_tvstyle));
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public MoudleEditText(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setBackground(context.getDrawable(R.drawable.moudle_tvstyle));
    }


}
