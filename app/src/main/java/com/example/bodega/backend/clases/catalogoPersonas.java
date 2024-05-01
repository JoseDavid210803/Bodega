package com.example.bodega.backend.clases;

import java.util.ArrayList;
import java.util.List;

public class catalogoPersonas {
    private List<persona> personas;
    private int cantidad;
    private int id_actual;

    public catalogoPersonas() {
        this.personas=new ArrayList<>();
        this.cantidad = 0;
        this.id_actual=0;
    }
    public boolean anadirPersona(persona p)
    {

        personas.add(p);
        p.setId(id_actual);
        id_actual++;
        cantidad ++;
        return true;
    }

    public boolean idDisponible(int id)
    {
        for(persona persona: personas)
        {
            if (persona.getId()==id)
            {
                return false;
            }
        }
        return true;
    }
    public persona buscarPersonaporId(int id){
        for (persona persona: personas)
        {
            if (persona.getId()==id)
            {
                return persona;
            }
        }
        return null;
    }
    public List<persona> getPersonas()
    {
        return personas;
    }


}
