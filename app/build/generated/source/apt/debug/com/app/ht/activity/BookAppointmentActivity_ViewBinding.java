// Generated code from Butter Knife. Do not modify!
package com.app.ht.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.app.ht.R;
import com.app.ht.customViews.HFTextView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BookAppointmentActivity_ViewBinding<T extends BookAppointmentActivity> implements Unbinder {
  protected T target;

  @UiThread
  public BookAppointmentActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.txtVwMonthName = Utils.findRequiredViewAsType(source, R.id.txtVw_monthName, "field 'txtVwMonthName'", HFTextView.class);
    target.tabLayout = Utils.findRequiredViewAsType(source, R.id.tabLayout, "field 'tabLayout'", TabLayout.class);
    target.viewPagerDateSlots = Utils.findRequiredViewAsType(source, R.id.viewPager_dateSlots, "field 'viewPagerDateSlots'", ViewPager.class);
    target.prgrsLoading = Utils.findRequiredViewAsType(source, R.id.prgrs_loading, "field 'prgrsLoading'", ProgressBar.class);
    target.lnrlytTab = Utils.findRequiredViewAsType(source, R.id.lnrlyt_tab, "field 'lnrlytTab'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.txtVwMonthName = null;
    target.tabLayout = null;
    target.viewPagerDateSlots = null;
    target.prgrsLoading = null;
    target.lnrlytTab = null;

    this.target = null;
  }
}
