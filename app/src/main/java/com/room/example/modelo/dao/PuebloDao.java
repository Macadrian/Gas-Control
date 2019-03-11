package com.room.example.modelo.dao;

import com.room.example.modelo.entidad.ComunidadEntity;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface PuebloDao {

    @Query("SELECT codigo, nombre FROM comunidad_tabla ORDER BY nombre") //Filtrar por Provincia
    List<PuebloEntity> obtenerListaPueblo();

    @Insert
    void insert(PuebloEntity puebloEntity);

}
