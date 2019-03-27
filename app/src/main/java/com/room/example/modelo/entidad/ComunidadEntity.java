package com.room.example.modelo.entidad;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "comunidad_tabla")
public class ComunidadEntity
{
    @PrimaryKey
    @ColumnInfo(name = "codigo")
    @NonNull
    private int codigo;

    @ColumnInfo(name = "nombre")
    private String nombre;

    public ComunidadEntity(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public ComunidadEntity() {
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

    @Override
    public String toString() { return "" + nombre; }
}
