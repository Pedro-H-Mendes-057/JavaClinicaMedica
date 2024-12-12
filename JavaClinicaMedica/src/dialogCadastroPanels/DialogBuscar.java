/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dialogCadastroPanels;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fonfon
 */
public class DialogBuscar extends JDialog {
    JTable buscar;
    JScrollPane jscrollPane;
    
    public DialogBuscar(JFrame parent) {
        super(parent, "Buscar", true);        
        this.setSize(1000, 650);
        this.setResizable(false);
        this.setLocationRelativeTo(parent);        
        this.setLayout(new GridBagLayout());       
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx=1;
        constraints.weighty=1;
        constraints.fill=GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10,5,10,5); // espaçamentos entre as células
        
        constraints.gridx=0; // coluna 0
        constraints.gridy=0; // linha 0
        this.add(getJScrollPane(), constraints);        
        
        pack();
    }
    
    public DialogBuscar(JDialog parent) {
        super(parent, "Buscar", true);        
        this.setSize(1000, 650);
        this.setResizable(false);
        this.setLocationRelativeTo(parent);        
        this.setLayout(new GridBagLayout());       
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx=1;
        constraints.weighty=1;
        constraints.fill=GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10,5,10,5); // espaçamentos entre as células
        
        constraints.gridx=0; // coluna 0
        constraints.gridy=0; // linha 0
        this.add(getJScrollPane(), constraints);        
        
        pack();
    }
    
     public JScrollPane getJScrollPane() {
        if (this.jscrollPane == null) {
            this.jscrollPane = new JScrollPane(getTable());
        }
        return this.jscrollPane;
    }

    public JTable getTable() {
        if (this.buscar == null) {
            String[] colunas = {"NOME", "CHAVE"}; // a coluna CHAVE guarda a chave do objeto 
            DefaultTableModel model = new DefaultTableModel(0, colunas.length);
            model.setColumnIdentifiers(colunas);
            this.buscar = new JTable(model) {
                @Override 
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };            
        }
        return this.buscar;
    }
}
