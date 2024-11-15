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
            String[] colunas = {"NOME", "ESPECIALIDADE", "CRM","CONTATO", "VALOR DO ATENDIMENTO"};
            DefaultTableModel model = new DefaultTableModel(0, colunas.length);
            model.setColumnIdentifiers(colunas);
            this.table = new JTable(model);
            this.table.setDefaultEditor(Object.class, null);
        }
        return this.table;
    }
    
}
