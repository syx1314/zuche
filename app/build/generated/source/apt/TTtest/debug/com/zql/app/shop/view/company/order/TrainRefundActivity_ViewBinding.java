// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.company.order;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import com.zql.app.shop.util.view.CommonTitleView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TrainRefundActivity_ViewBinding implements Unbinder {
  private TrainRefundActivity target;

  private View view2131299209;

  private View view2131299360;

  @UiThread
  public TrainRefundActivity_ViewBinding(TrainRefundActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public TrainRefundActivity_ViewBinding(final TrainRefundActivity target, View source) {
    this.target = target;

    View view;
    target.titleView = Utils.findRequiredViewAsType(source, R.id.title, "field 'titleView'", CommonTitleView.class);
    target.tvgaiqianTips = Utils.findRequiredViewAsType(source, R.id.tv_gaiqian_tips, "field 'tvgaiqianTips'", TextView.class);
    target.tvSelPeopleTips = Utils.findRequiredViewAsType(source, R.id.tv_sel_people_tips, "field 'tvSelPeopleTips'", TextView.class);
    target.rvTrainPeople = Utils.findRequiredViewAsType(source, R.id.rv_train_people, "field 'rvTrainPeople'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.tv_no_rebook, "field 'tvNoRebook' and method 'noReBook'");
    target.tvNoRebook = Utils.castView(view, R.id.tv_no_rebook, "field 'tvNoRebook'", TextView.class);
    view2131299209 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.noReBook(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_sel_train, "field 'tvRefund' and method 'toSelTrain'");
    target.tvRefund = Utils.castView(view, R.id.tv_sel_train, "field 'tvRefund'", TextView.class);
    view2131299360 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toSelTrain(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    TrainRefundActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.titleView = null;
    target.tvgaiqianTips = null;
    target.tvSelPeopleTips = null;
    target.rvTrainPeople = null;
    target.tvNoRebook = null;
    target.tvRefund = null;

    view2131299209.setOnClickListener(null);
    view2131299209 = null;
    view2131299360.setOnClickListener(null);
    view2131299360 = null;
  }
}
