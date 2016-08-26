package com.example.dell.myapplication.baseclass;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dell.myapplication.R;

public abstract class SingleFragmentActivity extends FragmentActivity {

    //模板方法类

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);

        replaceFragment();
    }

    private void replaceFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
//        Fragment crimeFragment = new CrimeFragment();    TODO 切记不要再犯
        ft.replace(R.id.fragment_container,getFragment());
        ft.commit();
    }

    protected abstract Fragment getFragment();  //钩子方法,将运行所需要的Fragment 延迟到子类实现
}
