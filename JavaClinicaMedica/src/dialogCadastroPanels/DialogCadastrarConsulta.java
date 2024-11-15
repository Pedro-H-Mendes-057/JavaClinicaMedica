/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dialogCadastroPanels;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author fonfon
 */
public class DialogCadastrarConsulta extends JDialog {
    private JLabel labelNomePaciente;
    private JTextField textFieldNomePaciente;
    private JButton buttonBuscarPaciente;
    private JLabel labelNomeMedico;
    private JTextField textFieldNomeMedico;
    private JButton buttonBuscarMedico;
    private JButton buttonSalvar;
    private JButton buttonCancelar;    
    private String[] horarios = { "08:00", "09:00", "10:00", "11:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00" };
    
    
    public DialogCadastrarConsulta(JFrame parent) {
        super(parent, "Cadastrar Consulta", true);
        this.setSize(1350, 650);
        this.setResizable(false);
        this.setLocationRelativeTo(parent);         
        this.setLayout(null);
        this.add(getLabelNomePaciente()); 
        this.add(getTextFieldNomePaciente());
        this.add(getButtonBuscarPaciente());
        this.add(getLabelNomeMedico()); 
        this.add(getTextFieldNomeMedico());
        this.add(getButtonBuscarMedico());
        this.setVisible(true);
    }
    
    JLabel getLabelNomePaciente() {
        if (this.labelNomePaciente == null) {
            this.labelNomePaciente = new JLabel();
            this.labelNomePaciente.setText("Paciente"); 
            this.labelNomePaciente.setFont(new Font("Tahoma", Font.PLAIN, 20));
            this.labelNomePaciente.setBounds(43, 44, 452, 29);
        }
        return this.labelNomePaciente;
    }
    
    public JTextField getTextFieldNomePaciente() {
        if (this.textFieldNomePaciente == null) {
            this.textFieldNomePaciente = new JTextField();
            this.textFieldNomePaciente.setBounds(43, 83, 450, 40);
            this.textFieldNomePaciente.setEditable(false);
        }
        return this.textFieldNomePaciente;
    }
    
    public JButton getButtonBuscarPaciente() {
        if (this.buttonBuscarPaciente == null) {
            this.buttonBuscarPaciente = new JButton("BUSCAR");
            this.buttonBuscarPaciente.setFont(new Font("Tahoma", Font.PLAIN, 20));            
            this.buttonBuscarPaciente.setBounds(493, 83, 150, 40);
           
        }
        return this.buttonBuscarPaciente;
    }
    
    JLabel getLabelNomeMedico() {
        if (this.labelNomeMedico == null) {
            this.labelNomeMedico = new JLabel();
            this.labelNomeMedico.setText("Médico"); 
            this.labelNomeMedico.setFont(new Font("Tahoma", Font.PLAIN, 20));
            this.labelNomeMedico.setBounds(700, 44, 452, 29);
        }
        return this.labelNomeMedico;
    }
    
    public JTextField getTextFieldNomeMedico() {
        if (this.textFieldNomeMedico == null) {
            this.textFieldNomeMedico = new JTextField();
            this.textFieldNomeMedico.setBounds(700, 83, 450, 40);
            this.textFieldNomeMedico.setEditable(false);
        }
        return this.textFieldNomeMedico;
    }
    
    public JButton getButtonBuscarMedico() {
        if (this.buttonBuscarMedico == null) {
            this.buttonBuscarMedico = new JButton("BUSCAR");
            this.buttonBuscarMedico.setFont(new Font("Tahoma", Font.PLAIN, 20));            
            this.buttonBuscarMedico.setBounds(1150, 83, 150, 40);
           
        }
        return this.buttonBuscarMedico;
    }
    
    
}
