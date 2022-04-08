package com.example.bmways.modelos;

public class Serie {
    private int idSerie;
    private String nombreSerie;
    public Serie(int idSerie, String nombreSerie) {
        this.idSerie = idSerie;
        this.nombreSerie = nombreSerie;
    }

    public int getIdSerie() {
        return idSerie;
    }

    public String getNombreSerie() {
        return nombreSerie;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "idSerie=" + idSerie +
                ", nombreSerie='" + nombreSerie + '\'' +
                '}';
    }
}
