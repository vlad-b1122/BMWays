package com.example.bmways.modelos;

public class Motor {
    private java.lang.String ID_motor;
    private java.lang.String nombreMotor;
    private java.lang.String FK_Combustible;

    public Motor(java.lang.String ID_motor, java.lang.String nombreMotor, java.lang.String carroceria) {
        this.ID_motor = ID_motor;
        this.nombreMotor = nombreMotor;
        this.FK_Combustible = carroceria;
    }

    public java.lang.String getID_motor() {
        return ID_motor;
    }

    public java.lang.String getNombreMotor() {
        return nombreMotor;
    }

    public java.lang.String getFK_Combustible() {
        return FK_Combustible;
    }

    public void setID_motor(java.lang.String ID_motor) {
        this.ID_motor = ID_motor;
    }

    public void setNombreMotor(java.lang.String nombreMotor) {
        this.nombreMotor = nombreMotor;
    }

    public void setFK_Combustible(java.lang.String FK_Combustible) {
        this.FK_Combustible = FK_Combustible;
    }

    @Override
    public java.lang.String toString() {
        return nombreMotor;

    }
}
