package com.education.glidetest;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by zhonghang on 2016/10/18.
 */

public class ImageHelper {
    public static void showImage(Context context, String url, ImageView imageView){
        Glide.with(context).load(url).into(imageView);
    }
}
