package com.app.ht.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.ht.R;
import com.app.ht.model.AppointmentDateSlot;
import com.app.ht.model.TimingSlot;
import com.app.ht.utils.HTLogger;
import com.app.ht.utils.HtUtils;
import com.app.ht.viewHolders.DateHeaderViewHolder;
import com.app.ht.viewHolders.TimeSlotRowHolder;
import com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandableItemConstants;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemAdapter;

import java.util.Date;
import java.util.List;

/**
 * Created by niranjan on 12/7/16.
 */

public class DateTimeSlotAdapter extends AbstractExpandableItemAdapter<DateHeaderViewHolder, TimeSlotRowHolder> {
    private static int GROUP_COUNT = 3;

    private static final String TAG = "DateTimeItemAdapter";
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
                HTLogger.d("itemView", "" + holder.getExpandStateFlags());
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
            Date startDate = HtUtils.parseDateString("yyyy-MM-dd HH:mm:ssZ", timeSlot.getStartTime());
            Date endDate = HtUtils.parseDateString("yyyy-MM-dd HH:mm:ssZ", timeSlot.getEndTime());
            holder.txtVw_slotTime.setText(HtUtils.formatDate("hh:mm a", startDate) + " - " + HtUtils.formatDate("hh:mm a", endDate));
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public boolean onCheckCanExpandOrCollapseGroup(DateHeaderViewHolder holder, int groupPosition, int x, int y, boolean expand) {
        return true;
//        switch (groupPosition) {
//            case 0:
//                return (mDateTimeSlot.getMorning().size() > 0);
//            case 1:
//                return (mDateTimeSlot.getAfternoon().size() > 0);
//            case 2:
//                return (mDateTimeSlot.getEvening().size() > 0);
//            default:
//                return false;
//        }
    }

//
//    public static abstract class MyBaseViewHolder extends AbstractExpandableItemViewHolder {
//
//        public MyBaseViewHolder(View v) {
//            super(v);
//
//        }
//    }

//    public static class MyGroupViewHolder extends MyBaseViewHolder {
//        public ImageView imgVw_chevron;
//        public HFTextView txtVw_slotHeader, txtVw_slotCount;
//
//        public MyGroupViewHolder(View v) {
//            super(v);
//            imgVw_chevron = (ImageView) v.findViewById(R.id.imgVw_chevron);
//            txtVw_slotHeader = (HFTextView) v.findViewById(R.id.txtVw_slotHeader);
//            txtVw_slotCount = (HFTextView) v.findViewById(R.id.txtVw_slotCount);
//        }
//    }
//
//    public static class MyChildViewHolder extends MyBaseViewHolder {
//        HFTextView txtVw_slotTime;
//        public MyChildViewHolder(View v) {
//            super(v);
//            txtVw_slotTime = (HFTextView) v.findViewById(R.id.txtVw_slotTime);
//        }
//    }

    private interface Expandable extends ExpandableItemConstants {
    }
}
