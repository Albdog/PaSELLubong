package com.example.miguel909.bh2018;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.miguel909.bh2018.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class AdminActivity extends AppCompatActivity {

    public static int sellerID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        ButterKnife.bind(this);
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
                sellerID = Integer.parseInt(sellerIDText.getText().toString());
                startActivity(intent);
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