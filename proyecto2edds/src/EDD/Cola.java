/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author Enrique León
 */
public class Cola {
    
    private Nodo cabeza;
    private Nodo cola; 
    private int size;
    
    public Cola(){
        this.cabeza = null;
        this.cola = null;
        this.size = 0;
    }
    
    public Nodo getCabeza() {
        return cabeza;
    }
    
    public void setCabeza(Nodo cabeza){
        this.cabeza = cabeza; 
    }
    
    public Nodo getcola() {
        return cola;
    }
    
    public void setCola(Nodo cola) {
        this.cola = cola;
    }
    
    public int getSize() {
        return size;
    }
    
    public void setSize(int size) {
        this.size = size;
    }
    
    public boolean colaVacia() {
        return this.cabeza == null;
    }
}
