package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import dialogCadastroPanels.DialogCadastrarMedico;
import exportacoes.ExportarDados;
import modelo.Medico;
import modelo.Paciente;

public class ControladorDialogCadastrarMedico implements ActionListener {
    private DialogCadastrarMedico dialogCadastrarMedico;
    private JTable tableHorarios;
    private Medico medico;
    private int qtdHorasAtend;

    public ControladorDialogCadastrarMedico(DialogCadastrarMedico dialogCadastrarMedico) {
        this.dialogCadastrarMedico = dialogCadastrarMedico;
        tableHorarios = this.dialogCadastrarMedico.getTableHorarios();  
        this.qtdHorasAtend = 0;
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
                               
                if (row >= 0 && col >= 1) {
                    if (tableHorarios.getModel().getValueAt(row, col) == "X") {
                        tableHorarios.getModel().setValueAt("", row, col);
                        qtdHorasAtend--;
                    } else if (tableHorarios.getModel().getValueAt(row, col) != "X") {
                        tableHorarios.getModel().setValueAt("X", row, col);
                        qtdHorasAtend++;
                    }
                }
                //System.out.println(qtdHorasAtend);
            }
           
        });
    }    
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.dialogCadastrarMedico.getButtonSalvar()) {
            try {              
                if (validosCamposVazios() == false) {
                    return;
                } else {
                    JOptionPane.showMessageDialog(this.dialogCadastrarMedico,
                            "Médico salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    addMedico();
                    this.dialogCadastrarMedico.dispose();
                   // System.out.println(this.qtdHorasAtend);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this.dialogCadastrarMedico, 
                        "Preenchimento inválido!");
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this.dialogCadastrarMedico, 
                        "Preenchimento inválido!");
            }
        } 
    } 
    
    private boolean validosCamposVazios() {
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
        
        if (this.qtdHorasAtend == 0) {
            JOptionPane.showMessageDialog(dialogCadastrarMedico, "Selecione os horários de atendimento do médico!");
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
        
        
        for (int row = 0; row < 11; row++) { 
            for (int col = 1; col < 6; col++) {         
                if (tableHorarios.getModel().getValueAt(row, col) == "X") {
                    this.medico.getHorasAtend()[row][col - 1] = 1;
                } else if (tableHorarios.getModel().getValueAt(row, col) != "X") {
                    this.medico.getHorasAtend()[row][col - 1] = 0;
                }
            }
        }
        ExportarDados.anexarMedico(this.medico, ControladorFrame.repositorioMedicos.contador);
        ControladorFrame.repositorioMedicos.addMedico(this.medico);
        
        /*for (int row = 0; row < 11; row++) { 
            for (int col = 0; col < 5; col++) {         
                System.out.print(this.medico.getHorasAtend()[row][col] + " ");
            }
            System.out.println();
        }*/
        
        ControladorFrame.frame.getPanelExames().getBTNNovo().setEnabled(true);
        ControladorFrame.frame.getPanelExames().getBTNEditar().setEnabled(true);
        ControladorFrame.frame.getPanelExames().getBTNExcluir().setEnabled(true);
    }
}
