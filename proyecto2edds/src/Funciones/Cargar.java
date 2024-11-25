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
 * La clase Cargar se encarga de cargar datos de un archivo JSON
 * y organizarlos en una estructura de árbol y una tabla hash.
 * @author Enrique León
 */
public class Cargar {

    private Arbol arbol;
    private HashTable hashTable;
    private String nombreLinaje;
    private boolean padresNoExisten;
    private boolean personasRepetidas;
    /**
     * Constructor que inicializa el árbol y la tabla hash.
     */
    public Cargar() {
        this.arbol = new Arbol();
        this.hashTable = new HashTable(100);
        this.nombreLinaje = null;
        this.personasRepetidas = false;
        this.padresNoExisten = false;
    }
    /**
     * Obtiene el árbol de miembros.
     * 
     * @return El árbol.
     */
    public Arbol getArbol() {
        return arbol;
    }

    public void setArbol(Arbol arbol) {
        this.arbol = arbol;
    }
    /**
     * Obtiene la tabla hash de miembros.
     * 
     * @return La tabla hash.
     */
    public HashTable getHashTable() {
        return hashTable;
    }
    /**
     * Establece la tabla hash de miembros.
     * 
     * @param hashTable La nueva tabla hash.
     */
    public void setHashTable(HashTable hashTable) {
        this.hashTable = hashTable;
    }

    public String getNombreLinaje() {
        return nombreLinaje;
    }
    /**
     * Establece el nombre del linaje.
     * 
     * @param nombreLinaje El nuevo nombre del linaje.
     */
    public void setNombreLinaje(String nombreLinaje) {
        this.nombreLinaje = nombreLinaje;
    }

    public boolean isPadresNoExisten() {
        return padresNoExisten;
    }
    /**
     * Establece el estado de padres no existentes.
     * 
     * @param padresNoExisten El nuevo estado.
     */
    public void setPadresNoExisten(boolean padresNoExisten) {
        this.padresNoExisten = padresNoExisten;
    }

    public boolean isPersonasRepetidas() {
        return personasRepetidas;
    }

    public void setPersonasRepetidas(boolean personasRepetidas) {
        this.personasRepetidas = personasRepetidas;
    }
    /**
     * Carga los datos desde un archivo JSON en la estructura de árbol y tabla hash.
     * 
     * @param ruta La ruta del archivo JSON.
     * @throws FileNotFoundException Si el archivo no se encuentra.
     */
    public void cargar(String ruta) throws FileNotFoundException {
        FileReader lectorArchivo = new FileReader(ruta);
        Gson gson = new Gson();
        JsonObject json = gson.fromJson(lectorArchivo, JsonObject.class);

        for (String nombreLinajeActual : json.keySet()) {
            nombreLinaje = nombreLinajeActual;
            JsonArray miembrosLinaje = json.getAsJsonArray(nombreLinaje);
            for (JsonElement miembro : miembrosLinaje) {
                JsonObject miembroJson = miembro.getAsJsonObject();
                agregarMiembrosHashTable(miembroJson);
            }
        }

        for (String nombreLinajeActual : json.keySet()) {
            nombreLinaje = nombreLinajeActual;
            JsonArray miembrosLinaje = json.getAsJsonArray(nombreLinaje);
            for (JsonElement miembro : miembrosLinaje) {
                JsonObject miembroJson = miembro.getAsJsonObject();
                agregarMiembrosArbol(miembroJson);
            }
        }

    }
     /**
     * Agrega un miembro al árbol a partir de un objeto JSON.
     * 
     * @param miembroJson El objeto JSON del miembro.
     */
    private void agregarMiembrosArbol(JsonObject miembroJson) {
        String nombre = miembroJson.keySet().iterator().next();
        JsonArray atributosMiembro = miembroJson.getAsJsonArray(nombre);

        Persona nuevoMiembro = new Persona(nombre);
        colocarAtributos(nuevoMiembro, atributosMiembro);

        if (this.arbol.buscar(nuevoMiembro.nombreUnico()) == null) {
            if (arbol.isEmpty()) {
                arbol.iniciarlizarRaiz(nuevoMiembro);
            } else {
                if (nuevoMiembro.getPadre().contains("of his name")) {
                    String nombrePadre = nuevoMiembro.getPadre().replace("of his name", "").replaceAll(",", "").trim();
                    nuevoMiembro.setPadre(nombrePadre);

                    if (arbol.buscar(nombrePadre) != null) {
                        arbol.insertar(arbol.buscar(nombrePadre), nuevoMiembro);
                    } else {
                        this.setPadresNoExisten(true);
                    }
                } else {
                    if (arbol.buscar(nuevoMiembro.getPadre()) != null) {
                        arbol.insertar(arbol.buscar(nuevoMiembro.getPadre()), nuevoMiembro);
                    } else {
                        this.setPadresNoExisten(true);
                    }
                }
            }
        } else {
            this.setPersonasRepetidas(true);
        }
    }

    private void agregarMiembrosHashTable(JsonObject miembroJson) {
        String nombre = miembroJson.keySet().iterator().next();
        JsonArray atributosMiembro = miembroJson.getAsJsonArray(nombre);

        Persona nuevoMiembro = new Persona(nombre);
        colocarAtributos(nuevoMiembro, atributosMiembro);
        this.hashTable.insertar(nuevoMiembro.nombreUnico(), nuevoMiembro);
    }
    /**
     * Agrega un miembro al hashtable a partir de un objeto JSON.
     * 
     * @param miembroJson El objeto JSON del miembro.
     */
    private void colocarAtributos(Persona nuevoMiembro, JsonArray atributosMiembro) {
        for (JsonElement atributoElemento : atributosMiembro) {
            JsonObject atributo = atributoElemento.getAsJsonObject();
            if (atributo.has("Of his name")) {
                nuevoMiembro.setNumeral(atributo.get("Of his name").getAsString());
            } else if (atributo.has("Born to")) {
                if (nuevoMiembro.getPadre() == null) {
                    nuevoMiembro.setPadre(atributo.get("Born to").getAsString());
                } else {
                    nuevoMiembro.setMadre(atributo.get("Born to").getAsString());
                }
            } else if (atributo.has("Known throughout as")) {
                nuevoMiembro.setMote(atributo.get("Known throughout as").getAsString());
            } else if (atributo.has("Held title")) {
                nuevoMiembro.setTitulo(atributo.get("Held title").getAsString());
            } else if (atributo.has("Wed to")) {
                nuevoMiembro.setEsposa(atributo.get("Wed to").getAsString());
            } else if (atributo.has("Of eyes")) {
                nuevoMiembro.setColorOjos(atributo.get("Of eyes").getAsString());
            } else if (atributo.has("Of hair")) {
                nuevoMiembro.setColorCabello(atributo.get("Of hair").getAsString());
            } else if (atributo.has("Notes")) {
                nuevoMiembro.setComentVida(atributo.get("Notes").getAsString());
            } else if (atributo.has("Fate")) {
                nuevoMiembro.setComentMuerte(atributo.get("Fate").getAsString());
            }
        }
    }

}
