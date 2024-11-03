/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import visual.DialogCadastrarMaterial;
import visual.PanelMateriais;
/**
 *
 * @author fonfon
 */
public class ControladorPanelMateriais implements ActionListener {
    PanelMateriais panelMateriais;
    DialogCadastrarMaterial  dialogCadastrarMaterial;
    ControladorDialogCadastrarMaterial controladorDialogCadastrarMaterial;
    
    public ControladorPanelMateriais(PanelMateriais panelMateriais) {
        this.panelMateriais = panelMateriais;
        addEventos();
    }
    
    public void addEventos() {
        this.panelMateriais.getButtonNovo().addActionListener(this);
        this.panelMateriais.getButtonCancelar().addActionListener(this);
        
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.panelMateriais.getButtonNovo()) {
            
                       
        } else if (e.getSource() == this.panelMateriais.getButtonCancelar()) {
            this.panelMateriais.getMessageDialogCancelarItem(panelMateriais);
        }
    }
}
