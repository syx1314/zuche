// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.company.hotel;

import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import com.zql.app.shop.util.view.BOldTravelInfo;
import com.zql.app.shop.view.commonview.hotel.CommonHotelReserveActivity_ViewBinding;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CHotelReserveActivity_ViewBinding extends CommonHotelReserveActivity_ViewBinding {
  private CHotelReserveActivity target;

  private View view2131296490;

  private View view2131297005;

  private View view2131296571;

  @UiThread
  public CHotelReserveActivity_ViewBinding(CHotelReserveActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CHotelReserveActivity_ViewBinding(final CHotelReserveActivity target, View source) {
    super(target, source);

    this.target = target;

    View view;
    target.c_hotel_reserve_icon_conform = Utils.findRequiredViewAsType(source, R.id.c_hotel_reserve_icon_conform, "field 'c_hotel_reserve_icon_conform'", TextView.class);
    target.ivHotelFit = Utils.findRequiredViewAsType(source, R.id.c_hotel_fit, "field 'ivHotelFit'", TextView.class);
    target.c_hotel_reserve_breach_guarantee = Utils.findRequiredViewAsType(source, R.id.c_hotel_reserve_breach_guarantee, "field 'c_hotel_reserve_breach_guarantee'", LinearLayout.class);
    target.c_hotel_reserve_breach_guarantee_tv_type = Utils.findRequiredViewAsType(source, R.id.c_hotel_reserve_breach_guarantee_tv_type, "field 'c_hotel_reserve_breach_guarantee_tv_type'", TextView.class);
    view = Utils.findRequiredView(source, R.id.c_hotel_reserve_breach_guarantee_tv_reason, "field 'c_hotel_reserve_breach_guarantee_tv_reason' and method 'diapolicyReason'");
    target.c_hotel_reserve_breach_guarantee_tv_reason = Utils.castView(view, R.id.c_hotel_reserve_breach_guarantee_tv_reason, "field 'c_hotel_reserve_breach_guarantee_tv_reason'", TextView.class);
    view2131296490 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.diapolicyReason(p0);
      }
    });
    target.c_new_hotel_reserve_cost_center = Utils.findRequiredViewAsType(source, R.id.c_new_hotel_reserve_cost_center, "field 'c_new_hotel_reserve_cost_center'", LinearLayout.class);
    target.c_hotel_reserve_box_rv = Utils.findRequiredViewAsType(source, R.id.c_hotel_reserve_box_rv, "field 'c_hotel_reserve_box_rv'", RecyclerView.class);
    target.common_hotel_reserve_sel_ll_solo = Utils.findRequiredViewAsType(source, R.id.common_hotel_reserve_sel_ll_solo, "field 'common_hotel_reserve_sel_ll_solo'", LinearLayout.class);
    target.common_hotel_reserve_sel_ll_many = Utils.findRequiredViewAsType(source, R.id.common_hotel_reserve_sel_ll_many, "field 'common_hotel_reserve_sel_ll_many'", LinearLayout.class);
    target.bTravelInfo = Utils.findRequiredViewAsType(source, R.id.view_travel_info, "field 'bTravelInfo'", BOldTravelInfo.class);
    target.c_new_hotel_reserve_ll_customization = Utils.findRequiredViewAsType(source, R.id.c_new_hotel_reserve_ll_customization, "field 'c_new_hotel_reserve_ll_customization'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.common_hotel_reserve_contact_et_name, "method 'selContact'");
    view2131297005 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.selContact(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.c_new_hotel_reserve_ll_cost_center, "method 'openCostCenterClk'");
    view2131296571 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.openCostCenterClk(p0);
      }
    });
  }

  @Override
  public void unbind() {
    CHotelReserveActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.c_hotel_reserve_icon_conform = null;
    target.ivHotelFit = null;
    target.c_hotel_reserve_breach_guarantee = null;
    target.c_hotel_reserve_breach_guarantee_tv_type = null;
    target.c_hotel_reserve_breach_guarantee_tv_reason = null;
    target.c_new_hotel_reserve_cost_center = null;
    target.c_hotel_reserve_box_rv = null;
    target.common_hotel_reserve_sel_ll_solo = null;
    target.common_hotel_reserve_sel_ll_many = null;
    target.bTravelInfo = null;
    target.c_new_hotel_reserve_ll_customization = null;

    view2131296490.setOnClickListener(null);
    view2131296490 = null;
    view2131297005.setOnClickListener(null);
    view2131297005 = null;
    view2131296571.setOnClickListener(null);
    view2131296571 = null;

    super.unbind();
  }
}
