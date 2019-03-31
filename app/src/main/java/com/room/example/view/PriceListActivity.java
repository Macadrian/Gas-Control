package com.room.example.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.room.example.GasPriceAdapter;
import com.room.example.GasStation;
import com.room.example.R;
import com.room.example.presenter.IDataPresenter;
import com.room.example.presenter.IPriceListPresenter;
import com.room.example.presenter.PriceListPresenter;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PriceListActivity extends AppCompatActivity implements  IPriceListActivity
{
    ProgressBar loadinDataBar;
    ListView listaGasolineras;
    IPriceListPresenter iPriceListPresenter;
    Bundle bundle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prices_activity);
        iPriceListPresenter = new PriceListPresenter(this);

        Intent intent = getIntent();
        bundle = intent.getBundleExtra("INFO");

        loadinDataBar =  findViewById(R.id.progressBar);
        listaGasolineras = findViewById(R.id.list);

        iPriceListPresenter.makeCall(bundle.getInt("GAS_TYPE"),bundle.getLong("TOWN_NAME"));
    }

    @Override
    public void updateListGasolineras(List<GasStation> gasStationList)
    {
        //if (gasStationList.size() != 0) {
            GasPriceAdapter gasPriceAdapter = new GasPriceAdapter(this, R.layout.list_item, gasStationList);
            listaGasolineras.setAdapter(gasPriceAdapter);
        //}

    }

    @Override
    public void mostrarProgreso(boolean active)
    {
        if(!active) loadinDataBar.setVisibility(View.INVISIBLE);
        else loadinDataBar.setVisibility(View.VISIBLE);
    }
}
