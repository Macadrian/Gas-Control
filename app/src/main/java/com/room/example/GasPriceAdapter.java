package com.room.example;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Custom Adapter en progreso...
 */
public class GasPriceAdapter extends ArrayAdapter<GasStation>
{
    List<GasStation> listaGasolineras = new ArrayList<GasStation>();
    int id_vista;
    Context contexto;


    public GasPriceAdapter(@NonNull Context context, int resource, @NonNull List<GasStation> objects) {
        super(context, resource, objects);


        listaGasolineras = objects;
        id_vista = resource;
        contexto = context;
    }

    @Nullable
    @Override
    public GasStation getItem(int position) {
        return listaGasolineras.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        LayoutInflater layoutInflater = LayoutInflater.from(contexto); // contexto.getLayoutInflater();
        View itemVista = layoutInflater.inflate(id_vista,null,true);

        TextView precio = itemVista.findViewById(R.id.id_direccion);
        precio.setText(getItem(position).getPrice().toString());

        TextView direccion = itemVista.findViewById(R.id.id_addressTag);
        direccion.setText(getItem(position).getAddress());

        return  itemVista;
    }
}
