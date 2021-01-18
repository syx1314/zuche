// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.company.air;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CInterAirCabinActivity_ViewBinding implements Unbinder {
  private CInterAirCabinActivity target;

  private View view2131296295;

  @UiThread
  public CInterAirCabinActivity_ViewBinding(CInterAirCabinActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CInterAirCabinActivity_ViewBinding(final CInterAirCabinActivity target, View source) {
    this.target = target;

    View view;
    target.tvStartplace = Utils.findRequiredViewAsType(source, R.id.airplane_query_list_top_title_left_startplace, "field 'tvStartplace'", TextView.class);
    target.ivCenterArrow = Utils.findRequiredViewAsType(source, R.id.airplane_query_list_top_title_center_arrow, "field 'ivCenterArrow'", ImageView.class);
    target.tvArriveplace = Utils.findRequiredViewAsType(source, R.id.airplane_query_list_top_title_right_arriveplace, "field 'tvArriveplace'", TextView.class);
    target.rvAirCabin = Utils.findRequiredViewAsType(source, R.id.rv_air_cabin, "field 'rvAirCabin'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.airplane_query_list_top_title_left_back, "method 'onViewClicked'");
    view2131296295 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    CInterAirCabinActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvStartplace = null;
    target.ivCenterArrow = null;
    target.tvArriveplace = null;
    target.rvAirCabin = null;

    view2131296295.setOnClickListener(null);
    view2131296295 = null;
  }
}
