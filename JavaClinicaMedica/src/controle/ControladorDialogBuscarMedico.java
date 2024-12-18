/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;


import dialogCadastroPanels.DialogBuscar;
import java.awt.event.ActionEvent;
import java.util.EventListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fonfon
 */
public class ControladorDialogBuscarMedico implements EventListener {
    private DialogBuscar dialogBuscarMedico;
    private int chaveMedico;
    
    public ControladorDialogBuscarMedico(DialogBuscar dialogBuscarMedico) {
        this.chaveMedico = -1;
        this.dialogBuscarMedico = dialogBuscarMedico;
        addEventos();
        adicionarNomes();
        this.dialogBuscarMedico.setVisible(true);
    }
    
    void addEventos() {
        this.dialogBuscarMedico.getTable().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int row = dialogBuscarMedico.getTable().rowAtPoint(e.getPoint());
                setChaveMedico((Integer) dialogBuscarMedico.getTable().getModel().getValueAt(row, 1)) ;
                dialogBuscarMedico.dispose();
            }
           
        });
    }
    
    public void actionPerformed(ActionEvent e) {

    }
     
    void adicionarNomes() {
        DefaultTableModel model = (DefaultTableModel) this.dialogBuscarMedico.getTable().getModel();         
       
        model.setRowCount(0);
        
        for (Integer chave : ControladorFrame.repositorioMedicos.getMedicos().keySet()) {
            model.addRow(new Object [] {
                ControladorFrame.repositorioMedicos.getMedicos().get(chave).getNome(),
                chave
            });
        }
        
        this.dialogBuscarMedico.getTable().removeColumn(this.dialogBuscarMedico.getTable().getColumn("CHAVE"));
        
        /*for (int i = 0; i < ControladorFrame.repositorioMedicos.getMedicos().size(); i++) {            
            model.addRow(new Object [] {
                ControladorFrame.repositorioMedicos.getMedicos().get(i).getNome(),
                i
            });
        }
        
        // a coluna POSICAO guarda o index do objeto 
        this.dialogBuscarMedico.getTable().removeColumn(this.dialogBuscarMedico.getTable().getColumn("POSICAO")); */
    }
    
    public void setChaveMedico(int indexMedico) {
        this.chaveMedico = indexMedico;
    }    
    
    public int getChaveMedico() {
        return this.chaveMedico;
    }
    
}
