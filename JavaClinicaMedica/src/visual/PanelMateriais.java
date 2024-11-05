package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PanelMateriais extends JPanel {
    JLabel labelPesquisar;
    JTextField textFieldPesquisar;
    JButton buttonPesquisar;    
    JTable tableMateriais;
    JButton buttonNovo;
    JButton buttonEditar;
    JButton buttonCancelar;   
    GridBagConstraints gbc;
    JPanel panelBotoes;
    JPanel panelPesquisar;
    JScrollPane jscrollPaneMateriais;
   
    
    public PanelMateriais(JFrame frame) {
        
        setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(50, 200, 5, 200);
        
        gbc.gridx = 0;
        gbc.gridy = 0;       
        gbc.weighty = 0.1;
        gbc.weightx = 0.1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.fill = GridBagConstraints.BOTH;   
  
        this.add(getPanelPesquisar(), gbc);
        
       
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(getJScrollPaneMateriais(), gbc);
        
        gbc.insets = new Insets(25, 200, 5, 200);
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 3; 
        gbc.weighty = 1;
        this.add(getPanelBotoes(), gbc); 
        
    }    
    
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
            this.labelPesquisar.setText("Pesquisar por material:");            
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
    
    public JTable getTableMateriais() {
        if (this.tableMateriais == null) {
            String [] colunas = {"NOME", "QTD ESTOQUE", "QTD MÍNIMA ","PREÇO", "FORNECEDOR"};
            int numLinhas = 0;
            DefaultTableModel model = new DefaultTableModel(numLinhas, colunas.length);
            model.setColumnIdentifiers(colunas);
            this.tableMateriais = new JTable(model);
        }
        
        return this.tableMateriais;
    }
    
    public JScrollPane getJScrollPaneMateriais() {
        if (this.jscrollPaneMateriais == null) {
            this.jscrollPaneMateriais = new JScrollPane(getTableMateriais());
           
        }
        return this.jscrollPaneMateriais;
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
    
    public boolean getMessageDialogCancelarItem(PanelMateriais panelMateriais) {
        int resposta = JOptionPane.showConfirmDialog(panelMateriais, "Tem certeza que deseja apagar este item?");
        
        if (resposta == JOptionPane.YES_OPTION){  
            return true;  
        } else {
            return false;
        }  
    }
}

