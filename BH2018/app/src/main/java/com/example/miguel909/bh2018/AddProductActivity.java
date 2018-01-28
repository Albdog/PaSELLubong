package com.example.miguel909.bh2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.miguel909.bh2018.R;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddProductActivity extends AppCompatActivity {

    @BindView(R.id.productNameText) EditText productNameText;
    @BindView(R.id.productDescriptionText) EditText productDescriptionText;
    @BindView(R.id.priceText) EditText priceText;
    @BindView(R.id.categorySpinner) Spinner categorySpinner;

    private String name;
    private String desc;
    private String price;
    private int category_id;
    private ArrayList<String[]> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        ButterKnife.bind(this);

        String next[];
        list = new ArrayList<>();
        try {
            CSVReader reader = new CSVReader(new InputStreamReader(getAssets().open("items.csv")));
            while(true) {
                next = reader.readNext();
                if(next != null) {
                    list.add(next);
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnClick (R.id.addButton)
    public void addNewItem() {
        name = productNameText.getText().toString();
        desc = productDescriptionText.getText().toString();
        price = priceText.getText().toString();
        category_id = categorySpinner.getSelectedItemPosition() + 1;

        try {
            CSVWriter writer = new CSVWriter(new FileWriter("items.csv", true));
            String[] item = (list.size() + 1 + "," + name + "," + desc + "," + price + "," + category_id + "," + AdminActivity.sellerID).split(",");
            writer.writeNext(item);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        productNameText.setText("");
        productDescriptionText.setText("");
        priceText.setText("");
    }

    @OnClick (R.id.proceedButton)
    public void proceed() {name = productNameText.getText().toString();
        desc = productDescriptionText.getText().toString();
        price = priceText.getText().toString();
        category_id = categorySpinner.getSelectedItemPosition() + 1;

        try {
            CSVWriter writer = new CSVWriter(new FileWriter("items.csv", true));
            String[] item = (list.size() + 1 + "," + name + "," + desc + "," + price + "," + category_id + "," + AdminActivity.sellerID).split(",");
            writer.writeNext(item);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Intent intent = new Intent(this, AdminActivity.class);
        startActivity(intent);
    }
}