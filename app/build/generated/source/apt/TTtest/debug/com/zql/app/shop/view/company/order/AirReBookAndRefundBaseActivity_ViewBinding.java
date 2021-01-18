// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.company.order;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import com.zql.app.shop.util.view.CommonTitleView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AirReBookAndRefundBaseActivity_ViewBinding implements Unbinder {
  private AirReBookAndRefundBaseActivity target;

  private View view2131299209;

  @UiThread
  public AirReBookAndRefundBaseActivity_ViewBinding(AirReBookAndRefundBaseActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AirReBookAndRefundBaseActivity_ViewBinding(final AirReBookAndRefundBaseActivity target,
      View source) {
    this.target = target;

    View view;
    target.titleView = Utils.findRequiredViewAsType(source, R.id.title, "field 'titleView'", CommonTitleView.class);
    target.rvAirPeople = Utils.findRequiredViewAsType(source, R.id.rv_air_people, "field 'rvAirPeople'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.tv_no_rebook, "field 'tvNoRebook' and method 'noReBook'");
    target.tvNoRebook = Utils.castView(view, R.id.tv_no_rebook, "field 'tvNoRebook'", TextView.class);
    view2131299209 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.noReBook(p0);
      }
    });
    target.tvSelAir = Utils.findRequiredViewAsType(source, R.id.tv_sel_air, "field 'tvSelAir'", TextView.class);
    target.rlDate = Utils.findRequiredViewAsType(source, R.id.rl_date, "field 'rlDate'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AirReBookAndRefundBaseActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.titleView = null;
    target.rvAirPeople = null;
    target.tvNoRebook = null;
    target.tvSelAir = null;
    target.rlDate = null;

    view2131299209.setOnClickListener(null);
    view2131299209 = null;
  }
}
