package com.example.library;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.BitmapFactory;

import androidx.core.app.NotificationCompat;

public class MoudleNotification {
    private Context c;
    private String AppName;

    public MoudleNotification(Context c,String AppName) {
        this.c = c;
        this.AppName = AppName;
    }

    public void Show(String title, String str, int id, String NotifyType, int BigImg, int smallImg) {

        NotificationManager manager = (NotificationManager) c.getSystemService(Context.NOTIFICATION_SERVICE);

        Notification.Builder builder = new Notification.Builder(c);


        builder.setSmallIcon(smallImg)
                .setLargeIcon(BitmapFactory.decodeResource(c.getResources(), BigImg))
                .setTicker(AppName)
                .setContentTitle(title)
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setContentText(str)
        ;

        switch (NotifyType) {
            case MoudleInfos.Notification_Sound:
                builder.setDefaults(Notification.DEFAULT_ALL);
                break;
            case MoudleInfos.Notification_shock:
                builder.setDefaults(Notification.DEFAULT_VIBRATE);
                builder.setSound(null);
                break;
            case MoudleInfos.Notification_None:
            default:
                builder.setDefaults(NotificationCompat.FLAG_ONLY_ALERT_ONCE);
                builder.setVibrate(new long[]{0});
                builder.setSound(null);
                break;
        }

        //Android 8 以上 需要 設定 Channel
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

            NotificationChannel channel = new NotificationChannel(NotifyType, "Moudle_channel",
                    NotificationManager.IMPORTANCE_DEFAULT);//設定唯一的渠道通知Id;

            switch (NotifyType) {
                case MoudleInfos.Notification_Sound:
                    channel.enableLights(false);
                    channel.enableVibration(true);
                    break;
                case MoudleInfos.Notification_shock:
                    channel.enableVibration(true);
                    channel.enableLights(false);
                    channel.setSound(null, null);
                    break;
                case MoudleInfos.Notification_None:
                default:
                    channel.enableLights(false);
                    channel.enableVibration(false);
                    channel.setVibrationPattern(new long[]{0});
                    channel.setSound(null, null);
                    break;
            }
            manager.createNotificationChannel(channel);//在NotificationManager中註冊渠道通知物件
            builder.setChannelId(NotifyType);//設定通知Id

        }
        manager.notify(id, builder.build());

    }

}




