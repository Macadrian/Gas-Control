package com.room.example.modelo.dao;

import com.room.example.modelo.entidad.ComunidadEntity;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface ComunidadDao {

    @Query("select codigo, nombre from comunidad_tabla order by nombre")
    List<ComunidadEntity> obtenerListaComunidad();

    @Insert
    void insert(ComunidadEntity comunidadEntity);

}
