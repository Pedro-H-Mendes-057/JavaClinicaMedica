/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import dialogCadastroPanels.DialogBuscar;
import dialogCadastroPanels.DialogCadastrarConsulta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Consulta;
import modelo.Medico;
import modelo.Paciente;

/**
 *
 * @author fonfon
 */
public class ControladorDialogCadastrarConsulta implements ActionListener{
    DialogCadastrarConsulta dialogCadastrarConsulta;
    private int chaveMedico;
    Medico medico;
    Consulta consulta;
    Paciente paciente;
    ControladorDialogBuscarPaciente controladorDialogBuscarPaciente;
    DialogBuscar dialogBuscarPaciente;
    ControladorDialogBuscarMaterial controladorDialogBuscarMaterial;
    DialogBuscar dialogBuscarMaterial;
    int chavePaciente;
    int chaveMaterial;
    int [] chaveMateriais;
    int countMateriais;
    
    public ControladorDialogCadastrarConsulta(DialogCadastrarConsulta dialogCadastrarConsulta, int chaveMedico) {
       this.dialogCadastrarConsulta = dialogCadastrarConsulta;
       this.chaveMedico = chaveMedico;
       this.medico = ControladorFrame.repositorioMedicos.getMedicos().get(chaveMedico);
       this.dialogCadastrarConsulta.getTextFieldNomeMedico().setText(this.medico.getNome()); 
       this.countMateriais = 0;
       this.chaveMateriais = new int[1000];
       addEventos();
       
       this.dialogCadastrarConsulta.setVisible(true);
    }
    
    public ControladorDialogCadastrarConsulta(DialogCadastrarConsulta dialogCadastrarConsulta, int chaveMedico, String chaveConsulta) {
       this.dialogCadastrarConsulta = dialogCadastrarConsulta;
       this.chaveMedico = chaveMedico;
       this.medico = ControladorFrame.repositorioMedicos.getMedicos().get(chaveMedico);
       this.dialogCadastrarConsulta.getTextFieldNomeMedico().setText(this.medico.getNome());
       
       addEventos();
       
       this.dialogCadastrarConsulta.setVisible(true);
    }
    
    void addEventos() {
        this.dialogCadastrarConsulta.getButtonSalvar().addActionListener(this);
        this.dialogCadastrarConsulta.getButtonBuscarPaciente().addActionListener(this);
        this.dialogCadastrarConsulta.getButtonBuscarMateriais().addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.dialogCadastrarConsulta.getButtonSalvar()) {
            salvarConsulta();
        } else if (e.getSource() == this.dialogCadastrarConsulta.getButtonBuscarPaciente()) {
            this.dialogBuscarPaciente = new DialogBuscar(this.dialogCadastrarConsulta);
            this.controladorDialogBuscarPaciente = new ControladorDialogBuscarPaciente(this.dialogBuscarPaciente);
            this.chavePaciente = this.controladorDialogBuscarPaciente.getChavePaciente();
            if (this.chavePaciente != -1) {
                this.dialogCadastrarConsulta.getTextFieldNomePaciente().setText(ControladorFrame.repositorioPacientes.getPacientes().get(this.chavePaciente).getNome());
                this.dialogCadastrarConsulta.getTextFieldConvenio().setText(ControladorFrame.repositorioPacientes.getPacientes().get(this.chavePaciente).getConvenio());                
            } else {
                this.dialogCadastrarConsulta.getTextFieldNomePaciente().setText("");
                this.dialogCadastrarConsulta.getTextFieldConvenio().setText("");
            }
        } else if (e.getSource() == this.dialogCadastrarConsulta.getButtonBuscarMateriais()) {
            this.dialogBuscarMaterial = new DialogBuscar(this.dialogCadastrarConsulta);
            this.controladorDialogBuscarMaterial = new ControladorDialogBuscarMaterial(this.dialogBuscarMaterial);
            if (this.chaveMaterial != -1) {
                for (int i = 0; i < this.countMateriais; i++) {
                    if (this.chaveMateriais[i] == this.chaveMaterial) {
                        mostrarErro(1);
                    } else if (i + 1 == this.countMateriais) {
                        this.chaveMateriais[this.countMateriais++] = this.chaveMaterial;
                        addMaterial();
                    }
                } 
                
                if (this.countMateriais == 0) {
                    this.chaveMateriais[this.countMateriais++] = this.chaveMaterial;

                    addMaterial();
                }
            }            
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
            if (ControladorFrame.repositorioConsultas.procurarConsulta(chaveConsulta) == false) {
                ControladorFrame.repositorioConsultas.addConsulta(chaveConsulta, getConsulta());
            } else {
                JOptionPane.showMessageDialog(this.dialogCadastrarConsulta, erros[1]);
            }
            System.out.println("Chave consulta: " + chaveConsulta);
        } else {
            JOptionPane.showMessageDialog(this.dialogCadastrarConsulta, erros[0]);
        }
    }
    
    Consulta getConsulta() {
        this.consulta = new Consulta();

        return this.consulta;
    }

    void addMaterial() {      

        DefaultTableModel model = (DefaultTableModel) this.dialogCadastrarConsulta.getTableBuscarMateriais().getModel();         

        model.setRowCount(0);

        for (int chave = 0; chave < this.countMateriais; chave++) {
            model.addRow(new Object [] {
                ControladorFrame.repositorioMateriais.getMateriais().get(chaveMateriais[chave]).getNome(),
                1,
                chave
            });
        }
    }

    void mostrarErro(int erro) {
        if (erro == 1) {
            JOptionPane.showMessageDialog(this.dialogCadastrarConsulta, "Esse material já foi adicionado! Altere a quantidade!");
        }
        
    }
    
}
