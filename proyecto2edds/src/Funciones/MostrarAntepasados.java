/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import EDD.Lista;
import EDD.Nodo;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.swing_viewer.ViewPanel;
import org.graphstream.ui.view.Viewer;
import proyecto2edds.Persona;

/**
 *La clase MostrarAntepasados es una ventana gráfica que visualiza
 * la genealogía de una lista de antepasados utilizando un grafo.
 * 
 * @author Enrique León
 */
public class MostrarAntepasados extends JFrame {
    private Lista antepasados;
    private Viewer visor;
    private ViewPanel panelVista;
    /**
     * Constructor que inicializa la ventana con la lista de antepasados.
     * 
     * @param antepasados La lista de antepasados a mostrar.
     */
    public MostrarAntepasados(Lista antepasados) {
        this.antepasados = antepasados;
        configurarInterfaz();
        inicializarVisor();
        agregarBotonCerrar();
    }
     /**
     * Configura la interfaz de la ventana.
     */
    private void configurarInterfaz() {
        setTitle("Visualizador de Antepasados");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
    }

    private void inicializarVisor() {
        Graph grafo = new SingleGraph("Antepasados");
        construirGrafo(grafo);

        
        visor = grafo.display(false);
        visor.enableAutoLayout();

        
        if (panelVista == null) {
            panelVista = (ViewPanel) visor.getDefaultView();
            add(panelVista, BorderLayout.CENTER);
        }
    }
    /**
     * Construye el grafo a partir de la lista de antepasados.
     * 
     * @param grafo El grafo a construir.
     */
    private void construirGrafo(Graph grafo) {
        if (antepasados == null || antepasados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay antepasados para mostrar.", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        
        Nodo aux = antepasados.getpFirst();
        Node nodoAnterior = null;

        while (aux != null) {
            Persona persona = (Persona) aux.getDato();
            String id = persona.nombreUnico();

          
            Node nodoActual = grafo.addNode(id);
            nodoActual.setAttribute("ui.label", persona.nombreUnico());
            nodoActual.setAttribute("ui.style", "fill-color: blue; size: 25px; text-alignment: center;");

           
            if (nodoAnterior != null) {
                String edgeId = nodoAnterior.getId() + "-" + nodoActual.getId();
                grafo.addEdge(edgeId, nodoAnterior.getId(), nodoActual.getId());
            }

            
            nodoAnterior = nodoActual;
            aux = aux.getPnext();
        }

        
        grafo.setAttribute("ui.stylesheet",
                "node { text-size: 16px; }" +
                "edge { size: 2px; }");
    }
    /**
     * Agrega un botón para cerrar la ventana.
     */
    private void agregarBotonCerrar() {
        JButton botonCerrar = new JButton("Cerrar");
        botonCerrar.addActionListener(e -> cerrarVentana());
        add(botonCerrar, BorderLayout.SOUTH);
    }
    /**
     * Cierra la ventana y libera recursos.
     */
    private void cerrarVentana() {
        if (visor != null) {
            visor.disableAutoLayout();
            visor.close();
        }
        if (panelVista != null) {
            remove(panelVista);
            panelVista = null;
        }
        dispose();
    }

}
