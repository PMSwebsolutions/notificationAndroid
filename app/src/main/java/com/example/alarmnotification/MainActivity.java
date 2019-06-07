package com.example.alarmnotification;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Button btn ;
    private String title,text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                startAlarm();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void startAlarm(){
        String dateStart = "06/07/2019 01:53:00";
        String dateStop = "06/07/2019 01:54:00";
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        Date d1 = null;
        Date d2 = null;

        try {
            d1 = format.parse(dateStart);
            d2 = format.parse(dateStop);

            //in milliseconds
            long diff = d2.getTime() - d1.getTime();
            String sec = Long.toString(diff);
            Toast.makeText(MainActivity.this,sec,Toast.LENGTH_LONG).show();
            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            Intent intent = new Intent(this, AlertReciever.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);

            alarmManager.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+ diff ,pendingIntent);
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    public String getTit(){
        title = "TO-DO Notification";
        return title;
    }

    public String getTxt(){
        text = "You have an activity left to do.";
        return text;
    }


}
