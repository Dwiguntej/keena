package com.salesforce.keenaspace.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class KeenaUtility {

    public static Date getDateWithoutTime(Date d){
      //  Date d = new Date();
        d.setHours(0);
        d.setMinutes(0);
        d.setSeconds(0);
        return d;
    }

    public static Date getDateInUTCTimezone(Date dt) {
        try {
            return getDateWithoutTime(new Date(dt.getTime() - Calendar.getInstance().getTimeZone().getOffset(dt.getTime())));

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }


    public static void main(String[] args) {
        SimpleDateFormat estFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            estFormatter.parse("2018-10-29 02:30:00");
            System.out.println();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


}
