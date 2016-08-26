package com.example.dell.myapplication.bean;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by dell on 2016/8/24.
 */
public class CrimeLab {
    private static CrimeLab sCrimeLab;
    private ArrayList<Crime> mCrimes;
    private Context mAppContext;     //为了使单例拥有调用资源,启动Activity 的能力
    private CrimeLab(Context appContext)
    {
        this.mAppContext = appContext;
        mCrimes = new ArrayList<>();
    }
    public static CrimeLab getInstance(Context context)
    {
        if(sCrimeLab == null)
        {
            sCrimeLab = new CrimeLab(context.getApplicationContext());  //不直接传参是为了使整个应用生命周期内Context保证存在

            //TODO 以下为测试数据
            for (int i = 0; i< 100; i++)
            {
                Crime crime = new Crime();
                crime.setmCrimeTitle("标题" + i);
                sCrimeLab.mCrimes.add(crime);
            }

        }
        return sCrimeLab;
    }

    public ArrayList<Crime> getCrimes()
    {
        return mCrimes;
    }
    public Crime getCrime(UUID uuid)
    {
        for (Crime c: mCrimes) {
            if(uuid.equals(c.getmCrimeId()))
            {
                return c;
            }
        }
        Toast.makeText(this.mAppContext,"没有查找到对应实例",Toast.LENGTH_SHORT).show();
        return null;
    }
}
