package com.education.glidetest;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

public class MainActivity extends AppCompatActivity {
    private ImageView mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImage = (ImageView) findViewById(R.id.imageview);
//        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/aa.mp4";
        String path = "http://ww3.sinaimg.cn/large/65e4f1e6jw1f7igwai9u3j21kw2t4hdt.jpg";
//        ImageView 的scaleType  fitXY center fitStart fitCenter fitEnd centerInside centerCrop matrix
//        ImageHelper.showImage();
        Glide.with(MainActivity.this)
                .load(path)
//                .asBitmap()
//                .toBytes()
                .thumbnail(0.1f)
                .error(R.drawable.leak_canary_icon)//设置加载失败的图片
                .placeholder(R.mipmap.ic_launcher)//设置占位图
                .centerCrop()//设置图片的拉伸方式为centerCrop
                .animate(R.anim.scale_image)//自定义动画
//                .crossFade()//淡入淡出动画
                .into(mImage);
        //转换成byte数组必须和asBitmap和toBytes一起调用
//                .into(new SimpleTarget<byte[]>(250, 250) {
//                    @Override
//                    public void onResourceReady(byte[] data, GlideAnimation anim) {
//                        // Post your bytes to a background thread and upload them here.
//                    }
//                });
    }
}
