package com.example.android.sunshine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //NOTE: BEWARE of the android.R.* it's not same as R.* especially true as I found out the
        //hard way when using android.R.id.home which is internally defined and not assigned by me.
        if (item.getItemId() == android.R.id.home) {
           onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
