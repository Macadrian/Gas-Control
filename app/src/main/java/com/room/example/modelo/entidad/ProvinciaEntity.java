package com.room.example.modelo.entidad;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "provincia_tabla")
public class ProvinciaEntity {
    @PrimaryKey
    @ColumnInfo(name = "codigo")
    @NonNull
    private int codigo;

    @ColumnInfo(name = "idComunidad")
    private int codigoComunidad;

    @ColumnInfo(name = "nombre")
    private String nombre;

    public ProvinciaEntity(int codigo, int codigoComunidad, String nombre) {
        this.codigo = codigo;
        this.codigoComunidad = codigoComunidad;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getCodigoComunidad() { return codigoComunidad; }

    public void setCodigoComunidad(int idComunidad) {
        this.codigoComunidad = idComunidad;
    }

    @Override
    public String toString() { return "" + nombre; }
}
