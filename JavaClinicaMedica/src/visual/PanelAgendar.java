package visual;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;


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
    
    
}
