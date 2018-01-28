package com.example.miguel909.bh2018;

import android.content.Context;
import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import au.com.bytecode.opencsv.CSVReader;

/**
 * Created by miguel909 on 27/01/2018.
 */

class TribeItem {
    private Context mContext;
    private ArrayList<Integer> resourceIds;
    private ArrayList<String> tribeName;
    private ArrayList<String> tribeDescription;
    private ArrayList<String> region;
    private ArrayList<String> tribeKey;
    private ArrayList<String[]> mList;

    public TribeItem(Context c){
        tribeKey = new ArrayList<String>();
        resourceIds = new ArrayList<Integer>();
        tribeName = new ArrayList<String>();
        tribeDescription = new ArrayList<String>();
        region = new ArrayList<String>();
        mList = new ArrayList<String[]>();
        mContext = c;
        loadData();

    }

    private void loadData(){
        try {
            InputStreamReader csvReader = new InputStreamReader(mContext.getApplicationContext().getAssets().open("tribes.csv"));
            BufferedReader bufferedReader = new BufferedReader(csvReader);

            String line;
            String csvSplitBy =",";
            while ((line = bufferedReader.readLine()) != null) {
                mList.add(line.split(csvSplitBy));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < mList.size(); i++){
            tribeKey.add(mList.get(i)[0]);
            tribeName.add(mList.get(i)[1]);
            tribeDescription.add(mList.get(i)[2]);
            region.add(mList.get(i)[3]);
            resourceIds.add(mContext.getResources().getIdentifier(mList.get(i)[4],"drawable", mContext.getPackageName()));
        }
    }

    public ArrayList<String> getTribeKey() {
        return tribeKey;
    }

    public ArrayList<Integer> getResourceIds(){
        return resourceIds;
    }

    public ArrayList<String> getTribeName(){
        return tribeName;
    }

    public ArrayList<String> getTribeDescription(){
        return tribeDescription;
    }

    public ArrayList<String> getRegion() {
        return region;
    }
}
