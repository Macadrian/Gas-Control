package com.room.example.modelo;

import com.room.example.modelo.entidad.ComunidadEntity;
import com.room.example.modelo.entidad.ProvinciaEntity;
import com.room.example.modelo.entidad.PuebloEntity;

import java.util.List;

import androidx.room.Insert;
import androidx.room.Query;

@androidx.room.Dao
public interface IDao
{
    //--------- Tabla Comunidad ---------

    @Query("select codigo, nombre from comunidad_tabla order by nombre")
    List<ComunidadEntity> obtenerListaComunidad();

    @Insert
    void insert(ComunidadEntity comunidadEntity);

    //--------- Tabla Provincia ---------

    @Query("select codigo, idComunidad, nombre from provincia_tabla where idComunidad = :comunidad order by nombre") //Filtrar por Comunidad
    List<ProvinciaEntity> obtenerListaProvincia(int comunidad);

    @Insert
    void insert(ProvinciaEntity provinciaEntity);

    //--------- Tabla Pueblo ---------

    @Query("select codigo, idProvincia, nombre from pueblo_tabla where idProvincia = :provincia order by nombre") //Filtrar por Provincia
    List<PuebloEntity> obtenerListaPueblo(int provincia);

    @Insert
    void insert(PuebloEntity puebloEntity);

}
