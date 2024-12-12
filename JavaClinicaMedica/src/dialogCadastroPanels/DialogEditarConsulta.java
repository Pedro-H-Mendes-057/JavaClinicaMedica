/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dialogCadastroPanels;

import controle.DateLabelFormatter;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;


/**
 *
 * @author fonfon
 */
public class DialogEditarConsulta extends JDialog {
    private JLabel labelNomePaciente;
    private JTextField textFieldNomePaciente;
    private JButton buttonBuscarPaciente;
    private JLabel labelNomeMedico;
    private JTextField textFieldNomeMedico;
    private JButton buttonBuscarMedico;
    private JButton buttonSalvar;
    private JButton buttonCancelar;    
    private JPanel panelPaciente;
    private JLabel labelConvenio;
    private JTextField textFielConvenio;
    private JLabel labelTipoConsulta;
    private JComboBox<String> jComboBoxTipoConsulta;
    private JPanel panelConsultaConvenio;
    private JButton buttonBuscarMateriais;
    private JTable tableBuscarMateriais;
    private JLabel labelAreaQueixa;   
    private JTextArea textAreaQueixa;
    private JLabel labelObservacoes;
    private JTextArea textAreaObservacoes;
    private JScrollPane scrollPaneTable;
    private JPanel panelSalvarCancelar; 
    private JDatePickerImpl datePicker;
    private JComboBox<String> jComboBoxHorario;       
    private JPanel panelDataHorario; 
    private JLabel labelData;
    private JLabel labelHorario;
    private JScrollPane scrollPaneQueixa;
    private JScrollPane scrollPaneObservacoes;
    private JTextField textFieldData;
    
    public DialogEditarConsulta(JFrame parent) {
        super(parent, "Cadastrar Consulta", true);
        this.setSize(1500, 650);
        this.setResizable(false);
        this.setLocationRelativeTo(parent);         
        
        // definicao do layout
        this.setLayout(new GridBagLayout());        
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx=1;
        constraints.weighty=0.1;
        constraints.fill=GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(0, 50,0, 50);
        
        // adição dos componentes na janela
        constraints.gridx=0; // coluna 0
        constraints.gridy=0; // linha 0
        this.add(getLabelNomeMedico(), constraints);
        
        constraints.weighty=0.9;
        constraints.gridx=0; // coluna 0
        constraints.gridy=1; // linha 1
        this.add(getTextFieldNomeMedico(), constraints);
        
        constraints.weighty=0.1;
        constraints.gridx=0; // coluna 0
        constraints.gridy=2; // linha 2
        this.add(getLabelNomePaciente(), constraints);
        
        constraints.weighty=0.9;
        constraints.gridx=0; // coluna 0
        constraints.gridy=3; // linha 3
        this.add(getPanelPaciente(), constraints);
        
        constraints.gridx=0; // coluna 0
        constraints.gridy=4; // linha 4
        this.add(getPanelConsultaConvenio(), constraints);
        
        constraints.gridx=0; // coluna 0
        constraints.gridy=5; // linha 5
        this.add(getPanelDataHorario(), constraints);
        
        constraints.weighty=0.1;
        constraints.gridx=0; // coluna 0
        constraints.gridy=6; // linha 6
        this.add(getLabelAreaQueixa(), constraints);
        
        constraints.fill=GridBagConstraints.BOTH;
        constraints.weighty=1;
        constraints.gridx=0; // coluna 0
        constraints.gridy=7; // linha 7
        this.add(getJScrollPaneQueixa(), constraints);  
               
        constraints.insets = new Insets(20, 50, 0, 50);
        constraints.gridx=0; // coluna 0
        constraints.gridy=8; // linha 8
        constraints.weighty=1;
        this.add(getJScrollPaneTable(), constraints);
        
        constraints.insets = new Insets(0, 50,0, 50);
        constraints.fill=GridBagConstraints.HORIZONTAL;
        constraints.weighty=0.9;
        constraints.gridx=0; // coluna 0
        constraints.gridy=9; // linha 9
        this.add(getButtonBuscarMateriais(), constraints); 
        
        constraints.fill=GridBagConstraints.HORIZONTAL;
        constraints.weighty=0.1;
        constraints.gridx=0; // coluna 0
        constraints.gridy=10; // linha 10
        this.add(getLabelObservacoes(), constraints);
        
        constraints.fill=GridBagConstraints.BOTH;
        constraints.weighty=0.9;
        constraints.gridx=0; // coluna 0
        constraints.gridy=11; // linha 11
        this.add(getJScrollPaneObservacoes(), constraints);
       
        constraints.insets = new Insets(0, 30,0, 0);
        constraints.gridx=0; // coluna 0
        constraints.gridy=12; // linha 12
        this.add(getPanelSalvarCancelar(), constraints);        
        
    }
    
    JLabel getLabelNomePaciente() {
        if (this.labelNomePaciente == null) {
            this.labelNomePaciente = new JLabel();
            this.labelNomePaciente.setText("Paciente");                        
        }
        return this.labelNomePaciente;
    }
    
