package com.example.bodega.backend.clases;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ticket {
    private List<pair<Producto, Integer>> productos;
    private persona persona;
    private Fecha fecha;
    private double importe;
    private int id;
    private int num_productos;
    //proveedor

    public ticket(Fecha fecha) {
        productos = new ArrayList<>(); // Use an appropriate list implementation
        this.fecha = fecha;
        this.importe = 0;
        this.num_productos=0;
    }

    public void addProducto(Producto producto, int cantidad, stock s) {

        s.aumentarStockProducto(cantidad, producto.getId());
        this.productos.add(new pair<>(producto, cantidad));
        actualizarImporte(producto.getPrecio(), cantidad);
        actualizarNumProductos(cantidad);
    }

    public boolean disminuirStockProducto(Producto producto, int cantidad, stock s) {
        if (s.disminuirStockProducto(cantidad, producto)) {
            this.productos.add(new pair<>(producto, cantidad));
            actualizarImporte(producto.getPrecio(), cantidad);
            actualizarNumProductos(cantidad);
            return true;
        }
        return false;
    }

    public persona getOrigen() {
        return persona;
    }

    public void setPersona(persona persona) {
        this.persona = persona;
    }

    public void mostrar() {
        Log.d("Ticket", "---- Ticket " + id + "----");
        Log.d("Ticket", "Fecha: " + fecha);
        Log.d("Ticket", "Persona: " + persona);
        Log.d("Ticket", "Productos:");
        for (pair<Producto, Integer> par : productos) {
            Log.d("Ticket", "   - " + par.getFirst() + " | Cantidad: " + par.getSecond());
        }
        Log.d("Ticket", "---- Fin del Ticket ----");
    }

    public void setId(int id) {
        this.id = id;
    }

    public void actualizarImporte(double p, int cant) {
        if (p <= 0) {
            return;
        }

        importe += p * cant;
    }
    public void actualizarNumProductos(int cant)
    {
        num_productos+=cant;
    }

    public List<pair<Producto, Integer>> getProductos() {
        return productos;
    }

    public com.example.bodega.backend.clases.persona getPersona() {
        return persona;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public double getImporte() {
        return importe;
    }

    public int getId() {
        return id;
    }

    public int getNum_productos() {
        return num_productos;
    }
}
