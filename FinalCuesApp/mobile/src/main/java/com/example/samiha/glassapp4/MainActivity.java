package com.example.samiha.glassapp4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public final static String EXTRA_MESSAGE = "com.example.samiha.glassapp4.MESSAGE";
    public void sendMessage(View view) {
        Intent intent = new Intent(this, MyNoteActivity.class);
        startActivity(intent);
    }



}
