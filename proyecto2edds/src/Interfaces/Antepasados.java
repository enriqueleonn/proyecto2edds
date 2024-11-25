/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import EDD.Lista;
import Funciones.MostrarAntepasados;
import Funciones.Validar;
import static Interfaces.Inicio.arbolGenealogico;
import javax.swing.JOptionPane;
import proyecto2edds.Persona;

/**
 *
 * @author Enrique León
 */
public class Antepasados extends javax.swing.JFrame {

    private Validar validar = new Validar();
    private String[] resultadoBusqueda;

    public Antepasados() {
        initComponents();
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        inputNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultadosBusqueda = new javax.swing.JTextArea();
        buscar = new javax.swing.JButton();
        volver = new javax.swing.JButton();
        inputIndex = new javax.swing.JTextField();
        mostrarAntepasados = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Mostrar Antepasados");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel2.setText("Ingrese el nombre del integrante del linaje:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel3.setText("Seleccione el índice para mostrar sus antepasados:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, -1));
        jPanel1.add(inputNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 330, -1));

        resultadosBusqueda.setColumns(20);
        resultadosBusqueda.setRows(5);
        jScrollPane1.setViewportView(resultadosBusqueda);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 310, 180));

        buscar.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        jPanel1.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, -1, -1));

        volver.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        volver.setText("Volver");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        jPanel1.add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 380, -1, -1));

        inputIndex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputIndexActionPerformed(evt);
            }
        });
        jPanel1.add(inputIndex, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 280, -1));

        mostrarAntepasados.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        mostrarAntepasados.setText("Mostrar antepasados");
        mostrarAntepasados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarAntepasadosActionPerformed(evt);
            }
        });
        jPanel1.add(mostrarAntepasados, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        if (!inputNombre.getText().isEmpty()) {
            String nombre = inputNombre.getText();
            Lista resultados = arbolGenealogico.getHashTable().buscarNombre2(nombre);

            if (!resultados.isEmpty()) {
                String[] nombresResultados = new String[resultados.getSize()];

                for (int i = 0; i < resultados.getSize(); i++) {
                    Persona persona = (Persona) resultados.getValor(i);
                    if (persona.getMote() != null) {
                        nombresResultados[i] = persona.getMote();
                    } else {
                        nombresResultados[i] = persona.getNombre() + " " + persona.getNumeral();
                    }
                }

                resultadoBusqueda = nombresResultados;

                String resultado = "";

                for (int i = 0; i < nombresResultados.length; i++) {
                    int indice = i + 1;
                    resultado += indice + ": " + nombresResultados[i] + "\n";
                }

                resultadosBusqueda.setText(resultado);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron coincidencia con el nombre buscado");
            }

            inputNombre.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "El input no puede estar vacio");
        }


    }//GEN-LAST:event_buscarActionPerformed

    private void mostrarAntepasadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarAntepasadosActionPerformed

        if (resultadoBusqueda == null || resultadoBusqueda[0] == null) {
            JOptionPane.showMessageDialog(null, "No hay resultados para ver detalles");
        } else {
            if (!inputIndex.getText().isEmpty() && !"".equals(inputIndex.getText())) {
                String indiceStr = inputIndex.getText();
                if (validar.ValidarNumeros(indiceStr) != -1) {
                    int indice = validar.ValidarNumeros(indiceStr) - 1;
                    if (validar.validarIndice(resultadoBusqueda.length - 1, 0, indice)) {
                        String clave = resultadoBusqueda[indice];

                        Lista antepasados = arbolGenealogico.getArbol().antepasados(arbolGenealogico.getArbol().buscar(clave));

                        System.setProperty("org.graphstream.ui", "swing");
                        MostrarAntepasados mostrar = new MostrarAntepasados(antepasados);
                        mostrar.setVisible(true);

                        this.dispose();
                        for (int i = 0; i < antepasados.getSize(); i++) {
                            Persona persona = (Persona) antepasados.getValor(i);
                            System.out.println(persona.toString() + "\n");
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "El numero esta fuera del indice");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un numero.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El input no puede estar vacio");
            }
        }
    }//GEN-LAST:event_mostrarAntepasadosActionPerformed

    private void inputIndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputIndexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputIndexActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        Menu menu = new Menu();
        this.dispose();
    }//GEN-LAST:event_volverActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Antepasados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Antepasados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Antepasados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Antepasados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Antepasados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscar;
    private javax.swing.JTextField inputIndex;
    private javax.swing.JTextField inputNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton mostrarAntepasados;
    private javax.swing.JTextArea resultadosBusqueda;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
