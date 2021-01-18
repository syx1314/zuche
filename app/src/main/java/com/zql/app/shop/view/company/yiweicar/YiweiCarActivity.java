package com.zql.app.shop.view.company.yiweicar;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.tbruyelle.rxpermissions.Permission;
import com.tbruyelle.rxpermissions.RxPermissions;
import com.zql.app.lib.core.CommonCallback;
import com.zql.app.lib.util.DateUtil;
import com.zql.app.lib.util.ListUtil;
import com.zql.app.lib.util.Validator;
import com.zql.app.lib.util.map.LocationTask;
import com.zql.app.lib.util.map.PositionEntity;
import com.zql.app.lib.util.sys.LogMe;
import com.zql.app.lib.util.ui.DialogUtil;
import com.zql.app.shop.R;
import com.zql.app.shop.adapter.XRefreshviewRecyclerAdapter;
import com.zql.app.shop.adapter.YiWeiCarAdapter;

import com.zql.app.shop.core.MyActivity;
import com.zql.app.shop.core.MyCommonRefreshActivity;
import com.zql.app.shop.entity.FilterBean;
import com.zql.app.shop.entity.yiwei.YiViUserCard;
import com.zql.app.shop.entity.yiwei.YiViUserCardReponse;
import com.zql.app.shop.entity.yiwei.YiweiCar;
import com.zql.app.shop.entity.yiwei.YiweiCarRequest;
import com.zql.app.shop.entity.yiwei.YiweiUserPhone;
import com.zql.app.shop.event.ApiResult;
import com.zql.app.shop.service.impl.YiweiServiceImpl;
import com.zql.app.shop.util.IntentUtil;
import com.zql.app.shop.util.view.XRefreshViewUtils;
import com.zql.app.shop.view.dialog.DialogFilterRight;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Subscriber;

public class YiweiCarActivity extends MyCommonRefreshActivity<YiweiServiceImpl> implements YiWeiCarAdapter.CallbackListener {

    @BindView(R.id.tab)
    TabLayout tabLayout;
    @BindView(R.id.tv_cur_position)
    TextView tvCurPosition;
    @BindView(R.id.fb)
    FloatingActionButton fb;
    private YiWeiCarAdapter adapter;
    private PositionEntity curPosition;
    FilterBean filterBean;
    /**
     * 高德定位需要进行检测的权限数组
     */
    protected String[] needPermissions = {
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.CAMERA,
    };
    List<YiweiCar> totalCar;
    @Override
    public int getLayout() {
        return R.layout.activity_yiwei_car;
    }


