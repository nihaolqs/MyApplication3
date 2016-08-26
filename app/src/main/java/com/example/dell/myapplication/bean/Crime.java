package com.example.dell.myapplication.bean;

import java.util.Date;
import java.util.UUID;

/**
 * Created by dell on 2016/8/24.
 */
public class Crime {
    private UUID mCrimeId;
    private String mCrimeTitle;
    private Date mDate;
    private boolean isSolved;

    public Crime() {
        mCrimeId = UUID.randomUUID();
        mDate = new Date();
    }

    public UUID getmCrimeId() {
        return mCrimeId;
    }

    public String getmCrimeTitle() {
        return mCrimeTitle;
    }

    public void setmCrimeTitle(String mCrimeTitle) {
        this.mCrimeTitle = mCrimeTitle;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public boolean isSolved() {
        return isSolved;
    }

    public void setSolved(boolean solved) {
        isSolved = solved;
    }
}
