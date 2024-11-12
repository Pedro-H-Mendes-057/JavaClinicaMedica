/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import visual.PanelAgendar;
import dialogCadastroPanels.DialogCadastrarConsulta;

/**
 *
 * @author fonfon
 */
public class ControladorPanelAgendar implements ActionListener {
    PanelAgendar panelAgendar;
    DialogCadastrarConsulta dialogCadastrarConsulta;
    
    public ControladorPanelAgendar(PanelAgendar panelAgendar) {
        this.panelAgendar = panelAgendar;
        addEventos();
    }
    
    public void addEventos() {
        this.panelAgendar.getBTNNovaConsulta().addActionListener(this);
        this.panelAgendar.getBTNNovoExame().addActionListener(this);
        
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() ==  this.panelAgendar.getBTNNovaConsulta()) {            
            dialogCadastrarConsulta = new DialogCadastrarConsulta(ControladorFrame.frame);
        } else if (e.getSource() == this.panelAgendar.getBTNNovoExame()) {
            
        }
    }
}
