package com.room.example.modelo;


import android.content.Context;

import com.android.volley.toolbox.JsonObjectRequest;
import com.room.example.modelo.entidad.ComunidadEntity;
import com.room.example.modelo.entidad.ProvinciaEntity;
import com.room.example.modelo.entidad.PuebloEntity;
import java.util.List;

public class Model
{
    private IDao iDao;
    private List<ComunidadEntity> listaComunidad;
    private List<ProvinciaEntity> listaProvincia;
    private List<PuebloEntity> listaPueblo;

    private String url = "https://sedeaplicaciones.minetur.gob.es/ServiciosRESTCarburantes/PreciosCarburantes/EstacionesTerrestres/FiltroMunicipioProducto/ ";

    public Model(Context application) {
        AppDatabase appDatabase = AppDatabase.getDatabase(application);

        iDao = appDatabase.dao();

        listaComunidad = iDao.obtenerListaComunidad();
    }

    public List<ComunidadEntity> getListaComunidad() {
        return listaComunidad;
    }

    public void getGasolineras()
    {

    }
}
