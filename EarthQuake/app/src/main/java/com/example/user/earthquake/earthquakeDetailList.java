package com.example.user.earthquake;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class earthquakeDetailList {

    String earthquakeLoc;
    Double earthquakeMag;
    String earthquakeDate;
    String earthquakeTime;

    public earthquakeDetailList(String earthquakeLoc, Double earthquakeMag, String earthquakeDate, String earthquakeTime) {
        this.earthquakeLoc = earthquakeLoc;
        DecimalFormat twoDForm = new DecimalFormat("#.##");
       // Double dd=Double.valueOf(twoDForm.format(earthquakeMag);
        this.earthquakeMag = Double.valueOf(twoDForm.format(earthquakeMag));

       long unixSeconds=Long.parseLong(earthquakeDate);
// convert seconds to milliseconds
        Date date = new java.util.Date(unixSeconds);
// the format of your date
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
// give a timezone reference for formatting (see comment at the bottom)
        sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT-4"));
        String formattedDate = sdf.format(date);




        this.earthquakeDate = formattedDate;
        this.earthquakeTime = earthquakeTime;
    }

    public String getEarthquakeLoc() {
        return earthquakeLoc;
    }

    public Double getEarthquakeMag() {
        return earthquakeMag;
    }

    public String getEarthquakeDate() {
        return earthquakeDate;
    }

    public String getEarthquakeTime() {
        return earthquakeTime;
    }
}
