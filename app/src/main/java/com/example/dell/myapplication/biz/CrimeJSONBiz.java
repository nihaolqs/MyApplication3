package com.example.dell.myapplication.biz;


import android.content.Context;

import com.example.dell.myapplication.bean.Crime;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.InputStreamReader;

import java.io.Writer;

import java.util.List;

/**
 * Created by dell on 2016/8/31.
 */
public class CrimeJSONBiz implements ICrimeSave2JSON ,ICrimeRead4JSON{

    private static final String JSON_NAME = "Crime_json.txt";
    private Context mContext;

    public CrimeJSONBiz(Context mContext) {
        this.mContext = mContext;

    }

    @Override
    public List<Crime> read4JSON() {

        StringBuffer sb = null;
        BufferedReader br = null;
        try {

            sb = new StringBuffer(10);
            FileInputStream fis = mContext.openFileInput(this.JSON_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
//            BufferedInputStream bis = new BufferedInputStream(fis);

            br = new BufferedReader(isr);

            String line;

            while((line = br.readLine()) != null)
            {
                sb.append(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(br != null)
            {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if(sb != null)
        {

        }

        return null;
    }

    @Override
    public void save2JSON(List<Crime> crimeList) {
        Writer out;
//        JsonWriter jsonWriter = new JsonWriter(out);

    }
}
