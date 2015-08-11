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
public class ListaDoble {
    private NodoDoble inicio;
    private NodoDoble fin;

    public ListaDoble() {
        inicio = null;
        fin = null;
    }
    public NodoDoble crearNodo(Data info){
        NodoDoble nodo = new NodoDoble();
        if(info != null){
            nodo.setDatos(info);
            nodo.setAnterior(null);
            nodo.setSiguiente(null);
        }
        return nodo;
    }
    public boolean esVacio(){
        if(inicio != null)
            return false;
        return true;
    }
    public void insertarNodo(Data info){
        NodoDoble temp = crearNodo(info);
        if(esVacio()){
            inicio = fin = temp;
        }else{
            NodoDoble aux = fin;
            fin = temp;
            fin.setAnterior(aux);
            aux.setSiguiente(fin);
//            fin.setSiguiente(inicio);
//            inicio.setAnterior(fin);
        }
    }
    
    public void mostrarLista(){
        NodoDoble aux = inicio;
        if(esVacio()){
            System.out.println("Lista Vacia.");
        }else{
            while(aux != null){
                System.out.println("Datos: ");
                aux = aux.getSiguiente();
            }
        }
    }
    
    public NodoDoble getPrimero(){
        return inicio;
    }
    public Data buscar(String personaje){
        Data datos = null;
        NodoDoble aux = inicio;
        if(esVacio()){
            System.out.println("Lista Vacia.");
        }else{
            while(aux != null){
                if(aux.getDatos().getPersonaje().equals(personaje))
                    datos = aux.getDatos();
                aux = aux.getSiguiente();
            }
        }
        return datos;
    }
}
