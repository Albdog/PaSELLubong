package com.example.miguel909.bh2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.miguel909.bh2018.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddProductActivity extends AppCompatActivity {

    @BindView(R.id.productNameText) EditText productNameText;
    @BindView(R.id.productDescriptionText) EditText productDescriptionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        ButterKnife.bind(this);
    }

    @OnClick (R.id.addButton)
    public void addNewItem() {
        productNameText.setText("");
        productDescriptionText.setText("");
    }

    @OnClick (R.id.proceedButton)
    public void proceed() {
        Intent intent = new Intent(this, AdminActivity.class);
        startActivity(intent);
    }
}