package com.example.bodega.backend.clases;

import java.util.ArrayList;
import java.util.List;

public class stock {
        // Private list to hold product objects
        private List<Producto> Productos;
        private int Cantidad;

        // Constructor to initialize the product list
        public stock() {
            Productos = new ArrayList<>(); // Use an appropriate list implementation
            Cantidad=0;
        }

    public List<Producto> getProductos() {
        return Productos;
    }

    public void setProductos(List<Producto> Productos) {
        this.Productos = Productos;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }

    // Method to add products to the stock
    public void addProducto(Producto producto) {
            Productos.add(producto);
            Cantidad++;}

        // Method to remove products from the stock
    public void removeProducto(Producto producto) {
            Productos.remove(producto);
            Cantidad--;
        }

        // Method to get all products in the stock

        // Method to get a specific product by ID
        public Producto getProductoById(int id) {
            for (Producto producto : Productos) {
                if (producto.getId() == id) {

                    return producto;
                }
            }
            return null; // Return null if not found
        }
        public boolean emptyStock()
        {
            return Cantidad == 0;
        }

    public boolean idDisponible(int id) {
        for (Producto producto : Productos) {
            if (producto.getId() == id) {
                return false;
            }

        }
        return true;
    }

    public int obtenerIndiceporId(int id)
    {
        for (int i=0; i<Cantidad; i++)
        {
            if (Productos.get(i).getId()==id)
            {
                return i;
            }
        }
        return -1;
    }
    public boolean disminuirStockProducto(int cant, Producto p){
        if (p.getCantidad() >= cant) {
            p.setCantidad(p.getCantidad() - cant);
            return true;
        } else {
            return false;
        }
    }

    public void aumentarStockProducto(int cant, Producto p){
        p.setCantidad(p.getCantidad()+cant);
        }


}

