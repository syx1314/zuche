package com.zql.app.shop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zql.app.lib.util.DateUtil;
import com.zql.app.lib.util.Validator;
import com.zql.app.shop.R;
import com.zql.app.shop.entity.yiwei.YiweiCar;
import com.zql.app.shop.entity.yiwei.YiweiPasserInfo;

import java.util.Date;
import java.util.List;

public class YiWeiCarAdapter extends XRefreshviewRecyclerAdapter<YiweiCar, ViewHolder> {


    private Context context;
    private CallbackListener callbackListener;
    private boolean isShowTitle=true;//是否显示头

    public void setCallbackListener(CallbackListener callbackListener) {
        this.callbackListener = callbackListener;
    }

    public void setShowTitle(boolean showTitle) {
        isShowTitle = showTitle;
    }

    @Override
    public ViewHolder getViewHolder(View view) {
        return new ViewHolder(view);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType, boolean isItem) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_yiwei_car, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position, boolean isItem) {

        final YiweiCar yiweiCar = list.get(position);

        if (yiweiCar != null) {
            YiweiPasserInfo passerInfo = yiweiCar.getPasserInfo();
            if (isShowTitle) {
                if (Validator.isNotEmpty(yiweiCar.getMinPrice()) && Validator.isNotEmpty(yiweiCar.getMaxPrice())) {
                    holder.setText(R.id.tv_order_sort, "拼座车主竞价");
                } else {
                    holder.setText(R.id.tv_order_sort, "拼座系统定价");
                }
                if (Validator.isNotEmpty(yiweiCar.getOrderInSeats())) {
                    holder.setText(R.id.tv_person, yiweiCar.getOrderInSeats() + "人·");
                } else {
                    holder.setText(R.id.tv_person, "");
                }
                if (passerInfo != null) {
                    holder.setText(R.id.tv_passager_name, "·" + passerInfo.getPasserName());
                } else {
                    holder.setText(R.id.tv_passager_name, "");

                }
            }else {
                holder.setVisable(R.id.lin_title,View.GONE);
                holder.setVisable(R.id.view_divider,View.GONE);
            }
            holder.setText(R.id.tv_time, DateUtil.date2Str(new Date(Long.valueOf(yiweiCar.getLeaveOnTime())), "yyyy-MM-dd HH:mm"));
            holder.setText(R.id.tv_start_city_addr, yiweiCar.getStartPoint());
            holder.setText(R.id.tv_end_city_addr, yiweiCar.getEndPoint());
            holder.setText(R.id.tv_create_time, "创建:" + DateUtil.date2Str(new Date(Long.valueOf(yiweiCar.getOrderCreateTime())), "yyyy-MM-dd HH:mm"));

            if (Validator.isNotEmpty(yiweiCar.getMinPrice()) && Validator.isNotEmpty(yiweiCar.getMaxPrice())) {

                holder.setText(R.id.tv_price, context.getString(R.string.money_unit) + yiweiCar.getMinPrice() + "-" + context.getString(R.string.money_unit) + yiweiCar.getMaxPrice());
            } else {
                if (Validator.isNotEmpty(yiweiCar.getOrderAccount())) {
                    holder.setText(R.id.tv_price, context.getString(R.string.money_unit) + yiweiCar.getOrderAccount());
                } else {
                    holder.setText(R.id.tv_price, "");
                }
            }
            holder.setText(R.id.tv_distance, yiweiCar.getTotalDistance() + "KM");
            holder.setText(R.id.tv_leave_words, yiweiCar.getLeaveWords());
            holder.getView(R.id.tv_leave_words).setSelected(true);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (callbackListener != null) {
                        callbackListener.itemOnClick(yiweiCar);
                    }
                }
            });
            holder.setOnClickListener(R.id.tv_phone, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (callbackListener != null) {
                        callbackListener.phone(yiweiCar.getPasserId());
                    }
                }
            });
        }
    }

    public interface CallbackListener {
        void phone(String pid);

        void itemOnClick(YiweiCar yiweiCar);
    }
}
