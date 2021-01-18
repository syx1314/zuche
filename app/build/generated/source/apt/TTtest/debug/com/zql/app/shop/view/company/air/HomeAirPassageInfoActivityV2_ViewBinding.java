// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.company.air;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import com.zql.app.shop.util.view.CommonTitleView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeAirPassageInfoActivityV2_ViewBinding implements Unbinder {
  private HomeAirPassageInfoActivityV2 target;

  private View view2131297602;

  private View view2131298943;

  private View view2131296349;

  @UiThread
  public HomeAirPassageInfoActivityV2_ViewBinding(HomeAirPassageInfoActivityV2 target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public HomeAirPassageInfoActivityV2_ViewBinding(final HomeAirPassageInfoActivityV2 target,
      View source) {
    this.target = target;

    View view;
    target.tvName = Utils.findRequiredViewAsType(source, R.id.tv_name, "field 'tvName'", TextView.class);
    target.rlEnName = Utils.findRequiredViewAsType(source, R.id.rl_en_name, "field 'rlEnName'", RelativeLayout.class);
    target.tvEname = Utils.findRequiredViewAsType(source, R.id.tv_en_name, "field 'tvEname'", TextView.class);
    view = Utils.findRequiredView(source, R.id.et_gender, "field 'etGender' and method 'onViewClicked'");
    target.etGender = Utils.castView(view, R.id.et_gender, "field 'etGender'", TextView.class);
    view2131297602 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.rgGender = Utils.findRequiredViewAsType(source, R.id.rg_gender, "field 'rgGender'", RadioGroup.class);
    target.rbMale = Utils.findRequiredViewAsType(source, R.id.rb_male, "field 'rbMale'", RadioButton.class);
    target.rbFeMale = Utils.findRequiredViewAsType(source, R.id.rb_female, "field 'rbFeMale'", RadioButton.class);
    view = Utils.findRequiredView(source, R.id.tv_certificate_type, "field 'tvCertificateType' and method 'onViewClicked'");
    target.tvCertificateType = Utils.castView(view, R.id.tv_certificate_type, "field 'tvCertificateType'", TextView.class);
    view2131298943 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.ivCertTypeGoRight = Utils.findRequiredViewAsType(source, R.id.iv_cert_type_go_right, "field 'ivCertTypeGoRight'", ImageView.class);
    target.etCertificateNum = Utils.findRequiredViewAsType(source, R.id.et_certificate_num, "field 'etCertificateNum'", EditText.class);
    target.etPhoneNum = Utils.findRequiredViewAsType(source, R.id.et_phone_num, "field 'etPhoneNum'", EditText.class);
    target.title = Utils.findRequiredViewAsType(source, R.id.title, "field 'title'", CommonTitleView.class);
    view = Utils.findRequiredView(source, R.id.btn_ok, "field 'btnOk' and method 'onViewClicked'");
    target.btnOk = Utils.castView(view, R.id.btn_ok, "field 'btnOk'", Button.class);
    view2131296349 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvNation = Utils.findRequiredViewAsType(source, R.id.tv_nation, "field 'tvNation'", TextView.class);
    target.rlNation = Utils.findRequiredViewAsType(source, R.id.rl_nation, "field 'rlNation'", RelativeLayout.class);
    target.tvCertExet = Utils.findRequiredViewAsType(source, R.id.tv_cert_exet, "field 'tvCertExet'", TextView.class);
    target.rlCertExet = Utils.findRequiredViewAsType(source, R.id.rl_cert_exet, "field 'rlCertExet'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HomeAirPassageInfoActivityV2 target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvName = null;
    target.rlEnName = null;
    target.tvEname = null;
    target.etGender = null;
    target.rgGender = null;
    target.rbMale = null;
    target.rbFeMale = null;
    target.tvCertificateType = null;
    target.ivCertTypeGoRight = null;
    target.etCertificateNum = null;
    target.etPhoneNum = null;
    target.title = null;
    target.btnOk = null;
    target.tvNation = null;
    target.rlNation = null;
    target.tvCertExet = null;
    target.rlCertExet = null;

    view2131297602.setOnClickListener(null);
    view2131297602 = null;
    view2131298943.setOnClickListener(null);
    view2131298943 = null;
    view2131296349.setOnClickListener(null);
    view2131296349 = null;
  }
}
