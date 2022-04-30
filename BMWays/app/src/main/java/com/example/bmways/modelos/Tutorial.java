package com.example.bmways.modelos;

public class Tutorial {
    private int ID_tutorial;
    private java.lang.String nombreTutorial;
    private java.lang.String descripcion;
    private java.lang.String imagen;
    private java.lang.String video;
    private java.lang.String FK_motor;
    private Motor motor;

    public int getID_tutorial() {
        return ID_tutorial;
    }

    public java.lang.String getNombreTutorial() {
        return nombreTutorial;
    }

    public java.lang.String getDescripcion() {
        return descripcion;
    }

    public java.lang.String getImagen() {
        return imagen;
    }

    public java.lang.String getVideo() {
        return video;
    }

    public java.lang.String getFK_motor() {
        return FK_motor;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setID_tutorial(int ID_tutorial) {
        this.ID_tutorial = ID_tutorial;
    }

    public void setNombreTutorial(java.lang.String nombreTutorial) {
        this.nombreTutorial = nombreTutorial;
    }

    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }

    public void setImagen(java.lang.String imagen) {
        this.imagen = imagen;
    }

    public void setVideo(java.lang.String video) {
        this.video = video;
    }

    public void setFK_motor(java.lang.String FK_motor) {
        this.FK_motor = FK_motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    @Override
    public java.lang.String toString() {
        return "Tutorial{" +
                "ID_tutorial=" + ID_tutorial +
                ", nombreTutorial='" + nombreTutorial + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", imagen='" + imagen + '\'' +
                ", video='" + video + '\'' +
                ", FK_motor='" + FK_motor + '\'' +
                ", motor=" + motor +
                '}';
    }

}
