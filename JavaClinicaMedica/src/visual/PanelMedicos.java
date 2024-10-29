package visual;

import javax.swing.*;
import java.awt.*;

public class PanelMedicos extends JPanel {
    JTextField textFieldPesquisar;
    JButton buttonPesquisar;
    JPanel panelPesquisar;
    JTable tableMedicos;
    JButton buttonNovo;
    JButton buttonEditar;
    JButton buttonCancelar;
    JPanel panelBotoes;
    GridBagConstraints gbc; 
    
    public PanelMedicos(JFrame frame) {
        setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(50, 100, 5, 5);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        this.add(getPanelPesquisar(), gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(getTextTableMedicos(), gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;       
        this.add(getPanelBotoes(), gbc);
    }
    
    public JPanel getPanelPesquisar() {
        if (this.panelPesquisar == null) {
            this.panelPesquisar = new JPanel();
            this.panelPesquisar.setLayout(new GridBagLayout());
            GridBagConstraints elems = new GridBagConstraints();
            
            elems.gridx = 0;
            elems.gridy = 0;
            elems.weightx = 1;
            elems.fill = GridBagConstraints.HORIZONTAL;
            //elems.anchor = GridBagConstraints.FIRST_LINE_START;
            this.panelPesquisar.add(getTextFieldPesquisar(), elems);
            
            elems.gridx = 1;
            elems.gridy = 0;
            //elems.anchor = GridBagConstraints.FIRST_LINE_END;
            this.panelPesquisar.add(getButtonPesquisar(), elems);
        }
    
        return this.panelPesquisar;
    }
    
    public JPanel getPanelBotoes() {
        if (this.panelBotoes == null) {
            this.panelBotoes = new JPanel();
            this.panelBotoes.add(getButtonNovo());
            this.panelBotoes.add(getButtonEditar());
            this.panelBotoes.add(getButtonCancelar());
        }
    
        return this.panelBotoes;
    }
    
    public JTextField getTextFieldPesquisar() {
        if (this.textFieldPesquisar == null) {
            this.textFieldPesquisar = new JTextField();           
            this.textFieldPesquisar.setPreferredSize(new Dimension(800, 40));
            
        }
        return this.textFieldPesquisar;
    }
    
    public JButton getButtonPesquisar() {
        if (this.buttonPesquisar == null) {
            this.buttonPesquisar = new JButton("PESQUISAR");
            this.buttonPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        }
        return this.buttonPesquisar;
    }
    
    public JTable getTextTableMedicos() {
        if (this.tableMedicos == null) {
            this.tableMedicos = new JTable();
           
        }
        return this.tableMedicos;
    }
    
    public JButton getButtonNovo() {
        if (this.buttonNovo == null) {
            this.buttonNovo = new JButton("NOVO");
            this.buttonNovo.setBackground(new Color(0, 128, 255));
            this.buttonNovo.setForeground(new Color(255, 255, 255));
            this.buttonNovo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        }
        return this.buttonNovo;
    }
    
    public JButton getButtonEditar() {
        if (this.buttonEditar == null) {
            this.buttonEditar = new JButton("EDITAR");
            this.buttonEditar.setFont(new Font("Tahoma", Font.PLAIN, 20));
            this.buttonEditar.setBounds(345, 639, 151, 39);
        }
        return this.buttonEditar;
    }
    
    public JButton getButtonCancelar() {
        if (this.buttonCancelar == null) {
            this.buttonCancelar = new JButton("CANCELAR");
            this.buttonCancelar.setBackground(new Color(253, 2, 90));
            this.buttonCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
            this.buttonCancelar.setBounds(506, 639, 151, 39);
           
        }
        return this.buttonCancelar;
    }
}
