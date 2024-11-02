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
        System.out.println("teste 1 ");
        addEventos();
    }
    
    void addEventos() {
        tableHorarios.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int row = tableHorarios.rowAtPoint(e.getPoint());
                int col = tableHorarios.columnAtPoint(e.getPoint());
                
                System.out.println("teste 2");
                
                if (row >= 0 && col >= 0) {
                    tableHorarios.getModel().setValueAt("X", row, col);
                }
            }
           
        });
    }
    
    
    public void actionPerformed(ActionEvent e) {
        
    }  
    
}
