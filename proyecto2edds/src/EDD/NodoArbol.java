/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import proyecto2edds.Persona;

/**
 * La clase NodoArbol representa un nodo en un árbol, que puede tener múltiples hijos.
 * Cada nodo contiene un dato, una referencia a su padre y una lista de hijos.
 * @author Enrique León
 */
public class NodoArbol {
     private Object dato;
    private NodoArbol padre;
    private Lista hijos;

      /**
     * Constructor que inicializa un nodo con un dato específico.
     * 
     * @param dato El dato a almacenar en el nodo.
     */
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
    /**
     * Busca un hijo en la lista de hijos del nodo.
     * 
     * @param hijo El nodo hijo a buscar.
     * @return true si el hijo existe, false en caso contrario.
     */
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
     /**
     * Verifica si el nodo es una hoja (sin hijos).
     * 
     * @return true si es una hoja, false en caso contrario.
     */
    public boolean esHoja() {
        return this.hijos.isEmpty();
    }

}
