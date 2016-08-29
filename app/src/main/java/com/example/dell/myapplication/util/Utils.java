package com.example.dell.myapplication.util;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by dell on 2016/8/24.
 */
public class Utils {

    public static String DateFormat(Date date)
    {
        String formatStr = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        return sdf.format(date);
    }

    public static class timeUtil
    {
        private Date mDate;

        public timeUtil(Date date)
        {
            this.mDate = date;
        }

        public int getYear()
        {
            Calendar calendar = getCalendar();
            int year = calendar.YEAR;
            return year;
        }

        public int getMontd()
        {
            Calendar calendar = getCalendar();
            int month = calendar.MONTH;
            return month;
        }

        public int getDay()
        {
            Calendar calendar = getCalendar();
            int dayOfMonth = calendar.DAY_OF_MONTH;
            return dayOfMonth;
        }

        @NonNull
        private Calendar getCalendar() {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(this.mDate);
            return calendar;
        }
    }
}
