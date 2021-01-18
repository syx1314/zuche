package com.zql.app.shop.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.zql.app.lib.BaseApplication;
import com.zql.app.lib.util.ListUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Recycler通用适配器
 * Created by huangzhe on 2017/4/19.
 */

public abstract class EasyRecyclerViewAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    protected static final int TYPE_HEAD = 0;
    protected static final int TYPE_BODY = 1;
    protected static final int TYPE_FOOT = 2;
    protected static final int TYPE_EMPTY = 3;

    private int curStatus = 1;//当前状态

    protected View mHeaderView;
    protected View mFooterView;

    //empty
    private FrameLayout mEmptyLayout;
    private boolean mHeadAndEmptyEnable;

    protected Context context;//当前界面

    private List<T> mDatas = null;//数据集

    private OnItemClickListener mItemClickListener;

    private OnItemLongClickListener mItemLongClickListener;

    public EasyRecyclerViewAdapter() {
        this.context = BaseApplication.mContext;
        this.mDatas = new ArrayList<>();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mItemClickListener = listener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener listener) {
        mItemLongClickListener = listener;
    }

    public void setHeaderView(View headerView) {
        mHeaderView = headerView;
        notifyItemInserted(0);
    }

    public void setFooterView(View footerView) {
        mFooterView = footerView;
        //  notifyItemInserted(getFooterPosition());
        notifyDataSetChanged();
    }

    public void setDatas(List<T> mDatas) {
        this.mDatas = mDatas;
        notifyDataSetChanged();
    }


    public EasyRecyclerViewAdapter(List<T> mDatas) {
        this.context = BaseApplication.mContext;
        this.mDatas = mDatas;
    }

    @Override
    public int getItemViewType(int position) {
        if (mHeaderView != null && position == 0) {
            return TYPE_HEAD;
        }
        if (mFooterView != null && mHeaderView == null) {
            if (ListUtil.isEmpty(mDatas) && position == 0) {
                return TYPE_EMPTY;
            } else if (mDatas != null && position == mDatas.size()) {
                return TYPE_FOOT;
            }
        }
        if (mFooterView != null && mHeaderView != null) {
            if (ListUtil.isEmpty(mDatas)) {
                if (mEmptyLayout == null) {
                    return TYPE_FOOT;
                } else {
                    return TYPE_EMPTY;
                }
            } else if (mDatas != null && position == mDatas.size() + 1) {
                return TYPE_FOOT;
            }
        }
        if (getEmptyViewCount() == 1) {
            if (mHeaderView != null && position == 1) {
                return TYPE_EMPTY;
            } else if (position == 0) {
                return TYPE_EMPTY;
            }
        } else {
            if (mFooterView == null && mHeaderView == null) {
                return TYPE_BODY;
            }
        }
        return TYPE_BODY;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEAD) {
            return new EasyViewHolder(mHeaderView);
        }
        if (viewType == TYPE_FOOT) {
            return new EasyViewHolder(mFooterView);
        }
        if (viewType == TYPE_EMPTY) {
            return new EasyViewHolder(mEmptyLayout);
        }
        return onCreate(parent, viewType);//获取资源文件
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_HEAD || getItemViewType(position) == TYPE_FOOT || getItemViewType(position) == TYPE_EMPTY) {
            return;
        }
        if (ListUtil.isEmpty(mDatas)) {
            return;
        }

        final int dataPosition = getDataPosition(holder);
        final T data = mDatas.get(dataPosition);
        onBind(holder, dataPosition, data);

        if (mItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mItemClickListener.OnItemClick(v, dataPosition, data);
                }
            });
        }

        if (mItemLongClickListener != null) {
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mItemLongClickListener.OnItemLongClick(v, dataPosition, data);
                    return true;
                }
            });
        }

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        final RecyclerView.LayoutManager layoutParams = recyclerView.getLayoutManager();
        if (layoutParams instanceof GridLayoutManager) {
            ((GridLayoutManager) layoutParams).setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    int type = getItemViewType(position);
                    if (type == TYPE_HEAD || type == TYPE_FOOT)
                        return ((GridLayoutManager) layoutParams).getSpanCount();
                    return 1;
                }
            });
        }

    }

    @Override
    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            StaggeredGridLayoutManager.LayoutParams params = (StaggeredGridLayoutManager.LayoutParams) layoutParams;
            if (mHeaderView != null && holder.getLayoutPosition() == 0) {
                params.setFullSpan(true);
            } else if (mFooterView != null && holder.getLayoutPosition() == getFooterPosition()) {
                params.setFullSpan(true);
            } else {
                params.setFullSpan(false);
            }

        }


    }

    public int getDataPosition(RecyclerView.ViewHolder holder) {
        int position = holder.getLayoutPosition();
        return mHeaderView == null ? position : position - 1;
    }

    private int getFooterPosition() {
        if (mFooterView == null) {
            return -1;
        }
        if (mHeaderView == null) {
            return mDatas.size();
        }
        if (mHeaderView != null) {
            return mDatas.size() + 1;
        }
        return -1;
    }

    @Override
    public int getItemCount() {
        if (mFooterView != null && mHeaderView != null) {
            if (getEmptyViewCount() == 1) {
                return 3;
            } else {
                return mDatas.size() + 2;
            }
        } else if (mFooterView != null || mHeaderView != null) {
            if (getEmptyViewCount() == 1) {
                return 2;
            } else {
                return mDatas.size() + 1;
            }
        }
        if (getEmptyViewCount() == 1) {
            return 1;
        } else {
            if (mDatas != null) {
                return mDatas.size();
            } else {
                return 0;
            }
        }
    }

    public abstract RecyclerView.ViewHolder onCreate(ViewGroup parent, final int viewType);

    public abstract void onBind(RecyclerView.ViewHolder viewHolder, int RealPosition, T data);

    public class EasyViewHolder extends RecyclerView.ViewHolder {

        public EasyViewHolder(View itemView) {
            super(itemView);
        }
    }

    public interface OnItemClickListener<T> {
        void OnItemClick(View view, int position, T data);
    }

    public interface OnItemLongClickListener<T> {
        void OnItemLongClick(View view, int position, T data);
    }

    public List<T> getmDatas() {
        return mDatas;
    }

    /**
     * 加入新元素
     *
     * @param data
     */
    public void addData(T data) {
        mDatas.add(data);
        notifyItemInserted(mDatas.size());
    }

    /**
     * 删除元素
     *
     * @param postion
     */
    public void removeData(int postion) {
        if (postion < mDatas.size()) {
            int count = mDatas.size();
            mDatas.remove(postion);
            notifyItemRemoved(postion);
            notifyItemRangeChanged(postion, count);
        }
    }

    /**
     * 设置空视图
     *
     * @param layoutResId
     * @param viewGroup
     */
    public void setEmptyView(int layoutResId, ViewGroup viewGroup) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(layoutResId, viewGroup, false);
        setEmptyView(view);
    }

    public void setEmptyView(View emptyView) {
        boolean insert = false;
        if (mEmptyLayout == null) {
            mEmptyLayout = new FrameLayout(emptyView.getContext());
            final LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
            final ViewGroup.LayoutParams lp = emptyView.getLayoutParams();
            if (lp != null) {
                layoutParams.width = lp.width;
                layoutParams.height = lp.height;
            }
            mEmptyLayout.setLayoutParams(layoutParams);
            insert = true;
        }
        mEmptyLayout.removeAllViews();
        mEmptyLayout.addView(emptyView);
        if (insert) {
            if (getEmptyViewCount() == 1) {
                int position = 0;
                if (mHeaderView != null) {
                    position++;
                }
                notifyItemInserted(position);
            }
        }
    }


    public int getEmptyViewCount() {
        if (mEmptyLayout == null || mEmptyLayout.getChildCount() == 0) {
            return 0;
        }
        if (mDatas.size() != 0) {
            return 0;
        }
        return 1;
    }

    public FrameLayout getmEmptyLayout() {
        return mEmptyLayout;
    }
}
