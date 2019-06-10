package com.room.example.presenter;

import android.content.Context;
import android.content.res.Resources;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.room.example.GasStation;
import com.room.example.R;
import com.room.example.modelo.IModel;
import com.room.example.modelo.Model;
import com.room.example.view.IPriceListActivity;
import com.room.example.view.PriceListActivity;

import java.util.ArrayList;
import java.util.List;

public class PriceListPresenter implements IPriceListPresenter
{
    IModel iModel;
    IPriceListActivity iPriceListActivity;
    Context context;
    Resources resources;
    public PriceListPresenter(PriceListActivity activity)
    {
        this.context = activity.getApplicationContext();
        iModel = Model.getInstance(context);
        iPriceListActivity = activity;
        resources = context.getResources();
    }



    @Override
    public List<Object> makeCall(int gas, long town)
    {

        iModel.getTownStationsPrices(
                town,
                gas,
                new Response.Listener<List<GasStation>>() {
                    @Override
                    public void onResponse(List<GasStation> response)
                    {
                        iPriceListActivity.mostrarProgreso(false);
                        iPriceListActivity.updateListGasolineras(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        iPriceListActivity.mostrarError(resources.getString(R.string.error_de_conexion));
                        iPriceListActivity.mostrarProgreso(false);
                        iPriceListActivity.mostrarSinResultados(true);
                    }
                },
                context);

        return new ArrayList();
    }
}
