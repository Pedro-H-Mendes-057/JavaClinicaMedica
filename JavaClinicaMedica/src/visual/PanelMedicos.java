package visual;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;


public class PanelMedicos extends TemplatePanel {
    /*JLabel labelPesquisar;
    JTextField textFieldPesquisar;
    JButton buttonPesquisar;    
    JScrollPane tableMedicos;
    JButton buttonNovo;
    JButton buttonEditar;
    JButton buttonCancelar;   
    GridBagConstraints gbc;
    JPanel panelBotoes;
    JPanel panelPesquisar;
   */
    
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
    /*
    public JPanel getPanelPesquisar() {
        if (this.panelPesquisar == null) {
            this.panelPesquisar = new JPanel();
            this.panelPesquisar.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            
            c.gridx = 0;
            c.gridy = 0;
            c.weighty = 0.6;
            this.panelPesquisar.add(getLabelPesquisar(), c);
            c.weightx = 0.5;
            c.weighty = 0.4;
            c.gridx = 0;
            c.gridy = 1;
            c.gridwidth = 2;
            c.gridheight = 1;
            c.fill = GridBagConstraints.BOTH;
           
            this.panelPesquisar.add(getTextFieldPesquisar(), c);
            c.weightx = 0;            
            c.gridx = 7;
            c.gridy = 1;
            c.gridwidth = 1;
            c.fill = GridBagConstraints.VERTICAL;
            this.panelPesquisar.add(getButtonPesquisar(), c);
        }
    
        return this.panelPesquisar;
    }
       
    JLabel getLabelPesquisar() {
        if (this.labelPesquisar == null) {
            this.labelPesquisar = new JLabel();
            this.labelPesquisar.setText("Pesquisar por médico:");            
        }
        
        return this.labelPesquisar;
    }
    
    public JTextField getTextFieldPesquisar() {
        if (this.textFieldPesquisar == null) {
            this.textFieldPesquisar = new JTextField();           
        }
        return this.textFieldPesquisar;
    }
    
    public JButton getButtonPesquisar() {
        if (this.buttonPesquisar == null) {
            this.buttonPesquisar = new JButton("PESQUISAR");
           
        }
        return this.buttonPesquisar;
    }
    
    public JPanel getPanelBotoes() {
        if (this.panelBotoes == null) {
            this.panelBotoes = new JPanel();
            this.panelBotoes.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            
            c.insets = new Insets(0, 0, 0, 10);           
            c.ipady = 10;
            this.panelBotoes.add(getButtonNovo(), c);
            this.panelBotoes.add(getButtonEditar(), c);
            this.panelBotoes.add(getButtonCancelar(), c);
        }
    
        return this.panelBotoes;
    }
    
    public JScrollPane getTextTableMedicos() {
        if (this.tableMedicos == null) {
            String [] colunas = {"CRM", "NOME", "ESPECIALIDADE ","VALOR DA CONSULTA", "CONTATO"};
            int numLinhas = 1;
            DefaultTableModel model = new DefaultTableModel(numLinhas, colunas.length);
            model.setColumnIdentifiers(colunas);
            this.tableMedicos =new JScrollPane(new JTable(model));
           
        }
        return this.tableMedicos;
    }
    
    public JButton getButtonNovo() {
        if (this.buttonNovo == null) {
            this.buttonNovo = new JButton("NOVO");
            this.buttonNovo.setBackground(new Color(50, 205, 101));
            this.buttonNovo.setForeground(new Color(255, 255, 255));
            
        }
        return this.buttonNovo;
    }
    
    public JButton getButtonEditar() {
        if (this.buttonEditar == null) {
            this.buttonEditar = new JButton("EDITAR");
           
        }
        return this.buttonEditar;
    }
    
    public JButton getButtonCancelar() {
        if (this.buttonCancelar == null) {
            this.buttonCancelar = new JButton("CANCELAR");
            this.buttonCancelar.setBackground(new Color(244, 0, 9));
            this.buttonCancelar.setForeground(new Color(255, 255, 255));
           
        }
        return this.buttonCancelar;
    }
    
    public boolean getMessageDialogCancelarItem(PanelMedicos panelMedicos) {
        int resposta = JOptionPane.showConfirmDialog(panelMedicos, "Tem certeza que deseja apagar este item?");
        
        if (resposta == JOptionPane.YES_OPTION){  
            return true;  
        } else {
            return false;
        }  
    }*/
}
