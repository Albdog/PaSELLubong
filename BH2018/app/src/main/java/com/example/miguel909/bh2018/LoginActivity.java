package com.example.miguel909.bh2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import au.com.bytecode.opencsv.CSVReader;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView (R.id.usernameText) EditText usernameText;
    @BindView(R.id.passwordText) EditText passwordText;

    public static String[] users;
    private String[] pass;
    private String[] type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        String next[];
        ArrayList<String[]> list = new ArrayList<>();
        try {
            CSVReader reader = new CSVReader(new InputStreamReader(getAssets().open("users.csv")));
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

        users = new String[list.size()];
        pass = new String[list.size()];
        type = new String[list.size()];

        for(int i = 0; i < list.size(); i++) {
            users[i] = list.get(i)[1];
            pass[i] = list.get(i)[2];
            type[i] = list.get(i)[6];
        }
    }

    @OnClick (R.id.loginButton)
    public  void login() {
        String u = usernameText.getText().toString();
        String p = passwordText.getText().toString();

        for(int i = 0; i < users.length; i++) {
            if(u.equals(users[i]) && p.equals(pass[i]) && type[i].equals("a")) {
                Intent intent = new Intent(this, AdminActivity.class);
                startActivity(intent);
                break;
            }
            else if(u.equals(users[i]) && p.equals(pass[i]) && (type[i].equals("c"))) {
                Toast.makeText(this, "You are not an admin.", Toast.LENGTH_SHORT).show();
                break;
            }
            else if(!(u.equals(users[i])) || !(p.equals(pass[i]))) {
                Toast.makeText(this, "Incorrect username/password.", Toast.LENGTH_SHORT).show();
                usernameText.setText("");
                passwordText.setText("");
                break;
            }
        }
    }

    @OnClick (R.id.createAccountText)
    public void createAccount() {
        Intent intent  = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);
    }
}
