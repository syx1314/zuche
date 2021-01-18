// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.company.yiweicar;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import com.zql.app.shop.view.fragment.common.CommonTabContentFragment_ViewBinding;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FuJInFragment_ViewBinding extends CommonTabContentFragment_ViewBinding {
  private FuJInFragment target;

  private View view2131296530;

  private View view2131296546;

  @UiThread
  public FuJInFragment_ViewBinding(final FuJInFragment target, View source) {
    super(target, source);

    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.tv_cur_position, "field 'tvCurPosition' and method 'goSelectPosition'");
    target.tvCurPosition = Utils.castView(view, R.id.tv_cur_position, "field 'tvCurPosition'", TextView.class);
    view2131296530 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.goSelectPosition();
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_shaixuan, "field 'tvShaixuan' and method 'onViewClicked'");
    target.tvShaixuan = Utils.castView(view, R.id.tv_shaixuan, "field 'tvShaixuan'", TextView.class);
    view2131296546 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
  }

  @Override
  public void unbind() {
    FuJInFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvCurPosition = null;
    target.tvShaixuan = null;

    view2131296530.setOnClickListener(null);
    view2131296530 = null;
    view2131296546.setOnClickListener(null);
    view2131296546 = null;

    super.unbind();
  }
}
