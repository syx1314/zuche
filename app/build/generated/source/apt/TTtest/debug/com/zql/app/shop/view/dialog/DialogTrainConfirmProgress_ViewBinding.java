// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DialogTrainConfirmProgress_ViewBinding implements Unbinder {
  private DialogTrainConfirmProgress target;

  @UiThread
  public DialogTrainConfirmProgress_ViewBinding(DialogTrainConfirmProgress target, View source) {
    this.target = target;

    target.ivGo = Utils.findRequiredViewAsType(source, R.id.iv_go, "field 'ivGo'", ImageView.class);
    target.tvDate = Utils.findRequiredViewAsType(source, R.id.tv_date, "field 'tvDate'", TextView.class);
    target.tvTrain = Utils.findRequiredViewAsType(source, R.id.tv_train, "field 'tvTrain'", TextView.class);
    target.linback = Utils.findRequiredViewAsType(source, R.id.lin_back, "field 'linback'", LinearLayout.class);
    target.tvbackDate = Utils.findRequiredViewAsType(source, R.id.tv_back_date, "field 'tvbackDate'", TextView.class);
    target.tvbackTrain = Utils.findRequiredViewAsType(source, R.id.tv_back_train, "field 'tvbackTrain'", TextView.class);
    target.tvPerson = Utils.findRequiredViewAsType(source, R.id.tv_person, "field 'tvPerson'", TextView.class);
    target.tvTextProgress = Utils.findRequiredViewAsType(source, R.id.tv_text_progress, "field 'tvTextProgress'", TextView.class);
    target.tvNumProgress = Utils.findRequiredViewAsType(source, R.id.tv_num_progress, "field 'tvNumProgress'", TextView.class);
    target.progressBar = Utils.findRequiredViewAsType(source, R.id.progress, "field 'progressBar'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DialogTrainConfirmProgress target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ivGo = null;
    target.tvDate = null;
    target.tvTrain = null;
    target.linback = null;
    target.tvbackDate = null;
    target.tvbackTrain = null;
    target.tvPerson = null;
    target.tvTextProgress = null;
    target.tvNumProgress = null;
    target.progressBar = null;
  }
}
