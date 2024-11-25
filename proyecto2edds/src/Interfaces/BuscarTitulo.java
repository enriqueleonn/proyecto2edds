/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import EDD.Lista;
import Funciones.Validar;
import static Interfaces.Inicio.arbolGenealogico;
import javax.swing.JOptionPane;
import proyecto2edds.Persona;

/**
 *
 * @author Enrique León
 */
public class BuscarTitulo extends javax.swing.JFrame {

    private Validar validar = new Validar();
    private String[] resultadoBusqueda;

    public BuscarTitulo() {
        initComponents();
        this.setVisible(true);
        this.setResizable(false);
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
        inputTitulo = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultadosStr = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        inputIndice = new javax.swing.JTextField();
        volver = new javax.swing.JButton();
        verDetalles = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Buscar por Título");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));
        jPanel1.add(inputTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 320, -1));

        buscar.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        jPanel1.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, -1, -1));

        resultadosStr.setColumns(20);
        resultadosStr.setRows(5);
        jScrollPane1.setViewportView(resultadosStr);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 300, 130));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel2.setText("Ingrese el número asociado a la persona para ver más detalles:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));
        jPanel1.add(inputIndice, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 360, -1));

        volver.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        volver.setText("Volver");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        jPanel1.add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 380, -1, -1));

        verDetalles.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        verDetalles.setText("Ver detalles");
        verDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verDetallesActionPerformed(evt);
            }
        });
        jPanel1.add(verDetalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        if (!inputTitulo.getText().isEmpty()) {
            String titulo = inputTitulo.getText();
            Lista resultados = arbolGenealogico.getHashTable().buscarTitulo(titulo);

            if (!resultados.isEmpty()) {
                String[] nombresTitulo = new String[resultados.getSize()];

                for (int i = 0; i < resultados.getSize(); i++) {
                    Persona persona = (Persona) resultados.getValor(i);
                    if (persona.getMote() != null) {
                        nombresTitulo[i] = persona.getMote();
                    } else {
                        nombresTitulo[i] = persona.getNombre() + " " + persona.getNumeral();
                    }
                }

                resultadoBusqueda = nombresTitulo;

                String resultado = "";

                for (int i = 0; i < nombresTitulo.length; i++) {
                    int indice = i + 1;
                    resultado += indice + ": " + nombresTitulo[i] + "\n";
                }

                resultadosStr.setText(resultado);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron coincidencia con el titulo buscado.");
            }

        } else {
            JOptionPane.showMessageDialog(null, "El input no puede estar vacio");
        }
    }//GEN-LAST:event_buscarActionPerformed

    private void verDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verDetallesActionPerformed
       if (resultadoBusqueda != null || resultadoBusqueda[0] != null) {
            if (!inputIndice.getText().isEmpty() && !"".equals(inputIndice.getText())) {
                String indiceStr = inputIndice.getText();
                if (validar.ValidarNumeros(indiceStr) != -1) {
                    int indice = validar.ValidarNumeros(indiceStr) - 1;
                    if (validar.validarIndice(resultadoBusqueda.length - 1, 0, indice)) {
                        String clave = resultadoBusqueda[indice];
                        JOptionPane.showMessageDialog(null, arbolGenealogico.getHashTable().buscar(clave));
                    } else {
                        JOptionPane.showMessageDialog(null, "El numero esta fuera del indice");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un numero.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El input no puede estar vacio");
            }
        }else{
            JOptionPane.showMessageDialog(null, "No hay resultados para ver detalles");
        }
                            
    }//GEN-LAST:event_verDetallesActionPerformed

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
            java.util.logging.Logger.getLogger(BuscarTitulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarTitulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarTitulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarTitulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarTitulo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscar;
    private javax.swing.JTextField inputIndice;
    private javax.swing.JTextField inputTitulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea resultadosStr;
    private javax.swing.JButton verDetalles;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
