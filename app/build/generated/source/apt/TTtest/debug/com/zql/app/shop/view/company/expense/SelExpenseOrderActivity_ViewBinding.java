// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.company.expense;

import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.andview.refreshview.XRefreshView;
import com.zql.app.shop.R;
import com.zql.app.shop.core.MyCommonRefreshActivity_ViewBinding;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SelExpenseOrderActivity_ViewBinding extends MyCommonRefreshActivity_ViewBinding {
  private SelExpenseOrderActivity target;

  private View view2131299339;

  private View view2131299198;

  @UiThread
  public SelExpenseOrderActivity_ViewBinding(SelExpenseOrderActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SelExpenseOrderActivity_ViewBinding(final SelExpenseOrderActivity target, View source) {
    super(target, source);

    this.target = target;

    View view;
    target.tvSearchPeople = Utils.findRequiredViewAsType(source, R.id.tv_search_people, "field 'tvSearchPeople'", EditText.class);
    target.linSearch = Utils.findRequiredViewAsType(source, R.id.lin_search, "field 'linSearch'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.tv_search, "field 'etSearch' and method 'searchName'");
    target.etSearch = Utils.castView(view, R.id.tv_search, "field 'etSearch'", TextView.class);
    view2131299339 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.searchName(p0);
      }
    });
    target.rv = Utils.findRequiredViewAsType(source, R.id.rv, "field 'rv'", RecyclerView.class);
    target.xrefreshview = Utils.findRequiredViewAsType(source, R.id.xrefreshview, "field 'xrefreshview'", XRefreshView.class);
    target.tvPrice = Utils.findRequiredViewAsType(source, R.id.tv_price, "field 'tvPrice'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_next, "method 'next'");
    view2131299198 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.next(p0);
      }
    });
  }

  @Override
  public void unbind() {
    SelExpenseOrderActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvSearchPeople = null;
    target.linSearch = null;
    target.etSearch = null;
    target.rv = null;
    target.xrefreshview = null;
    target.tvPrice = null;

    view2131299339.setOnClickListener(null);
    view2131299339 = null;
    view2131299198.setOnClickListener(null);
    view2131299198 = null;

    super.unbind();
  }
}
