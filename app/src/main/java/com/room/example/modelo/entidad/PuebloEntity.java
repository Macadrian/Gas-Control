package com.room.example.modelo.entidad;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "pueblo_tabla")
public class ProvinciaEntity {
    @PrimaryKey
    @ColumnInfo(name = "codigo")
    @NonNull
    private String codigo;
    private String codigoProvincia;

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

    public String getCodigoProvincia() {
        return codigoProvincia;
    }

    public void setCodigoProvincia(String nombre) {
        this.codigoProvincia = codigoProvincia;
    }
}
