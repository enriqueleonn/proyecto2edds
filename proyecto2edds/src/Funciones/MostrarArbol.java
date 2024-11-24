/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import EDD.Arbol;
import EDD.Cola;
import EDD.NodoArbol;
import proyecto2edds.Persona;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

/**
 *
 * @author Enrique León
 */
public class MostrarArbol {
     public static Graph construirGrafoDesdeArbol(Arbol arbol, String nombreGrafo, String estilo) {
        Graph grafo = new SingleGraph(nombreGrafo);

        if (arbol.isEmpty()) {
            System.out.println("El árbol está vacío.");
            return grafo;
        }

        
        NodoArbol nodoRaiz = arbol.getRoot();
        Persona personaRaiz = (Persona) nodoRaiz.getDato();
        String idRaiz = personaRaiz.nombreUnico() + "_" + nodoRaiz.hashCode();

       
        if (grafo.getNode(idRaiz) == null) {
            grafo.addNode(idRaiz).setAttribute("ui.label", personaRaiz.nombreUnico());
            grafo.getNode(idRaiz).setAttribute("persona", personaRaiz);
        }

        
        agregarNodoYSubarbol(nodoRaiz, idRaiz, grafo);

       
        if (estilo != null && !estilo.isEmpty()) {
            grafo.setAttribute("ui.stylesheet", estilo);
        } else {
            
            grafo.setAttribute("ui.stylesheet", "node { fill-color: green; size: 20px; text-alignment: center; }");
        }
        grafo.setAttribute("ui.quality");
        grafo.setAttribute("ui.antialias");

        return grafo;
    }

   
    private static void agregarNodoYSubarbol(NodoArbol nodoActual, String padreId, Graph grafo) {
        if (nodoActual == null || nodoActual.getDato() == null) {
            return;
        }

        
        Cola colaNodos = new Cola();
        Cola colaPadres = new Cola();

        colaNodos.enColar(nodoActual);
        colaPadres.enColar(padreId);

        while (!colaNodos.colaVacia()) {
            NodoArbol nodo = (NodoArbol) colaNodos.desEncolar();
            String padre = (String) colaPadres.desEncolar();

            
            Persona persona = (Persona) nodo.getDato();
            String nodoId = persona.nombreUnico() + "_" + nodo.hashCode(); 

            
            if (grafo.getNode(nodoId) == null) {
                grafo.addNode(nodoId).setAttribute("ui.label", persona.nombreUnico());
                grafo.getNode(nodoId).setAttribute("persona", persona);
            }

            
            if (padre != null) {
                String edgeId = padre + "-" + nodoId;
                if (grafo.getEdge(edgeId) == null) {
                    grafo.addEdge(edgeId, padre, nodoId);
                }
            }

            
            for (int i = 0; i < nodo.getHijos().getSize(); i++) {
                NodoArbol hijo = (NodoArbol) nodo.getHijos().getValor(i);
                colaNodos.enColar(hijo);
                colaPadres.enColar(nodoId);
            }
        }
    }
}
