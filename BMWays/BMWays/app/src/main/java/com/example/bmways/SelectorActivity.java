package com.example.bmways;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class SelectorActivity extends AppCompatActivity {
    private Spinner desplegableSerie;
    //private ArrayList<String> opcionesSerie;
    private ArrayAdapter adaptadorListaSerie;

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

        this.inicializarDesplegableSerie();
        this.inicializarDesplegableCarroceria();
        this.inicializarDesplegableCombustible();
        this.inicializarDesplegableMotor();

    }

    private void inicializarDesplegableSerie()
    {
        Controlador controlador = (Controlador) getApplicationContext();
        controlador.obtenerSeries();
        adaptadorListaSerie = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, controlador.opcionesSerie);
        desplegableSerie = (Spinner) findViewById(R.id.despSerie);
        desplegableSerie.setAdapter(adaptadorListaSerie);
        desplegableSerie.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                desplegableSerie.setSelection(2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    /*private void crearOpcionesSerie()
    {
        opcionesSerie.add("Serie 1");

    }*/

    private void inicializarDesplegableCarroceria()
    {
        opcionesCarroceria = new ArrayList<String>();
        this.crearOpcionesCarroceria();
        adaptadorListaCarroceria = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, opcionesCarroceria);
        desplegableCarroceria = (Spinner) findViewById(R.id.despCarroceria);
        desplegableCarroceria.setAdapter(adaptadorListaCarroceria);
    }


    private void crearOpcionesCarroceria()
    {
        opcionesCarroceria.add("E60");
        opcionesCarroceria.add("E70");
        opcionesCarroceria.add("E90");
        opcionesCarroceria.add("E92");
        opcionesCarroceria.add("F10");
    }

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
        opcionesCombustible.add("LGTBI");
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
}