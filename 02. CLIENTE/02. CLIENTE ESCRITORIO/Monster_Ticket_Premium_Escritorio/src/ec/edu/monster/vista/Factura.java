/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ec.edu.monster.vista;

import ec.edu.monster.controlador.TicketController;
import ec.edu.monster.ws.Localidad;
import ec.edu.monster.ws.Ticket;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jhonatan
 */
public class Factura extends javax.swing.JFrame {

    private int index;
    private double precioConIva;
    private List<Integer> cantidades;
    private String nombre;
    private String cedula;
    private String direccion;
    private double precioSinIva;
    private double iva;
    private List<Ticket> listaTk;
    private List<Localidad> listaLc;
    /**
     * Creates new form Factura
     */
    public Factura() {
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JLabel();
        txtCedula = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblConfirmacion = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblValores = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Factura");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Cédula:");

        jLabel4.setText("Dirección:");

        txtNombre.setText("  ");

        txtCedula.setText("   ");

        txtDireccion.setText("   ");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(105, 105, 105)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDireccion)
                            .addComponent(txtCedula)
                            .addComponent(txtNombre)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCedula))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDireccion))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Factura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblConfirmacion;
    private javax.swing.JTable tblValores;
    private javax.swing.JLabel txtCedula;
    private javax.swing.JLabel txtDireccion;
    private javax.swing.JLabel txtNombre;
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
        for (int i = 0; i < getListaLc().size(); i++) {
            Localidad lc = getListaLc().get(i);
            int cantidad = cantidades.get(i);
            aux = aux + (lc.getPrecioLocalidad() * cantidad);
            Object[] rowData = {
                cantidad, lc.getNombreLocalidad(), lc.getPrecioLocalidad(), lc.getPrecioLocalidad() * cantidad
            };
            tabla.addRow(rowData);
            
        }
        setPrecioSinIva(aux);
        setIva((getPrecioSinIva() * 0.12));
        setPrecioConIva((getPrecioSinIva() * 0.12) + getPrecioSinIva());
        System.out.println("-Precio sin IVA: " + getPrecioSinIva() + " -IVA 12%: " + getIva() +" -Precio con IVA: " + getPrecioConIva());
        DefaultTableModel tablaValores = (DefaultTableModel) tblValores.getModel();
        tablaValores.setRowCount(0);
        Object[] rowData = {
            getPrecioSinIva(), getIva(), getPrecioConIva()
        };
        
        tablaValores.addRow(rowData);
        
        txtNombre.setText(getNombre());
        txtCedula.setText(getCedula());
        txtDireccion.setText(getDireccion());
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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
