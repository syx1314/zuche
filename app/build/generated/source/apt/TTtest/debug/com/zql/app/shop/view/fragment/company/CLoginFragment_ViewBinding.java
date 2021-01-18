// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.fragment.company;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CLoginFragment_ViewBinding implements Unbinder {
  private CLoginFragment target;

  private View view2131296356;

  private View view2131296359;

  private View view2131296508;

  private View view2131297862;

  private View view2131299521;

  private View view2131299064;

  @UiThread
  public CLoginFragment_ViewBinding(final CLoginFragment target, View source) {
    this.target = target;

    View view;
    target.rg = Utils.findRequiredViewAsType(source, R.id.rg, "field 'rg'", RadioGroup.class);
    target.linLoginWay2 = Utils.findRequiredViewAsType(source, R.id.lin_way2, "field 'linLoginWay2'", LinearLayout.class);
    target.etPhone = Utils.findRequiredViewAsType(source, R.id.c_login_et_phone, "field 'etPhone'", EditText.class);
    target.etCode = Utils.findRequiredViewAsType(source, R.id.c_login_et_v_code, "field 'etCode'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btn_send_code, "field 'btnSendCode' and method 'sendCode'");
    target.btnSendCode = Utils.castView(view, R.id.btn_send_code, "field 'btnSendCode'", Button.class);
    view2131296356 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.sendCode(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_to_p, "field 'btnToP' and method 'toP'");
    target.btnToP = Utils.castView(view, R.id.btn_to_p, "field 'btnToP'", Button.class);
    view2131296359 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toP(p0);
      }
    });
    target.linLoginWay1 = Utils.findRequiredViewAsType(source, R.id.lin_way1, "field 'linLoginWay1'", LinearLayout.class);
    target.c_login_et_username = Utils.findRequiredViewAsType(source, R.id.c_login_et_username, "field 'c_login_et_username'", EditText.class);
    target.c_login_et_password = Utils.findRequiredViewAsType(source, R.id.c_login_et_password, "field 'c_login_et_password'", EditText.class);
    target.c_login_et_code = Utils.findRequiredViewAsType(source, R.id.c_login_et_code, "field 'c_login_et_code'", EditText.class);
    view = Utils.findRequiredView(source, R.id.c_login_btn_submit, "field 'c_login_btn_submit' and method 'submitClk'");
    target.c_login_btn_submit = Utils.castView(view, R.id.c_login_btn_submit, "field 'c_login_btn_submit'", Button.class);
    view2131296508 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.submitClk(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.iv_show_password, "field 'cbShowPwd' and method 'showPwd'");
    target.cbShowPwd = Utils.castView(view, R.id.iv_show_password, "field 'cbShowPwd'", CheckBox.class);
    view2131297862 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.showPwd(p0);
      }
    });
    target.tvVersion = Utils.findRequiredViewAsType(source, R.id.tv_version, "field 'tvVersion'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_yzm_login, "method 'yzmLogin'");
    view2131299521 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.yzmLogin(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_forget_password, "method 'forgetPassword'");
    view2131299064 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.forgetPassword(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    CLoginFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rg = null;
    target.linLoginWay2 = null;
    target.etPhone = null;
    target.etCode = null;
    target.btnSendCode = null;
    target.btnToP = null;
    target.linLoginWay1 = null;
    target.c_login_et_username = null;
    target.c_login_et_password = null;
    target.c_login_et_code = null;
    target.c_login_btn_submit = null;
    target.cbShowPwd = null;
    target.tvVersion = null;

    view2131296356.setOnClickListener(null);
    view2131296356 = null;
    view2131296359.setOnClickListener(null);
    view2131296359 = null;
    view2131296508.setOnClickListener(null);
    view2131296508 = null;
    view2131297862.setOnClickListener(null);
    view2131297862 = null;
    view2131299521.setOnClickListener(null);
    view2131299521 = null;
    view2131299064.setOnClickListener(null);
    view2131299064 = null;
  }
}
