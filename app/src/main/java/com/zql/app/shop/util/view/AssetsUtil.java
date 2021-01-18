package com.zql.app.shop.util.view;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.zql.app.lib.util.Validator;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by gaofeng on 2017/5/26.
 */

public class AssetsUtil {
    /**
     * 从Assets中读取图片
     */
    public static Bitmap getImageFromAssetsFile(Context ctx, String fileName) {

        Bitmap image = null;
        if(Validator.isNotEmpty(fileName)) {

            AssetManager am = ctx.getResources().getAssets();
            try {
                InputStream is = am.open("airlines/" + fileName + ".png");

                image = BitmapFactory.decodeStream(is);
                is.close();
            } catch (IOException e) {
                e.printStackTrace();

            }
        }
        return image;

    }

}
