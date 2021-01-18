// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.company.trip;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import com.zql.app.shop.util.view.FloatScrollView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CommonTripDetailsActivity_ViewBinding implements Unbinder {
  private CommonTripDetailsActivity target;

  private View view2131298983;

  private View view2131297758;

  @UiThread
  public CommonTripDetailsActivity_ViewBinding(CommonTripDetailsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CommonTripDetailsActivity_ViewBinding(final CommonTripDetailsActivity target,
      View source) {
    this.target = target;

    View view;
    target.tvHeaderTitle = Utils.findRequiredViewAsType(source, R.id.tv_header_title, "field 'tvHeaderTitle'", TextView.class);
    target.tvSubTitle = Utils.findRequiredViewAsType(source, R.id.tv_sub_title, "field 'tvSubTitle'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_contact_kf, "field 'tvContactKf' and method 'onViewClicked'");
    target.tvContactKf = Utils.castView(view, R.id.tv_contact_kf, "field 'tvContactKf'", TextView.class);
    view2131298983 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.tvOrderDetails = Utils.findRequiredViewAsType(source, R.id.tv_order_details, "field 'tvOrderDetails'", TextView.class);
    target.tvTips = Utils.findRequiredViewAsType(source, R.id.tv_tips, "field 'tvTips'", TextView.class);
    target.rlTips = Utils.findRequiredViewAsType(source, R.id.rl_tips, "field 'rlTips'", RelativeLayout.class);
    target.rlContent = Utils.findRequiredViewAsType(source, R.id.rl_content, "field 'rlContent'", LinearLayout.class);
    target.linContent2 = Utils.findRequiredViewAsType(source, R.id.lin_content2, "field 'linContent2'", LinearLayout.class);
    target.tvStartFlag = Utils.findRequiredViewAsType(source, R.id.tv_start_flag, "field 'tvStartFlag'", TextView.class);
    target.tvStartCity = Utils.findRequiredViewAsType(source, R.id.tv_start_city, "field 'tvStartCity'", TextView.class);
    target.ivWeatherImg = Utils.findRequiredViewAsType(source, R.id.iv_weather_img, "field 'ivWeatherImg'", ImageView.class);
    target.tvTemperature = Utils.findRequiredViewAsType(source, R.id.tv_temperature, "field 'tvTemperature'", TextView.class);
    target.tvWeather = Utils.findRequiredViewAsType(source, R.id.tv_weather, "field 'tvWeather'", TextView.class);
    target.tvPmTitle = Utils.findRequiredViewAsType(source, R.id.tv_pm_title, "field 'tvPmTitle'", TextView.class);
    target.tvNengjianduTitle = Utils.findRequiredViewAsType(source, R.id.tv_nengjiandu_title, "field 'tvNengjianduTitle'", TextView.class);
    target.rlStartAddress = Utils.findRequiredViewAsType(source, R.id.rl_start_address, "field 'rlStartAddress'", RelativeLayout.class);
    target.tvEndFlag = Utils.findRequiredViewAsType(source, R.id.tv_end_flag, "field 'tvEndFlag'", TextView.class);
    target.tvEndCity = Utils.findRequiredViewAsType(source, R.id.tv_end_city, "field 'tvEndCity'", TextView.class);
    target.ivEndWeatherImg = Utils.findRequiredViewAsType(source, R.id.iv_end_weather_img, "field 'ivEndWeatherImg'", ImageView.class);
    target.tvEndTemperature = Utils.findRequiredViewAsType(source, R.id.tv_end_temperature, "field 'tvEndTemperature'", TextView.class);
    target.tvEndWeather = Utils.findRequiredViewAsType(source, R.id.tv_end_weather, "field 'tvEndWeather'", TextView.class);
    target.tvEndPmTitle = Utils.findRequiredViewAsType(source, R.id.tv_end_pm_title, "field 'tvEndPmTitle'", TextView.class);
    target.tvEndNengjianduTitle = Utils.findRequiredViewAsType(source, R.id.tv_end_nengjiandu_title, "field 'tvEndNengjianduTitle'", TextView.class);
    target.rlEndAddress = Utils.findRequiredViewAsType(source, R.id.rl_end_address, "field 'rlEndAddress'", RelativeLayout.class);
    view = Utils.findRequiredView(source, R.id.iv_back, "field 'ivBack' and method 'back'");
    target.ivBack = Utils.castView(view, R.id.iv_back, "field 'ivBack'", ImageView.class);
    view2131297758 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.back(p0);
      }
    });
    target.ivLogo = Utils.findRequiredViewAsType(source, R.id.iv_logo, "field 'ivLogo'", ImageView.class);
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.tvCheckStatus = Utils.findRequiredViewAsType(source, R.id.tv_check_status, "field 'tvCheckStatus'", TextView.class);
    target.linCheckInTips = Utils.findRequiredViewAsType(source, R.id.lin_check_in_tips, "field 'linCheckInTips'", LinearLayout.class);
    target.tvStartAirport = Utils.findRequiredViewAsType(source, R.id.tv_start_airport, "field 'tvStartAirport'", TextView.class);
    target.tvArriveAirport = Utils.findRequiredViewAsType(source, R.id.tv_arrive_airport, "field 'tvArriveAirport'", TextView.class);
    target.tvExpectedTakeOff = Utils.findRequiredViewAsType(source, R.id.tv_expected_take_off, "field 'tvExpectedTakeOff'", TextView.class);
    target.tvStartTime = Utils.findRequiredViewAsType(source, R.id.tv_start_time, "field 'tvStartTime'", TextView.class);
    target.tvStartPlan = Utils.findRequiredViewAsType(source, R.id.tv_start_plan, "field 'tvStartPlan'", TextView.class);
    target.tvArriveTime = Utils.findRequiredViewAsType(source, R.id.tv_arrive_time, "field 'tvArriveTime'", TextView.class);
    target.tvAddDay = Utils.findRequiredViewAsType(source, R.id.tv_add_day, "field 'tvAddDay'", TextView.class);
    target.tvArrivePlan = Utils.findRequiredViewAsType(source, R.id.tv_arrive_plan, "field 'tvArrivePlan'", TextView.class);
    target.tvStopCity = Utils.findRequiredViewAsType(source, R.id.tv_stop_city, "field 'tvStopCity'", TextView.class);
    target.viewDivider1 = Utils.findRequiredView(source, R.id.view_divider1, "field 'viewDivider1'");
    target.tvTicketNum = Utils.findRequiredViewAsType(source, R.id.tv_ticket_num, "field 'tvTicketNum'", TextView.class);
    target.viewDivider2 = Utils.findRequiredView(source, R.id.view_divider2, "field 'viewDivider2'");
    target.tvCabinTitle = Utils.findRequiredViewAsType(source, R.id.tv_cabin_title, "field 'tvCabinTitle'", TextView.class);
    target.tvCabinName = Utils.findRequiredViewAsType(source, R.id.tv_cabin_name, "field 'tvCabinName'", TextView.class);
    target.tvMealTitle = Utils.findRequiredViewAsType(source, R.id.tv_meal_title, "field 'tvMealTitle'", TextView.class);
    target.tvMeal = Utils.findRequiredViewAsType(source, R.id.tv_meal, "field 'tvMeal'", TextView.class);
    target.tvArriveRateTitle = Utils.findRequiredViewAsType(source, R.id.tv_arrive_rate_title, "field 'tvArriveRateTitle'", TextView.class);
    target.tvArriveRate = Utils.findRequiredViewAsType(source, R.id.tv_arrive_rate, "field 'tvArriveRate'", TextView.class);
    target.viewDivider3 = Utils.findRequiredView(source, R.id.view_divider3, "field 'viewDivider3'");
    target.tvCheckInCounterTitle = Utils.findRequiredViewAsType(source, R.id.tv_check_in_counter_title, "field 'tvCheckInCounterTitle'", TextView.class);
    target.tvCheckInCounter = Utils.findRequiredViewAsType(source, R.id.tv_check_in_counter, "field 'tvCheckInCounter'", TextView.class);
    target.tvDepartureGateTitle = Utils.findRequiredViewAsType(source, R.id.tv_departure_gate_title, "field 'tvDepartureGateTitle'", TextView.class);
    target.tvDepartureGate = Utils.findRequiredViewAsType(source, R.id.tv_departure_gate, "field 'tvDepartureGate'", TextView.class);
    target.tvLuggageCarouselTitle = Utils.findRequiredViewAsType(source, R.id.tv_luggage_carousel_title, "field 'tvLuggageCarouselTitle'", TextView.class);
    target.tvLuggageCarousel = Utils.findRequiredViewAsType(source, R.id.tv_luggage_carousel, "field 'tvLuggageCarousel'", TextView.class);
    target.tvPrecedingFlightTitle = Utils.findRequiredViewAsType(source, R.id.tv_preceding_flight_title, "field 'tvPrecedingFlightTitle'", TextView.class);
    target.tvPrecedingFlight = Utils.findRequiredViewAsType(source, R.id.tv_preceding_flight, "field 'tvPrecedingFlight'", TextView.class);
    target.rlFlostTitle = Utils.findRequiredViewAsType(source, R.id.rl_float_title, "field 'rlFlostTitle'", RelativeLayout.class);
    target.scrollView = Utils.findRequiredViewAsType(source, R.id.sv, "field 'scrollView'", FloatScrollView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CommonTripDetailsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvHeaderTitle = null;
    target.tvSubTitle = null;
    target.tvContactKf = null;
    target.tvOrderDetails = null;
    target.tvTips = null;
    target.rlTips = null;
    target.rlContent = null;
    target.linContent2 = null;
    target.tvStartFlag = null;
    target.tvStartCity = null;
    target.ivWeatherImg = null;
    target.tvTemperature = null;
    target.tvWeather = null;
    target.tvPmTitle = null;
    target.tvNengjianduTitle = null;
    target.rlStartAddress = null;
    target.tvEndFlag = null;
    target.tvEndCity = null;
    target.ivEndWeatherImg = null;
    target.tvEndTemperature = null;
    target.tvEndWeather = null;
    target.tvEndPmTitle = null;
    target.tvEndNengjianduTitle = null;
    target.rlEndAddress = null;
    target.ivBack = null;
    target.ivLogo = null;
    target.tvTitle = null;
    target.tvCheckStatus = null;
    target.linCheckInTips = null;
    target.tvStartAirport = null;
    target.tvArriveAirport = null;
    target.tvExpectedTakeOff = null;
    target.tvStartTime = null;
    target.tvStartPlan = null;
    target.tvArriveTime = null;
    target.tvAddDay = null;
    target.tvArrivePlan = null;
    target.tvStopCity = null;
    target.viewDivider1 = null;
    target.tvTicketNum = null;
    target.viewDivider2 = null;
    target.tvCabinTitle = null;
    target.tvCabinName = null;
    target.tvMealTitle = null;
    target.tvMeal = null;
    target.tvArriveRateTitle = null;
    target.tvArriveRate = null;
    target.viewDivider3 = null;
    target.tvCheckInCounterTitle = null;
    target.tvCheckInCounter = null;
    target.tvDepartureGateTitle = null;
    target.tvDepartureGate = null;
    target.tvLuggageCarouselTitle = null;
    target.tvLuggageCarousel = null;
    target.tvPrecedingFlightTitle = null;
    target.tvPrecedingFlight = null;
    target.rlFlostTitle = null;
    target.scrollView = null;

    view2131298983.setOnClickListener(null);
    view2131298983 = null;
    view2131297758.setOnClickListener(null);
    view2131297758 = null;
  }
}
