package com.room.example.modelo;

import android.app.Application;
import android.content.Context;

import com.room.example.modelo.dao.ComunidadDao;
import com.room.example.modelo.entidad.ComunidadEntity;

import java.util.List;

public class DatabaseRepository {
    private ComunidadDao comunidadDao;
    private List<ComunidadEntity> listaComunidad;

    private Comunidad comunidadDao;
    private List<ComunidadEntity> listaComunidad;

    private ComunidadDao comunidadDao;
    private List<ComunidadEntity> listaComunidad;


    public DatabaseRepository(Context application) {
        AppDatabase appDatabase = AppDatabase.getDatabase(application);
        comunidadDao = appDatabase.comunidadDao();
        listaComunidad = comunidadDao.obtenerListaComunidad();
    }

    public List<ComunidadEntity> getListaComunidad() {
        return listaComunidad;
    }
    public List<ProvinciaEntity> getListaProvincia() {
        return listaProvincia;
    }
    public List<PuebloEntity> getListaPueblo() {
        return listaPueblo;
    }
}
