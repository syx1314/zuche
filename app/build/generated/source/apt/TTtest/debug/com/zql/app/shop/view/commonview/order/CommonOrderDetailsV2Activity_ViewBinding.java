// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.commonview.order;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import com.zql.app.shop.core.MyCommonRefreshActivity_ViewBinding;
import com.zql.app.shop.util.view.CommonTitleView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CommonOrderDetailsV2Activity_ViewBinding extends MyCommonRefreshActivity_ViewBinding {
  private CommonOrderDetailsV2Activity target;

  private View view2131299364;

  private View view2131298923;

  private View view2131298922;

  private View view2131298921;

  private View view2131299448;

  private View view2131299321;

  private View view2131299322;

  private View view2131298925;

  private View view2131298926;

  private View view2131299460;

  private View view2131298053;

  @UiThread
  public CommonOrderDetailsV2Activity_ViewBinding(CommonOrderDetailsV2Activity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CommonOrderDetailsV2Activity_ViewBinding(final CommonOrderDetailsV2Activity target,
      View source) {
    super(target, source);

    this.target = target;

    View view;
    target.rl = Utils.findRequiredViewAsType(source, R.id.rl, "field 'rl'", RelativeLayout.class);
    target.title = Utils.findRequiredViewAsType(source, R.id.ct_title, "field 'title'", CommonTitleView.class);
    view = Utils.findRequiredView(source, R.id.tv_send_approve, "field 'tvSendApprove' and method 'sendApprove'");
    target.tvSendApprove = Utils.castView(view, R.id.tv_send_approve, "field 'tvSendApprove'", TextView.class);
    view2131299364 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.sendApprove(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_cancel_order, "field 'tvCancelOrder' and method 'cancelOrder'");
    target.tvCancelOrder = Utils.castView(view, R.id.tv_cancel_order, "field 'tvCancelOrder'", TextView.class);
    view2131298923 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.cancelOrder(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_cancel_approve, "field 'tvCancelApprove' and method 'cancelApprove'");
    target.tvCancelApprove = Utils.castView(view, R.id.tv_cancel_approve, "field 'tvCancelApprove'", TextView.class);
    view2131298922 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.cancelApprove(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_cancel_apply, "field 'tvCancelApply' and method 'cancelApply'");
    target.tvCancelApply = Utils.castView(view, R.id.tv_cancel_apply, "field 'tvCancelApply'", TextView.class);
    view2131298921 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.cancelApply(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_train_cancel_status, "field 'tvTeainCancelStatus' and method 'cancelTicket'");
    target.tvTeainCancelStatus = Utils.castView(view, R.id.tv_train_cancel_status, "field 'tvTeainCancelStatus'", TextView.class);
    view2131299448 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.cancelTicket(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_retreat, "field 'tvRetreat' and method 'retreat'");
    target.tvRetreat = Utils.castView(view, R.id.tv_retreat, "field 'tvRetreat'", TextView.class);
    view2131299321 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.retreat(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_retreat0, "field 'tvRetreat0' and method 'retreat'");
    target.tvRetreat0 = Utils.castView(view, R.id.tv_retreat0, "field 'tvRetreat0'", TextView.class);
    view2131299322 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.retreat(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_cancel_ticket, "field 'tvCancelTicket' and method 'cancelTicket'");
    target.tvCancelTicket = Utils.castView(view, R.id.tv_cancel_ticket, "field 'tvCancelTicket'", TextView.class);
    view2131298925 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.cancelTicket(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_cancel_ticket0, "field 'tvCancelTicket0' and method 'cancelTicket'");
    target.tvCancelTicket0 = Utils.castView(view, R.id.tv_cancel_ticket0, "field 'tvCancelTicket0'", TextView.class);
    view2131298926 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.cancelTicket(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_tui_fang, "field 'tvTuifang' and method 'cancelTicket'");
    target.tvTuifang = Utils.castView(view, R.id.tv_tui_fang, "field 'tvTuifang'", TextView.class);
    view2131299460 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.cancelTicket(p0);
      }
    });
    target.tvCancelStatus = Utils.findRequiredViewAsType(source, R.id.tv_cancel_status, "field 'tvCancelStatus'", TextView.class);
    target.linBottom = Utils.findRequiredViewAsType(source, R.id.lin_bottom, "field 'linBottom'", LinearLayout.class);
    target.linBtnBox = Utils.findRequiredViewAsType(source, R.id.lin_btn_box, "field 'linBtnBox'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.lin_price, "field 'linPrice' and method 'priceDetails'");
    target.linPrice = Utils.castView(view, R.id.lin_price, "field 'linPrice'", LinearLayout.class);
    view2131298053 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.priceDetails(p0);
      }
    });
    target.tvMingxi = Utils.findRequiredViewAsType(source, R.id.tv_mingxi, "field 'tvMingxi'", TextView.class);
    target.tvTotalPrice = Utils.findRequiredViewAsType(source, R.id.tv_total_price, "field 'tvTotalPrice'", TextView.class);
    target.ivPriceDetails = Utils.findRequiredViewAsType(source, R.id.iv_price_details, "field 'ivPriceDetails'", ImageView.class);
  }

  @Override
  public void unbind() {
    CommonOrderDetailsV2Activity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rl = null;
    target.title = null;
    target.tvSendApprove = null;
    target.tvCancelOrder = null;
    target.tvCancelApprove = null;
    target.tvCancelApply = null;
    target.tvTeainCancelStatus = null;
    target.tvRetreat = null;
    target.tvRetreat0 = null;
    target.tvCancelTicket = null;
    target.tvCancelTicket0 = null;
    target.tvTuifang = null;
    target.tvCancelStatus = null;
    target.linBottom = null;
    target.linBtnBox = null;
    target.linPrice = null;
    target.tvMingxi = null;
    target.tvTotalPrice = null;
    target.ivPriceDetails = null;

    view2131299364.setOnClickListener(null);
    view2131299364 = null;
    view2131298923.setOnClickListener(null);
    view2131298923 = null;
    view2131298922.setOnClickListener(null);
    view2131298922 = null;
    view2131298921.setOnClickListener(null);
    view2131298921 = null;
    view2131299448.setOnClickListener(null);
    view2131299448 = null;
    view2131299321.setOnClickListener(null);
    view2131299321 = null;
    view2131299322.setOnClickListener(null);
    view2131299322 = null;
    view2131298925.setOnClickListener(null);
    view2131298925 = null;
    view2131298926.setOnClickListener(null);
    view2131298926 = null;
    view2131299460.setOnClickListener(null);
    view2131299460 = null;
    view2131298053.setOnClickListener(null);
    view2131298053 = null;

    super.unbind();
  }
}
