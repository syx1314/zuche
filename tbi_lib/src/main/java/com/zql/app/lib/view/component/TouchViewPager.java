package com.zql.app.lib.view.component;

import android.content.Context;
import android.support.annotation.Px;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

/**
 * 可控制是否滚动的ViewPager
 * Created by huangzhe on 2017/4/21.
 */

public class TouchViewPager extends ViewPager {
    private boolean scrollble=true;
    public TouchViewPager(Context context) {
        super(context);
    }

    public TouchViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void scrollTo(@Px int x, @Px int y) {
        if(scrollble) {
            super.scrollTo(x, y);
        }
    }


    public boolean isScrollble() {
        return scrollble;
    }

    public void setScrollble(boolean scrollble) {
        this.scrollble = scrollble;
    }
}
