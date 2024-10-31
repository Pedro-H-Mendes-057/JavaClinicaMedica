package visual;
import dialogCadastroPanels.DialogCadastroExames;
import dialogCadastroPanels.DialogCadastroPaciente;
import dialogCadastroPanels.DialogReagendarExame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelExame extends JPanel {
    private JTextField textFieldPesquisar;
    private JLabel labelPesquisar;
    private JScrollPane tableExames;
    private JButton btNovo;
    private JButton btReagendar;
    private JButton btCancelar;
    private JButton btPesquisar;   
    private JPanel panelPesquisar;
    private JPanel panelBotoes;
    GridBagConstraints gbc;
    private JFrame frame;

    public PanelExame(JFrame frame) {
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
        this.add(getTextTableMedicos(), gbc);
        
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
            this.labelPesquisar.setText("Pesquisar por exame:");            
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
            this.panelBotoes.add(getButtonReagendar(), c);
            this.panelBotoes.add(getButtonCancelar(), c);
        }
        return this.panelBotoes;
    }
    
    public JScrollPane getTextTableMedicos() {
        if (this.tableExames == null) {
            String [] colunas = {"NOME", "TIPO", "VALOR", "DESCRICAO"};
            int numLinhas = 1;
            DefaultTableModel model = new DefaultTableModel(numLinhas, colunas.length);
            model.setColumnIdentifiers(colunas);
            this.tableExames =new JScrollPane(new JTable(model));
        }
        return this.tableExames;
    }
    
    public JButton getButtonNovo() {
        if (this.btNovo == null) {
            this.btNovo = new JButton("NOVO");
            this.btNovo.setBackground(new Color(50, 205, 101));
            this.btNovo.setForeground(new Color(255, 255, 255));
            this.btNovo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new DialogCadastroExames(frame).setVisible(true);
                }
            });
        }
        return this.btNovo;
    }
    
    public JButton getButtonReagendar() {
        if (this.btReagendar == null) {
            this.btReagendar = new JButton("REAGENDAR");
            this.btReagendar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new DialogReagendarExame(frame).setVisible(true);
                }
            });
        }
        return this.btReagendar;
    }
    
    public JButton getButtonCancelar() {
        if (this.btCancelar == null) {
            this.btCancelar = new JButton("CANCELAR");
            this.btCancelar.setBackground(new Color(244, 0, 9));
            this.btCancelar.setForeground(new Color(255, 255, 255));
        }
        return this.btCancelar;
    }
}