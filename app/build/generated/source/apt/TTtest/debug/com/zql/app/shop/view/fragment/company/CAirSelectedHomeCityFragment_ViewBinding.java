// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.fragment.company;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import com.zql.app.shop.util.view.SideBar;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CAirSelectedHomeCityFragment_ViewBinding implements Unbinder {
  private CAirSelectedHomeCityFragment target;

  private View view2131299356;

  private View view2131299095;

  @UiThread
  public CAirSelectedHomeCityFragment_ViewBinding(final CAirSelectedHomeCityFragment target,
      View source) {
    this.target = target;

    View view;
    target.rvCity = Utils.findRequiredViewAsType(source, R.id.rv_city, "field 'rvCity'", RecyclerView.class);
    target.viewSideBar = Utils.findRequiredViewAsType(source, R.id.view_sideBar, "field 'viewSideBar'", SideBar.class);
    view = Utils.findRequiredView(source, R.id.tv_sel_city_history, "method 'onViewClicked'");
    view2131299356 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_hot_city, "method 'onViewClicked'");
    view2131299095 = view;
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
    CAirSelectedHomeCityFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rvCity = null;
    target.viewSideBar = null;

    view2131299356.setOnClickListener(null);
    view2131299356 = null;
    view2131299095.setOnClickListener(null);
    view2131299095 = null;
  }
}
