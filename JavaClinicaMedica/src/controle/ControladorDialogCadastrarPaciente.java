package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.Paciente;
import controle.ControladorPanelPacientes;
import dialogCadastroPanels.DialogCadastrarPaciente;
import exportacoes.ExportarDados;
import modelo.Endereco;
import repositorio.RepositorioPacientes;

public class ControladorDialogCadastrarPaciente implements ActionListener {
    private DialogCadastrarPaciente dialogCadastrarPaciente;
    private Paciente paciente;
    private Endereco endereco;

    // Construtor que recebe o DialogCadastroPaciente
    public ControladorDialogCadastrarPaciente(DialogCadastrarPaciente dialogCadastrarPaciente) {
        this.dialogCadastrarPaciente = dialogCadastrarPaciente;        
        addEventos();        
        this.dialogCadastrarPaciente.setVisible(true);
    }

    void addEventos() {
        this.dialogCadastrarPaciente.getBtSalvar().addActionListener(this);
        this.dialogCadastrarPaciente.getBtCancelar().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
    	if(e.getSource() == this.dialogCadastrarPaciente.getBtCancelar()){
    		this.dialogCadastrarPaciente.dispose();
    	}
        if (e.getSource() == this.dialogCadastrarPaciente.getBtSalvar()) {
    	    try { 
    	    	if (verifCamposVazios() == false) {
    	    		return;
    	    	}
    	        String nome = this.dialogCadastrarPaciente.getTxFNomePaciente().getText();
    	        String dataNasc = this.dialogCadastrarPaciente.getTxFDataNasc().getText();
    	        String contato = this.dialogCadastrarPaciente.getTxFContato().getText();
    	        String tipoSang = dialogCadastrarPaciente.getCbTipoSang().getSelectedItem().toString();
    	        double altura = Double.parseDouble(this.dialogCadastrarPaciente.getTxFAltura().getText());
    	        double peso = Double.parseDouble(this.dialogCadastrarPaciente.getTxFPeso().getText());
    	        String convenio = this.dialogCadastrarPaciente.getCbConvenio().getSelectedItem().toString();
    	        String estado = this.dialogCadastrarPaciente.getCBEstado().getSelectedItem().toString();
    	        String rua = dialogCadastrarPaciente.getTxFRua().getText();
                String bairro = dialogCadastrarPaciente.getTxFBairro().getText();
                String cidade = dialogCadastrarPaciente.getTxFCidade().getText();
                String cep = dialogCadastrarPaciente.getTxFCEP().getText();
                String numero = dialogCadastrarPaciente.getTxFNumero().getText(); 

                Endereco endereco = new Endereco();
                endereco.setRua(rua);
                endereco.setBairro(bairro);
                endereco.setCidade(cidade);
                endereco.setCep(cep);
                endereco.setEstado(estado);
                endereco.setNumero(numero);

                if (nome.matches(".*\\d.*") || estado.matches(".*\\d.*") || rua.matches(".*\\d.*") ||
                							bairro.matches(".*\\d.*") || cidade.matches(".*\\d.*")) {
                    throw new IllegalArgumentException("Preenchimento inválido!");
                }
    	        
    	        if (altura <= 0) {
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
            }
        }
    }
    
    private boolean verifCamposVazios() {
        if (dialogCadastrarPaciente.getTxFNomePaciente().getText().isBlank() ||
            dialogCadastrarPaciente.getTxFDataNasc().getText().isBlank() ||
            dialogCadastrarPaciente.getTxFContato().getText().isBlank() ||
            dialogCadastrarPaciente.getTxFAltura().getText().isBlank() ||
            dialogCadastrarPaciente.getTxFPeso().getText().isBlank() ||
            dialogCadastrarPaciente.getCbConvenio().getSelectedItem().toString().isBlank() ||
            dialogCadastrarPaciente.getTxFNumero().getText().isBlank() ||
            dialogCadastrarPaciente.getTxFRua().getText().isBlank() ||
            dialogCadastrarPaciente.getTxFBairro().getText().isBlank() ||
            dialogCadastrarPaciente.getTxFCidade().getText().isBlank() ||
            dialogCadastrarPaciente.getCBEstado().getSelectedItem().toString().isBlank()) {
            JOptionPane.showMessageDialog(dialogCadastrarPaciente, 
                                          "Preencha todos os campos!", "Erro", 
                                          JOptionPane.ERROR_MESSAGE);
            return false;
        }
        String mascDataNasc = "  /  /    ";
        String mascContato = "(  )     -    ";
        String mascCEP = "     -   ";
        if (dialogCadastrarPaciente.getTxFDataNasc().getText().equals(mascDataNasc)) {
        	  JOptionPane.showMessageDialog(dialogCadastrarPaciente, 
                      "Preencha todos os campos! (data nasc)", "Erro", 
                      JOptionPane.ERROR_MESSAGE);
        	  return false;
        }
        if (dialogCadastrarPaciente.getTxFContato().getText().equals(mascContato)) {
        	JOptionPane.showMessageDialog(dialogCadastrarPaciente, 
                    "Preencha todos os campos! (contato)", "Erro", 
                    JOptionPane.ERROR_MESSAGE);
        	return false;
        }
        if (dialogCadastrarPaciente.getTxFCEP().getText().equals(mascCEP)) {
        	JOptionPane.showMessageDialog(dialogCadastrarPaciente, 
                    "Preencha todos os campos! (cep)", "Erro", 
                    JOptionPane.ERROR_MESSAGE);
        }
        return true;
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
        
        this.endereco = new Endereco();
        this.endereco.setRua(this.dialogCadastrarPaciente.getTxFRua().getText());
	this.endereco.setNumero(this.dialogCadastrarPaciente.getTxFNumero().getText());      
        this.endereco.setBairro(this.dialogCadastrarPaciente.getTxFBairro().getText());
        this.endereco.setCep(this.dialogCadastrarPaciente.getTxFCEP().getText());
        this.endereco.setCidade(this.dialogCadastrarPaciente.getTxFCidade().getText());
        this.endereco.setEstado(this.dialogCadastrarPaciente.getEstado());

        this.paciente.setEndereco(this.endereco);
        ControladorFrame.repositorioPacientes.addPaciente(this.paciente);
        ExportarDados.anexarPaciente(this.paciente);
        //System.out.print("teste");
    }
}