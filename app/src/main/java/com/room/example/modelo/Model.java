package com.room.example.modelo;


import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.room.example.ListaGasolina;
import com.room.example.PriceRequest;
import com.room.example.modelo.entidad.ComunidadEntity;
import com.room.example.modelo.entidad.ProvinciaEntity;
import com.room.example.modelo.entidad.PuebloEntity;

import org.json.JSONObject;

import java.util.List;

public class Model implements IModel
{
    private static Model INSTANCE;

    private IDao iDao;
    private AppDatabase appDatabase;

    private List<ComunidadEntity> listaComunidad;
    private List<ProvinciaEntity> listaProvincia;
    private List<PuebloEntity> listaPueblo;

    private final Resources resources;


    private Model(Context application) {
        appDatabase = AppDatabase.getDatabase(application);

        iDao = appDatabase.dao();

        resources = application.getResources();
    }

    public static Model getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new Model(context);
        }
        return INSTANCE;
    }

    @Override
    public void obtenerListaComunidades(Response.Listener listener)
    {
        new ObtenerListaComunidadesTask(iDao,listener).execute();
    }

    @Override
    public void obtenerListaProvincias(Response.Listener listener,int codigoComunidad)
    {
        new ObtenerListaProvinciasTask(iDao,listener,codigoComunidad).execute();
    }

    @Override
    public void obtenerListaPueblos(Response.Listener listener, int codigoProvincia)
    {
        new ObtenerListaPueblosTask(iDao,listener,codigoProvincia).execute();
    }

    @Override
    public void getTownStationsPrices(long pueblo, int gasType, Response.Listener listener,Response.ErrorListener errorListener, Context context)
    {
        new PriceRequest(context).getPrices(pueblo,gasType,listener,errorListener);
    }

    //region Tasks Classes
    private class ObtenerListaComunidadesTask extends AsyncTask<Void, Void, List<ComunidadEntity>>
    {
        private IDao dao;
        private Response.Listener listener;

        ObtenerListaComunidadesTask(IDao dao, Response.Listener listener)
        {
            this.dao  = dao;
            this.listener = listener;
        }

        @Override
        protected List<ComunidadEntity> doInBackground(Void... params) {
            return dao.obtenerListaComunidad();
        }

        @Override
        protected void onPostExecute(List<ComunidadEntity> communityList) {
           listener.onResponse(communityList);
        }
    }

    private class ObtenerListaProvinciasTask extends AsyncTask<Void, Void, List<ProvinciaEntity>>
    {
        private final Response.Listener listener;
        private IDao dao;
        private int codigoComunidad;

        ObtenerListaProvinciasTask(IDao dao, Response.Listener listener, int codigoComunidad)
        {
            this.dao  = dao;
            this.codigoComunidad = codigoComunidad;
            this.listener = listener;
        }

        @Override
        protected List<ProvinciaEntity> doInBackground(Void... params) {
            return dao.obtenerListaProvincia(codigoComunidad);
        }

        @Override
        protected void onPostExecute(List<ProvinciaEntity> provinciaEntities) {
            listener.onResponse(provinciaEntities);
        }
    }

    private class ObtenerListaPueblosTask extends AsyncTask<Void, Void, List<PuebloEntity>>
    {
        private final Response.Listener listener;
        private IDao dao;
        private int codigoProvincia;

        ObtenerListaPueblosTask(IDao dao, Response.Listener listener, int codigoProvincia)
        {
            this.dao  = dao;
            this.codigoProvincia = codigoProvincia;
            this.listener = listener;
        }

        @Override
        protected List<PuebloEntity> doInBackground(Void... params)
        {
            return dao.obtenerListaPueblo(codigoProvincia);
        }

        @Override
        protected void onPostExecute(List<PuebloEntity> puebloEntities) {
            listaPueblo = puebloEntities;
            listener.onResponse(puebloEntities);
        }
    }
    //endregion
}
