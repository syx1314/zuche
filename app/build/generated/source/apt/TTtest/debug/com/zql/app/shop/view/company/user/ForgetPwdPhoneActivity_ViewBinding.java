// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.company.user;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ForgetPwdPhoneActivity_ViewBinding implements Unbinder {
  private ForgetPwdPhoneActivity target;

  private View view2131297758;

  private View view2131299048;

  @UiThread
  public ForgetPwdPhoneActivity_ViewBinding(ForgetPwdPhoneActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ForgetPwdPhoneActivity_ViewBinding(final ForgetPwdPhoneActivity target, View source) {
    this.target = target;

    View view;
    target.etPhone = Utils.findRequiredViewAsType(source, R.id.et_phone, "field 'etPhone'", EditText.class);
    view = Utils.findRequiredView(source, R.id.iv_back, "method 'onViewClicked'");
    view2131297758 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_find_code, "method 'onViewClicked'");
    view2131299048 = view;
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
    ForgetPwdPhoneActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.etPhone = null;

    view2131297758.setOnClickListener(null);
    view2131297758 = null;
    view2131299048.setOnClickListener(null);
    view2131299048 = null;
  }
}
