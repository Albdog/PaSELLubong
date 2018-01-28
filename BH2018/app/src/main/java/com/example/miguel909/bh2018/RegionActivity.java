package com.example.miguel909.bh2018;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by miguel909 on 27/01/2018.
 */

public class RegionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.region_activity);

        Spinner regionSpinner = findViewById(R.id.region_spinner);
        ArrayAdapter<CharSequence> regionAdapter = ArrayAdapter.createFromResource(this, R.array.regions ,R.layout.support_simple_spinner_dropdown_item);
        regionSpinner.setAdapter(regionAdapter);

        RecyclerView tribeListRecyclerView = findViewById(R.id.tribe_list);
        TribeListAdapter tribeListAdapter = new TribeListAdapter(this);
        tribeListRecyclerView.setAdapter(tribeListAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        tribeListRecyclerView.setLayoutManager(layoutManager);

        String category = getIntent().getExtras().getString("selectedCategory");

        getSupportActionBar().setTitle(category);
    }
}
