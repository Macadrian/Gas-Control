package com.room.example.modelo;


import android.content.Context;
import android.os.AsyncTask;

import com.android.volley.toolbox.JsonObjectRequest;
import com.room.example.Fuel;
import com.room.example.modelo.entidad.ComunidadEntity;
import com.room.example.modelo.entidad.ProvinciaEntity;
import com.room.example.modelo.entidad.PuebloEntity;

import java.util.ArrayList;
import java.util.List;

public class Model implements IModel
{
    private static Model INSTANCE;

    private IDao iDao;
    private List<ComunidadEntity> listaComunidad;
    private List<ProvinciaEntity> listaProvincia;
    private List<PuebloEntity> listaPueblo;

    private String url = "https://sedeaplicaciones.minetur.gob.es/ServiciosRESTCarburantes/PreciosCarburantes/EstacionesTerrestres/FiltroMunicipioProducto/ ";

    public Model(Context application) {
        AppDatabase appDatabase = AppDatabase.getDatabase(application);

        iDao = appDatabase.dao();
        //region Pruebas

        listaComunidad = new ArrayList<>();

        new ObtenerListaComunidadesTask(iDao).execute();

        //listaComunidad = iDao.obtenerListaComunidad();
        //listaComunidad.add(new ComunidadEntity(1,"hola"));
        //listaComunidad.add(new ComunidadEntity(2,"adios"));

        listaProvincia = new ArrayList<>();
        listaProvincia.add(new ProvinciaEntity(1,1,"como te llamas"));
        listaProvincia.add(new ProvinciaEntity(2,1,"encantado de conocerte"));
        listaProvincia.add(new ProvinciaEntity(3,2,"ya nos veremos"));
        listaProvincia.add(new ProvinciaEntity(4,2,"que te vaya bien"));
        //endregion
    }

    public static Model getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new Model(context);
        }
        return INSTANCE;
    }

    @Override
    public List<ComunidadEntity> obtenerListaComunidades() {
        //listaComunidad = iDao.obtenerListaComunidad();
        return listaComunidad;
    }

    @Override
    public List<ProvinciaEntity> obtenerListaProvincias() {
        return listaProvincia;
    }

    @Override
    public List<Fuel> obtenerListaFuels() {
        return null;
    }

    //region Tasks Classes
    private static class ObtenerListaComunidadesTask extends AsyncTask<Void,Void,Void>
    {
        public List<ComunidadEntity> lista;
        private IDao dao;

        public ObtenerListaComunidadesTask(IDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids)
        {
            //lista = dao.obtenerListaComunidad();
            return null;
        }

    }

    //endregion
}
