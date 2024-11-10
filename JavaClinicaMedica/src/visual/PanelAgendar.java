package visual;

import java.awt.Color;
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
}
