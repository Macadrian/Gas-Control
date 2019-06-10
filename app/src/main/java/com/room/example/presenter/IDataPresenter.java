package com.room.example.presenter;

import com.room.example.modelo.entidad.PuebloEntity;

import java.util.List;

public interface IDataPresenter
{

    public void obtenerListaComunidades();
    public void obtenerListaProvincias(int codigoComunidad);
    public void obtenerListaPueblos(int codigoProvincia);
    public void obtenerListaFuels();

    public void gestionarBoton();
}
