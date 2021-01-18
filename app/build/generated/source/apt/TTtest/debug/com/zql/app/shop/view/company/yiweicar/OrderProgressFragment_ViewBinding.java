// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.company.yiweicar;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class OrderProgressFragment_ViewBinding implements Unbinder {
  private OrderProgressFragment target;

  @UiThread
  public OrderProgressFragment_ViewBinding(OrderProgressFragment target, View source) {
    this.target = target;

    target.rvDingdan = Utils.findRequiredViewAsType(source, R.id.rv_dingdan, "field 'rvDingdan'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    OrderProgressFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rvDingdan = null;
  }
}
