package me.anky.scf;

import java.text.SimpleDateFormat;

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
}
