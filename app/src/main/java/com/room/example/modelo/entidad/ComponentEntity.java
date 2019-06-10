package com.room.example.modelo.entidad;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "componente_tabla")
public class ComponentEntity
{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "codigo")
    @NonNull
    private Integer codigo;

    @ColumnInfo(name = "nombre")
    private String nombre;


    public ComponentEntity( String nombre)
    {
        this.nombre = nombre;
    }

    public ComponentEntity() {}

    public Integer getCodigo() {
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
