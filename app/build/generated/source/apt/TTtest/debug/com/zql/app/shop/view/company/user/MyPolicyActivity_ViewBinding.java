// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.company.user;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MyPolicyActivity_ViewBinding implements Unbinder {
  private MyPolicyActivity target;

  @UiThread
  public MyPolicyActivity_ViewBinding(MyPolicyActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MyPolicyActivity_ViewBinding(MyPolicyActivity target, View source) {
    this.target = target;

    target.tablayout = Utils.findRequiredViewAsType(source, R.id.tablayout, "field 'tablayout'", TabLayout.class);
    target.tvPolicy = Utils.findRequiredViewAsType(source, R.id.tv_policy, "field 'tvPolicy'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MyPolicyActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tablayout = null;
    target.tvPolicy = null;
  }
}
