/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import EDD.Arbol;
import EDD.NodoArbol;
import Interfaces.Menu;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import proyecto2edds.Persona;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.swing_viewer.ViewPanel;
import org.graphstream.ui.view.Viewer;

/**
 * La clase MostrarArbol es una ventana gráfica que visualiza
 * un árbol genealógico utilizando un grafo.
 * 
 * @author Enrique León
 */
public class MostrarArbol extends JFrame {

    private Arbol arbol;
    private Viewer visor;
    private ViewPanel panelVista;

    /**
     * Constructor que inicializa la ventana con el árbol a mostrar.
     * 
     * @param arbol El árbol genealógico a visualizar.
     */
    public MostrarArbol(Arbol arbol) {
        this.arbol = arbol;
        configurarInterfaz();
        inicializarVisor();
        agregarBotonRegresar();
    }
    /**
     * Configura la interfaz de la ventana.
     */
    private void configurarInterfaz() {
        setTitle("Visualizador de Árbol");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
    }
    /**
     * Inicializa el visor del árbol.
     */
    private void inicializarVisor() {
        Graph arbolVisual = new SingleGraph("Árbol");
        construirArbol(arbolVisual);

        visor = arbolVisual.display(false);
        visor.enableAutoLayout();

        agregarEventosNodos(arbolVisual);

        if (panelVista == null) {
            panelVista = (ViewPanel) visor.getDefaultView();
            add(panelVista, BorderLayout.CENTER);
        }
    }
     /**
     * Agrega eventos a los nodos del árbol para mostrar detalles de la persona.
     * 
     * @param arbolVisual El grafo del árbol.
     */
    private void agregarEventosNodos(Graph arbolVisual) {
        for (Node node : arbolVisual) {

            node.setAttribute("ui.label", node.getId());

            NodoArbol nodoArbol = arbol.buscar(node.getId());
            if (nodoArbol != null) {
                node.setAttribute("persona", nodoArbol.getDato());
            }

            node.setAttribute("ui.style", "fill-color: green; size: 20px;");

            node.setAttribute("ui.clicked", (Runnable) () -> {
                Persona persona = (Persona) node.getAttribute("persona");
                if (persona != null) {
                    JOptionPane.showMessageDialog(null,
                            persona.toString(),
                            "Detalles de la Persona",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            });
        }
    }
    /**
     * Construye el árbol visual a partir de la estructura de datos.
     * 
     * @param arbolVisual El grafo a construir.
     */
    private void construirArbol(Graph arbolVisual) {
        if (arbol.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El árbol está vacío.");
            return;
        }

        agregarNodoYSubarbol(arbol.getRoot(), null, arbolVisual);

        arbolVisual.setAttribute("ui.stylesheet",
                "node { text-size: 14px; size: 30px; text-alignment: center; fill-color: green; }"
                + "edge { size: 2px; }"
        );
    }
    /**
     * Agrega un nodo y sus subárboles al grafo.
     * 
     * @param nodoActual  El nodo actual del árbol.
     * @param padreId     El ID del nodo padre.
     * @param arbolVisual El grafo del árbol.
     */
    private void agregarNodoYSubarbol(NodoArbol nodoActual, String padreId, Graph arbolVisual) {
        Persona persona = (Persona) nodoActual.getDato();
        String nodoId = persona.nombreUnico();

        if (arbolVisual.getNode(nodoId) == null) {
            Node node = arbolVisual.addNode(nodoId);
            node.setAttribute("ui.label", persona.nombreUnico());
            node.setAttribute("persona", persona);
        }

        if (padreId != null && arbolVisual.getEdge(padreId + "-" + nodoId) == null) {
            arbolVisual.addEdge(padreId + "-" + nodoId, padreId, nodoId);
        }

        for (int i = 0; i < nodoActual.getHijos().getSize(); i++) {
            NodoArbol hijo = (NodoArbol) nodoActual.getHijos().getValor(i);
            agregarNodoYSubarbol(hijo, nodoId, arbolVisual);
        }
    }
    /**
     * Agrega un botón para regresar al menú principal.
     */
    private void agregarBotonRegresar() {
        JButton botonRegresar = new JButton("Regresar");
        botonRegresar.addActionListener(e -> {
            cerrarVisor();
            dispose();
            Menu menuPrincipal = new Menu();
            menuPrincipal.setVisible(true);
        });
        add(botonRegresar, BorderLayout.SOUTH);
    }
    /**
     * Cierra el visor y libera recursos.
     */
    private void cerrarVisor() {
        if (visor != null) {
            visor.disableAutoLayout();
            visor.close();
        }
        if (panelVista != null) {
            remove(panelVista);
            panelVista = null;
        }

        Menu menu = new Menu();
    }
}
