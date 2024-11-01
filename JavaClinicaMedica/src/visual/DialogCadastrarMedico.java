/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visual;

import javax.swing.JDialog;
import javax.swing.JFrame;
import controle.ControladorFrame;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author fonfon
 */
public class DialogCadastrarMedico extends JDialog {
    JLabel labelNome;
    JTextField textFieldNome;
    JLabel labelContato;
    JTextField textFieldContato;
    JLabel labelCRM;
    JTextField textFieldCRM;
    JLabel labelEspecialidade;
    JTextField textFieldEspecialidade;
    JLabel labelValor;
    JTextField textFieldValor;
    
    
    public DialogCadastrarMedico(JFrame parent) {
        super(parent, "Cadastrar Médico", true);
        this.setSize(1300, 650);
        this.setResizable(false);
        this.setLocationRelativeTo(parent);         
        this.setLayout(null);       
        this.add(getLabelNome()); 
        this.add(getTextFieldNome()); 
        this.add(getLabelContato()); 
        this.add(getTextFieldContato()); 
        this.add(getLabelCRM()); 
        this.add(getTextFieldCRM()); 
        this.add(getLabelEspecialidade()); 
        this.add(getTextFieldEspecialidade());       
        this.add(getLabelValor()); 
        this.add(getTextFieldValor()); 
        
        this.setVisible(true);
    }
    
    JLabel getLabelNome() {
        if (this.labelNome == null) {
            this.labelNome = new JLabel();
            this.labelNome.setText("Nome do médico:"); 
            this.labelNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
            this.labelNome.setBounds(63, 44, 452, 29);
        }
        return this.labelNome;
    }
    
    public JTextField getTextFieldNome() {
        if (this.textFieldNome == null) {
            this.textFieldNome = new JTextField();
            this.textFieldNome.setBounds(63, 83, 1170, 40);
        }
        return this.textFieldNome;
    }
    
    JLabel getLabelContato() {
        if (this.labelContato == null) {
            this.labelContato = new JLabel();
            this.labelContato.setText("Contato:"); 
            this.labelContato.setFont(new Font("Tahoma", Font.PLAIN, 20));
            this.labelContato.setBounds(63, 140, 452, 29);
        }
        
        return this.labelContato;
    }
    
    public JTextField getTextFieldContato() {
        if (this.textFieldContato == null) {
            this.textFieldContato = new JTextField();
            this.textFieldContato.setBounds(63, 179, 520, 40);
        }
        return this.textFieldContato;
    }
    
    JLabel getLabelCRM() {
        if (this.labelCRM == null) {
            this.labelCRM = new JLabel();
            this.labelCRM.setText("CRM:"); 
            this.labelCRM.setFont(new Font("Tahoma", Font.PLAIN, 20));
            this.labelCRM.setBounds(710, 140, 452, 29);
        }
        
        return this.labelCRM;
    }
    
    public JTextField getTextFieldCRM() {
        if (this.textFieldCRM == null) {
            this.textFieldCRM = new JTextField();
            this.textFieldCRM.setBounds(710, 179, 520, 40);
        }
        return this.textFieldCRM;
    }
    
    JLabel getLabelEspecialidade() {
        if (this.labelEspecialidade == null) {
            this.labelEspecialidade = new JLabel();
            this.labelEspecialidade.setText("Especialidade:");
            this.labelEspecialidade.setFont(new Font("Tahoma", Font.PLAIN, 20));
            //this.labelEspecialidade.setBounds(63, 44, 452, 29);            
        }
        
        return this.labelEspecialidade;
    }
    
    public JTextField getTextFieldEspecialidade() {
        if (this.textFieldEspecialidade == null) {
            this.textFieldEspecialidade = new JTextField();           
        }
        return this.textFieldEspecialidade;
    }
    
    JLabel getLabelValor() {
        if (this.labelValor == null) {
            this.labelValor = new JLabel();
            this.labelValor.setText("Valor:");
            this.labelValor.setFont(new Font("Tahoma", Font.PLAIN, 20));
            //this.labelValor.setBounds(63, 44, 452, 29);            
        }
        
        return this.labelValor;
    }
    
    public JTextField getTextFieldValor() {
        if (this.textFieldValor == null) {
            this.textFieldValor = new JTextField();           
        }
        return this.textFieldValor;
    }
}
