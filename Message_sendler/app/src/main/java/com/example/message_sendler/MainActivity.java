package com.example.message_sendler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onPreviewMessage(View view)
    {
        Intent intent = new Intent(this, Mesage_Receiver.class);
        EditText Text_message = (EditText)findViewById(R.id.message); // get text from EditText
        String message_text = String.valueOf(Text_message.getText());// get text from EditText
        intent.putExtra(Mesage_Receiver.MESSAGE, message_text);
        startActivity(intent);
    }
}