    public JTextField getTextFieldNomePaciente() {
        if (this.textFieldNomePaciente == null) {
            this.textFieldNomePaciente = new JTextField();            
            this.textFieldNomePaciente.setEditable(false);
        }
        return this.textFieldNomePaciente;
    }
    
    public JButton getButtonBuscarPaciente() {
        if (this.buttonBuscarPaciente == null) {
            this.buttonBuscarPaciente = new JButton("BUSCAR");                 
        }
        return this.buttonBuscarPaciente;
    }
    
    JLabel getLabelNomeMedico() {
        if (this.labelNomeMedico == null) {
            this.labelNomeMedico = new JLabel();
            this.labelNomeMedico.setText("Médico");                        
        }
        return this.labelNomeMedico;
    }
    
    public JTextField getTextFieldNomeMedico() {
        if (this.textFieldNomeMedico == null) {
            this.textFieldNomeMedico = new JTextField();            
            this.textFieldNomeMedico.setEditable(false);
        }
        return this.textFieldNomeMedico;
    }    
    
    public JPanel getPanelPaciente() {
        if (this.panelPaciente == null) {
            this.panelPaciente = new JPanel();
            this.panelPaciente.setLayout(new GridBagLayout());        
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.weightx=1;
            constraints.weighty=1;
            constraints.fill=GridBagConstraints.HORIZONTAL;      
            constraints.gridx=0; // coluna 0
            constraints.gridy=0; // linha 0           
            this.panelPaciente.add(getTextFieldNomePaciente(), constraints);

            constraints.insets = new Insets(0, 50,0, 0);
            constraints.weightx=0.25;
            constraints.gridx=1; // coluna 4
            constraints.gridy=0; // linha 0            
            this.panelPaciente.add(getButtonBuscarPaciente(), constraints);
        } 
        return this.panelPaciente;
    }
    
    public JLabel getLabelConvenio() {
        if (this.labelConvenio == null) {
            this.labelConvenio = new JLabel();
            this.labelConvenio.setText("Convênio");
        }
        return this.labelConvenio;
    }
    

    public JTextField getTextFieldConvenio() {
        if (this.textFielConvenio == null) {
            this.textFielConvenio = new JTextField();            
            this.textFielConvenio.setEditable(false);
        }
        return this.textFielConvenio; 
    }
    

    public JLabel getLabelTipoConsulta() {
        if (this.labelTipoConsulta == null) {
            this.labelTipoConsulta = new JLabel();
            this.labelTipoConsulta.setText("Tipo de Consulta");
        }
        return this.labelTipoConsulta;
    }
    
    public JComboBox<String> getjComboBoxTipoConsulta() {
        if (this.jComboBoxTipoConsulta == null) {
            String[] options = {"Emergencial", "Agendamento"};
            this.jComboBoxTipoConsulta = new JComboBox<>(options);
        }
        
        
        return this.jComboBoxTipoConsulta;
    }    

    public JPanel getPanelConsultaConvenio() {
        if (this.panelConsultaConvenio == null) {
            this.panelConsultaConvenio = new JPanel();
            this.panelConsultaConvenio.setLayout(new GridBagLayout());        
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.weightx=1;
            constraints.weighty=1;
            constraints.fill=GridBagConstraints.HORIZONTAL;        

            constraints.gridx=0; // coluna 0
            constraints.gridy=0; // linha 0           
            this.panelConsultaConvenio.add(getLabelTipoConsulta(), constraints);
           
            constraints.insets = new Insets(0, 50,0,0);
            constraints.gridx=1; // coluna 1
            constraints.gridy=0; // linha 0            
            this.panelConsultaConvenio.add(getLabelConvenio(), constraints);
            
            constraints.insets = new Insets(0, 0,0,0);
            constraints.gridx=0; // coluna 0
            constraints.gridy=1; // linha 1            
            this.panelConsultaConvenio.add(getjComboBoxTipoConsulta(), constraints);
            
            constraints.insets = new Insets(0, 50,0,0);
            constraints.gridx=1; // coluna 1
            constraints.gridy=1; // linha 1 
            this.panelConsultaConvenio.add(getTextFieldConvenio(), constraints);
        } 
        
        return this.panelConsultaConvenio;        
    }
    
    
    public JButton getButtonBuscarMateriais() {
        if (this.buttonBuscarMateriais == null) {
            this.buttonBuscarMateriais = new JButton("BUSCAR MATERIAIS");                     
        }
        return this.buttonBuscarMateriais;   
    }

    public JTable getTableBuscarMateriais() {
        if (this.tableBuscarMateriais == null) { 
            String[] colunas = {"MATERIAL", "QUANTIDADE", "CHAVE"};
            DefaultTableModel model = new DefaultTableModel(0, colunas.length);
            model.setColumnIdentifiers(colunas);
            this.tableBuscarMateriais = new JTable(model) {
                @Override 
                public boolean isCellEditable(int row, int column) {
                    if (column == 1) {
                        return true;
                    }
                    return false;
                }
            };
            this.tableBuscarMateriais.removeColumn(this.tableBuscarMateriais.getColumn("CHAVE"));
        }
        return this.tableBuscarMateriais;        
    }
    
