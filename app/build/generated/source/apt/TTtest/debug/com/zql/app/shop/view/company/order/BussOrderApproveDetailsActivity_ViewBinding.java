// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.company.order;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import com.zql.app.shop.view.company.bussinessorder.BaseBussOrderDetailsActivity_ViewBinding;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BussOrderApproveDetailsActivity_ViewBinding extends BaseBussOrderDetailsActivity_ViewBinding {
  private BussOrderApproveDetailsActivity target;

  private View view2131299254;

  private View view2131299311;

  @UiThread
  public BussOrderApproveDetailsActivity_ViewBinding(BussOrderApproveDetailsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public BussOrderApproveDetailsActivity_ViewBinding(final BussOrderApproveDetailsActivity target,
      View source) {
    super(target, source);

    this.target = target;

    View view;
    target.linTrip = Utils.findRequiredViewAsType(source, R.id.lin_trip, "field 'linTrip'", LinearLayout.class);
    target.tvPoint1 = Utils.findRequiredViewAsType(source, R.id.tv_point1, "field 'tvPoint1'", TextView.class);
    target.tvPoint2 = Utils.findRequiredViewAsType(source, R.id.tv_point2, "field 'tvPoint2'", TextView.class);
    target.tvPoint3 = Utils.findRequiredViewAsType(source, R.id.tv_point3, "field 'tvPoint3'", TextView.class);
    target.tvPoint4 = Utils.findRequiredViewAsType(source, R.id.tv_point4, "field 'tvPoint4'", TextView.class);
    target.tvPoint5 = Utils.findRequiredViewAsType(source, R.id.tv_point5, "field 'tvPoint5'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_pass, "method 'onViewClicked'");
    view2131299254 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_refuse, "method 'refuse'");
    view2131299311 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.refuse(p0);
      }
    });
  }

  @Override
  public void unbind() {
    BussOrderApproveDetailsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.linTrip = null;
    target.tvPoint1 = null;
    target.tvPoint2 = null;
    target.tvPoint3 = null;
    target.tvPoint4 = null;
    target.tvPoint5 = null;

    view2131299254.setOnClickListener(null);
    view2131299254 = null;
    view2131299311.setOnClickListener(null);
    view2131299311 = null;

    super.unbind();
  }
}
