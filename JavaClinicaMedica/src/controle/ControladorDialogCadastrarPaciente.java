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
    	    	verifCampoVazio(); 
    	        String nome = txFNomePaciente.getText();
    	        String dataNasc = txFDataNasc.getText();
    	        String contato = txFContato.getText();
    	        String tipoSang = cbTipoSang.getSelectedItem().toString();
    	        int altura = Integer.parseInt(txFAltura.getText());
    	        if (altura <= 0) {
    	        	throw new IllegalArgumentException("Altura inválida!");
    	        }
    	        double peso = Double.parseDouble(txFPeso.getText());
    	        if (peso <= 0) {
    	        	throw new IllegalArgumentException("Peso inválido!");
    	        }
    	        String convenio = cbConvenio.getSelectedItem().toString();

    	        JOptionPane.showMessageDialog(DialogCadastrarPaciente.this, 
    	        "Paciente salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    	        this.dialogCadastrarPaciente.dispose();

    	        } catch (NumberFormatException ex) {
    	            JOptionPane.showMessageDialog(DialogCadastrarPaciente.this, 
    	                "Preenchimento inválido! Altura e peso devem ser numéricos.", 
    	                "Erro", JOptionPane.ERROR_MESSAGE);
    	        } catch (IllegalArgumentException ex) {
    	            JOptionPane.showMessageDialog(DialogCadastrarPaciente.this, 
    	                ex.getMessage(), 
    	                "Preenchimento inválido!", JOptionPane.ERROR_MESSAGE);
    	        }
    	        }
    	        });
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