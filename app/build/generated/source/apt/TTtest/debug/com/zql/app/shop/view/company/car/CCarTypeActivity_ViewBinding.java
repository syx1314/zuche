// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.company.car;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import com.zql.app.shop.core.MyMapActivity_ViewBinding;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CCarTypeActivity_ViewBinding extends MyMapActivity_ViewBinding {
  private CCarTypeActivity target;

  private View view2131297645;

  private View view2131297646;

  private View view2131297647;

  private View view2131297648;

  private View view2131296355;

  @UiThread
  public CCarTypeActivity_ViewBinding(CCarTypeActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CCarTypeActivity_ViewBinding(final CCarTypeActivity target, View source) {
    super(target, source);

    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.fl_car1, "field 'flCar1' and method 'selCar1'");
    target.flCar1 = Utils.castView(view, R.id.fl_car1, "field 'flCar1'", FrameLayout.class);
    view2131297645 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.selCar1(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.fl_car2, "field 'flCar2' and method 'selCar2'");
    target.flCar2 = Utils.castView(view, R.id.fl_car2, "field 'flCar2'", FrameLayout.class);
    view2131297646 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.selCar2(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.fl_car3, "field 'flCar3' and method 'selCar3'");
    target.flCar3 = Utils.castView(view, R.id.fl_car3, "field 'flCar3'", FrameLayout.class);
    view2131297647 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.selCar3(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.fl_car4, "field 'flCar4' and method 'selCar4'");
    target.flCar4 = Utils.castView(view, R.id.fl_car4, "field 'flCar4'", FrameLayout.class);
    view2131297648 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.selCar4(p0);
      }
    });
    target.ivCarSel1 = Utils.findRequiredViewAsType(source, R.id.iv_car_sel1, "field 'ivCarSel1'", ImageView.class);
    target.ivCarSel2 = Utils.findRequiredViewAsType(source, R.id.iv_car_sel2, "field 'ivCarSel2'", ImageView.class);
    target.ivCarSel3 = Utils.findRequiredViewAsType(source, R.id.iv_car_sel3, "field 'ivCarSel3'", ImageView.class);
    target.ivCarSel4 = Utils.findRequiredViewAsType(source, R.id.iv_car_sel4, "field 'ivCarSel4'", ImageView.class);
    target.tvCarType = Utils.findRequiredViewAsType(source, R.id.tv_car_type, "field 'tvCarType'", TextView.class);
    target.tvCarIntroduce = Utils.findRequiredViewAsType(source, R.id.tv_car_introduce, "field 'tvCarIntroduce'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_sel_car_next, "method 'next'");
    view2131296355 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.next(p0);
      }
    });
  }

  @Override
  public void unbind() {
    CCarTypeActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.flCar1 = null;
    target.flCar2 = null;
    target.flCar3 = null;
    target.flCar4 = null;
    target.ivCarSel1 = null;
    target.ivCarSel2 = null;
    target.ivCarSel3 = null;
    target.ivCarSel4 = null;
    target.tvCarType = null;
    target.tvCarIntroduce = null;

    view2131297645.setOnClickListener(null);
    view2131297645 = null;
    view2131297646.setOnClickListener(null);
    view2131297646 = null;
    view2131297647.setOnClickListener(null);
    view2131297647 = null;
    view2131297648.setOnClickListener(null);
    view2131297648 = null;
    view2131296355.setOnClickListener(null);
    view2131296355 = null;

    super.unbind();
  }
}
