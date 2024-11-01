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
        getContentPane().setLayout(null);
        setVisible(true);
        getContentPane().add(getLabelNome());
        
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
        }
        return this.textFieldNome;
    }
    
    JLabel getLabelContato() {
        if (this.labelContato == null) {
            this.labelContato = new JLabel();
            this.labelContato.setText("Contato:");            
        }
        
        return this.labelContato;
    }
    
    public JTextField getTextFieldContato() {
        if (this.textFieldContato == null) {
            this.textFieldContato = new JTextField();           
        }
        return this.textFieldContato;
    }
    
    JLabel getLabelCRM() {
        if (this.labelCRM == null) {
            this.labelCRM = new JLabel();
            this.labelCRM.setText("CRM:");            
        }
        
        return this.labelCRM;
    }
    
    public JTextField getTextFieldCRM() {
        if (this.textFieldCRM == null) {
            this.textFieldCRM = new JTextField();           
        }
        return this.textFieldCRM;
    }
    
    JLabel getLabelEspecialidade() {
        if (this.labelEspecialidade == null) {
            this.labelEspecialidade = new JLabel();
            this.labelEspecialidade.setText("Especialidade:");            
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
