package com.example.dell.myapplication.view;

import android.content.Context;

import com.example.dell.myapplication.biz.CrimeBiz;
import com.example.dell.myapplication.biz.ICrimeBiz;

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



//    public void
}