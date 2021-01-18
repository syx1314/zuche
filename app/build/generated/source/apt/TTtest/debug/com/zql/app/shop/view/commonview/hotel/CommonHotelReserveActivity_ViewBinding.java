// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.commonview.hotel;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import com.zql.app.shop.util.view.CommonTitleView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CommonHotelReserveActivity_ViewBinding implements Unbinder {
  private CommonHotelReserveActivity target;

  private View view2131297003;

  private View view2131298927;

  private View view2131299371;

  private View view2131297016;

  private View view2131297001;

  private View view2131298073;

  private View view2131297002;

  private View view2131298055;

  @UiThread
  public CommonHotelReserveActivity_ViewBinding(CommonHotelReserveActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CommonHotelReserveActivity_ViewBinding(final CommonHotelReserveActivity target,
      View source) {
    this.target = target;

    View view;
    target.rl = Utils.findRequiredViewAsType(source, R.id.c_hotel_reserve, "field 'rl'", LinearLayout.class);
    target.common_hotel_reserve_header = Utils.findRequiredViewAsType(source, R.id.common_hotel_reserve_header, "field 'common_hotel_reserve_header'", CommonTitleView.class);
    target.common_hotel_reserve_tv_total_prices = Utils.findRequiredViewAsType(source, R.id.common_hotel_reserve_tv_total_prices, "field 'common_hotel_reserve_tv_total_prices'", TextView.class);
    target.common_hotel_reserve_img_top = Utils.findRequiredViewAsType(source, R.id.common_hotel_reserve_img_top, "field 'common_hotel_reserve_img_top'", ImageView.class);
    target.hotelRoomNameView = Utils.findRequiredViewAsType(source, R.id.common_hotel_reserve_tv_name, "field 'hotelRoomNameView'", TextView.class);
    target.tvGuarantee = Utils.findRequiredViewAsType(source, R.id.tv_guarantee, "field 'tvGuarantee'", TextView.class);
    target.tvCompanyAgreement = Utils.findRequiredViewAsType(source, R.id.tv_company_agreement, "field 'tvCompanyAgreement'", TextView.class);
    target.ivCompanyLogo = Utils.findRequiredViewAsType(source, R.id.iv_company_logo, "field 'ivCompanyLogo'", ImageView.class);
    target.tvTbiAgreement = Utils.findRequiredViewAsType(source, R.id.tv_tbi_agreement, "field 'tvTbiAgreement'", TextView.class);
    target.hotelStartDate = Utils.findRequiredViewAsType(source, R.id.common_hotel_reserve_tv_start, "field 'hotelStartDate'", TextView.class);
    target.hotelEndDate = Utils.findRequiredViewAsType(source, R.id.common_hotel_reserve_tv_end, "field 'hotelEndDate'", TextView.class);
    target.common_hotel_reserve_tv_night = Utils.findRequiredViewAsType(source, R.id.common_hotel_reserve_tv_night, "field 'common_hotel_reserve_tv_night'", TextView.class);
    target.includeBreakfastView = Utils.findRequiredViewAsType(source, R.id.common_hotel_reserve_tv_morning, "field 'includeBreakfastView'", TextView.class);
    target.bedTypeView = Utils.findRequiredViewAsType(source, R.id.common_hotel_reserve_tv_bed, "field 'bedTypeView'", TextView.class);
    target.averagePriceView = Utils.findRequiredViewAsType(source, R.id.common_hotel_reserve_tv_price, "field 'averagePriceView'", TextView.class);
    target.showPriceView = Utils.findRequiredViewAsType(source, R.id.common_hotel_reserve_rl_total, "field 'showPriceView'", LinearLayout.class);
    target.ivPriceDetails = Utils.findRequiredViewAsType(source, R.id.iv_price_details, "field 'ivPriceDetails'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.common_hotel_reserve_btn_next, "field 'nextStepButton' and method 'hotelReserveNextStepClk'");
    target.nextStepButton = Utils.castView(view, R.id.common_hotel_reserve_btn_next, "field 'nextStepButton'", TextView.class);
    view2131297003 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.hotelReserveNextStepClk(p0);
      }
    });
    target.common_hotel_reserve_contact_et_name = Utils.findRequiredViewAsType(source, R.id.common_hotel_reserve_contact_et_name, "field 'common_hotel_reserve_contact_et_name'", TextView.class);
    target.ivSelContact = Utils.findRequiredViewAsType(source, R.id.iv_sel_contact, "field 'ivSelContact'", ImageView.class);
    target.common_hotel_reserve_contact_et_tel = Utils.findRequiredViewAsType(source, R.id.common_hotel_reserve_contact_et_tel, "field 'common_hotel_reserve_contact_et_tel'", EditText.class);
    target.c_hotel_reserve_contact_et_email = Utils.findRequiredViewAsType(source, R.id.c_hotel_reserve_contact_et_email, "field 'c_hotel_reserve_contact_et_email'", EditText.class);
    target.common_hotel_reserve_sel_tv_special = Utils.findRequiredViewAsType(source, R.id.common_hotel_reserve_sel_tv_special, "field 'common_hotel_reserve_sel_tv_special'", TextView.class);
    target.common_hotel_reserve_sel_tv_latest = Utils.findRequiredViewAsType(source, R.id.common_hotel_reserve_sel_tv_latest, "field 'common_hotel_reserve_sel_tv_latest'", TextView.class);
    target.guaranteeLinear = Utils.findRequiredViewAsType(source, R.id.common_hotel_reserve_guarantee, "field 'guaranteeLinear'", LinearLayout.class);
    target.guaranteeView = Utils.findRequiredViewAsType(source, R.id.common_hotel_reserve_tv_guarantee, "field 'guaranteeView'", TextView.class);
    target.roomsNumber = Utils.findRequiredViewAsType(source, R.id.common_hotel_reserve_sel_tv_room_num, "field 'roomsNumber'", TextView.class);
    target.etBz = Utils.findRequiredViewAsType(source, R.id.et_bz, "field 'etBz'", EditText.class);
    view = Utils.findRequiredView(source, R.id.tv_cancel_zhengce, "field 'tvCancelZhengce' and method 'cancelZhengce'");
    target.tvCancelZhengce = Utils.castView(view, R.id.tv_cancel_zhengce, "field 'tvCancelZhengce'", TextView.class);
    view2131298927 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.cancelZhengce(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_share_way, "field 'tvShareWay' and method 'roomPriceShareWay'");
    target.tvShareWay = Utils.castView(view, R.id.tv_share_way, "field 'tvShareWay'", TextView.class);
    view2131299371 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.roomPriceShareWay(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.common_hotel_reserve_sel_ll_room, "method 'roomsNumberClk'");
    view2131297016 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.roomsNumberClk(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.common_hotel_reserve_box_ll_latest, "method 'reserveBox_LatestClk'");
    view2131297001 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.reserveBox_LatestClk(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lin_room_price_share, "method 'roomPriceShareWay'");
    view2131298073 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.roomPriceShareWay(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.common_hotel_reserve_box_ll_special, "method 'reserveBoxSpecialClk'");
    view2131297002 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.reserveBoxSpecialClk(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lin_price_details, "method 'priceDetials'");
    view2131298055 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.priceDetials(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    CommonHotelReserveActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rl = null;
    target.common_hotel_reserve_header = null;
    target.common_hotel_reserve_tv_total_prices = null;
    target.common_hotel_reserve_img_top = null;
    target.hotelRoomNameView = null;
    target.tvGuarantee = null;
    target.tvCompanyAgreement = null;
    target.ivCompanyLogo = null;
    target.tvTbiAgreement = null;
    target.hotelStartDate = null;
    target.hotelEndDate = null;
    target.common_hotel_reserve_tv_night = null;
    target.includeBreakfastView = null;
    target.bedTypeView = null;
    target.averagePriceView = null;
    target.showPriceView = null;
    target.ivPriceDetails = null;
    target.nextStepButton = null;
    target.common_hotel_reserve_contact_et_name = null;
    target.ivSelContact = null;
    target.common_hotel_reserve_contact_et_tel = null;
    target.c_hotel_reserve_contact_et_email = null;
    target.common_hotel_reserve_sel_tv_special = null;
    target.common_hotel_reserve_sel_tv_latest = null;
    target.guaranteeLinear = null;
    target.guaranteeView = null;
    target.roomsNumber = null;
    target.etBz = null;
    target.tvCancelZhengce = null;
    target.tvShareWay = null;

    view2131297003.setOnClickListener(null);
    view2131297003 = null;
    view2131298927.setOnClickListener(null);
    view2131298927 = null;
    view2131299371.setOnClickListener(null);
    view2131299371 = null;
    view2131297016.setOnClickListener(null);
    view2131297016 = null;
    view2131297001.setOnClickListener(null);
    view2131297001 = null;
    view2131298073.setOnClickListener(null);
    view2131298073 = null;
    view2131297002.setOnClickListener(null);
    view2131297002 = null;
    view2131298055.setOnClickListener(null);
    view2131298055 = null;
  }
}
