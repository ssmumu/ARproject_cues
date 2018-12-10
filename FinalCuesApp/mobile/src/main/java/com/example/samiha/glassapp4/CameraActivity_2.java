package com.example.samiha.glassapp4;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.security.acl.Group;


public class CameraActivity_2 extends AppCompatActivity {

    TextView bgv;
    ImageView imgv;
    TextView feedv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_2);
        bgv = (TextView) findViewById(R.id.textView8);
        imgv = (ImageView) findViewById(R.id.imageView7);
        feedv = (TextView) findViewById(R.id.textView7);

        //ObjectAnimator animatorX = ObjectAnimator.
        Animation animation1 = AnimationUtils.loadAnimation(CameraActivity_2.this, R.anim.righttoleft);
        bgv.startAnimation(animation1);
        Animation animation2 = AnimationUtils.loadAnimation(CameraActivity_2.this, R.anim.righttoleft2);
        imgv.startAnimation(animation2);
        Animation animation3 = AnimationUtils.loadAnimation(CameraActivity_2.this, R.anim.righttoleft3);
        feedv.startAnimation(animation3);

    }

}
