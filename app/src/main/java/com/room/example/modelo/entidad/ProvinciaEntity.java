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
    private String codigo;
    private String codigoComunidad;

    @ColumnInfo(name = "nombre")
    private String nombre;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoComunidad() { return codigoComunidad; }

    public void setCodigoComunidad(String nombre) {
        this.codigoComunidad = codigoComunidad;
    }
}
