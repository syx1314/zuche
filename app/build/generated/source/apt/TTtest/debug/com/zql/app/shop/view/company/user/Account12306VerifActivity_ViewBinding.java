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
import com.zql.app.shop.util.view.CommonTitleView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Account12306VerifActivity_ViewBinding implements Unbinder {
  private Account12306VerifActivity target;

  private View view2131299365;

  private View view2131299079;

  @UiThread
  public Account12306VerifActivity_ViewBinding(Account12306VerifActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public Account12306VerifActivity_ViewBinding(final Account12306VerifActivity target,
      View source) {
    this.target = target;

    View view;
    target.tvTips = Utils.findRequiredViewAsType(source, R.id.tv_tips, "field 'tvTips'", TextView.class);
    target.etCode = Utils.findRequiredViewAsType(source, R.id.etCode, "field 'etCode'", EditText.class);
    target.title = Utils.findRequiredViewAsType(source, R.id.title, "field 'title'", CommonTitleView.class);
    view = Utils.findRequiredView(source, R.id.tv_send_code, "method 'sendCode'");
    view2131299365 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.sendCode(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_handle, "method 'onViewClicked'");
    view2131299079 = view;
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
    Account12306VerifActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvTips = null;
    target.etCode = null;
    target.title = null;

    view2131299365.setOnClickListener(null);
    view2131299365 = null;
    view2131299079.setOnClickListener(null);
    view2131299079 = null;
  }
}
