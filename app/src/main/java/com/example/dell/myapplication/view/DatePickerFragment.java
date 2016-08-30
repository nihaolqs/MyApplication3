package com.example.dell.myapplication.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;

import com.example.dell.myapplication.R;
import com.example.dell.myapplication.persenter.DatePickerFragmentPersenter;
import com.example.dell.myapplication.util.Contance;

import java.util.Date;

/**
 * Created by dell on 2016/8/26.
 */
public class DatePickerFragment extends DialogFragment implements IDatePickerView{

    private DatePickerFragmentPersenter mDatePickerFragmentPersenter;

    private DatePicker mDatePicker;
    private DialogInterface.OnClickListener listener;

    public DatePickerFragment() {

    }

    public static DatePickerFragment getInstance(Date date)
    {
        DatePickerFragment datePickerFragment = new DatePickerFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable(Contance.CRIME_DATE_DIALOG_KEY,date);
        datePickerFragment.setArguments(bundle);
        return datePickerFragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        this.mDatePickerFragmentPersenter = new DatePickerFragmentPersenter(this);

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.dialog_date, null);

        mDatePicker = (DatePicker) view.findViewById(R.id.datePicker);

        Bundle arguments = getArguments();

        Date date = (Date) arguments.getSerializable(Contance.CRIME_DATE_DIALOG_KEY);

        Log.e("Date",date.toString());

        mDatePickerFragmentPersenter.changeTime(date);

        mDatePickerFragmentPersenter.setTime2DatePicker(mDatePicker);

        mDatePicker.getCalendarView().setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                mDatePickerFragmentPersenter.getDate4DatePicker(mDatePicker);
                //保存状态防止屏幕旋转时消失
            }
        });

        listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Date time = mDatePickerFragmentPersenter.getChooseTime();
//                Bundle bundle = new Bundle();
//                bundle.putSerializable(Contance.CRIME_DATE_DIALOG_KEY,mDatePickerFragmentPersenter.getChooseTime());
//                setArguments(bundle);
            }
        };
        AlertDialog dialog = new AlertDialog.Builder(getContext())
                .setTitle(R.string.date_picker_title)
                .setPositiveButton(android.R.string.ok, listener)
                .setView(view)
                .create();
        return dialog;
    }


    @Override
    public void setDate(Date date) {

    }

    @Override
    public Date getDate() {
        return null;
    }
}
