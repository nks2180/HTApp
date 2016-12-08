package com.app.ht.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.ht.R;
import com.app.ht.model.AppointmentDateSlot;
import com.app.ht.model.TimingSlot;
import com.app.ht.utils.HtUtils;
import com.app.ht.viewHolders.DateHeaderViewHolder;
import com.app.ht.viewHolders.TimeSlotRowHolder;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemAdapter;

import java.util.Date;
import java.util.List;

/**
 * Created by niranjan on 12/7/16.
 */

public class DateTimeSlotAdapter extends AbstractExpandableItemAdapter<DateHeaderViewHolder, TimeSlotRowHolder> {

    private static int GROUP_COUNT = 3;
    AppointmentDateSlot mDateTimeSlot;

    public DateTimeSlotAdapter(AppointmentDateSlot dateTimeSlot) {
        this.mDateTimeSlot = dateTimeSlot;
        setHasStableIds(true);
    }

    @Override
    public int getGroupCount() {
        return GROUP_COUNT;
    }

    @Override
    public int getChildCount(int groupPosition) {
        switch (groupPosition) {
            case 0:
                return mDateTimeSlot.getMorning().size();
            case 1:
                return mDateTimeSlot.getAfternoon().size();
            case 2:
                return mDateTimeSlot.getEvening().size();
            default:
                return 0;
        }
    }

    @Override
    public long getGroupId(int groupPosition) {
        return HtUtils.DEFAULT_GROUP_ID + groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return HtUtils.DEFAULT_CHILD_ID + childPosition;
    }

    @Override
    public DateHeaderViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View v = inflater.inflate(R.layout.layout_slot_header, parent, false);
        return new DateHeaderViewHolder(v);
    }

    @Override
    public TimeSlotRowHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View v = inflater.inflate(R.layout.layout_slot_time, parent, false);
        return new TimeSlotRowHolder(v);
    }

    @Override
    public void onBindGroupViewHolder(DateHeaderViewHolder holder, int groupPosition, int viewType) {
        int slotCount = 0;
        switch (groupPosition) {
            case 0:
                slotCount = mDateTimeSlot.getMorning().size();
                holder.txtVw_slotHeader.setText("Morning");
                break;
            case 1:
                slotCount = mDateTimeSlot.getAfternoon().size();
                holder.txtVw_slotHeader.setText("AfterNoon");
                break;
            case 2:
                slotCount = mDateTimeSlot.getEvening().size();
                holder.txtVw_slotHeader.setText("Evening");
                break;

        }
        holder.itemView.setClickable(true);

        if (slotCount > 0)
            holder.imgVw_chevron.setVisibility(View.VISIBLE);
        else
            holder.imgVw_chevron.setVisibility(View.INVISIBLE);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.imgVw_chevron.animate().rotationBy(180);
            }
        });
        holder.txtVw_slotCount.setText(slotCount + (slotCount > 1 ? " Slots Available" : " Slot Available"));

    }

    @Override
    public void onBindChildViewHolder(TimeSlotRowHolder holder, int groupPosition, int childPosition, int viewType) {
        try {
            List<TimingSlot> timingSlots = null;
            switch (groupPosition) {
                case 0:
                    timingSlots = mDateTimeSlot.getMorning();
                    break;
                case 1:
                    timingSlots = mDateTimeSlot.getAfternoon();
                    break;
                case 2:
                    timingSlots = mDateTimeSlot.getEvening();
                    break;
            }
            TimingSlot timeSlot = timingSlots.get(childPosition);
            Date startDate = HtUtils.parseDateString(HtUtils.yyyyMMddhhmmZ, timeSlot.getStartTime());
            Date endDate = HtUtils.parseDateString(HtUtils.yyyyMMddhhmmZ, timeSlot.getEndTime());
            holder.txtVw_slotTime.setText(HtUtils.formatDate(HtUtils.hhmma, startDate) + " - " + HtUtils.formatDate(HtUtils.hhmma, endDate));
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public boolean onCheckCanExpandOrCollapseGroup(DateHeaderViewHolder holder, int groupPosition, int x, int y, boolean expand) {
        return true;
    }

}
