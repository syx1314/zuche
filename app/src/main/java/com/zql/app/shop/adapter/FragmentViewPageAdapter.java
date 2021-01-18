package com.zql.app.shop.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.zql.app.lib.view.BaseAppFragment;

import java.util.List;

/**
 * ViewPage加载Fragment
 * Created by huangzhe on 2017/4/19.
 */

public class FragmentViewPageAdapter extends FragmentStatePagerAdapter {
    private String[] tags;
    private List<BaseAppFragment> fragments;

    public FragmentViewPageAdapter(FragmentManager fm, String[] tags, List<BaseAppFragment> fragments) {
        super(fm);
        this.tags = tags;
        this.fragments = fragments;
    }

    public FragmentViewPageAdapter(FragmentManager fm, List<BaseAppFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (tags != null) {
            return tags[position];
        } else {
            return super.getPageTitle(position);
        }
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
