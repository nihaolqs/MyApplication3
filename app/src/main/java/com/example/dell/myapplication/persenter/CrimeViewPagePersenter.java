package com.example.dell.myapplication.persenter;

import android.content.Context;

import com.example.dell.myapplication.bean.Crime;
import com.example.dell.myapplication.biz.CrimeBiz;
import com.example.dell.myapplication.biz.ICrimeBiz;
import com.example.dell.myapplication.view.ICrimeViewPageView;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by dell on 2016/8/26.
 */
public class CrimeViewPagePersenter {
    private ICrimeBiz mCrimeBiz;
    private ICrimeViewPageView mCrimeViewPageView;

    public CrimeViewPagePersenter(ICrimeViewPageView mCrimeViewPageView, Context context) {
        this.mCrimeViewPageView = mCrimeViewPageView;
        this.mCrimeBiz = new CrimeBiz(context);
    }

    public void pageChange(UUID uuid)
    {
        this.mCrimeViewPageView.showCrimePage(uuid);
    }

    public List<Crime> getCrimes() {
     return mCrimeBiz.getCrimes();
    }

    public void setToolBarTitle()
    {
        String title = mCrimeViewPageView.getTitle();
        mCrimeViewPageView.setActivityTitle(title);
    }

    public void showCrimeViewPage(UUID uuid)
    {
        mCrimeViewPageView.replaceViewPage();
        mCrimeViewPageView.showCrimePage(uuid);
    }
}