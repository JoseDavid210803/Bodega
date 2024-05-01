package com.example.bodega.backend.metodos;

import android.app.Application;
import android.util.Log;

import com.example.bodega.backend.clases.Fecha;
import com.example.bodega.backend.clases.Producto;
import com.example.bodega.backend.clases.catalogoPersonas;

import com.example.bodega.backend.clases.persona;
import com.example.bodega.backend.clases.stock;
import com.example.bodega.backend.clases.listaTickets;
import com.example.bodega.backend.clases.ticket;


public class MyApplication extends Application {
    private stock inventario = new stock();
    private catalogoPersonas catalogoProveedores= new catalogoPersonas();

    private listaTickets ticketsEntrada = new listaTickets();
    private catalogoPersonas catalogoClientes= new catalogoPersonas();

    private listaTickets ticketsSalida = new listaTickets();


    @Override
    public void onCreate()
    {
        super.onCreate();
        //creacion de inventario
        for (int i = 0; i < 20; i++) {
            inventario.addProducto( new Producto(i+1, 10, 10.0+i, "Producto" + (i + 1)));
            catalogoProveedores.anadirPersona(new persona("Proveedor" + i + 1, "3312345678", "correoProveedor" + i +1 +"@hotmail.com"));
            catalogoClientes.anadirPersona(new persona("Cliente" + i + 1, "3312345678", "correoCliente" + i +1 +"@hotmail.com"));

        }
        //ticket 1
        ticket ticket_entrada1=new ticket(new Fecha(30, 4, 2024));
        ticket_entrada1.setPersona(catalogoProveedores.getPersonas().get(0));
        ticket_entrada1.addProducto(inventario.getProductos().get(0), 5, inventario);
        ticket_entrada1.addProducto(inventario.getProductos().get(2), 34, inventario);
        //ticket 2
        ticket ticket_entrada2 = new ticket(new Fecha(30, 4, 2024));
        ticket_entrada2.setPersona(catalogoProveedores.getPersonas().get(1)); // Suponiendo que obtienes la segunda persona del catálogo
        ticket_entrada2.addProducto(inventario.getProductos().get(1), 10, inventario); // Suponiendo que agregas el segundo producto del inventario
        ticket_entrada2.addProducto(inventario.getProductos().get(3), 20, inventario); // Suponiendo que agregas el cuarto producto del inventario

        // Generar ticket 3
        ticket ticket_entrada3 = new ticket(new Fecha(30, 4, 2024));
        ticket_entrada3.setPersona(catalogoProveedores.getPersonas().get(2)); // Suponiendo que obtienes la tercera persona del catálogo
        ticket_entrada3.addProducto(inventario.getProductos().get(2), 15, inventario); // Suponiendo que agregas el tercer producto del inventario
        ticket_entrada3.addProducto(inventario.getProductos().get(4), 25, inventario); // Suponiendo que agregas el quinto producto del inventario

        // Generar ticket 4
        ticket ticket_entrada4 = new ticket(new Fecha(30, 4, 2024));
        ticket_entrada4.setPersona(catalogoProveedores.getPersonas().get(3));
        ticket_entrada4.addProducto(inventario.getProductos().get(3), 8, inventario);
        ticket_entrada4.addProducto(inventario.getProductos().get(5), 12, inventario);

        // Generar ticket 5
        ticket ticket_entrada5 = new ticket(new Fecha(30, 4, 2024));
        ticket_entrada5.setPersona(catalogoProveedores.getPersonas().get(4));
        ticket_entrada5.addProducto(inventario.getProductos().get(4), 30, inventario);
        ticket_entrada5.addProducto(inventario.getProductos().get(6), 18, inventario);



        //Genera ticket 1
        ticket ticket_salida1 = new ticket(new Fecha(30, 4 ,2024));
        ticket_salida1.setPersona((catalogoClientes.getPersonas().get(0)));
        ticket_salida1.disminuirStockProducto(inventario.getProductos().get(0), 5, inventario);
        ticket_salida1.disminuirStockProducto(inventario.getProductos().get(3), 10, inventario);
        // Generar ticket 2
        ticket ticket_salida2 = new ticket(new Fecha(30, 4, 2024));
        ticket_salida2.setPersona(catalogoClientes.getPersonas().get(1)); // Suponiendo que obtienes la segunda persona del catálogo
        ticket_salida2.disminuirStockProducto(inventario.getProductos().get(1), 8, inventario); // Suponiendo que reduces el stock del segundo producto del inventario
        ticket_salida2.disminuirStockProducto(inventario.getProductos().get(4), 15, inventario); // Suponiendo que reduces el stock del quinto producto del inventario

        // Generar ticket 3
        ticket ticket_salida3 = new ticket(new Fecha(30, 4, 2024));
        ticket_salida3.setPersona(catalogoClientes.getPersonas().get(2)); // Suponiendo que obtienes la tercera persona del catálogo
        ticket_salida3.disminuirStockProducto(inventario.getProductos().get(2), 20, inventario); // Suponiendo que reduces el stock del tercer producto del inventario
        ticket_salida3.disminuirStockProducto(inventario.getProductos().get(5), 5, inventario); // Suponiendo que reduces el stock del sexto producto del inventario

        // Generar ticket 4
        ticket ticket_salida4 = new ticket(new Fecha(30, 4, 2024));
        ticket_salida4.setPersona(catalogoClientes.getPersonas().get(3)); // Suponiendo que obtienes la cuarta persona del catálogo
        ticket_salida4.disminuirStockProducto(inventario.getProductos().get(3), 18, inventario); // Suponiendo que reduces el stock del cuarto producto del inventario
        ticket_salida4.disminuirStockProducto(inventario.getProductos().get(6), 7, inventario); // Suponiendo que reduces el stock del séptimo producto del inventario

        // Generar ticket 5
        ticket ticket_salida5 = new ticket(new Fecha(30, 4, 2024));
        ticket_salida5.setPersona(catalogoClientes.getPersonas().get(4)); // Suponiendo que obtienes la quinta persona del catálogo
        ticket_salida5.disminuirStockProducto(inventario.getProductos().get(4), 25, inventario); // Suponiendo que reduces el stock del quinto producto del inventario
        ticket_salida5.disminuirStockProducto(inventario.getProductos().get(7), 3, inventario); // Suponiendo que reduces el stock del octavo producto del inventario


        ticketsEntrada.agregarTicket(ticket_entrada1);
        ticketsEntrada.agregarTicket(ticket_entrada2);
        ticketsEntrada.agregarTicket(ticket_entrada3);
        ticketsEntrada.agregarTicket(ticket_entrada4);
        ticketsEntrada.agregarTicket(ticket_entrada5);
        ticketsEntrada.agregarTicket(ticket_entrada1);
        ticketsEntrada.agregarTicket(ticket_entrada2);
        ticketsEntrada.agregarTicket(ticket_entrada3);
        ticketsEntrada.agregarTicket(ticket_entrada4);
        ticketsEntrada.agregarTicket(ticket_entrada5);

        ticketsSalida.agregarTicket(ticket_salida1);
        ticketsSalida.agregarTicket(ticket_salida2);
        ticketsSalida.agregarTicket(ticket_salida3);
        ticketsSalida.agregarTicket(ticket_salida4);
        ticketsSalida.agregarTicket(ticket_salida5);
        ticketsSalida.agregarTicket(ticket_salida1);
        ticketsSalida.agregarTicket(ticket_salida2);
        ticketsSalida.agregarTicket(ticket_salida3);
        ticketsSalida.agregarTicket(ticket_salida4);
        ticketsSalida.agregarTicket(ticket_salida5);

        Log.d("Ticket", "Tickets entrada");
        Log.d("Ticket", "");

        for (ticket ticket : ticketsEntrada.getListaTickets())
        {
            ticket.mostrar();
        }


        Log.d("Ticket", "");
        Log.d("Ticket", "Tickets salida");
        Log.d("Ticket", "");
        for (ticket ticket : ticketsSalida.getListaTickets())
        {
            ticket.mostrar();
        }


    }
    public stock getInventario() {
        return inventario;
    }

    public catalogoPersonas getCatalogoProveedores() {
        return catalogoProveedores;
    }

    public listaTickets getTicketsEntrada() {
        return ticketsEntrada;
    }

    public catalogoPersonas getCatalogoClientes() {
        return catalogoClientes;
    }

    public listaTickets getTicketsSalida() {
        return ticketsSalida;
    }
}
