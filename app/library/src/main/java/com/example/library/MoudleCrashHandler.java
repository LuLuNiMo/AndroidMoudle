package com.example.library;

import android.app.Activity;
import android.content.Intent;
import android.os.Looper;
import android.util.Log;

public abstract class MoudleCrashHandler implements Thread.UncaughtExceptionHandler{

    protected Thread.UncaughtExceptionHandler handler;
    protected Activity activity;

    public void setException(Activity activity) {
        this.activity = activity;
        handler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {

        if (!handleException(e) && handler != null) {
            handler.uncaughtException(t, e);
        } else {
            Log.e("Log-uncaughtException", "*****" + e.getMessage());
            RecordLog(e);
            Restart();
            e.printStackTrace();
        }
        RecordLog(e);
    }


    private boolean handleException(final Throwable ex) {
        if (ex == null) {
            return false;
        }
        new Thread() {
            @Override
            public void run() {
                Looper.prepare();
                Log.e("Log-handleException----", "*****" + ex.getMessage());
                RecordLog(ex);
                Restart();
                ex.printStackTrace();
                Looper.loop();

            }
        }.start();
        return true;
    }
    protected abstract void Restart();
    protected abstract void RecordLog(Throwable e);

}
