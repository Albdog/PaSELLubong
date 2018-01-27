package com.example.miguel909.bh2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import au.com.bytecode.opencsv.CSVWriter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateAccountActivity extends AppCompatActivity {

    @BindView(R.id.usernameText) EditText usernameText;
    @BindView(R.id.passwordText) EditText passwordText;
    @BindView(R.id.confirmPasswordText) EditText confirmPasswordText;
    @BindView(R.id.givenNameText) EditText giveNameText;
    @BindView(R.id.middleNameText) EditText middleNameText;
    @BindView(R.id.lastNameText) EditText lastNameText;
    @BindView(R.id.emailText) EditText emailText;
    @BindView(R.id.phoneText) EditText phoneText;
    @BindView(R.id.bdayText) EditText bdayText;
    @BindView(R.id.addressText) EditText addressText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        ButterKnife.bind(this);
    }

    @OnClick (R.id.createAccountButton)
    public void createAccount() {
        String username = usernameText.getText().toString();
        String password = passwordText.getText().toString();
        String confirm = confirmPasswordText.getText().toString();
        String given = giveNameText.getText().toString();
        String middle = middleNameText.getText().toString();
        String last = lastNameText.getText().toString();
        String email = emailText.getText().toString();
        String phone = phoneText.getText().toString();
        String bday = bdayText.getText().toString();
        String address = addressText.getText().toString();

        if(password.equals(confirm)) {
            try {
                CSVWriter writer = new CSVWriter(new FileWriter("users.csv", true));
                String[] user = (LoginActivity.users.length + 1 + "," + username + "," + password + "," + given + "," + middle + "," + last + ",c").split(",");
                writer.writeNext(user);
                writer.close();

                writer = new CSVWriter(new FileWriter("customer.csv", true));
                String[] customer = (LoginActivity.users.length + 1 + "," + email + "," + phone + "," + bday + "," + address).split(",");
                writer.writeNext(customer);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}