package com.example.miguel909.bh2018;

import android.content.Context;
import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import au.com.bytecode.opencsv.CSVReader;

/**
 * Created by miguel909 on 27/01/2018.
 */

class ProductItem {
    private static Context mContext;
    private static ArrayList<String> itemKey;
    private static ArrayList<Integer> resourceIds;
    private static ArrayList<String> productName;
    private static ArrayList<String> productDescription;
    private static ArrayList<String> productPrice;
    private static ArrayList<String> categoryKey;
    private static ArrayList<String> sellerKey;
    private static ArrayList<String[]> mList;
    private static ArrayList<String> tribeKey;

    public ProductItem(Context c){
        itemKey = new ArrayList<String>();
        resourceIds = new ArrayList<Integer>();
        productName = new ArrayList<String>();
        productDescription = new ArrayList<String>();
        productPrice = new ArrayList<String>();
        categoryKey = new ArrayList<String>();
        sellerKey = new ArrayList<String>();
        tribeKey = new ArrayList<String>();
        mList = new ArrayList<String[]>();
        mContext = c;
        loadData();
    }

    public void loadData(){
        try {
            InputStreamReader csvReader = new InputStreamReader(mContext.getApplicationContext().getAssets().open("items.csv"));
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
            itemKey.add(mList.get(i)[0]);
            productName.add(mList.get(i)[1]);
            productDescription.add(mList.get(i)[2]);
            productPrice.add(mList.get(i)[3]);
            categoryKey.add(mList.get(i)[4]);
            sellerKey.add(mList.get(i)[5]);
            tribeKey.add(mList.get(i)[7]);
            if(mList.get(i)[6].equals("n/a")){
                resourceIds.add(mContext.getResources().getIdentifier("logo_icon","drawable", mContext.getPackageName()));
            } else {
                resourceIds.add(mContext.getResources().getIdentifier(mList.get(i)[6],"drawable", mContext.getPackageName()));
            }

        }
    }

    public static ArrayList<String> getTribeKey() {
        return tribeKey;
    }

    public static ArrayList<String> getItemKey() {
        return itemKey;
    }

    public static ArrayList<Integer> getResourceIds() {
        return resourceIds;
    }

    public static ArrayList<String> getProductName() {
        return productName;
    }

    public static ArrayList<String> getProductDescription() {
        return productDescription;
    }

    public static ArrayList<String> getProductPrice() {
        return productPrice;
    }

    public static ArrayList<String> getCategoryKey() {
        return categoryKey;
    }

    public static ArrayList<String> getSellerKey() {
        return sellerKey;
    }
}
