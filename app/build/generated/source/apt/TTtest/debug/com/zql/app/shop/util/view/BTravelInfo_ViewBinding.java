// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.util.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BTravelInfo_ViewBinding implements Unbinder {
  private BTravelInfo target;

  private View view2131299378;

  private View view2131299025;

  private View view2131299284;

  @UiThread
  public BTravelInfo_ViewBinding(BTravelInfo target) {
    this(target, target);
  }

  @UiThread
  public BTravelInfo_ViewBinding(final BTravelInfo target, View source) {
    this.target = target;

    View view;
    target.linTravelTitle = Utils.findRequiredViewAsType(source, R.id.lin_travel_title, "field 'linTravelTitle'", LinearLayout.class);
    target.c_new_common_reserve_business = Utils.findRequiredViewAsType(source, R.id.c_new_common_reserve_business, "field 'c_new_common_reserve_business'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.tv_start, "field 'tvStart' and method 'onViewClicked'");
    target.tvStart = Utils.castView(view, R.id.tv_start, "field 'tvStart'", TextView.class);
    view2131299378 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_end, "field 'tvEnd' and method 'onViewClicked'");
    target.tvEnd = Utils.castView(view, R.id.tv_end, "field 'tvEnd'", TextView.class);
    view2131299025 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.etAddress = Utils.findRequiredViewAsType(source, R.id.et_address, "field 'etAddress'", EditText.class);
    view = Utils.findRequiredView(source, R.id.tv_purpose, "field 'tvPurpose' and method 'onViewClicked'");
    target.tvPurpose = Utils.castView(view, R.id.tv_purpose, "field 'tvPurpose'", TextView.class);
    view2131299284 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.etReason = Utils.findRequiredViewAsType(source, R.id.et_reason, "field 'etReason'", EditText.class);
    target.c_new_common_reserve_business_ll_object = Utils.findRequiredViewAsType(source, R.id.c_new_common_reserve_business_ll_object, "field 'c_new_common_reserve_business_ll_object'", RelativeLayout.class);
    target.rlStart = Utils.findRequiredView(source, R.id.rl_start, "field 'rlStart'");
    target.rlEnd = Utils.findRequiredView(source, R.id.rl_end, "field 'rlEnd'");
    target.rlAddress = Utils.findRequiredView(source, R.id.rl_address, "field 'rlAddress'");
    target.llReason = Utils.findRequiredView(source, R.id.c_new_common_reserve_business_ll_reason, "field 'llReason'");
  }

  @Override
  @CallSuper
  public void unbind() {
    BTravelInfo target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.linTravelTitle = null;
    target.c_new_common_reserve_business = null;
    target.tvStart = null;
    target.tvEnd = null;
    target.etAddress = null;
    target.tvPurpose = null;
    target.etReason = null;
    target.c_new_common_reserve_business_ll_object = null;
    target.rlStart = null;
    target.rlEnd = null;
    target.rlAddress = null;
    target.llReason = null;

    view2131299378.setOnClickListener(null);
    view2131299378 = null;
    view2131299025.setOnClickListener(null);
    view2131299025 = null;
    view2131299284.setOnClickListener(null);
    view2131299284 = null;
  }
}
