/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import EDD.Arbol;
import EDD.HashTable;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.FileNotFoundException;
import java.io.FileReader;
import proyecto2edds.Persona;

/**
 *
 * @author Enrique León
 */
public class Cargar {

    private Arbol arbol;
    private HashTable hashTable;
    private String nombreLinaje;

    public Cargar() {
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

    public void cargar(String ruta) throws FileNotFoundException {
        FileReader lectorArchivo = new FileReader(ruta);
        Gson gson = new Gson();
        JsonObject json = gson.fromJson(lectorArchivo, JsonObject.class);

        for (String nombreLinajeActual : json.keySet()) {
            nombreLinaje = nombreLinajeActual;
            JsonArray miembrosLinaje = json.getAsJsonArray(nombreLinaje);
            for (JsonElement miembro : miembrosLinaje) {
                JsonObject miembroJson = miembro.getAsJsonObject();
                agregarMiembroHashTable(miembroJson);
            }
        }

    }
    
    private void  agregarMiembroHashTable (JsonObject miembroJson){
        String nombre = miembroJson.keySet().iterator().next();
         JsonArray atributosMiembro = miembroJson.getAsJsonArray(nombre);
        
        Persona nuevoMiembro = new Persona(nombre);
        colocarAtributos(nuevoMiembro, atributosMiembro);
        this.hashTable.insertar(nuevoMiembro.nombreUnico(), nuevoMiembro);

    }
    private void colocarAtributos(Persona nuevoMiembro,JsonArray atributosMiembro){
        for (JsonElement atributoElemento : atributosMiembro) {
            JsonObject atributo = atributoElemento.getAsJsonObject();
            if(atributo.has("Of his name")){
                nuevoMiembro.setNumeral(atributo.get("Of his name").getAsString());
            }else if(atributo.has("Born to")){
                if(nuevoMiembro.getPadre() == null){
                    nuevoMiembro.setPadre(atributo.get("Born to").getAsString());
                }else{
                    nuevoMiembro.setMadre(atributo.get("Born to").getAsString());
                }
            }else if(atributo.has("Known throughout as")){
                nuevoMiembro.setMote(atributo.get("Known throughout as").getAsString());
            }else if(atributo.has("Held title")){
                nuevoMiembro.setTitulo(atributo.get("Held title").getAsString());
            }else if(atributo.has("Wed to")){
                nuevoMiembro.setEsposa(atributo.get("Wed to").getAsString());
            }else if(atributo.has("Of eyes")){
                nuevoMiembro.setColorOjos(atributo.get("Of eyes").getAsString());
            }else if(atributo.has("Of hair")){
                nuevoMiembro.setColorCabello(atributo.get("Of hair").getAsString());
            }else if(atributo.has("Notes")){
                nuevoMiembro.setComentVida(atributo.get("Notes").getAsString());
            }else if(atributo.has("Fate")){
                nuevoMiembro.setComentMuerte(atributo.get("Fate").getAsString());
            }
        }
    }
}
