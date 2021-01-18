package com.zql.app.shop.util.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.zql.app.lib.util.ui.DisplayUtil;
import com.zql.app.shop.R;

import java.lang.reflect.Field;

/**
 * Created by huangzhe on 2018/1/25.
 */

public class TabDrawable extends Drawable {
    View view;
    Paint paint;


    public TabDrawable(View view, int color) {
        this.view = view;
        paint = new Paint();
        paint.setColor(color);
        paint.setAntiAlias(true);
        float density = view.getResources().getDisplayMetrics().density;
    }

    int getIntValue(String name) {
        try {
            Field f = view.getClass().getDeclaredField(name);
            f.setAccessible(true);
            Object obj = f.get(view);
            return (Integer) obj;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        int mIndicatorLeft = getIntValue("mIndicatorLeft");
        int mIndicatorRight = getIntValue("mIndicatorRight");
        int height = view.getHeight();
//        if (mIndicatorLeft >= 0 && mIndicatorRight > mIndicatorLeft) {
//            paint.setStyle(Paint.Style.FILL);
//            paint.setStrokeWidth(10f);
//            Path path = new Path();
//            path.moveTo(mIndicatorLeft, 10);
//            path.lineTo(mIndicatorRight-20, 10);
//            path.lineTo(mIndicatorRight, height);
//            path.lineTo(mIndicatorLeft, height);
//            path.close();
//            canvas.drawPath(path, paint);
//            float radii[] = {10, 10, 10, 10, 0, 0, 0, 0};
//            Path path2 = new Path();
//            path2.addRoundRect(new RectF(mIndicatorLeft, 0, mIndicatorRight, 15), radii, Path.Direction.CCW);
//            canvas.drawPath(path2, paint);
//        }
        Bitmap bmp= BitmapFactory.decodeResource(view.getResources(), R.mipmap.img_air_tab_bg_1);
//        canvas.drawBitmap(bmp,mIndicatorLeft,0,paint);

        canvas.drawBitmap(bmp,null,new RectF(mIndicatorLeft, 0, mIndicatorRight, height),paint);
    }

    @Override
    public void setAlpha(@IntRange(from = 0, to = 255) int alpha) {

    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.UNKNOWN;
    }
}
