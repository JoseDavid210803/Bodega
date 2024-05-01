package com.example.bodega.backend.clases;

import java.util.ArrayList;
import java.util.List;

public class listaTickets {
    private List<ticket> listaTickets;
    private int cantidad;

    public listaTickets() {
        listaTickets= new ArrayList<>();
        cantidad=0;
    }
    public void agregarTicket(ticket nuevoTicket) {
        nuevoTicket.setId(cantidad + 1);
        listaTickets.add(nuevoTicket);
        cantidad++;
    }
    public List<ticket> getListaTickets()
    {
        return listaTickets;
    }

}
