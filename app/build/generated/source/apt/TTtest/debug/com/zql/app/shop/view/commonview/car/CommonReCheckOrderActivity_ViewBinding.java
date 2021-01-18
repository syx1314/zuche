// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.commonview.car;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CommonReCheckOrderActivity_ViewBinding implements Unbinder {
  private CommonReCheckOrderActivity target;

  private View view2131296332;

  @UiThread
  public CommonReCheckOrderActivity_ViewBinding(CommonReCheckOrderActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CommonReCheckOrderActivity_ViewBinding(final CommonReCheckOrderActivity target,
      View source) {
    this.target = target;

    View view;
    target.rvOrder = Utils.findRequiredViewAsType(source, R.id.rv_order, "field 'rvOrder'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.btn_addvance, "field 'btn_addvance' and method 'addvance'");
    target.btn_addvance = Utils.castView(view, R.id.btn_addvance, "field 'btn_addvance'", Button.class);
    view2131296332 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.addvance(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    CommonReCheckOrderActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rvOrder = null;
    target.btn_addvance = null;

    view2131296332.setOnClickListener(null);
    view2131296332 = null;
  }
}
