package com.app.ht.viewHolders;

import android.view.View;
import android.widget.LinearLayout;

import com.app.ht.R;
import com.app.ht.customViews.HFTextView;

/**
 * Created by niranjan on 12/8/16.
 */

public class TimeSlotRowHolder extends MyBaseViewHolder {
    public HFTextView txtVw_slotTime;
    public LinearLayout lnrLyt_slotTime;

    public TimeSlotRowHolder(View v) {
        super(v);
        txtVw_slotTime = (HFTextView) v.findViewById(R.id.txtVw_slotTime);
        lnrLyt_slotTime = (LinearLayout) v.findViewById(R.id.lnrLyt_slotTime);
    }
}
