package com.example.miguel909.bh2018;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import au.com.bytecode.opencsv.CSVReader;

import static android.app.PendingIntent.getActivity;

/**
 * Created by miguel909 on 27/01/2018.
 */

class CategoryItem {
    private Context mContext;
    private ArrayList<String[]> mList;
    private static ArrayList<Integer> resourceIds;
    private static ArrayList<String> title;

    public CategoryItem(Context c) {
        title = new ArrayList<String>();
        resourceIds = new ArrayList<Integer>();
        mList = new ArrayList<String[]>();
        mContext = c;
        loadData();
    }

    private void loadData() {

        try {
            InputStreamReader csvReader = new InputStreamReader(mContext.getApplicationContext().getAssets().open("categories.csv"));
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

        for (int i = 0; i < mList.size(); i++) {
            title.add(mList.get(i)[1]);
            resourceIds.add(mContext.getResources().getIdentifier(mList.get(i)[2],"drawable", mContext.getPackageName()));
        }

    }

    public ArrayList<Integer> getResourceIds(){
        return resourceIds;
    }

    public ArrayList<String> getTitle(){
        return title;
    }


}
