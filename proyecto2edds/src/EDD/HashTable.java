/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import javax.swing.JOptionPane;
import proyecto2edds.Persona;

/**
 * La clase HashTable implementa una tabla hash para almacenar objetos
 * utilizando listas encadenadas para manejar colisiones.
 * 
 * @author Enrique León
 */


public class HashTable {

    private Lista[] tabla;
    private int max;

     /**
     * Constructor que inicializa la tabla hash con un tamaño máximo.
     * 
     * @param max El tamaño máximo de la tabla.
     */
    public HashTable(int max) {
        this.max = max;
        this.tabla = new Lista[max];
        for (int i = 0; i < max; i++) {
            tabla[i] = new Lista();
        }

    }

    public Lista[] getTabla() {
        return tabla;
    }

    public void setTabla(Lista[] tabla) {
        this.tabla = tabla;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getIndex(Object key) {
        return Math.abs(key.hashCode()) % max;
    }

     /**
     * Inserta un nuevo valor asociado a una clave en la tabla.
     * 
     * @param key   La clave del valor a insertar.
     * @param value El valor a insertar.
     */
    public void insertar(Object key, Object value) {
        int index = this.getIndex(key);
        Lista listaIndex = tabla[index];

        if (this.buscar(key) == null) {
            listaIndex.InsertarFinal(value);
        }
    }
    
   /**
     * Busca un objeto en la tabla hash por su clave.
     * 
     * @param clave La clave del objeto a buscar.
     * @return El objeto encontrado o null si no existe.
     */
    public Object buscar(Object clave) {
        int index = this.getIndex(clave);
        Lista listaIndex = tabla[index];
        if (!listaIndex.isEmpty()) {
            for (int i = 0; i < listaIndex.getSize(); i++) {
                Persona personaActual = (Persona) listaIndex.getValor(i);
                String claveStr = (String) clave;
                if (personaActual.nombreUnico().equalsIgnoreCase(claveStr)) {
                    return personaActual;
                }
            }
        }
        return null;
    }

       /**
     * Busca personas en la tabla por un nombre parcial.
     * 
     * @param nombre El nombre a buscar.
     * @return Una lista de personas que coinciden con el nombre.
     */
    public Lista buscarNombre(String nombre) {
        Lista resultado = new Lista();
        for (int i = 0; i < max; i++) {
            if (!tabla[i].isEmpty()) {
                for (int j = 0; j < tabla[i].getSize(); j++) {
                    Persona personaActual = (Persona) tabla[i].getValor(j);
                    if (personaActual.getMote() != null) {
                        if (personaActual.getMote().toLowerCase().contains(nombre.toLowerCase())) {
                            resultado.InsertarFinal(personaActual);
                        } else if (personaActual.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                            resultado.InsertarFinal(personaActual);
                        }
                    } else {
                        if (personaActual.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                            resultado.InsertarFinal(personaActual);
                        }
                    }
                }
            }
        }

        return resultado;
    }

      /**
     * Busca personas en la tabla por el nombre exacto.
     * 
     * @param nombre El nombre a buscar.
     * @return Una lista de personas que coinciden con el nombre.
     */
    public Lista buscarNombre2(String nombre) {
        Lista resultado = new Lista();
        for (int i = 0; i < max; i++) {
            if (!tabla[i].isEmpty()) {
                for (int j = 0; j < tabla[i].getSize(); j++) {
                    Persona personaActual = (Persona) tabla[i].getValor(j);
                    if (personaActual.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                        resultado.InsertarFinal(personaActual);
                    }
                }
            }
        }

        return resultado;
    }
    
    /**
     * Busca personas en la tabla por su título.
     * 
     * @param titulo El título a buscar.
     * @return Una lista de personas que coinciden con el título.
     */
    public Lista buscarTitulo(String titulo) {

        Lista resultado = new Lista();
        for (int i = 0; i < max; i++) {
            if (!tabla[i].isEmpty()) {
                for (int j = 0; j < tabla[i].getSize(); j++) {
                    Persona personaActual = (Persona) tabla[i].getValor(j);
                    if (personaActual.getTitulo() != null) {
                        if (personaActual.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                            resultado.InsertarFinal(personaActual);
                        }
                    }
                }
            }
        }
        return resultado;
    }

    public void destruir() {
        for (int i = 0; i < max; i++) {

            tabla[i] = new Lista();
        }
    }
  /**
     * Muestra el contenido de la tabla hash en la consola.
     */
    public void mostrarTabla() {
        String tablaStr = "HashTable:\n";
        for (int i = 0; i < max; i++) {
            if (!tabla[i].isEmpty()) {
                tablaStr += "Indice " + i + ": ";
                for (int j = 0; j < tabla[i].getSize(); j++) {
                    Persona persona = (Persona) tabla[i].getValor(j);
                    tablaStr += persona.nombreUnico() + "-> ";
                }

                tablaStr += "null" + "\n";
            }
        }
        System.out.println(tablaStr);
    }
    
  /**
     * Muestra la información de una persona basada en su ID.
     * 
     * @param id El ID de la persona a mostrar.
     */
    public void mostrarInfo(String id) {
        Persona persona = (Persona) this.buscar(id); 
        if (persona != null) {
            JOptionPane.showMessageDialog(null,
                    persona.toString(), 
                    "Información de " + persona.getNombre(),
                    JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null,
                    "No se encontró el nodo con ID: " + id,
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
