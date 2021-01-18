package com.zql.app.shop.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.zql.app.lib.util.ListUtil;

import java.util.List;

/**
 * Created by yyj on 2017/12/29.
 */

public class BaseRecycleViewAdapter<T> extends RecyclerView.Adapter<ViewHolder> {

    public List<T> mdatas;
    private int resLayoutId;
    protected OnItemClickListener onItemClickListener;
    protected OnItemLongClickListener onItemLongClickListener;
    private int width, height;
    protected String flag;
    protected int selPosition = 0;//默认选择的项

    protected Context context;

    public void setSelPosition(int selPosition) {
        this.selPosition = selPosition;
        notifyDataSetChanged();
    }

    public BaseRecycleViewAdapter setDefaultSelPosition() {
        this.selPosition = -1;
        return this;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }

    public void setItemSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public BaseRecycleViewAdapter(List<T> mdatas, @LayoutRes int resLayoutId) {
        this.mdatas = mdatas;
        this.resLayoutId = resLayoutId;
    }

    public BaseRecycleViewAdapter(List<T> mdatas, @LayoutRes int resLayoutId, String flag) {
        this.mdatas = mdatas;
        this.resLayoutId = resLayoutId;
        this.flag = flag;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (parent.getContext() != null) {
            context = parent.getContext();
            View inflate = LayoutInflater.from(parent.getContext()).inflate(resLayoutId, parent, false);
            if (width != 0 || height != 0) {
                inflate.setLayoutParams(new ViewGroup.LayoutParams(width, height));
            }
            return new ViewHolder(inflate);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        if (holder == null) {
            return;
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null) {
                    onItemClickListener.onClick(position);
                }
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                if(onItemLongClickListener!=null){
                    onItemLongClickListener.onClick(position);
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mdatas != null ? mdatas.size() : 0;
    }

    /**
     * 加入新元素
     *
     * @param data
     */
    public void addData(T data) {
        mdatas.add(data);
        notifyItemInserted(mdatas.size());
    }

    /**
     * 加入新元素
     *
     * @param data
     */
    public void addData(List<T> data) {
        mdatas.addAll(data);
        notifyItemInserted(mdatas.size());
    }
    public void  removeData(int position){
        mdatas.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,mdatas.size());

    }

    /**
     * 清楚数据
     */
    public void clear() {
        if(ListUtil.isNotEmpty(mdatas)) {
            mdatas.clear();
        }
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void onClick(int position);
    }
    public interface OnItemLongClickListener {
        void onClick(int position);
    }

}
