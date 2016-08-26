package com.example.dell.myapplication.util;

import android.annotation.TargetApi;
import android.os.Build;

import java.text.SimpleDateFormat;
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
}
