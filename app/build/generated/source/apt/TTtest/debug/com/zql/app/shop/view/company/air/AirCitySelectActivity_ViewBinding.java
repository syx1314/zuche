// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.company.air;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AirCitySelectActivity_ViewBinding implements Unbinder {
  private AirCitySelectActivity target;

  private View view2131298920;

  private View view2131297348;

  private View view2131297358;

  @UiThread
  public AirCitySelectActivity_ViewBinding(AirCitySelectActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AirCitySelectActivity_ViewBinding(final AirCitySelectActivity target, View source) {
    this.target = target;

    View view;
    target.lin_city_header = Utils.findRequiredViewAsType(source, R.id.cp_common_select_city_header, "field 'lin_city_header'", LinearLayout.class);
    target.linSearchCity = Utils.findRequiredViewAsType(source, R.id.lin_select_city_header, "field 'linSearchCity'", LinearLayout.class);
    target.etSearch = Utils.findRequiredViewAsType(source, R.id.cp_common_select_city_et_search, "field 'etSearch'", EditText.class);
    view = Utils.findRequiredView(source, R.id.tv_cancel, "field 'tvCancel' and method 'cancel'");
    target.tvCancel = Utils.castView(view, R.id.tv_cancel, "field 'tvCancel'", TextView.class);
    view2131298920 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.cancel();
      }
    });
    target.tabLayout = Utils.findRequiredViewAsType(source, R.id.tablayout, "field 'tabLayout'", TabLayout.class);
    target.viewPager = Utils.findRequiredViewAsType(source, R.id.viewPager, "field 'viewPager'", ViewPager.class);
    target.flSearchReult = Utils.findRequiredViewAsType(source, R.id.fl_search_reult, "field 'flSearchReult'", FrameLayout.class);
    target.view80Bg = Utils.findRequiredView(source, R.id.view_80_bg, "field 'view80Bg'");
    target.rvSearchList = Utils.findRequiredViewAsType(source, R.id.rv_search_list, "field 'rvSearchList'", RecyclerView.class);
    target.rlSearchList = Utils.findRequiredViewAsType(source, R.id.rl_search_list, "field 'rlSearchList'", RelativeLayout.class);
    view = Utils.findRequiredView(source, R.id.cp_common_select_city_header_back, "method 'onViewClicked'");
    view2131297348 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    view = Utils.findRequiredView(source, R.id.cp_common_select_city_tv_search, "method 'onViewClicked1'");
    view2131297358 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked1();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    AirCitySelectActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.lin_city_header = null;
    target.linSearchCity = null;
    target.etSearch = null;
    target.tvCancel = null;
    target.tabLayout = null;
    target.viewPager = null;
    target.flSearchReult = null;
    target.view80Bg = null;
    target.rvSearchList = null;
    target.rlSearchList = null;

    view2131298920.setOnClickListener(null);
    view2131298920 = null;
    view2131297348.setOnClickListener(null);
    view2131297348 = null;
    view2131297358.setOnClickListener(null);
    view2131297358 = null;
  }
}
