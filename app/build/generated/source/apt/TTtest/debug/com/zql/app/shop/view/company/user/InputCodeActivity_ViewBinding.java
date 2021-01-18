// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.company.user;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class InputCodeActivity_ViewBinding implements Unbinder {
  private InputCodeActivity target;

  private View view2131299429;

  private View view2131299368;

  @UiThread
  public InputCodeActivity_ViewBinding(InputCodeActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public InputCodeActivity_ViewBinding(final InputCodeActivity target, View source) {
    this.target = target;

    View view;
    target.tvPhone = Utils.findRequiredViewAsType(source, R.id.tv_phone, "field 'tvPhone'", TextView.class);
    target.etCode = Utils.findRequiredViewAsType(source, R.id.et_code, "field 'etCode'", EditText.class);
    view = Utils.findRequiredView(source, R.id.tv_time, "field 'tvTime' and method 'onViewClicked'");
    target.tvTime = Utils.castView(view, R.id.tv_time, "field 'tvTime'", TextView.class);
    view2131299429 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_set_pwd, "method 'onViewClicked'");
    view2131299368 = view;
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
    InputCodeActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvPhone = null;
    target.etCode = null;
    target.tvTime = null;

    view2131299429.setOnClickListener(null);
    view2131299429 = null;
    view2131299368.setOnClickListener(null);
    view2131299368 = null;
  }
}
