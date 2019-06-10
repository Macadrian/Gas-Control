package com.room.example.modelo.entidad;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "comida_tabla")
public class MealEntity
{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "codigo")
    @NonNull
    private Integer codigo;

    @ColumnInfo(name = "nombre")
    private String nombre;

    @ColumnInfo(name = "imagen", typeAffinity = ColumnInfo.BLOB)
    private byte[] imagen;

    public MealEntity(String nombre, byte[] imagen)
    {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public MealEntity() {}

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setImagen( byte[] imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() { return "" + nombre; }
}

