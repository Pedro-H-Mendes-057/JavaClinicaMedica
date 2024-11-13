package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import dialogCadastroPanels.DialogCadastrarMedico;

public class ControladorDialogCadastrarMedico implements ActionListener {
    DialogCadastrarMedico dialogCadastrarMedico;
    JTable tableHorarios;

    public ControladorDialogCadastrarMedico(DialogCadastrarMedico dialogCadastrarMedico) {
        this.dialogCadastrarMedico = dialogCadastrarMedico;
        tableHorarios = this.dialogCadastrarMedico.getTableHorarios();
        System.out.println("teste CONTROLADOR ");
        addEventos();
        this.dialogCadastrarMedico.setVisible(true);
    }

    void addEventos() {
        this.dialogCadastrarMedico.getButtonSalvar().addActionListener(this);

        tableHorarios.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int row = tableHorarios.rowAtPoint(e.getPoint());
                int col = tableHorarios.columnAtPoint(e.getPoint());

                System.out.println("teste 2");

                if (row >= 1 && col >= 0) {
                    tableHorarios.getModel().setValueAt("  X  ", row, col);
                }
            }
        });
    }

   
    public boolean validarCampos() {
        try {
            
            if (dialogCadastrarMedico.getTextFieldNome().getText().trim().isEmpty()) {
                throw new IllegalArgumentException("Preencha o Nome!");
            }

            // Valida Contato
            if (dialogCadastrarMedico.getTextFieldContato().getText().trim().isEmpty()) {
                throw new IllegalArgumentException("Preencha o Contato!");
            }
            String contato = dialogCadastrarMedico.getTextFieldContato().getText().trim();
            try {
                Long.parseLong(contato);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Contato deve ser um número!");
            }
            if (dialogCadastrarMedico.getTextFieldCRM().getText().trim().isEmpty()) {
                throw new IllegalArgumentException("Preencha o CRM!");
            }
            String crm = dialogCadastrarMedico.getTextFieldCRM().getText().trim();
            try {
                int crmNumber = Integer.parseInt(crm);
                if (crmNumber <= 0) {
                    throw new IllegalArgumentException("CRM inválido!");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("CRM deve ser um número!");
            }
            if (dialogCadastrarMedico.getTextFieldEspecialidade().getText().trim().isEmpty()) {
                throw new IllegalArgumentException("Preencha a Especialidade!");
            }

            if (dialogCadastrarMedico.getTextFieldValor().getText().trim().isEmpty()) {
                throw new IllegalArgumentException("Preencha o Valor da Consulta!");
            }
            double valorConsulta = Double.parseDouble(dialogCadastrarMedico.getTextFieldValor().getText());
            if (valorConsulta <= 0) {
                throw new IllegalArgumentException("O valor da consulta deve ser maior que zero!");
            }

            return true;

        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(dialogCadastrarMedico, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.dialogCadastrarMedico.getButtonSalvar()) {
            try {
                String nome = this.dialogCadastrarMedico.getTextFieldNome().getText();
                String contato = this.dialogCadastrarMedico.getTextFieldContato().getText();
                String crm = this.dialogCadastrarMedico.getTextFieldCRM().getText();
                String especialidade = this.dialogCadastrarMedico.getTextFieldEspecialidade().getText();
                double valorConsulta = Double.parseDouble(this.dialogCadastrarMedico.getTextFieldValor().getText());

                if (!validarCampos()) {
                    return;
                } else {
                    JOptionPane.showMessageDialog(this.dialogCadastrarMedico,
                            "Médico salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    addMedico(nome, contato, crm, especialidade, valorConsulta);
                    this.dialogCadastrarMedico.dispose();
                }
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this.dialogCadastrarMedico, 
                        "Preenchimento inválido!", JOptionPane.ERROR_MESSAGE);
            } /*catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this.dialogCadastrarMedico, 
                        "Preenchimento inválido!", JOptionPane.ERROR_MESSAGE);
            }*/
        }
    }
}
