package com.example.library;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.ScrollView;

public class ScrollView2 extends ScrollView {
    private Context mContext;

    public ScrollView2(Context context) {
        this(context, null);
    }

    public ScrollView2(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScrollView2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        try {
            Display display = ((Activity) mContext).getWindowManager().getDefaultDisplay();
            DisplayMetrics d = new DisplayMetrics();
            display.getMetrics(d);
            // 設定控制元件最大高度不能超過螢幕高度的一半
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(d.heightPixels / 2, MeasureSpec.AT_MOST);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 重新計算控制元件的寬高
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

}
