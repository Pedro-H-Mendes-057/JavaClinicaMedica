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
            //addPaciente();
            //this.dialogCadastrarPaciente.dispose();
    	    try { 
    	        String nome = this.dialogCadastrarPaciente.getTxFNomePaciente().getText();
    	        String dataNasc = this.dialogCadastrarPaciente.getTxFDataNasc().getText();
    	        String contato = this.dialogCadastrarPaciente.getTxFContato().getText();
    	        String tipoSang = this.dialogCadastrarPaciente.getTxFTipoSang().getText();
    	        int altura = Integer.parseInt(this.dialogCadastrarPaciente.getTxFAltura().getText());
    	        double peso = Double.parseDouble(this.dialogCadastrarPaciente.getTxFPeso().getText());
    	        String convenio = this.dialogCadastrarPaciente.getCbConvenio().getSelectedItem().toString();
    	        
    	        if(verifCampoVazio()) {
    	        	throw new IllegalArgumentException ("Preencha todos os campos!");
    	        } else if (altura <= 0) {
    	        	throw new IllegalArgumentException("Altura inválida!");
    	        } else if (peso <= 0) {
    	        	throw new IllegalArgumentException("Peso inválido!");
    	        } else {
    	        	JOptionPane.showMessageDialog(this.dialogCadastrarPaciente, 
    	       		"Paciente salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    	        	this.dialogCadastrarPaciente.dispose();
    	        }
    	        } catch (IllegalArgumentException ex) {
    	            JOptionPane.showMessageDialog(this.dialogCadastrarPaciente, 
    	                ex.getMessage(), "Preenchimento inválido!", JOptionPane.ERROR_MESSAGE);
    	            	this.dialogCadastrarPaciente.dispose();
    	        } /*catch (NumberFormatException ex) {
    	            JOptionPane.showMessageDialog(dialogCadastrarPaciente, 
        	                "Preenchimento inválido! Altura e peso devem ser numéricos.", 
        	                "Erro", JOptionPane.ERROR_MESSAGE);
        	            	this.dialogCadastrarPaciente.dispose();
        	    }*/
    	}
    }
    private boolean verifCampoVazio(){
    		if(this.dialogCadastrarPaciente.getTxFNomePaciente().getText().trim().isEmpty()||
    			this.dialogCadastrarPaciente.getTxFDataNasc().getText().trim().isEmpty() ||
    			this.dialogCadastrarPaciente.getTxFContato().getText().trim().isEmpty()||
    			this.dialogCadastrarPaciente.getTxFAltura().getText().trim().isEmpty()||
    			this.dialogCadastrarPaciente.getTxFPeso().getText().trim().isEmpty()||
    	        (this.dialogCadastrarPaciente.getCbTipoSang().getSelectedItem() == null || 
    	        this.dialogCadastrarPaciente.getCbTipoSang().getSelectedItem().toString().trim().isEmpty())||
    	        (this.dialogCadastrarPaciente.getCbConvenio().getSelectedItem() == null || 
    	        this.dialogCadastrarPaciente.getCbConvenio().getSelectedItem().toString().trim().isEmpty())) {
    			return true;
    		}else {
    			return false;
    		}
    }// do verifCampoVazio
    
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