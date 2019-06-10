package com.room.example;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;

public class ListaGasolina
{
    public class GasType
    {
        private String abreviation;
        private int codigo;
        private String etiqueta;

        public GasType(int cd, String etq, String abr)
        {
            codigo = cd;
            etiqueta = etq;
            abreviation = abr;
        }

        public String getAbreviation() { return abreviation; }

        public int getCodigo() { return codigo; }

        public String getEtiqueta() { return etiqueta; }

        @NonNull
        @Override
        public String toString() {
            return etiqueta;
        }
    }

    private List<GasType> gasTypes;

    public ListaGasolina()
    {
        gasTypes = new ArrayList<>();
        gasTypes.add(new GasType(3, "Gasoline 98", "G98"));
        gasTypes.add(new GasType(4, "Regular diesel A", "GOA"));
        gasTypes.add(new GasType(5, "New diesel A", "NGO"));
        gasTypes.add(new GasType(15, "Gasoline 95", "G95"));
        gasTypes.add(new GasType(17, "Liquefied petroleum gases", "GLP"));
    }

    public List<GasType> getGasTypes() {
        return gasTypes;
    }
}
