package com.example.dell.myapplication.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.myapplication.bean.Crime;
import com.example.dell.myapplication.view.CrimeFragment;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by dell on 2016/8/26.
 */
public class MyCrimePagerAdapter extends PagerAdapter {

    private ArrayList<Crime> crimes = new ArrayList<>();
    @Override
    public int getCount() {
        return crimes.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        UUID uuid = crimes.get(position).getmCrimeId();
        Fragment fragment = CrimeFragment.getInstance(uuid);
        return fragment;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }
}
