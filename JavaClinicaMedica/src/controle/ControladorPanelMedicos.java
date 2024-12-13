/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dialogCadastroPanels.DialogCadastrarMedico;
import exportacoes.ExportarDados;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Medico;
import visual.PanelMedicos;

/**
 *
 * @author fonfon
 */
public class ControladorPanelMedicos implements ActionListener {
    PanelMedicos panelMedicos;
    DialogCadastrarMedico cadastrarMedico;
    ControladorDialogCadastrarMedico controladorDialogCadastrarMedico;
    
    public ControladorPanelMedicos(PanelMedicos panelMedicos) {
        this.panelMedicos = panelMedicos;
        try {
            ExportarDados.recuperarMedicos();
        } catch (IOException ex) {
           System.out.println("Falha na criação do arquivo Medicos.txt");
        }
        atualizarTabela();
        addEventos();
    }
    
    public void addEventos() {
        this.panelMedicos.getBTNNovo().addActionListener(this);
        this.panelMedicos.getBTNExcluir().addActionListener(this);
        this.panelMedicos.getBTNPesquisar().addActionListener(this);
        
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.panelMedicos.getBTNNovo()) {            
            this.cadastrarMedico = new DialogCadastrarMedico(ControladorFrame.frame);            
            this.controladorDialogCadastrarMedico = new ControladorDialogCadastrarMedico(this.cadastrarMedico); 
            atualizarTabela();
        }
        
        if (e.getSource() == this.panelMedicos.getBTNExcluir()) {
            if(this.panelMedicos.getMessageDialogExcluirItem(panelMedicos) &&
            		(this.panelMedicos.getTable().getSelectedRowCount()) == 1) {
                int linhaSelecionada = this.panelMedicos.getTable().getSelectedRow();
                int colunaChave = 5;
                DefaultTableModel model = (DefaultTableModel) this.panelMedicos.getTable().getModel();                
            	ControladorFrame.repositorioMedicos.getMedicos().remove((int) this.panelMedicos.getTable().getModel().getValueAt(linhaSelecionada, colunaChave));
            	atualizarTabela();
                if(ControladorFrame.repositorioMedicos.getMedicos().isEmpty()) System.out.println("Tá apagando mesmo");                
                
            }
            
        }
        if (e.getSource() == this.panelMedicos.getBTNPesquisar()) {
        	panelMedicos.getTxFPesquisar().getInputContext().endComposition();
        	buscarNome();
        }
    }
    
    void buscarNome() {
        String termoBusca = panelMedicos.getTxFPesquisar().getText().trim().toLowerCase();

        if (termoBusca.isEmpty()) {
            atualizarTabela();
            return;
        }

        DefaultTableModel tabelaPac = (DefaultTableModel) panelMedicos.getTable().getModel();
        tabelaPac.setRowCount(0);

        boolean encontrou = false;

        File arquivo = new File("src/exportacoes/Medicos.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                //dividir cada linha
                String[] dados = linha.split(";;");

                //GARANTIR que tenha 6 espaços no MINIMO
                if (dados.length >= 6) {
                    String nome = dados[1].trim().toLowerCase();

                    if (nome.contains(termoBusca)) {
                        encontrou = true;

                        tabelaPac.addRow(new Object[]{
                            dados[1], //Nome
                            dados[2], //Especialidade
                            dados[3], //CRM
                            dados[4], //Contato
                            dados[5]  //Valor
                        });
                    }
                }
            }

            if (!encontrou) {
                JOptionPane.showMessageDialog(null, "Nenhum médico encontrado.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar o arquivo: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }


    
    public void atualizarTabela() {
        DefaultTableModel model = (DefaultTableModel) this.panelMedicos.getTable().getModel(); 
        
        //System.out.println("size = " + ControladorFrame.repositorioMateriais.getMateriais().size());
        model.setRowCount(0); // apaga todos os itens da tabela para que ela seja refeita                       
                 
        for (Integer chave : ControladorFrame.repositorioMedicos.getMedicos().keySet()) {
           model.addRow(new Object [] {
               ControladorFrame.repositorioMedicos.getMedicos().get(chave).getNome(),                
               String.valueOf(ControladorFrame.repositorioMedicos.getMedicos().get(chave).getEspecialidade()),
               String.valueOf(ControladorFrame.repositorioMedicos.getMedicos().get(chave).getCrm()),
               ControladorFrame.repositorioMedicos.getMedicos().get(chave).getContato(),
               ControladorFrame.repositorioMedicos.getMedicos().get(chave).getValorConsulta(),
               chave
           });
        }
        
        //this.panelMedicos.getTable().removeColumn(this.panelMedicos.getTable().getColumn("CHAVE"));
        
        /*for (int i = 0; i < ControladorFrame.repositorioMedicos.getMedicos().size(); i++) {
            //System.out.println("OI " + i);
            model.addRow(new Object [] {
                ControladorFrame.repositorioMedicos.getMedicos().get(i).getNome(),
                String.valueOf(ControladorFrame.repositorioMedicos.getMedicos().get(i).getEspecialidade()),
                String.valueOf(ControladorFrame.repositorioMedicos.getMedicos().get(i).getCrm()),
                ControladorFrame.repositorioMedicos.getMedicos().get(i).getContato(),
                ControladorFrame.repositorioMedicos.getMedicos().get(i).getValorConsulta(),
            });
        }*/    
    }
}
