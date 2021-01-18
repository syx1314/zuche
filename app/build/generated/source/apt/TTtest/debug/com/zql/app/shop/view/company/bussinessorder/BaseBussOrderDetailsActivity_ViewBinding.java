// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.company.bussinessorder;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import com.zql.app.shop.util.view.CommonTitleView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BaseBussOrderDetailsActivity_ViewBinding implements Unbinder {
  private BaseBussOrderDetailsActivity target;

  @UiThread
  public BaseBussOrderDetailsActivity_ViewBinding(BaseBussOrderDetailsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public BaseBussOrderDetailsActivity_ViewBinding(BaseBussOrderDetailsActivity target,
      View source) {
    this.target = target;

    target.linTitle = Utils.findRequiredViewAsType(source, R.id.lin_tile, "field 'linTitle'", LinearLayout.class);
    target.title = Utils.findRequiredViewAsType(source, R.id.title, "field 'title'", CommonTitleView.class);
    target.tvBussId = Utils.findRequiredViewAsType(source, R.id.tv_buss_id, "field 'tvBussId'", TextView.class);
    target.tvStatus = Utils.findRequiredViewAsType(source, R.id.tv_status, "field 'tvStatus'", TextView.class);
    target.viewDivider = Utils.findRequiredView(source, R.id.view_divider, "field 'viewDivider'");
    target.tvSelBussMan = Utils.findRequiredViewAsType(source, R.id.tv_sel_buss_man, "field 'tvSelBussMan'", TextView.class);
    target.tvStartTime = Utils.findRequiredViewAsType(source, R.id.tv_start_time, "field 'tvStartTime'", TextView.class);
    target.tvEndTime = Utils.findRequiredViewAsType(source, R.id.tv_end_time, "field 'tvEndTime'", TextView.class);
    target.tvCity = Utils.findRequiredViewAsType(source, R.id.tv_city, "field 'tvCity'", TextView.class);
    target.linCb = Utils.findRequiredViewAsType(source, R.id.lin_cb, "field 'linCb'", LinearLayout.class);
    target.tvMod = Utils.findRequiredViewAsType(source, R.id.tv_mod, "field 'tvMod'", TextView.class);
    target.cbAir = Utils.findRequiredViewAsType(source, R.id.cb_air, "field 'cbAir'", CheckBox.class);
    target.cbHotel = Utils.findRequiredViewAsType(source, R.id.cb_hotel, "field 'cbHotel'", CheckBox.class);
    target.cbTrain = Utils.findRequiredViewAsType(source, R.id.cb_train, "field 'cbTrain'", CheckBox.class);
    target.cbSurance = Utils.findRequiredViewAsType(source, R.id.cb_surance, "field 'cbSurance'", CheckBox.class);
    target.cbCar = Utils.findRequiredViewAsType(source, R.id.cb_car, "field 'cbCar'", CheckBox.class);
    target.tvPurpose = Utils.findRequiredViewAsType(source, R.id.tv_purpose, "field 'tvPurpose'", EditText.class);
    target.tvShiqin = Utils.findRequiredViewAsType(source, R.id.tv_shiqin, "field 'tvShiqin'", EditText.class);
    target.tvSendApprove = Utils.findOptionalViewAsType(source, R.id.tv_send_approve, "field 'tvSendApprove'", TextView.class);
    target.tvSave = Utils.findOptionalViewAsType(source, R.id.tv_save, "field 'tvSave'", TextView.class);
    target.tvDel = Utils.findOptionalViewAsType(source, R.id.tv_del, "field 'tvDel'", TextView.class);
    target.viewCreateTime = source.findViewById(R.id.view_create_time);
    target.linCreateTime = Utils.findRequiredViewAsType(source, R.id.lin_create_time, "field 'linCreateTime'", LinearLayout.class);
    target.tvCreateTime = Utils.findRequiredViewAsType(source, R.id.tv_create_time, "field 'tvCreateTime'", TextView.class);
    target.tvAdvance = Utils.findRequiredViewAsType(source, R.id.tv_addvance, "field 'tvAdvance'", TextView.class);
    target.linBottom = Utils.findRequiredViewAsType(source, R.id.lin_bottom, "field 'linBottom'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    BaseBussOrderDetailsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.linTitle = null;
    target.title = null;
    target.tvBussId = null;
    target.tvStatus = null;
    target.viewDivider = null;
    target.tvSelBussMan = null;
    target.tvStartTime = null;
    target.tvEndTime = null;
    target.tvCity = null;
    target.linCb = null;
    target.tvMod = null;
    target.cbAir = null;
    target.cbHotel = null;
    target.cbTrain = null;
    target.cbSurance = null;
    target.cbCar = null;
    target.tvPurpose = null;
    target.tvShiqin = null;
    target.tvSendApprove = null;
    target.tvSave = null;
    target.tvDel = null;
    target.viewCreateTime = null;
    target.linCreateTime = null;
    target.tvCreateTime = null;
    target.tvAdvance = null;
    target.linBottom = null;
  }
}
