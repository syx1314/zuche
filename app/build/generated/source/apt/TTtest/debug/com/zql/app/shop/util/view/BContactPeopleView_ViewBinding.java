// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.util.view;

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

public class BContactPeopleView_ViewBinding implements Unbinder {
  private BContactPeopleView target;

  private View view2131297614;

  @UiThread
  public BContactPeopleView_ViewBinding(BContactPeopleView target) {
    this(target, target);
  }

  @UiThread
  public BContactPeopleView_ViewBinding(final BContactPeopleView target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.et_name, "field 'etName' and method 'selContactName'");
    target.etName = Utils.castView(view, R.id.et_name, "field 'etName'", TextView.class);
    view2131297614 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.selContactName();
      }
    });
    target.etPhone = Utils.findRequiredViewAsType(source, R.id.et_phone, "field 'etPhone'", EditText.class);
    target.etEmail = Utils.findRequiredViewAsType(source, R.id.et_email, "field 'etEmail'", EditText.class);
    target.linPassageTitle = Utils.findRequiredViewAsType(source, R.id.lin_passage_title, "field 'linPassageTitle'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    BContactPeopleView target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.etName = null;
    target.etPhone = null;
    target.etEmail = null;
    target.linPassageTitle = null;

    view2131297614.setOnClickListener(null);
    view2131297614 = null;
  }
}
