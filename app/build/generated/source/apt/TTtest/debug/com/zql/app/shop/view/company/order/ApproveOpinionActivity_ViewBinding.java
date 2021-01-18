// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.company.order;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ApproveOpinionActivity_ViewBinding implements Unbinder {
  private ApproveOpinionActivity target;

  private View view2131296350;

  private View view2131296352;

  @UiThread
  public ApproveOpinionActivity_ViewBinding(ApproveOpinionActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ApproveOpinionActivity_ViewBinding(final ApproveOpinionActivity target, View source) {
    this.target = target;

    View view;
    target.etOpinion = Utils.findRequiredViewAsType(source, R.id.et_opinion, "field 'etOpinion'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btn_pass, "field 'btnPass' and method 'passApv'");
    target.btnPass = Utils.castView(view, R.id.btn_pass, "field 'btnPass'", Button.class);
    view2131296350 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.passApv(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_refuse, "field 'btnRefuse' and method 'refuse'");
    target.btnRefuse = Utils.castView(view, R.id.btn_refuse, "field 'btnRefuse'", Button.class);
    view2131296352 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.refuse(p0);
      }
    });
    target.tvWordsNum = Utils.findRequiredViewAsType(source, R.id.tv_words_num, "field 'tvWordsNum'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ApproveOpinionActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.etOpinion = null;
    target.btnPass = null;
    target.btnRefuse = null;
    target.tvWordsNum = null;

    view2131296350.setOnClickListener(null);
    view2131296350 = null;
    view2131296352.setOnClickListener(null);
    view2131296352 = null;
  }
}
