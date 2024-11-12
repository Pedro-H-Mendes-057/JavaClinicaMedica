package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Paciente;
import controle.ControladorPanelPacientes;
import dialogCadastroPanels.DialogCadastrarPaciente;
import repositorio.RepositorioPacientes;

public class ControladorDialogCadastrarPaciente implements ActionListener {
    private DialogCadastrarPaciente dialogCadastrarPaciente;
    private Paciente paciente;

    // Construtor que recebe o DialogCadastroPaciente
    public ControladorDialogCadastrarPaciente(DialogCadastrarPaciente dialogCadastrarPaciente) {
        this.dialogCadastrarPaciente = dialogCadastrarPaciente;
        
        addEventos();
        
        this.dialogCadastrarPaciente.setVisible(true);
    }

    void addEventos() {
        this.dialogCadastrarPaciente.getBtSalvar().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
       if (e.getSource() == this.dialogCadastrarPaciente.getBtSalvar()) {            
            addPaciente();
            this.dialogCadastrarPaciente.dispose();
        }
    }  
    
    public void addPaciente() {
        this.paciente = new Paciente();
        this.paciente.setNome(this.dialogCadastrarPaciente.getNomePaciente());
        this.paciente.setDataNasc(this.dialogCadastrarPaciente.getDataNascimento());
        this.paciente.setContato(this.dialogCadastrarPaciente.getContato());
        this.paciente.setAltura(this.dialogCadastrarPaciente.getAltura());
        this.paciente.setTipoSang(this.dialogCadastrarPaciente.getTipoSang());
        this.paciente.setPeso(this.dialogCadastrarPaciente.getPeso());
        this.paciente.setConvenio(this.dialogCadastrarPaciente.getConvenio());

        ControladorFrame.repositorioPacientes.addPaciente(this.paciente);
    }
}