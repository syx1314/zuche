// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.company.air;

import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import com.zql.app.shop.core.MyCommonRefreshActivity_ViewBinding;
import com.zql.app.shop.util.view.AirListTopCalendar;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CAirplaneQueryListActivity_ViewBinding extends MyCommonRefreshActivity_ViewBinding {
  private CAirplaneQueryListActivity target;

  private View view2131299457;

  private View view2131296842;

  private View view2131296846;

  private View view2131296840;

  private View view2131296848;

  private View view2131296839;

  private View view2131296847;

  private View view2131296295;

  private View view2131299163;

  @UiThread
  public CAirplaneQueryListActivity_ViewBinding(CAirplaneQueryListActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CAirplaneQueryListActivity_ViewBinding(final CAirplaneQueryListActivity target,
      View source) {
    super(target, source);

    this.target = target;

    View view;
    target.viewAirCalendar = Utils.findRequiredViewAsType(source, R.id.view_air_calendar, "field 'viewAirCalendar'", AirListTopCalendar.class);
    target.rvSelAir = Utils.findRequiredViewAsType(source, R.id.rv_sel_air, "field 'rvSelAir'", RecyclerView.class);
    target.linTimeTips = Utils.findRequiredViewAsType(source, R.id.lin_time_tips, "field 'linTimeTips'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.tv_travelpolicy, "field 'tvTravelPolicy' and method 'travelPolicy'");
    target.tvTravelPolicy = Utils.castView(view, R.id.tv_travelpolicy, "field 'tvTravelPolicy'", TextView.class);
    view2131299457 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.travelPolicy(p0);
      }
    });
    target.airplane_query_list_top_title_left_startplace = Utils.findRequiredViewAsType(source, R.id.airplane_query_list_top_title_left_startplace, "field 'airplane_query_list_top_title_left_startplace'", TextView.class);
    target.airplane_query_list_top_title_right_arriveplace = Utils.findRequiredViewAsType(source, R.id.airplane_query_list_top_title_right_arriveplace, "field 'airplane_query_list_top_title_right_arriveplace'", TextView.class);
    target.common_airplane_list_tv_top_show_month_day = Utils.findRequiredViewAsType(source, R.id.common_airplane_list_tv_top_show_month_day, "field 'common_airplane_list_tv_top_show_month_day'", TextView.class);
    target.common_airplane_list_tv_top_show_weekday = Utils.findRequiredViewAsType(source, R.id.common_airplane_list_tv_top_show_weekday, "field 'common_airplane_list_tv_top_show_weekday'", TextView.class);
    view = Utils.findRequiredView(source, R.id.common_airplane_query_list_iv_bottom_select_icon, "field 'ivFilterAir' and method 'selectConditionsClk'");
    target.ivFilterAir = Utils.castView(view, R.id.common_airplane_query_list_iv_bottom_select_icon, "field 'ivFilterAir'", ImageView.class);
    view2131296842 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.selectConditionsClk(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.common_airplane_query_list_tv_bottom_select_conditions, "field 'tvFilterAir' and method 'selectConditionsClk'");
    target.tvFilterAir = Utils.castView(view, R.id.common_airplane_query_list_tv_bottom_select_conditions, "field 'tvFilterAir'", TextView.class);
    view2131296846 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.selectConditionsClk(p0);
      }
    });
    target.common_airplane_list_tv_top_show_lower_price = Utils.findRequiredViewAsType(source, R.id.common_airplane_list_tv_top_show_lower_price, "field 'common_airplane_list_tv_top_show_lower_price'", TextView.class);
    target.common_airplane_query_list_filter_dot = Utils.findRequiredView(source, R.id.common_airplane_query_list_filter_dot, "field 'common_airplane_query_list_filter_dot'");
    view = Utils.findRequiredView(source, R.id.common_airplane_query_list_bottom_time_icon, "field 'ivFilterTime' and method 'selectTimeClk'");
    target.ivFilterTime = Utils.castView(view, R.id.common_airplane_query_list_bottom_time_icon, "field 'ivFilterTime'", ImageView.class);
    view2131296840 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.selectTimeClk(p0);
      }
    });
    target.common_airplane_query_list_time_dot = Utils.findRequiredView(source, R.id.common_airplane_query_list_time_dot, "field 'common_airplane_query_list_time_dot'");
    target.ivTimeSort = Utils.findRequiredViewAsType(source, R.id.iv_time_sort, "field 'ivTimeSort'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.common_airplane_query_list_tv_bottom_select_time, "field 'common_airplane_query_list_tv_bottom_select_time' and method 'selectTimeClk'");
    target.common_airplane_query_list_tv_bottom_select_time = Utils.castView(view, R.id.common_airplane_query_list_tv_bottom_select_time, "field 'common_airplane_query_list_tv_bottom_select_time'", TextView.class);
    view2131296848 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.selectTimeClk(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.common_airplane_query_list_bottom_price_icon, "field 'ivFilterPrice' and method 'selectPriceClk'");
    target.ivFilterPrice = Utils.castView(view, R.id.common_airplane_query_list_bottom_price_icon, "field 'ivFilterPrice'", ImageView.class);
    view2131296839 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.selectPriceClk(p0);
      }
    });
    target.common_airplane_query_list_price_dot = Utils.findRequiredView(source, R.id.common_airplane_query_list_price_dot, "field 'common_airplane_query_list_price_dot'");
    view = Utils.findRequiredView(source, R.id.common_airplane_query_list_tv_bottom_select_price, "field 'common_airplane_query_list_tv_bottom_select_price' and method 'selectPriceClk'");
    target.common_airplane_query_list_tv_bottom_select_price = Utils.castView(view, R.id.common_airplane_query_list_tv_bottom_select_price, "field 'common_airplane_query_list_tv_bottom_select_price'", TextView.class);
    view2131296847 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.selectPriceClk(p0);
      }
    });
    target.ivPriceSort = Utils.findRequiredViewAsType(source, R.id.iv_price_sort, "field 'ivPriceSort'", ImageView.class);
    target.common_airplane_query_list_relativelayout_bottom_tab = Utils.findRequiredViewAsType(source, R.id.common_airplane_query_list_relativelayout_bottom_tab, "field 'common_airplane_query_list_relativelayout_bottom_tab'", LinearLayout.class);
    target.airplane_query_list_top_tip = Utils.findRequiredViewAsType(source, R.id.airplane_query_list_top_tip, "field 'airplane_query_list_top_tip'", TextView.class);
    view = Utils.findRequiredView(source, R.id.airplane_query_list_top_title_left_back, "method 'backfinishClk'");
    view2131296295 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.backfinishClk(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_look_calendar, "method 'lookCalendar'");
    view2131299163 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.lookCalendar(p0);
      }
    });
  }

  @Override
  public void unbind() {
    CAirplaneQueryListActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.viewAirCalendar = null;
    target.rvSelAir = null;
    target.linTimeTips = null;
    target.tvTravelPolicy = null;
    target.airplane_query_list_top_title_left_startplace = null;
    target.airplane_query_list_top_title_right_arriveplace = null;
    target.common_airplane_list_tv_top_show_month_day = null;
    target.common_airplane_list_tv_top_show_weekday = null;
    target.ivFilterAir = null;
    target.tvFilterAir = null;
    target.common_airplane_list_tv_top_show_lower_price = null;
    target.common_airplane_query_list_filter_dot = null;
    target.ivFilterTime = null;
    target.common_airplane_query_list_time_dot = null;
    target.ivTimeSort = null;
    target.common_airplane_query_list_tv_bottom_select_time = null;
    target.ivFilterPrice = null;
    target.common_airplane_query_list_price_dot = null;
    target.common_airplane_query_list_tv_bottom_select_price = null;
    target.ivPriceSort = null;
    target.common_airplane_query_list_relativelayout_bottom_tab = null;
    target.airplane_query_list_top_tip = null;

    view2131299457.setOnClickListener(null);
    view2131299457 = null;
    view2131296842.setOnClickListener(null);
    view2131296842 = null;
    view2131296846.setOnClickListener(null);
    view2131296846 = null;
    view2131296840.setOnClickListener(null);
    view2131296840 = null;
    view2131296848.setOnClickListener(null);
    view2131296848 = null;
    view2131296839.setOnClickListener(null);
    view2131296839 = null;
    view2131296847.setOnClickListener(null);
    view2131296847 = null;
    view2131296295.setOnClickListener(null);
    view2131296295 = null;
    view2131299163.setOnClickListener(null);
    view2131299163 = null;

    super.unbind();
  }
}
