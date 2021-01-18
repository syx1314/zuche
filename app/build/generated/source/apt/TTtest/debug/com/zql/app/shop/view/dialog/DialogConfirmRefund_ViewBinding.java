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

public class DialogConfirmRefund_ViewBinding implements Unbinder {
  private DialogConfirmRefund target;

  private View view2131299114;

  private View view2131298978;

  @UiThread
  public DialogConfirmRefund_ViewBinding(final DialogConfirmRefund target, View source) {
    this.target = target;

    View view;
    target.rv = Utils.findRequiredViewAsType(source, R.id.rv, "field 'rv'", RecyclerView.class);
    target.tvTuiTips = Utils.findRequiredViewAsType(source, R.id.tv_tui_tips, "field 'tvTuiTips'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_hulue, "method 'onViewClicked'");
    view2131299114 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_confirm, "method 'onViewClicked'");
    view2131298978 = view;
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
    DialogConfirmRefund target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rv = null;
    target.tvTuiTips = null;

    view2131299114.setOnClickListener(null);
    view2131299114 = null;
    view2131298978.setOnClickListener(null);
    view2131298978 = null;
  }
}
