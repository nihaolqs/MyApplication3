package com.example.dell.myapplication.persenter;

import com.example.dell.myapplication.view.IDatePickerView;

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
}
