package com.room.example.view;

import com.room.example.GasStation;

import java.util.List;

public interface IPriceListActivity
{
    void updateListGasolineras(List<GasStation> gasStationList);
    void mostrarProgreso(boolean active);
}
