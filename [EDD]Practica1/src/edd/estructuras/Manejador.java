/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edd.estructuras;

/**
 *
 * @author Saul
 */
public class Manejador {
    private static Manejador instancia;
    public ListaDoble listaElementos = new ListaDoble();
    public static Manejador getInstancia(){
        if(instancia == null){
            instancia = new Manejador();
        }
        return instancia;
    }
    public Manejador(){
        
    }
    public void insert(Data elemento){
        listaElementos.insertarNodo(elemento);
    }
    public Data buscar(String personaje){
        return listaElementos.buscar(personaje);
    }
}
