/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import javax.swing.JOptionPane;

/**
 * * La clase Lista implementa una lista enlazada simple para almacenar objetos.
 * Permite realizar operaciones como insertar, eliminar y buscar elementos.
 * @author Enrique León
 */
public class Lista {
    
    private Nodo pFirst;
    private int size;
    
        /**
     * Constructor que inicializa la lista vacía.
     */
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
       /**
     * Inserta un nuevo elemento al final de la lista.
     * 
     * @param dato El dato a insertar.
     */
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
      /**
     * Muestra los elementos de la lista en un cuadro de diálogo.
     */
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
      /**
     * Busca un elemento en la lista.
     * 
     * @param referencia El objeto a buscar.
     * @return true si se encontró el objeto, false en caso contrario.
     */
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
     /**
     * Inserta un nuevo elemento en una posición específica de la lista.
     * 
     * @param posicion La posición donde insertar el nuevo elemento.
     * @param valor El valor a insertar.
     */
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
    
       /**
     * Obtiene el nodo en una posición específica.
     * 
     * @param posicion La posición del nodo.
     * @return El nodo en la posición especificada o null si la posición es inválida.
     */
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
      /**
     * Transforma la lista en una representación de cadena.
     * 
     * @return Una cadena que representa los elementos de la lista.
     */
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
