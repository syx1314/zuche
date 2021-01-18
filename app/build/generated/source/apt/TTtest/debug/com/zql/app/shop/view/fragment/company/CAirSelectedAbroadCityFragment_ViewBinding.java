// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.fragment.company;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CAirSelectedAbroadCityFragment_ViewBinding implements Unbinder {
  private CAirSelectedAbroadCityFragment target;

  @UiThread
  public CAirSelectedAbroadCityFragment_ViewBinding(CAirSelectedAbroadCityFragment target,
      View source) {
    this.target = target;

    target.rvContinent = Utils.findRequiredViewAsType(source, R.id.rv_continent, "field 'rvContinent'", RecyclerView.class);
    target.rvCity = Utils.findRequiredViewAsType(source, R.id.rv_city, "field 'rvCity'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CAirSelectedAbroadCityFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rvContinent = null;
    target.rvCity = null;
  }
}
