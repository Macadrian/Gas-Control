package com.room.example.view;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

import com.room.example.Fuel;
import com.room.example.R;
import com.room.example.modelo.entidad.ComunidadEntity;
import com.room.example.modelo.entidad.ProvinciaEntity;
import com.room.example.presenter.DataPresenter;
import com.room.example.presenter.IDataPresenter;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * View for the data acquiring activity, with the methods recommended in the project description.
 */
public class DataActivity extends AppCompatActivity implements IDataActivity
{

    /**
     * onCreate method that inflates the data_activity xml layout.
     * @param savedInstanceState
     */

    private Spinner spinnerCommunity;
    private Spinner spinnerProvince;
    private Spinner spinnerFuel;
    private AutoCompleteTextView town;

    private IDataPresenter iDataPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_activity);

        //region Inicialización

        spinnerCommunity = findViewById(R.id.CommunitySpinner);
        spinnerProvince = findViewById(R.id.ProvinceSpinner);
        town = findViewById(R.id.TownAutoComplete);
        spinnerFuel = findViewById(R.id.FuelSpinner);

        iDataPresenter = new DataPresenter(this);

        //endregion
        iDataPresenter.obtenerListaComunidades();
        iDataPresenter.obtenerListaFuels();

        //Cuando seleccionamos un Item de la Comunidad...
        spinnerCommunity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                //Al seleccionar una comunidad, podemos activar el spinner de provincias.
                spinnerProvince.setEnabled(true);

                //Llamamos al presenter para asignar la lista de Provincias
                iDataPresenter.obtenerListaProvincias();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });

        //Cuando seleccionamos un Item de la Provincia...
        spinnerProvince.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });

        //Cuando seleccionamos un Item del gasoil...
        spinnerFuel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Nos guardamos su código.
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void updateSpinnerCommunities(List<ComunidadEntity> lista)
    {
        ArrayAdapter<ComunidadEntity> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, lista);
        spinnerCommunity.setAdapter(adapter);
    }

    @Override
    public void updateSpinnerProvinces(List<ProvinciaEntity> lista)
    {
        ArrayAdapter<ProvinciaEntity> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, lista);
        spinnerProvince.setAdapter(adapter);
    }

    /*@Override
    public void updateSpinnerTowns(List<PuebloEntity> lista)
    {
        ArrayAdapter<PuebloEntity> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, lista);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }*/

    @Override
    public void updateSpinnerFuels(List<Fuel> lista)
    {
        ArrayAdapter<Fuel> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, lista);
        spinnerProvince.setAdapter(adapter);
    }
}
