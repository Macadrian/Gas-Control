package com.room.example.view;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;

import com.room.example.Fuel;
import com.room.example.R;
import com.room.example.modelo.entidad.ComunidadEntity;
import com.room.example.modelo.entidad.ProvinciaEntity;
import com.room.example.modelo.entidad.PuebloEntity;
import com.room.example.presenter.DataPresenter;
import com.room.example.presenter.IDataPresenter;

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
    private AutoCompleteTextView townTextView;
    private Button button;

    private IDataPresenter iDataPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_activity);

        //region Inicialización

        spinnerCommunity = findViewById(R.id.CommunitySpinner);
        spinnerProvince = findViewById(R.id.ProvinceSpinner);
        townTextView = findViewById(R.id.TownAutoComplete);
        spinnerFuel = findViewById(R.id.FuelSpinner);
        button = findViewById(R.id.PricesButton);

        iDataPresenter = new DataPresenter(this);

        //endregion
        iDataPresenter.obtenerListaComunidades();

        //Cuando seleccionamos un Item de la Comunidad...
        spinnerCommunity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                //Al seleccionar una comunidad, podemos activar el spinner de provincias.
                townTextView.setText("");
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
                townTextView.setText("");
                iDataPresenter.obtenerListaPueblos();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });

        townTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {

            }

            @Override
            public void afterTextChanged(Editable s) {
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

    @Override
    public void updateSpinnerTowns(List<PuebloEntity> lista)
    {
        ArrayAdapter<PuebloEntity> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, lista);
        townTextView.setAdapter(adapter);
    }

    @Override
    public void updateSpinnerFuels(List<Fuel> lista)
    {
        ArrayAdapter<Fuel> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, lista);
        spinnerProvince.setAdapter(adapter);
    }

    @Override
    public String getPuebloElegido() {
        return "";
    }

    @Override
    public String getFuelElegido() {
        return "";
    }
}
