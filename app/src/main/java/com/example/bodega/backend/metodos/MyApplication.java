package com.example.bodega.backend.metodos;

import android.app.Application;
import com.example.bodega.backend.clases.producto;
import com.example.bodega.backend.clases.stock;


public class MyApplication extends Application {
    @Override
    public void onCreate()
    {
        super.onCreate();
        stock inventario = new stock();
        inventario.addProducto(new producto(1,17, 19.90, "Coca lata 355ml"));
        inventario.addProducto(new producto(2,12, 9.90, "Fanta 355ml"));
        inventario.addProducto(new producto(3,9, 34.90, "Coca 2.5L"));
        inventario.addProducto(new producto(4,5, 30, "Pan Blanco bimbo"));
        inventario.addProducto(new producto(5,0, 80, "Cigarros Lucky Strikes 20pz"));
    }
}
