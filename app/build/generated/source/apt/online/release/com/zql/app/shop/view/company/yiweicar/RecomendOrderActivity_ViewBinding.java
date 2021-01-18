// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.company.yiweicar;

import android.support.annotation.UiThread;
import android.support.design.widget.TabLayout;
import android.view.View;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import com.zql.app.shop.core.MyCommonRefreshActivity_ViewBinding;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RecomendOrderActivity_ViewBinding extends MyCommonRefreshActivity_ViewBinding {
  private RecomendOrderActivity target;

  @UiThread
  public RecomendOrderActivity_ViewBinding(RecomendOrderActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public RecomendOrderActivity_ViewBinding(RecomendOrderActivity target, View source) {
    super(target, source);

    this.target = target;

    target.tabLayout = Utils.findRequiredViewAsType(source, R.id.tab, "field 'tabLayout'", TabLayout.class);
    target.tabFilter = Utils.findRequiredViewAsType(source, R.id.tab_filter, "field 'tabFilter'", TabLayout.class);
  }

  @Override
  public void unbind() {
    RecomendOrderActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tabLayout = null;
    target.tabFilter = null;

    super.unbind();
  }
}
