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
public class ControladorDialogBuscarMaterial {
    private DialogBuscar dialogBuscarMaterial;
    private int chaveMaterial;    
    
    public ControladorDialogBuscarMaterial(DialogBuscar dialogBuscarMaterial) {
        this.chaveMaterial = -1;
        this.dialogBuscarMaterial = dialogBuscarMaterial;
        addEventos();
        adicionarNomes();
        this.dialogBuscarMaterial.setVisible(true);
    }
    
    void addEventos() {
        this.dialogBuscarMaterial.getTable().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int row = dialogBuscarMaterial.getTable().rowAtPoint(e.getPoint());
                setChaveMaterial((Integer) dialogBuscarMaterial.getTable().getModel().getValueAt(row, 1)) ;
                dialogBuscarMaterial.dispose();
            }
           
        });
    }
    
    public void actionPerformed(ActionEvent e) {

    }
     
    void adicionarNomes() {
        DefaultTableModel model = (DefaultTableModel) this.dialogBuscarMaterial.getTable().getModel();         
       
        model.setRowCount(0);
        
        for (int chave = 0; chave < ControladorFrame.repositorioMateriais.getMateriais().size(); chave++) {
            model.addRow(new Object [] {
                ControladorFrame.repositorioMateriais.getMateriais().get(chave).getNome(),
                chave
            });
        }
        
        this.dialogBuscarMaterial.getTable().removeColumn(this.dialogBuscarMaterial.getTable().getColumn("CHAVE"));
       
    }
    
    public void setChaveMaterial(int indexMaterial) {
        this.chaveMaterial = indexMaterial;
    }    
    
    public int getChaveMaterial() {
        return this.chaveMaterial;
    }
}
