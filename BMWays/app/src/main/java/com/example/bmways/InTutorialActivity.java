package com.example.bmways;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class InTutorialActivity extends AppCompatActivity {

    public TextView inTutorialTitle;
    public TextView inTutorialDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_tutorial);

        inTutorialTitle = findViewById(R.id.inTutorialTitle);
        inTutorialDescription = findViewById(R.id.inTutorialDescription);

        Bundle bundle = getIntent().getExtras();
        String titulo = bundle.getString("titulo");
        String descripcion = bundle.getString("descripcion");
        inTutorialTitle.setText(titulo);
        inTutorialDescription.setText(descripcion);
    }
}