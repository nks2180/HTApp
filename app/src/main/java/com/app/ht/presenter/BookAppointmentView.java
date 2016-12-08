package com.app.ht.presenter;

import com.app.ht.model.AppointmentDateSlot;

import java.util.ArrayList;

/**
 * Created by niranjan on 12/7/16.
 */

public interface BookAppointmentView extends BaseView{
    void onSlotsResponeCame(ArrayList<AppointmentDateSlot> dateTimeSlots);

}
