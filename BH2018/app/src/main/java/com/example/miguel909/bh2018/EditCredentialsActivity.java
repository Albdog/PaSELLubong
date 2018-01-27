package com.example.miguel909.bh2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.miguel909.bh2018.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class EditCredentialsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_credentials);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.proceedButton)
    public void proceed() {
        Intent intent = new Intent(this, AdminActivity.class);
        startActivity(intent);
    }
}
