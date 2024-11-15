/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dialogCadastroPanels;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fonfon
 */
public class DialogBuscarMedico extends JDialog {
    JTable buscarMedicos;
    JScrollPane jscrollPane;
    JButton buttonSelecionarMedico;
    
    public DialogBuscarMedico(JFrame parent) {
        super(parent, "Buscar Médico", true);        
        
    }
    
     public JScrollPane getJScrollPane() {
        if (this.jscrollPane == null) {
            this.jscrollPane = new JScrollPane(getTable());
        }
        return this.jscrollPane;
    }

    public JTable getTable() {
        if (this.buscarMedicos == null) {
            String[] colunas = {"NOME", "CRM"};
            DefaultTableModel model = new DefaultTableModel(0, colunas.length);
            model.setColumnIdentifiers(colunas);
            this.buscarMedicos = new JTable(model) {
                @Override 
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };            
        }
        return this.buscarMedicos;
    }
    
    public JButton getBTNNovaConsulta() {
        if (this.buttonSelecionarMedico == null) {
            this.buttonSelecionarMedico = new JButton("SELECIONAR");
            this.buttonSelecionarMedico.setBackground(new Color(50, 205, 101));
            this.buttonSelecionarMedico.setForeground(Color.WHITE);
        }
        return this.buttonSelecionarMedico;
    }
}
