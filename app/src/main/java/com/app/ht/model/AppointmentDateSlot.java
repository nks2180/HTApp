package com.app.ht.model;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.io.Serializable;
import java.util.List;

/**
 * Created by niranjan on 12/7/16.
 */

@JsonObject
public class AppointmentDateSlot implements Serializable{

    String date;

    @JsonField(name = "afternoon")
    private List<TimingSlot> afternoon;
    @JsonField(name = "evening")
    private List<TimingSlot> evening;
    @JsonField(name = "morning")
    private List<TimingSlot> morning;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<TimingSlot> getAfternoon() {
        return afternoon;
    }

    public void setAfternoon(List<TimingSlot> afternoon) {
        this.afternoon = afternoon;
    }

    public List<TimingSlot> getEvening() {
        return evening;
    }

    public void setEvening(List<TimingSlot> evening) {
        this.evening = evening;
    }

    public List<TimingSlot> getMorning() {
        return morning;
    }

    public void setMorning(List<TimingSlot> morning) {
        this.morning = morning;
    }


}
