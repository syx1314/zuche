// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CommonDialogBottomFilter_ViewBinding implements Unbinder {
  private CommonDialogBottomFilter target;

  private View view2131298920;

  private View view2131299010;

  private View view2131299218;

  @UiThread
  public CommonDialogBottomFilter_ViewBinding(final CommonDialogBottomFilter target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.tv_cancel, "field 'tvCancel' and method 'onViewClicked'");
    target.tvCancel = Utils.castView(view, R.id.tv_cancel, "field 'tvCancel'", TextView.class);
    view2131298920 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_dialog_title, "field 'tvDialogTitle' and method 'onViewClicked'");
    target.tvDialogTitle = Utils.castView(view, R.id.tv_dialog_title, "field 'tvDialogTitle'", TextView.class);
    view2131299010 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_ok, "field 'tvOk' and method 'onViewClicked'");
    target.tvOk = Utils.castView(view, R.id.tv_ok, "field 'tvOk'", TextView.class);
    view2131299218 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.rvLeftTitle = Utils.findRequiredViewAsType(source, R.id.rv_left_title, "field 'rvLeftTitle'", RecyclerView.class);
    target.rvCondition = Utils.findRequiredViewAsType(source, R.id.rv_condition, "field 'rvCondition'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CommonDialogBottomFilter target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvCancel = null;
    target.tvDialogTitle = null;
    target.tvOk = null;
    target.rvLeftTitle = null;
    target.rvCondition = null;

    view2131298920.setOnClickListener(null);
    view2131298920 = null;
    view2131299010.setOnClickListener(null);
    view2131299010 = null;
    view2131299218.setOnClickListener(null);
    view2131299218 = null;
  }
}
