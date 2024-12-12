/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import dialogCadastroPanels.DialogBuscar;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fonfon
 */
public class ControladorDialogBuscarPaciente {
    private DialogBuscar dialogBuscarPaciente;
    private int chavePaciente;
    
    public ControladorDialogBuscarPaciente(DialogBuscar dialogBuscarPaciente) {
        this.chavePaciente = -1;
        this.dialogBuscarPaciente = dialogBuscarPaciente;
        addEventos();
        adicionarNomes();
        this.dialogBuscarPaciente.setVisible(true);
    }
    
    void addEventos() {
        this.dialogBuscarPaciente.getTable().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int row = dialogBuscarPaciente.getTable().rowAtPoint(e.getPoint());
                setChavePaciente((Integer) dialogBuscarPaciente.getTable().getModel().getValueAt(row, 1)) ;
                dialogBuscarPaciente.dispose();
            }
           
        });
    }
    
    public void actionPerformed(ActionEvent e) {

    }
     
    void adicionarNomes() {
        DefaultTableModel model = (DefaultTableModel) this.dialogBuscarPaciente.getTable().getModel();         
       
        model.setRowCount(0);
        
        for (int chave = 0; chave < ControladorFrame.repositorioPacientes.getPacientes().size(); chave++) {
            model.addRow(new Object [] {
                ControladorFrame.repositorioPacientes.getPacientes().get(chave).getNome(),
                chave
            });
        }
        
        this.dialogBuscarPaciente.getTable().removeColumn(this.dialogBuscarPaciente.getTable().getColumn("CHAVE"));
       
    }
    
    public void setChavePaciente(int indexPaciente) {
        this.chavePaciente = indexPaciente;
    }    
    
    public int getChavePaciente() {
        return this.chavePaciente;
    }
}
