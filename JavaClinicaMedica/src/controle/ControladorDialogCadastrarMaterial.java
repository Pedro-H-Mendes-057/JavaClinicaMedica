/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.Material;
import visual.DialogCadastrarMaterial;

/**
 *
 * @author fonfon
 */
public class ControladorDialogCadastrarMaterial implements ActionListener {
    DialogCadastrarMaterial dialogCadastrarMaterial;
    Material material;
    
    public ControladorDialogCadastrarMaterial(DialogCadastrarMaterial dialogCadastrarMaterial) {
        this.dialogCadastrarMaterial = dialogCadastrarMaterial;
        
        addEventos();
        
        this.dialogCadastrarMaterial.setVisible(true);
    }
    
    void addEventos() {
        this.dialogCadastrarMaterial.getButtonUpload().addActionListener(this);
        this.dialogCadastrarMaterial.getButtonSalvar().addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.dialogCadastrarMaterial.getButtonUpload()) {
            uploadImage();
        } else if (e.getSource() == this.dialogCadastrarMaterial.getButtonSalvar()) {            
            addMaterial();
            this.dialogCadastrarMaterial.dispose();
            //System.out.println("TESTE AQUI");
        }
    }  
    
    public void uploadImage() {
        JFileChooser chooser = new JFileChooser(); 
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG Imagens", "jpg");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this.dialogCadastrarMaterial);
    }
    
    public void addMaterial() {
        this.material = new Material();
        this.material.setNome(this.dialogCadastrarMaterial.getTextFieldNome().getText());
        this.material.setFornecedor(this.dialogCadastrarMaterial.getTextFieldFornecedor().getText());
        this.material.setQuant(Integer.valueOf(this.dialogCadastrarMaterial.getTextFieldQtdEstoque().getText()));
        this.material.setQuantMin(Integer.valueOf(this.dialogCadastrarMaterial.getTextFieldQtdMinima().getText()));
        this.material.setPreco(this.dialogCadastrarMaterial.getTextFieldPreco().getText());
       
        ControladorFrame.repositorioMateriais.addMaterial(this.material);
    }
}
