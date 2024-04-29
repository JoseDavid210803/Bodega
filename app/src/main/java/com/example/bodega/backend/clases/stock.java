package com.example.bodega.backend.clases;

import java.util.ArrayList;
import java.util.List;

public class stock {
        // Private list to hold product objects
        private List<producto> productos;
        private int Cantidad;

        // Constructor to initialize the product list
        public stock() {
            productos = new ArrayList<>(); // Use an appropriate list implementation
            Cantidad=0;
        }

    public List<producto> getProductos() {
        return productos;
    }

    public void setProductos(List<producto> productos) {
        this.productos = productos;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }

    // Method to add products to the stock
        public void addProducto(producto producto) {
            productos.add(producto);
            Cantidad++;
        }

        // Method to remove products from the stock
        public void removeProducto(producto producto) {
            productos.remove(producto);
            Cantidad--;
        }

        // Method to get all products in the stock
        public List<producto> getAllProductos() {
            return productos;
        }

        // Method to get a specific product by ID
        public producto getProductoById(int id) {
            for (producto producto : productos) {
                if (producto.getId() == id) {
                    return producto;
                }
            }
            return null; // Return null if not found
        }

        // Other methods as needed (e.g., search, filter, update)
    }

