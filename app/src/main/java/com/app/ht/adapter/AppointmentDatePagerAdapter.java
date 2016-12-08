package com.app.ht.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.app.ht.fragment.AppointmentDateTimeFragment;
import com.app.ht.model.AppointmentDateSlot;

import java.util.ArrayList;

/**
 * Created by niranjan on 12/7/16.
 */

public class AppointmentDatePagerAdapter extends FragmentPagerAdapter {
    ArrayList<AppointmentDateSlot> mdateTimeSlots;

    public AppointmentDatePagerAdapter(FragmentManager fragmentManager, ArrayList<AppointmentDateSlot> dateTimeSlots) {
        super(fragmentManager);
        this.mdateTimeSlots = dateTimeSlots;
    }

    @Override
    public Fragment getItem(int position) {
        AppointmentDateTimeFragment dateTimeFragment = AppointmentDateTimeFragment.newInstance(mdateTimeSlots.get(position));
        return dateTimeFragment;
    }

    @Override
    public int getCount() {
        return mdateTimeSlots.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }
}
