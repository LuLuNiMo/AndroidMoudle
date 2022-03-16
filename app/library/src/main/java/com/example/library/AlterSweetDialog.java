package com.example.library;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class AlterSweetDialog extends AppCompatActivity {
    private Dialog dialog;
    private View v;

    private EditText2 ed;
    private AppCompatButton btn1,btn2,btn3;
    private TextView title,text;
    private ImageView iv;

    public AlterSweetDialog() {
        dialog = new Dialog(this, R.style.InfoDialog);
        v = LayoutInflater.from(this).inflate(R.layout.alterdialog, null);

        ed = v.findViewById(R.id.ed);
        btn1 = v.findViewById(R.id.btn1);
        btn2 = v.findViewById(R.id.btn2);
        btn3 = v.findViewById(R.id.btn3);
        title = v.findViewById(R.id.title);
        text = v.findViewById(R.id.text);
        iv = v.findViewById(R.id.iv);

    }

    public void ShowOne(String s1,String s2,boolean isText,int icon){
        title.setText(s1);
        text.setText(s2);
        iv.setImageResource(icon);
        btn2.setText("確定");
        btn2.setLayoutParams(showOBJ(230,120));

        if(isText){ed.setLayoutParams(showOBJ(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));}

        btn2.setOnClickListener(v->{
            dialog.dismiss();
        });

        dialog.setContentView(v);
        dialog.show();
    }

    public void ShowOne(String s1,String s2){
        title.setText(s1);
        text.setText(s2);
        iv.setImageResource(MoudleInfos.image_info);
        btn2.setText("確定");
        btn2.setLayoutParams(showOBJ(230,120));
        btn2.setOnClickListener(v->{
            dialog.dismiss();
        });
        dialog.setContentView(v);
        dialog.show();
    }

    public void ShowTwo(String s1,String s2,View.OnClickListener event,boolean isText,int icon){
        title.setText(s1);
        text.setText(s2);
        iv.setImageResource(icon);
        btn1.setText("確定");
        btn1.setLayoutParams(showOBJ(210,120));
        btn2.setText("取消");
        btn2.setLayoutParams(showOBJ(210,120));

        if(isText){ed.setLayoutParams(showOBJ(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));}

        btn1.setOnClickListener(event);

        btn2.setOnClickListener(v->{
            dialog.dismiss();
        });

        dialog.setContentView(v);
        dialog.show();
    }

    public void ShowThree(String t,String cc,String b1,String b2,View.OnClickListener event1,
                          View.OnClickListener event2,boolean isText,int icon){

        title.setText(t);
        text.setText(cc);
        iv.setImageResource(icon);
        btn1.setText(b1);
        btn1.setLayoutParams(showOBJ(200,120));
        btn2.setText(b2);
        btn2.setLayoutParams(showOBJ(200,120));
        btn3.setText("取消");
        btn3.setLayoutParams(showOBJ(200,120));

        if(isText){ed.setLayoutParams(showOBJ(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));}

        btn1.setOnClickListener(event1);
        btn2.setOnClickListener(event2);

        btn3.setOnClickListener(v->{
            dialog.dismiss();
        });

        dialog.setContentView(v);
        dialog.show();

    }

    public EditText2 getEd(){
        return ed;
    }

    public void Close() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    public String getText(){
        return ed.getText().toString();
    }


    private LinearLayout.LayoutParams showOBJ(int width, int height) {
        LinearLayout.LayoutParams ll = new LinearLayout.LayoutParams
                (width, height, 0);
        ll.setMargins(5, 5, 5, 5);
        return ll;
    }


}
