package com.anvarpasha.avtogarage.utils;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

    public static String parseDate(String inputDateString) {

        Date date = null;
        if (inputDateString == null)
            inputDateString = "2012-12-12 12:12:12";
        String outputDateString = null;

        inputDateString = inputDateString.substring(0,19).replace("T"," ");

        SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd.MM.yy HH:mm", Locale.US);
        try {
            date = inputDateFormat.parse(inputDateString);
            outputDateString = outputDateFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return outputDateString;
    }

    public static String parseDateWithoutTime(String inputDateString) {
        Date date = null;
        if (inputDateString == null)
            inputDateString = "2012-12-12 12:12:12";
        String outputDateString = null;

        SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("d MMM yyyy", Locale.US);
        try {
            date = inputDateFormat.parse(inputDateString);
            outputDateString = outputDateFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return outputDateString;
    }

    public static String parseDateOnlyTime(String inputDateString) {
        Date date = null;
        if (inputDateString == null)
            inputDateString = "2012-12-12 12:12:12";
        String outputDateString = null;

        SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("HH:mm", Locale.US);
        try {
            date = inputDateFormat.parse(inputDateString);
            outputDateString = outputDateFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return outputDateString;
    }

    public static String fromMillisToTimeString(Long millis) {
        SimpleDateFormat format = new SimpleDateFormat("hh:mm a", Locale.getDefault());
        return format.format(millis);
    }


    public static String capitalize( String line) {
        return Character.toUpperCase(line.charAt(0)) + line.substring(1);
    }

}
