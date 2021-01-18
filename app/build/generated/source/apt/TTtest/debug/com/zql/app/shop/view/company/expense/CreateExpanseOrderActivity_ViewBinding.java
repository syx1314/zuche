// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.company.expense;

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

public class CreateExpanseOrderActivity_ViewBinding implements Unbinder {
  private CreateExpanseOrderActivity target;

  private View view2131299386;

  private View view2131299032;

  private View view2131299501;

  private View view2131299499;

  private View view2131299498;

  private View view2131299338;

  private View view2131298978;

  private View view2131298998;

  private View view2131298828;

  @UiThread
  public CreateExpanseOrderActivity_ViewBinding(CreateExpanseOrderActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CreateExpanseOrderActivity_ViewBinding(final CreateExpanseOrderActivity target,
      View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.tv_start_time, "field 'tvStartTime' and method 'onViewClicked'");
    target.tvStartTime = Utils.castView(view, R.id.tv_start_time, "field 'tvStartTime'", TextView.class);
    view2131299386 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_end_time, "field 'tvEndTime' and method 'onViewClicked'");
    target.tvEndTime = Utils.castView(view, R.id.tv_end_time, "field 'tvEndTime'", TextView.class);
    view2131299032 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvDepartment = Utils.findRequiredViewAsType(source, R.id.tv_department, "field 'tvDepartment'", TextView.class);
    target.tvPhone = Utils.findRequiredViewAsType(source, R.id.tv_phone, "field 'tvPhone'", EditText.class);
    target.tvShiyou = Utils.findRequiredViewAsType(source, R.id.tv_shiyou, "field 'tvShiyou'", EditText.class);
    target.tvBeizhu = Utils.findRequiredViewAsType(source, R.id.tv_beizhu, "field 'tvBeizhu'", EditText.class);
    target.tvCreateTime = Utils.findRequiredViewAsType(source, R.id.tv_create_time, "field 'tvCreateTime'", TextView.class);
    target.tvChalvPrice = Utils.findRequiredViewAsType(source, R.id.tv_chalv_price, "field 'tvChalvPrice'", TextView.class);
    target.tvQitaPrice = Utils.findRequiredViewAsType(source, R.id.tv_qita_price, "field 'tvQitaPrice'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_update_qita, "field 'tvUpdateQita' and method 'onViewClicked'");
    target.tvUpdateQita = Utils.castView(view, R.id.tv_update_qita, "field 'tvUpdateQita'", TextView.class);
    view2131299501 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvJiaotongPrice = Utils.findRequiredViewAsType(source, R.id.tv_jiaotong_price, "field 'tvJiaotongPrice'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_update_jiaotong, "field 'tvUpdateJiaotong' and method 'onViewClicked'");
    target.tvUpdateJiaotong = Utils.castView(view, R.id.tv_update_jiaotong, "field 'tvUpdateJiaotong'", TextView.class);
    view2131299499 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.linOrderInfo = Utils.findRequiredViewAsType(source, R.id.lin_order_info, "field 'linOrderInfo'", LinearLayout.class);
    target.tvPrice = Utils.findRequiredViewAsType(source, R.id.tv_price, "field 'tvPrice'", TextView.class);
    target.linCreateTime = Utils.findRequiredViewAsType(source, R.id.lin_create_time, "field 'linCreateTime'", LinearLayout.class);
    target.viewCreateTime = Utils.findRequiredView(source, R.id.view_create_time, "field 'viewCreateTime'");
    view = Utils.findRequiredView(source, R.id.tv_update_chalv, "field 'tvUpdateChalv' and method 'onViewClicked'");
    target.tvUpdateChalv = Utils.castView(view, R.id.tv_update_chalv, "field 'tvUpdateChalv'", TextView.class);
    view2131299498 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_save, "field 'tvSave' and method 'onViewClicked'");
    target.tvSave = Utils.castView(view, R.id.tv_save, "field 'tvSave'", TextView.class);
    view2131299338 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvExpenseNo = Utils.findRequiredViewAsType(source, R.id.tv_expense_no, "field 'tvExpenseNo'", TextView.class);
    target.tvStatus = Utils.findRequiredViewAsType(source, R.id.tv_status, "field 'tvStatus'", TextView.class);
    target.linNo = Utils.findRequiredViewAsType(source, R.id.lin_no, "field 'linNo'", LinearLayout.class);
    target.viewDivider = Utils.findRequiredView(source, R.id.view_divider, "field 'viewDivider'");
    view = Utils.findRequiredView(source, R.id.tv_confirm, "field 'tvConfirm' and method 'onViewClicked'");
    target.tvConfirm = Utils.castView(view, R.id.tv_confirm, "field 'tvConfirm'", TextView.class);
    view2131298978 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_del, "field 'tvDel' and method 'onViewClicked'");
    target.tvDel = Utils.castView(view, R.id.tv_del, "field 'tvDel'", TextView.class);
    view2131298998 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_add_order, "method 'onViewClicked'");
    view2131298828 = view;
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
    CreateExpanseOrderActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvStartTime = null;
    target.tvEndTime = null;
    target.tvDepartment = null;
    target.tvPhone = null;
    target.tvShiyou = null;
    target.tvBeizhu = null;
    target.tvCreateTime = null;
    target.tvChalvPrice = null;
    target.tvQitaPrice = null;
    target.tvUpdateQita = null;
    target.tvJiaotongPrice = null;
    target.tvUpdateJiaotong = null;
    target.linOrderInfo = null;
    target.tvPrice = null;
    target.linCreateTime = null;
    target.viewCreateTime = null;
    target.tvUpdateChalv = null;
    target.tvSave = null;
    target.tvExpenseNo = null;
    target.tvStatus = null;
    target.linNo = null;
    target.viewDivider = null;
    target.tvConfirm = null;
    target.tvDel = null;

    view2131299386.setOnClickListener(null);
    view2131299386 = null;
    view2131299032.setOnClickListener(null);
    view2131299032 = null;
    view2131299501.setOnClickListener(null);
    view2131299501 = null;
    view2131299499.setOnClickListener(null);
    view2131299499 = null;
    view2131299498.setOnClickListener(null);
    view2131299498 = null;
    view2131299338.setOnClickListener(null);
    view2131299338 = null;
    view2131298978.setOnClickListener(null);
    view2131298978 = null;
    view2131298998.setOnClickListener(null);
    view2131298998 = null;
    view2131298828.setOnClickListener(null);
    view2131298828 = null;
  }
}
