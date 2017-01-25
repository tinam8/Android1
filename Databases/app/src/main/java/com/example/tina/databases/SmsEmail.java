package com.example.tina.databases;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;

public class SmsEmail extends AppCompatActivity {

    private int MY_PERM=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_email);


        //ask for permission
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.SEND_SMS}, MY_PERM);
    }

    public void onClick(View v) {
        sendSMS("5556", "Neki moj tekst koji saljem.");
    }




    public void onSMSIntentClick(View v) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) //for new versions
        {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + 5556));
            i.putExtra("sms_body", "Moj tekst koji saljem.");
            startActivity(i);

        }
        else // For early versions, do what worked before.
        {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setType("vnd.android-dir/mms-sms");
            i.putExtra("address", "5556");
            i.putExtra("sms_body","Moj tekst koji saljem.");
            startActivity(i);
        }



    }

    //sends an SMS message to another device
    private void sendSMS(String phoneNumber, String message)
    {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, null, null);
    }


    public void onClick2(View v) {
        String[] to =
                {"someguy@yourcompany.com",
                        "anotherguy@yourcompany.com"};
        String[] cc = {"busybody@yourcompany.com"};
        sendEmail(to, cc, "Hello", "Hello my friends!");
    }

    //sends message to another device-
    private void sendEmail(String[] emailAddresses, String[] carbonCopies,
                           String subject, String message)
    {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        String[] to = emailAddresses;
        String[] cc = carbonCopies;
        emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
        emailIntent.putExtra(Intent.EXTRA_CC, cc);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Email"));
    }

}
