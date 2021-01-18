// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.company;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import com.zql.app.shop.util.view.CommonTitleView;
import com.zql.app.shop.util.view.X5WebView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BLoadHtmlActivity_ViewBinding implements Unbinder {
  private BLoadHtmlActivity target;

  private View view2131297758;

  @UiThread
  public BLoadHtmlActivity_ViewBinding(BLoadHtmlActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public BLoadHtmlActivity_ViewBinding(final BLoadHtmlActivity target, View source) {
    this.target = target;

    View view;
    target.titleView = Utils.findRequiredViewAsType(source, R.id.title, "field 'titleView'", CommonTitleView.class);
    target.webView = Utils.findRequiredViewAsType(source, R.id.webView, "field 'webView'", X5WebView.class);
    view = Utils.findRequiredView(source, R.id.iv_back, "field 'ivBack' and method 'back'");
    target.ivBack = Utils.castView(view, R.id.iv_back, "field 'ivBack'", ImageView.class);
    view2131297758 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.back();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    BLoadHtmlActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.titleView = null;
    target.webView = null;
    target.ivBack = null;

    view2131297758.setOnClickListener(null);
    view2131297758 = null;
  }
}
