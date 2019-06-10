package com.room.example.modelo.entidad;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "idiomas_componentes_tabla")
public class ComponentLanguageEntity
{
    @PrimaryKey
    @ColumnInfo(name = "codigoComponente")
    @NonNull
    private Integer codigoComponente;

    @PrimaryKey
    @ColumnInfo(name = "codigoIdioma")
    @NonNull
    private int codigoIdioma;

    @ColumnInfo(name = "nombre")
    @NonNull
    private String nombre;


    public ComponentLanguageEntity(int codigoComponente, int codigoIdioma, String nombre)
    {
        this.nombre = nombre;
        this.codigoIdioma = codigoIdioma;
        this.codigoComponente = codigoComponente;
    }

    public Integer getCodigoComponente() {
        return codigoComponente;
    }

    public Integer getCodigoIdioma() {
        return codigoIdioma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() { return "" + nombre; }
}
