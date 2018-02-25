package com.example.miguel909.bh2018;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import au.com.bytecode.opencsv.CSVWriter;

/**
 * Created by miguel909 on 28/01/2018.
 */

public class Order {
    private Context mContext;
    private ArrayList<String[]> mList;
    private ArrayList<String> itemKey;
    private ArrayList<String> itemName;
    private ArrayList<Integer> itemImage;
    private ArrayList<Integer> quantity;
    private ArrayList<String> unitPrice;

    public Order(Context c){
        mContext = c;
        itemKey = new ArrayList<String>();
        itemName = new ArrayList<String>();
        itemImage = new ArrayList<Integer>();
        quantity = new ArrayList<Integer>();
        unitPrice = new ArrayList<String>();
        mList = new ArrayList<String[]>();

        loadData();
    }

    public void loadData(){
        try {
            InputStreamReader csvReader = new InputStreamReader(mContext.getApplicationContext().getAssets().open("cart.csv"));
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
            itemName.add(mList.get(i)[1]);
            if(mList.get(i)[2].equals("n/a")) {
                itemImage.add(mContext.getResources().getIdentifier("logo_icon", "drawable", mContext.getPackageName()));
            }else{
                itemImage.add(mContext.getResources().getIdentifier(mList.get(i)[2], "drawable", mContext.getPackageName()));
            }
            quantity.add(Integer.parseInt(mList.get(i)[3]));
            unitPrice.add(mList.get(i)[4]);
        }
    }

    public ArrayList<String> getItemKey() {
        return itemKey;
    }

    public ArrayList<String> getItemName() {
        return itemName;
    }

    public ArrayList<Integer> getItemImage() {
        return itemImage;
    }

    public ArrayList<Integer> getQuantity() {
        return quantity;
    }

    public ArrayList<String> getUnitPrice() {
        return unitPrice;
    }

    public void addToCart(String in, int ii ,int q, String up){
        try {
            CSVWriter writer = new CSVWriter(new FileWriter("cart.csv",true));
            String[] order = ((this.getItemKey().size()+1) + "," + in + "," + ii + "," + q + "," + up).split(",");
            writer.writeNext(order);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
