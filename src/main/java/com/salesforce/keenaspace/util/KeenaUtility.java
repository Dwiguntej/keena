package com.salesforce.keenaspace.util;

import java.util.Date;

public class KeenaUtility {

    public static Date getDateWithoutTime(Date d){
      //  Date d = new Date();
        d.setHours(0);
        d.setMinutes(0);
        d.setSeconds(0);
        return d;
    }

}
