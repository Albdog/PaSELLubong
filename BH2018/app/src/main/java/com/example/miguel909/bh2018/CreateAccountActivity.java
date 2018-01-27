package com.example.miguel909.bh2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        ButterKnife.bind(this);
    }

    @OnClick (R.id.createAccountButton)
    public void createAccount() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}