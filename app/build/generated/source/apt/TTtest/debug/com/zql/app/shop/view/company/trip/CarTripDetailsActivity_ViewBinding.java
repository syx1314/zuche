// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.company.trip;

import android.support.annotation.UiThread;
import android.view.View;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CarTripDetailsActivity_ViewBinding extends CommonTripDetailsActivity_ViewBinding {
  private CarTripDetailsActivity target;

  private View view2131299243;

  @UiThread
  public CarTripDetailsActivity_ViewBinding(CarTripDetailsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CarTripDetailsActivity_ViewBinding(final CarTripDetailsActivity target, View source) {
    super(target, source);

    this.target = target;

    View view;
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
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view2131299243.setOnClickListener(null);
    view2131299243 = null;

    super.unbind();
  }
}
