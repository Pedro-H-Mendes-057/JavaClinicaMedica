/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import visual.PanelMedicos;
import visual.DialogCadastrarMedico;

/**
 *
 * @author fonfon
 */
public class ControladorPanelMedicos implements ActionListener {
    PanelMedicos panelMedicos;
    DialogCadastrarMedico cadastrarMedico;
    ControladorDialogCadastrarMedico controladorDialogCadastrarMedico;
    
    public ControladorPanelMedicos(PanelMedicos panelMedicos) {
        this.panelMedicos = panelMedicos;
        addEventos();
    }
    
    public void addEventos() {
        this.panelMedicos.getButtonNovo().addActionListener(this);
        this.panelMedicos.getButtonCancelar().addActionListener(this);
        
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.panelMedicos.getButtonNovo()) {            
            this.cadastrarMedico = new DialogCadastrarMedico(ControladorFrame.frame);            
            this.controladorDialogCadastrarMedico = new ControladorDialogCadastrarMedico(this.cadastrarMedico);            
        } else if (e.getSource() == this.panelMedicos.getButtonCancelar()) {
            this.panelMedicos.getMessageDialogCancelarItem(panelMedicos);
        }
    }
}