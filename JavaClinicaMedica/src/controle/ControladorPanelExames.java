package controle;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import dialogCadastroPanels.DialogCadastrarExames;
import dialogCadastroPanels.DialogEDITARExames;
import modelo.Exame;
import visual.PanelExames;
import javax.swing.table.DefaultTableModel;

public class ControladorPanelExames implements ActionListener {
    Exame exame;
    private PanelExames panelExames;
    private DialogCadastrarExames dialogCadastrarExames;
    private ControladorDialogCadastrarExame controladorDialogCadastrarExame;
    private ControladorPanelMateriais controladorPanelMateriais;
    
    private DialogEDITARExames dialogEditarExames;
    private ControladorDialogEDITARExame controladorDialogEditarExame;
    
    public ControladorPanelExames(PanelExames panelExames, ControladorPanelMateriais controladorPanelMateriais) {
        this.panelExames = panelExames;
        this.controladorPanelMateriais = controladorPanelMateriais;
        addEventos();
    }
    
    private void addEventos() {
        this.panelExames.getBTNNovo().addActionListener(this);
        
        this.panelExames.getTable().getSelectionModel().addListSelectionListener(event -> {
            boolean itemSelecionado = this.panelExames.getTable().getSelectedRow() != -1;
            this.panelExames.getBTNEditar().setEnabled(itemSelecionado);
            this.panelExames.getBTNExcluir().setEnabled(itemSelecionado);
        });
        //this.panelExames.getBTNEditar().addActionListener(this);
        this.panelExames.getBTNExcluir().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == panelExames.getBTNNovo()) {   
           
            dialogCadastrarExames = new DialogCadastrarExames(ControladorFrame.frame);
            controladorDialogCadastrarExame = new ControladorDialogCadastrarExame(this.dialogCadastrarExames, this.controladorPanelMateriais);           
            atualizarTabela();
            
        }
        
        if (e.getSource() == this.panelExames.getBTNExcluir()) {           
            if(this.panelExames.getMessageDialogExcluirItem(panelExames) &&
            		(this.panelExames.getTable().getSelectedRowCount()) == 1) {
                
            	ControladorFrame.repositorioExames.getExames().remove(this.panelExames.getTable().getSelectedRow());
            	atualizarTabela();
            }
            
        }
        
        if (e.getSource() == panelExames.getBTNEditar()) {
            int selectedRow = this.panelExames.getTable().getSelectedRow();
            if (selectedRow != -1) {
                Exame exameSelecionado = ControladorFrame.repositorioExames.getExames().get(selectedRow);
                this.dialogEditarExames = new DialogEDITARExames(ControladorFrame.frame, exameSelecionado);
                this.controladorDialogEditarExame = new ControladorDialogEDITARExame(this.dialogEditarExames, exameSelecionado);
                atualizarTabela();
            }
        }
        
    }//do actionperformed

    private void atualizarTabela() {
        DefaultTableModel model = (DefaultTableModel) this.panelExames.getTable().getModel(); 
        
        model.setRowCount(0);
        
        ControladorFrame.repositorioExames.getExames().forEach(exame -> {
            model.addRow(new Object[]{
                exame.getNomeExame(),
                exame.getTipo(),
                exame.getValorParticular(),
                exame.getDescricao(),
                exame.getMedico().getNome()
            });
        });
        
    }

    /*
        for (int i = 0; i < ControladorFrame.repositorioExames.getExames().size(); i++) {
            //System.out.println("OI " + i);
            model.addRow(new Object [] {
            		ControladorFrame.repositorioExames.getExames().get(i).getNomeExame(),
                    ControladorFrame.repositorioExames.getExames().get(i).getTipo(),
                    String.valueOf(ControladorFrame.repositorioExames.getExames().get(i).getValorParticular()),
                    ControladorFrame.repositorioExames.getExames().get(i).getDescricao(),
                    ControladorFrame.repositorioExames.getExames().get(i).getMedico() 
            });
        }   */ 
    

}//da classe
