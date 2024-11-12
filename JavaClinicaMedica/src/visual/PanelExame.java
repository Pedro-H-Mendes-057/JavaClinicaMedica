package visual;
import dialogCadastroPanels.DialogCadastroExames;
import dialogCadastroPanels.DialogCadastroPaciente;
import dialogCadastroPanels.DialogReagendarExame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelExame extends TemplatePanel {

    public PanelExame() {
        super();
        
        getLabelPesquisar().setText("Pesquisar por Exame:");
    }
    
    @Override
    public JTable getTable() {
        if (this.table == null) {
            String[] colunas = {"NOME DO PACIENTE", "TIPO DE EXAME", "VALOR", "DESCRICAO"};
            DefaultTableModel model = new DefaultTableModel(10, colunas.length);
            model.setColumnIdentifiers(colunas);
            this.table = new JTable(model);
        }
        return this.table;
    }
    
}