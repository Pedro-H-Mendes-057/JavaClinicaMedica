package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

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
    	    try { 
    	        String nome = this.dialogCadastrarPaciente.getTxFNomePaciente().getText();
    	        String dataNasc = this.dialogCadastrarPaciente.getTxFDataNasc().getText();
    	        String contato = this.dialogCadastrarPaciente.getTxFContato().getText();
    	        String tipoSang = this.dialogCadastrarPaciente.getTxFTipoSang().getText();
    	        int altura = Integer.parseInt(this.dialogCadastrarPaciente.getTxFAltura().getText());
    	        double peso = Double.parseDouble(this.dialogCadastrarPaciente.getTxFPeso().getText());
    	        String convenio = this.dialogCadastrarPaciente.getCbConvenio().getSelectedItem().toString();
    	        
    	        //por algum motivo, não exibe a mensagem "preencha todos os campos", por isso o 1º if está comentado
    	        
    	        /*if(verifCampoVazio(nome, dataNasc, contato, tipoSang, altura, peso, convenio)) {
    	        	throw new IllegalArgumentException ("Preencha todos os campos!");
    	        } else */if (altura <= 0) {
    	        	throw new IllegalArgumentException("Altura inválida!");
    	        } else if (peso <= 0) {
    	        	throw new IllegalArgumentException("Peso inválido!");
    	        } else {
    	        	JOptionPane.showMessageDialog(this.dialogCadastrarPaciente, 
    	       		"Paciente salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    	        	addPaciente();
    	        	this.dialogCadastrarPaciente.dispose();
    	        }
    	        } catch (IllegalArgumentException ex) {
    	            JOptionPane.showMessageDialog(this.dialogCadastrarPaciente, 
    	                ex.getMessage(), "Preenchimento inválido!", JOptionPane.ERROR_MESSAGE);
    	            	//this.dialogCadastrarPaciente.dispose();
    	        }
    	}
    }
    
    private boolean verifCampoVazio(String nome, String dataNasc, String contato, String tipoSang,
    		int altura, double peso, String convenio){
    	
    	return nome.trim().isEmpty() || dataNasc.trim().isEmpty() || contato.trim().isEmpty() || tipoSang.trim().isEmpty()
    	        || altura == 0 || peso == 0|| convenio.trim().isEmpty();
    	
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