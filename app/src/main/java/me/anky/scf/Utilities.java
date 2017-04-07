package me.anky.scf;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Anky An on 6/04/2017.
 * anky25@gmail.com
 */

public class Utilities {

    public static final String DATE_FORMAT = "yyyyMMdd";

    public static int getCurrentDate(){
        long currentTime = System.currentTimeMillis();
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        String dateString = dateFormat.format(currentTime);
        return Integer.parseInt(dateString);
    }

    // Convert yyyy-MM-dd HH:mm to milliseconds
    public static long convertDateToMillis(String date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        long millis = 0;
        try {
            Date mDate = format.parse(date);
            millis = mDate.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return millis;
    }

    // Convert yyyyMMdd to milliseconds
    public static long convertSimpleDateToMillis(String date){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        long millis = 0;
        try {
            Date mDate = format.parse(date);
            millis = mDate.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return millis;
    }
}
