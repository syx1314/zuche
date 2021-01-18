package com.zql.app.shop.adapter;

import android.support.v7.widget.RecyclerView;

import com.andview.refreshview.recyclerview.BaseRecyclerAdapter;
import com.zql.app.lib.util.ListUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * XRefreshview的Recycler的适配器基类
 * Created by huangzhe on 2017/4/24.
 */

public abstract class XRefreshviewRecyclerAdapter<T, VH extends RecyclerView.ViewHolder> extends BaseRecyclerAdapter<VH> {
    protected List<T> list;

    public XRefreshviewRecyclerAdapter() {
        this.list = new ArrayList<>();
    }

    public void setDatas(List<T> list) {
        if (list != null && !list.isEmpty()) {
            for (T obj : list) {
                insert(this.list, obj, getAdapterItemCount());
            }
            notifyDataSetChanged();
        }
    }

    @Override
    public int getAdapterItemCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public List<T> getList() {
        return list;
    }

    public void remove(int position) {
        remove(list, position);
    }

    public void clear() {
        if (ListUtil.isNotEmpty(list)) {
            clear(list);
        }
    }

    public void refresh() {
        notifyDataSetChanged();
    }
}
