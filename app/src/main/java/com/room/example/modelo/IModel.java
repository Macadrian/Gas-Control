package com.room.example.modelo;

import com.room.example.Fuel;
import com.room.example.modelo.entidad.ComunidadEntity;
import com.room.example.modelo.entidad.ProvinciaEntity;

import java.util.List;

public interface IModel
{
    public List<ComunidadEntity> obtenerListaComunidades();
    public List<ProvinciaEntity> obtenerListaProvincias();
    public List<Fuel> obtenerListaFuels();
}
