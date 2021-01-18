// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.company.trip;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TrainTripDetailsActivity_ViewBinding extends CommonTripDetailsActivity_ViewBinding {
  private TrainTripDetailsActivity target;

  private View view2131299243;

  @UiThread
  public TrainTripDetailsActivity_ViewBinding(TrainTripDetailsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public TrainTripDetailsActivity_ViewBinding(final TrainTripDetailsActivity target, View source) {
    super(target, source);

    this.target = target;

    View view;
    target.tvFloatTotalTime = Utils.findRequiredViewAsType(source, R.id.tv_float_total_time, "field 'tvFloatTotalTime'", TextView.class);
    target.tvFloatDepDate = Utils.findRequiredViewAsType(source, R.id.tv_float_dep_date, "field 'tvFloatDepDate'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_order_details, "method 'toOrderDetails'");
    view2131299243 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toOrderDetails();
      }
    });
  }

  @Override
  public void unbind() {
    TrainTripDetailsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvFloatTotalTime = null;
    target.tvFloatDepDate = null;

    view2131299243.setOnClickListener(null);
    view2131299243 = null;

    super.unbind();
  }
}
