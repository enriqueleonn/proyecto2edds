/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 * * La clase Nodo representa un nodo en una lista enlazada.
 * Cada nodo contiene un dato y una referencia al siguiente nodo.
 * @author Enrique León
 */
public class Nodo {
    
    private Object dato;
    private Nodo pnext;
    
    /**
     * Constructor que inicializa un nodo vacío.
     */
    public Nodo(){
        this.dato = null;
        this.pnext = null;
    }
     /**
     * Constructor que inicializa un nodo con un dato específico.
     * 
     * @param dato El dato a almacenar en el nodo.
     */
    public Nodo(Object dato) {
        this.dato = dato;
        this.pnext = null;
    }
    /**
     * Obtiene el dato almacenado en el nodo.
     * 
     * @return El dato del nodo.
     */
    public Object getDato() {
        return dato;
    }
    /**
     * Establece el dato del nodo.
     * 
     * @param dato El nuevo dato a almacenar en el nodo.
     */
    public void setDato (Object dato) {
        this.dato = dato;
    }
    /**
     * Obtiene el siguiente nodo en la lista.
     * 
     * @return El siguiente nodo.
     */
    public Nodo getPnext() {
        return pnext;
    }
    /**
     * Establece el siguiente nodo en la lista.
     * 
     * @param pnext El nuevo nodo siguiente.
     */
    public void setPnext (Nodo pnext) {
        this.pnext = pnext;
    }
}
