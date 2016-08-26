package com.example.dell.myapplication.view;

import android.support.v4.app.Fragment;

import com.example.dell.myapplication.baseclass.SingleFragmentActivity;
import com.example.dell.myapplication.util.Contance;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by lin on 2016/8/24.
 */
public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment getFragment() {

        return new CrimeListFragment();
    }


}
