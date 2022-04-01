package com.example.bmways;

import android.app.Application;
import android.util.Log;
import android.view.View;

import com.example.bmways.api.ApiInterface;
import com.example.bmways.api.ServiceGenerator;
import com.example.bmways.modelos.Carroceria;
import com.example.bmways.modelos.Serie;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Controlador extends Application {
    public ArrayList<String> opcionesSerie;
    public ArrayList<String> opcionesCarrocerias;
    private ApiInterface apiInterface;

    @Override
    public void onCreate() {
        super.onCreate();
        this.apiInterface = ServiceGenerator.createService(ApiInterface.class);
    }

    public void obtenerSeries() {
        opcionesSerie = new  ArrayList<String>();
        Call<List<Serie>> call = this.apiInterface.getSeries();
        call.enqueue(new Callback<List<Serie>>() {
            @Override
            public void onResponse(Call<List<Serie>> call, Response<List<Serie>> response) {
                if (response.isSuccessful()) {
                    for (Serie serie : response.body()) {
                        opcionesSerie.add(serie.getNombreSerie());
                        //System.out.println("\tSERIE DEBUG: "+serie.getNombreSerie()+"\n");
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

    public void obtenerCarroceriasPorSerie() {
        opcionesCarrocerias = new  ArrayList<String>();
        Call<List<Carroceria>> call = this.apiInterface.getCarroceriasPorSerie("3");
        call.enqueue(new Callback<List<Carroceria>>() {
            @Override
            public void onResponse(Call<List<Carroceria>> call, Response<List<Carroceria>> response) {
                if (response.isSuccessful()) {
                    for (Carroceria carroceria : response.body()) {
                        opcionesCarrocerias.add(carroceria.getNombreSerie());
                    }
                }

            }
            @Override
            public void onFailure(Call<List<Carroceria>> call, Throwable t) {

                //ha fallado mostrar aviso de que es posible de que no tenga intertet
                Log.e("tag", t.getMessage());

            }
        });
    }

}


