/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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
           this.dialogCadastrarMaterial = new DialogCadastrarMaterial(ControladorFrame.frame);
           this.controladorDialogCadastrarMaterial = new ControladorDialogCadastrarMaterial(this.dialogCadastrarMaterial);
           atualizarTabela();
                       
        } else if (e.getSource() == this.panelMateriais.getButtonCancelar()) {
            this.panelMateriais.getMessageDialogCancelarItem(panelMateriais);
        }
    }
    
    public void atualizarTabela() {
        DefaultTableModel model = (DefaultTableModel) this.panelMateriais.getTableMateriais().getModel(); 
        
        //System.out.println("size = " + ControladorFrame.repositorioMateriais.getMateriais().size());
        model.setRowCount(0); // apaga todos os itens da tabela para que ela seja refeita
        
        for (int i = 0; i < ControladorFrame.repositorioMateriais.getMateriais().size(); i++) {
            //System.out.println("OI " + i);
            model.addRow(new Object [] {
                ControladorFrame.repositorioMateriais.getMateriais().get(i).getNome(),
                String.valueOf(ControladorFrame.repositorioMateriais.getMateriais().get(i).getQuant()),
                String.valueOf(ControladorFrame.repositorioMateriais.getMateriais().get(i).getQuantMin()),
                ControladorFrame.repositorioMateriais.getMateriais().get(i).getFornecedor(),
                ControladorFrame.repositorioMateriais.getMateriais().get(i).getPreco(),
            });
        }    
    }
}
