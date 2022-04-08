package com.example.bmways.modelos;

public class Carroceria {
    private int idCarroceria;
    private String nombreCarroceria;
    private Serie serie;

    public Carroceria(int idCarroceria, String nombreSerie, Serie serie) {
        this.idCarroceria = idCarroceria;
        this.nombreCarroceria = nombreSerie;
        this.serie = serie;
    }

    public int getIdCarroceria() {
        return idCarroceria;
    }

    public String getNombreSerie() {
        return nombreCarroceria;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setIdCarroceria(int idCarroceria) {
        this.idCarroceria = idCarroceria;
    }

    public void setNombreSerie(String nombreSerie) {
        this.nombreCarroceria = nombreSerie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public String getNombreCarroceria() {
        return nombreCarroceria;
    }
}
