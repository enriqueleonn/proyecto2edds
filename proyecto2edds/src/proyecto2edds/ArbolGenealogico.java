/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2edds;

import EDD.Arbol;
import EDD.HashTable;

/**
 *
 * La clase ArbolGenealogico representa un árbol genealógico que 
 * contiene información sobre un linaje y utiliza una tabla hash 
 * para almacenar datos relacionados.
 * 
 * @author eabdf
 */
public class ArbolGenealogico {

    private String nombreLinaje;
    private Arbol arbol;
    private HashTable hashTable;
    /**
     * Constructor que inicializa un nuevo árbol genealógico 
     * con un linaje nulo, un nuevo árbol y una tabla hash de tamaño 100.
     */
    public ArbolGenealogico() {
        this.nombreLinaje = null;
        this.arbol = new Arbol();
        this.hashTable = new HashTable(100);
    }

    public String getNombreLinaje() {
        return nombreLinaje;
    }

    public void setNombreLinaje(String nombreLinaje) {
        this.nombreLinaje = nombreLinaje;
    }

    public Arbol getArbol() {
        return arbol;
    }

    public void setArbol(Arbol arbol) {
        this.arbol = arbol;
    }

    public HashTable getHashTable() {
        return hashTable;
    }
    /**
     * Establece una nueva tabla hash.
     * 
     * @param hashTable La nueva tabla hash.
     */
    public void setHashTable(HashTable hashTable) {
        this.hashTable = hashTable;
    }
    /**
     * Inicializa el árbol genealógico con un árbol, una tabla hash 
     * y un nombre de linaje.
     * 
     * @param arbol El árbol genealógico a establecer.
     * @param hashTable La tabla hash a establecer.
     * @param nombre El nombre del linaje.
     */
    public void iniciar(Arbol arbol, HashTable hashTable, String nombre) {
        this.nombreLinaje = nombre;
        this.arbol = arbol;
        this.hashTable = hashTable;
    }
    /**
     * Destruye el árbol genealógico, reiniciando el linaje y 
     * creando un nuevo árbol y destruyendo la tabla hash.
     */
    public void destruir() {
        this.nombreLinaje = null;
        this.arbol = new Arbol();
        this.hashTable.destruir();
    }

}
