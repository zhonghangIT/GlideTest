package com.education.glidetest;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.graphics.Palette;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.stream.BaseGlideUrlLoader;
import com.bumptech.glide.module.GlideModule;

import java.io.InputStream;

/**
 * Created by zhonghang on 2016/10/18.
 */

public class MyGlideMoudle implements GlideModule {
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        //设置Glide的配置
        builder.setDecodeFormat(DecodeFormat.PREFER_ARGB_8888);
        //设置Bitmap缓存池的大小
        builder.setBitmapPool(new LruBitmapPool(24 * 1024 * 1024));
        //设置磁盘缓存的位置大小
        builder.setDiskCache(new DiskLruCacheFactory("", 100 * 1024 * 1024));
    }

    @Override
    public void registerComponents(Context context, Glide glide) {
        glide.register(MyDataModel.class, InputStream.class,new MyUrlLoaderFactory());
    }


    public interface MyDataModel {
        public String buildUrl(int width, int height);
    }

    public class MyUrlLoaderFactory implements ModelLoaderFactory {
        @Override
        public ModelLoader build(Context context, GenericLoaderFactory factories) {
            return new MyUrlLoader(context);
        }
        @Override
        public void teardown() {

        }
    }
    public class MyUrlLoader extends BaseGlideUrlLoader<MyDataModel> {
        public MyUrlLoader(Context context) {
            super(context);
        }
        @Override
        protected String getUrl(MyDataModel model, int width, int height) {
            // Construct the url for the correct size here.
            return model.buildUrl(width, height);
        }
    }
}
