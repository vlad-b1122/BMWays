package com.example.bmways;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.bmways.modelos.Serie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.DoubleStream;

public class SelectorActivity extends AppCompatActivity implements Controlador.controladorDelegate {

    private Controlador controlador;

    private Spinner desplegableSerie;
    private ArrayList<String> opcionesSerie;
    private ArrayAdapter<Serie> adaptadorListaSerie;

    private Spinner desplegableCarroceria;
    private ArrayList<String> opcionesCarroceria;
    private ArrayAdapter adaptadorListaCarroceria;

    private Spinner desplegableCombustible;
    private ArrayList<String> opcionesCombustible;
    private ArrayAdapter adaptadorListaCombustible;


    private Spinner desplegableMotor;
    private ArrayList<String> opcionesMotor;
    private ArrayAdapter adaptadorListaMotor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector);
        this.controlador = (Controlador) getApplicationContext();
        this.inicializarDesplegableSerie();
       // this.inicializarDesplegableCarroceria();
        this.inicializarDesplegableCombustible();
        this.inicializarDesplegableMotor();

    }

    private void inicializarDesplegableSerie()
    {
        desplegableSerie = findViewById(R.id.despSerie);
        this.controlador.obtenerSeries(this);
    }

  /*  private void inicializarDesplegableCarroceria()
    {
        desplegableCarroceria = findViewById(R.id.despCarroceria);
        this.controlador.obtenerCarroceriasPorSerie(this);
    }*/

    private void inicializarDesplegableCombustible()
    {
        opcionesCombustible = new ArrayList<String>();
        this.crearOpcionesCombustible();
        adaptadorListaCombustible = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, opcionesCombustible);
        desplegableCombustible = (Spinner) findViewById(R.id.despCombustible);
        desplegableCombustible.setAdapter(adaptadorListaCombustible);
    }


    private void crearOpcionesCombustible()
    {
        opcionesCombustible.add("Gasolina");
        opcionesCombustible.add("Diesel");
        opcionesCombustible.add("Hibrido");
    }

    private void inicializarDesplegableMotor()
    {
        opcionesMotor = new ArrayList<String>();
        this.crearOpcionesMotor();
        adaptadorListaMotor = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, opcionesMotor);
        desplegableMotor = (Spinner) findViewById(R.id.despMotor);
        desplegableMotor.setAdapter(adaptadorListaMotor);
    }

    private void crearOpcionesMotor()
    {
        opcionesMotor.add("2.0");
        opcionesMotor.add("2.2");
        opcionesMotor.add("2.5");
        opcionesMotor.add("3.0");
        opcionesMotor.add("4.0");
    }

    public void pressSeleccionar(View view) {
        //get serie
        String serieSeleccionada = (String) desplegableSerie.getSelectedItem();
        Toast.makeText(this, "serie seleccionada: "+serieSeleccionada, Toast.LENGTH_SHORT).show();
    }
/*
    @Override
    public void seriesObtenidas(List<String> series) {
        adaptadorListaSerie = new ArrayAdapter<Serie>(SelectorActivity.this, R.layout.spinner_list, controlador.series);
        adaptadorListaSerie.setDropDownViewResource(R.layout.spinner_dropdown);

        desplegableSerie.setAdapter(adaptadorListaSerie);
        desplegableSerie.setPrompt("Seleccione una serie");

        desplegableSerie.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(SelectorActivity.this,"i vale: "+i, Toast.LENGTH_SHORT).show();
                desplegableSerie.setSelection(i);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }*/

    @Override
    public void objetosSerieObtenidos(List<Serie> series) {
        adaptadorListaSerie = new ArrayAdapter<Serie>(SelectorActivity.this, R.layout.spinner_list, controlador.series);
        adaptadorListaSerie.setDropDownViewResource(R.layout.spinner_dropdown);

        desplegableSerie.setAdapter(adaptadorListaSerie);
        desplegableSerie.setPrompt("Seleccione una serie");

        desplegableSerie.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(SelectorActivity.this,"i vale: "+i, Toast.LENGTH_SHORT).show();
                desplegableSerie.setSelection(i);
                Serie serieAux = controlador.series.get(i);
                desplegableCarroceria = findViewById(R.id.despCarroceria);
                controlador.obtenerCarroceriasPorSerie(SelectorActivity.this, serieAux.getIdSerie());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void carroceriasObtenidas(List<String> series) {
        adaptadorListaCarroceria = new ArrayAdapter<String>(SelectorActivity.this, R.layout.spinner_list, controlador.opcionesCarrocerias);
        desplegableCarroceria.setAdapter(adaptadorListaCarroceria);
        desplegableCarroceria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               // desplegableCarroceria.setSelection(2);
                Toast.makeText(SelectorActivity.this,"i vale: "+i, Toast.LENGTH_SHORT).show();
               // desplegableCarroceria.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}