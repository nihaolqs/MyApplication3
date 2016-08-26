package com.example.dell.myapplication.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.example.dell.myapplication.R;
import com.example.dell.myapplication.bean.Crime;
import com.example.dell.myapplication.persenter.CrimePersenter;
import com.example.dell.myapplication.util.Contance;
import com.example.dell.myapplication.util.Utils;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * A simple {@link Fragment} subclass.
 */
public class CrimeFragment extends Fragment implements ICrimeView{

//    private Crime mCrime;
    private View mLayout;
    private EditText mEtCrimeTitle;
    private CrimePersenter mCrimePersenter;
    private CheckBox mCbCrimeSolved;
    private Button mBtnDate;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        UUID uuid = (UUID) arguments.getSerializable(Contance.CRIME_INTENT_KEY);
        this.mCrimePersenter = new CrimePersenter(this,getContext(),uuid);
//        this.mCrime = new Crime();


    }

    public static Fragment getInstance(UUID uuid)    //降低与托管Activity的耦合,方便进行复用
    {
        CrimeFragment crimeFragment = new CrimeFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Contance.CRIME_INTENT_KEY,uuid);
        crimeFragment.setArguments(bundle);
        return crimeFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mLayout = inflater.inflate(R.layout.fragment_crime, container, false);
        initUI();
        this.mCrimePersenter.replaceView();
        return mLayout;
    }

    private void initUI() {
        initFindView();
        initSetLinster();
    }

    private void initSetLinster() {
        mEtCrimeTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                mCrime.setmCrimeTitle(charSequence.toString());
                CrimeFragment.this.mCrimePersenter.setCrimeTitle();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mCbCrimeSolved.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mCrimePersenter.setIsSolved();
            }
        });
    }

    private void initFindView() {
        mEtCrimeTitle = (EditText) mLayout.findViewById(R.id.et_crimrtitle);
        mCbCrimeSolved = (CheckBox) mLayout.findViewById(R.id.cb_crime_solved);
        mBtnDate = (Button) mLayout.findViewById(R.id.btn_crime_date);
        String strDate = Utils.DateFormat(mCrimePersenter.getDate());
        Log.e("strDate",strDate);
        mBtnDate.setText(strDate);
    }

    @Override
    public String getCrimeTitle() {
        return mEtCrimeTitle.getText().toString();
    }

    @Override
    public void setCrimeTitle() {
        String title = mCrimePersenter.getCrimeTitle();
        mEtCrimeTitle.setText(title);
    }

    @Override
    public boolean getIsSolved() {
        return mCbCrimeSolved.isChecked();
    }

    @Override
    public void setIsSolved() {
        boolean solved = mCrimePersenter.isSolved();
        mCbCrimeSolved.setChecked(solved);
    }

    @Override
    public void setDate() {
        Date date = mCrimePersenter.getDate();
        this.mBtnDate.setText(Utils.DateFormat(date));
    }
}
