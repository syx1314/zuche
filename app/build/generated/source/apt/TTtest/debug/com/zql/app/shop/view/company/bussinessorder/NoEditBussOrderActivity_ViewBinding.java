// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.company.bussinessorder;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NoEditBussOrderActivity_ViewBinding extends BaseBussOrderDetailsActivity_ViewBinding {
  private NoEditBussOrderActivity target;

  private View view2131298833;

  @UiThread
  public NoEditBussOrderActivity_ViewBinding(NoEditBussOrderActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public NoEditBussOrderActivity_ViewBinding(final NoEditBussOrderActivity target, View source) {
    super(target, source);

    this.target = target;

    View view;
    target.linTrip = Utils.findRequiredViewAsType(source, R.id.lin_trip, "field 'linTrip'", LinearLayout.class);
    target.tvPoint1 = Utils.findRequiredViewAsType(source, R.id.tv_point1, "field 'tvPoint1'", TextView.class);
    target.tvPoint2 = Utils.findRequiredViewAsType(source, R.id.tv_point2, "field 'tvPoint2'", TextView.class);
    target.tvPoint3 = Utils.findRequiredViewAsType(source, R.id.tv_point3, "field 'tvPoint3'", TextView.class);
    target.tvPoint4 = Utils.findRequiredViewAsType(source, R.id.tv_point4, "field 'tvPoint4'", TextView.class);
    target.tvPoint5 = Utils.findRequiredViewAsType(source, R.id.tv_point5, "field 'tvPoint5'", TextView.class);
    target.linApproveContent = Utils.findRequiredViewAsType(source, R.id.lin_approve_content, "field 'linApproveContent'", LinearLayout.class);
    target.linApprove = Utils.findRequiredViewAsType(source, R.id.lin_approve, "field 'linApprove'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.tv_addvance, "method 'onViewClicked'");
    view2131298833 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  public void unbind() {
    NoEditBussOrderActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.linTrip = null;
    target.tvPoint1 = null;
    target.tvPoint2 = null;
    target.tvPoint3 = null;
    target.tvPoint4 = null;
    target.tvPoint5 = null;
    target.linApproveContent = null;
    target.linApprove = null;

    view2131298833.setOnClickListener(null);
    view2131298833 = null;

    super.unbind();
  }
}
