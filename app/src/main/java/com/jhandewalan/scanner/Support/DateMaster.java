package com.jhandewalan.scanner.Support;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateMaster {


    public static String currentDateIndian(boolean is30DaysBack) {
        String date_require = "";

        Date current_date = Calendar.getInstance().getTime();
        Log.e("current date", "Current time => " + current_date);
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");


        Calendar calendar = Calendar.getInstance();
        calendar.setTime(current_date);
        calendar.add(Calendar.DAY_OF_YEAR, -30);
        Date newDate = calendar.getTime();

        String formatted_30_days_back = df.format(newDate);
        String formatted_current_Date = df.format(current_date);
        if (is30DaysBack) {
            date_require = formatted_30_days_back;
        } else {
            date_require = formatted_current_Date;
        }


        return date_require;


    }

    public static String currentDate(boolean is30DaysBack) {
        String date_require = "";

        Date current_date = Calendar.getInstance().getTime();
        Log.e("current date", "Current time => " + current_date);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");


        Calendar calendar = Calendar.getInstance();
        calendar.setTime(current_date);
        calendar.add(Calendar.DAY_OF_YEAR, -30);
        Date newDate = calendar.getTime();

        String formatted_30_days_back = df.format(newDate);
        String formatted_current_Date = df.format(current_date);
        if (is30DaysBack) {
            date_require = formatted_30_days_back;
        } else {
            date_require = formatted_current_Date;
        }


        return date_require;


    }

    public static String currentDateTime(boolean is30DaysBack) {
        String date_require = "";

        Date current_date = Calendar.getInstance().getTime();
        Log.e("current date", "Current time => " + current_date);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");


        Calendar calendar = Calendar.getInstance();
        calendar.setTime(current_date);
        calendar.add(Calendar.DAY_OF_YEAR, -30);
        Date newDate = calendar.getTime();

        String formatted_30_days_back = df.format(newDate);
        String formatted_current_Date = df.format(current_date);
        if (is30DaysBack) {
            date_require = formatted_30_days_back;
        } else {
            date_require = formatted_current_Date;
        }


        return date_require;


    }


    public static String currentTime(boolean is30DaysBack) {
        String date_require = "";

        Date current_date = Calendar.getInstance().getTime();
        Log.e("current date", "Current time => " + current_date);
        SimpleDateFormat df = new SimpleDateFormat("hh:mm:ss");


        Calendar calendar = Calendar.getInstance();
        calendar.setTime(current_date);
        calendar.add(Calendar.DAY_OF_YEAR, -30);
        Date newDate = calendar.getTime();

        String formatted_30_days_back = df.format(newDate);
        String formatted_current_Date = df.format(current_date);

            date_require = formatted_current_Date;



        return date_require;


    }

    public static String back_Date_by(int no_ofBack_days) {
        String date_require = "";

        Date current_date = Calendar.getInstance().getTime();
        Log.e("current date", "Current time => " + current_date);
        SimpleDateFormat df = new SimpleDateFormat("dd MMM yyyy");


        Calendar calendar = Calendar.getInstance();
        calendar.setTime(current_date);
        calendar.add(Calendar.DAY_OF_YEAR, no_ofBack_days);
        Date newDate = calendar.getTime();

        String formatted_30_days_back = df.format(newDate);
        String formatted_current_Date = df.format(current_date);
        if (no_ofBack_days == 0) {
            date_require = formatted_current_Date;

        } else {
            date_require = formatted_30_days_back;

        }


        return date_require;


    }

    public static String TformatDate(String Tdate) {
        String formatted_current_Date = "";


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            Date d = sdf.parse(Tdate);
            SimpleDateFormat df = new SimpleDateFormat("dd MMM yyyy");
            formatted_current_Date = df.format(d);
            Log.e("Date Formated", "Date Formated : " + formatted_current_Date);


        } catch (ParseException ex) {
            Log.e("Exception", ex.getLocalizedMessage());
        }
        return formatted_current_Date;
    }
}
