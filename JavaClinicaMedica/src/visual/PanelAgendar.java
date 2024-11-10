package visual;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelAgendar extends TemplatePanel {
   
    private JTable tableAgendar;

    public PanelAgendar(JFrame frame) {
        super();        
        getLabelPesquisar().setText("Pesquisar por paciente:");
    } 

    @Override
    public JTable getTable() {
        if (this.tableAgendar == null) {
            String[] colunas = {"DIA", "HORA", "PACIENTE", "EXAME/CONSULTA", "MEDICO"};            
            DefaultTableModel model = new DefaultTableModel(0, colunas.length);
            model.setColumnIdentifiers(colunas);

            this.tableAgendar = new JTable(model);
            
        }
        return this.tableAgendar;
    }    
    
        
    @Override
    public JButton getBTNEditar() {
        if (this.btnEditar == null) {
            this.btnEditar = new JButton("EDITAR");
            this.btnEditar.setBackground(new Color(100, 149, 237));
            this.btnEditar.setForeground(Color.WHITE);
        }
        return this.btnEditar;
    }
    
    
}// da classe
