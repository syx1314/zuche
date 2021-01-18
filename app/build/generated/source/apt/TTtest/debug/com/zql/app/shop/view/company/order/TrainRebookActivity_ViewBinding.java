// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.company.order;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TrainRebookActivity_ViewBinding implements Unbinder {
  private TrainRebookActivity target;

  private View view2131299209;

  private View view2131299360;

  @UiThread
  public TrainRebookActivity_ViewBinding(TrainRebookActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public TrainRebookActivity_ViewBinding(final TrainRebookActivity target, View source) {
    this.target = target;

    View view;
    target.rvTrainPeople = Utils.findRequiredViewAsType(source, R.id.rv_train_people, "field 'rvTrainPeople'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.tv_no_rebook, "method 'noReBook'");
    view2131299209 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.noReBook(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_sel_train, "method 'toSelTrain'");
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
    TrainRebookActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rvTrainPeople = null;

    view2131299209.setOnClickListener(null);
    view2131299209 = null;
    view2131299360.setOnClickListener(null);
    view2131299360 = null;
  }
}
