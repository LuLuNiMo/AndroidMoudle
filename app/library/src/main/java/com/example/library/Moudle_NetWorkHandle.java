package com.example.library;

import static android.content.Context.WIFI_SERVICE;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class Moudle_NetWorkHandle {
    private Context c;
    private ConnectivityManager manager;

    public Moudle_NetWorkHandle(Context c) {
        this.c = c;
        manager = (ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    public boolean isConnect() {
        try {
            return (manager.getActiveNetworkInfo() != null && manager.getActiveNetworkInfo().isConnectedOrConnecting());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //取得手機MAC位置
    public static String getWIFI_MAC() {
        List<NetworkInterface> all = null;
        try {
            all = Collections.list(NetworkInterface.getNetworkInterfaces());
        } catch (SocketException e) {
            e.printStackTrace();
        }
        for (NetworkInterface nif : all) {
            if (!nif.getName().equalsIgnoreCase("wlan0")) continue;

            byte[] macBytes = new byte[0];
            try {
                macBytes = nif.getHardwareAddress();
            } catch (SocketException e1) {
                e1.printStackTrace();
            }
            if (macBytes == null) {
                return "";
            }

            StringBuilder res1 = new StringBuilder();
            for (byte b : macBytes) {
                res1.append(String.format("%02X:", b));
            }

            if (res1.length() > 0) {
                res1.deleteCharAt(res1.length() - 1);
            }
            return res1.toString();

        }
        return "02:00:00:00:00:00";
    }

    //取得IP
    public String getMyIp() {
        String ip = "";
        if (manager.getActiveNetworkInfo().getType() == ConnectivityManager.TYPE_WIFI) {
            ip = getWifi_IP();
        } else {
            ip = getLocalIpAddress();
        }
        return ip;
    }


    //取得WI-FI IP
    public String getWifi_IP() {
        WifiManager wifi_service = (WifiManager) c.getSystemService(WIFI_SERVICE); //新增一個WifiManager物件並取得WIFI_SERVICE
        WifiInfo wifiInfo = wifi_service.getConnectionInfo();  //取得wifi資訊

        int ipAddress = wifiInfo.getIpAddress(); //取得IP，但這會是一個詭異的數字，還要再自己換算才行
        return String.format("%d.%d.%d.%d", (ipAddress & 0xff), (ipAddress >> 8 & 0xff), (ipAddress >> 16 & 0xff), (ipAddress >> 24 & 0xff));//利用位移運算和AND運算計算IP
    }

    //取得自行上網IP
    public String getLocalIpAddress() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
                 en.hasMoreElements(); ) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return " ";
    }


    //取得wifi資訊
    @SuppressLint("DefaultLocale") //WiFi資訊,連結速度,連結機子速度,連結速度單位,Wifi源名稱,IP位置
    public String[] getWiFi_Info() {
        WifiManager wifiManager = (WifiManager) c.getApplicationContext().getSystemService(WIFI_SERVICE);
        WifiInfo info = wifiManager.getConnectionInfo();
        int strength = 0;// 連結訊號強度,5為獲取的訊號強度值在5以內
        int speed = 0;// 連結速度
        String units = "";// 連結速度單位
        String ssid = "";// Wifi源名稱
        String ip = "";

        if (info.getBSSID() != null) {
            strength = WifiManager.calculateSignalLevel(info.getRssi(), 5);
            speed = info.getLinkSpeed();
            units = WifiInfo.LINK_SPEED_UNITS;
            ssid = info.getSSID();
            ip = String.format("%d.%d.%d.%d", (info.getIpAddress() & 0xff),
                    (info.getIpAddress() >> 8 & 0xff), (info.getIpAddress() >> 16 & 0xff), (info.getIpAddress() >> 24 & 0xff));
        }
        String[] arr = {info.toString(), String.valueOf(strength), String.valueOf(speed), units, ssid, ip};
        return arr;
    }




}



