package com.example.dell.myapplication.persenter;

import android.support.annotation.NonNull;
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
        datePicker.updateDate(calendar.YEAR,calendar.MONTH,calendar.DAY_OF_MONTH);
    }

    public void getDate4DatePicker(DatePicker datePicker)
    {
        Calendar calendar = getCalendar();
        calendar.set(datePicker.getYear(),datePicker.getMonth(),datePicker.getDayOfMonth());
        Date time = calendar.getTime();
        if (time != null)
        {
            this.mDate = time;
        }
    }
}