    @Override
    protected void initView() {
        super.initView();
        tabLayout.addTab(tabLayout.newTab().setText("顺风车"));
        tabLayout.addTab(tabLayout.newTab().setText("跑腿"));
        requestPermissoin("允许", "禁止", "禁止了权限将会影响很多功能", needPermissions);

        LocationTask locationTask = new LocationTask(ctx, new CommonCallback<PositionEntity>() {
            @Override
            public void onCallBack(PositionEntity data) {
             if (data!=null){
                 curPosition=data;
                 LogMe.e("定位成功"+data.city+data.address);
                 tvCurPosition.setText(data.city);
                 getRefreshViewUtils().reLoad();

             }
            }
        });
        locationTask.startSingleLocate();
        getRefreshViewUtils().setPullRefreshListener(new XRefreshViewUtils.PullRefreshListener() {
            @Override
            public void refresh() {
                if (totalCar!=null){
                    totalCar.clear();
                    totalCar=null;
                }
            }
        });
    }
    /**
     * 请求权限
     *
     * @param permission  权限
     * @param okTips      授权提示
     * @param noTips      拒绝权限
     * @param noAgainTips 点击不在提醒 提示用户如何操作
     */
    protected void requestPermissoin(final String okTips, final String noTips, final String noAgainTips, String... permission) {

        RxPermissions rxPermissions = new RxPermissions(ctx);
        rxPermissions.requestEach(permission).subscribe(new Subscriber<Permission>() {
            @Override
            public void onCompleted() {
//                LogMe.e("onCompleted");
//                if(gojump) {
//                    checkVersion();
//                }
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(Permission permission) {
//                LogMe.e("onNext"+permission.name);
                if (permission.granted) {
                    // 用户已经同意该权限
//                    flag++;
//                    if(flag==needPermissions.length-1){
//                        gojump=true;
//                    }

                } else if (permission.shouldShowRequestPermissionRationale) {
//                    gojump=false;
                    // 用户拒绝了该权限，没有选中『不再询问』（Never ask again）,那么下次再次启动时，还会提示请求权限的对话框
                    DialogUtil.showAlert(ctx, noTips, new CommonCallback<Boolean>() {
                        @Override
                        public void onCallBack(Boolean data) {
//                            checkVersion();
                        }
                    });


                } else {
//                    gojump = false;
                    // 用户拒绝了该权限，并且选中『不再询问』，提醒用户手动打开权限
                    DialogUtil.showAlertOkCancel(ctx, noAgainTips, new CommonCallback<Boolean>() {
                        @Override
                        public void onCallBack(Boolean data) {
                            if (data) {
                                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                Uri uri = Uri.fromParts("package", getPackageName(), null);
                                intent.setData(uri);
                                startActivityForResult(intent, 0);
                            } else {
//                                checkVersion();
                            }
                        }
                    });
                }
            }
        });
    }
    @Override
    protected XRefreshviewRecyclerAdapter getOrderContextViewAdapter() {
          adapter=new YiWeiCarAdapter();
          adapter.setCallbackListener(this);
        return adapter;
    }

    @Override
    protected View getEmptyView() {
        return null;
    }

    @Override
    protected void loadData() {
        if (curPosition==null){
            DialogUtil.dismissProgress();
            getRefreshViewUtils().setLoadData(null,true);
            return;
        }
        YiweiCarRequest request=new YiweiCarRequest();
        request.setPageNo(getRefreshViewUtils().getCurPage()+"");
        request.setPageSize(getRefreshViewUtils().getPageCount()+"");
        request.setStartLatitude(curPosition.latitue+"");
        request.setStartLongitude(curPosition.longitude+"");
        String json = new Gson().toJson(request, YiweiCarRequest.class);
        //json=json.replace("{","%7b").replace("}","%7d");
        LogMe.e(json);
        String encode = null;
        try {
            encode = URLEncoder.encode(json,"utf-8");
            encode = URLEncoder.encode(json,"utf-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        LogMe.e(encode);
        //json="%7b%22isNewEdition%22%3a%221%22%2c%22pageNo%22%3a%221%22%2c%22pageSize%22%3a%2220%22%2c%22startLatitude%22%3a%2239.05183403862847%22%2c%22startLongitude%22%3a%22117.1266750759549%22%7d";
        getTbiService().carOrderList(encode, new CommonCallback<ApiResult<String>>() {
         @Override
         public void onCallBack(ApiResult<String> data) {
             if (data!=null){
                 if (ListUtil.isNotEmpty(data.getData())) {
                     if (ListUtil.isNotEmpty(totalCar)) {
                         totalCar.addAll(data.getData());
                     }else {
                         totalCar = data.getData();
                     }
                     getRefreshViewUtils().setLoadData(setFilterData(data.getData()),true);
                 }
             }
         }
     });
    }

    private List<YiweiCar> setFilterData(List<YiweiCar> data) {
        if (ListUtil.isNotEmpty(data)){
            Collections.sort(data, new Comparator<YiweiCar>() {
                @Override
                public int compare(YiweiCar yiweiCar, YiweiCar t1) {
                    return yiweiCar.getLeaveOnTime().compareTo(t1.getLeaveOnTime());
                }
            });
            if (filterBean!=null){
                List<YiweiCar> tmpCarList=new ArrayList<>();
                String start = filterBean.getStart();
                String end = filterBean.getEnd();
                String date = filterBean.getDate();

                for (YiweiCar yiweiCar : data) {
                    boolean isContainStart=true;
                    if (Validator.isNotEmpty(start)){
                        isContainStart = yiweiCar.getStartPoint().contains(start);

                    }
                    boolean isContainEnd=true;
                    if (Validator.isNotEmpty(end)) {
                        isContainEnd = yiweiCar.getEndPoint().contains(end);
                    }
                    boolean isCOntainDate=true;

                    if (Validator.isNotEmpty(date)) {
                        String s = DateUtil.date2Str(new Date(Long.valueOf(yiweiCar.getLeaveOnTime())), "yyyy-MM-dd");
                        isCOntainDate = s.contains(date);
                    }
                    if (isContainStart&&isContainEnd&&isCOntainDate) {
                        try {
                            tmpCarList.add((YiweiCar) yiweiCar.clone());
                        } catch (CloneNotSupportedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                LogMe.e(tmpCarList);
                return tmpCarList;
            }else {
                return data;
            }

        }
        return null;
    }

    @OnClick(R.id.tv_shaixuan)
    public void shaixuan(){
        DialogFilterRight right=new DialogFilterRight(ctx);
        right.show();
        right.setFilterBean(filterBean);
        right.setOnConfirmListener(new DialogFilterRight.OnConfirmListener() {
            @Override
            public void confirm(FilterBean filterBean1) {
                filterBean=filterBean1;
                adapter.clear();
                List<YiweiCar> yiweiCars = setFilterData(totalCar);


                getRefreshViewUtils().setLoadData(yiweiCars,true);
            }
        });
    }
    @OnClick(R.id.fb)
    public void toOrder(){
        IntentUtil.get().goActivity(this,OrderActivity.class);

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
