// Generated code from Butter Knife. Do not modify!
package com.zql.app.shop.view.company.user;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zql.app.shop.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Account12306PassagerVerifActivity_ViewBinding implements Unbinder {
  private Account12306PassagerVerifActivity target;

  private View view2131298986;

  private View view2131299263;

  private View view2131299068;

  private View view2131299310;

  @UiThread
  public Account12306PassagerVerifActivity_ViewBinding(Account12306PassagerVerifActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public Account12306PassagerVerifActivity_ViewBinding(final Account12306PassagerVerifActivity target,
      View source) {
    this.target = target;

    View view;
    target.tvMsgTips = Utils.findRequiredViewAsType(source, R.id.tv_msg_tips, "field 'tvMsgTips'", TextView.class);
    target.tvCode = Utils.findRequiredViewAsType(source, R.id.tv_code, "field 'tvCode'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_copy, "field 'tvCopy' and method 'onViewClicked'");
    target.tvCopy = Utils.castView(view, R.id.tv_copy, "field 'tvCopy'", TextView.class);
    view2131298986 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvDaoTime = Utils.findRequiredViewAsType(source, R.id.tv_dao_time, "field 'tvDaoTime'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_phone_yanzheng, "field 'tvPhoneYanzheng' and method 'onViewClicked'");
    target.tvPhoneYanzheng = Utils.castView(view, R.id.tv_phone_yanzheng, "field 'tvPhoneYanzheng'", TextView.class);
    view2131299263 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_friend, "field 'tvFriend' and method 'onViewClicked'");
    target.tvFriend = Utils.castView(view, R.id.tv_friend, "field 'tvFriend'", TextView.class);
    view2131299068 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvHeyanStatus = Utils.findRequiredViewAsType(source, R.id.tv_heyan_status, "field 'tvHeyanStatus'", TextView.class);
    target.tv_auto_refresh = Utils.findRequiredViewAsType(source, R.id.tv_auto_refresh, "field 'tv_auto_refresh'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_refresh, "method 'onViewClicked'");
    view2131299310 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    Account12306PassagerVerifActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvMsgTips = null;
    target.tvCode = null;
    target.tvCopy = null;
    target.tvDaoTime = null;
    target.tvPhoneYanzheng = null;
    target.tvFriend = null;
    target.tvHeyanStatus = null;
    target.tv_auto_refresh = null;

    view2131298986.setOnClickListener(null);
    view2131298986 = null;
    view2131299263.setOnClickListener(null);
    view2131299263 = null;
    view2131299068.setOnClickListener(null);
    view2131299068 = null;
    view2131299310.setOnClickListener(null);
    view2131299310 = null;
  }
}
