// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AirShowFragment_ViewBinding implements Unbinder {
  private AirShowFragment target;

  @UiThread
  public AirShowFragment_ViewBinding(AirShowFragment target, View source) {
    this.target = target;

    target.rvAir = Utils.findRequiredViewAsType(source, R.id.rv_air, "field 'rvAir'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AirShowFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rvAir = null;
  }
}
