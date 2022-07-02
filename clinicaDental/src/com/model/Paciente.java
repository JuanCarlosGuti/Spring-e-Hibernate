package com.model;

import java.util.Date;

public class Paciente {
    private int id;
    private String nombre;
    private int DNI;
    private Date fechaIngreso;
    private Domicilio domicilio;

    public Paciente(String nombre, int DNI, Date fechaIngreso, Domicilio domicilio) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }

    public Paciente(int id, String nombre, int DNI, Date fechaIngreso, Domicilio domicilio) {
        this.id = id;
        this.nombre = nombre;
        this.DNI = DNI;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }
}
