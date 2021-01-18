// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.company.expense;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ExpenseOrderDetailsActivity_ViewBinding implements Unbinder {
  private ExpenseOrderDetailsActivity target;

  @UiThread
  public ExpenseOrderDetailsActivity_ViewBinding(ExpenseOrderDetailsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ExpenseOrderDetailsActivity_ViewBinding(ExpenseOrderDetailsActivity target, View source) {
    this.target = target;

    target.tvExpenseNo = Utils.findRequiredViewAsType(source, R.id.tv_expense_no, "field 'tvExpenseNo'", TextView.class);
    target.tvStatus = Utils.findRequiredViewAsType(source, R.id.tv_status, "field 'tvStatus'", TextView.class);
    target.tvStartTime = Utils.findRequiredViewAsType(source, R.id.tv_start_time, "field 'tvStartTime'", TextView.class);
    target.tvEndTime = Utils.findRequiredViewAsType(source, R.id.tv_end_time, "field 'tvEndTime'", TextView.class);
    target.tvDepartment = Utils.findRequiredViewAsType(source, R.id.tv_department, "field 'tvDepartment'", TextView.class);
    target.tvPhone = Utils.findRequiredViewAsType(source, R.id.tv_phone, "field 'tvPhone'", TextView.class);
    target.tvShiyou = Utils.findRequiredViewAsType(source, R.id.tv_shiyou, "field 'tvShiyou'", TextView.class);
    target.tvBeizhu = Utils.findRequiredViewAsType(source, R.id.tv_beizhu, "field 'tvBeizhu'", TextView.class);
    target.tvCreateTime = Utils.findRequiredViewAsType(source, R.id.tv_create_time, "field 'tvCreateTime'", TextView.class);
    target.tvChalvPrice = Utils.findRequiredViewAsType(source, R.id.tv_chalv_price, "field 'tvChalvPrice'", TextView.class);
    target.tvQitaPrice = Utils.findRequiredViewAsType(source, R.id.tv_qita_price, "field 'tvQitaPrice'", TextView.class);
    target.tvJiaotongPrice = Utils.findRequiredViewAsType(source, R.id.tv_jiaotong_price, "field 'tvJiaotongPrice'", TextView.class);
    target.linOrderInfo = Utils.findRequiredViewAsType(source, R.id.lin_order_info, "field 'linOrderInfo'", LinearLayout.class);
    target.tvPrice = Utils.findRequiredViewAsType(source, R.id.tv_price, "field 'tvPrice'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ExpenseOrderDetailsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvExpenseNo = null;
    target.tvStatus = null;
    target.tvStartTime = null;
    target.tvEndTime = null;
    target.tvDepartment = null;
    target.tvPhone = null;
    target.tvShiyou = null;
    target.tvBeizhu = null;
    target.tvCreateTime = null;
    target.tvChalvPrice = null;
    target.tvQitaPrice = null;
    target.tvJiaotongPrice = null;
    target.linOrderInfo = null;
    target.tvPrice = null;
  }
}
