/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import dialogCadastroPanels.DialogCadastrarMedico;


/**
 *
 * @author fonfon
 */
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
        tableHorarios.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int row = tableHorarios.rowAtPoint(e.getPoint());
                int col = tableHorarios.columnAtPoint(e.getPoint());
                
                System.out.println("teste 2");
                
                if (row >= 0 && col >= 0) {
                    tableHorarios.getModel().setValueAt("  X  ", row, col);
                }
            }
           
        });
    }
    
    private void validarPreench() {
    try {
        //NOME
        if (getTextFieldNome().getText().trim().isEmpty()) {
            throw new IllegalArgumentException("Preenchimento inválido");
        }
        
        // CRM
        String crm = dialogCadastrarMedico.getTextFieldCRM().getText().trim();
            if (crm.isEmpty()) {
                throw new IllegalArgumentException("Preencha todos os campos.");
            }
            try {
                int crmNumber = Integer.parseInt(crm);
                if (crmNumber <= 0) {
                    throw new IllegalArgumentException("Preenchimento inválido.");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Preenchimento inválido.");
            }
        
        // CONTATO
       String contato = dialogCadastrarMedico.getTextFieldContato().getText().trim();
            if (contato.isEmpty()) {
                throw new IllegalArgumentException("O campo 'Contato' é obrigatório.");
            }
            try {
                Long.parseLong(contato); // Para aceitar números longos no contato
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Preenchimento inválido.");
            }
        
        //ESPECIALIDADE
        if (getTextFieldEspecialidade().getText().trim().isEmpty()) {
            throw new IllegalArgumentException("Preencha todos os campos!");
        }
        
        // CONSULTA
        if (getTextFieldValor().getText().trim().isEmpty()) {
            throw new IllegalArgumentException("Preencha todos os campos!");
        }
        double valorConsulta = Double.parseDouble(getTextFieldValor().getText());
        if (valorConsulta <= 0) {
            throw new IllegalArgumentException("Consulta deve ter Valor maior que 0");
        }
         JOptionPane.showMessageDialog(dialogCadastrarMedico, "Cadastro realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(dialogCadastrarMedico, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(dialogCadastrarMedico, "Ocorreu um erro inesperado: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void actionPerformed(ActionEvent e) {
        
    }  
    
}
