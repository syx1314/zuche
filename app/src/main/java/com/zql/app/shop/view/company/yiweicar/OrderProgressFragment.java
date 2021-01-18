package com.zql.app.shop.view.company.yiweicar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;
import com.zql.app.lib.core.CommonCallback;
import com.zql.app.lib.util.ListUtil;
import com.zql.app.lib.util.Validator;
import com.zql.app.lib.util.sys.LogMe;
import com.zql.app.lib.util.ui.DialogUtil;
import com.zql.app.shop.R;
import com.zql.app.shop.adapter.YiWeiCarAdapter;
import com.zql.app.shop.core.MyActivity;
import com.zql.app.shop.core.MyBaseFragment;
import com.zql.app.shop.core.TbiAppActivity;
import com.zql.app.shop.entity.yiwei.LoginResponse;
import com.zql.app.shop.entity.yiwei.OrderRequest;
import com.zql.app.shop.entity.yiwei.YiweiCar;
import com.zql.app.shop.event.ApiResult;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class OrderProgressFragment extends MyBaseFragment {
    @BindView(R.id.rv_dingdan)
    RecyclerView rvDingdan;


    @Override
    public int getLayout() {
        return R.layout.fragment_order_progress;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        super.initView(view, savedInstanceState);

        OrderRequest request = new OrderRequest();
        List<String> orderTyleList = new ArrayList<>();
        orderTyleList.add("1");
        orderTyleList.add("2");
        orderTyleList.add("3");
        orderTyleList.add("4");
        orderTyleList.add("5");
        orderTyleList.add("7");
        orderTyleList.add("8");
        orderTyleList.add("9");
        orderTyleList.add("10");
        orderTyleList.add("11");
        orderTyleList.add("12");
        orderTyleList.add("13");
        request.setOrderTypeList(orderTyleList);
        String json = new Gson().toJson(request, OrderRequest.class);
        //json=json.replace("{","%7b").replace("}","%7d");
        LogMe.e(json);
        String encode = null;
        try {
            encode = URLEncoder.encode(json, "utf-8");
            encode = URLEncoder.encode(json, "utf-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String uid = "";
        if (login != null) {
            LoginResponse.LoginRes data = login.getData();
            if (data != null) {
                uid = data.getUserId();
            }
            if (Validator.isEmpty(uid)) {
                uid = "09d91fa8-3369-11ea-a206-98039b46d4d0";
            }
            DialogUtil.showProgress(ctx, true);

            ((MainActivity) getActivity()).getTbiService().orderProgress(uid, encode, new CommonCallback<ApiResult<String>>() {
                @Override
                public void onCallBack(ApiResult<String> data) {
                    LogMe.e("进行中的返回的结果" + data);
                    if (data != null && ListUtil.isNotEmpty(data.getData())) {
                        YiWeiCarAdapter adapter = new YiWeiCarAdapter();
                        adapter.setShowTitle(false);
                        adapter.setDatas(data.getData());

                        adapter.setCallbackListener(new YiWeiCarAdapter.CallbackListener() {
                            @Override
                            public void phone(String pid) {

                            }

                            @Override
                            public void itemOnClick(YiweiCar yiweiCar) {
                                Intent intent = new Intent(ctx, RecomendOrderActivity.class);
                                intent.putExtra("orderId", yiweiCar.getOrderId());
                                startActivity(intent);

                            }
                        });
                        rvDingdan.setLayoutManager(new LinearLayoutManager(ctx));
                        rvDingdan.setAdapter(adapter);

                    } else {
                        if (data != null) {
                            DialogUtil.showAlert(ctx, data.getMessage(), null);
                        }
                    }
                }
            });
        }

    }
}
