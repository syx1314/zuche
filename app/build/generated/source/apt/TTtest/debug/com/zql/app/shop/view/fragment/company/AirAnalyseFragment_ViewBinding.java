// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.fragment.company;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import com.zql.app.shop.util.view.CircularProgressView;
import com.zql.app.shop.util.view.CustomBarChart;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AirAnalyseFragment_ViewBinding implements Unbinder {
  private AirAnalyseFragment target;

  @UiThread
  public AirAnalyseFragment_ViewBinding(AirAnalyseFragment target, View source) {
    this.target = target;

    target.linChart = Utils.findRequiredViewAsType(source, R.id.lin_chart, "field 'linChart'", LinearLayout.class);
    target.rlTakeOffDelay = Utils.findRequiredViewAsType(source, R.id.rl_take_off_delay, "field 'rlTakeOffDelay'", RelativeLayout.class);
    target.tvAvgTakeOffTime = Utils.findRequiredViewAsType(source, R.id.tv_avg_take_off_time, "field 'tvAvgTakeOffTime'", TextView.class);
    target.airDepDelayChart = Utils.findRequiredViewAsType(source, R.id.air_dep_delay, "field 'airDepDelayChart'", CustomBarChart.class);
    target.rlArrDelay = Utils.findRequiredViewAsType(source, R.id.rl_arr_delay, "field 'rlArrDelay'", RelativeLayout.class);
    target.airArrDelayChart = Utils.findRequiredViewAsType(source, R.id.air_arr_delay, "field 'airArrDelayChart'", CustomBarChart.class);
    target.tvCicleDelayTitle = Utils.findRequiredViewAsType(source, R.id.tv_circlr_delay_title, "field 'tvCicleDelayTitle'", TextView.class);
    target.linCircleDelay = Utils.findRequiredViewAsType(source, R.id.lin_circlr_delay, "field 'linCircleDelay'", LinearLayout.class);
    target.linDepKaojin = Utils.findRequiredViewAsType(source, R.id.lin_dep_kaojin, "field 'linDepKaojin'", LinearLayout.class);
    target.linArrKaojin = Utils.findRequiredViewAsType(source, R.id.lin_arr_kaojin, "field 'linArrKaojin'", LinearLayout.class);
    target.tvAvgArrive = Utils.findRequiredViewAsType(source, R.id.tv_avg_arrive, "field 'tvAvgArrive'", TextView.class);
    target.depKaojin = Utils.findRequiredViewAsType(source, R.id.progress_dep_kaojin, "field 'depKaojin'", CircularProgressView.class);
    target.tvDepKaojin = Utils.findRequiredViewAsType(source, R.id.tv_dep_kaojin, "field 'tvDepKaojin'", TextView.class);
    target.arrKaojin = Utils.findRequiredViewAsType(source, R.id.progress_arr_kaojin, "field 'arrKaojin'", CircularProgressView.class);
    target.tvArrKaojin = Utils.findRequiredViewAsType(source, R.id.tv_arr_kaojin, "field 'tvArrKaojin'", TextView.class);
    target.tvAgeTypeTitle = Utils.findRequiredViewAsType(source, R.id.tv_age_type_title, "field 'tvAgeTypeTitle'", TextView.class);
    target.linAgeTypeContent = Utils.findRequiredViewAsType(source, R.id.lin_age_type_content, "field 'linAgeTypeContent'", LinearLayout.class);
    target.tvAirTypeCode = Utils.findRequiredViewAsType(source, R.id.tv_air_type_code, "field 'tvAirTypeCode'", TextView.class);
    target.tvAirType = Utils.findRequiredViewAsType(source, R.id.tv_air_type, "field 'tvAirType'", TextView.class);
    target.tvAirAge = Utils.findRequiredViewAsType(source, R.id.tv_air_age, "field 'tvAirAge'", TextView.class);
    target.linCabinConfig = Utils.findRequiredViewAsType(source, R.id.lin_cabin_config, "field 'linCabinConfig'", LinearLayout.class);
    target.tabCabin = Utils.findRequiredViewAsType(source, R.id.tab_cabin, "field 'tabCabin'", TabLayout.class);
    target.tvSeatAngle = Utils.findRequiredViewAsType(source, R.id.tv_seat_angle, "field 'tvSeatAngle'", TextView.class);
    target.tvSeatSpace = Utils.findRequiredViewAsType(source, R.id.tv_seat_space, "field 'tvSeatSpace'", TextView.class);
    target.tvSeatWidth = Utils.findRequiredViewAsType(source, R.id.tv_seat_width, "field 'tvSeatWidth'", TextView.class);
    target.tvMeal = Utils.findRequiredViewAsType(source, R.id.tv_meal, "field 'tvMeal'", TextView.class);
    target.tvWifi = Utils.findRequiredViewAsType(source, R.id.tv_wifi, "field 'tvWifi'", TextView.class);
    target.tvDianyuan = Utils.findRequiredViewAsType(source, R.id.tv_dianyuan, "field 'tvDianyuan'", TextView.class);
    target.tvSeatLayout = Utils.findRequiredViewAsType(source, R.id.tv_seat_layout, "field 'tvSeatLayout'", TextView.class);
    target.tvMedia = Utils.findRequiredViewAsType(source, R.id.tv_media, "field 'tvMedia'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AirAnalyseFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.linChart = null;
    target.rlTakeOffDelay = null;
    target.tvAvgTakeOffTime = null;
    target.airDepDelayChart = null;
    target.rlArrDelay = null;
    target.airArrDelayChart = null;
    target.tvCicleDelayTitle = null;
    target.linCircleDelay = null;
    target.linDepKaojin = null;
    target.linArrKaojin = null;
    target.tvAvgArrive = null;
    target.depKaojin = null;
    target.tvDepKaojin = null;
    target.arrKaojin = null;
    target.tvArrKaojin = null;
    target.tvAgeTypeTitle = null;
    target.linAgeTypeContent = null;
    target.tvAirTypeCode = null;
    target.tvAirType = null;
    target.tvAirAge = null;
    target.linCabinConfig = null;
    target.tabCabin = null;
    target.tvSeatAngle = null;
    target.tvSeatSpace = null;
    target.tvSeatWidth = null;
    target.tvMeal = null;
    target.tvWifi = null;
    target.tvDianyuan = null;
    target.tvSeatLayout = null;
    target.tvMedia = null;
  }
}
