/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ec.edu.monster.vista;

import ec.edu.monster.controlador.TicketController;
import ec.edu.monster.ws.Localidad;
import ec.edu.monster.ws.Ticket;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

/**
 *
 * @author Jhonatan
 */
public class ConfirmacionCompra extends javax.swing.JFrame {
    private SpinnerNumberModel modelos;
    private int index;
    private int cantTribuna;
    private int cantPalco;
    private int cantGeneral;
    private int cantGeneralVisitante;
    private double precioSinIva;
    private double precioConIva;
    private double iva;
    private List<Integer> cantidades;

    public ConfirmacionCompra(int index, int cantTribuna, int cantPalco, int cantGeneral, int cantGeneralVisitante) {
        this.index = index;
        this.cantTribuna = cantTribuna;
        this.cantPalco = cantPalco;
        this.cantGeneral = cantGeneral;
        this.cantGeneralVisitante = cantGeneralVisitante;
    }
    
    private List<Ticket> listaTk;
    private List<Localidad> listaLc;

    /**
     * Creates new form ConfirmacionCompra
     */
    public ConfirmacionCompra() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblConfirmacion = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblValores = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CONFIRMACIÓN DE COMPRA");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("CONFIRMACIÓN DE COMPRA");

        tblConfirmacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cantidad", "Descripción", "V. Unitario", "V. Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblConfirmacion);

        tblValores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Subtotal", "IVA 12%", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblValores);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Pagar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        jLabel2.setText("Detalle a pagar: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(201, 201, 201))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ConsultaView consulta = new ConsultaView();
        consulta.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            TicketController controller = new TicketController();
            List<Ticket> lista = controller.traerPartidos();
            Ticket tk = lista.get(index);
            controller.registroCompra("-", "-", "-", cantidades.get(1), cantidades.get(0),
                    cantidades.get(2), cantidades.get(3), iva, tk.getCodigoPartido());
            JOptionPane.showMessageDialog(null,"Se registró el pago con éxito","Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println("Error al registrar el pago " + e);
            JOptionPane.showMessageDialog(null, "Error al registrar el pago", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ConfirmacionCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfirmacionCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfirmacionCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfirmacionCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConfirmacionCompra().setVisible(true);
             }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblConfirmacion;
    private javax.swing.JTable tblValores;
    // End of variables declaration//GEN-END:variables

    public void setTabla(){
        TicketController controller = new TicketController();
        setListaTk(controller.traerPartidos());
        Ticket tk = getListaTk().get(getIndex());
        setListaLc(controller.traerLocalidades(tk.getCodigoPartido()));
        DefaultTableModel tabla = (DefaultTableModel) tblConfirmacion.getModel();
        tblConfirmacion.setRowHeight(30);
        tabla.setRowCount(0);
        double aux = 0;
        modelos = new SpinnerNumberModel(0, 0, 100, 1);
        for (int i = 0; i < getListaLc().size(); i++) {
            Localidad lc = getListaLc().get(i);
            int cantidad = cantidades.get(i);
            aux = aux + (lc.getPrecioLocalidad() * cantidad);
            Object[] rowData = {
                cantidad, lc.getNombreLocalidad(), lc.getPrecioLocalidad(), lc.getPrecioLocalidad() * cantidad
            };
            TableColumn columna = tblConfirmacion.getColumnModel().getColumn(0);
            columna.setCellEditor(new SpinnerEditor(modelos));
            tabla.addRow(rowData);
            
        }
        setPrecioSinIva(aux);
        setIva((precioSinIva * 0.12));
        setPrecioConIva((precioSinIva * 0.12) + precioSinIva);
        System.out.println("-Precio sin IVA: " + getPrecioSinIva() + " -IVA 12%: " + getIva() +" -Precio con IVA: " + getPrecioConIva());
        DefaultTableModel tablaValores = (DefaultTableModel) tblValores.getModel();
        tablaValores.setRowCount(0);
        Object[] rowData = {
            getPrecioSinIva(), getIva(), getPrecioConIva()
        };
        tablaValores.addRow(rowData);
    }
    private class SpinnerEditor extends AbstractCellEditor implements TableCellEditor {
        private JSpinner spinner;

        public SpinnerEditor(SpinnerNumberModel modelo) {
            spinner = new JSpinner(modelo);
            spinner.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    // Actualizar el valor en el modelo de la tabla cuando se cambie el valor del spinner
                    stopCellEditing();
                }
            });
        }

        @Override
        public Object getCellEditorValue() {
            return spinner.getValue();
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            spinner.setValue(value);
            return spinner;
        }
    }
    
    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * @return the cantTribuna
     */
    public int getCantTribuna() {
        return cantTribuna;
    }

    /**
     * @param cantTribuna the cantTribuna to set
     */
    public void setCantTribuna(int cantTribuna) {
        this.cantTribuna = cantTribuna;
    }

    /**
     * @return the cantPalco
     */
    public int getCantPalco() {
        return cantPalco;
    }

    /**
     * @param cantPalco the cantPalco to set
     */
    public void setCantPalco(int cantPalco) {
        this.cantPalco = cantPalco;
    }

    /**
     * @return the cantGeneral
     */
    public int getCantGeneral() {
        return cantGeneral;
    }

    /**
     * @param cantGeneral the cantGeneral to set
     */
    public void setCantGeneral(int cantGeneral) {
        this.cantGeneral = cantGeneral;
    }

    /**
     * @return the cantGeneralVisitante
     */
    public int getCantGeneralVisitante() {
        return cantGeneralVisitante;
    }

    /**
     * @param cantGeneralVisitante the cantGeneralVisitante to set
     */
    public void setCantGeneralVisitante(int cantGeneralVisitante) {
        this.cantGeneralVisitante = cantGeneralVisitante;
    }

    /**
     * @return the precioSinIva
     */
    public double getPrecioSinIva() {
        return precioSinIva;
    }

    /**
     * @param precioSinIva the precioSinIva to set
     */
    public void setPrecioSinIva(double precioSinIva) {
        this.precioSinIva = precioSinIva;
    }

    /**
     * @return the precioConIva
     */
    public double getPrecioConIva() {
        return precioConIva;
    }

    /**
     * @param precioConIva the precioConIva to set
     */
    public void setPrecioConIva(double precioConIva) {
        this.precioConIva = precioConIva;
    }

    /**
     * @return the iva
     */
    public double getIva() {
        return iva;
    }

    /**
     * @param iva the iva to set
     */
    public void setIva(double iva) {
        this.iva = iva;
    }

    /**
     * @return the cantidades
     */
    public List<Integer> getCantidades() {
        return cantidades;
    }

    /**
     * @param cantidades the cantidades to set
     */
    public void setCantidades(List<Integer> cantidades) {
        this.cantidades = cantidades;
    }

    /**
     * @return the listaTk
     */
    public List<Ticket> getListaTk() {
        return listaTk;
    }

    /**
     * @param listaTk the listaTk to set
     */
    public void setListaTk(List<Ticket> listaTk) {
        this.listaTk = listaTk;
    }

    /**
     * @return the listaLc
     */
    public List<Localidad> getListaLc() {
        return listaLc;
    }

    /**
     * @param listaLc the listaLc to set
     */
    public void setListaLc(List<Localidad> listaLc) {
        this.listaLc = listaLc;
    }
}
