// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.fragment.common;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.andview.refreshview.XRefreshView;
import com.zql.app.shop.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CommonTabContentFragment_ViewBinding implements Unbinder {
  private CommonTabContentFragment target;

  @UiThread
  public CommonTabContentFragment_ViewBinding(CommonTabContentFragment target, View source) {
    this.target = target;

    target.c_order_xrefreshview = Utils.findRequiredViewAsType(source, R.id.xrefreshview, "field 'c_order_xrefreshview'", XRefreshView.class);
    target.c_order_rv = Utils.findRequiredViewAsType(source, R.id.rv, "field 'c_order_rv'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CommonTabContentFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.c_order_xrefreshview = null;
    target.c_order_rv = null;
  }
}
