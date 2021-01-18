// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.company.order;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CAirOrderDetailsActivity_ViewBinding implements Unbinder {
  private CAirOrderDetailsActivity target;

  private View view2131299253;

  @UiThread
  public CAirOrderDetailsActivity_ViewBinding(CAirOrderDetailsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CAirOrderDetailsActivity_ViewBinding(final CAirOrderDetailsActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.tv_part_order_status, "method 'partOrderStatus'");
    view2131299253 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.partOrderStatus(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view2131299253.setOnClickListener(null);
    view2131299253 = null;
  }
}
