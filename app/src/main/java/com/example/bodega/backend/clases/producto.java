package com.example.bodega.backend.clases;

public class producto {

    int id;
    String nombre;
    int cantidad;
    double precio;

    String color;

    public  producto(int id, int cantidad, double precio, String nombre) {
        this.id=id;
        this.cantidad=cantidad;
        this.nombre = nombre;
        this.precio = precio;
        this.color ="#775447";
    }
    public void mostrarDetalles() {
        System.out.println("ID: " + id);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: $" + precio);
    }

    //getters
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

    public String getColor() {
        return color;
    }
}
