/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import javax.swing.JOptionPane;
import proyecto2edds.Persona;

/**
 * La clase Arbol representa una estructura de árbol que permite almacenar nodos 
 * y realizar diversas operaciones sobre ellos, como inserción, búsqueda y 
 * visualización de nodos por niveles.
 * @author Enrique León
 */
public class Arbol {

    private NodoArbol root;
    
    /**
     * Constructor que inicializa la raíz del árbol como nula.
     */

    public Arbol() {
        this.root = null;
    }

    public NodoArbol getRoot() {
        return root;
    }

    public void setRoot(NodoArbol root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return root == null;
    }
    
 /**
     * Inicializa la raíz del árbol con un nuevo nodo.
     * 
     * @param dato El dato para el nuevo nodo raíz.
     */
    public void iniciarlizarRaiz(Object dato) {
        NodoArbol rootNueva = new NodoArbol(dato);
        this.setRoot(rootNueva);
    }

    /**
     * Inserta un nuevo nodo como hijo de un nodo padre.
     * 
     * @param padre El nodo padre.
     * @param dato  El dato del nuevo nodo.
     */
    public void insertar(NodoArbol padre, Object dato) {
        NodoArbol hijo = new NodoArbol(dato);
        hijo.setPadre(padre);
        padre.agregarHijo(hijo);
    }
    
 /**
     * Busca un nodo por su nombre único.
     * 
     * @param nombreUnico El nombre único a buscar.
     * @return El nodo encontrado o null si no existe.
     */
    public NodoArbol buscar(String nombreUnico) {
        if (!this.isEmpty()) {
            Cola cola = new Cola();

            cola.enColar(this.root);

            while (!cola.colaVacia()) {
                NodoArbol nodoActual = (NodoArbol) cola.desEncolar();
                Persona personaActual = (Persona) nodoActual.getDato();

                if (personaActual.nombreUnico().equalsIgnoreCase(nombreUnico)) {
                    return nodoActual;
                }
                if (personaActual.nombreNumeral().equalsIgnoreCase(nombreUnico)) {
                    return nodoActual;
                }

                Nodo temp = nodoActual.getHijos().getpFirst();
                while (temp != null) {
                    NodoArbol nodoHijoActual = (NodoArbol) temp.getDato();
                    cola.enColar(nodoHijoActual);

                    temp = temp.getPnext();
                }
            }

        }
        return null;
    }
    
    /**
     * Muestra los nodos del árbol por niveles.
     */
    public void mostrarPorNiveles() {
        if (!this.isEmpty()) {
            String arbolStr = "Arbol General:\n";
            Cola cola = new Cola();

            cola.enColar(this.root);

            while (!cola.colaVacia()) {
                NodoArbol nodoActual = (NodoArbol) cola.desEncolar();
                Persona personaActual = (Persona) nodoActual.getDato();

                arbolStr += personaActual.toString() + "\n";

                Nodo temp = nodoActual.getHijos().getpFirst();
                while (temp != null) {
                    NodoArbol nodoHijoActual = (NodoArbol) temp.getDato();
                    cola.enColar(nodoHijoActual);

                    temp = temp.getPnext();
                }
            }

            System.out.println(arbolStr);
        }
    }
    
   /**
     * Calcula el nivel máximo del árbol.
     * 
     * @return El nivel máximo.
     */
    public int nivelMaximo() {
        if (this.isEmpty()) {
            return 0;
        }
        int max = 0;
        Cola cola = new Cola();
        cola.enColar(this.root);

        Cola colaNiveles = new Cola();
        colaNiveles.enColar(1);

        while (!cola.colaVacia()) {
            NodoArbol nodoActual = (NodoArbol) cola.desEncolar();
            int nivelActual = (int) colaNiveles.desEncolar();

            max = Math.max(max, nivelActual);

            Nodo temp = nodoActual.getHijos().getpFirst();
            while (temp != null) {
                NodoArbol nodoHijoActual = (NodoArbol) temp.getDato();
                cola.enColar(nodoHijoActual);
                colaNiveles.enColar(nivelActual + 1);
                temp = temp.getPnext();
            }
        }

        return max;
    }
    
 /**
     * Lista las personas en un nivel específico.
     * 
     * @param nivel El nivel a listar.
     * @return Una lista de personas en el nivel especificado o null si está vacío.
     */
    public Lista listarNivel(int nivel) {
        Lista personasNivel = new Lista();
        if (this.isEmpty()) {
            return null;
        }

        Cola cola = new Cola();
        cola.enColar(this.root);

        Cola colaNiveles = new Cola();
        colaNiveles.enColar(1);

        while (!cola.colaVacia()) {
            NodoArbol nodoActual = (NodoArbol) cola.desEncolar();
            int nivelActual = (int) colaNiveles.desEncolar();

            if (nivelActual == nivel) {
                Persona personaActual = (Persona) nodoActual.getDato();
                personasNivel.InsertarFinal(personaActual);
            }

            Nodo temp = nodoActual.getHijos().getpFirst();
            while (temp != null) {
                NodoArbol nodoHijoActual = (NodoArbol) temp.getDato();
                cola.enColar(nodoHijoActual);
                colaNiveles.enColar(nivelActual + 1);
                temp = temp.getPnext();
            }
        }

        return personasNivel;

    }
    
  /**
     * Obtiene la lista de antepasados de un nodo dado.
     * 
     * @param nodo El nodo del cual se desean obtener los antepasados.
     * @return Una lista de antepasados o null si el nodo es nulo.
     */
    public Lista antepasados(NodoArbol nodo) {
        if (nodo == null) {
            return null;
        }

        Lista ancestros = new Lista();
        NodoArbol actual = nodo.getPadre();

        while (actual != null) {
            Persona personaActual = (Persona) actual.getDato();
            ancestros.InsertarFinal(personaActual);
            actual = actual.getPadre();
        }

        return ancestros;
    }
    
   /**
     * Muestra la información de un nodo basado en su ID.
     * 
     * @param id ID del nodo a buscar.
     */
    public void mostrarInfo(String id) {
        NodoArbol nodo = (NodoArbol) this.buscar(id); 
        if (nodo != null) {
            Persona persona = (Persona) nodo.getDato();
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

}
