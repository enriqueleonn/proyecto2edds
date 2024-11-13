/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import javax.swing.JOptionPane;

/**
 *
 * @author Enrique León
 */
public class Lista {
    
    private Nodo pFirst;
    private int size;
    
    public Lista() {
        this.pFirst = null;
        this.size = 0;
    }
    
    public Nodo getpFirst() {
        return pFirst;
    }
    
    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }
    
    public int getSize() {
        return size;
    }
    
    public void setSize (int size) {
        this.size = size;
    }
    
    public boolean isEmpty() {
        return this.pFirst == null;
    }
    
    public void eliminar (){
        pFirst = null;
        size = 0;
    }
    
    public void InsertarFinal (Object dato) {
        Nodo pNew = new Nodo (dato);
        if (isEmpty()) {
            pFirst = pNew; 
        }
        else {
            Nodo aux = pFirst;
            while (aux.getPnext() != null) {
                aux = aux.getPnext();
            }
            aux.setPnext(pNew);
        }
        size++;
    }
    
    public void mostrar(){
        if (!isEmpty()) {
            Nodo aux = pFirst;
            String expresion = "";
            while (aux != null){
                expresion = expresion + aux.getDato().toString()+"\n";
                aux = aux.getPnext();
            }
            JOptionPane.showMessageDialog(null, expresion);
        }
        else{
            JOptionPane.showMessageDialog(null, "La lista está vacía");
        }
    }
    
    public boolean Eliminar_Inicio(){
        if (!isEmpty()) {
            pFirst = pFirst.getPnext();
            size--;
            return true;
        }
        else{
            return false;
        }
    }
    
    public void Eliminar_Final(){
        if(!isEmpty()){
            if (getSize()==1) {
                eliminar();
            }else{
                Nodo pointer = getpFirst();
                while(pointer.getPnext() != null && pointer.getPnext().getPnext()!= null){
                    pointer = pointer.getPnext();
                }
                pointer.setPnext(null);
            }
            size --;
        }  
    }
    
    public boolean buscar(Object referencia){
        Nodo aux = pFirst;
        boolean encontrado = false;
        while(aux != null && encontrado != true){
            if (referencia == aux.getDato()){ 
                encontrado = true;
            }
            else{
                aux = aux.getPnext();
            }
        }
        return encontrado;
    }
    
    public void insertarPorPosicion(int posicion, Object valor){
        if(posicion>=0 && posicion<size){
            Nodo nuevo = new Nodo(valor);
            if(posicion == 0){
                nuevo.setPnext(pFirst);
                pFirst = nuevo;
            }
            else{
                if(posicion == size-1){
                    Nodo aux = pFirst;
                    while(aux.getPnext() != null){
                        aux = aux.getPnext();
                    }
                    aux.setPnext(nuevo);              
                }
                else{
                    Nodo aux = pFirst;
                    for (int i = 0; i < (posicion-1); i++) {
                        aux = aux.getPnext();
                    }
                    Nodo siguiente = aux.getPnext();
                    aux.setPnext(nuevo);
                    nuevo.setPnext(siguiente);
                }
            }
            size++;
        }
    }
    
    
    public Object getValor(int posicion){

        if(posicion>=0 && posicion<size){
            
            if (posicion == 0) {
                return pFirst.getDato();
            }else{
                Nodo aux = pFirst;
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getPnext();
                }
                return aux.getDato();
            }
        }
        return null;
    }
    
    public Nodo getNodo(int posicion){

        if(posicion>=0 && posicion<size){
            
            if (posicion == 0) {
                return pFirst;
            }else{
                Nodo aux = pFirst;
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getPnext();
                }
                return aux;
            }
        }
        return null;
    }
    
    public String transformar(){
        if (!isEmpty()) {
            
            Nodo aux = pFirst;
            String expresion = "";
            
            for (int i = 0; i<size; i++) {
                expresion += aux.getDato().toString()+ "\n";
                aux = aux.getPnext();
            }
            return expresion;
        }
        return "Lista vacía";
    }
    
}
