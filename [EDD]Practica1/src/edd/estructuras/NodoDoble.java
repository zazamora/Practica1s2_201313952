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
public class NodoDoble {
    private Data datos;
    private NodoDoble siguiente;
    private NodoDoble anterior;

    public Data getDatos() {
        return datos;
    }

    public void setDatos(Data datos) {
        this.siguiente = null;
        this.anterior = null;
        this.datos = datos;
    }

    public NodoDoble getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }

    public NodoDoble() {
        this.siguiente = null;
        this.anterior = null;
    }
    
}
