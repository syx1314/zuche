// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DialogConfirmTravelerInfo_ViewBinding implements Unbinder {
  private DialogConfirmTravelerInfo target;

  private View view2131299323;

  private View view2131298978;

  @UiThread
  public DialogConfirmTravelerInfo_ViewBinding(final DialogConfirmTravelerInfo target,
      View source) {
    this.target = target;

    View view;
    target.tvName = Utils.findRequiredViewAsType(source, R.id.tv_name, "field 'tvName'", TextView.class);
    target.tvEnname = Utils.findRequiredViewAsType(source, R.id.tv_enname, "field 'tvEnname'", TextView.class);
    target.tvGender = Utils.findRequiredViewAsType(source, R.id.tv_gender, "field 'tvGender'", TextView.class);
    target.tvBirthday = Utils.findRequiredViewAsType(source, R.id.tv_birthday, "field 'tvBirthday'", TextView.class);
    target.tvNation = Utils.findRequiredViewAsType(source, R.id.tv_nation, "field 'tvNation'", TextView.class);
    target.tvCertType = Utils.findRequiredViewAsType(source, R.id.tv_cert_type, "field 'tvCertType'", TextView.class);
    target.tvCertNo = Utils.findRequiredViewAsType(source, R.id.tv_cert_no, "field 'tvCertNo'", TextView.class);
    target.tvCertDate = Utils.findRequiredViewAsType(source, R.id.tv_cert_date, "field 'tvCertDate'", TextView.class);
    target.tvPhone = Utils.findRequiredViewAsType(source, R.id.tv_phone, "field 'tvPhone'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_return_modific, "method 'onViewClicked'");
    view2131299323 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_confirm, "method 'onViewClicked'");
    view2131298978 = view;
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
    DialogConfirmTravelerInfo target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvName = null;
    target.tvEnname = null;
    target.tvGender = null;
    target.tvBirthday = null;
    target.tvNation = null;
    target.tvCertType = null;
    target.tvCertNo = null;
    target.tvCertDate = null;
    target.tvPhone = null;

    view2131299323.setOnClickListener(null);
    view2131299323 = null;
    view2131298978.setOnClickListener(null);
    view2131298978 = null;
  }
}
