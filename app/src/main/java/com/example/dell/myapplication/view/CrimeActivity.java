package com.example.dell.myapplication.view;

import android.support.v4.app.Fragment;

import com.example.dell.myapplication.baseclass.SingleFragmentActivity;
import com.example.dell.myapplication.util.Contance;

import java.util.UUID;

public class CrimeActivity extends SingleFragmentActivity {

    @Override
    protected Fragment getFragment() {
        UUID uuid = (UUID) getIntent().getSerializableExtra(Contance.CRIME_INTENT_KEY);
        return CrimeFragment.getInstance(uuid);
    }
}
