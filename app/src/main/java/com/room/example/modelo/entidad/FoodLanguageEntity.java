package com.room.example.modelo.entidad;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "idiomas_alimentos_tabla")
public class FoodLanguageEntity
{
    @PrimaryKey
    @ColumnInfo(name = "codigoAlimento")
    @NonNull
    private Integer codigoAlimento;

    @PrimaryKey
    @ColumnInfo(name = "codigoIdioma")
    @NonNull
    private int codigoIdioma;

    @ColumnInfo(name = "nombre")
    @NonNull
    private String nombre;


    public FoodLanguageEntity(int codigoAlimento,int codigoIdioma, String nombre)
    {
        this.nombre = nombre;
        this.codigoIdioma = codigoIdioma;
        this.codigoAlimento = codigoAlimento;
    }

    public Integer getCodigoComponente() {
        return codigoAlimento;
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
