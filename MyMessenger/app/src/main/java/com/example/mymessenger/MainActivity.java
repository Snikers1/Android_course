package com.example.mymessenger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickSendMessage(View view){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Messenger Application");
        EditText user_text = (EditText)findViewById(R.id.create_message);
        String message = user_text.getText().toString();
        intent.putExtra(Intent.EXTRA_TEXT, message);
        startActivity(intent);
    }
}
