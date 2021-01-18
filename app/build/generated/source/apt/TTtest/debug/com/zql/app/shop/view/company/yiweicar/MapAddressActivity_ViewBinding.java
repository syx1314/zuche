// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.company.yiweicar;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.amap.api.maps.MapView;
import com.zql.app.shop.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MapAddressActivity_ViewBinding implements Unbinder {
  private MapAddressActivity target;

  private View view2131296532;

  @UiThread
  public MapAddressActivity_ViewBinding(MapAddressActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MapAddressActivity_ViewBinding(final MapAddressActivity target, View source) {
    this.target = target;

    View view;
    target.map = Utils.findRequiredViewAsType(source, R.id.map, "field 'map'", MapView.class);
    view = Utils.findRequiredView(source, R.id.tv_cofirm_address, "method 'onViewClicked'");
    view2131296532 = view;
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
    MapAddressActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.map = null;

    view2131296532.setOnClickListener(null);
    view2131296532 = null;
  }
}
