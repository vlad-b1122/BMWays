package com.example.bmways.modelos;

public class String {
    private java.lang.String ID_Serie;
    private java.lang.String nombreSerie;
    public String(java.lang.String idSerie, java.lang.String nombreSerie) {
        this.ID_Serie = idSerie;
        this.nombreSerie = nombreSerie;
    }

    public java.lang.String getIdSerie() {
        return ID_Serie;
    }

    public java.lang.String getNombreSerie() {
        return nombreSerie;
    }
/*
    @Override
    public String toString() {
        return nombreSerie;
    }*/

    @Override
    public java.lang.String toString() {
        return nombreSerie;
    }
}
