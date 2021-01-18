// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.util.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BSubmitOrderConfirmDialog_ViewBinding implements Unbinder {
  private BSubmitOrderConfirmDialog target;

  private View view2131298070;

  private View view2131299409;

  @UiThread
  public BSubmitOrderConfirmDialog_ViewBinding(BSubmitOrderConfirmDialog target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public BSubmitOrderConfirmDialog_ViewBinding(final BSubmitOrderConfirmDialog target,
      View source) {
    this.target = target;

    View view;
    target.rlRoot = Utils.findRequiredViewAsType(source, R.id.rl_root, "field 'rlRoot'", RelativeLayout.class);
    target.linBottom = Utils.findRequiredViewAsType(source, R.id.lin_bottom, "field 'linBottom'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.lin_reminder, "field 'linReminder' and method 'onViewClicked'");
    target.linReminder = Utils.castView(view, R.id.lin_reminder, "field 'linReminder'", LinearLayout.class);
    view2131298070 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.rvContent = Utils.findRequiredViewAsType(source, R.id.rv_content, "field 'rvContent'", RecyclerView.class);
    target.titleView = Utils.findRequiredViewAsType(source, R.id.title, "field 'titleView'", CommonTitleView.class);
    view = Utils.findRequiredView(source, R.id.tv_submit_order, "method 'onViewClicked'");
    view2131299409 = view;
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
    BSubmitOrderConfirmDialog target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rlRoot = null;
    target.linBottom = null;
    target.linReminder = null;
    target.rvContent = null;
    target.titleView = null;

    view2131298070.setOnClickListener(null);
    view2131298070 = null;
    view2131299409.setOnClickListener(null);
    view2131299409 = null;
  }
}
