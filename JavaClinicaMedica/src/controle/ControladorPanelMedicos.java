/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dialogCadastroPanels.DialogCadastrarMedico;
import javax.swing.table.DefaultTableModel;
import visual.PanelMedicos;

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
        this.panelMedicos.getBTNNovo().addActionListener(this);
        this.panelMedicos.getBTNExcluir().addActionListener(this);
        
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.panelMedicos.getBTNNovo()) {            
            this.cadastrarMedico = new DialogCadastrarMedico(ControladorFrame.frame);            
            this.controladorDialogCadastrarMedico = new ControladorDialogCadastrarMedico(this.cadastrarMedico); 
            atualizarTabela();
        }
        
        if (e.getSource() == this.panelMedicos.getBTNExcluir()) {
            if(this.panelMedicos.getMessageDialogExcluirItem(panelMedicos) &&
            		(this.panelMedicos.getTable().getSelectedRowCount()) == 1) {
            	ControladorFrame.repositorioMedicos.getMedicos().remove(this.panelMedicos.getTable().getSelectedRow());
            	atualizarTabela();
            	if(ControladorFrame.repositorioMedicos.getMedicos().isEmpty()) System.out.println("Tá apagando mesmo");
            }
            
        }
    }
    
    public void atualizarTabela() {
        DefaultTableModel model = (DefaultTableModel) this.panelMedicos.getTable().getModel(); 
        
        //System.out.println("size = " + ControladorFrame.repositorioMateriais.getMateriais().size());
        model.setRowCount(0); // apaga todos os itens da tabela para que ela seja refeita
        
        for (int i = 0; i < ControladorFrame.repositorioMedicos.getMedicos().size(); i++) {
            //System.out.println("OI " + i);
            model.addRow(new Object [] {
                ControladorFrame.repositorioMedicos.getMedicos().get(i).getNome(),
                String.valueOf(ControladorFrame.repositorioMedicos.getMedicos().get(i).getEspecialidade()),
                String.valueOf(ControladorFrame.repositorioMedicos.getMedicos().get(i).getCrm()),
                ControladorFrame.repositorioMedicos.getMedicos().get(i).getContato(),
                ControladorFrame.repositorioMedicos.getMedicos().get(i).getValorConsulta(),
            });
        }    
    }
}
