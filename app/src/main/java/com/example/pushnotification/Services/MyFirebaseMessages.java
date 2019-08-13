package com.example.pushnotification.Services;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.example.pushnotification.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.lang.annotation.Target;

public class MyFirebaseMessages extends FirebaseMessagingService {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);


        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        int importance = NotificationManager.IMPORTANCE_DEFAULT;
        NotificationChannel mChannel = notificationManager.getNotificationChannel("1");

        if (mChannel == null) {
            mChannel = new NotificationChannel("1", "channal title", importance);

        }
        Notification.Builder notification = new Notification.Builder(this,"1")
                .setContentTitle(remoteMessage.getData().get("title"))
                .setContentText(remoteMessage.getData().get("message"))
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setDefaults(Notification.DEFAULT_ALL)
                .setAutoCancel(true);

            notificationManager.createNotificationChannel(mChannel);
            notificationManager.notify(0, notification.build());


    }
}
