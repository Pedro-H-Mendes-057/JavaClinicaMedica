package visual;
import dialogCadastroPanels.DialogCadastrarExames;
import dialogCadastroPanels.DialogCadastrarPaciente;
import dialogCadastroPanels.DialogReagendarExames;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelExames extends TemplatePanel {

    public PanelExames() {
        super();
         
       
        getLabelPesquisar().setText("Pesquisar por Exame:");
        getBTNNovo().setEnabled(true);
        getBTNEditar().setEnabled(false);
        getBTNExcluir().setEnabled(false);
    }
    
    @Override
    public JTable getTable() {
        if (this.table == null) {
            String[] colunas = {"NOME DO EXAME", "TIPO DE EXAME", "VALOR", "DESCRICAO", "MEDICO"};
            DefaultTableModel model = new DefaultTableModel(0, colunas.length);
            model.setColumnIdentifiers(colunas);
            this.table = new JTable(model);
            this.table.setDefaultEditor(Object.class, null);
        }
        return this.table;
    }
    
}