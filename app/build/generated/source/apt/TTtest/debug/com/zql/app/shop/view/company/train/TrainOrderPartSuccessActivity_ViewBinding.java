// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.company.train;

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

public class TrainOrderPartSuccessActivity_ViewBinding implements Unbinder {
  private TrainOrderPartSuccessActivity target;

  private View view2131296354;

  @UiThread
  public TrainOrderPartSuccessActivity_ViewBinding(TrainOrderPartSuccessActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public TrainOrderPartSuccessActivity_ViewBinding(final TrainOrderPartSuccessActivity target,
      View source) {
    this.target = target;

    View view;
    target.rvAirInfo = Utils.findRequiredViewAsType(source, R.id.rv_air_info, "field 'rvAirInfo'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.btn_return_home, "method 'onViewClicked'");
    view2131296354 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    TrainOrderPartSuccessActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rvAirInfo = null;

    view2131296354.setOnClickListener(null);
    view2131296354 = null;
  }
}
