package com.example.bmways;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.bmways.modelos.Motor;
import com.example.bmways.modelos.Tutorial;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;
import java.util.List;

public class VideosActivity extends AppCompatActivity implements Controlador.controladorDelegateTutoriales {

    RecyclerView recyclerView;

    //Aqui se fija el contenido de la lista
    ArrayList<Tutorial> tutoriales;
    ArrayList<String> s1, s2;
    ArrayList<Integer> images;
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
        images = new ArrayList<>();

        for (Tutorial tuto : tutoriales) {
            s1.add(tuto.getDescripcion());
            s2.add(tuto.getVideo());
            images.add(Integer.parseInt(tuto.getImagen()));
        }

        ListaVideosAdapter adapterLista = new ListaVideosAdapter(this, s1, s2, images);

        adapterLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titulo = s1.get(recyclerView.getChildAdapterPosition(v));
                String desc = s2.get(recyclerView.getChildAdapterPosition(v));

                Intent intent = new Intent(getApplicationContext(), InTutorialActivity.class);
                intent.putExtra("titulo", titulo);
                intent.putExtra("descripcion", desc);
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(adapterLista);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}