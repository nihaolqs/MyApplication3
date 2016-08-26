package com.example.dell.myapplication.persenter;

import android.content.Context;
import android.support.v4.app.FragmentManager;

import com.example.dell.myapplication.bean.Crime;
import com.example.dell.myapplication.biz.CrimeBiz;
import com.example.dell.myapplication.biz.ICrimeBiz;
import com.example.dell.myapplication.view.DatePickerFragment;
import com.example.dell.myapplication.view.ICrimeView;

import java.util.Date;
import java.util.UUID;

/**
 * Created by dell on 2016/8/24.
 * 成员变量中的Crime确保不会出现空对象,造成FC
 * 提交后保存到单实例CrimeLab对象中
 */
public class CrimePersenter {
    private static final String DIALOG_DATE = "date";
    private ICrimeView crimeView;
    private ICrimeBiz crimeBiz;
    private Crime mCrime;
    private Context mContext;

    public CrimePersenter(ICrimeView crimeView, Context context, UUID uuid) {

        this.crimeView = crimeView;
        this.mContext = context;
        this.crimeBiz = new CrimeBiz(context);
        Crime crime = crimeBiz.readCrime(uuid);
        if(crime ==null)
        {
            crime = new Crime();
        }
        this.mCrime = crime;
    }

    public void addCrime(){
        String crimeTitle = crimeView.getCrimeTitle();

        this.mCrime.setmCrimeTitle(crimeTitle);
        boolean isSolved = crimeView.getIsSolved();
        this.mCrime.setSolved(isSolved);
        crimeBiz.setCrime(this.mCrime);
    }
    public String getCrimeTitle()
    {
        String crimeTitle = this.mCrime.getmCrimeTitle();
        return crimeTitle;
    }

    private void readCrime(UUID uuid) {
        Crime crime;
        crime = crimeBiz.readCrime(uuid);
        if (crime != null)
        {
            this.mCrime = crime;
        }
    }

    public boolean isSolved()
    {
        boolean solved = this.mCrime.isSolved();
        return solved;
    }

    public void setCrimeTitle()
    {
        String crimeTitle = crimeView.getCrimeTitle();
        this.mCrime.setmCrimeTitle(crimeTitle);
    }
    public void setIsSolved()
    {
        boolean isSolved = crimeView.getIsSolved();
        this.mCrime.setSolved(isSolved);
    }

    public void setDate()
    {
        this.mCrime.setmDate(new Date());
    }

    public Date getDate()
    {
        return this.mCrime.getmDate();
    }

    public void replaceView()
    {
        crimeView.setCrimeTitle();
        crimeView.setIsSolved();
        crimeView.setDate();
    }

    public void showDateDialog(FragmentManager fm)
    {
        DatePickerFragment datePickerFragment = new DatePickerFragment();
        datePickerFragment.show(fm,CrimePersenter.DIALOG_DATE);
    }
}
