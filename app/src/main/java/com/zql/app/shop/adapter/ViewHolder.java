package com.zql.app.shop.adapter;


import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.zql.app.lib.BaseApplication;
import com.zql.app.lib.util.Validator;
import com.zql.app.lib.util.ui.DisplayUtil;
import com.zql.app.lib.util.ui.ImageLoader;
import com.zql.app.shop.R;
import com.zql.app.shop.TbiApplication;



/**
 * Created by yyj on 2017/12/29.
 */

public class ViewHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> mViews;
    private View mConvertView;

    public ViewHolder(View itemView) {
        super(itemView);
        mConvertView = itemView;
        mViews = new SparseArray<View>();
    }

    public ViewHolder setText(int viewId, String text) {
        TextView tv = getView(viewId);
        if(tv==null){
            return this;
        }
        if (tv != null && Validator.isNotEmpty(text)) {
            tv.setText(text);
        } else {
            tv.setText("");
        }
        return this;
    }
    public ViewHolder setTextResid(int viewId, int resid) {
        TextView tv = getView(viewId);
        if(tv==null){
            return this;
        }
        if (tv != null) {
            tv.setText(resid);
        } else {
            tv.setText("");
        }
        return this;
    }
    public ViewHolder setRating(int viewId, float rat) {
        RatingBar ratingBar = getView(viewId);
        if (ratingBar != null ) {
    ratingBar.setRating(rat);
        }
        return this;
    }
  public ViewHolder setTextHint(int viewId, String text) {
        TextView tv = getView(viewId);
      if(tv==null){
          return this;
      }
        if (tv != null && Validator.isNotEmpty(text)) {
            tv.setHint(text);
        } else {
            tv.setText("");
        }
        return this;
    }

    public ViewHolder setTextHtml(int viewId, String text) {
        TextView tv = getView(viewId);
        if(tv==null){
            return this;
        }
        if (tv != null && Validator.isNotEmpty(text)) {
            tv.setText(Html.fromHtml(text));
        }
        return this;
    }

    public ViewHolder setImageResource(int viewId, int resId) {
        ImageView view = getView(viewId);
        if(view==null){
            return this;
        }
        if (view != null) {
            view.setImageResource(resId);
        }
        return this;
    }

    public ViewHolder setImageBitmap(int viewId, Bitmap bitmap) {
        ImageView view = getView(viewId);
        if (view != null) {
            view.setImageBitmap(bitmap);
        }
        return this;
    }

    public ViewHolder setBackgroundResource(int viewId, int resId) {
        View view = getView(viewId);
        if (view != null) {
            view.setBackgroundResource(resId);
        }
        return this;
    }
    public ViewHolder setBackgroundColor(int viewId, int colorId) {
        View view = getView(viewId);
        if (view != null) {
            view.setBackgroundColor(colorId);
        }
        return this;
    }
    public ViewHolder setImage(int viewId, String url) {
        ImageView view = getView(viewId);

        if (view != null) {
            ImageLoader.loadNoCache(TbiApplication.mContext,url,view,R.mipmap.ic_no_img);
        }
        return this;
    }
    public ViewHolder setImageRadius(int viewId, String url) {
        ImageView view = getView(viewId);

        if (view != null) {
            ImageLoader.loadRound(TbiApplication.mContext,url,view,R.mipmap.ic_no_img);
        }
        return this;
    }
    public ViewHolder setImageXy(int viewId, String url) {
        ImageView view = getView(viewId);
        if (view != null) {
            ImageLoader.loadDefaultCacheXy(TbiApplication.mContext,url,view,R.mipmap.ic_no_img);
        }
        return this;
    }

    public ViewHolder setOnClickListener(int viewId,
                                         View.OnClickListener listener) {
        View view = getView(viewId);
        if(listener!=null) {
            view.setOnClickListener(listener);
        }
        return this;
    }

    public ViewHolder setTextWatcher(int viewId, TextWatcher watcher) {
        EditText view = getView(viewId);
        view.addTextChangedListener(watcher);
        return this;
    }

    public ViewHolder setBackground(int viewId, int resId) {
        View view = getView(viewId);
        view.setBackgroundResource(resId);

        return this;
    }

    public ViewHolder setTextColor(int viewId, int resId) {
        TextView view = getView(viewId);
        view.setTextColor(resId);

        return this;
    }

    public ViewHolder setTextLeftDrawable(int viewId, Drawable drawable) {
        TextView view = getView(viewId);
        //在左側加入图片
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        view.setCompoundDrawables(drawable, null, null, null);
        view.setCompoundDrawablePadding(4);//设置图片和text之间的间距
//        view.setPadding(-5, 0, 0, 0);
        return this;
    }

    public ViewHolder setTextLeftDrawable(int viewId, Drawable drawable, int leftPadding) {
        TextView view = getView(viewId);
        //在左側加入图片
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        view.setCompoundDrawables(drawable, null, null, null);
        view.setCompoundDrawablePadding(DisplayUtil.dipToPx(BaseApplication.mContext, leftPadding));//设置图片和text之间的间距
//        view.setPadding(-5, 0, 0, 0);
        return this;
    }

    public ViewHolder setTextRightDrawable(int viewId, Drawable drawable) {
        if (drawable == null) {
            return this;
        }
        TextView view = getView(viewId);
        //在左側加入图片
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        view.setCompoundDrawables(null, null, drawable, null);
        view.setCompoundDrawablePadding(DisplayUtil.dipToPx(BaseApplication.mContext, 5));//设置图片和text之间的间距
//        view.setPadding(0, 0, DisplayUtil.dipToPx(BaseApplication.mContext,10), 0);
        return this;
    }

    public ViewHolder setTextRightDrawable1(int viewId, Drawable drawable) {
        if (drawable == null) {
            return this;
        }
        TextView view = getView(viewId);
        //在左側加入图片
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        view.setCompoundDrawables(null, null, drawable, null);
        view.setCompoundDrawablePadding(DisplayUtil.dipToPx(BaseApplication.mContext, 10));//设置图片和text之间的间距
//        view.setPadding(0, 0, DisplayUtil.dipToPx(BaseApplication.mContext,10), 0);
        return this;
    }


    public ViewHolder setVisable(int viewId, int visibility) {
        View view = getView(viewId);
        if(view!=null) {
            view.setVisibility(visibility);
        }
        return this;
    }


    /**
     * 通过viewId获取控件
     *
     * @param viewId
     * @return
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public TextView getTextView(int viewId) {
        TextView view = (TextView) mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
        }
        return view;
    }
    public ImageView getImageView(int viewId) {
        ImageView view = (ImageView) mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
        }
        return view;
    }
    public LinearLayout getLinearLayout(int viewId) {
        LinearLayout view = (LinearLayout) mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
        }
        return view;
    }
}
