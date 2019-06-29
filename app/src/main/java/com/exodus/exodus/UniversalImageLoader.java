package com.exodus.exodus;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

public class UniversalImageLoader {

    private static final int defaultImage = R.drawable.error_ic;
    private Context mContext;

    public UniversalImageLoader(Context mContext) {
        this.mContext = mContext;
    }

    public ImageLoaderConfiguration getConfig(){
        DisplayImageOptions defaultOption = new DisplayImageOptions.Builder()
                .showImageForEmptyUri(defaultImage)
                .showImageOnFail(defaultImage).cacheOnDisk(true).resetViewBeforeLoading(true)
                .imageScaleType(ImageScaleType.EXACTLY).displayer(new FadeInBitmapDisplayer(30)).build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(mContext)
                .defaultDisplayImageOptions(defaultOption).diskCacheSize(100 * 1024 * 1024).build();

        return config;
    }

    public void setImage(String imgURL , ImageView image){
        ImageLoader loader = ImageLoader.getInstance();

        loader.displayImage(imgURL,image);
    }
}
