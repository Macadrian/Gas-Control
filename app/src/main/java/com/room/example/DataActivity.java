package com.room.example;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * View for the data acquiring activity, with the methods recommended in the project description.
 */
public class DataActivity extends AppCompatActivity implements IDataActivity {

    /**
     * onCreate method that inflates the data_activity xml layout.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_activity);
    }

    @Override
    public void showCommunities() {

    }

    @Override
    public void showProvinces() {

    }

    @Override
    public void showTowns() {

    }
}
