// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.company.user;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.zql.app.shop.R;
import com.zql.app.shop.util.view.FloatScrollView;
import com.zql.app.shop.util.view.MoreCircleView;
import com.zql.app.shop.util.view.MyHorizontalBarChart;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CompanyReportActivity_ViewBinding implements Unbinder {
  private CompanyReportActivity target;

  private View view2131298951;

  private View view2131299013;

  @UiThread
  public CompanyReportActivity_ViewBinding(CompanyReportActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CompanyReportActivity_ViewBinding(final CompanyReportActivity target, View source) {
    this.target = target;

    View view;
    target.floatSv = Utils.findRequiredViewAsType(source, R.id.floatSv, "field 'floatSv'", FloatScrollView.class);
    target.linFloatTitle = Utils.findRequiredViewAsType(source, R.id.lin_float_title, "field 'linFloatTitle'", LinearLayout.class);
    target.linBaobiao = Utils.findRequiredViewAsType(source, R.id.lin_baobiao, "field 'linBaobiao'", LinearLayout.class);
    target.linChalv = Utils.findRequiredViewAsType(source, R.id.lin_chalv, "field 'linChalv'", LinearLayout.class);
    target.tvReportTips = Utils.findRequiredViewAsType(source, R.id.tv_report_tips, "field 'tvReportTips'", TextView.class);
    target.rgTab = Utils.findRequiredViewAsType(source, R.id.rg_tab, "field 'rgTab'", RadioGroup.class);
    target.tvFloatTitle = Utils.findRequiredViewAsType(source, R.id.tv_float_title, "field 'tvFloatTitle'", TextView.class);
    target.chartChailv = Utils.findRequiredViewAsType(source, R.id.chart_chailv, "field 'chartChailv'", PieChart.class);
    target.tvChailvHomeAir = Utils.findRequiredViewAsType(source, R.id.tv_chailv_home_air, "field 'tvChailvHomeAir'", TextView.class);
    target.tvChailvInterAir = Utils.findRequiredViewAsType(source, R.id.tv_chailv_inter_air, "field 'tvChailvInterAir'", TextView.class);
    target.tvChailvHotel = Utils.findRequiredViewAsType(source, R.id.tv_chailv_hotel, "field 'tvChailvHotel'", TextView.class);
    target.tvChailvTrain = Utils.findRequiredViewAsType(source, R.id.tv_chailv_train, "field 'tvChailvTrain'", TextView.class);
    target.tvChailvCar = Utils.findRequiredViewAsType(source, R.id.tv_chailv_car, "field 'tvChailvCar'", TextView.class);
    target.linAirCompany = Utils.findRequiredViewAsType(source, R.id.lin_air_company, "field 'linAirCompany'", LinearLayout.class);
    target.chartBarAirlineCompanyPurchases = Utils.findRequiredViewAsType(source, R.id.chart_bar_airline_company_purchases, "field 'chartBarAirlineCompanyPurchases'", BarChart.class);
    target.chartPieAirlineCompanyPurchases = Utils.findRequiredViewAsType(source, R.id.chart_pie_airline_company_purchases, "field 'chartPieAirlineCompanyPurchases'", PieChart.class);
    target.linAirline = Utils.findRequiredViewAsType(source, R.id.lin_airline, "field 'linAirline'", LinearLayout.class);
    target.chartHorizontalBarAirlinePurchases = Utils.findRequiredViewAsType(source, R.id.chart_horizontalBar_airline_purchases, "field 'chartHorizontalBarAirlinePurchases'", MyHorizontalBarChart.class);
    target.chartPieAirlinePurchases = Utils.findRequiredViewAsType(source, R.id.chart_pie_airline_purchases, "field 'chartPieAirlinePurchases'", PieChart.class);
    target.linHotel = Utils.findRequiredViewAsType(source, R.id.lin_hotel, "field 'linHotel'", LinearLayout.class);
    target.chartBarHotelPurchases = Utils.findRequiredViewAsType(source, R.id.chart_bar_hotel_purchases, "field 'chartBarHotelPurchases'", BarChart.class);
    target.chartPieHotelPurchases = Utils.findRequiredViewAsType(source, R.id.chart_pie_hotel_purchases, "field 'chartPieHotelPurchases'", PieChart.class);
    target.linTrain = Utils.findRequiredViewAsType(source, R.id.lin_train, "field 'linTrain'", LinearLayout.class);
    target.chartBarTrainPurchases = Utils.findRequiredViewAsType(source, R.id.chart_bar_train_purchases, "field 'chartBarTrainPurchases'", BarChart.class);
    target.chartPieTrainPurchases = Utils.findRequiredViewAsType(source, R.id.chart_pie_train_purchases, "field 'chartPieTrainPurchases'", PieChart.class);
    target.tvChalvTitle = Utils.findRequiredViewAsType(source, R.id.tv_chalv_title, "field 'tvChalvTitle'", TextView.class);
    target.linPurchases = Utils.findRequiredViewAsType(source, R.id.lin_purchases, "field 'linPurchases'", LinearLayout.class);
    target.tvPurchasesTitle = Utils.findRequiredViewAsType(source, R.id.tv_purchases_title, "field 'tvPurchasesTitle'", TextView.class);
    target.tvAgreementUseTitle = Utils.findRequiredViewAsType(source, R.id.tv_agreement_use_title, "field 'tvAgreementUseTitle'", TextView.class);
    target.tvApproveRateTitle = Utils.findRequiredViewAsType(source, R.id.tv_approve_rate_title, "field 'tvApproveRateTitle'", TextView.class);
    target.tvAirAdvanceRateTitle = Utils.findRequiredViewAsType(source, R.id.tv_air_advance_rate_title, "field 'tvAirAdvanceRateTitle'", TextView.class);
    target.tvCoseSaveTitle = Utils.findRequiredViewAsType(source, R.id.tv_cose_save_title, "field 'tvCoseSaveTitle'", TextView.class);
    target.linAgreement = Utils.findRequiredViewAsType(source, R.id.lin_agreement, "field 'linAgreement'", LinearLayout.class);
    target.linApprove = Utils.findRequiredViewAsType(source, R.id.lin_approve, "field 'linApprove'", LinearLayout.class);
    target.linApproveContent = Utils.findRequiredViewAsType(source, R.id.lin_approve_content, "field 'linApproveContent'", LinearLayout.class);
    target.linAirAdvance = Utils.findRequiredViewAsType(source, R.id.lin_air_advance, "field 'linAirAdvance'", LinearLayout.class);
    target.linAirAdvanceContent = Utils.findRequiredViewAsType(source, R.id.lin_air_advance_rate_content, "field 'linAirAdvanceContent'", LinearLayout.class);
    target.linCose = Utils.findRequiredViewAsType(source, R.id.lin_cose, "field 'linCose'", LinearLayout.class);
    target.tvTotalTrade = Utils.findRequiredViewAsType(source, R.id.tv_total_trade, "field 'tvTotalTrade'", TextView.class);
    target.tvMarketvalue = Utils.findRequiredViewAsType(source, R.id.tv_market_value, "field 'tvMarketvalue'", TextView.class);
    target.tvTotalSave = Utils.findRequiredViewAsType(source, R.id.tv_total_save, "field 'tvTotalSave'", TextView.class);
    target.linAirAgreement = Utils.findRequiredViewAsType(source, R.id.lin_air_agreement, "field 'linAirAgreement'", LinearLayout.class);
    target.viewCircleAirTotal = Utils.findRequiredViewAsType(source, R.id.view_circle_air_total, "field 'viewCircleAirTotal'", MoreCircleView.class);
    target.viewAgreeCircleAirTotal = Utils.findRequiredViewAsType(source, R.id.view_agree_circle_air_total, "field 'viewAgreeCircleAirTotal'", MoreCircleView.class);
    target.viewNoagreeCircleAirTotal = Utils.findRequiredViewAsType(source, R.id.view_noagree_circle_air_total, "field 'viewNoagreeCircleAirTotal'", MoreCircleView.class);
    target.tvAirZhang = Utils.findRequiredViewAsType(source, R.id.tv_air_zhang, "field 'tvAirZhang'", TextView.class);
    target.tvAgreeementZhang = Utils.findRequiredViewAsType(source, R.id.tv_agreeement_zhang, "field 'tvAgreeementZhang'", TextView.class);
    target.tvNoAgreeementZhang = Utils.findRequiredViewAsType(source, R.id.tv_no_agreeement_zhang, "field 'tvNoAgreeementZhang'", TextView.class);
    target.rlHotelAgreement = Utils.findRequiredViewAsType(source, R.id.rl_hotel_agreement, "field 'rlHotelAgreement'", RelativeLayout.class);
    target.tvHotelJian = Utils.findRequiredViewAsType(source, R.id.tv_hotel_jian, "field 'tvHotelJian'", TextView.class);
    target.tvHotelAgreeementJian = Utils.findRequiredViewAsType(source, R.id.tv_hotel_agreeement_jian, "field 'tvHotelAgreeementJian'", TextView.class);
    target.tvHotelNoAgreeementJian = Utils.findRequiredViewAsType(source, R.id.tv_hotel_no_agreeement_jian, "field 'tvHotelNoAgreeementJian'", TextView.class);
    target.viewCircleHotelTotal = Utils.findRequiredViewAsType(source, R.id.view_circle_hotel_total, "field 'viewCircleHotelTotal'", MoreCircleView.class);
    target.viewAgreeCircleHotelTotal = Utils.findRequiredViewAsType(source, R.id.view_agree_circle_hotel_total, "field 'viewAgreeCircleHotelTotal'", MoreCircleView.class);
    target.viewNoagreeCircleHotelTotal = Utils.findRequiredViewAsType(source, R.id.view_noagree_circle_hotel_total, "field 'viewNoagreeCircleHotelTotal'", MoreCircleView.class);
    target.linNoFit = Utils.findRequiredViewAsType(source, R.id.lin_no_fit, "field 'linNoFit'", LinearLayout.class);
    target.tvNoFitTitle = Utils.findRequiredViewAsType(source, R.id.tv_no_fit_title, "field 'tvNoFitTitle'", TextView.class);
    target.linNofitOrder = Utils.findRequiredViewAsType(source, R.id.lin_no_fit_order, "field 'linNofitOrder'", LinearLayout.class);
    target.tvNofitOrder = Utils.findRequiredViewAsType(source, R.id.tv_no_fit_order, "field 'tvNofitOrder'", TextView.class);
    target.linNoFitOrderContent = Utils.findRequiredViewAsType(source, R.id.lin_no_fit_order_content, "field 'linNoFitOrderContent'", LinearLayout.class);
    target.linNofitPrice = Utils.findRequiredViewAsType(source, R.id.lin_no_fit_price, "field 'linNofitPrice'", LinearLayout.class);
    target.tvNoFitPrice = Utils.findRequiredViewAsType(source, R.id.tv_no_fit_price, "field 'tvNoFitPrice'", TextView.class);
    target.linNoFitPriceContent = Utils.findRequiredViewAsType(source, R.id.lin_no_fit_price_content, "field 'linNoFitPriceContent'", LinearLayout.class);
    target.linReportTitle = Utils.findRequiredViewAsType(source, R.id.lin_company_report_title, "field 'linReportTitle'", LinearLayout.class);
    target.tvReportTitle = Utils.findRequiredViewAsType(source, R.id.tv_report_title, "field 'tvReportTitle'", TextView.class);
    target.tvReportTime = Utils.findRequiredViewAsType(source, R.id.tv_report_time, "field 'tvReportTime'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_chart_list, "method 'chartList'");
    view2131298951 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.chartList(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_download, "method 'downLoad'");
    view2131299013 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.downLoad(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    CompanyReportActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.floatSv = null;
    target.linFloatTitle = null;
    target.linBaobiao = null;
    target.linChalv = null;
    target.tvReportTips = null;
    target.rgTab = null;
    target.tvFloatTitle = null;
    target.chartChailv = null;
    target.tvChailvHomeAir = null;
    target.tvChailvInterAir = null;
    target.tvChailvHotel = null;
    target.tvChailvTrain = null;
    target.tvChailvCar = null;
    target.linAirCompany = null;
    target.chartBarAirlineCompanyPurchases = null;
    target.chartPieAirlineCompanyPurchases = null;
    target.linAirline = null;
    target.chartHorizontalBarAirlinePurchases = null;
    target.chartPieAirlinePurchases = null;
    target.linHotel = null;
    target.chartBarHotelPurchases = null;
    target.chartPieHotelPurchases = null;
    target.linTrain = null;
    target.chartBarTrainPurchases = null;
    target.chartPieTrainPurchases = null;
    target.tvChalvTitle = null;
    target.linPurchases = null;
    target.tvPurchasesTitle = null;
    target.tvAgreementUseTitle = null;
    target.tvApproveRateTitle = null;
    target.tvAirAdvanceRateTitle = null;
    target.tvCoseSaveTitle = null;
    target.linAgreement = null;
    target.linApprove = null;
    target.linApproveContent = null;
    target.linAirAdvance = null;
    target.linAirAdvanceContent = null;
    target.linCose = null;
    target.tvTotalTrade = null;
    target.tvMarketvalue = null;
    target.tvTotalSave = null;
    target.linAirAgreement = null;
    target.viewCircleAirTotal = null;
    target.viewAgreeCircleAirTotal = null;
    target.viewNoagreeCircleAirTotal = null;
    target.tvAirZhang = null;
    target.tvAgreeementZhang = null;
    target.tvNoAgreeementZhang = null;
    target.rlHotelAgreement = null;
    target.tvHotelJian = null;
    target.tvHotelAgreeementJian = null;
    target.tvHotelNoAgreeementJian = null;
    target.viewCircleHotelTotal = null;
    target.viewAgreeCircleHotelTotal = null;
    target.viewNoagreeCircleHotelTotal = null;
    target.linNoFit = null;
    target.tvNoFitTitle = null;
    target.linNofitOrder = null;
    target.tvNofitOrder = null;
    target.linNoFitOrderContent = null;
    target.linNofitPrice = null;
    target.tvNoFitPrice = null;
    target.linNoFitPriceContent = null;
    target.linReportTitle = null;
    target.tvReportTitle = null;
    target.tvReportTime = null;

    view2131298951.setOnClickListener(null);
    view2131298951 = null;
    view2131299013.setOnClickListener(null);
    view2131299013 = null;
  }
}
