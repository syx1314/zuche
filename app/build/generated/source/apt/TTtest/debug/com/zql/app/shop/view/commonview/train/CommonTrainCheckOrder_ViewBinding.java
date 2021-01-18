// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.commonview.train;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import com.zql.app.shop.util.view.BOldTravelInfo;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CommonTrainCheckOrder_ViewBinding implements Unbinder {
  private CommonTrainCheckOrder target;

  private View view2131297597;

  private View view2131296642;

  private View view2131296731;

  private View view2131296641;

  private View view2131296639;

  @UiThread
  public CommonTrainCheckOrder_ViewBinding(CommonTrainCheckOrder target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CommonTrainCheckOrder_ViewBinding(final CommonTrainCheckOrder target, View source) {
    this.target = target;

    View view;
    target.c_train_check_order_ll = Utils.findRequiredViewAsType(source, R.id.c_train_check_order_ll, "field 'c_train_check_order_ll'", LinearLayout.class);
    target.viewBottomLine = Utils.findRequiredView(source, R.id.view_bottom_line, "field 'viewBottomLine'");
    target.c_train_check_order_ll_ticket = Utils.findRequiredViewAsType(source, R.id.c_train_check_order_ll_ticket, "field 'c_train_check_order_ll_ticket'", LinearLayout.class);
    target.c_train_check_order_ticket_tv_passenger_num = Utils.findRequiredViewAsType(source, R.id.c_train_check_order_ticket_tv_passenger_num, "field 'c_train_check_order_ticket_tv_passenger_num'", TextView.class);
    target.linDispolicy = Utils.findRequiredViewAsType(source, R.id.lin_dispolicy, "field 'linDispolicy'", CardView.class);
    view = Utils.findRequiredView(source, R.id.et_dispolicy, "field 'etDispolicy' and method 'setEtDispolicy'");
    target.etDispolicy = Utils.castView(view, R.id.et_dispolicy, "field 'etDispolicy'", TextView.class);
    view2131297597 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.setEtDispolicy(p0);
      }
    });
    target.c_train_check_order_ticket_ll_passenger_box = Utils.findRequiredViewAsType(source, R.id.c_train_check_order_ticket_ll_passenger_box, "field 'c_train_check_order_ticket_ll_passenger_box'", LinearLayout.class);
    target.cTrainSeatLinBox = Utils.findRequiredViewAsType(source, R.id.c_train_check_order_seat, "field 'cTrainSeatLinBox'", LinearLayout.class);
    target.layoutSeatBox = Utils.findRequiredViewAsType(source, R.id.layout_seat_box, "field 'layoutSeatBox'", LinearLayout.class);
    target.lin1Seat = Utils.findRequiredViewAsType(source, R.id.lin1_seat, "field 'lin1Seat'", LinearLayout.class);
    target.ivOrderType = Utils.findRequiredViewAsType(source, R.id.iv_order_type, "field 'ivOrderType'", ImageView.class);
    target.tvSelectedSeat = Utils.findRequiredViewAsType(source, R.id.tv_selected_seat, "field 'tvSelectedSeat'", TextView.class);
    target.cb1SeatA = Utils.findRequiredViewAsType(source, R.id.cb1_seat_a, "field 'cb1SeatA'", CheckBox.class);
    target.cb1SeatB = Utils.findRequiredViewAsType(source, R.id.cb1_seat_b, "field 'cb1SeatB'", CheckBox.class);
    target.cb1SeatC = Utils.findRequiredViewAsType(source, R.id.cb1_seat_c, "field 'cb1SeatC'", CheckBox.class);
    target.cb1SeatD = Utils.findRequiredViewAsType(source, R.id.cb1_seat_d, "field 'cb1SeatD'", CheckBox.class);
    target.cb1SeatF = Utils.findRequiredViewAsType(source, R.id.cb1_seat_f, "field 'cb1SeatF'", CheckBox.class);
    target.lin2Seat = Utils.findRequiredViewAsType(source, R.id.lin2_seat, "field 'lin2Seat'", LinearLayout.class);
    target.cb2SeatA = Utils.findRequiredViewAsType(source, R.id.cb2_seat_a, "field 'cb2SeatA'", CheckBox.class);
    target.cb2SeatB = Utils.findRequiredViewAsType(source, R.id.cb2_seat_b, "field 'cb2SeatB'", CheckBox.class);
    target.cb2SeatC = Utils.findRequiredViewAsType(source, R.id.cb2_seat_c, "field 'cb2SeatC'", CheckBox.class);
    target.cb2SeatD = Utils.findRequiredViewAsType(source, R.id.cb2_seat_d, "field 'cb2SeatD'", CheckBox.class);
    target.cb2SeatF = Utils.findRequiredViewAsType(source, R.id.cb2_seat_f, "field 'cb2SeatF'", CheckBox.class);
    target.cBackTrainSeatLinBox = Utils.findRequiredViewAsType(source, R.id.c_back_train_check_order_seat, "field 'cBackTrainSeatLinBox'", LinearLayout.class);
    target.viewline1 = Utils.findRequiredView(source, R.id.view_line1, "field 'viewline1'");
    target.tvBackSelSeat = Utils.findRequiredViewAsType(source, R.id.tv_back_selected_seat, "field 'tvBackSelSeat'", TextView.class);
    target.lin1BackSeat = Utils.findRequiredViewAsType(source, R.id.lin1_back_seat, "field 'lin1BackSeat'", LinearLayout.class);
    target.cb1BackSeatA = Utils.findRequiredViewAsType(source, R.id.cb1_back_seat_a, "field 'cb1BackSeatA'", CheckBox.class);
    target.cb1BackSeatB = Utils.findRequiredViewAsType(source, R.id.cb1_back_seat_b, "field 'cb1BackSeatB'", CheckBox.class);
    target.cb1BackSeatC = Utils.findRequiredViewAsType(source, R.id.cb1_back_seat_c, "field 'cb1BackSeatC'", CheckBox.class);
    target.cb1BackSeatD = Utils.findRequiredViewAsType(source, R.id.cb1_back_seat_d, "field 'cb1BackSeatD'", CheckBox.class);
    target.cb1BackSeatF = Utils.findRequiredViewAsType(source, R.id.cb1_back_seat_f, "field 'cb1BackSeatF'", CheckBox.class);
    target.lin2BackSeat = Utils.findRequiredViewAsType(source, R.id.lin2_back_seat, "field 'lin2BackSeat'", LinearLayout.class);
    target.cb2BackSeatA = Utils.findRequiredViewAsType(source, R.id.cb2_back_seat_a, "field 'cb2BackSeatA'", CheckBox.class);
    target.cb2BackSeatB = Utils.findRequiredViewAsType(source, R.id.cb2_back_seat_b, "field 'cb2BackSeatB'", CheckBox.class);
    target.cb2BackSeatC = Utils.findRequiredViewAsType(source, R.id.cb2_back_seat_c, "field 'cb2BackSeatC'", CheckBox.class);
    target.cb2BackSeatD = Utils.findRequiredViewAsType(source, R.id.cb2_back_seat_d, "field 'cb2BackSeatD'", CheckBox.class);
    target.cb2BackSeatF = Utils.findRequiredViewAsType(source, R.id.cb2_back_seat_f, "field 'cb2BackSeatF'", CheckBox.class);
    view = Utils.findRequiredView(source, R.id.c_train_check_order_ticket_ll_contact, "field 'linContact' and method 'goPassageClk'");
    target.linContact = Utils.castView(view, R.id.c_train_check_order_ticket_ll_contact, "field 'linContact'", LinearLayout.class);
    view2131296642 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.goPassageClk(p0);
      }
    });
    target.c_train_check_order_ticket_tv_contact = Utils.findRequiredViewAsType(source, R.id.c_train_check_order_ticket_tv_contact, "field 'c_train_check_order_ticket_tv_contact'", TextView.class);
    view = Utils.findRequiredView(source, R.id.card_12306, "field 'card12306' and method 'to12306'");
    target.card12306 = Utils.castView(view, R.id.card_12306, "field 'card12306'", CardView.class);
    view2131296731 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.to12306(p0);
      }
    });
    target.tv12306 = Utils.findRequiredViewAsType(source, R.id.tv_12306, "field 'tv12306'", TextView.class);
    target.ivSelContact = Utils.findRequiredViewAsType(source, R.id.iv_sel_contact, "field 'ivSelContact'", ImageView.class);
    target.etContactPhone = Utils.findRequiredViewAsType(source, R.id.et_contact_phone, "field 'etContactPhone'", EditText.class);
    target.etContactMail = Utils.findRequiredViewAsType(source, R.id.et_contact_mail, "field 'etContactMail'", EditText.class);
    target.viewTravelInfo = Utils.findRequiredViewAsType(source, R.id.view_travel_info, "field 'viewTravelInfo'", BOldTravelInfo.class);
    target.linBz = Utils.findRequiredViewAsType(source, R.id.lin_bz, "field 'linBz'", LinearLayout.class);
    target.etBz = Utils.findRequiredViewAsType(source, R.id.et_bz, "field 'etBz'", EditText.class);
    target.c_train_check_order_ticket_tv_total_prices = Utils.findRequiredViewAsType(source, R.id.c_train_check_order_ticket_tv_total_prices, "field 'c_train_check_order_ticket_tv_total_prices'", TextView.class);
    view = Utils.findRequiredView(source, R.id.c_train_check_order_ticket_ll, "field 'c_train_check_order_ticket_ll' and method 'onOpenPriceClk'");
    target.c_train_check_order_ticket_ll = Utils.castView(view, R.id.c_train_check_order_ticket_ll, "field 'c_train_check_order_ticket_ll'", LinearLayout.class);
    view2131296641 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onOpenPriceClk(p0);
      }
    });
    target.c_train_check_order_ticket_img_up = Utils.findRequiredViewAsType(source, R.id.c_train_check_order_ticket_img_up, "field 'c_train_check_order_ticket_img_up'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.c_train_check_order_ticket_btn, "field 'c_train_check_order_ticket_btn' and method 'submitClk'");
    target.c_train_check_order_ticket_btn = Utils.castView(view, R.id.c_train_check_order_ticket_btn, "field 'c_train_check_order_ticket_btn'", TextView.class);
    view2131296639 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.submitClk(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    CommonTrainCheckOrder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.c_train_check_order_ll = null;
    target.viewBottomLine = null;
    target.c_train_check_order_ll_ticket = null;
    target.c_train_check_order_ticket_tv_passenger_num = null;
    target.linDispolicy = null;
    target.etDispolicy = null;
    target.c_train_check_order_ticket_ll_passenger_box = null;
    target.cTrainSeatLinBox = null;
    target.layoutSeatBox = null;
    target.lin1Seat = null;
    target.ivOrderType = null;
    target.tvSelectedSeat = null;
    target.cb1SeatA = null;
    target.cb1SeatB = null;
    target.cb1SeatC = null;
    target.cb1SeatD = null;
    target.cb1SeatF = null;
    target.lin2Seat = null;
    target.cb2SeatA = null;
    target.cb2SeatB = null;
    target.cb2SeatC = null;
    target.cb2SeatD = null;
    target.cb2SeatF = null;
    target.cBackTrainSeatLinBox = null;
    target.viewline1 = null;
    target.tvBackSelSeat = null;
    target.lin1BackSeat = null;
    target.cb1BackSeatA = null;
    target.cb1BackSeatB = null;
    target.cb1BackSeatC = null;
    target.cb1BackSeatD = null;
    target.cb1BackSeatF = null;
    target.lin2BackSeat = null;
    target.cb2BackSeatA = null;
    target.cb2BackSeatB = null;
    target.cb2BackSeatC = null;
    target.cb2BackSeatD = null;
    target.cb2BackSeatF = null;
    target.linContact = null;
    target.c_train_check_order_ticket_tv_contact = null;
    target.card12306 = null;
    target.tv12306 = null;
    target.ivSelContact = null;
    target.etContactPhone = null;
    target.etContactMail = null;
    target.viewTravelInfo = null;
    target.linBz = null;
    target.etBz = null;
    target.c_train_check_order_ticket_tv_total_prices = null;
    target.c_train_check_order_ticket_ll = null;
    target.c_train_check_order_ticket_img_up = null;
    target.c_train_check_order_ticket_btn = null;

    view2131297597.setOnClickListener(null);
    view2131297597 = null;
    view2131296642.setOnClickListener(null);
    view2131296642 = null;
    view2131296731.setOnClickListener(null);
    view2131296731 = null;
    view2131296641.setOnClickListener(null);
    view2131296641 = null;
    view2131296639.setOnClickListener(null);
    view2131296639 = null;
  }
}
