/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import dialogCadastroPanels.DialogCadastrarConsulta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Medico;

/**
 *
 * @author fonfon
 */
public class ControladorDialogCadastrarConsulta implements ActionListener{
    DialogCadastrarConsulta dialogCadastrarConsulta;
    private int chaveMedico;
    Medico medico;
    
    public ControladorDialogCadastrarConsulta(DialogCadastrarConsulta dialogCadastrarConsulta, int chaveMedico) {
       this.dialogCadastrarConsulta = dialogCadastrarConsulta;
       this.chaveMedico = chaveMedico;
       this.medico = ControladorFrame.repositorioMedicos.getMedicos().get(chaveMedico);
       this.dialogCadastrarConsulta.getTextFieldNomeMedico().setText(this.medico.getNome());
       
       addEventos();
       
       this.dialogCadastrarConsulta.setVisible(true);
    }
    
    void addEventos() {
        this.dialogCadastrarConsulta.getButtonSalvar().addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.dialogCadastrarConsulta.getButtonSalvar()) {
            salvarConsulta();
        }
    }
    
    void salvarConsulta() {
        String [] erros = {this.medico.getNome() + " não atende na data e horário selecionados!", 
        "Já existe uma consulta cadastrada na data e horário selecionados!"};
        
        Calendar calendar = Calendar.getInstance();
        Date dataSelecionada = (Date) this.dialogCadastrarConsulta.getJDatePicker().getModel().getValue();
        calendar.setTime(dataSelecionada);
        //System.out.println(dataSelecionada);
        int diaDaSemana = calendar.get(Calendar.DAY_OF_WEEK) - 2;
        int horarioSelecionado = this.dialogCadastrarConsulta.getjComboBoxHorario().getSelectedIndex();
        //System.out.println("Horário selecionado: " + horarioSelecionado);
        //System.out.println("Data selecionada: " + diaDaSemana);
        if (diaDaSemana != -1 && diaDaSemana != 5 && medico.getHorasAtend()[horarioSelecionado][diaDaSemana] == 1) {
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
            String horario = (String) this.dialogCadastrarConsulta.getjComboBoxHorario().getSelectedItem();
            String chaveConsulta = "M=" + chaveMedico + "#D=" + formatador.format(dataSelecionada) + "#H=" + horario;
            if (ControladorFrame.repositorioConsultas.getConsulta(chaveConsulta) == false) {
                ControladorFrame.repositorioConsultas.addConsulta(chaveConsulta, chaveConsulta);
            } else {
                JOptionPane.showMessageDialog(this.dialogCadastrarConsulta, erros[1]);
            }
            System.out.println("Chave consulta: " + chaveConsulta);
        } else {
            JOptionPane.showMessageDialog(this.dialogCadastrarConsulta, erros[0]);
        }
    }
}
