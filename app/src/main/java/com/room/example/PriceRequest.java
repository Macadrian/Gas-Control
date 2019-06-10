package com.room.example;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.room.example.modelo.entidad.PuebloEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PriceRequest {
    RequestQueue queue;
    final String url = "https://sedeaplicaciones.minetur.gob.es/ServiciosRESTCarburantes/PreciosCarburantes/EstacionesTerrestres/FiltroMunicipioProducto/";

    public PriceRequest(Context context) {
        queue = Volley.newRequestQueue(context);
    }

    private static final Locale spanish = new Locale("es", "ES");
    private static final NumberFormat doubleFormat = NumberFormat.getInstance(spanish);


    public void getPrices(long pueblo, int gasType, Response.Listener listener, Response.ErrorListener errorListener) {
        String finalUrl = url + pueblo + "/" + gasType;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, finalUrl, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        listener.onResponse(parseJSON(response));
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                        errorListener.onErrorResponse(error);
                    }
                });

        queue.add(jsonObjectRequest);
    }

    private List<GasStation> parseJSON(JSONObject jsonObject) {
        List<GasStation> lista = new ArrayList<>();
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonAux;

        try {
            jsonArray = jsonObject.getJSONArray("ListaEESSPrecio");

            for (int i = 0; i < jsonArray.length(); i++) {
                jsonAux = jsonArray.getJSONObject(i);
                GasStation gasStation = new GasStation(
                        parseDouble(jsonAux.getString("PrecioProducto")),
                        jsonAux.getString("Dirección"),
                        jsonAux.getString("Rótulo"),
                        parseDouble(jsonAux.getString("Longitud (WGS84)")),
                        parseDouble(jsonAux.getString("Latitud")));
                lista.add(gasStation);
            }

        } catch (JSONException ex) {
            Log.e("Parse Response", ex.getMessage());
        }
        return lista;
    }

    private static double parseDouble(String s) {
        try {
            return doubleFormat.parse(s).doubleValue();
        } catch (ParseException e) {
            return 0;
        }
    }
}