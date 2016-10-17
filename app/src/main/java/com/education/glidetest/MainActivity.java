package com.education.glidetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    private ImageView mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImage = (ImageView) findViewById(R.id.imageview);
        String path = "http://image.haha.mx/2014/02/02/middle/1115779_c221d1fc47b97bb1605cddc9c8aec0a7_1391347675.gif";
        Glide.with(MainActivity.this).load(path).into(mImage);
    }
}
