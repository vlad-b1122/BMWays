package com.example.bmways.modelos;

public class Carroceria {
    private int idCarroceria;
    private String nombreSerie;
    private Serie serie;

    public Carroceria(int idCarroceria, String nombreSerie, Serie serie) {
        this.idCarroceria = idCarroceria;
        this.nombreSerie = nombreSerie;
        this.serie = serie;
    }

    public int getIdCarroceria() {
        return idCarroceria;
    }

    public String getNombreSerie() {
        return nombreSerie;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setIdCarroceria(int idCarroceria) {
        this.idCarroceria = idCarroceria;
    }

    public void setNombreSerie(String nombreSerie) {
        this.nombreSerie = nombreSerie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }
}
