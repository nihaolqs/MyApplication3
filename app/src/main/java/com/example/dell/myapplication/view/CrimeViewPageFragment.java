package com.example.dell.myapplication.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.myapplication.R;
import com.example.dell.myapplication.adapter.MyCrimePagerAdapter;

import java.util.UUID;

/**
 * A simple {@link Fragment} subclass.
 */
public class CrimeViewPageFragment extends Fragment implements ICrimeViewPageView {


    private View mLayout;
    private LayoutInflater mInflater;
    private CrimeViewPagePersenter mCrimeViewPagePersenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mLayout = inflater.inflate(R.layout.fragment_crime_view_page, container, false);
        initParam(inflater);
        initUi();
        return mLayout;
    }

    private void initUi() {
        ViewPager mViewPager = (ViewPager) mLayout.findViewById(R.id.vp_cvpf_crimes);
        PagerAdapter mPagerAdapter = new MyCrimePagerAdapter();
        mViewPager.setAdapter(mPagerAdapter);
    }

    private void initParam(LayoutInflater inflater) {
        this.mCrimeViewPagePersenter = new CrimeViewPagePersenter(this,getContext());
        this.mInflater = inflater;
    }

    public static Fragment getInstance() {
        return null;
    }

    @Override
    public void showCrimePage(UUID uuid) {

    }
}
