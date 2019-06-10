package com.room.example.modelo.entidad;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "comida_tabla")
public class FoodEntity
{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "codigo")
    @NonNull
    private Integer codigo;

    @PrimaryKey
    @ColumnInfo(name = "nombre")
    @NonNull
    private String nombre;


    public FoodEntity(String nombre)
    {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
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
