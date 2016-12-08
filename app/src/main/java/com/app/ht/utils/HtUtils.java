package com.app.ht.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by niranjan on 12/7/16.
 */

public class HtUtils {
    //public static String yyyyMMdd = ;
    public static String yyyyMMddhhmmZ = "yyyy-MM-dd HH:mm:ssZ";
    public static String hhmma = "hh:mm a";

    public static final int DEFAULT_GROUP_ID = 1000;
    public static final int DEFAULT_CHILD_ID = 10000;

    public static String EXTRA_APPOINTMENT_DATETIME_OBJ = "dateTime_slot_obj";

    public static Date parseDateString(String dateFormat, String dateString){
        try {
            SimpleDateFormat fmt = new SimpleDateFormat(dateFormat);
            fmt.setTimeZone(TimeZone.getTimeZone("GMT"));
            return fmt.parse(dateString);
        }
        catch (ParseException ex){
            ex.printStackTrace();
            return null;
        }
    }

    public static String formatDate(String dateFormat, Date date){
        SimpleDateFormat fmtOut = new SimpleDateFormat(dateFormat);
        return fmtOut.format(date);
    }

    public static String getDayOfWeek(Date date){
        SimpleDateFormat fmt = new SimpleDateFormat("EE");
        return fmt.format(date);
    }

    public static String getDateOfMonth(Date date){
        SimpleDateFormat fmt = new SimpleDateFormat("d");
        return fmt.format(date);
    }

    public static String getMonthFromDate(Date date){
        SimpleDateFormat fmt = new SimpleDateFormat("MMMM");
        return fmt.format(date);
    }
}
