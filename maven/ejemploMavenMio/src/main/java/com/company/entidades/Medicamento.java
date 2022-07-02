package com.company.entidades;

public class Medicamento {
    private int Cod;
    private String nombre;
    private String laboratorio;
    private int cantidad;
    private double precio;
    private Long id;

    public Medicamento(int cod, String nombre, String laboratorio, int cantidad, double precio, Long id) {
        Cod = cod;
        this.nombre = nombre;
        this.laboratorio = laboratorio;
        this.cantidad = cantidad;
        this.precio = precio;
        this.id = id;
    }

    public Medicamento(String nombre, double precio, Long id) {
        this.nombre = nombre;
        this.precio = precio;
        this.id = id;
    }

    public Medicamento() {
    }

    public int getCod() {
        return Cod;
    }

    public void setCod(int cod) {
        Cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Medicamento{" +
                "Cod=" + Cod +
                ", nombre='" + nombre + '\'' +
                ", laboratorio='" + laboratorio + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                ", id=" + id +
                '}';
    }
}
