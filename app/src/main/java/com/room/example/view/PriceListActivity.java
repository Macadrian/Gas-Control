package com.room.example.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.room.example.GasPriceAdapter;
import com.room.example.GasStation;
import com.room.example.R;
import com.room.example.presenter.IDataPresenter;
import com.room.example.presenter.IPriceListPresenter;
import com.room.example.presenter.PriceListPresenter;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class PriceListActivity extends AppCompatActivity implements  IPriceListActivity
{
    ProgressBar loadinDataBar;
    ListView listaGasolineras;
    TextView noResult;
    AlertDialog dialog;

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
        noResult = findViewById(R.id.id_sinresultados);

        iPriceListPresenter.makeCall(bundle.getInt("GAS_TYPE"),bundle.getLong("TOWN_NAME"));

        listaGasolineras.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                openDialog((GasStation)parent.getItemAtPosition(position));
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        dialog.dismiss();
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

    @Override
    public void mostrarError(String resources) {
        Toast.makeText(this, resources, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void mostrarSinResultados(boolean active)
    {
        if(!active) noResult.setVisibility(View.INVISIBLE);
        else noResult.setVisibility(View.VISIBLE);
    }

    private void openDialog(GasStation gasolinera)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.dialog_gasstation,null);

        TextView precio = view.findViewById(R.id.id_price);
        TextView address = view.findViewById(R.id.id_address);

        precio.setText(gasolinera.getPrice().toString());
        address.setText(gasolinera.getAddress());

        builder.setTitle(gasolinera.getName())
        .setView(view);

        builder.setPositiveButton(R.string.map, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id)
            {
                callMaps(gasolinera,20);// User clicked OK button
            }
        });
        builder.setNegativeButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
            }
        });

        dialog = builder.create();
        dialog.show();
    }

    private void callMaps(GasStation gasStation, int zoom)
    {
        String coordenadas = "geo:"+gasStation.getLatitud()+","+gasStation.getLength()+"?z="+zoom;
        Uri gmmIntentUri = Uri.parse(coordenadas);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }
}
