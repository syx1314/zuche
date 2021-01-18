package com.zql.app.lib.util.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

/**
 * Created by Administrator on 2019/1/7 0007.
 */

public class ImageLoader {
    public  static void load(Context context, String path, ImageView imageView,int placeHolder){
            Glide.with(context).load(path).placeholder(placeHolder).error(placeHolder).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(imageView);

    }
    public  static void loadRound(Context context, String path, ImageView imageView,int placeHolder){
        Glide.with(context).load(path).placeholder(placeHolder).error(placeHolder).diskCacheStrategy(DiskCacheStrategy.SOURCE).transform(new BitmapTransformation(context) {
            @Override
            protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
                return roundCrop(pool, toTransform);
            }

            @Override
            public String getId() {
                float radius = Resources.getSystem().getDisplayMetrics().density * 4;
                return getClass().getName() + Math.round(radius);
            }
        }).into(imageView);

    }
    public  static void loadDefaultCache(Context context, String path, ImageView imageView,int placeHolder){
            Glide.with(context).load(path).placeholder(placeHolder).error(placeHolder).into(imageView);
    }

    public  static void loadDefaultCacheXy(Context context, String path, ImageView imageView,int placeHolder){
        Glide.with(context).load(path).placeholder(placeHolder).centerCrop().error(placeHolder).into(imageView);
    }
    public  static void load(Context context, String path, ImageView imageView){
        Glide.with(context).load(path).into(imageView);
    }
    public  static void loadNoCache(Context context, String path, ImageView imageView,int placeHolder){
        Glide.with(context).load(path).placeholder(placeHolder).into(imageView);
    }
    public static void loadWh(Context context, String path, final ImageView imageView){
        Glide.with(context).load(path).asBitmap().into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap bitmap, GlideAnimation<? super Bitmap> glideAnimation) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int h= (imageView.getWidth() * Integer.valueOf(height))/Integer.valueOf( width);
                imageView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,h));
                imageView.setImageBitmap(bitmap);
            }
        });

    }

    public  static void loadGif(Context context, int  resId, ImageView imageView){
        Glide.with(context).load(resId).asGif().diskCacheStrategy(DiskCacheStrategy.NONE).into(imageView);
    }
    private static Bitmap roundCrop(BitmapPool pool, Bitmap source) {
        if (source == null) return null;

        Bitmap result = pool.get(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
        if (result == null) {
            result = Bitmap.createBitmap(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
        }
        float radius = Resources.getSystem().getDisplayMetrics().density * 4;
        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        paint.setShader(new BitmapShader(source, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
        paint.setAntiAlias(true);
        RectF rectF = new RectF(0f, 0f, source.getWidth(), source.getHeight());
        canvas.drawRoundRect(rectF, radius, radius, paint);
        return result;
    }



}
