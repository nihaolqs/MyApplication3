package com.example.dell.myapplication.biz;

import android.content.Context;

import com.example.dell.myapplication.bean.Crime;
import com.example.dell.myapplication.bean.CrimeLab;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by dell on 2016/8/24.
 */
public class CrimeBiz implements ICrimeBiz{
    private Context mContex;
    public CrimeBiz(Context context) {
        this.mContex = context;
    }

    @Override
    public void setCrime( Crime crime) {
        CrimeLab crimeLab = CrimeLab.getInstance(this.mContex);
        crimeLab.getCrimes().add(crime);
    }

    @Override
    public Crime readCrime(UUID uuid) {
        CrimeLab crimeLab = CrimeLab.getInstance(this.mContex);
        Crime crime = crimeLab.getCrime(uuid);
        return crime;
    }

    @Override
    public ArrayList<Crime> getCrimes() {
        CrimeLab crimeLab = CrimeLab.getInstance(this.mContex);
        ArrayList<Crime> crimes = crimeLab.getCrimes();
        //TODO 以下为测试数据
        for (int i = 0; i< 100; i++)
        {
            Crime crime = new Crime();
            crime.setmCrimeTitle("标题" + i);
            crimes.add(crime);
        }
        return crimes;
    }
}
