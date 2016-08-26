package com.example.dell.myapplication.biz;

import android.content.Context;

import com.example.dell.myapplication.bean.Crime;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by dell on 2016/8/24.
 */
public interface ICrimeBiz {
    void setCrime(Crime crime);
    Crime readCrime( UUID uuid);
    ArrayList<Crime> getCrimes();
}
