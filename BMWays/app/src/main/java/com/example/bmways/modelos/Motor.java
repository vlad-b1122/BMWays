package com.example.bmways.modelos;

public class Motor {
    private int idMotor;
    private String nombreMotor;
    private Carroceria carroceria;

    public Motor(int idMotor, String nombreMotor, Carroceria carroceria) {
        this.idMotor = idMotor;
        this.nombreMotor = nombreMotor;
        this.carroceria = carroceria;
    }

    public int getIdMotor() {
        return idMotor;
    }

    public String getNombreMotor() {
        return nombreMotor;
    }

    public Carroceria getCarroceria() {
        return carroceria;
    }

    public void setIdMotor(int idMotor) {
        this.idMotor = idMotor;
    }

    public void setNombreMotor(String nombreMotor) {
        this.nombreMotor = nombreMotor;
    }

    public void setCarroceria(Carroceria carroceria) {
        this.carroceria = carroceria;
    }
}
