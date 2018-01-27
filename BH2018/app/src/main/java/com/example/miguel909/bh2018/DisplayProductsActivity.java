package com.example.miguel909.bh2018;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by miguel909 on 27/01/2018.
 */

public class DisplayProductsActivity extends AppCompatActivity{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_products_activity);

        ImageView headerBackground = findViewById(R.id.display_products_header_background);
        TextView headerText = findViewById(R.id.display_products_header_text);

        GridView gridView = findViewById(R.id.display_products_grid);
        gridView.setAdapter(new ProductAdapter(this));

    }
}
