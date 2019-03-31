package com.room.example.view;

import com.room.example.ListaGasolina;
import com.room.example.modelo.entidad.ComunidadEntity;
import com.room.example.modelo.entidad.ProvinciaEntity;
import com.room.example.modelo.entidad.PuebloEntity;

import java.util.List;

public interface IDataActivity {
    void updateSpinnerCommunities(List<ComunidadEntity> lista);
    void updateSpinnerProvinces(List<ProvinciaEntity> lista);
    void updateSpinnerTowns(List<PuebloEntity> list);
    void updateSpinnerFuels(List<ListaGasolina.GasType> list);

    void setButton(boolean activado);
    String getPuebloEscrito();
}
