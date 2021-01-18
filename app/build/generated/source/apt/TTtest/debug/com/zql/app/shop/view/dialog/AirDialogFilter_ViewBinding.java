// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AirDialogFilter_ViewBinding implements Unbinder {
  private AirDialogFilter target;

  private View view2131298965;

  private View view2131298920;

  private View view2131299218;

  @UiThread
  public AirDialogFilter_ViewBinding(final AirDialogFilter target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.tv_clear, "field 'tvClear' and method 'onViewClicked'");
    target.tvClear = Utils.castView(view, R.id.tv_clear, "field 'tvClear'", TextView.class);
    view2131298965 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.rvTitle = Utils.findRequiredViewAsType(source, R.id.rv_title, "field 'rvTitle'", RecyclerView.class);
    target.rvCondition = Utils.findRequiredViewAsType(source, R.id.rv_condition, "field 'rvCondition'", RecyclerView.class);
    target.cbShowTax = Utils.findRequiredViewAsType(source, R.id.cb_show_tax, "field 'cbShowTax'", CheckBox.class);
    target.cbShowDirect = Utils.findRequiredViewAsType(source, R.id.cb_show_direct, "field 'cbShowDirect'", CheckBox.class);
    target.commonSelectFlightContainerRootContainer = Utils.findRequiredViewAsType(source, R.id.common_select_flight_container_root_container, "field 'commonSelectFlightContainerRootContainer'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.tv_cancel, "method 'onViewClicked'");
    view2131298920 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_ok, "method 'onViewClicked'");
    view2131299218 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    AirDialogFilter target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvClear = null;
    target.rvTitle = null;
    target.rvCondition = null;
    target.cbShowTax = null;
    target.cbShowDirect = null;
    target.commonSelectFlightContainerRootContainer = null;

    view2131298965.setOnClickListener(null);
    view2131298965 = null;
    view2131298920.setOnClickListener(null);
    view2131298920 = null;
    view2131299218.setOnClickListener(null);
    view2131299218 = null;
  }
}
