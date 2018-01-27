package com.example.miguel909.bh2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.miguel909.bh2018.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        ButterKnife.bind(this);
    }

    @OnClick (R.id.addButton)
    public void addProduct() {
        Intent intent = new Intent(this, AddProductActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.sellerButton)
    public  void viewSeller() {
        Intent intent = new Intent(this, SellerInformationActivity.class);
        startActivity(intent);
    }

    @OnClick (R.id.credentialsButton)
    public void editCredentials() {
        Intent intent = new Intent(this, EditCredentialsActivity.class);
        startActivity(intent);
    }

    @OnClick (R.id.logoutButton)
    public void logout() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}