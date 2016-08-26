package com.example.dell.myapplication.persenter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.dell.myapplication.bean.Crime;
import com.example.dell.myapplication.biz.CrimeBiz;
import com.example.dell.myapplication.biz.ICrimeBiz;
import com.example.dell.myapplication.util.Contance;
import com.example.dell.myapplication.view.CrimeViewPageActivity;
import com.example.dell.myapplication.view.ICrimeListView;

import java.util.List;

/**
 * Created by lin on 2016/8/24.
 */
public class CrimeListPersenter {
    private ICrimeBiz mCrimeBiz;
    private ICrimeListView mCrimeListView;
    private Context mContext;

    public CrimeListPersenter(ICrimeListView mCrimeListView, Context context) {
        this.mCrimeListView = mCrimeListView;
        this.mCrimeBiz = new CrimeBiz(context);
        this.mContext = context;
    }

    public List<Crime> getCrimes()
    {
        return mCrimeBiz.getCrimes();
    }

    public void showCrime(Crime crime)
    {
        Intent intent = new Intent(mContext,CrimeViewPageActivity.class);

        intent.putExtra(Contance.CRIME_INTENT_KEY,crime.getmCrimeId());
//        Log.e("showCrime","startActivity");
        this.mContext.startActivity(intent);
    }
}
