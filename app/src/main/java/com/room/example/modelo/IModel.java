package com.room.example.modelo;

import android.content.Context;

import com.android.volley.Response;
import com.room.example.ListaGasolina;
import com.room.example.modelo.entidad.PuebloEntity;

import java.util.List;

public interface IModel
{
    void obtenerListaComunidades(Response.Listener listener);
    void obtenerListaProvincias(Response.Listener listener, int codigoComunidad);
    void obtenerListaPueblos(Response.Listener listener, int codigoProvincia);

    void getTownStationsPrices(long pueblo, int gasType, Response.Listener listener, Response.ErrorListener errorListener, Context context);
}
