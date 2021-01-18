// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.company;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import com.zql.app.shop.util.view.X5WebView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ShowYQActivity_ViewBinding implements Unbinder {
  private ShowYQActivity target;

  @UiThread
  public ShowYQActivity_ViewBinding(ShowYQActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ShowYQActivity_ViewBinding(ShowYQActivity target, View source) {
    this.target = target;

    target.webView = Utils.findRequiredViewAsType(source, R.id.webView, "field 'webView'", X5WebView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ShowYQActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.webView = null;
  }
}
