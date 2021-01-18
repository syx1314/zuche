// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.company.car;

import android.support.annotation.UiThread;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import com.zql.app.shop.core.MyMapActivity_ViewBinding;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CCarActivity_ViewBinding extends MyMapActivity_ViewBinding {
  private CCarActivity target;

  private View view2131298830;

  private View view2131298831;

  private View view2131299429;

  @UiThread
  public CCarActivity_ViewBinding(CCarActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CCarActivity_ViewBinding(final CCarActivity target, View source) {
    super(target, source);

    this.target = target;

    View view;
    target.tabLayout = Utils.findRequiredViewAsType(source, R.id.tablayout, "field 'tabLayout'", TabLayout.class);
    view = Utils.findRequiredView(source, R.id.tv_address1, "field 'tvAddress1' and method 'address1'");
    target.tvAddress1 = Utils.castView(view, R.id.tv_address1, "field 'tvAddress1'", TextView.class);
    view2131298830 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.address1(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_address2, "field 'tvAddress2' and method 'address2'");
    target.tvAddress2 = Utils.castView(view, R.id.tv_address2, "field 'tvAddress2'", TextView.class);
    view2131298831 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.address2(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_time, "field 'tvTime' and method 'selTime'");
    target.tvTime = Utils.castView(view, R.id.tv_time, "field 'tvTime'", TextView.class);
    view2131299429 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.selTime(p0);
      }
    });
  }

  @Override
  public void unbind() {
    CCarActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tabLayout = null;
    target.tvAddress1 = null;
    target.tvAddress2 = null;
    target.tvTime = null;

    view2131298830.setOnClickListener(null);
    view2131298830 = null;
    view2131298831.setOnClickListener(null);
    view2131298831 = null;
    view2131299429.setOnClickListener(null);
    view2131299429 = null;

    super.unbind();
  }
}
