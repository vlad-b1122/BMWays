package com.example.bmways;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.bmways.modelos.Motor;
import com.example.bmways.modelos.Tutorial;

import java.util.ArrayList;
import java.util.List;

public class VideosActivity extends AppCompatActivity implements Controlador.controladorDelegateTutoriales{

    RecyclerView recyclerView;

    //Aqui se fija el contenido de la lista
    ArrayList<Tutorial> tutoriales;
    ArrayList<String> s1, s2;
    int images[];
    Controlador controlador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);

        this.controlador = (Controlador) getApplicationContext();
        s1 = new ArrayList<String>();
        s2 = new ArrayList<String>();
        tutoriales = new ArrayList<Tutorial>();

        recyclerView = findViewById(R.id.recyclerView);
        this.controlador.obtenerTutorialesPorMotor(VideosActivity.this);
    }

    @Override
    public void tutorialesObtenidos(List<Tutorial> tutoriales) {
        this.tutoriales = controlador.getTutoriales();

        for (Tutorial tuto : tutoriales) {
            s1.add(tuto.getDescripcion());
            s2.add(tuto.getVideo());
        }
        images = new int[]{R.drawable.video1thumbnail,R.drawable.video1thumbnail};

        ListaVideosAdapter adapterLista = new ListaVideosAdapter(this, s1, s2, images);
        recyclerView.setAdapter(adapterLista);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}