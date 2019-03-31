package com.room.example.view;

import android.content.res.Resources;

import com.room.example.GasStation;

import java.util.List;

public interface IPriceListActivity
{
    void updateListGasolineras(List<GasStation> gasStationList);
    void mostrarProgreso(boolean active);
    void mostrarError(String resources);
    void mostrarSinResultados(boolean active);
}
