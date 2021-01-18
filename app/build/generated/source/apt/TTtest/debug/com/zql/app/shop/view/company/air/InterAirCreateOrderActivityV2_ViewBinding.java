// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.company.air;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import com.zql.app.shop.util.view.BContactPeopleView;
import com.zql.app.shop.util.view.BOldTravelInfo;
import java.lang.IllegalStateException;
import java.lang.Override;

public class InterAirCreateOrderActivityV2_ViewBinding implements Unbinder {
  private InterAirCreateOrderActivityV2 target;

  private View view2131298075;

  private View view2131298769;

  private View view2131297617;

  private View view2131298319;

  private View view2131298070;

  private View view2131298988;

  private View view2131297972;

  private View view2131298055;

  @UiThread
  public InterAirCreateOrderActivityV2_ViewBinding(InterAirCreateOrderActivityV2 target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public InterAirCreateOrderActivityV2_ViewBinding(final InterAirCreateOrderActivityV2 target,
      View source) {
    this.target = target;

    View view;
    target.rlRoot = Utils.findRequiredViewAsType(source, R.id.rl_root, "field 'rlRoot'", RelativeLayout.class);
    target.tv_price_title = Utils.findRequiredViewAsType(source, R.id.p_flight_reserve_total_price_string, "field 'tv_price_title'", TextView.class);
    target.tv_price = Utils.findRequiredViewAsType(source, R.id.p_flight_reserve_bottom_pay_total_price_number, "field 'tv_price'", TextView.class);
    target.iv_expand_detail = Utils.findRequiredViewAsType(source, R.id.p_flight_reserve_bottom_pay_left_unfold, "field 'iv_expand_detail'", ImageButton.class);
    target.linAirInfo = Utils.findRequiredViewAsType(source, R.id.lin_air_info, "field 'linAirInfo'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.lin_rule, "field 'linRule' and method 'onViewClicked'");
    target.linRule = Utils.castView(view, R.id.lin_rule, "field 'linRule'", LinearLayout.class);
    view2131298075 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.linPassageContainer = Utils.findRequiredViewAsType(source, R.id.lin_passage_container, "field 'linPassageContainer'", LinearLayout.class);
    target.tvPassageNum = Utils.findRequiredViewAsType(source, R.id.tv_total_passage_num, "field 'tvPassageNum'", TextView.class);
    target.rvTraveler = Utils.findRequiredViewAsType(source, R.id.rv_traveler, "field 'rvTraveler'", RecyclerView.class);
    target.tvSurance = Utils.findRequiredViewAsType(source, R.id.tv_surance, "field 'tvSurance'", TextView.class);
    target.tvSurancePrice = Utils.findRequiredViewAsType(source, R.id.tv_surance_price, "field 'tvSurancePrice'", TextView.class);
    view = Utils.findRequiredView(source, R.id.switch_surance, "field 'switchSurance' and method 'checkChange'");
    target.switchSurance = Utils.castView(view, R.id.switch_surance, "field 'switchSurance'", Switch.class);
    view2131298769 = view;
    ((CompoundButton) view).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton p0, boolean p1) {
        target.checkChange();
      }
    });
    target.contactView = Utils.findRequiredViewAsType(source, R.id.contact_view, "field 'contactView'", BContactPeopleView.class);
    target.linPolicy = Utils.findRequiredViewAsType(source, R.id.c_flight_reserve_common_linearlayout_notfit_policy_out_tab_1, "field 'linPolicy'", LinearLayout.class);
    target.bTravelInfo = Utils.findRequiredViewAsType(source, R.id.view_travel_info, "field 'bTravelInfo'", BOldTravelInfo.class);
    target.tvPolicyContent = Utils.findRequiredViewAsType(source, R.id.tv_notfit_policy_content, "field 'tvPolicyContent'", TextView.class);
    view = Utils.findRequiredView(source, R.id.et_notfit_policy_reason_content, "field 'tvNofitReason' and method 'onViewClicked'");
    target.tvNofitReason = Utils.castView(view, R.id.et_notfit_policy_reason_content, "field 'tvNofitReason'", TextView.class);
    view2131297617 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.etBz = Utils.findRequiredViewAsType(source, R.id.et_bz, "field 'etBz'", EditText.class);
    view = Utils.findRequiredView(source, R.id.p_flight_reserve_to_pay, "field 'btnPay' and method 'onViewClicked'");
    target.btnPay = Utils.castView(view, R.id.p_flight_reserve_to_pay, "field 'btnPay'", TextView.class);
    view2131298319 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.linInsuranceBox = Utils.findRequiredViewAsType(source, R.id.lin_insurance_box, "field 'linInsuranceBox'", LinearLayout.class);
    target.linPriceBox = Utils.findRequiredViewAsType(source, R.id.in_bottom, "field 'linPriceBox'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.lin_reminder, "method 'onViewClicked'");
    view2131298070 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_cost_center, "method 'onViewClicked'");
    view2131298988 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lin_cost_center, "method 'onViewClicked'");
    view2131297972 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lin_price_details, "method 'onViewClicked'");
    view2131298055 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    InterAirCreateOrderActivityV2 target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rlRoot = null;
    target.tv_price_title = null;
    target.tv_price = null;
    target.iv_expand_detail = null;
    target.linAirInfo = null;
    target.linRule = null;
    target.linPassageContainer = null;
    target.tvPassageNum = null;
    target.rvTraveler = null;
    target.tvSurance = null;
    target.tvSurancePrice = null;
    target.switchSurance = null;
    target.contactView = null;
    target.linPolicy = null;
    target.bTravelInfo = null;
    target.tvPolicyContent = null;
    target.tvNofitReason = null;
    target.etBz = null;
    target.btnPay = null;
    target.linInsuranceBox = null;
    target.linPriceBox = null;

    view2131298075.setOnClickListener(null);
    view2131298075 = null;
    ((CompoundButton) view2131298769).setOnCheckedChangeListener(null);
    view2131298769 = null;
    view2131297617.setOnClickListener(null);
    view2131297617 = null;
    view2131298319.setOnClickListener(null);
    view2131298319 = null;
    view2131298070.setOnClickListener(null);
    view2131298070 = null;
    view2131298988.setOnClickListener(null);
    view2131298988 = null;
    view2131297972.setOnClickListener(null);
    view2131297972 = null;
    view2131298055.setOnClickListener(null);
    view2131298055 = null;
  }
}
