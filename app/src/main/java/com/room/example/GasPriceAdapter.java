package com.room.example;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Custom Adapter en progreso...
 */
public class GasPriceAdapter extends ArrayAdapter<GasStation> {


    public GasPriceAdapter(@NonNull Context context, int resource, @NonNull List<GasStation> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
}
