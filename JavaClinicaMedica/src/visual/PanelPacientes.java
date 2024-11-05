package visual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import dialogCadastroPanels.DialogCadastroPaciente;
import ctrlRepositorios.controladorCadastroPacientes;

public class PanelPacientes extends JPanel {
    JLabel labelPesquisar;
    JTextField textFieldPesquisar;
    JButton btPesquisar;    
    JTable tablePacientes;
    JScrollPane jscrollPanePacientes;
    JButton btNovo;
    JButton btEditar;
    JButton btCancelar;   
    GridBagConstraints gbc;
    JPanel panelBotoes;
    JPanel panelPesquisar;
    private JFrame frame;
    
    
    public PanelPacientes(JFrame frame) {
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
        this.add(getJScrollPanePacientes(), gbc);
        
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
            this.labelPesquisar.setText("Pesquisar por paciente:");            
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
        if (this.btPesquisar == null) {
            this.btPesquisar = new JButton("PESQUISAR");
           
        }
        return this.btPesquisar;
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
    
    public JTable getTablePacientes() {
        if (this.tablePacientes == null) {
            String[] colunas = {"NOME", "DATA NASC", "CONTATO", "TIPO SANG", "CONVENIO"};
            int numLinhas = 0;
            DefaultTableModel model = new DefaultTableModel(numLinhas, colunas.length);
            model.setColumnIdentifiers(colunas);
            this.tablePacientes = new JTable(model);
        }
        return this.tablePacientes;
    }

    public JScrollPane getJScrollPanePacientes() {
        if (this.jscrollPanePacientes == null) {
            this.jscrollPanePacientes = new JScrollPane(getTablePacientes());
        }
        return this.jscrollPanePacientes;
    }
    
    public JButton getButtonNovo() {
        if (this.btNovo == null) {
            this.btNovo = new JButton("NOVO");
            this.btNovo.setBackground(new Color(50, 205, 101));
            this.btNovo.setForeground(new Color(255, 255, 255));
            this.btNovo.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    controladorCadastroPacientes controlador = new controladorCadastroPacientes();
                    new DialogCadastroPaciente(frame, controlador).setVisible(true);
                }
            });
           
        }
        return this.btNovo;
    }
    
    public JButton getButtonEditar() {
        if (this.btEditar == null) {
            this.btEditar = new JButton("EDITAR");
           
        }
        return this.btEditar;
    }
    
    public JButton getButtonCancelar() {
        if (this.btCancelar == null) {
            this.btCancelar = new JButton("CANCELAR");
            this.btCancelar.setBackground(new Color(244, 0, 9));
            this.btCancelar.setForeground(new Color(255, 255, 255));
           
        }
        return this.btCancelar;
    }
    
    public boolean getMessageDialogCancelarItem(PanelPacientes panelPacientes) {
        int resposta = JOptionPane.showConfirmDialog(panelPacientes, "Tem certeza que deseja apagar este item?");
        
        if (resposta == JOptionPane.YES_OPTION){  
            return true;  
        } else {
            return false;
        }  
    }
    
    
}
