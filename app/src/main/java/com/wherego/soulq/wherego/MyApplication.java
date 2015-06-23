package com.wherego.soulq.wherego;

import android.app.Application;

import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import java.util.LinkedList;

public class MyApplication extends Application {


    LinkedList<Places> place_items;
    LinkedList<Comments> comments_items;

    public MyApplication() {
        place_items = new LinkedList<>();
        comments_items = new LinkedList<>();
    }

    public LinkedList<Places> getPlacesList() {
        return place_items;
    }
    public LinkedList<Comments> getCommentsList() {
        return comments_items;
    }

    public void addItem(Places place) {
        place_items.add(place);
    }
    public void addItem(Comments comment) {
        comments_items.add(comment);
    }

    public void onCreate() {
        super.onCreate();

        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheOnDisc(true)
                .cacheInMemory(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(300))
                .showStubImage(R.drawable.empty_photo)
                .showImageForEmptyUri(R.drawable.empty_photo)
                .showImageOnFail(R.drawable.empty_photo)
                .build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                getApplicationContext())
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new WeakMemoryCache())
                .discCacheSize(100 * 1024 * 1024).build();

        ImageLoader.getInstance().init(config);
    }
}
