package com.example.bodega.backend.clases;

public class persona {
    private int id;
    private String nombre;
    private String numero_telefono;
    private String correo_electronico;

    public persona( String nombre, String numero_telefono, String correo_electronico) {
        this.nombre = nombre;
        this.numero_telefono = numero_telefono;
        this.correo_electronico = correo_electronico;
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

    public String getNumero_telefono() {
        return numero_telefono;
    }

    public void setNumero_telefono(String numero_telefono) {
        this.numero_telefono = numero_telefono;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }
    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Teléfono: " + numero_telefono + ", Correo electrónico: " + correo_electronico;
    }
}
