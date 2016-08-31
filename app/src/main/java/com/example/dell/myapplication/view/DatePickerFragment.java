package com.example.dell.myapplication.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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
import com.example.dell.myapplication.persenter.CrimeListPersenter;
import com.example.dell.myapplication.persenter.CrimePersenter;
import com.example.dell.myapplication.persenter.DatePickerFragmentPersenter;
import com.example.dell.myapplication.util.Contance;

import java.util.Calendar;
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

        final Calendar calendar = Calendar.getInstance();

        mDatePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                mDatePickerFragmentPersenter.getDate4DatePicker();
//                //保存日期,防止屏幕旋转的时候消失   TODO 栈溢出错误,未修改 临时注释掉
//                Date time = mDatePickerFragmentPersenter.getChooseTime();
//                Bundle bundle = new Bundle();
//                bundle.putSerializable(Contance.CRIME_DATE_DIALOG_KEY,time);
//                setArguments(bundle);
            }
        });

        Bundle arguments = getArguments();

        final Date date = (Date) arguments.getSerializable(Contance.CRIME_DATE_DIALOG_KEY);

        Log.e("Date",date.toString());

        mDatePickerFragmentPersenter.changeTime(date);

        mDatePickerFragmentPersenter.setTime2DatePicker();

        mDatePicker.getCalendarView().setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                mDatePickerFragmentPersenter.getDate4DatePicker();
                //保存状态防止屏幕旋转时消失
            }
        });

        listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Date time = mDatePickerFragmentPersenter.getChooseTime();
                Intent data = new Intent();
                data.putExtra(CrimePersenter.RESQUEST_KEY,time);
                getTargetFragment().onActivityResult(CrimePersenter.DIALOG_DATE_REQUEST_CODE,0,data);
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
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
//        Log.e("setTime2DatePicker","" +" "+ calendar.YEAR  +" "+ calendar.MONTH +" "+ calendar.DAY_OF_MONTH);  TODO 请勿再犯
        this.mDatePicker.updateDate(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH) + 1,calendar.get(Calendar.DAY_OF_MONTH));
    }

    @Override
    public Date getDate() {
        int year = this.mDatePicker.getYear();
        int moth = this.mDatePicker.getMonth();
        int day = this.mDatePicker.getDayOfMonth();
        Calendar calendar = Calendar.getInstance();
        calendar.set(year,moth-1,day);
        Date time = calendar.getTime();
        return time;
    }
}
