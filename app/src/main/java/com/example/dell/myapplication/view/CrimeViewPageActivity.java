package com.example.dell.myapplication.view;

import android.support.v4.app.Fragment;

import com.example.dell.myapplication.baseclass.SingleFragmentActivity;

/**
 * Created by dell on 2016/8/26.
 */
public class CrimeViewPageActivity extends SingleFragmentActivity{
    @Override
    protected Fragment getFragment() {
        return CrimeViewPageFragment.getInstance();
    }
}
