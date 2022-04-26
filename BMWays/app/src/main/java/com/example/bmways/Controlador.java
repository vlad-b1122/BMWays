package com.example.bmways;

import android.app.Application;
import android.util.Log;

import com.example.bmways.api.ApiInterface;
import com.example.bmways.api.ServiceGenerator;
import com.example.bmways.modelos.Carroceria;
import com.example.bmways.modelos.Combustible;
import com.example.bmways.modelos.String;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Controlador extends Application {

    public ArrayList<String> series;
    public ArrayList<Carroceria> carrocerias;
    public ArrayList<Combustible> combustibles;

    private ApiInterface apiInterface;

    @Override
    public void onCreate() {
        super.onCreate();
        this.apiInterface = ServiceGenerator.createService(ApiInterface.class);
    }

    interface controladorDelegate{
        //void seriesObtenidas(List<String> series);
        void seriesObtenidas(List<String> series);
        void carroceriasObtenidas(List<Carroceria> carrocerias);
        void combustiblesObtenidos(List<Combustible> combustibles);
    }
    public void obtenerSeries(final controladorDelegate delegate){
        //opcionesSerie = new  ArrayList<String>();
        series = new  ArrayList<String>();
        Call<List<String>> call = this.apiInterface.getSeries();
        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                if (response.isSuccessful()) {
                    for (String serie : response.body()) {
                        //opcionesSerie.add(serie.getNombreSerie());
                        //System.out.println("TEST ----------------------------------------------> Valor serie  " + serie.getIdSerie());
                        series.add(serie);
                    }
                    delegate.seriesObtenidas(series);
                    //delegate.seriesObtenidas(opcionesSerie);
                }
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                //ha fallado mostrar aviso de que es posible de que no tenga intertet
                Log.e("tag", t.getMessage());

            }
        });
    }

    public void obtenerCarroceriasPorSerie(final controladorDelegate delegate, java.lang.String idSerie) {
        carrocerias = new  ArrayList<Carroceria>();

        Call<List<Carroceria>> call = this.apiInterface.getCarroceriasPorSerie(java.lang.String.valueOf(idSerie));
        call.enqueue(new Callback<List<Carroceria>>() {
            @Override
            public void onResponse(Call<List<Carroceria>> call, Response<List<Carroceria>> response) {
                if (response.isSuccessful()) {
                    for (Carroceria carroceria : response.body()) {
                        carrocerias.add(carroceria);
                    }
                    delegate.carroceriasObtenidas(carrocerias);
                }

            }
            @Override
            public void onFailure(Call<List<Carroceria>> call, Throwable t) {

                //ha fallado mostrar aviso de que es posible de que no tenga intertet
                Log.e("tag", t.getMessage());

            }
        });
    }

    public void obtenerCombustiblesPorCarroceria(final controladorDelegate delegate, java.lang.String idCarroceria) {
        combustibles = new  ArrayList<Combustible>();
        Call<List<Combustible>> call = this.apiInterface.getCombustiblesPorCarroceria(java.lang.String.valueOf(idCarroceria));
        call.enqueue(new Callback<List<Combustible>>() {
            @Override
            public void onResponse(Call<List<Combustible>> call, Response<List<Combustible>> response) {
                if (response.isSuccessful()) {
                    for (Combustible combustible : response.body()) {
                        combustibles.add(combustible);
                    }
                    delegate.combustiblesObtenidos(combustibles);
                }

            }
            @Override
            public void onFailure(Call<List<Combustible>> call, Throwable t) {

                //ha fallado mostrar aviso de que es posible de que no tenga intertet
                Log.e("tag", t.getMessage());

            }
        });
    }

}


