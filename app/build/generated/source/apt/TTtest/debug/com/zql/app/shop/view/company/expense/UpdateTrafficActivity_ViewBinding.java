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
import com.zql.app.shop.util.view.CommonTitleView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class UpdateTrafficActivity_ViewBinding implements Unbinder {
  private UpdateTrafficActivity target;

  private View view2131299288;

  @UiThread
  public UpdateTrafficActivity_ViewBinding(UpdateTrafficActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public UpdateTrafficActivity_ViewBinding(final UpdateTrafficActivity target, View source) {
    this.target = target;

    View view;
    target.rv = Utils.findRequiredViewAsType(source, R.id.rv, "field 'rv'", RecyclerView.class);
    target.tvPrice = Utils.findRequiredViewAsType(source, R.id.tv_price, "field 'tvPrice'", TextView.class);
    target.title = Utils.findRequiredViewAsType(source, R.id.title, "field 'title'", CommonTitleView.class);
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
    UpdateTrafficActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rv = null;
    target.tvPrice = null;
    target.title = null;
    target.linContent = null;

    view2131299288.setOnClickListener(null);
    view2131299288 = null;
  }
}
