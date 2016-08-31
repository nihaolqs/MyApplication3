package com.example.dell.myapplication.biz;

import com.example.dell.myapplication.bean.Crime;

import java.util.List;

/**
 * Created by dell on 2016/8/31.
 */
public interface ICrimeSave2JSON {
    void save2JSON(List<Crime> crimeList);
}
