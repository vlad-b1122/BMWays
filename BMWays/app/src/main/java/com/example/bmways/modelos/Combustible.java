package com.example.bmways.modelos;

public class Combustible {
    private java.lang.String ID_combustible;
    private java.lang.String nombreCombustible;
    private java.lang.String FK_Carroceria;

    public Combustible(java.lang.String ID_combustible, java.lang.String nombreSerie, java.lang.String FK_Carroceria) {
        this.ID_combustible = ID_combustible;
        this.nombreCombustible = nombreSerie;
        this.FK_Carroceria = FK_Carroceria;
    }

    public java.lang.String getID_combustible() {
        return ID_combustible;
    }

    public java.lang.String getNombreSerie() {
        return nombreCombustible;
    }

    public java.lang.String getFK_Carroceria() {
        return FK_Carroceria;
    }

    public void setID_combustible(java.lang.String ID_combustible) {
        this.ID_combustible = ID_combustible;
    }

    public void setNombreSerie(java.lang.String nombreSerie) {
        this.nombreCombustible = nombreSerie;
    }

    public void setFK_Carroceria(java.lang.String FK_Carroceria) {
        this.FK_Carroceria = FK_Carroceria;
    }

    public java.lang.String getNombreCombustible() {
        return nombreCombustible;
    }

    @Override
    public java.lang.String toString() {
        return nombreCombustible;
    }
}
