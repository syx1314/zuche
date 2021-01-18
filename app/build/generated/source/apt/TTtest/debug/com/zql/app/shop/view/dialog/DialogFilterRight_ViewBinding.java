// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DialogFilterRight_ViewBinding implements Unbinder {
  private DialogFilterRight target;

  private View view2131296533;

  private View view2131296550;

  private View view2131296403;

  @UiThread
  public DialogFilterRight_ViewBinding(DialogFilterRight target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DialogFilterRight_ViewBinding(final DialogFilterRight target, View source) {
    this.target = target;

    View view;
    target.etQidian = Utils.findRequiredViewAsType(source, R.id.et_qidian, "field 'etQidian'", EditText.class);
    target.etZundian = Utils.findRequiredViewAsType(source, R.id.et_zundian, "field 'etZundian'", EditText.class);
    target.etDate = Utils.findRequiredViewAsType(source, R.id.et_date, "field 'etDate'", EditText.class);
    view = Utils.findRequiredView(source, R.id.tv_confirm, "field 'tvConfirm' and method 'onViewClicked'");
    target.tvConfirm = Utils.castView(view, R.id.tv_confirm, "field 'tvConfirm'", TextView.class);
    view2131296533 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_reset, "field 'tvReset' and method 'onViewClicked'");
    target.tvReset = Utils.castView(view, R.id.tv_reset, "field 'tvReset'", TextView.class);
    view2131296550 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lin_root, "field 'linRoot' and method 'onViewClicked'");
    target.linRoot = Utils.castView(view, R.id.lin_root, "field 'linRoot'", LinearLayout.class);
    view2131296403 = view;
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
    DialogFilterRight target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.etQidian = null;
    target.etZundian = null;
    target.etDate = null;
    target.tvConfirm = null;
    target.tvReset = null;
    target.linRoot = null;

    view2131296533.setOnClickListener(null);
    view2131296533 = null;
    view2131296550.setOnClickListener(null);
    view2131296550 = null;
    view2131296403.setOnClickListener(null);
    view2131296403 = null;
  }
}
