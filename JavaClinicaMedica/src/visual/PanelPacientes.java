package visual;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class PanelPacientes extends TemplatePanel {
    
    public PanelPacientes() {
    	super();
    	
    	getLabelPesquisar().setText("Pesquisar por Paciente:");
    	getBTNExcluir().setEnabled(false);
        getBTNExcluir().setVisible(false);
        getBTNEditar().setText("Visualizar");
    }
    
    @Override
    public JTable getTable() {
        if (this.table == null) {
            String[] colunas = {"NOME", "DATA NASC", "CONTATO", "TIPO SANGU.", "CONVENIO"};
            DefaultTableModel model = new DefaultTableModel(0, colunas.length);
            model.setColumnIdentifiers(colunas);
            this.table = new JTable(model);
            this.table.setDefaultEditor(Object.class, null);
        }
        return this.table;
    }
    
    public boolean getMessageDialogCancelarItem(PanelPacientes panelPacientes) {
        int resposta = JOptionPane.showConfirmDialog(panelPacientes, "Tem certeza que deseja apagar este item?");
        
        if (resposta == JOptionPane.YES_OPTION){  
            return true;  
        } else {
            return false;
        } 
    }
}//da classe
