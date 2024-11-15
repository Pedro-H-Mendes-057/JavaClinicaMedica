/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;


import dialogCadastroPanels.DialogBuscarMedico;
import java.awt.event.ActionEvent;
import java.util.EventListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fonfon
 */
public class ControladorDialogBuscarMedico implements EventListener {
    DialogBuscarMedico dialogBuscarMedico;
    
    public ControladorDialogBuscarMedico(DialogBuscarMedico dialogBuscarMedico) {
        this.dialogBuscarMedico = dialogBuscarMedico;
        addEventos();
        adicionarNomes();
        this.dialogBuscarMedico.setVisible(true);
    }
    
    void addEventos() {
        
    }
    
    public void actionPerformed(ActionEvent e) {

    }
     
    void adicionarNomes() {
        DefaultTableModel model = (DefaultTableModel) this.dialogBuscarMedico.getTable().getModel();         
       
        model.setRowCount(0);
        
        for (int i = 0; i < ControladorFrame.repositorioMedicos.getMedicos().size(); i++) {            
            model.addRow(new Object [] {
                ControladorFrame.repositorioMedicos.getMedicos().get(i).getNome()
            });
        }    
   
    }
}
