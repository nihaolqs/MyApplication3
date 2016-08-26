package com.example.dell.myapplication.adapter;

import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.dell.myapplication.R;
import com.example.dell.myapplication.bean.Crime;
import com.example.dell.myapplication.util.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lin on 2016/8/24.
 */
public class CrimeListAdapter extends BaseAdapter {

    private  LayoutInflater mInflater;
    ArrayList<Crime> mCrimes = new ArrayList<>();

    public CrimeListAdapter(@NonNull LayoutInflater inflater) {
        this.mInflater = inflater;
    }

    private void setmCrimes(List<Crime> crimes)
    {
        mCrimes.clear();
        mCrimes.addAll(crimes);
    }

    public void notifyDataSetChanged(List<Crime> crimes) {
        setmCrimes(crimes);
        super.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return this.mCrimes.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null)
        {
            view = this.mInflater.inflate(R.layout.crimes_list_item, null);
            ViewHolder viewHolder = new ViewHolder();
            view.setTag(viewHolder);
            viewHolder.tvCrimeTitle = (TextView) view.findViewById(R.id.tv_crime_list_item_crimetitle);
            viewHolder.tvCrimeDate = (TextView) view.findViewById(R.id.tv_crime_list_item_crimedate);
            viewHolder.cbSolvedNow = (CheckBox) view.findViewById(R.id.cb_crime_list_item_solvednow);
        }
        ViewHolder holder = (ViewHolder) view.getTag();
        Crime crime = this.mCrimes.get(i);
        holder.tvCrimeTitle.setText(crime.getmCrimeTitle());
        holder.tvCrimeDate.setText(Utils.DateFormat(crime.getmDate()));
        holder.cbSolvedNow.setChecked(crime.isSolved());
        return view;
    }

    public Crime getCrime(int posiction){
        if(posiction > this.mCrimes.size() -1)
        {
            Log.e("getCrime","posiction");
            return null;
        }else
        {
            return this.mCrimes.get(posiction);
        }
    }

    private class ViewHolder{
        TextView tvCrimeTitle;
        TextView tvCrimeDate;
        CheckBox cbSolvedNow;
    }

}
