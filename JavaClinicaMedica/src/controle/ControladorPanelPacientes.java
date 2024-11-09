package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import repositorio.RepositorioPacientes;
import controle.ControladorDialogCadastrarPaciente;
import dialogCadastroPanels.DialogCadastroPaciente;
import visual.PanelPacientes;


public class ControladorPanelPacientes implements ActionListener{
	PanelPacientes panelPacientes;
    DialogCadastroPaciente  dialogCadastroPaciente;
    ControladorDialogCadastrarPaciente controladorDialogCadastrarPaciente;
    
    public ControladorPanelPacientes(PanelPacientes panelPacientes) {
        this.panelPacientes = panelPacientes;
        addEventos();
    }

    public void addEventos() {
        this.panelPacientes.getBTNNovo().addActionListener(this);
        this.panelPacientes.getBTNCancelar().addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.panelPacientes.getBTNNovo()) {
           this.dialogCadastroPaciente = new DialogCadastroPaciente(ControladorFrame.frame);
           this.controladorDialogCadastrarPaciente = new ControladorDialogCadastrarPaciente(this.dialogCadastroPaciente);
           atualizarTabela();

        } else if (e.getSource() == this.panelPacientes.getBTNCancelar()) {
            this.panelPacientes.getMessageDialogCancelarItem(panelPacientes);
        }
    }
    
    public void atualizarTabela() {
        DefaultTableModel model = (DefaultTableModel) this.panelPacientes.getTable().getModel(); 
        model.setRowCount(0); // Apaga todos os itens da tabela para que ela seja refeita
        
        for (int i = 0; i < ControladorFrame.repositorioPacientes.getPacientes().size(); i++) {
            model.addRow(new Object [] {
                ControladorFrame.repositorioPacientes.getPacientes().get(i).getNome(),
                ControladorFrame.repositorioPacientes.getPacientes().get(i).getDataNasc(),
                ControladorFrame.repositorioPacientes.getPacientes().get(i).getContato(),
                ControladorFrame.repositorioPacientes.getPacientes().get(i).getTipoSang(),
                ControladorFrame.repositorioPacientes.getPacientes().get(i).getConvenio()
            });
        }    
    }

}
