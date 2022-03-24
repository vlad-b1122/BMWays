package com.example.bmways;

import android.app.Application;
import android.util.Log;
import android.view.View;

import com.example.bmways.api.ApiInterface;
import com.example.bmways.api.ServiceGenerator;
import com.example.bmways.modelos.Serie;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Controlador extends Application {
    public ArrayList<String> opcionesSerie;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public void obtenerSeries() {
        ApiInterface apiInterface = ServiceGenerator.createService(ApiInterface.class);
        opcionesSerie = new  ArrayList<String>();
        Call<List<Serie>> call = apiInterface.getSeries();
        call.enqueue(new Callback<List<Serie>>() {
            @Override
            public void onResponse(Call<List<Serie>> call, Response<List<Serie>> response) {
                if (response.isSuccessful()) {
                    for (Serie serie : response.body()) {
                        opcionesSerie.add(serie.getNombreSerie());
                        System.out.println("\tSERIE DEBUG: "+serie.getNombreSerie()+"\n");
                    }
                }

            }

            @Override
            public void onFailure(Call<List<Serie>> call, Throwable t) {
                //ha fallado mostrar aviso de que es posible de que no tenga intertet
                Log.e("tag", t.getMessage());

            }
        });
    }

}


