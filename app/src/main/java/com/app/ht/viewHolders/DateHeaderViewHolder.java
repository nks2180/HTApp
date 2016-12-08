package com.app.ht.viewHolders;

import android.view.View;
import android.widget.ImageView;

import com.app.ht.R;
import com.app.ht.customViews.HFTextView;

/**
 * Created by niranjan on 12/8/16.
 */

public class DateHeaderViewHolder  extends MyBaseViewHolder {
    public ImageView imgVw_chevron;
    public HFTextView txtVw_slotHeader, txtVw_slotCount;

    public DateHeaderViewHolder(View v) {
        super(v);
        imgVw_chevron = (ImageView) v.findViewById(R.id.imgVw_chevron);
        txtVw_slotHeader = (HFTextView) v.findViewById(R.id.txtVw_slotHeader);
        txtVw_slotCount = (HFTextView) v.findViewById(R.id.txtVw_slotCount);
    }
}
