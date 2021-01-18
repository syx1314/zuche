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

public class CreateBussOrderActivity_ViewBinding extends BaseBussOrderDetailsActivity_ViewBinding {
  private CreateBussOrderActivity target;

  private View view2131299364;

  private View view2131299386;

  private View view2131299032;

  private View view2131299354;

  private View view2131299338;

  private View view2131298998;

  private View view2131298963;

  @UiThread
  public CreateBussOrderActivity_ViewBinding(CreateBussOrderActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CreateBussOrderActivity_ViewBinding(final CreateBussOrderActivity target, View source) {
    super(target, source);

    this.target = target;

    View view;
    target.linApprove = Utils.findRequiredViewAsType(source, R.id.lin_approve, "field 'linApprove'", LinearLayout.class);
    target.linApproveContent = Utils.findRequiredViewAsType(source, R.id.lin_approve_content, "field 'linApproveContent'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.tv_send_approve, "field 'tvSendApprove' and method 'onViewClicked'");
    target.tvSendApprove = Utils.castView(view, R.id.tv_send_approve, "field 'tvSendApprove'", TextView.class);
    view2131299364 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_start_time, "method 'onViewClicked'");
    view2131299386 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_end_time, "method 'onViewClicked'");
    view2131299032 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_sel_buss_man, "method 'onViewClicked'");
    view2131299354 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_save, "method 'onViewClicked'");
    view2131299338 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_del, "method 'onViewClicked'");
    view2131298998 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_city, "method 'onViewClicked'");
    view2131298963 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  public void unbind() {
    CreateBussOrderActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.linApprove = null;
    target.linApproveContent = null;
    target.tvSendApprove = null;

    view2131299364.setOnClickListener(null);
    view2131299364 = null;
    view2131299386.setOnClickListener(null);
    view2131299386 = null;
    view2131299032.setOnClickListener(null);
    view2131299032 = null;
    view2131299354.setOnClickListener(null);
    view2131299354 = null;
    view2131299338.setOnClickListener(null);
    view2131299338 = null;
    view2131298998.setOnClickListener(null);
    view2131298998 = null;
    view2131298963.setOnClickListener(null);
    view2131298963 = null;

    super.unbind();
  }
}
