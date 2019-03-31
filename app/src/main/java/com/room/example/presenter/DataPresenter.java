package com.room.example.presenter;

import com.android.volley.Request;
import com.android.volley.Response;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.room.example.ListaGasolina;
import com.room.example.modelo.IModel;
import com.room.example.modelo.Model;
import com.room.example.modelo.entidad.ComunidadEntity;
import com.room.example.modelo.entidad.ProvinciaEntity;
import com.room.example.modelo.entidad.PuebloEntity;
import com.room.example.view.DataActivity;
import com.room.example.view.IDataActivity;


import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DataPresenter implements IDataPresenter
{
    IDataActivity iDataActivity;
    IModel iModel;
    List<PuebloEntity> listaPueblos = new ArrayList<>();

    public DataPresenter(DataActivity dataActivity)
    {
        this.iDataActivity = dataActivity;
        this.iModel = Model.getInstance(dataActivity.getApplicationContext());
    }

    @Override
    public void obtenerListaComunidades()
    {
        iModel.obtenerListaComunidades(new Response.Listener<List<ComunidadEntity>>() {
            @Override
            public void onResponse(List<ComunidadEntity> response) {
                iDataActivity.updateSpinnerCommunities(response);
            }
        });
    }

    @Override
    public void obtenerListaProvincias(int codigoComunidad)
    {
        iModel.obtenerListaProvincias(new Response.Listener<List<ProvinciaEntity>>() {
            @Override
            public void onResponse(List<ProvinciaEntity> response) {
                iDataActivity.updateSpinnerProvinces(response);
            }
        },codigoComunidad);
    }

    @Override
    public void obtenerListaPueblos(int codigoProvincia) {
        iModel.obtenerListaPueblos(new Response.Listener<List<PuebloEntity>>() {
            @Override
            public void onResponse(List<PuebloEntity> response) {
                iDataActivity.updateSpinnerTowns(response);
                listaPueblos = response;
            }
        },codigoProvincia);
    }

    @Override
    public void obtenerListaFuels()
    {
        iDataActivity.updateSpinnerFuels(new ListaGasolina().getGasTypes());
    }

    @Override
    public void gestionarBoton()
    {
       for(PuebloEntity pueblo: listaPueblos)
       {
           String puebloEscrito = iDataActivity.getPuebloEscrito();
           if(puebloEscrito.matches(pueblo.toString()))
           {
                iDataActivity.setButton(true);
                return;
           }
       }
       iDataActivity.setButton(false);
    }
}
