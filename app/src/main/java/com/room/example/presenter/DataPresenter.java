package com.room.example.presenter;

import android.content.Context;

import com.room.example.Fuel;
import com.room.example.modelo.IModel;
import com.room.example.modelo.Model;
import com.room.example.modelo.entidad.ComunidadEntity;
import com.room.example.modelo.entidad.ProvinciaEntity;
import com.room.example.modelo.entidad.PuebloEntity;
import com.room.example.view.DataActivity;
import com.room.example.view.IDataActivity;

import java.util.List;

public class DataPresenter implements IDataPresenter
{
    IDataActivity iDataActivity;
    IModel iModel;

    public DataPresenter(DataActivity dataActivity)
    {
        this.iDataActivity = dataActivity;
        this.iModel = new Model(dataActivity.getApplicationContext());
    }

    @Override
    public void obtenerListaComunidades()
    {
        List<ComunidadEntity> lista = iModel.obtenerListaComunidades();
        iDataActivity.updateSpinnerCommunities(lista);
    }

    @Override
    public void obtenerListaProvincias()
    {
        List<ProvinciaEntity> lista = iModel.obtenerListaProvincias();
        iDataActivity.updateSpinnerProvinces(lista);
    }

    @Override
    public void obtenerListaPueblos() {
        List<PuebloEntity> lista = iModel.obtenerListaPueblos();
        iDataActivity.updateSpinnerTowns(lista);
    }

    @Override
    public void obtenerListaFuels()
    {
        List<Fuel> lista = iModel.obtenerListaFuels();
        iDataActivity.updateSpinnerFuels(lista);
    }

    @Override
    public void gestionarBoton()
    {
        //if(iDataActivity)
    }
}
