package com.example.miguel909.bh2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.miguel909.bh2018.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SellerInformationActivity extends AppCompatActivity {

    @BindView(R.id.productsSoldList) ListView productsSoldList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_information);
        ButterKnife.bind(this);

        ProductsSoldSummary productsSoldSummary = new ProductsSoldSummary(this);
        productsSoldList.setAdapter(productsSoldSummary);
    }
}