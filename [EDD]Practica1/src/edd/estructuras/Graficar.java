/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edd.estructuras;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author Saul
 */
public class Graficar {
    private File texto;
    public Graficar(){
        
    }
    public void archivoGraphviz(String codigo1, String nombre) {
        try {
            String path = nombre + ".txt";
            texto = new File(path);
            FileWriter writer = new FileWriter(texto);
            BufferedWriter buf = new BufferedWriter(writer);
            buf.write(
                    codigo1
                    
            );
            buf.flush();
            buf.close();
            writer.close();
            generar(nombre);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void graficaLista(){
        String texto = "";
        texto += "digraph grafica{\n";
        texto += "rankdir = TB; \n";
        texto += "node [shape = record, style = filled, colorfill = seashell2]; \n";
        texto += "splines = line;\n";
        /*----------SUB GRAPH---------*/
        texto += "subgraph cluster_L {\n";
        texto += "node [shape = box style = filled];\n";
        texto += "label = \"LISTA DOBLE ELEMENTOS\"; \n";
        texto += "color = red\n";
        NodoDoble miNodo = Manejador.getInstancia().listaElementos.getPrimero();
        if(miNodo != null){
            if(miNodo.getSiguiente() == null){
                texto += "G" + miNodo.getDatos().getPersonaje() + "[label=\"Personaje:" + miNodo.getDatos().getPersonaje() + "\n Tipo: " + miNodo.getDatos().getTipo() + "\nCantidad: " + miNodo.getDatos().getCantidad() + "\"" + "]\n";
            }else{
                while(miNodo.getSiguiente() != Manejador.getInstancia().listaElementos.getPrimero()){
                    Data dato1 = miNodo.getDatos();
                    Data dato2 = miNodo.getSiguiente().getDatos();
                    texto += "G" + dato1.getPersonaje() + "[label = \"Personaje:" + dato1.getPersonaje() + "\nTipo: " + dato1.getTipo() + "\nCantidad: " + dato1.getCantidad() + "\"" + "]\n";
                    texto += "G" + dato2.getPersonaje() + "[label = \"Personaje:" + dato2.getPersonaje() + "\nTipo: " + dato2.getTipo() + "\nCantidad: " + dato2.getCantidad() + "\"" + "]\n";
                    texto += "G" + dato1.getPersonaje() + "->G" + dato2.getPersonaje() + ";\n";
                    texto += "G" + dato2.getPersonaje() + "->G" + dato1.getPersonaje() + ";\n";
                    miNodo = miNodo.getSiguiente();
                }
//                Data d1 = Manejador.getInstancia().listaElementos.getPrimero().getDatos();
//                Data d2 = Manejador.getInstancia().listaElementos.getPrimero().getAnterior().getDatos();
//                System.out.println("Primero: " + d1.getPersonaje() + " - " + d2.getPersonaje());
//                texto += "G" + d1.getPersonaje() + "->G" + d2.getPersonaje() + ";\n";
//                texto += "G" + d2.getPersonaje() + "->G" + d1.getPersonaje() + ";\n";
            }
        }
        texto += "}\n";
        /*--------------------------------------------------------------------------------------------------*/
        texto += "}";
        archivoGraphviz(texto, "listadoble");
    }
    public void generar(String nombre) {
        try{
            String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
            String fileInputPath = nombre + ".txt";
            String fileOutputPath = nombre + ".jpg";
            String tParam = "-Tjpg";
            String tOParam = "-o";
            String [] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;
            Runtime rt = Runtime.getRuntime();
            rt.exec(cmd);
        }catch(Exception e){

        }
    }
}
