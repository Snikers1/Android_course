package com.example.message_sendler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.util.Log;
import android.net.Uri;
import android.widget.Button;
import android.widget.TextView;


public class Mesage_Receiver extends AppCompatActivity {

    public static final String MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesage__receiver);
        Intent intent = getIntent();
        Button send_message = (Button)findViewById(R.id.sendEmail);
        String message = intent.getStringExtra(MESSAGE);
        TextView messageView = (TextView)findViewById(R.id.preview_text);
        messageView.setText(message);
        send_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });
    }

    public void sendMail()
    {
        String[] TO = {"bessonoff97@mail.ru", "meloch1997@mail.ru"};
        String SUBJECT = "Homework 1";
        Intent intent = getIntent();
        String SEND_MESSAGE = intent.getStringExtra(MESSAGE);
        Intent email_intent = new Intent(Intent.ACTION_SENDTO);
        email_intent.setData(Uri.parse("mailto:"));
        email_intent.putExtra(Intent.EXTRA_TEXT, SEND_MESSAGE);
        email_intent.putExtra(Intent.EXTRA_EMAIL, TO);
        email_intent.putExtra(Intent.EXTRA_SUBJECT, SUBJECT);

        if (email_intent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(email_intent, "Message sending"));
        }
        else {
            Log.d("Intent", "No activity on the device (email app) that can handle my intent");
        }
    }
}
