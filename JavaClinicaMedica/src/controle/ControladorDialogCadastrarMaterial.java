/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import visual.DialogCadastrarMaterial;

/**
 *
 * @author fonfon
 */
public class ControladorDialogCadastrarMaterial implements ActionListener {
    DialogCadastrarMaterial dialogCadastrarMaterial;
    
    public ControladorDialogCadastrarMaterial(DialogCadastrarMaterial dialogCadastrarMaterial) {
        this.dialogCadastrarMaterial = dialogCadastrarMaterial;
        
        addEventos();
        
        this.dialogCadastrarMaterial.setVisible(true);
    }
    
    void addEventos() {
        this.dialogCadastrarMaterial.getButtonUpload().addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.dialogCadastrarMaterial.getButtonUpload()) {
            
        }
    }  
}
