// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.util.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CommonTitleView_ViewBinding implements Unbinder {
  private CommonTitleView target;

  private View view2131296397;

  @UiThread
  public CommonTitleView_ViewBinding(CommonTitleView target) {
    this(target, target);
  }

  @UiThread
  public CommonTitleView_ViewBinding(final CommonTitleView target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.iv_left, "field 'ivLeft' and method 'ivLeft'");
    target.ivLeft = Utils.castView(view, R.id.iv_left, "field 'ivLeft'", ImageView.class);
    view2131296397 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.ivLeft(p0);
      }
    });
    target.tvLeft = Utils.findRequiredViewAsType(source, R.id.tv_left, "field 'tvLeft'", TextView.class);
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.tvRight = Utils.findRequiredViewAsType(source, R.id.tv_right, "field 'tvRight'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CommonTitleView target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ivLeft = null;
    target.tvLeft = null;
    target.tvTitle = null;
    target.tvRight = null;

    view2131296397.setOnClickListener(null);
    view2131296397 = null;
  }
}
