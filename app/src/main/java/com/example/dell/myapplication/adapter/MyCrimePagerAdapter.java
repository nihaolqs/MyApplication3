package com.example.dell.myapplication.adapter;

import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.myapplication.bean.Crime;
import com.example.dell.myapplication.view.CrimeFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by dell on 2016/8/26.
 */
public class MyCrimePagerAdapter extends FragmentStatePagerAdapter {   //TODO防止对内存占用过大

    private ArrayList<Crime> mCrimes = new ArrayList<>();

    public MyCrimePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Crime crime = mCrimes.get(position);
        UUID uuid = crime.getmCrimeId();
        return CrimeFragment.getInstance(uuid);
    }

    @Override
    public int getCount() {
        return this.mCrimes.size();
    }

    public void notifyDataSetChanged(List<Crime> crimes) {
        this.mCrimes.addAll(crimes);
        super.notifyDataSetChanged();
    }


}
