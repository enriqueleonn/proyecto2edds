/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import proyecto2edds.Persona;

/**
 *
 * @author Enrique León
 */
public class Arbol {
     private NodoArbol root;

    public Arbol() {
        this.root = null;
    }

    public NodoArbol getRoot() {
        return root;
    }

    public void setRoot(NodoArbol root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return root == null;
    }
    
    public void iniciarlizarRaiz(Object dato){
        NodoArbol rootNueva = new NodoArbol(dato);
        this.setRoot(rootNueva);
    }

    public void insertar(NodoArbol padre, Object dato) {
        NodoArbol hijo = new NodoArbol(dato);
        hijo.setPadre(padre);
        padre.agregarHijo(hijo);
    }

    public NodoArbol buscar(String nombreUnico) {
        if (!this.isEmpty()) {
            Cola cola = new Cola();

            cola.enColar(this.root);

            while (!cola.colaVacia()) {
                NodoArbol nodoActual = (NodoArbol) cola.desEncolar();
                Persona personaActual = (Persona) nodoActual.getDato();

                if(personaActual.nombreUnico().equalsIgnoreCase(nombreUnico)){
                    return nodoActual;
                }

                Nodo temp = nodoActual.getHijos().getpFirst();
                while (temp != null) {
                    NodoArbol nodoHijoActual = (NodoArbol) temp.getDato();
                    cola.enColar(nodoHijoActual);

                    temp = temp.getPnext();
                }
            }

        }
        return null;
    }

    public void mostrarPorNiveles() {
        if (!this.isEmpty()) {
            String arbolStr = "Arbol General:\n";
            Cola cola = new Cola();

            cola.enColar(this.root);

            while (!cola.colaVacia()) {
                NodoArbol nodoActual = (NodoArbol) cola.desEncolar();
                Persona personaActual = (Persona) nodoActual.getDato();

                arbolStr += personaActual.toString() + "\n";

                Nodo temp = nodoActual.getHijos().getpFirst();
                while (temp != null) {
                    NodoArbol nodoHijoActual = (NodoArbol) temp.getDato();
                    cola.enColar(nodoHijoActual);

                    temp = temp.getPnext();
                }
            }

            System.out.println(arbolStr);
        }
    }
}

    

