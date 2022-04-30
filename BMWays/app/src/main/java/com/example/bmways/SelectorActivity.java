package com.example.bmways;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.bmways.modelos.Carroceria;
import com.example.bmways.modelos.Combustible;
import com.example.bmways.modelos.Motor;
import com.example.bmways.modelos.String;
import com.example.bmways.modelos.Tutorial;

import java.util.ArrayList;
import java.util.List;

public class SelectorActivity extends AppCompatActivity implements Controlador.controladorDelegate {

    private Controlador controlador;

    private Spinner desplegableSerie;
    private ArrayList<java.lang.String> opcionesSerie;
    private ArrayAdapter<String> adaptadorListaSerie;

    private Spinner desplegableCarroceria;
    private ArrayList<java.lang.String> opcionesCarroceria;
    private ArrayAdapter adaptadorListaCarroceria;

    private Spinner desplegableCombustible;
    private ArrayList<java.lang.String> opcionesCombustible;
    private ArrayAdapter adaptadorListaCombustible;


    private Spinner desplegableMotor;
    private ArrayList<java.lang.String> opcionesMotor;
    private ArrayAdapter adaptadorListaMotor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector);
        this.controlador = (Controlador) getApplicationContext();
        this.inicializarDesplegableSerie();

    }

    private void inicializarDesplegableSerie()
    {
        desplegableSerie = findViewById(R.id.despSerie);
        this.controlador.obtenerSeries(this);
    }

    public void pressSeleccionar(View view) {
        //java.lang.String serieSeleccionada = (java.lang.String) desplegableSerie.getSelectedItem();
        //Toast.makeText(this, "serie seleccionada: "+serieSeleccionada, Toast.LENGTH_SHORT).show();
        //this.controlador.obtenerTutorialesPorMotor();
        startActivity(new Intent(SelectorActivity.this, VideosActivity.class));
    }

    @Override
    public void seriesObtenidas(List<String> series) {
        adaptadorListaSerie = new ArrayAdapter<String>(SelectorActivity.this, R.layout.spinner_list, controlador.series);
        adaptadorListaSerie.setDropDownViewResource(R.layout.spinner_dropdown);

        desplegableSerie.setAdapter(adaptadorListaSerie);
        desplegableSerie.setPrompt("Seleccione una serie");

        desplegableSerie.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               desplegableSerie.setSelection(i);
                String serieAux = controlador.series.get(i);
                desplegableCarroceria = findViewById(R.id.despCarroceria);
                controlador.obtenerCarroceriasPorSerie(SelectorActivity.this, serieAux.getIdSerie());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void carroceriasObtenidas(List<Carroceria> carrocerias) {
        adaptadorListaCarroceria = new ArrayAdapter<Carroceria>(SelectorActivity.this, R.layout.spinner_list, controlador.carrocerias);
        desplegableCarroceria.setAdapter(adaptadorListaCarroceria);
        desplegableCarroceria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                desplegableCarroceria.setSelection(i);
                Carroceria carroceriaAux = controlador.carrocerias.get(i);
                desplegableCombustible = findViewById(R.id.despCombustible);
                controlador.obtenerCombustiblesPorCarroceria(SelectorActivity.this, carroceriaAux.getID_carroceria());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    @Override
    public void combustiblesObtenidos(List<Combustible> combustibles) {
        adaptadorListaCombustible = new ArrayAdapter<Combustible>(SelectorActivity.this, R.layout.spinner_list, controlador.combustibles);
        desplegableCombustible.setAdapter(adaptadorListaCombustible);
        desplegableCombustible.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(SelectorActivity.this,"i vale: "+i, Toast.LENGTH_SHORT).show();
                desplegableCombustible.setSelection(i);
                Combustible combustibleAux = controlador.combustibles.get(i);
                desplegableMotor = findViewById(R.id.despMotor);
                controlador.obtenerMotoresPorCombustible(SelectorActivity.this, combustibleAux.getID_combustible());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    @Override
    public void motoresObtenidos(List<Motor> motores) {
        adaptadorListaMotor = new ArrayAdapter<Motor>(SelectorActivity.this, R.layout.spinner_list, controlador.motores);
        desplegableMotor.setAdapter(adaptadorListaMotor);
        desplegableMotor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(SelectorActivity.this,"i vale: "+i, Toast.LENGTH_SHORT).show();
                desplegableMotor.setSelection(i);
                Motor motorAux = controlador.motores.get(i);
                desplegableMotor = findViewById(R.id.despMotor);
                controlador.setIdMotor(motorAux.getID_motor());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


}