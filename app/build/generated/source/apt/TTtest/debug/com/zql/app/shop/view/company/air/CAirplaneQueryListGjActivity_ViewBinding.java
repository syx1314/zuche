// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.company.air;

import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import com.zql.app.shop.core.MyCommonRefreshActivity_ViewBinding;
import com.zql.app.shop.util.view.AirListTopCalendar;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CAirplaneQueryListGjActivity_ViewBinding extends MyCommonRefreshActivity_ViewBinding {
  private CAirplaneQueryListGjActivity target;

  private View view2131299457;

  private View view2131298624;

  private View view2131298650;

  private View view2131298638;

  private View view2131298634;

  private View view2131296295;

  private View view2131299163;

  @UiThread
  public CAirplaneQueryListGjActivity_ViewBinding(CAirplaneQueryListGjActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CAirplaneQueryListGjActivity_ViewBinding(final CAirplaneQueryListGjActivity target,
      View source) {
    super(target, source);

    this.target = target;

    View view;
    target.tvTopTip = Utils.findRequiredViewAsType(source, R.id.airplane_query_list_top_tip, "field 'tvTopTip'", TextView.class);
    target.tvStartplace = Utils.findRequiredViewAsType(source, R.id.airplane_query_list_top_title_left_startplace, "field 'tvStartplace'", TextView.class);
    target.ivTitleCenterArrow = Utils.findRequiredViewAsType(source, R.id.airplane_query_list_top_title_center_arrow, "field 'ivTitleCenterArrow'", ImageView.class);
    target.tvTitleRightArriveplace = Utils.findRequiredViewAsType(source, R.id.airplane_query_list_top_title_right_arriveplace, "field 'tvTitleRightArriveplace'", TextView.class);
    target.tvBackDate = Utils.findRequiredViewAsType(source, R.id.tv_back_date, "field 'tvBackDate'", TextView.class);
    target.linCalendar = Utils.findRequiredViewAsType(source, R.id.lin_calendar, "field 'linCalendar'", LinearLayout.class);
    target.viewAirCalendar = Utils.findRequiredViewAsType(source, R.id.view_air_calendar, "field 'viewAirCalendar'", AirListTopCalendar.class);
    target.rvSelAir = Utils.findRequiredViewAsType(source, R.id.rv_sel_air, "field 'rvSelAir'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.tv_travelpolicy, "field 'tvTravelPolicy' and method 'onViewClicked'");
    target.tvTravelPolicy = Utils.castView(view, R.id.tv_travelpolicy, "field 'tvTravelPolicy'", TextView.class);
    view2131299457 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvHaveTax = Utils.findRequiredViewAsType(source, R.id.tv_have_tax, "field 'tvHaveTax'", TextView.class);
    target.linNoContent = Utils.findRequiredViewAsType(source, R.id.lin_no_content, "field 'linNoContent'", LinearLayout.class);
    target.ivBottomSelectIcon = Utils.findRequiredViewAsType(source, R.id.iv_bottom_select_icon, "field 'ivBottomSelectIcon'", ImageView.class);
    target.tvBottomSelectConditions = Utils.findRequiredViewAsType(source, R.id.tv_bottom_select_conditions, "field 'tvBottomSelectConditions'", TextView.class);
    target.filterDot = Utils.findRequiredView(source, R.id.filter_dot, "field 'filterDot'");
    target.ivBottomTimeIcon = Utils.findRequiredViewAsType(source, R.id.iv_bottom_time_icon, "field 'ivBottomTimeIcon'", ImageView.class);
    target.ivTimeSort = Utils.findRequiredViewAsType(source, R.id.iv_time_sort, "field 'ivTimeSort'", ImageView.class);
    target.tvBottomSelectTime = Utils.findRequiredViewAsType(source, R.id.tv_bottom_select_time, "field 'tvBottomSelectTime'", TextView.class);
    target.viewTimeDot = Utils.findRequiredView(source, R.id.view_time_dot, "field 'viewTimeDot'");
    target.ivPriceSort = Utils.findRequiredViewAsType(source, R.id.iv_price_sort, "field 'ivPriceSort'", ImageView.class);
    target.ivPriceIcon = Utils.findRequiredViewAsType(source, R.id.iv_price_icon, "field 'ivPriceIcon'", ImageView.class);
    target.tvBottomSelectPrice = Utils.findRequiredViewAsType(source, R.id.tv_bottom_select_price, "field 'tvBottomSelectPrice'", TextView.class);
    target.viewPriceDot = Utils.findRequiredView(source, R.id.view_price_dot, "field 'viewPriceDot'");
    target.ivMoreIcon = Utils.findRequiredViewAsType(source, R.id.iv_more_icon, "field 'ivMoreIcon'", ImageView.class);
    target.tvBottomSelectMore = Utils.findRequiredViewAsType(source, R.id.tv_bottom_select_more, "field 'tvBottomSelectMore'", TextView.class);
    target.viewMoreDot = Utils.findRequiredView(source, R.id.view_more_dot, "field 'viewMoreDot'");
    target.bottomTab = Utils.findRequiredViewAsType(source, R.id.bottom_tab, "field 'bottomTab'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.rl_filter, "field 'rlFilter' and method 'onViewClicked'");
    target.rlFilter = Utils.castView(view, R.id.rl_filter, "field 'rlFilter'", RelativeLayout.class);
    view2131298624 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rl_time, "field 'rlTime' and method 'onViewClicked'");
    target.rlTime = Utils.castView(view, R.id.rl_time, "field 'rlTime'", RelativeLayout.class);
    view2131298650 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rl_price, "field 'rlPrice' and method 'onViewClicked'");
    target.rlPrice = Utils.castView(view, R.id.rl_price, "field 'rlPrice'", RelativeLayout.class);
    view2131298638 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rl_more, "field 'rlMore' and method 'onViewClicked'");
    target.rlMore = Utils.castView(view, R.id.rl_more, "field 'rlMore'", RelativeLayout.class);
    view2131298634 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.airplane_query_list_top_title_left_back, "method 'onViewClicked'");
    view2131296295 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
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
    CAirplaneQueryListGjActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvTopTip = null;
    target.tvStartplace = null;
    target.ivTitleCenterArrow = null;
    target.tvTitleRightArriveplace = null;
    target.tvBackDate = null;
    target.linCalendar = null;
    target.viewAirCalendar = null;
    target.rvSelAir = null;
    target.tvTravelPolicy = null;
    target.tvHaveTax = null;
    target.linNoContent = null;
    target.ivBottomSelectIcon = null;
    target.tvBottomSelectConditions = null;
    target.filterDot = null;
    target.ivBottomTimeIcon = null;
    target.ivTimeSort = null;
    target.tvBottomSelectTime = null;
    target.viewTimeDot = null;
    target.ivPriceSort = null;
    target.ivPriceIcon = null;
    target.tvBottomSelectPrice = null;
    target.viewPriceDot = null;
    target.ivMoreIcon = null;
    target.tvBottomSelectMore = null;
    target.viewMoreDot = null;
    target.bottomTab = null;
    target.rlFilter = null;
    target.rlTime = null;
    target.rlPrice = null;
    target.rlMore = null;

    view2131299457.setOnClickListener(null);
    view2131299457 = null;
    view2131298624.setOnClickListener(null);
    view2131298624 = null;
    view2131298650.setOnClickListener(null);
    view2131298650 = null;
    view2131298638.setOnClickListener(null);
    view2131298638 = null;
    view2131298634.setOnClickListener(null);
    view2131298634 = null;
    view2131296295.setOnClickListener(null);
    view2131296295 = null;
    view2131299163.setOnClickListener(null);
    view2131299163 = null;

    super.unbind();
  }
}
