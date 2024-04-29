package com.example.bodega.backend.clases;

public class producto {

    int id;
    String nombre;
    int cantidad;
    double precio;

    public  producto(int id, int cantidad, double precio, String nombre) {
        this.id=id;
        this.cantidad=cantidad;
        this.nombre = nombre;
        this.precio = precio;
    }
    public void mostrarDetalles() {
        System.out.println("ID: " + id);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: $" + precio);
    }

    //getters
    public double getPrecio(){
        return precio;
    }
    public int getCantidad(){
        return cantidad;
    }
    public float getId(){
        return id;
    }
    public String getNombre()
    {
        return nombre;
    }


}
