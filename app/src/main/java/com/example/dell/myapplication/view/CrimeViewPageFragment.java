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
import com.example.dell.myapplication.bean.Crime;
import com.example.dell.myapplication.persenter.CrimeViewPagePersenter;

import java.util.List;
import java.util.UUID;

/**
 * A simple {@link Fragment} subclass.
 */
public class CrimeViewPageFragment extends Fragment implements ICrimeViewPageView {


    private View mLayout;
    private LayoutInflater mInflater;
    private CrimeViewPagePersenter mCrimeViewPagePersenter;
    private ViewPager mViewPager;
    private MyCrimePagerAdapter mPagerAdapter;

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
        mViewPager = (ViewPager) mLayout.findViewById(R.id.vp_cvpf_crimes);
        mPagerAdapter = new MyCrimePagerAdapter(getChildFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mCrimeViewPagePersenter.setToolBarTitle();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
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
        List<Crime> crimes = mCrimeViewPagePersenter.getCrimes();
        for (int i = 0; i < crimes.size(); i++)
        {
            Crime crime = crimes.get(i);
            if(crime.getmCrimeId().equals(uuid))
            {
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }

    @Override
    public void replaceViewPage()
    {
        List<Crime> crimes = this.mCrimeViewPagePersenter.getCrimes();
        this.mPagerAdapter.notifyDataSetChanged(crimes);
    }

    @Override
    public String getTitle() {
        int item = mViewPager.getCurrentItem();
        String crimeTitle = mCrimeViewPagePersenter.getCrimes().get(item).getmCrimeTitle();
        return crimeTitle;
    }

    @Override
    public void setActivityTitle(String title) {
        getActivity().setTitle(title);
    }
}
