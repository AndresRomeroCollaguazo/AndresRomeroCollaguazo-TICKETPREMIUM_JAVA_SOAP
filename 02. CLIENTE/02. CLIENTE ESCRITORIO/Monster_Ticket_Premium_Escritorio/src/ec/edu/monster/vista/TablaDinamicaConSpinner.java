/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.vista;
import java.awt.Component;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class TablaDinamicaConSpinner extends JFrame {

    private JTable tabla;
    private SpinnerNumberModel modeloSpinner;

    public TablaDinamicaConSpinner() {
        super("Tabla Dinámica con Spinner");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear el modelo de spinner
        modeloSpinner = new SpinnerNumberModel(0, 0, 100, 1);

        // Crear los datos iniciales para la tabla
        Object[][] datos = new Object[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                datos[i][j] = 0;
            }
        }

        // Crear el modelo de tabla
        DefaultTableModel modeloTabla = new DefaultTableModel(datos, new String[]{"Columna 1", "Columna 2", "Columna 3", "Columna 4", "Columna 5"}) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 2) { // Índice de la columna donde se mostrará el spinner
                    return Integer.class;
                }
                return super.getColumnClass(columnIndex);
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 2; // Solo la columna del spinner es editable
            }
        };

        // Crear la tabla
        tabla = new JTable(modeloTabla);

        // Agregar el editor de spinner a la columna específica
        TableColumn columna = tabla.getColumnModel().getColumn(2); // Índice de la columna donde se mostrará el spinner
        columna.setCellEditor(new SpinnerEditor(modeloSpinner));

        // Utilizar un TableCellRenderer personalizado para mostrar el valor como texto en las demás columnas
        tabla.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (column != 2) { // Si no es la columna del spinner
                    value = value != null ? value.toString() : ""; // Mostrar el valor como texto
                }
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }
        });

        // Agregar la tabla a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(tabla);
        getContentPane().add(scrollPane);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TablaDinamicaConSpinner().setVisible(true);
            }
        });
    }

    // Clase para el editor de spinner en la tabla
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
}