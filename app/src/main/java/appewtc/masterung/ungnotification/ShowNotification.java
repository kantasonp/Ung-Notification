package appewtc.masterung.ungnotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;

public class ShowNotification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_notification);

        showNoti();

    }   // Main Method

    private void showNoti() {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.doremon48);
        builder.setTicker("Driving Better");
        builder.setWhen(System.currentTimeMillis());
        builder.setContentTitle("ระยะเกิน");
        builder.setContentText("ถึงเวลา แว้ววววว");
        builder.setAutoCancel(false);


        Uri soundUri = RingtoneManager.getDefaultUri(Notification.DEFAULT_SOUND);
        builder.setSound(soundUri);

        android.app.Notification notification = builder.build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1000, notification);


    }
}   // Main Class