    public JScrollPane getJScrollPaneTable() {
        if (this.scrollPaneTable == null) {
            this.scrollPaneTable = new JScrollPane(getTableBuscarMateriais());
        }
        return this.scrollPaneTable;
    }

    public JScrollPane getJScrollPaneQueixa() {
        if (this.scrollPaneQueixa == null) {
            this.scrollPaneQueixa = new JScrollPane(getTextAreaQueixa());
        }
        return this.scrollPaneQueixa;
    }
    
    public JScrollPane getJScrollPaneObservacoes() {
        if (this.scrollPaneObservacoes == null) {
            this.scrollPaneObservacoes = new JScrollPane(getTextAreaObservacoes());
        }
        return this.scrollPaneObservacoes;
    }
    
    public JTextArea getTextAreaQueixa() {
        if (this.textAreaQueixa == null) {
            this.textAreaQueixa = new JTextArea();           
        }
       
        return this.textAreaQueixa;
    }

    public JTextArea getTextAreaObservacoes() {
        if (this.textAreaObservacoes == null) {
            this.textAreaObservacoes = new JTextArea();           
        }
       
        return this.textAreaObservacoes;
    }
    
    public JLabel getLabelAreaQueixa() {
         if (this.labelAreaQueixa == null) {
            this.labelAreaQueixa = new JLabel();
            this.labelAreaQueixa.setText("Queixa do Paciente");
        }
        return this.labelAreaQueixa;
    }

    public JLabel getLabelObservacoes() {
        if (this.labelObservacoes == null) {
            this.labelObservacoes = new JLabel();
            this.labelObservacoes.setText("Observações");
        }        
        return this.labelObservacoes;
    }
    
    public JButton getButtonSalvar() {
         if (this.buttonSalvar == null) {
            this.buttonSalvar = new JButton("SALVAR");
            this.buttonSalvar.setFont(new Font("Tahoma", Font.PLAIN, 20));          
        }
        return this.buttonSalvar;
    }

    public JButton getButtonCancelar() {
         if (this.buttonCancelar == null) {
            this.buttonCancelar = new JButton("CANCELAR");
            this.buttonCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));          
        }
        return this.buttonCancelar;
    }
    
    
    public JPanel getPanelSalvarCancelar() {
        if (this.panelSalvarCancelar == null) {
            this.panelSalvarCancelar = new JPanel();
            this.panelSalvarCancelar.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));        
                    
            this.panelSalvarCancelar.add(getButtonSalvar());                   
            this.panelSalvarCancelar.add(getButtonCancelar());
        } 
        return this.panelSalvarCancelar;
    }
    
        
    public JTextField getTextFieldData() {
        if (this.textFieldData == null) {
            this.textFieldData = new JTextField();            
            this.textFieldData.setEditable(false);
        }
        return this.textFieldData; 
    }
    
     public JComboBox<String> getjComboBoxHorario() {
        if (this.jComboBoxHorario == null) {
            String[] options = { "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00" };
            this.jComboBoxHorario = new JComboBox<>(options);
        }
                
        return this.jComboBoxHorario;
    }
     
     JLabel getLabelData() {
        if (this.labelData == null) {
            this.labelData = new JLabel();
            this.labelData.setText("Data da consulta");                         
        }
        return this.labelData;
    }
          
    JLabel getLabelHorario() {
        if (this.labelHorario == null) {
            this.labelHorario = new JLabel();
            this.labelHorario.setText("Selecione o horário");                        
        }
        return this.labelHorario;
    }
    
    public JPanel getPanelDataHorario() {
        if (this.panelDataHorario == null) {
            this.panelDataHorario = new JPanel();
            this.panelDataHorario.setLayout(new GridBagLayout());        
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.weightx=1;
            constraints.weighty=1;
            constraints.fill=GridBagConstraints.HORIZONTAL;        

            constraints.gridx=0; // coluna 0
            constraints.gridy=0; // linha 0           
            this.panelDataHorario.add(getLabelData(), constraints);
           
            constraints.insets = new Insets(0, 50,0,0);
            constraints.gridx=1; // coluna 1
            constraints.gridy=0; // linha 0            
            this.panelDataHorario.add(getLabelHorario(), constraints);
            
            constraints.insets = new Insets(0,0,0,0);
            constraints.gridx=0; // coluna 0
            constraints.gridy=1; // linha 1            
            this.panelDataHorario.add(getTextFieldData(), constraints);
            
            constraints.insets = new Insets(0, 50,0,0);
            constraints.gridx=1; // coluna 1
            constraints.gridy=1; // linha 1 
            this.panelDataHorario.add(getjComboBoxHorario(), constraints);
        } 
        
        return this.panelDataHorario;        
    }
}

