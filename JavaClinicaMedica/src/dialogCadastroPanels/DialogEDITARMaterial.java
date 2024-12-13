package dialogCadastroPanels;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import modelo.Material;

public class DialogEDITARMaterial extends JDialog {
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
    
    private Material materialAlterado;
    
    public DialogEDITARMaterial(JFrame parent, Material materialAlterado) {
        super(parent, "Editar Material", true);
        this.setSize(1300, 650);
        this.setResizable(false);
        this.setLocationRelativeTo(parent);         
        this.setLayout(null);
        
        this.add(getLabelNome()); 
        this.add(getTextFieldNome());
        this.add(getLabelQtdEstoque()); 
        this.add(getTextFieldQtdEstoque());
        this.add(getLabelQtdMinima()); 
        this.add(getTextFieldQtdMinima()); 
        this.add(getLabelPreco()); 
        this.add(getTextFieldPreco());
        this.add(getLabelFornecedor()); 
        this.add(getTextFieldFornecedor());         
        this.add(getButtonSalvar()); 
        this.add(getButtonCancelar());        
        
        this.materialAlterado = materialAlterado;
        
        this.preencherCampos(materialAlterado);
        
        getTextFieldNome().setEnabled(false);
        getTextFieldFornecedor().setEnabled(false);
        getTextFieldQtdMinima().setEnabled(false);
        getTextFieldQtdEstoque().setEnabled(true);
        getTextFieldPreco().setEnabled(true);
        
    }
    public void preencherCampos(Material material) {
    	
    	if (material == null) {
            throw new IllegalArgumentException("O material não pode ser nulo!");
        }
    	getTextFieldNome().setText(materialAlterado.getNome());
    	getTextFieldFornecedor().setText(materialAlterado.getFornecedor());
        getTextFieldQtdEstoque().setText(String.valueOf(materialAlterado.getQuant()));
        getTextFieldQtdMinima().setText(String.valueOf(materialAlterado.getQuantMin()));
        getTextFieldPreco().setText(materialAlterado.getPreco());

        getTextFieldNome().setEnabled(false);
        getTextFieldFornecedor().setEnabled(false);
        getTextFieldQtdMinima().setEnabled(false);
    }


    
    JLabel getLabelNome() {
        if (this.labelNome == null) {
            this.labelNome = new JLabel();
            this.labelNome.setText("Nome do material:"); 
            this.labelNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
            this.labelNome.setBounds(350, 44, 452, 29);
        }
        return this.labelNome;
    }
    
    public JTextField getTextFieldNome() {
        if (this.textFieldNome == null) {
            this.textFieldNome = new JTextField();
            this.textFieldNome.setBounds(350, 83, 520, 40);
        }
        return this.textFieldNome;
    }
    
    JLabel getLabelQtdEstoque() {
        if (this.labelQtdEstoque == null) {
            this.labelQtdEstoque = new JLabel();
            this.labelQtdEstoque.setText("Quantidade estoque:"); 
            this.labelQtdEstoque.setFont(new Font("Tahoma", Font.PLAIN, 20));
            this.labelQtdEstoque.setBounds(350, 140, 452, 29);
        }
        return this.labelQtdEstoque;
    }
    
    public JTextField getTextFieldQtdEstoque() {
        if (this.textFieldQtdEstoque == null) {
            this.textFieldQtdEstoque = new JTextField();
            this.textFieldQtdEstoque.setBounds(350, 179, 520, 40);
        }
        return this.textFieldQtdEstoque;
    }
    
    JLabel getLabelQtdMinima() {
        if (this.labelQtdMinima == null) {
            this.labelQtdMinima = new JLabel();
            this.labelQtdMinima.setText("Quantidade mínima:"); 
            this.labelQtdMinima.setFont(new Font("Tahoma", Font.PLAIN, 20));
            this.labelQtdMinima.setBounds(350, 236, 452, 29);
        }
        return this.labelQtdMinima;
    }
    
    public JTextField getTextFieldQtdMinima() {
        if (this.textFieldQtdMinima == null) {
            this.textFieldQtdMinima = new JTextField();
            this.textFieldQtdMinima.setBounds(350, 275, 520, 40);
        }
        return this.textFieldQtdMinima;
    }
    
    JLabel getLabelPreco() {
        if (this.labelPreco == null) {
            this.labelPreco = new JLabel();
            this.labelPreco.setText("Preço:"); 
            this.labelPreco.setFont(new Font("Tahoma", Font.PLAIN, 20));
            this.labelPreco.setBounds(350, 332, 452, 29);
        }
        return this.labelPreco;
    }
    
    public JTextField getTextFieldPreco() {
        if (this.textFieldPreco == null) {
            this.textFieldPreco = new JTextField();
            this.textFieldPreco.setBounds(350, 371, 520, 40);
        }
        return this.textFieldPreco;
    }
    
    JLabel getLabelFornecedor() {
        if (this.labelFornecedor == null) {
            this.labelFornecedor = new JLabel();
            this.labelFornecedor.setText("Fornecedor:"); 
            this.labelFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 20));
            this.labelFornecedor.setBounds(350, 428, 452, 29);
        }
        return this.labelFornecedor;
    }
    
    public JTextField getTextFieldFornecedor() {
        if (this.textFieldFornecedor == null) {
            this.textFieldFornecedor = new JTextField();
            this.textFieldFornecedor.setBounds(350, 467, 520, 40);
        }
        return this.textFieldFornecedor;
    }
    
    public JButton getButtonSalvar() {
        if (this.buttonSalvar == null) {
            this.buttonSalvar = new JButton("SALVAR");
            this.buttonSalvar.setFont(new Font("Tahoma", Font.PLAIN, 20));
            this.buttonSalvar.setBackground(new Color(50, 205, 101));
            this.buttonSalvar.setForeground(new Color(255, 255, 255));
            this.buttonSalvar.setBounds(400, 530, 177, 55);
           
        }
        return this.buttonSalvar;
    }
    
    public JButton getButtonCancelar() {
        if (this.buttonCancelar == null) {
            this.buttonCancelar  = new JButton("CANCELAR");
            this.buttonCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
            this.buttonCancelar.setBackground(new Color(244, 0, 9));
            this.buttonCancelar.setForeground(new Color(255, 255, 255));
            this.buttonCancelar.setBounds(620, 530, 177, 55);
           
        }
        return this.buttonCancelar;
    }    
   
}
