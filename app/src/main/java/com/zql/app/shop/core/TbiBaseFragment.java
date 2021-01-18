package com.zql.app.shop.core;

import com.zql.app.lib.view.BaseAppFragment;

/**
 * 电商碎片基类
 * Created by huangzhe on 2017/4/30.
 */

public abstract class TbiBaseFragment extends BaseAppFragment {
    /**
     * 得到Activity
     *
     * @return
     */
    public TbiAppActivity getTbiAppActivity() {
        return (TbiAppActivity) getActivity();
    }

    /**
     * 激活显示
     */
    @Override
    public void onActivate() {
        //默认实现 子类根据实际情况判断是否需要该事件
    }
}
