package com.example.miguel909.bh2018;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.miguel909.bh2018.R;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import au.com.bytecode.opencsv.CSVReader;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AdminActivity extends AppCompatActivity {

    public static int sellerID;
    public static String sellerName;
    public static String tribe;
    private String[] sellerIDs;
    private String[] sellerNames;
    private String[] sellerTribes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        ButterKnife.bind(this);

        String next[];
        ArrayList<String[]> list = new ArrayList<>();
        try {
            CSVReader reader = new CSVReader(new InputStreamReader(getAssets().open("sellers.csv")));
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

        sellerIDs = new String[list.size()];
        sellerNames = new String[list.size()];
        sellerTribes = new String[list.size()];

        for(int i = 0; i < list.size(); i++) {
            sellerIDs[i] = list.get(i)[0];
            sellerNames[i] = list.get(i)[1];
            if(list.get(i)[2].equals("1")) {
                sellerTribes[i] = "Bontoc";
            }
            else if(list.get(i)[2].equals("2")) {
                sellerTribes[i] = "Ifugao";
            }
        }
    }

    @OnClick (R.id.addButton)
    public void addProduct() {
        alertDialog(AddProductActivity.class);
    }

    @OnClick(R.id.sellerButton)
    public  void viewSeller() {
        alertDialog(SellerInformationActivity.class);
    }

    @OnClick (R.id.credentialsButton)
    public void editCredentials() {
        alertDialog(EditCredentialsActivity.class);
    }

    private void alertDialog(Class activityName) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.name_dialog, null);
        builder.setView(view);
        Button confirmButton = view.findViewById(R.id.confirmButton);
        Button cancelButton = view.findViewById(R.id.cancelButton);
        final EditText sellerIDText = view.findViewById(R.id.sellerIDText);

        final AlertDialog dialog = builder.create();

        final Intent intent = new Intent(this, activityName);

        dialog.show();

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i = 0; i < sellerIDs.length; i++) {
                    sellerIDs[i] = sellerIDs[i].replaceAll(((char) 65279) + "", "");
                    if(sellerIDText.getText().toString().equals(sellerIDs[i])) {
                        sellerID = Integer.parseInt(sellerIDText.getText().toString());
                        startActivity(intent);

                        sellerName = sellerNames[i];
                        tribe = sellerTribes[i];

                        break;
                    }
                    else {
                        Toast.makeText(AdminActivity.this, "ID does not exist.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.hide();
            }
        });
    }

    @OnClick (R.id.logoutButton)
    public void logout() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}