// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.company.expense;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class UpdateChalvActivity_ViewBinding implements Unbinder {
  private UpdateChalvActivity target;

  private View view2131299288;

  @UiThread
  public UpdateChalvActivity_ViewBinding(UpdateChalvActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public UpdateChalvActivity_ViewBinding(final UpdateChalvActivity target, View source) {
    this.target = target;

    View view;
    target.rv = Utils.findRequiredViewAsType(source, R.id.rv, "field 'rv'", RecyclerView.class);
    target.tvPrice = Utils.findRequiredViewAsType(source, R.id.tv_price, "field 'tvPrice'", TextView.class);
    target.linContent = Utils.findRequiredViewAsType(source, R.id.lin_content, "field 'linContent'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.tv_queren, "method 'onViewClicked'");
    view2131299288 = view;
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
    UpdateChalvActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rv = null;
    target.tvPrice = null;
    target.linContent = null;

    view2131299288.setOnClickListener(null);
    view2131299288 = null;
  }
}
