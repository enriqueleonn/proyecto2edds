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
    
    public void enColar (Object dato) {
        Nodo pNew = new Nodo (dato);
        if (this.colaVacia()) {
            this.setCabeza(pNew);
            this.setCola(pNew);
        }
        else {
            this.cola.setPnext(pNew);
            this.setCola(pNew);
        }
        size++;
    }
    
    public Object desEncolar(){
        if (this.colaVacia()) {
            Object quitar = this.cabeza.getDato();
            this.setCabeza(null);
            this.setCola(null);
            size--;
            return quitar;
        }
        
        else {
            Object quitar = this.cabeza.getDato();
            this.setCabeza(this.cabeza.getPnext());
            size--;
            return quitar;
        }
    }
    
    public void destruir () {
        cabeza = null;
        cola = null;
        size = 0;
    }
    
    public void listar() {
        Nodo aux = cabeza;
        String pila = "COLA:\n";
        while (aux != null) {
            pila = pila + aux.getDato() + "\n";
            aux = aux.getPnext();
        }
        System.out.println(pila);
    }
}
