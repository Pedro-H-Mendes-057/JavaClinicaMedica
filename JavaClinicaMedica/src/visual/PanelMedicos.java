package visual;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;


public class PanelMedicos extends TemplatePanel {
    
    public PanelMedicos() {
        super();
        
        getLabelPesquisar().setText("Pesquisar por Médico:");
    }
    
    @Override
    public JTable getTable() {
        if (this.table == null) {
            String[] colunas = {"CRM", "NOME", "ESPECIALIDADE ","VALOR DA CONSULTA", "CONTATO"};
            DefaultTableModel model = new DefaultTableModel(10, colunas.length);
            model.setColumnIdentifiers(colunas);
            this.table = new JTable(model);
        }
        return this.table;
    }
    
}
