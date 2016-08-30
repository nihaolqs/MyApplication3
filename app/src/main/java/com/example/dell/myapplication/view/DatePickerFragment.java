package com.example.dell.myapplication.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;

import com.example.dell.myapplication.R;

/**
 * Created by dell on 2016/8/26.
 */
public class DatePickerFragment extends DialogFragment{

    private DatePicker mDatePicker;

    public DatePickerFragment() {
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.dialog_date, null);

        mDatePicker = (DatePicker) view.findViewById(R.id.datePicker);

        mDatePicker.

        AlertDialog dialog = new AlertDialog.Builder(getContext())
                .setTitle(R.string.date_picker_title)
                .setPositiveButton(android.R.string.ok, null)
                .setView(view)
                .create();
        return dialog;
    }


}
