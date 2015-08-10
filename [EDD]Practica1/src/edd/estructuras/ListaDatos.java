/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edd.estructuras;

import java.util.ArrayList;

/**
 *
 * @author Saul
 */
public class ListaDatos {
    private ArrayList<Data> listaObjetos;
    private static ListaDatos instancia;
    public static ListaDatos getInstancia(){
        if(instancia == null){
            instancia = new ListaDatos();
        }
        return instancia;
    }
    public ListaDatos(){
        listaObjetos = new ArrayList<Data>();
    }
    public ArrayList<Data> getLista(){
        return listaObjetos;
    }
    public void cargarDatos(){
        listaObjetos.add(new Data("MarioBross", "Fontanero Italiano que le gusta la pizza.", 1, 1, "Principal", "mario.png"));
        listaObjetos.add(new Data("Vida", "Da nueva vida.", 0, 1,"Item", "life.png"));
        listaObjetos.add(new Data("Pared", "Pared", 0, 0, "Item", "pared.png"));
        listaObjetos.add(new Data("Suelo", "Suelo", 0, 0, "Item", "suelo.png"));
        listaObjetos.add(new Data("Koopa", "Tortuga que mata personajes.", 0, -1, "Enemigo", "koopa.png"));
        listaObjetos.add(new Data("Goomba", "Mostro que mate personajes", 0, -1, "Enemigo", "goomba.png"));
        listaObjetos.add(new Data("Ficha", "Incrementa puntos de personaje.", 0,0,"Item", "ficha.png"));
        listaObjetos.add(new Data("Castillo", "Lugar de llegada de personaje.", 0,0,"Item", "castillo.png"));
    }
    public Data getDatos(String personaje){
        Data elemento = null;
        for(Data dato:listaObjetos){
            if(dato.getPersonaje().equals(personaje)){
                elemento = dato;
            }
        }
        return elemento;
    }
}
