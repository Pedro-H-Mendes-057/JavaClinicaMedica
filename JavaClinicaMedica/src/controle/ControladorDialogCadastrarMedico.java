package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import dialogCadastroPanels.DialogCadastrarMedico;
import modelo.Medico;
import modelo.Paciente;

public class ControladorDialogCadastrarMedico implements ActionListener {
    DialogCadastrarMedico dialogCadastrarMedico;
    JTable tableHorarios;
    private Medico medico;

    public ControladorDialogCadastrarMedico(DialogCadastrarMedico dialogCadastrarMedico) {
        this.dialogCadastrarMedico = dialogCadastrarMedico;
        tableHorarios = this.dialogCadastrarMedico.getTableHorarios();
        System.out.println("teste CONTROLADOR ");
        addEventos();
        this.dialogCadastrarMedico.setVisible(true);
    }

    void addEventos() {
        this.dialogCadastrarMedico.getButtonSalvar().addActionListener(this);
    	this.dialogCadastrarMedico.getButtonCancelar().addActionListener(e-> {
    		dialogCadastrarMedico.dispose();
    	});
    	    	
        tableHorarios.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int row = tableHorarios.rowAtPoint(e.getPoint());
                int col = tableHorarios.columnAtPoint(e.getPoint());

                System.out.println("teste tabela dialog cadastrar medico");

                if (row >= 0 && col >= 1) {
                    tableHorarios.getModel().setValueAt("  X  ", row, col);
                }//do if de tabela
            }//do mouseClicked
        });//do tabelHorarios
    }//do AddEventos

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.dialogCadastrarMedico.getButtonSalvar()) {
            try {
                String nome = this.dialogCadastrarMedico.getTextFieldNome().getText();
                String contato = this.dialogCadastrarMedico.getTextFieldContato().getText();
                String crm = this.dialogCadastrarMedico.getTextFieldCRM().getText();
                String especialidade = this.dialogCadastrarMedico.getTextFieldEspecialidade().getText();
                double valorConsulta = Double.parseDouble(this.dialogCadastrarMedico.getTextFieldValor().getText());

                if (ValidosCamposVazios() == false) {
                    return;
                } else {
                    JOptionPane.showMessageDialog(this.dialogCadastrarMedico,
                            "Médico salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    addMedico(/*nome, contato, crm, especialidade, valorConsulta*/);
                    this.dialogCadastrarMedico.dispose();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this.dialogCadastrarMedico, 
                        "Preenchimento inválido!");
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this.dialogCadastrarMedico, 
                        "Preenchimento inválido!");
            }
        } 
    } //actionPerformed
    
    private boolean ValidosCamposVazios() {
        if (dialogCadastrarMedico.getTextFieldNome().getText().trim().isEmpty()) {
        	JOptionPane.showMessageDialog(dialogCadastrarMedico, "Preencha todos os campos!");
            return false;
        }

        String contato = dialogCadastrarMedico.getTextFieldContato().getText().trim();
        if (contato.isEmpty() || contato.contains("_")) {
        	JOptionPane.showMessageDialog(dialogCadastrarMedico, "Preencha todos os campos!");
            return false;
        }

        String crm = dialogCadastrarMedico.getTextFieldCRM().getText().trim();
        if (crm.isEmpty()) {
        	JOptionPane.showMessageDialog(dialogCadastrarMedico, "Preencha todos os campos!");
            return false;
        }
        try {
            int crmNumber = Integer.parseInt(crm);
            if (crmNumber <= 0) {
            	JOptionPane.showMessageDialog(dialogCadastrarMedico, "CRM Invalido!");
                return false;
            }
        } catch (NumberFormatException e) {
        	JOptionPane.showMessageDialog(dialogCadastrarMedico, "CRM deve conter numeros!");
            return false;
        }

        if (dialogCadastrarMedico.getTextFieldEspecialidade().getText().trim().isEmpty()) {
        	JOptionPane.showMessageDialog(dialogCadastrarMedico, "Preencha todos os campos!");
            return false;
        }

        String valorConsultaStr = dialogCadastrarMedico.getTextFieldValor().getText().trim();
        if (valorConsultaStr.isEmpty()) {
        	JOptionPane.showMessageDialog(dialogCadastrarMedico, "Preencha todos os campos!");
            return false;
        }
        try {
            double valorConsulta = Double.parseDouble(valorConsultaStr);
            if (valorConsulta <= 0) {
            	JOptionPane.showMessageDialog(dialogCadastrarMedico, "Preenchimento inválido!");
                return false;
            }
        } catch (NumberFormatException e) {
        	JOptionPane.showMessageDialog(dialogCadastrarMedico, "Valor deve ser um número!");
            return false;
        }
        return true;
    }

    public void addMedico() {
        this.medico = new Medico();
        this.medico.setNome(this.dialogCadastrarMedico.getTextFieldNome().getText().trim());
        this.medico.setContato(this.dialogCadastrarMedico.getTextFieldContato().getText().trim());
        this.medico.setCrm(this.dialogCadastrarMedico.getTextFieldCRM().getText().trim());
        this.medico.setEspecialidade(this.dialogCadastrarMedico.getTextFieldEspecialidade().getText().trim());
        this.medico.setValorConsulta(Double.parseDouble(this.dialogCadastrarMedico.getTextFieldValor().getText().trim()));
        ControladorFrame.repositorioMedicos.addMedico(this.medico);
        
        
        /*
        this.medico = new Paciente();
        this.medico.setNome(this.dialogCadastrarMedico.getNome());
        this.medico.setContato(this.dialogCadastrarMedico.getContato());
        this.medico.setCrm(this.dialogCadastrarMedico.getCrm());
        this.medico.setEspecialidade(this.dialogCadastrarMedico.getEspecialidade());
        this.medico.setValorConsulta(this.dialogCadastrarMedico.getValorConsulta());
        ControladorFrame.repositorioMedicos.addMedico(medico);
        */
    }
}
