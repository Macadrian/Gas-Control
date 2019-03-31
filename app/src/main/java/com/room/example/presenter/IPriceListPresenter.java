package com.room.example.presenter;

import com.room.example.ListaGasolina;
import com.room.example.modelo.entidad.PuebloEntity;

import java.util.List;

public interface IPriceListPresenter
{
    List<Object> makeCall(int gas, long townCode);
}
