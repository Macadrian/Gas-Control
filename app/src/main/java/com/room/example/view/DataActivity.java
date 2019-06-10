package com.room.example.view;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.room.example.ListaGasolina;
import com.room.example.R;
import com.room.example.eventos.BaseDeDatosCargada;
import com.room.example.modelo.entidad.ComunidadEntity;
import com.room.example.modelo.entidad.ProvinciaEntity;
import com.room.example.modelo.entidad.PuebloEntity;
import com.room.example.presenter.DataPresenter;
import com.room.example.presenter.IDataPresenter;

import android.content.Intent;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

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
    private ProgressBar loadinDataBar;

    private IDataPresenter iDataPresenter;

    private long townCode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_activity_new_version);

        /*if(ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET},1001);
        }*/

        //region Inicialización

        spinnerCommunity = findViewById(R.id.CommunitySpinner);
        spinnerProvince = findViewById(R.id.ProvinceSpinner);
        townTextView = findViewById(R.id.TownAutoComplete);
        spinnerFuel = findViewById(R.id.FuelSpinner);
        button = findViewById(R.id.PricesButton);
        loadinDataBar = findViewById(R.id.id_progressbardata);

        iDataPresenter = new DataPresenter(this);

        //endregion

        //Cuando seleccionamos un Item de la Comunidad...
        spinnerCommunity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                ComunidadEntity object = (ComunidadEntity) parent.getItemAtPosition(position);
                iDataPresenter.obtenerListaProvincias(object.getCodigo());

                townTextView.setText("");
                setButton(false);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });

        //Cuando seleccionamos un Item de la Provincia...
        spinnerProvince.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                ProvinciaEntity object = (ProvinciaEntity) parent.getItemAtPosition(position);
                iDataPresenter.obtenerListaPueblos(object.getCodigo());

                townTextView.setText("");
                setButton(false);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });


        townTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {

            }

            @Override
            public void afterTextChanged(Editable s)
            {
                iDataPresenter.gestionarBoton();
            }
        });

        townTextView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PuebloEntity puebloElegido = (PuebloEntity) parent.getItemAtPosition(position);
                townCode = puebloElegido.getCodigo();
            }
        });

        button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                ListaGasolina.GasType gas = (ListaGasolina.GasType) spinnerFuel.getSelectedItem();

                Bundle information = new Bundle();
                information.putInt("GAS_TYPE", gas.getCodigo());
                information.putLong("TOWN_NAME", townCode);

                Intent intent = new Intent(getBaseContext(), PriceListActivity.class);
                intent.putExtra("INFO",information);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onStart()
    {
        super.onStart();
        EventBus.getDefault().register(this);

        iDataPresenter.obtenerListaComunidades();
        iDataPresenter.obtenerListaFuels();
        setButton(false);
    }
    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Override
    public void updateSpinnerCommunities(List<ComunidadEntity> lista)
    {
        ArrayAdapter<ComunidadEntity> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);
        spinnerCommunity.setAdapter(adapter);
    }

    @Override
    public void updateSpinnerProvinces(List<ProvinciaEntity> lista)
    {
        ArrayAdapter<ProvinciaEntity> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);
        spinnerProvince.setAdapter(adapter);
    }

    @Override
    public void updateSpinnerTowns(List<PuebloEntity> lista)
    {
        ArrayAdapter<PuebloEntity> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);
        townTextView.setAdapter(adapter);
    }

    @Override
    public void updateSpinnerFuels(List<ListaGasolina.GasType> lista)
    {
        ArrayAdapter<ListaGasolina.GasType> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);
        spinnerFuel.setAdapter(adapter);
    }

    @Override
    public void setButton( boolean activado )
    {
        button.setEnabled(activado);
    }

    @Override
    public String getPuebloEscrito()
    {
        return townTextView.getText().toString();
    }

    @Override
    public void mostrarProgreso(boolean active)
    {
        if(!active) loadinDataBar.setVisibility(View.INVISIBLE);
        else loadinDataBar.setVisibility(View.VISIBLE);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(BaseDeDatosCargada event)
    {
        iDataPresenter.obtenerListaComunidades();
    }
}
