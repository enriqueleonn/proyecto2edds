/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author Enrique León
 */
public class Nodo {
    
    private Object dato;
    private Nodo pnext;
    
    public Nodo(){
        this.dato = null;
        this.pnext = null;
    }
    
    public Nodo(Object dato) {
        this.dato = dato;
        this.pnext = null;
    }
    
    public Object getDato() {
        return dato;
    }
    
    public void setDato (Object dato) {
        this.dato = dato;
    }
    
    public Nodo getPnext() {
        return pnext;
    }
    
    public void setPnext (Nodo pnext) {
        this.pnext = pnext;
    }
}
