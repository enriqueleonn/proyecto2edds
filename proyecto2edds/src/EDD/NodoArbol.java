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
public class NodoArbol {
     private Object dato;
    private NodoArbol padre;
    private Lista hijos;

    public NodoArbol(Object dato) {
        this.dato = dato;
        this.padre = null;
        this.hijos = new Lista();
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public NodoArbol getPadre() {
        return padre;
    }

    public void setPadre(NodoArbol padre) {
        this.padre = padre;
    }

    public Lista getHijos() {
        return hijos;
    }

    public void setHijos(Lista hijos) {
        this.hijos = hijos;
    }
    
    public void agregarHijo(NodoArbol hijo){
        if(!this.buscarHijo(hijo)){
            this.hijos.InsertarFinal(hijo);
        }
    }

    public boolean buscarHijo(NodoArbol hijo) {
        if (!this.esHoja()) {
            Persona personaNueva = (Persona) hijo.getDato();
            for (int i = 0; i < this.hijos.getSize(); i++) {
                NodoArbol hijoActual = (NodoArbol) this.hijos.getValor(i);
                Persona personaActual = (Persona) hijoActual.getDato();
                if (personaActual.nombreUnico().equalsIgnoreCase(personaNueva.nombreUnico())) {
                    return true;
                }
            }

            return false;
        }
        
        return false;
    }

    public boolean esHoja() {
        return this.hijos.isEmpty();
    }

}
