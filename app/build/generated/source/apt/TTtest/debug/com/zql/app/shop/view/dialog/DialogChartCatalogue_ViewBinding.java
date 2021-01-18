// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.RadioGroup;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DialogChartCatalogue_ViewBinding implements Unbinder {
  private DialogChartCatalogue target;

  @UiThread
  public DialogChartCatalogue_ViewBinding(DialogChartCatalogue target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DialogChartCatalogue_ViewBinding(DialogChartCatalogue target, View source) {
    this.target = target;

    target.rg = Utils.findRequiredViewAsType(source, R.id.rg, "field 'rg'", RadioGroup.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DialogChartCatalogue target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rg = null;
  }
}
