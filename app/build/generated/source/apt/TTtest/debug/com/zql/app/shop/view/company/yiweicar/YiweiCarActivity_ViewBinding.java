// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.company.yiweicar;

import android.support.annotation.UiThread;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import com.zql.app.shop.core.MyCommonRefreshActivity_ViewBinding;
import java.lang.IllegalStateException;
import java.lang.Override;

public class YiweiCarActivity_ViewBinding extends MyCommonRefreshActivity_ViewBinding {
  private YiweiCarActivity target;

  private View view2131296365;

  private View view2131296552;

  @UiThread
  public YiweiCarActivity_ViewBinding(YiweiCarActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public YiweiCarActivity_ViewBinding(final YiweiCarActivity target, View source) {
    super(target, source);

    this.target = target;

    View view;
    target.tabLayout = Utils.findRequiredViewAsType(source, R.id.tab, "field 'tabLayout'", TabLayout.class);
    target.tvCurPosition = Utils.findRequiredViewAsType(source, R.id.tv_cur_position, "field 'tvCurPosition'", TextView.class);
    view = Utils.findRequiredView(source, R.id.fb, "field 'fb' and method 'toOrder'");
    target.fb = Utils.castView(view, R.id.fb, "field 'fb'", FloatingActionButton.class);
    view2131296365 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toOrder();
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_shaixuan, "method 'shaixuan'");
    view2131296552 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.shaixuan();
      }
    });
  }

  @Override
  public void unbind() {
    YiweiCarActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tabLayout = null;
    target.tvCurPosition = null;
    target.fb = null;

    view2131296365.setOnClickListener(null);
    view2131296365 = null;
    view2131296552.setOnClickListener(null);
    view2131296552 = null;

    super.unbind();
  }
}
