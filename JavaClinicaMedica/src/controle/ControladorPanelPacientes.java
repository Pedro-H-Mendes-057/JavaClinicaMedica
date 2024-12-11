package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import visual.PanelPacientes;
import dialogCadastroPanels.DialogCadastrarPaciente;
import exportacoes.ExportarDados;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladorPanelPacientes implements ActionListener {
    private PanelPacientes panelPacientes;
    private DialogCadastrarPaciente dialogCadastrarPaciente;
    private ControladorDialogCadastrarPaciente controladorDialogCadastrarPaciente;
    
    public ControladorPanelPacientes(PanelPacientes panelPacientes) {
        this.panelPacientes = panelPacientes;
        try {
            ExportarDados.recuperarPacientes();
        } catch (IOException ex) {
           System.out.println("Falha na recuperação do arquivo Pacientes.txt");
        }
        atualizarTabela();
        addEventos();
    }

    private void addEventos() {
        panelPacientes.getBTNNovo().addActionListener(this);
        panelPacientes.getBTNExcluir().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == panelPacientes.getBTNNovo()) {
            dialogCadastrarPaciente = new DialogCadastrarPaciente(ControladorFrame.frame);
            
            controladorDialogCadastrarPaciente = new ControladorDialogCadastrarPaciente(dialogCadastrarPaciente);
            
            atualizarTabela();
        }
        
        if (e.getSource() == this.panelPacientes.getBTNExcluir()) {
            if(this.panelPacientes.getMessageDialogExcluirItem(panelPacientes) &&
            		(this.panelPacientes.getTable().getSelectedRowCount()) == 1) {
            	ControladorFrame.repositorioPacientes.getPacientes().remove(this.panelPacientes.getTable().getSelectedRow());
            	atualizarTabela();
            }
            
        }
    }
    
    private void atualizarTabela() {
        DefaultTableModel model = (DefaultTableModel) panelPacientes.getTable().getModel();
        model.setRowCount(0); // Apaga todos os itens da tabela para que ela seja refeita
        
        ControladorFrame.repositorioPacientes.getPacientes().forEach(paciente -> {
            model.addRow(new Object[]{
                paciente.getNome(),
                paciente.getDataNasc(),
                paciente.getContato(),
                paciente.getTipoSang(),
                paciente.getConvenio()
            });
        });
    }
}
