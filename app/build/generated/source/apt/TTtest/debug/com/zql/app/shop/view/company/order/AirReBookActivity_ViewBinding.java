// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.company.order;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AirReBookActivity_ViewBinding extends AirReBookAndRefundBaseActivity_ViewBinding {
  private AirReBookActivity target;

  private View view2131299358;

  private View view2131296758;

  private View view2131296763;

  private View view2131296768;

  private View view2131298033;

  private View view2131298120;

  private View view2131298032;

  private View view2131299353;

  @UiThread
  public AirReBookActivity_ViewBinding(AirReBookActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AirReBookActivity_ViewBinding(final AirReBookActivity target, View source) {
    super(target, source);

    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.tv_sel_date, "field 'tvSelDate' and method 'selDate'");
    target.tvSelDate = Utils.castView(view, R.id.tv_sel_date, "field 'tvSelDate'", TextView.class);
    view2131299358 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.selDate(p0);
      }
    });
    target.cbZiyuan = Utils.findRequiredViewAsType(source, R.id.cb_ziyuan, "field 'cbZiyuan'", CheckBox.class);
    target.ivZiyuan = Utils.findRequiredViewAsType(source, R.id.iv_ziyuan, "field 'ivZiyuan'", ImageView.class);
    target.cbNoZiyuan = Utils.findRequiredViewAsType(source, R.id.cb_no_ziyuan, "field 'cbNoZiyuan'", CheckBox.class);
    target.ivNoZiyuan = Utils.findRequiredViewAsType(source, R.id.iv_no_ziyuan, "field 'ivNoZiyuan'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.cb_biandong, "field 'cbBiandong' and method 'selectNoZiyuan'");
    target.cbBiandong = Utils.castView(view, R.id.cb_biandong, "field 'cbBiandong'", CheckBox.class);
    view2131296758 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.selectNoZiyuan(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.cb_hangbanquxiao, "field 'cbHangbanquxiao' and method 'selectNoZiyuan'");
    target.cbHangbanquxiao = Utils.castView(view, R.id.cb_hangbanquxiao, "field 'cbHangbanquxiao'", CheckBox.class);
    view2131296763 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.selectNoZiyuan(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.cb_other, "field 'cbOther' and method 'selectNoZiyuan'");
    target.cbOther = Utils.castView(view, R.id.cb_other, "field 'cbOther'", CheckBox.class);
    view2131296768 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.selectNoZiyuan(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lin_no_ziyuan_content, "field 'linNoZiyuanContent' and method 'onViewClicked'");
    target.linNoZiyuanContent = Utils.castView(view, R.id.lin_no_ziyuan_content, "field 'linNoZiyuanContent'", LinearLayout.class);
    view2131298033 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.rlRefundSelect = Utils.findRequiredViewAsType(source, R.id.rl_refund_select, "field 'rlRefundSelect'", RelativeLayout.class);
    view = Utils.findRequiredView(source, R.id.lin_ziyuan, "method 'onViewClicked'");
    view2131298120 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lin_no_ziyuan, "method 'onViewClicked'");
    view2131298032 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_sel_air, "method 'toSelAir'");
    view2131299353 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toSelAir(p0);
      }
    });
  }

  @Override
  public void unbind() {
    AirReBookActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvSelDate = null;
    target.cbZiyuan = null;
    target.ivZiyuan = null;
    target.cbNoZiyuan = null;
    target.ivNoZiyuan = null;
    target.cbBiandong = null;
    target.cbHangbanquxiao = null;
    target.cbOther = null;
    target.linNoZiyuanContent = null;
    target.rlRefundSelect = null;

    view2131299358.setOnClickListener(null);
    view2131299358 = null;
    view2131296758.setOnClickListener(null);
    view2131296758 = null;
    view2131296763.setOnClickListener(null);
    view2131296763 = null;
    view2131296768.setOnClickListener(null);
    view2131296768 = null;
    view2131298033.setOnClickListener(null);
    view2131298033 = null;
    view2131298120.setOnClickListener(null);
    view2131298120 = null;
    view2131298032.setOnClickListener(null);
    view2131298032 = null;
    view2131299353.setOnClickListener(null);
    view2131299353 = null;

    super.unbind();
  }
}
