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

import modelo.Material;

/**
 *
 * @author fonfon
 */
public class DialogCadastrarMaterial extends JDialog {
    JLabel labelNome;
    JTextField textFieldNome;
    JLabel labelQtdEstoque;
    JTextField textFieldQtdEstoque;
    JLabel labelQtdMinima;
    JTextField textFieldQtdMinima;
    JLabel labelPreco;
    JTextField textFieldPreco;
    JLabel labelFornecedor;
    JTextField textFieldFornecedor;
    JButton buttonSalvar;
    JButton buttonCancelar;
    public boolean modoEdicao = false;
    private Material materialAlterado;
    
    public DialogCadastrarMaterial(JFrame parent) {
        super(parent, "Cadastrar Material", true);
        this.setSize(1300, 650);
        this.setResizable(false);
        this.setLocationRelativeTo(parent);         
        getContentPane().setLayout(null); 
        getContentPane().add(getLabelNome()); 
        getContentPane().add(getTextFieldNome());
        getContentPane().add(getLabelQtdEstoque()); 
        getContentPane().add(getTextFieldQtdEstoque());
        getContentPane().add(getLabelQtdMinima()); 
        getContentPane().add(getTextFieldQtdMinima()); 
        getContentPane().add(getLabelPreco()); 
        getContentPane().add(getTextFieldPreco());
        getContentPane().add(getLabelFornecedor()); 
        getContentPane().add(getTextFieldFornecedor());         
        getContentPane().add(getButtonSalvar()); 
        getContentPane().add(getButtonCancelar());
        
    }
    public void setModoEdicao(boolean modoEdicao, Material material) {
        this.modoEdicao = modoEdicao;
        this.materialAlterado = material;

        if (modoEdicao) {
                getTextFieldNome().setText(material.getNome());
                getTextFieldFornecedor().setText(material.getFornecedor());
                getTextFieldQtdEstoque().setText(String.valueOf(material.getQuant()));
                getTextFieldQtdMinima().setText(String.valueOf(material.getQuantMin()));
                getTextFieldPreco().setText(material.getPreco());
                
                getTextFieldNome().setEnabled(false);
                getTextFieldFornecedor().setEnabled(false);
                getTextFieldQtdMinima().setEnabled(false);
        }
    }//ModoEdicao

    
    JLabel getLabelNome() {
        if (this.labelNome == null) {
            this.labelNome = new JLabel();
            this.labelNome.setText("Nome do material:"); 
            this.labelNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
            this.labelNome.setBounds(331, 44, 452, 29);
        }
        return this.labelNome;
    }
    
    public JTextField getTextFieldNome() {
        if (this.textFieldNome == null) {
            this.textFieldNome = new JTextField();
            this.textFieldNome.setBounds(331, 84, 520, 40);
        }
        return this.textFieldNome;
    }
    
    JLabel getLabelQtdEstoque() {
        if (this.labelQtdEstoque == null) {
            this.labelQtdEstoque = new JLabel();
            this.labelQtdEstoque.setText("Quantidade estoque:"); 
            this.labelQtdEstoque.setFont(new Font("Tahoma", Font.PLAIN, 20));
            this.labelQtdEstoque.setBounds(331, 140, 452, 29);
        }
        return this.labelQtdEstoque;
    }
    
    public JTextField getTextFieldQtdEstoque() {
        if (this.textFieldQtdEstoque == null) {
            this.textFieldQtdEstoque = new JTextField();
            this.textFieldQtdEstoque.setBounds(331, 180, 520, 40);
        }
        return this.textFieldQtdEstoque;
    }
    
    JLabel getLabelQtdMinima() {
        if (this.labelQtdMinima == null) {
            this.labelQtdMinima = new JLabel();
            this.labelQtdMinima.setText("Quantidade mínima:"); 
            this.labelQtdMinima.setFont(new Font("Tahoma", Font.PLAIN, 20));
            this.labelQtdMinima.setBounds(331, 236, 452, 29);
        }
        return this.labelQtdMinima;
    }
    
    public JTextField getTextFieldQtdMinima() {
        if (this.textFieldQtdMinima == null) {
            this.textFieldQtdMinima = new JTextField();
            this.textFieldQtdMinima.setBounds(331, 276, 520, 40);
        }
        return this.textFieldQtdMinima;
    }
    
    JLabel getLabelPreco() {
        if (this.labelPreco == null) {
            this.labelPreco = new JLabel();
            this.labelPreco.setText("Preço:"); 
            this.labelPreco.setFont(new Font("Tahoma", Font.PLAIN, 20));
            this.labelPreco.setBounds(331, 337, 452, 29);
        }
        return this.labelPreco;
    }
    
    public JTextField getTextFieldPreco() {
        if (this.textFieldPreco == null) {
            this.textFieldPreco = new JTextField();
            this.textFieldPreco.setBounds(331, 377, 520, 40);
        }
        return this.textFieldPreco;
    }
    
    JLabel getLabelFornecedor() {
        if (this.labelFornecedor == null) {
            this.labelFornecedor = new JLabel();
            this.labelFornecedor.setText("Fornecedor:"); 
            this.labelFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 20));
            this.labelFornecedor.setBounds(331, 428, 452, 29);
        }
        return this.labelFornecedor;
    }
    
    public JTextField getTextFieldFornecedor() {
        if (this.textFieldFornecedor == null) {
            this.textFieldFornecedor = new JTextField();
            this.textFieldFornecedor.setBounds(331, 468, 520, 40);
        }
        return this.textFieldFornecedor;
    }
    
    public JButton getButtonSalvar() {
        if (this.buttonSalvar == null) {
            this.buttonSalvar = new JButton("SALVAR");
            this.buttonSalvar.setFont(new Font("Tahoma", Font.PLAIN, 20));
            this.buttonSalvar.setBackground(new Color(50, 205, 101));
            this.buttonSalvar.setForeground(new Color(255, 255, 255));
            this.buttonSalvar.setBounds(389, 530, 177, 55);
           
        }
        return this.buttonSalvar;
    }
    
    public JButton getButtonCancelar() {
        if (this.buttonCancelar == null) {
            this.buttonCancelar  = new JButton("CANCELAR");
            this.buttonCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
            this.buttonCancelar.setBackground(new Color(244, 0, 9));
            this.buttonCancelar.setForeground(new Color(255, 255, 255));
            this.buttonCancelar.setBounds(596, 530, 177, 55);
           
        }
        return this.buttonCancelar;
    }
}
