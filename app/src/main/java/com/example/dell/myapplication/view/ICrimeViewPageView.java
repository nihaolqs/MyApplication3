package com.example.dell.myapplication.view;

import java.util.UUID;

/**
 * Created by dell on 2016/8/26.
 */
public interface ICrimeViewPageView {
    void showCrimePage(UUID uuid);
    void replaceViewPage();
    String getTitle();
    void setActivityTitle(String title);
}
