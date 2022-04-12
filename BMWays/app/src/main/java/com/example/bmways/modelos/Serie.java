package com.example.bmways.modelos;

public class Serie {
    private String ID_Serie;
    private String nombreSerie;
    public Serie(String idSerie, String nombreSerie) {
        this.ID_Serie = idSerie;
        this.nombreSerie = nombreSerie;
    }

    public String getIdSerie() {
        return ID_Serie;
    }

    public String getNombreSerie() {
        return nombreSerie;
    }

    @Override
    public String toString() {
        return nombreSerie;
    }
}
