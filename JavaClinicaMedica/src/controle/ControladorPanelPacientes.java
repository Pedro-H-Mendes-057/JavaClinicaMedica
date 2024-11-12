package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import visual.PanelPacientes;
import dialogCadastroPanels.DialogCadastroPaciente;

public class ControladorPanelPacientes implements ActionListener {
    private PanelPacientes panelPacientes;
    private DialogCadastroPaciente dialogCadastroPaciente;
    private ControladorDialogCadastrarPaciente controladorDialogCadastrarPaciente;
    
    public ControladorPanelPacientes(PanelPacientes panelPacientes) {
        this.panelPacientes = panelPacientes;
        addEventos();
    }

    private void addEventos() {
        panelPacientes.getBTNNovo().addActionListener(this);
        panelPacientes.getBTNExcluir().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == panelPacientes.getBTNNovo()) {
            dialogCadastroPaciente = new DialogCadastroPaciente(ControladorFrame.frame);
            
            controladorDialogCadastrarPaciente = new ControladorDialogCadastrarPaciente(dialogCadastroPaciente);

            dialogCadastroPaciente.setVisible(true);
            atualizarTabela();
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
