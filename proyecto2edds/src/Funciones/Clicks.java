/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import EDD.Arbol;
import org.graphstream.graph.Graph;
import org.graphstream.ui.view.Viewer;
import org.graphstream.ui.view.ViewerListener;
import org.graphstream.ui.view.ViewerPipe;

/**
 *
 * @author eabdf
 */
public class Clicks implements ViewerListener {
    
    protected boolean loop = true;
    private Arbol arbolGenealogico;

    public Clicks(Graph grafo, Arbol arbolGenealogico) {
        this.arbolGenealogico = arbolGenealogico;
        Graph graph = grafo;
        Viewer viewer = graph.display();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);

       
        viewer.getDefaultView().enableMouseOptions();

       
        ViewerPipe fromViewer = viewer.newViewerPipe();
        fromViewer.addViewerListener(this); 
        fromViewer.addSink(graph);

       
        new Thread(() -> {
            while (loop) {
                fromViewer.pump(); 
                try {
                    Thread.sleep(50); 
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }).start();

    }

    @Override
    public void viewClosed(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void buttonPushed(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void buttonReleased(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseOver(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseLeft(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
