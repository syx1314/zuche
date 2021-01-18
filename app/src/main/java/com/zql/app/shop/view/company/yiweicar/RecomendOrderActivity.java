package com.zql.app.shop.view.company.yiweicar;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.gson.Gson;
import com.zql.app.lib.core.CommonCallback;
import com.zql.app.lib.util.Validator;
import com.zql.app.lib.util.sys.LogMe;
import com.zql.app.lib.util.ui.DialogUtil;
import com.zql.app.shop.R;
import com.zql.app.shop.adapter.XRefreshviewRecyclerAdapter;
import com.zql.app.shop.adapter.YiWeiCarAdapter;
import com.zql.app.shop.core.MyActivity;
import com.zql.app.shop.core.MyCommonRefreshActivity;
import com.zql.app.shop.entity.yiwei.LoginResponse;
import com.zql.app.shop.entity.yiwei.MachOrderReponse;
import com.zql.app.shop.entity.yiwei.MachOrderRequest;
import com.zql.app.shop.entity.yiwei.MachReponse;
import com.zql.app.shop.entity.yiwei.OrderRequest;
import com.zql.app.shop.entity.yiwei.YiViUserCard;
import com.zql.app.shop.entity.yiwei.YiViUserCardReponse;
import com.zql.app.shop.entity.yiwei.YiweiCar;
import com.zql.app.shop.entity.yiwei.YiweiUserPhone;
import com.zql.app.shop.event.ApiResult;
import com.zql.app.shop.service.impl.YiweiServiceImpl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import butterknife.BindView;

public class RecomendOrderActivity extends MyCommonRefreshActivity<YiweiServiceImpl> implements YiWeiCarAdapter.CallbackListener {

    @BindView(R.id.tab)
    TabLayout tabLayout;
    @BindView(R.id.tab_filter)
    TabLayout tabFilter;
    private String orderId;
    String matchType="3";
    private String sortType="1"; // 2出发时间最早  1 离我最近 3 总价最高
    Object tag;
    @Override
    protected void initView() {
        orderId=getIntent().getStringExtra("orderId");
        super.initView();
        tabLayout.addTab(tabLayout.newTab().setText("包车/尊享").setTag("2"));
        tabLayout.addTab(tabLayout.newTab().setText("精准匹配").setTag("3"));
        tabLayout.addTab(tabLayout.newTab().setText("粗略匹配").setTag("4"));

        tabFilter.addTab(tabFilter.newTab().setText("离我最近").setTag("1"));
        tabFilter.addTab(tabFilter.newTab().setText("出发时间最早").setTag("2"));
        tabFilter.addTab(tabFilter.newTab().setText("总价最高").setTag("3"));
        tabLayout.getTabAt(1).select();
        tabFilter.getTabAt(0).select();
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                matchType = (String) tab.getTag();
                getRefreshViewUtils().reLoad();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //筛选
        tabFilter.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                sortType = (String) tab.getTag();
                getRefreshViewUtils().reLoad();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    protected XRefreshviewRecyclerAdapter getOrderContextViewAdapter() {
        YiWeiCarAdapter adapter = new YiWeiCarAdapter();
        adapter.setCallbackListener(this);
        return adapter;
    }

    @Override
    protected View getEmptyView() {
        return null;
    }

    @Override
    protected void loadData() {
        MachOrderRequest request=new MachOrderRequest();
        request.setMatchType(matchType);
        request.setPageNo(getRefreshViewUtils().getCurPage()+"");
        getRefreshViewUtils().setPageCount(10);
        request.setPageSize(getRefreshViewUtils().getPageCount()+"");
        request.setOrderId(orderId);
        request.setSortType(sortType);
        String json = new Gson().toJson(request, MachOrderRequest.class);
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
            getTbiService().orderJinZhunList(uid, encode, new CommonCallback<MachReponse>() {
                @Override
                public void onCallBack(MachReponse data) {
                    if (data!=null&&data.getData()!=null){
                        MachOrderReponse reponse = data.getData();
                        getRefreshViewUtils().setLoadData(reponse.getOrderListVO(),true);
                    }
                }
            });
        }
    }

    @Override
    public int getLayout() {
        return R.layout.activity_recomend_order;
    }


    @Override
    public void phone(String pid) {
        DialogUtil.showProgress(ctx,false);
        YiweiUserPhone yiweiUserPhone=new YiweiUserPhone();
        yiweiUserPhone.setFindUserId(pid);
        String json = new Gson().toJson(yiweiUserPhone, YiweiUserPhone.class);
        //json=json.replace("{","%7b").replace("}","%7d");
        LogMe.e(json);
        String encode = null;
        try {
            encode = URLEncoder.encode(json,"utf-8");
            encode = URLEncoder.encode(json,"utf-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        getTbiService().findUserPhone(encode, new CommonCallback<YiViUserCardReponse>() {
            @Override
            public void onCallBack(YiViUserCardReponse data) {
                final YiViUserCard data1 = data.getData();
                if (data1!=null) {
                    final YiViUserCard yiViUserCard = data1.getYiViUserCard();
                    DialogUtil.showAlertCusTitlelW80(ctx, "提示", yiViUserCard.getUserMobile(), "取消", getResources().getColor(R.color.tt_orange), "拨打", getResources().getColor(R.color.base_main_txt), new CommonCallback<Boolean>() {
                        @Override
                        public void onCallBack(Boolean aBoolean) {
                            if (!aBoolean) {
                                Intent intent = new Intent(Intent.ACTION_DIAL);
                                intent.setData(Uri.parse("tel:" + yiViUserCard.getUserMobile()));
                                startActivity(intent);
                            }
                        }
                    });
                }else {
                    DialogUtil.showAlert(ctx,"出事了 联系管理员",null);
                }
            }
        });
    }

    @Override
    public void itemOnClick(YiweiCar yiweiCar) {

    }
}
