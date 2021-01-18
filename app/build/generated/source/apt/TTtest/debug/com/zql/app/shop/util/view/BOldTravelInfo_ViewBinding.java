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

public class BOldTravelInfo_ViewBinding implements Unbinder {
  private BOldTravelInfo target;

  private View view2131299378;

  private View view2131299025;

  private View view2131299284;

  private View view2131297623;

  private View view2131296561;

  private View view2131298647;

  private View view2131298622;

  private View view2131296562;

  @UiThread
  public BOldTravelInfo_ViewBinding(BOldTravelInfo target) {
    this(target, target);
  }

  @UiThread
  public BOldTravelInfo_ViewBinding(final BOldTravelInfo target, View source) {
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
    target.tvEndSubTitle = Utils.findRequiredViewAsType(source, R.id.tv_end_sub_title, "field 'tvEndSubTitle'", TextView.class);
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
    view = Utils.findRequiredView(source, R.id.et_reason, "field 'etReason' and method 'onViewClicked'");
    target.etReason = Utils.castView(view, R.id.et_reason, "field 'etReason'", EditText.class);
    view2131297623 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.linProjectNo = Utils.findRequiredViewAsType(source, R.id.lin_project_no, "field 'linProjectNo'", LinearLayout.class);
    target.tvProjectNo = Utils.findRequiredViewAsType(source, R.id.tv_project_no, "field 'tvProjectNo'", EditText.class);
    view = Utils.findRequiredView(source, R.id.c_new_common_reserve_business_ll_object, "field 'c_new_common_reserve_business_ll_object' and method 'onViewClicked'");
    target.c_new_common_reserve_business_ll_object = Utils.castView(view, R.id.c_new_common_reserve_business_ll_object, "field 'c_new_common_reserve_business_ll_object'", LinearLayout.class);
    view2131296561 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rl_start, "field 'rlStart' and method 'onViewClicked'");
    target.rlStart = view;
    view2131298647 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rl_end, "field 'rlEnd' and method 'onViewClicked'");
    target.rlEnd = view;
    view2131298622 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.rlAddress = Utils.findRequiredView(source, R.id.rl_address, "field 'rlAddress'");
    view = Utils.findRequiredView(source, R.id.c_new_common_reserve_business_ll_reason, "field 'llReason' and method 'onViewClicked'");
    target.llReason = view;
    view2131296562 = view;
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
    BOldTravelInfo target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.linTravelTitle = null;
    target.c_new_common_reserve_business = null;
    target.tvStart = null;
    target.tvEndSubTitle = null;
    target.tvEnd = null;
    target.etAddress = null;
    target.tvPurpose = null;
    target.etReason = null;
    target.linProjectNo = null;
    target.tvProjectNo = null;
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
    view2131297623.setOnClickListener(null);
    view2131297623 = null;
    view2131296561.setOnClickListener(null);
    view2131296561 = null;
    view2131298647.setOnClickListener(null);
    view2131298647 = null;
    view2131298622.setOnClickListener(null);
    view2131298622 = null;
    view2131296562.setOnClickListener(null);
    view2131296562 = null;
  }
}
