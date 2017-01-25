package com.example.tina.databases;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static int MY_PERM = 3;
    static int notificationID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ask for permission
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.VIBRATE)
                != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.VIBRATE}, MY_PERM);

        DBAdapter db = new DBAdapter(this);


        //---add a contact---
        db.open();
        long id = db.insertContact("Wei-Meng Lee", "weimenglee@learn2develop.net");
        id = db.insertContact("Mary Jackson", "mary@jackson.com");
        db.close();

        //---add an address---
        db.open();
        id = db.insertAddress("Ulica", 10);
        id = db.insertAddress("Uloca", 20);
        db.close();


//        //--get all contacts---
//        db.open();
//        Cursor c = db.getAllContacts();
//        if (c.moveToFirst())
//        {
//            do {
//                DisplayContact(c);
//            } while (c.moveToNext());
//        }
//        db.close();


//        //--get all addresses---
//        db.open();
//        Cursor c = db.getAllAddresses();
//        if (c.moveToFirst())
//        {
//            do {
//                DisplayAddress(c);
//            } while (c.moveToNext());
//        }
//        db.close();
//
//
//        //---get a contact---
//        db.open();
//        Cursor cu = db.getContact(2);
//        if (cu.moveToFirst())
//            DisplayContact(cu);
//        else
//            Toast.makeText(this, "No contact found", Toast.LENGTH_LONG).show();
//        db.close();
//
//
//
//        //---update contact---
//        db.open();
//        if (db.updateContact(1, "Wei-Meng Lee", "weimenglee@gmail.com"))
//            Toast.makeText(this, "Update successful.", Toast.LENGTH_LONG).show();
//        else
//            Toast.makeText(this, "Update failed.", Toast.LENGTH_LONG).show();
//        db.close();



//        //---delete a contact---
//        db.open();
//        if (db.deleteContact(1))
//            Toast.makeText(this, "Delete successful.", Toast.LENGTH_LONG).show();
//        else
//            Toast.makeText(this, "Delete failed.", Toast.LENGTH_LONG).show();
//        db.close();

    }

//    public void DisplayContact(Cursor c)
//    {
//        Toast.makeText(this,
//                "id: " + c.getString(0) + "\n" +
//                        "Name: " + c.getString(1) + "\n" +
//                        "Email:  " + c.getString(2),
//                Toast.LENGTH_LONG).show();
//    }
//
//    public void DisplayAddress(Cursor c)
//    {
//        Toast.makeText(this,
//                "id: " + c.getString(0) + "\n" +
//                        "Street: " + c.getString(1) + "\n" +
//                        "Number:  " + c.getString(2),
//                Toast.LENGTH_LONG).show();
//    }

    public void startEmbeddedCP(View view) {
        Intent intent = new Intent(this, EmbeddedCP.class);
        startActivity(intent);
    }

    public void startCustomCP(View view) {
        Intent intent = new Intent(this, CustomCP.class);
        startActivity(intent);
    }

    public void sendSmsEmail(View view) {
        Intent intent = new Intent(this, SmsEmail.class);
        startActivity(intent);
    }

    public void startWebConnection(View view) {
        Intent intent = new Intent(this, WebConnection.class);
        startActivity(intent);
    }

    public void startService(View view) {
        startService(new Intent(getBaseContext(), MyService.class));
    }

    public void stopService(View view) {
        stopService(new Intent(getBaseContext(), MyService.class));
    }

    public void showNotification(View view) {
        displayNotification();
    }


    protected void displayNotification()
    {
        //---PendingIntent to launch activity if the user selects
        // this notification---
        Intent i = new Intent(this, NotificationView.class);

        i.putExtra("notificationID", notificationID);


        PendingIntent pendingIntent =
                PendingIntent.getActivity(this, 0, i, 0);

        long[] vibrate = new long[] { 100, 250, 100, 500};

        NotificationManager nm = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);


        Notification notif = new Notification.Builder(this)
                .setTicker("Reminder: meeting starts in 5 minutes")
                .setContentTitle("Meeting with customer at 3pm...")
                .setContentText("this is the second row")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setWhen(System.currentTimeMillis())
                .setShowWhen(true)
                .setContentIntent(pendingIntent)
                .setVibrate(vibrate)
                .build();


        nm.notify(notificationID, notif);
    }

}
