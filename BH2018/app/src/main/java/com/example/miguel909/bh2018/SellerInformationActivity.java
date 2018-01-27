package com.example.miguel909.bh2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SellerInformationActivity extends AppCompatActivity {

    @BindView(R.id.productsSoldList) ListView productsSoldList;
    @BindView(R.id.sellerName) TextView sellerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_information);
        ButterKnife.bind(this);

        ProductsSoldAdapter productsSoldAdapter = new ProductsSoldAdapter(this);
        productsSoldList.setAdapter(productsSoldAdapter);
    }
}