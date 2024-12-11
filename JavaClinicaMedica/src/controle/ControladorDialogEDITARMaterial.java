package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.Material;
import controle.ControladorPanelMateriais;
import dialogCadastroPanels.DialogEDITARMaterial;

public class ControladorDialogEDITARMaterial implements ActionListener {
    DialogEDITARMaterial dialogEditarMaterial;
    Material material;    

    public ControladorDialogEDITARMaterial(DialogEDITARMaterial dialogEditarMaterial, Material material) {
        
        this.dialogEditarMaterial = dialogEditarMaterial;
        this.material = material;
        addEventos();
        
        this.dialogEditarMaterial.setVisible(true);
    }
    
    void addEventos() {
        this.dialogEditarMaterial.getButtonUpload().addActionListener(this);
        this.dialogEditarMaterial.getButtonSalvar().addActionListener(this);
        this.dialogEditarMaterial.getButtonCancelar().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.dialogEditarMaterial.getButtonUpload()) {
            uploadImage();
            
        } else if (e.getSource() == this.dialogEditarMaterial.getButtonSalvar()) { 
        	if(camposValidos() == true) {
                    atualizarMaterial();
                    JOptionPane.showMessageDialog(this.dialogEditarMaterial, "Material atualizado com sucesso!");
                    this.dialogEditarMaterial.dispose();   
                }
        } else if (e.getSource() == this.dialogEditarMaterial.getButtonCancelar()) {
            this.dialogEditarMaterial.dispose();           
        }
    }

    public void uploadImage() {
        JFileChooser chooser = new JFileChooser(); 
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG Imagens", "jpg");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this.dialogEditarMaterial);
    }
    
    public boolean camposValidos() {
    	 String quantString = this.dialogEditarMaterial.getTextFieldQtdEstoque().getText().trim();
         String precoString = this.dialogEditarMaterial.getTextFieldPreco().getText().trim();

         if (quantString.isEmpty() || precoString.isEmpty()) {
             JOptionPane.showMessageDialog(dialogEditarMaterial, "Preencha todos os campos!");
             return false;
         }

         try {
             int quant = Integer.parseInt(quantString);
             double preco = Double.parseDouble(precoString);

             if (quant <= 0 || preco <= 0) {
                 JOptionPane.showMessageDialog(dialogEditarMaterial, "Quantidade e preço devem ser maiores que zero!");
                 return false;
             }
         } catch (NumberFormatException ex) {
             JOptionPane.showMessageDialog(dialogEditarMaterial, "Preenchimento inválido!");
             return false;
         }

         return true;
    }
    
    private void atualizarMaterial() {
    	 //Material materialAtualizado = new Material();
    	 this.material.setNome(this.dialogEditarMaterial.getTextFieldNome().getText());
    	 this.material.setQuant(Integer.parseInt(this.dialogEditarMaterial.getTextFieldQtdEstoque().getText()));
    	 this.material.setPreco(this.dialogEditarMaterial.getTextFieldPreco().getText());

    	 ControladorFrame.repositorioMateriais.atualizarMaterial(this.material);
    }
    
    /*public void addMaterial() {
        this.material = new Material();
        this.material.setNome(this.dialogEditarMaterial.getTextFieldNome().getText());
        this.material.setFornecedor(this.dialogEditarMaterial.getTextFieldFornecedor().getText());
        this.material.setQuant(Integer.valueOf(this.dialogEditarMaterial.getTextFieldQtdEstoque().getText()));
        this.material.setQuantMin(Integer.valueOf(this.dialogEditarMaterial.getTextFieldQtdMinima().getText()));
        this.material.setPreco(this.dialogEditarMaterial.getTextFieldPreco().getText());
       
        ControladorFrame.repositorioMateriais.addMaterial(this.material);
    }  */
    
}