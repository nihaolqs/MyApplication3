package com.example.dell.myapplication.view;

import android.support.v4.app.Fragment;

import com.example.dell.myapplication.baseclass.SingleFragmentActivity;
import com.example.dell.myapplication.util.Contance;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by dell on 2016/8/26.
 */
public class CrimeViewPageActivity extends SingleFragmentActivity{
    @Override
    protected Fragment getFragment() {
        UUID uuid = (UUID) getIntent().getSerializableExtra(Contance.CRIME_INTENT_KEY);
        return CrimeViewPageFragment.getInstance(uuid);
    }
}
