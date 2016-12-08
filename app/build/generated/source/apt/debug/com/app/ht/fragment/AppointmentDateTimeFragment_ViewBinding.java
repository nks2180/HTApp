// Generated code from Butter Knife. Do not modify!
package com.app.ht.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.app.ht.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AppointmentDateTimeFragment_ViewBinding<T extends AppointmentDateTimeFragment> implements Unbinder {
  protected T target;

  @UiThread
  public AppointmentDateTimeFragment_ViewBinding(T target, View source) {
    this.target = target;

    target.recyclerVwSlots = Utils.findRequiredViewAsType(source, R.id.recyclerVw_slots, "field 'recyclerVwSlots'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.recyclerVwSlots = null;

    this.target = null;
  }
}
