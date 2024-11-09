package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Paciente;
import controle.ControladorPanelPacientes;
import dialogCadastroPanels.DialogCadastroPaciente;
import repositorio.RepositorioPacientes;

public class ControladorDialogCadastrarPaciente implements ActionListener {
    private DialogCadastroPaciente dialogCadastroPaciente;
    private Paciente paciente;

    // Construtor que recebe o DialogCadastroPaciente
    public ControladorDialogCadastrarPaciente(DialogCadastroPaciente dialogCadastroPaciente) {
        this.dialogCadastroPaciente = dialogCadastroPaciente;
        
        addEventos();
        
        this.dialogCadastroPaciente.setVisible(true);
    }

    void addEventos() {
        this.dialogCadastroPaciente.getBtSalvar().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
       if (e.getSource() == this.dialogCadastroPaciente.getBtSalvar()) {            
            addPaciente();
            this.dialogCadastroPaciente.dispose();
        }
    }  
    
    public void addPaciente() {
        this.paciente = new Paciente();
        this.paciente.setNome(this.dialogCadastroPaciente.getNomePaciente());
        this.paciente.setDataNasc(this.dialogCadastroPaciente.getDataNascimento());
        this.paciente.setContato(this.dialogCadastroPaciente.getContato());
        this.paciente.setAltura(this.dialogCadastroPaciente.getAltura());
        this.paciente.setTipoSang(this.dialogCadastroPaciente.getTipoSang());
        this.paciente.setPeso(this.dialogCadastroPaciente.getPeso());
        this.paciente.setConvenio(this.dialogCadastroPaciente.getConvenio());

        ControladorFrame.repositorioPacientes.addPaciente(this.paciente);
    }
}