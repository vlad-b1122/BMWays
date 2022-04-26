package com.example.bmways.modelos;

public class Carroceria {
    private java.lang.String ID_carroceria;
    private java.lang.String nombreCarroceria;
    private java.lang.String FK_Serie;

    public Carroceria(java.lang.String ID_carroceria, java.lang.String nombreSerie, java.lang.String FK_Serie) {
        this.ID_carroceria = ID_carroceria;
        this.nombreCarroceria = nombreSerie;
        this.FK_Serie = FK_Serie;
    }

    public java.lang.String getID_carroceria() {
        return ID_carroceria;
    }

    public java.lang.String getNombreSerie() {
        return nombreCarroceria;
    }

    public java.lang.String getFK_Serie() {
        return FK_Serie;
    }

    public void setID_carroceria(java.lang.String ID_carroceria) {
        this.ID_carroceria = ID_carroceria;
    }

    public void setNombreSerie(java.lang.String nombreSerie) {
        this.nombreCarroceria = nombreSerie;
    }

    public void setFK_Serie(java.lang.String FK_Serie) {
        this.FK_Serie = FK_Serie;
    }

    public java.lang.String getNombreCarroceria() {
        return nombreCarroceria;
    }

   /* @Override
    public String toString() {
        return nombreCarroceria;
    }*/

    @Override
    public java.lang.String toString() {
        return nombreCarroceria;
    }
}
