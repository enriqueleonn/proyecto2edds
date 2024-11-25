/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2edds;

import EDD.Arbol;
import EDD.HashTable;

/**
 *
 *
 * @author eabdf
 */
public class ArbolGenealogico {

    private String nombreLinaje;
    private Arbol arbol;
    private HashTable hashTable;

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

    public void setHashTable(HashTable hashTable) {
        this.hashTable = hashTable;
    }

    public void iniciar(Arbol arbol, HashTable hashTable, String nombre) {
        this.nombreLinaje = nombre;
        this.arbol = arbol;
        this.hashTable = hashTable;
    }

    public void destruir() {
        this.nombreLinaje = null;
        this.arbol = new Arbol();
        this.hashTable.destruir();
    }

}
