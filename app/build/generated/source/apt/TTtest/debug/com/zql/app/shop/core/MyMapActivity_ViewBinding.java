// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.core;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.amap.api.maps.MapView;
import com.zql.app.shop.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MyMapActivity_ViewBinding implements Unbinder {
  private MyMapActivity target;

  @UiThread
  public MyMapActivity_ViewBinding(MyMapActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MyMapActivity_ViewBinding(MyMapActivity target, View source) {
    this.target = target;

    target.mapView = Utils.findRequiredViewAsType(source, R.id.mapView, "field 'mapView'", MapView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MyMapActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mapView = null;
  }
}
