/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import visual.DialogCadastrarMedico;


/**
 *
 * @author fonfon
 */
public class ControladorDialogCadastrarMedico implements ActionListener {
    DialogCadastrarMedico dialogCadastrarMedico;
    JTable tableHorarios; 
    
    public ControladorDialogCadastrarMedico(DialogCadastrarMedico dialogCadastrarMedico) {
        this.dialogCadastrarMedico = dialogCadastrarMedico;
        tableHorarios = this.dialogCadastrarMedico.getTableHorarios();        
        addEventos();
        this.dialogCadastrarMedico.setVisible(true);
    }
    
    void addEventos() {
        tableHorarios.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int row = tableHorarios.rowAtPoint(e.getPoint());
                int col = tableHorarios.columnAtPoint(e.getPoint());              
                               
                if (row >= 0 && col >= 1) {
                    if (tableHorarios.getModel().getValueAt(row, col) == "X") {
                        tableHorarios.getModel().setValueAt("", row, col);
                    } else {
                        tableHorarios.getModel().setValueAt("X", row, col);
                    }
                }
            }
           
        });
    }
    
    
    public void actionPerformed(ActionEvent e) {
        
    }  
    
}
