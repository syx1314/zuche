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

public class FindPwdActivity_ViewBinding implements Unbinder {
  private FindPwdActivity target;

  private View view2131299410;

  @UiThread
  public FindPwdActivity_ViewBinding(FindPwdActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public FindPwdActivity_ViewBinding(final FindPwdActivity target, View source) {
    this.target = target;

    View view;
    target.tvNewPwd = Utils.findRequiredViewAsType(source, R.id.tv_new_pwd, "field 'tvNewPwd'", EditText.class);
    target.tvReNewPwd = Utils.findRequiredViewAsType(source, R.id.tv_re_new_pwd, "field 'tvReNewPwd'", EditText.class);
    view = Utils.findRequiredView(source, R.id.tv_submit_pwd, "field 'tvSubmitPwd' and method 'onViewClicked'");
    target.tvSubmitPwd = Utils.castView(view, R.id.tv_submit_pwd, "field 'tvSubmitPwd'", TextView.class);
    view2131299410 = view;
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
    FindPwdActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvNewPwd = null;
    target.tvReNewPwd = null;
    target.tvSubmitPwd = null;

    view2131299410.setOnClickListener(null);
    view2131299410 = null;
  }
}
