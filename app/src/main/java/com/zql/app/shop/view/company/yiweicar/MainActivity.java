package com.zql.app.shop.view.company.yiweicar;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.zql.app.lib.view.BaseAppFragment;
import com.zql.app.shop.R;
import com.zql.app.shop.adapter.FragmentViewPageAdapter;
import com.zql.app.shop.core.MyActivity;
import com.zql.app.shop.service.impl.YiweiServiceImpl;
import com.zql.app.shop.util.IntentUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends MyActivity<YiweiServiceImpl> {


    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {
        super.initData();
        tablayout.addTab(tablayout.newTab().setText("进行中"));
        tablayout.addTab(tablayout.newTab().setText("附近"));

        String[] titleList = {"进行中", "附近"};

        List<BaseAppFragment> fragmentList = new ArrayList<>();
        fragmentList.add(new OrderProgressFragment());
        fragmentList.add(new FuJInFragment());
        viewPager.setAdapter(new FragmentViewPageAdapter(getSupportFragmentManager(), titleList, fragmentList));
        tablayout.setupWithViewPager(viewPager);


    }



    @OnClick(R.id.tv_login)
    public void onViewClicked() {
        IntentUtil.get().goActivity(ctx,LoginActivity.class);
    }
}
