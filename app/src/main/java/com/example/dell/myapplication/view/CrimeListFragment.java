package com.example.dell.myapplication.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.dell.myapplication.R;
import com.example.dell.myapplication.adapter.CrimeListAdapter;
import com.example.dell.myapplication.bean.Crime;
import com.example.dell.myapplication.persenter.CrimeListPersenter;

/**
 * Created by lin on 2016/8/24.
 */
public class CrimeListFragment extends Fragment implements ICrimeListView{

    private View mLayout;
    private ListView mLvCrimeList;
    private CrimeListAdapter adapter;
    private CrimeListPersenter mCrimeListPersenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mLayout = inflater.inflate(R.layout.fragment_crime_list,null);
        this.adapter = new CrimeListAdapter(inflater);
        this.mCrimeListPersenter = new CrimeListPersenter(this,getContext());
        init();
        return mLayout;
    }

    @Override
    public void onResume() {   //刷新数据,使得展示数据为最新数据
        super.onResume();
        adapter.notifyDataSetChanged(mCrimeListPersenter.getCrimes());
    }

    private void init() {
        initUi();
    }

    private void initUi() {
        mLvCrimeList = (ListView) mLayout.findViewById(R.id.lv_crime_list);

        mLvCrimeList.setAdapter(adapter);
        adapter.notifyDataSetChanged(mCrimeListPersenter.getCrimes());
        mLvCrimeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Crime crime = adapter.getCrime(i);
                mCrimeListPersenter.showCrime(crime);
            }
        });
    }

    @Override
    public void updateCrimeList() {
        adapter.notifyDataSetChanged(mCrimeListPersenter.getCrimes());  // TODO 重写了该方法<<需要附加数据
    }
}
