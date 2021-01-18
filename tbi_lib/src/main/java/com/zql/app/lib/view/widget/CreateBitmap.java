package com.zql.app.lib.view.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.AsyncTask;
import android.widget.ImageView;

import com.zql.app.lib.core.CommonCallback;
import com.zql.app.lib.util.sys.LogMe;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 加载网络图片
 * Created by huangzhe on 2017/2/7.
 */

public class CreateBitmap extends AsyncTask<String,Void,Bitmap>{
    private ImageView imageView;
    private CommonCallback<Boolean> callback;
    private File saveFile;//保存本地文件

    public CreateBitmap(ImageView imageView,File saveFile,CommonCallback<Boolean> callback) {
        this.imageView = imageView;
        this.callback=callback;
        this.saveFile=saveFile;
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        try {
            URL picUrl = new URL(strings[0]);
            HttpURLConnection conn = (HttpURLConnection) picUrl.openConnection();
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(5000);
            conn.setRequestMethod("GET");
            conn.connect();//开始连接
            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                InputStream is = conn.getInputStream();
//                if(saveFile!=null){
//                    FileOutputStream fos=new FileOutputStream(saveFile);
//                    byte[] buffer=new byte[1024];
//                    int len=0;
//                    while((len=is.read(buffer))!=-1){
//                        fos.write(buffer,0,len);
//                    }
//                    fos.close();
//                }
                Bitmap bitmap = BitmapFactory.decodeStream(picUrl.openStream());
                Bitmap saveMap= getRoundedCornerBitmap(bitmap);
                try{
                    FileOutputStream out=new FileOutputStream(saveFile);
//                    saveMap.compress(Bitmap.CompressFormat.JPEG,90,out);

                    byte[] byteArray = new byte[1024];
                    int len = 0;
                    while ((len = is.read(byteArray)) != -1) {
                        out.write(byteArray, 0, len);
                    }
                    out.flush();
                    out.close();
                    is.close();
                }catch (Exception ex){
                    LogMe.e(ex.getMessage(),ex);
                }
                return saveMap;
            }
        }catch(Exception ex){
            LogMe.e(ex.getMessage(),ex);
        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        if(bitmap!=null) {
            super.onPostExecute(bitmap);
            imageView.setImageBitmap(bitmap);
            callback.onCallBack(true);
        }else{
            callback.onCallBack(false);
        }
    }
    //绘制图片
    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);
        final float roundPx = 12;

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(Color.WHITE);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
        canvas.drawRoundRect(rectF,10,10,paint);
        return output;
    }
}
