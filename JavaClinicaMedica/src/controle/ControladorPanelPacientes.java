package controle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import visual.PanelPacientes;
import dialogCadastroPanels.DialogCadastrarPaciente;
import dialogCadastroPanels.DialogEDITARMaterial;
import dialogCadastroPanels.DialogEDITARPaciente;
import exportacoes.ExportarDados;
import modelo.Material;
import modelo.Paciente;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import repositorio.RepositorioPacientes;

public class ControladorPanelPacientes implements ActionListener {
    private PanelPacientes panelPacientes;
    private DialogCadastrarPaciente dialogCadastrarPaciente;
    private ControladorDialogCadastrarPaciente controladorDialogCadastrarPaciente;
    RepositorioPacientes repositorioPacientes;
    ControladorDialogEDITARPaciente controladorDialogEditarPaciente;
    DialogEDITARPaciente dialogEditarPaciente;
    
    
    public ControladorPanelPacientes(PanelPacientes panelPacientes, RepositorioPacientes repositorioPacientes) {
        this.panelPacientes = panelPacientes;
        try {
            ExportarDados.recuperarPacientes();
        } catch (IOException ex) {
           System.out.println("Falha na criação do arquivo Pacientes.txt");
        }
        atualizarTabela();
        addEventos();
    }

    private void addEventos() {
        panelPacientes.getBTNNovo().addActionListener(this);
        panelPacientes.getBTNExcluir().addActionListener(this);
        panelPacientes.getBTNEditar().addActionListener(this);
        
        this.panelPacientes.getBTNEditar().setEnabled(false);
        this.panelPacientes.getTable().getSelectionModel().addListSelectionListener(event -> {
            boolean itemSelecionado = this.panelPacientes.getTable().getSelectedRow() != -1;
            this.panelPacientes.getBTNEditar().setEnabled(itemSelecionado);
            this.panelPacientes.getBTNExcluir().setEnabled(itemSelecionado);
            
            this.panelPacientes.getBTNPesquisar().addActionListener(this);
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == panelPacientes.getBTNNovo()) {
            dialogCadastrarPaciente = new DialogCadastrarPaciente(ControladorFrame.frame);
            
            controladorDialogCadastrarPaciente = new ControladorDialogCadastrarPaciente(dialogCadastrarPaciente);
            
            atualizarTabela();
        }//do Novo
        
        if (e.getSource() == this.panelPacientes.getBTNExcluir()) {
            if(this.panelPacientes.getMessageDialogExcluirItem(panelPacientes) &&
            		(this.panelPacientes.getTable().getSelectedRowCount()) == 1) {
            	ControladorFrame.repositorioPacientes.getPacientes().remove(this.panelPacientes.getTable().getSelectedRow());
            	atualizarTabela();
            }
        }//do Excluir
        else if (e.getSource() == this.panelPacientes.getBTNEditar()) {
        	int indexLinhaItem = this.panelPacientes.getTable().getSelectedRow();
            if (indexLinhaItem != -1) {
                Paciente pacienteSeleciona = ControladorFrame.repositorioPacientes.getPacientes().get(indexLinhaItem);
                this.dialogEditarPaciente = new DialogEDITARPaciente(ControladorFrame.frame, pacienteSeleciona);
                this.controladorDialogEditarPaciente = new ControladorDialogEDITARPaciente(this.dialogEditarPaciente, pacienteSeleciona);
                atualizarTabela();
            }
        }
        else if (e.getSource() == panelPacientes.getBTNPesquisar()) {
        	panelPacientes.getTxFPesquisar().getInputContext().endComposition();
            buscarNome();
        }
    }///////do ActionPerformed

    private void buscarNome() {
        String termoBusca = panelPacientes.getTxFPesquisar().getText().trim().toLowerCase();

        if (termoBusca.isEmpty()) {
            atualizarTabela();
            return;
        }
        
        DefaultTableModel tabelaPac = (DefaultTableModel) panelPacientes.getTable().getModel();
        tabelaPac.setRowCount(0); //Limpa as linhas

      //Rastrear se algum paciente foi encontrado, pra evitar bug do OptionPane
        boolean encontrou = false;
        
        File arquivo = new File("src/exportacoes/Pacientes.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length >= 5) {
                    String nome = dados[0].toLowerCase();
                    
                    if (nome.contains(termoBusca)) {
                        encontrou = true;
                        
                        tabelaPac.addRow(new Object[]{
                            dados[0], //Nome
                            dados[1], //Data de nascimento
                            dados[2], //Contato
                            dados[3], //Tipo sanguíneo
                            dados[4]  //Convênio
                        });
                    }
                }
            }

            if (!encontrou) {
                JOptionPane.showMessageDialog(null, "Nenhum paciente encontrado.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar o arquivo: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void atualizarTabela() {
        DefaultTableModel model = (DefaultTableModel) panelPacientes.getTable().getModel();
        model.setRowCount(0); // Apaga todos os itens da tabela para que ela seja refeita
        
        ControladorFrame.repositorioPacientes.getPacientes().forEach(paciente -> {
            model.addRow(new Object[]{
                paciente.getNome(),
                paciente.getDataNasc(),
                paciente.getContato(),
                paciente.getTipoSang(),
                paciente.getConvenio()
            });
        });
    }
}
