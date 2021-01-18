// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.dialog;

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

public class DialogInterAirCalander_ViewBinding implements Unbinder {
  private DialogInterAirCalander target;

  private View view2131297941;

  @UiThread
  public DialogInterAirCalander_ViewBinding(final DialogInterAirCalander target, View source) {
    this.target = target;

    View view;
    target.rvAir = Utils.findRequiredViewAsType(source, R.id.rv_air, "field 'rvAir'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.lin_box, "method 'dismiss'");
    view2131297941 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.dismiss();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    DialogInterAirCalander target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rvAir = null;

    view2131297941.setOnClickListener(null);
    view2131297941 = null;
  }
}
