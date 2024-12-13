/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import dialogCadastroPanels.DialogBuscar;
import dialogCadastroPanels.DialogCadastrarConsulta;
import dialogCadastroPanels.DialogEditarConsulta;
import exportacoes.ExportarDados;
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
import visual.Frame;

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
    DialogEditarConsulta dialogEditarConsulta;
    int chavePaciente;
    int chaveMaterial;
    int [] chaveMateriais;
    int countMateriais;
    String chaveConsulta;
    boolean modoEdicao;
    
    public ControladorDialogCadastrarConsulta(DialogCadastrarConsulta dialogCadastrarConsulta, int chaveMedico) {
       this.dialogCadastrarConsulta = dialogCadastrarConsulta;
       this.chaveMedico = chaveMedico;
       this.medico = ControladorFrame.repositorioMedicos.getMedicos().get(chaveMedico);
       this.dialogCadastrarConsulta.getTextFieldNomeMedico().setText(this.medico.getNome()); 
       this.countMateriais = 0;
       this.chaveMateriais = new int[1000];       
       addEventosCadastrar();
       this.modoEdicao = false;
       this.dialogCadastrarConsulta.setVisible(true);
    }
    
    public ControladorDialogCadastrarConsulta(DialogEditarConsulta dialogEditarConsulta, int chaveMedico, String chaveConsulta) {
       this.dialogEditarConsulta = dialogEditarConsulta;
       this.chaveMedico = chaveMedico;
       this.medico = ControladorFrame.repositorioMedicos.getMedicos().get(chaveMedico);
       this.dialogEditarConsulta.getTextFieldNomeMedico().setText(this.medico.getNome());       
       Consulta consulta = ControladorFrame.repositorioConsultas.getConsulta(chaveConsulta);
       this.dialogEditarConsulta.getTextFieldNomePaciente().setText(consulta.getPaciente());
       this.dialogEditarConsulta.getTextFieldConvenio().setText(consulta.getConvenio());
       this.dialogEditarConsulta.getTextAreaQueixa().setText(consulta.getQueixa());
       this.dialogEditarConsulta.getTextAreaObservacoes().setText(consulta.getObservacoes());
       this.dialogEditarConsulta.getjComboBoxTipoConsulta().setSelectedItem(consulta.getTipoConsulta());
       this.dialogEditarConsulta.getjComboBoxHorario().setSelectedItem(consulta.getHora());       
       this.dialogEditarConsulta.getTextFieldData().setText(consulta.getData());
       this.dialogEditarConsulta.getButtonBuscarMateriais().setEnabled(false);
       this.dialogEditarConsulta.getButtonBuscarPaciente().setEnabled(false);
       preencherTabelaMateriais(consulta.getMateriaisUsar());       
       this.chaveConsulta = chaveConsulta;
       addEventosEditar();
       this.modoEdicao = true;
       this.dialogEditarConsulta.setVisible(true);
    }
    
    void addEventosEditar() {
        this.dialogEditarConsulta.getButtonSalvar().addActionListener(this);
        this.dialogEditarConsulta.getButtonCancelar().addActionListener(this);
    }
    
    void addEventosCadastrar() {
        this.dialogCadastrarConsulta.getButtonSalvar().addActionListener(this);
        this.dialogCadastrarConsulta.getButtonBuscarPaciente().addActionListener(this);
        this.dialogCadastrarConsulta.getButtonBuscarMateriais().addActionListener(this);
        this.dialogCadastrarConsulta.getButtonCancelar().addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (!this.modoEdicao) {
            if (e.getSource() == this.dialogCadastrarConsulta.getButtonSalvar()) {
                if (validarCampos() && validarData() && validarMateriais()) {
                    salvarConsulta();
                    this.dialogCadastrarConsulta.dispose();
                }
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
                this.chaveMaterial = -1;
                this.dialogBuscarMaterial = new DialogBuscar(this.dialogCadastrarConsulta);
                this.controladorDialogBuscarMaterial = new ControladorDialogBuscarMaterial(this.dialogBuscarMaterial);
                this.chaveMaterial = this.controladorDialogBuscarMaterial.getChaveMaterial();          
                if (this.chaveMaterial != -1) {
                    int contTemp = this.countMateriais; 
                    for (int i = 0; i < contTemp; i++) {
                        if (this.chaveMateriais[i] == this.chaveMaterial) {
                            mostrarErro(1);
                        } else if (i + 1 == this.countMateriais) {
                            this.chaveMateriais[i] = this.chaveMaterial;
                            this.countMateriais++;
                            addMaterial();
                        }
                    }                
                    if (this.countMateriais == 0) {
                        this.chaveMateriais[this.countMateriais++] = this.chaveMaterial;

                        addMaterial();
                    }
                } 

            }
        } else {            
            if (e.getSource() == this.dialogEditarConsulta.getButtonCancelar()) {
                deletarConsulta();
                ExportarDados.atualizarTodasAsConsultas();
                this.dialogEditarConsulta.dispose(); 
            } else if (e.getSource() == this.dialogEditarConsulta.getButtonSalvar()) {                
                if (editarConsulta()) {                    
                    ExportarDados.atualizarTodasAsConsultas();
                    this.dialogEditarConsulta.dispose();
                }           
            }
        }
    }
    
    void salvarConsulta() {
        ControladorFrame.repositorioConsultas.addConsulta(this.chaveConsulta, getConsulta());            
    }
    
    void deletarConsulta() {     
        Object [][] arrayMateriais = ControladorFrame.repositorioConsultas.getConsulta(this.chaveConsulta).getMateriaisUsar();
        
        for (int i = 0; i < arrayMateriais.length; i++) {
            for (int j = 0; j < ControladorFrame.repositorioMateriais.getMateriais().size(); j++) {
                if (ControladorFrame.repositorioMateriais.getMateriais().get(j).getNome().equalsIgnoreCase(arrayMateriais[i][0].toString())) {
                    ControladorFrame.repositorioMateriais.getMateriais().get(j).setQuant(
                        ControladorFrame.repositorioMateriais.getMateriais().get(j).getQuant() + Integer.parseInt(arrayMateriais[i][1].toString())
                    );
                    ControladorFrame.repositorioMateriais.getMateriais().get(j).setUtilizado(-1);
                }
            }
        }     
        ExportarDados.atualizarTodosOsMateriais();                
        Frame.controladorPanelMateriais.atualizarTabela();
        ControladorFrame.repositorioConsultas.getConsultas().remove(this.chaveConsulta);
    }
    
    boolean editarConsulta() {
        if (this.dialogEditarConsulta.getTextAreaQueixa().getText().isBlank()
            || this.dialogEditarConsulta.getTextAreaObservacoes().getText().isBlank()) {
            JOptionPane.showMessageDialog(this.dialogEditarConsulta, "Preencha todos os campos!");
            return false;
        } else {
            Consulta consulta = ControladorFrame.repositorioConsultas.getConsulta(this.chaveConsulta);
            consulta.setObservacoes(this.dialogEditarConsulta.getTextAreaObservacoes().getText().trim());
            consulta.setQueixa(this.dialogEditarConsulta.getTextAreaQueixa().getText().trim());
            return true;
        }        
    }
    
    boolean validarData() {
        String [] erros = {this.medico.getNome() + " não atende na data e horário selecionados!", 
        "Já existe uma consulta cadastrada na data e horário selecionados!"};

        Calendar calendar = Calendar.getInstance();
        Date dataSelecionada = (Date) this.dialogCadastrarConsulta.getJDatePicker().getModel().getValue();
        calendar.setTime(dataSelecionada);       
        int diaDaSemana = calendar.get(Calendar.DAY_OF_WEEK) - 2;
        int horarioSelecionado = this.dialogCadastrarConsulta.getjComboBoxHorario().getSelectedIndex();       
        if (diaDaSemana != -1 && diaDaSemana != 5 && medico.getHorasAtend()[horarioSelecionado][diaDaSemana] == 1) {
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
            String horario = (String) this.dialogCadastrarConsulta.getjComboBoxHorario().getSelectedItem();
            this.chaveConsulta = "M=" + chaveMedico + "#D=" + formatador.format(dataSelecionada) + "#H=" + horario;
            if (ControladorFrame.repositorioConsultas.procurarConsulta(chaveConsulta) == false) {
            } else {
                JOptionPane.showMessageDialog(this.dialogCadastrarConsulta, erros[1]);
                return false;
            }
            System.out.println("Chave consulta: " + chaveConsulta);
        } else {
            JOptionPane.showMessageDialog(this.dialogCadastrarConsulta, erros[0]);
            return false;
        }
        
        return true;        
    }
    
    
    Consulta getConsulta() {
        this.consulta = new Consulta();
        this.consulta.setPaciente(this.dialogCadastrarConsulta.getTextFieldNomePaciente().getText().trim());
        this.consulta.setConvenio(this.dialogCadastrarConsulta.getTextFieldConvenio().getText().trim());
        this.consulta.setObservacoes(this.dialogCadastrarConsulta.getTextAreaObservacoes().getText().trim());
        this.consulta.setQueixa(this.dialogCadastrarConsulta.getTextAreaQueixa().getText().trim());
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");        
        this.consulta.setData(formatador.format(this.dialogCadastrarConsulta.getJDatePicker().getModel().getValue()));
        this.consulta.setMedico(this.chaveMedico);
        this.consulta.setHora(this.dialogCadastrarConsulta.getjComboBoxHorario().getSelectedItem().toString().trim());
        this.consulta.setTipoConsulta(this.dialogCadastrarConsulta.getjComboBoxTipoConsulta().getSelectedItem().toString().trim());
        
        int numLinhas = this.dialogCadastrarConsulta.getTableBuscarMateriais().getRowCount();
        Object [][] arrayMateriais = new Object[numLinhas][2]; 
        int quantidadeMateriais = this.dialogCadastrarConsulta.getTableBuscarMateriais().getRowCount();
        for (int i = 0; i < quantidadeMateriais; i++) {
            arrayMateriais[i][0] = this.dialogCadastrarConsulta.getTableBuscarMateriais().getValueAt(i, 0).toString().trim();
            arrayMateriais[i][1] = this.dialogCadastrarConsulta.getTableBuscarMateriais().getValueAt(i, 1).toString().trim();
        }
        
        this.consulta.setMateriaisUsar(arrayMateriais);
        
        ExportarDados.anexarConsulta(this.consulta, this.chaveConsulta);
        
        return this.consulta;
    }
    
    void preencherTabelaMateriais(Object [][] arrayMateriais) {
        DefaultTableModel model = (DefaultTableModel) this.dialogEditarConsulta.getTableBuscarMateriais().getModel();
        
        model.setRowCount(0);
        
        for (int i = 0; i < arrayMateriais.length; i++) {
            model.addRow(new Object [] {
                arrayMateriais[i][0],
                arrayMateriais[i][1]              
            });
        }
        
        
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
    
    boolean validarCampos() {
        if (this.dialogCadastrarConsulta.getTextAreaQueixa().getText().isBlank()
            || this.dialogCadastrarConsulta.getTextAreaObservacoes().getText().isBlank()
            || this.dialogCadastrarConsulta.getTextFieldConvenio().getText().isBlank()
            || this.dialogCadastrarConsulta.getTextFieldNomePaciente().getText().isBlank()) {
            mostrarErro(2);
            return false;
        }
        
        if (this.countMateriais == 0) {
            mostrarErro(3);
            return false;
        }
        
        if (this.dialogCadastrarConsulta.getJDatePicker().getModel().getValue() == null ) {
            mostrarErro(4);
            return false;
        }       
        
        return true;
    }
    
    boolean validarMateriais() {
         int quantidadeEscolhida;
        int quantidadeEstoque;
        for (int i = 0; i < this.countMateriais; i++) {
            quantidadeEstoque = ControladorFrame.repositorioMateriais.getMateriais().get(this.chaveMateriais[i]).getQuant();
            System.out.println("Quantidade estoque = " + quantidadeEstoque);
            try {
                if (this.dialogCadastrarConsulta.getTableBuscarMateriais().isEditing()) {
                    this.dialogCadastrarConsulta.getTableBuscarMateriais().getCellEditor().stopCellEditing(); // Finaliza a edição da célula atual
                }
                quantidadeEscolhida = Integer.parseInt(this.dialogCadastrarConsulta.getTableBuscarMateriais().getValueAt(i, 1).toString());
                System.out.println("Quantidade escolhida = " + quantidadeEscolhida);
                if (quantidadeEstoque < quantidadeEscolhida) {
                    mostrarErro(5);
                    return false;
                }
                
                ControladorFrame.repositorioMateriais.getMateriais().get(this.chaveMateriais[i]).setQuant(quantidadeEstoque - quantidadeEscolhida);
                ControladorFrame.repositorioMateriais.getMateriais().get(this.chaveMateriais[i]).setUtilizado(1);
                ExportarDados.atualizarTodosOsMateriais();
                Frame.controladorPanelMateriais.atualizarTabela();
            } catch (NumberFormatException ex) {
                mostrarErro(6);
                return false;
            }
        } 
        
        return true;
    }

    void mostrarErro(int erro) {
        switch (erro) {
            case 1:
                JOptionPane.showMessageDialog(this.dialogCadastrarConsulta, "Esse material já foi adicionado! Altere a quantidade!");
                break;
            case 2:
                JOptionPane.showMessageDialog(this.dialogCadastrarConsulta, "Preencha todos os campos!");
                break;
            case 3:
                JOptionPane.showMessageDialog(this.dialogCadastrarConsulta, "Escolha um material!");
                break;
            case 4:
                JOptionPane.showMessageDialog(this.dialogCadastrarConsulta, "Selecione uma data!");
                break;
            case 5:
                JOptionPane.showMessageDialog(this.dialogCadastrarConsulta, "Sem estoque suficiente de materiais!");
                break;
            case 6:
                JOptionPane.showMessageDialog(this.dialogCadastrarConsulta, "Digite números na coluna quantidade!");
                break;                
            default:
                break;
        }
        
    }
    
}
