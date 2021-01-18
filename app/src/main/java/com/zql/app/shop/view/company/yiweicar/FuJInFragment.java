package com.zql.app.shop.view.company.yiweicar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amap.api.maps.model.CameraPosition;
import com.google.gson.Gson;
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
import com.zql.app.shop.entity.FilterBean;
import com.zql.app.shop.entity.yiwei.YiViUserCard;
import com.zql.app.shop.entity.yiwei.YiViUserCardReponse;
import com.zql.app.shop.entity.yiwei.YiweiCar;
import com.zql.app.shop.entity.yiwei.YiweiCarRequest;
import com.zql.app.shop.entity.yiwei.YiweiUserPhone;
import com.zql.app.shop.event.ApiResult;
import com.zql.app.shop.util.view.XRefreshViewUtils;
import com.zql.app.shop.view.dialog.DialogFilterRight;
import com.zql.app.shop.view.fragment.common.CommonTabContentFragment;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class FuJInFragment extends CommonTabContentFragment implements YiWeiCarAdapter.CallbackListener {
    @BindView(R.id.tv_cur_position)
    TextView tvCurPosition;

    @BindView(R.id.tv_shaixuan)
    TextView tvShaixuan;
  
    private PositionEntity curPosition;
    private YiWeiCarAdapter adapter;
    FilterBean filterBean;
    List<YiweiCar> totalCar;

    @Override
    protected XRefreshviewRecyclerAdapter getOrderContextViewAdapter() {
        adapter = new YiWeiCarAdapter();
        adapter.setCallbackListener(this);
        return adapter;
    }

    @Override
    protected View getEmptyView() {
        return null;
    }

    @Override
    protected void loadData() {
        if (curPosition == null) {
            DialogUtil.dismissProgress();
            getRefreshViewUtils().setLoadData(null, true);
            return;
        }
        YiweiCarRequest request = new YiweiCarRequest();
        request.setPageNo(getRefreshViewUtils().getCurPage() + "");
        request.setPageSize(getRefreshViewUtils().getPageCount() + "");
        request.setStartLatitude(curPosition.latitue + "");
        request.setStartLongitude(curPosition.longitude + "");
        String json = new Gson().toJson(request, YiweiCarRequest.class);
        //json=json.replace("{","%7b").replace("}","%7d");
        LogMe.e(json);
        String encode = null;
        try {
            encode = URLEncoder.encode(json, "utf-8");
            encode = URLEncoder.encode(json, "utf-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        LogMe.e(encode);
        //json="%7b%22isNewEdition%22%3a%221%22%2c%22pageNo%22%3a%221%22%2c%22pageSize%22%3a%2220%22%2c%22startLatitude%22%3a%2239.05183403862847%22%2c%22startLongitude%22%3a%22117.1266750759549%22%7d";
        ((MainActivity) getActivity()).getTbiService().carOrderList(encode, new CommonCallback<ApiResult<String>>() {
            @Override
            public void onCallBack(ApiResult<String> data) {
                if (data != null) {
                    if (ListUtil.isNotEmpty(data.getData())) {
                        if (ListUtil.isNotEmpty(totalCar)) {
                            totalCar.addAll(data.getData());
                        } else {
                            totalCar = data.getData();
                        }
                        getRefreshViewUtils().setLoadData(setFilterData(data.getData()), true);
                    }
                }
            }
        });
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        super.initView(view, savedInstanceState);
        LocationTask locationTask = new LocationTask(ctx, new CommonCallback<PositionEntity>() {
            @Override
            public void onCallBack(PositionEntity data) {
                if (data != null) {
                    curPosition = data;
                    LogMe.e("定位成功" + data.city + data.address);
                    tvCurPosition.setText(data.city);
                    getRefreshViewUtils().reLoad();

                }
            }
        });
        locationTask.startSingleLocate();
        getRefreshViewUtils().setPullRefreshListener(new XRefreshViewUtils.PullRefreshListener() {
            @Override
            public void refresh() {
                if (totalCar != null) {
                    totalCar.clear();
                    totalCar = null;
                }
            }
        });
    }

    @Override
    public int getLayout() {
        return R.layout.activity_yiwei_car;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 999) {
            if (data != null) {
                CameraPosition p = data.getParcelableExtra("p");
                if (p != null && p.target != null) {
                    curPosition.latitue = p.target.latitude;
                    curPosition.longitude = p.target.longitude;
                    getRefreshViewUtils().reLoad();
                }
            }
        }
    }

    @Override
    public void phone(String pid) {
        DialogUtil.showProgress(ctx, false);
        YiweiUserPhone yiweiUserPhone = new YiweiUserPhone();
        yiweiUserPhone.setFindUserId(pid);
        String json = new Gson().toJson(yiweiUserPhone, YiweiUserPhone.class);
        //json=json.replace("{","%7b").replace("}","%7d");
        LogMe.e(json);
        String encode = null;
        try {
            encode = URLEncoder.encode(json, "utf-8");
            encode = URLEncoder.encode(json, "utf-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        ((MainActivity) getActivity()).getTbiService().findUserPhone(encode, new CommonCallback<YiViUserCardReponse>() {
            @Override
            public void onCallBack(YiViUserCardReponse data) {
                final YiViUserCard data1 = data.getData();
                if (data1 != null) {
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
                } else {
                    DialogUtil.showAlert(ctx, "出事了 联系管理员", null);
                }
            }
        });
    }

    @Override
    public void itemOnClick(YiweiCar yiweiCar) {

    }


   

    @OnClick(R.id.tv_shaixuan)
    public void onViewClicked() {
        DialogFilterRight right = new DialogFilterRight(ctx);
        right.show();
        right.setFilterBean(filterBean);
        right.setOnConfirmListener(new DialogFilterRight.OnConfirmListener() {
            @Override
            public void confirm(FilterBean filterBean1) {
                filterBean = filterBean1;
                adapter.clear();
                List<YiweiCar> yiweiCars = setFilterData(totalCar);


                getRefreshViewUtils().setLoadData(yiweiCars, true);
            }
        });
    }

    private List<YiweiCar> setFilterData(List<YiweiCar> data) {
        if (ListUtil.isNotEmpty(data)) {
            Collections.sort(data, new Comparator<YiweiCar>() {
                @Override
                public int compare(YiweiCar yiweiCar, YiweiCar t1) {
                    return yiweiCar.getLeaveOnTime().compareTo(t1.getLeaveOnTime());
                }
            });
            if (filterBean != null) {
                List<YiweiCar> tmpCarList = new ArrayList<>();
                String start = filterBean.getStart();
                String end = filterBean.getEnd();
                String date = filterBean.getDate();

                for (YiweiCar yiweiCar : data) {
                    boolean isContainStart = true;
                    if (Validator.isNotEmpty(start)) {
                        isContainStart = yiweiCar.getStartPoint().contains(start);

                    }
                    boolean isContainEnd = true;
                    if (Validator.isNotEmpty(end)) {
                        isContainEnd = yiweiCar.getEndPoint().contains(end);
                    }
                    boolean isCOntainDate = true;

                    if (Validator.isNotEmpty(date)) {
                        String s = DateUtil.date2Str(new Date(Long.valueOf(yiweiCar.getLeaveOnTime())), "yyyy-MM-dd");
                        isCOntainDate = s.contains(date);
                    }
                    if (isContainStart && isContainEnd && isCOntainDate) {
                        try {
                            tmpCarList.add((YiweiCar) yiweiCar.clone());
                        } catch (CloneNotSupportedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                LogMe.e(tmpCarList);
                return tmpCarList;
            } else {
                return data;
            }

        }
        return null;
    }



    @OnClick(R.id.tv_cur_position)
    public void goSelectPosition() {
        startActivityForResult(new Intent(ctx,MapAddressActivity.class),100);
    }
}
