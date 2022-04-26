package com.example.bmways;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final int SHOW_SUBACTIVITY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void elegirCoche(View v){
        startActivity(new Intent(MainActivity.this, SelectorActivity.class));
    }

    /*public void pruebaApi(View view) {
        ApiInterface apiInterface = ServiceGenerator.createService(ApiInterface.class);

        Call<List<Serie>> call = apiInterface.getSeries();
        call.enqueue(new Callback<List<Serie>>() {
            @Override
            public void onResponse(Call<List<Serie>> call, Response<List<Serie>> response) {
                if (response.isSuccessful()) {
                    for (Serie usu : response.body()) {
                        System.out.println("serie: "+usu.getNombreSerie());
                    }
                }

            }

            @Override
            public void onFailure(Call<List<Serie>> call, Throwable t) {
                //ha fallado mostrar aviso de que es posible de que no tenga intertet
                Log.e("tag", t.getMessage());

            }
        });
    }*/
}