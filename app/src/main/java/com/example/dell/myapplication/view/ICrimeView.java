package com.example.dell.myapplication.view;

import android.content.Intent;

import java.util.Date;

/**
 * Created by dell on 2016/8/24.
 */
public interface ICrimeView {
    String getCrimeTitle();
    void setCrimeTitle();
    boolean getIsSolved();
    void setIsSolved();
    void setDate();
}
