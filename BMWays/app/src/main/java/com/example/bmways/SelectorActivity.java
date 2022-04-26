package com.example.bmways;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.bmways.modelos.Carroceria;
import com.example.bmways.modelos.Combustible;
import com.example.bmways.modelos.String;

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
        this.inicializarDesplegableMotor();

    }

    private void inicializarDesplegableSerie()
    {
        desplegableSerie = findViewById(R.id.despSerie);
        this.controlador.obtenerSeries(this);
    }




    private void inicializarDesplegableMotor()
    {
        opcionesMotor = new ArrayList<java.lang.String>();
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
        java.lang.String serieSeleccionada = (java.lang.String) desplegableSerie.getSelectedItem();
        Toast.makeText(this, "serie seleccionada: "+serieSeleccionada, Toast.LENGTH_SHORT).show();
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
                //Toast.makeText(SelectorActivity.this,"i vale: "+i, Toast.LENGTH_SHORT).show();
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
                //Toast.makeText(SelectorActivity.this,"i vale: "+i, Toast.LENGTH_SHORT).show();
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
                desplegableCombustible = findViewById(R.id.despCombustible);
                controlador.obtenerCombustiblesPorCarroceria(SelectorActivity.this, combustibleAux.getID_combustible());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


}