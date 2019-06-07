package com.example.alarmnotification;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {

    public static String CHANNEL_1_ID = "My Channel 1";

    @Override
    public void onCreate(){
        super.onCreate();
        createNotificationChannels();
    }

    private void createNotificationChannels(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel1 = new NotificationChannel(CHANNEL_1_ID,"Ym Channel 1", NotificationManager.IMPORTANCE_HIGH);
            channel1.setDescription("This is channel 1");
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
        }
    }
}
