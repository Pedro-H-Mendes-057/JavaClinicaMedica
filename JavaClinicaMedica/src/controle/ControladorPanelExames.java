package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import dialogCadastroPanels.DialogCadastrarExames;
import dialogCadastroPanels.DialogCadastrarPaciente;
import dialogCadastroPanels.DialogReagendarExames;
import visual.PanelExames;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class ControladorPanelExames implements ActionListener {
    private PanelExames panelExames;
    private DialogCadastrarExames dialogCadastrarExames;
    private ControladorDialogCadastrarExame controladorDialogCadastrarExame;
    
    public ControladorPanelExames(PanelExames panelExames) {
        this.panelExames = panelExames;       
        addEventos();
    }
    
    private void addEventos() {
        this.panelExames.getBTNNovo().addActionListener(this);
        this.panelExames.getBTNEditar().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == panelExames.getBTNNovo()) {   
           
            dialogCadastrarExames = new DialogCadastrarExames(ControladorFrame.frame);
            controladorDialogCadastrarExame = new ControladorDialogCadastrarExame(this.dialogCadastrarExames);           
            atualizarTabela();
            
        }
        
        if (e.getSource() == this.panelExames.getBTNExcluir()) {
            if(this.panelExames.getMessageDialogExcluirItem(panelExames) &&
            		(this.panelExames.getTable().getSelectedRowCount()) == 1) {
            	ControladorFrame.repositorioExames.getExames().remove(this.panelExames.getTable().getSelectedRow());
            	atualizarTabela();
            }
            
        }
        
        if(e.getSource() == panelExames.getBTNEditar()) {
            new DialogReagendarExames(ControladorFrame.frame).setVisible(true);
        }
    }//do actionperformed

    private void atualizarTabela() {
        DefaultTableModel model = (DefaultTableModel) this.panelExames.getTable().getModel(); 
        
        model.setRowCount(0); // apaga todos os itens da tabela para que ela seja refeita
        
        for (int i = 0; i < ControladorFrame.repositorioExames.getExames().size(); i++) {
            //System.out.println("OI " + i);
            model.addRow(new Object [] {
            		ControladorFrame.repositorioExames.getExames().get(i).getNomeExame(),
                    ControladorFrame.repositorioExames.getExames().get(i).getTipo(),
                    String.valueOf(ControladorFrame.repositorioExames.getExames().get(i).getValorParticular()),
                    ControladorFrame.repositorioExames.getExames().get(i).getDescricao(),
                    ControladorFrame.repositorioExames.getExames().get(i).getMedico() 
            });
        }    
    }

    

}//da classe
