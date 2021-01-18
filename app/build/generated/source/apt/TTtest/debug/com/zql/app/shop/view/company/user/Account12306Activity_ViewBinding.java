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

public class Account12306Activity_ViewBinding implements Unbinder {
  private Account12306Activity target;

  private View view2131298898;

  private View view2131299495;

  @UiThread
  public Account12306Activity_ViewBinding(Account12306Activity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public Account12306Activity_ViewBinding(final Account12306Activity target, View source) {
    this.target = target;

    View view;
    target.et12306Account = Utils.findRequiredViewAsType(source, R.id.et_12306_account, "field 'et12306Account'", EditText.class);
    target.viewdivider = Utils.findRequiredView(source, R.id.view_divider, "field 'viewdivider'");
    target.tvPwdTitle = Utils.findRequiredViewAsType(source, R.id.tv_pwd_title, "field 'tvPwdTitle'", TextView.class);
    target.et12306Pwd = Utils.findRequiredViewAsType(source, R.id.et_12306_pwd, "field 'et12306Pwd'", EditText.class);
    view = Utils.findRequiredView(source, R.id.tv_bind_account, "field 'tvBindAccount' and method 'onViewClicked'");
    target.tvBindAccount = Utils.castView(view, R.id.tv_bind_account, "field 'tvBindAccount'", TextView.class);
    view2131298898 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_unbind_account, "field 'tvUnbindAccount' and method 'onViewClicked'");
    target.tvUnbindAccount = Utils.castView(view, R.id.tv_unbind_account, "field 'tvUnbindAccount'", TextView.class);
    view2131299495 = view;
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
    Account12306Activity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.et12306Account = null;
    target.viewdivider = null;
    target.tvPwdTitle = null;
    target.et12306Pwd = null;
    target.tvBindAccount = null;
    target.tvUnbindAccount = null;

    view2131298898.setOnClickListener(null);
    view2131298898 = null;
    view2131299495.setOnClickListener(null);
    view2131299495 = null;
  }
}
