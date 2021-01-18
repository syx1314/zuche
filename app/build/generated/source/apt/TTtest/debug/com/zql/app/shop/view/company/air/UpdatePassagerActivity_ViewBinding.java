// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.company.air;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import com.zql.app.shop.util.view.CommonTitleView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class UpdatePassagerActivity_ViewBinding implements Unbinder {
  private UpdatePassagerActivity target;

  private View view2131297602;

  private View view2131297615;

  private View view2131297585;

  private View view2131297584;

  private View view2131296349;

  @UiThread
  public UpdatePassagerActivity_ViewBinding(UpdatePassagerActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public UpdatePassagerActivity_ViewBinding(final UpdatePassagerActivity target, View source) {
    this.target = target;

    View view;
    target.etName = Utils.findRequiredViewAsType(source, R.id.et_name, "field 'etName'", TextView.class);
    target.tvEnName = Utils.findRequiredViewAsType(source, R.id.tv_first_name, "field 'tvEnName'", TextView.class);
    target.etEnName = Utils.findRequiredViewAsType(source, R.id.et_en_name, "field 'etEnName'", TextView.class);
    target.etBirthday = Utils.findRequiredViewAsType(source, R.id.et_birthday, "field 'etBirthday'", TextView.class);
    target.lin22 = Utils.findRequiredView(source, R.id.line22, "field 'lin22'");
    view = Utils.findRequiredView(source, R.id.et_gender, "field 'etGender' and method 'selGender'");
    target.etGender = Utils.castView(view, R.id.et_gender, "field 'etGender'", TextView.class);
    view2131297602 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.selGender();
      }
    });
    target.rgGender = Utils.findRequiredViewAsType(source, R.id.rg_gender, "field 'rgGender'", RadioGroup.class);
    view = Utils.findRequiredView(source, R.id.et_nation, "field 'etNation' and method 'selCountry'");
    target.etNation = Utils.castView(view, R.id.et_nation, "field 'etNation'", TextView.class);
    view2131297615 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.selCountry();
      }
    });
    view = Utils.findRequiredView(source, R.id.et_cert_info, "field 'tvCertType' and method 'selCertType'");
    target.tvCertType = Utils.castView(view, R.id.et_cert_info, "field 'tvCertType'", TextView.class);
    view2131297585 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.selCertType();
      }
    });
    target.ivCertTypeGoRight = Utils.findRequiredViewAsType(source, R.id.iv_cert_type_go_right, "field 'ivCertTypeGoRight'", ImageView.class);
    target.etCertNo = Utils.findRequiredViewAsType(source, R.id.et_cert_no, "field 'etCertNo'", EditText.class);
    target.line53 = Utils.findRequiredView(source, R.id.line53, "field 'line53'");
    view = Utils.findRequiredView(source, R.id.et_cert_exet, "field 'tvCertExet' and method 'selectCertExet'");
    target.tvCertExet = Utils.castView(view, R.id.et_cert_exet, "field 'tvCertExet'", TextView.class);
    view2131297584 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.selectCertExet();
      }
    });
    target.etPhone = Utils.findRequiredViewAsType(source, R.id.et_phone, "field 'etPhone'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btn_ok, "field 'btnOk' and method 'onViewClicked'");
    target.btnOk = Utils.castView(view, R.id.btn_ok, "field 'btnOk'", Button.class);
    view2131296349 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.title = Utils.findRequiredViewAsType(source, R.id.title, "field 'title'", CommonTitleView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    UpdatePassagerActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.etName = null;
    target.tvEnName = null;
    target.etEnName = null;
    target.etBirthday = null;
    target.lin22 = null;
    target.etGender = null;
    target.rgGender = null;
    target.etNation = null;
    target.tvCertType = null;
    target.ivCertTypeGoRight = null;
    target.etCertNo = null;
    target.line53 = null;
    target.tvCertExet = null;
    target.etPhone = null;
    target.btnOk = null;
    target.title = null;

    view2131297602.setOnClickListener(null);
    view2131297602 = null;
    view2131297615.setOnClickListener(null);
    view2131297615 = null;
    view2131297585.setOnClickListener(null);
    view2131297585 = null;
    view2131297584.setOnClickListener(null);
    view2131297584 = null;
    view2131296349.setOnClickListener(null);
    view2131296349 = null;
  }
}
