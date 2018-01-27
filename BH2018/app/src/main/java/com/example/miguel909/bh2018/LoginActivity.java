package com.example.miguel909.bh2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView (R.id.usernameText) EditText usernameText;
    @BindView(R.id.passwordText) EditText passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick (R.id.loginButton)
    public  void login() {
        Intent intent = new Intent(this, AdminActivity.class);
        startActivity(intent);
    }

    @OnClick (R.id.createAccountText)
    public void createAccount() {
        Intent intent  = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);
    }
}
