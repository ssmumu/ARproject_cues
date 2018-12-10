package com.example.samiha.glassapp4;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.Button;


public class CameraActivity extends AppCompatActivity {

   Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);


 //       Intent i=new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
 //       startActivity(i);

//        btn=(Button)findViewById(R.id.button6);
//        btn.setOnClickListener(new OnClickListener() {
//
//            public void onClick(View v) {
//
//
//            }
//        });
//
//        Intent intent = new Intent(this, CameraActivity_2.class);
//        startActivity(intent);


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
