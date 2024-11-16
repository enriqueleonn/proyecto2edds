/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import EDD.Arbol;
import EDD.HashTable;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *
 * @author Enrique León
 */
public class Cargar {
    private Arbol arbol;
    private HashTable hashTable;
    private String nombreLinaje;
    
    public Cargar(){
        this.arbol = new Arbol();
        this.hashTable = new HashTable(100);
        this.nombreLinaje = null;
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

    public String getNombreLinaje() {
        return nombreLinaje;
    }

    public void setNombreLinaje(String nombreLinaje) {
        this.nombreLinaje = nombreLinaje;
    }
    
    public void cargar (String ruta) throws FileNotFoundException {
        FileReader lectorArchivo = new FileReader(ruta);
        Gson gson = new Gson();
        JsonObject json = gson.fromJson(lectorArchivo, JsonObject.class);
        
        for (String nombreLinajeActual: json.keySet()){
             nombreLinaje = nombreLinajeActual;
        }
        
        
        
        
    }
}
