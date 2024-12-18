package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.Material;
import controle.ControladorPanelMateriais;
import dialogCadastroPanels.DialogCadastrarMaterial;
import exportacoes.ExportarDados;

public class ControladorDialogCadastrarMaterial implements ActionListener {
    DialogCadastrarMaterial dialogCadastrarMaterial;
    Material material;    

    public ControladorDialogCadastrarMaterial(DialogCadastrarMaterial dialogCadastrarMaterial) {
        this.dialogCadastrarMaterial = dialogCadastrarMaterial;
        //this.material = materialAlterado;
        //this.dialogCadastrarMaterial.setModoEdicao(false, null);  //(boolean, material)
        addEventos();

        this.dialogCadastrarMaterial.setVisible(true);
    }
    
    /*//Construtor 2 pra Edição
    public ControladorDialogCadastrarMaterial(DialogCadastrarMaterial dialogCadastrarMaterial, Material materialAlterado) {
    	this.dialogCadastrarMaterial.setModoEdicao(true, materialAlterado);
    	this.material = materialAlterado;
        addEventos();
        this.dialogCadastrarMaterial.setVisible(true);
    }*/
    
    void addEventos() {
        this.dialogCadastrarMaterial.getButtonSalvar().addActionListener(this);
        this.dialogCadastrarMaterial.getButtonCancelar().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.dialogCadastrarMaterial.getButtonSalvar()) { 
        	if(camposValidos() == true) {
        		
        	if (this.dialogCadastrarMaterial.modoEdicao) {
                    atualizarMaterial();
                    JOptionPane.showMessageDialog(this.dialogCadastrarMaterial, "Material atualizado com sucesso!");
                } else {
                    addMaterial();
                    JOptionPane.showMessageDialog(this.dialogCadastrarMaterial, "Material salvo com sucesso!");
                }
                this.dialogCadastrarMaterial.dispose();                
            }
        }//do salvar
        else if (e.getSource()== this.dialogCadastrarMaterial.getButtonCancelar()) {
        	this.dialogCadastrarMaterial.dispose();    
        }
    }  
    
    public boolean camposValidos() {
        String nome = this.dialogCadastrarMaterial.getTextFieldNome().getText().trim();
        String fornecedor = this.dialogCadastrarMaterial.getTextFieldFornecedor().getText().trim();
        String quantString = this.dialogCadastrarMaterial.getTextFieldQtdEstoque().getText().trim();
        String quantMinString = this.dialogCadastrarMaterial.getTextFieldQtdMinima().getText().trim();
        String precoString = this.dialogCadastrarMaterial.getTextFieldPreco().getText().trim();

        if (nome.isEmpty() || fornecedor.isEmpty() || quantString.isEmpty() || quantMinString.isEmpty() || precoString.isEmpty()) {
            JOptionPane.showMessageDialog(dialogCadastrarMaterial, "Preencha todos os campos!");
            return false;
        }
        /*else if (nomeDuplicado(nome)) {
		            JOptionPane.showMessageDialog(dialogCadastrarMaterial, "Já existe um material com este nome cadastrado!");
		            return false;
		        }*/
		        
		        if (ControladorFrame.repositorioMateriais.buscarMaterial(nome)) {
		            JOptionPane.showMessageDialog(dialogCadastrarMaterial, "Esse material já está cadastrado!");
		            return false;
        }

        try {
            int quant = Integer.parseInt(quantString);
            int quantMin = Integer.parseInt(quantMinString);  //se o campo como STRING não tiver vazio (pq não fucniona o .isEmpty pra numeros)
            double preco = Double.parseDouble(precoString);   // converte pra Int/Double pra validar os valores numericos

            if (quant <= 0 || quantMin <= 0 || preco <= 0) {
                JOptionPane.showMessageDialog(dialogCadastrarMaterial, "Quantidade e preço devem ser maiores que zero!");
                return false;
            }
            
            if (quant < quantMin) {
            	 JOptionPane.showMessageDialog(dialogCadastrarMaterial, 
                         "Estoque deve ser maior que a quantidade mínima!",
                         "Erro!",
                         JOptionPane.ERROR_MESSAGE);
                     return false;
                 }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(dialogCadastrarMaterial, "Preenchimento inválido!");
            return false;
        }
        return true;
    }
    
    private void atualizarMaterial() {
        this.material.setQuant(Integer.valueOf(this.dialogCadastrarMaterial.getTextFieldQtdEstoque().getText().trim()));
        this.material.setPreco(this.dialogCadastrarMaterial.getTextFieldPreco().getText().trim());
    }//
    
    public void addMaterial() {
        this.material = new Material();
        this.material.setNome(this.dialogCadastrarMaterial.getTextFieldNome().getText().trim());
        this.material.setFornecedor(this.dialogCadastrarMaterial.getTextFieldFornecedor().getText().trim());
        this.material.setQuant(Integer.valueOf(this.dialogCadastrarMaterial.getTextFieldQtdEstoque().getText().trim()));
        this.material.setQuantMin(Integer.valueOf(this.dialogCadastrarMaterial.getTextFieldQtdMinima().getText().trim()));
        this.material.setPreco(this.dialogCadastrarMaterial.getTextFieldPreco().getText().trim());
        this.material.setUtilizado(1);
        
        ControladorFrame.repositorioMateriais.addMaterial(this.material);
        ExportarDados.anexarMaterial(this.material);
    }    
    
}