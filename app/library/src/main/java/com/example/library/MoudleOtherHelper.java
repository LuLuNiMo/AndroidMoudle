package com.example.library;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.BatteryManager;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MoudleOtherHelper {

    @SuppressLint("SimpleDateFormat")
    public static String getTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
        Date date = new Date(System.currentTimeMillis());
        return df.format(date);
    }


    //取得純數字時間
    @SuppressLint("SimpleDateFormat")
    public static String getTime2() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        Date date = new Date(System.currentTimeMillis());
        return df.format(date);
    }


    //日期相減(年/月/日)
    @SuppressLint("SimpleDateFormat")
    public static Long minusDate2(String da1, String da2) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");

        try {
            Date daa1 = df.parse(da1);
            Date daa2 = df.parse(da2);

            return daa1.getTime() - daa2.getTime();
        } catch (Exception e) {
            Log.e("ParseException", e.getMessage());
            e.printStackTrace();
        }
        return 0L;
    }

    //小數點後去掉
    public static String ShowNum(String s) {
        if (s.indexOf(".") > 0) {
            return s.replaceAll("0+?$", "0");
        } else {
            return s.replaceAll("[.]$", "");
        }
    }


    public static String getAppName(Context c) {
        String arr[] = c.getPackageName().split("\\.");
        return arr[arr.length - 1];
    }

    //Resert
    public static void reLoad(Activity a) {
        Intent intent = a.getIntent();
        a.overridePendingTransition(0, 0);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        a.finish();
        a.overridePendingTransition(0, 0);
        a.startActivity(intent);
    }


    //電量不足提醒
    public static void CheckBattery(Context c, String s, int bigImg, int smallImg, float n) {

        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = c.registerReceiver(null, ifilter);

        int status = batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
        boolean isCharging = (status == BatteryManager.BATTERY_STATUS_CHARGING ||
                status == BatteryManager.BATTERY_STATUS_FULL);

        if (isCharging) { //如果充電就不動作
            return;
        }

        int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

        float batteryPct = level * 100 / (float) scale;
        if (batteryPct <= n) {
            new MoudleNotification(c, getAppName(c)).Show("battery Warning", s, 99,
                    MoudleInfos.Notification_Sound, bigImg, smallImg);

        }
    }


    private static MediaPlayer musicPlayer = null;

    public static void BeepPlay(int id, Context c) {

        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Ringtone rt = RingtoneManager.getRingtone(c.getApplicationContext(), uri);
        rt.play();

        try {

            if (musicPlayer != null) {
                musicPlayer.stop();
                musicPlayer.release();
                musicPlayer = null;
            }

            musicPlayer = MediaPlayer.create(c, id);

            musicPlayer.stop();
            musicPlayer.prepare();
            musicPlayer.start();

        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}




