package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import modelo.Endereco;
import modelo.Paciente;
import controle.ControladorPanelPacientes;
import dialogCadastroPanels.DialogEDITARPaciente;
import exportacoes.ExportarDados;

public class ControladorDialogEDITARPaciente implements ActionListener {
    DialogEDITARPaciente dialogEditarPaciente;
    Paciente paciente;
    Endereco endereco; 

    public ControladorDialogEDITARPaciente(DialogEDITARPaciente dialogEditarMaterial, Paciente paciente) {
        this.dialogEditarPaciente = dialogEditarMaterial;
        this.paciente = paciente;
        addEventos();
        
        this.dialogEditarPaciente.setVisible(true);
    }
    
    void addEventos() {
        this.dialogEditarPaciente.getBtSalvar().addActionListener(this);
        this.dialogEditarPaciente.getBtCancelar().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
    	if(e.getSource() == this.dialogEditarPaciente.getBtCancelar()){
    		this.dialogEditarPaciente.dispose();
    	}
        if (e.getSource() == this.dialogEditarPaciente.getBtSalvar()) {
    	    try { 
    	    	if (verifCamposVazios() == false) {
    	    		return;
    	    	}
    	        String nome = this.dialogEditarPaciente.getTxFNomePaciente().getText();
    	        String dataNasc = this.dialogEditarPaciente.getTxFDataNasc().getText();
    	        String contato = this.dialogEditarPaciente.getTxFContato().getText();
    	        String tipoSang = dialogEditarPaciente.getCbTipoSang().getSelectedItem().toString();
    	        double altura = Double.parseDouble(this.dialogEditarPaciente.getTxFAltura().getText());
    	        double peso = Double.parseDouble(this.dialogEditarPaciente.getTxFPeso().getText());
    	        String convenio = this.dialogEditarPaciente.getCbConvenio().getSelectedItem().toString();
    	        String estado = this.dialogEditarPaciente.getCBEstado().getSelectedItem().toString();
    	        String rua = dialogEditarPaciente.getTxFRua().getText();
                String bairro = dialogEditarPaciente.getTxFBairro().getText();
                String cidade = dialogEditarPaciente.getTxFCidade().getText();
                String cep = dialogEditarPaciente.getTxFCEP().getText();
                String numero = dialogEditarPaciente.getTxFNumero().getText(); 

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
    	        	JOptionPane.showMessageDialog(this.dialogEditarPaciente, 
    	       		"Paciente atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    	        	addPaciente();
    	        	this.dialogEditarPaciente.dispose();
    	        }
    	    } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this.dialogEditarPaciente, 
                    ex.getMessage(), "Preenchimento inválido!", JOptionPane.ERROR_MESSAGE);             
            }
        }
    }
    
    private boolean verifCamposVazios() {
        if (dialogEditarPaciente.getTxFNomePaciente().getText().isBlank() ||
            dialogEditarPaciente.getTxFDataNasc().getText().isBlank() ||
            dialogEditarPaciente.getTxFContato().getText().isBlank() ||
            dialogEditarPaciente.getTxFAltura().getText().isBlank() ||
            dialogEditarPaciente.getTxFPeso().getText().isBlank() ||
            dialogEditarPaciente.getCbConvenio().getSelectedItem().toString().isBlank() ||
            dialogEditarPaciente.getTxFNumero().getText().isBlank() ||
            dialogEditarPaciente.getTxFRua().getText().isBlank() ||
            dialogEditarPaciente.getTxFBairro().getText().isBlank() ||
            dialogEditarPaciente.getTxFCidade().getText().isBlank() ||
            dialogEditarPaciente.getCBEstado().getSelectedItem().toString().isBlank()) {
            JOptionPane.showMessageDialog(dialogEditarPaciente, 
                                          "Preencha todos os campos!", "Erro", 
                                          JOptionPane.ERROR_MESSAGE);
            return false;
        }
        String mascDataNasc = "  /  /    ";
        String mascContato = "(  )     -    ";
        String mascCEP = "     -   ";
        if (dialogEditarPaciente.getTxFDataNasc().getText().equals(mascDataNasc)) {
        	  JOptionPane.showMessageDialog(dialogEditarPaciente, 
                      "Preencha todos os campos! (data nasc)", "Erro", 
                      JOptionPane.ERROR_MESSAGE);
        	  return false;
        }
        if (dialogEditarPaciente.getTxFContato().getText().equals(mascContato)) {
        	JOptionPane.showMessageDialog(dialogEditarPaciente, 
                    "Preencha todos os campos! (contato)", "Erro", 
                    JOptionPane.ERROR_MESSAGE);
        	return false;
        }
        if (dialogEditarPaciente.getTxFCEP().getText().equals(mascCEP)) {
        	JOptionPane.showMessageDialog(dialogEditarPaciente, 
                    "Preencha todos os campos! (cep)", "Erro", 
                    JOptionPane.ERROR_MESSAGE);
        }
        return true;
    } 
    
    
    public void addPaciente() {
        this.paciente = new Paciente();
        this.paciente.setNome(this.dialogEditarPaciente.getNomePaciente());
        this.paciente.setDataNasc(this.dialogEditarPaciente.getDataNascimento());
        this.paciente.setContato(this.dialogEditarPaciente.getContato());
        this.paciente.setAltura(this.dialogEditarPaciente.getAltura());
        this.paciente.setTipoSang(this.dialogEditarPaciente.getTipoSang());
        this.paciente.setPeso(this.dialogEditarPaciente.getPeso());
        this.paciente.setConvenio(this.dialogEditarPaciente.getConvenio());
        
        this.endereco = new Endereco();
        this.endereco.setRua(this.dialogEditarPaciente.getTxFRua().getText());
	this.endereco.setNumero(this.dialogEditarPaciente.getTxFNumero().getText());      
        this.endereco.setBairro(this.dialogEditarPaciente.getTxFBairro().getText());
        this.endereco.setCep(this.dialogEditarPaciente.getTxFCEP().getText());
        this.endereco.setCidade(this.dialogEditarPaciente.getTxFCidade().getText());
        this.endereco.setEstado(this.dialogEditarPaciente.getEstado());

        this.paciente.setEndereco(this.endereco);
        ControladorFrame.repositorioPacientes.addPaciente(this.paciente);
        ExportarDados.anexarPaciente(this.paciente);
        //System.out.print("teste");
    }
}