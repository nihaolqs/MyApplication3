package com.example.dell.myapplication.persenter;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.DatePicker;

import com.example.dell.myapplication.view.IDatePickerView;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by lin on 2016/8/30.
 */
public class DatePickerFragmentPersenter {
    private IDatePickerView datePickerView;
    private Date mDate;

    public DatePickerFragmentPersenter(IDatePickerView datePickerView) {
        this.datePickerView = datePickerView;
        this.mDate = datePickerView.getDate();
    }

    public void changeTime(Date date)
    {
        this.mDate = date;
    }

    public Date getChooseTime()
    {
        return this.mDate;
    }

    @NonNull
    private Calendar getCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.mDate);
        return calendar;
    }

    public void setTime2DatePicker(DatePicker datePicker)
    {
        Calendar calendar = getCalendar();
//        Log.e("setTime2DatePicker","" +" "+ calendar.YEAR  +" "+ calendar.MONTH +" "+ calendar.DAY_OF_MONTH);  TODO 请勿再犯
        datePicker.updateDate(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH) + 1,calendar.get(Calendar.DAY_OF_MONTH));
    }

    public void getDate4DatePicker(DatePicker datePicker)
    {
        Calendar calendar = getCalendar();
        calendar.set(datePicker.getYear(),datePicker.getMonth()-1,datePicker.getDayOfMonth());
        Date time = calendar.getTime();
        if (time != null)
        {
            this.mDate = time;
        }
    }
}
