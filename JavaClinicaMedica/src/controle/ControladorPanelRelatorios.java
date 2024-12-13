package controle;
import visual.PanelRelatorios;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import modelo.Exame;
import modelo.Material;
import modelo.Medico;
import modelo.Paciente;
 
import dialogCadastroPanels.DialogPesquisa;
import modelo.Paciente;
import modelo.Medico;
import modelo.Exame;
import repositorio.RepositorioExames;
import repositorio.RepositorioMedicos;
import repositorio.RepositorioPacientes;

import java.util.Map;

public class ControladorPanelRelatorios implements ActionListener{
	
    private PanelRelatorios panelRelatorios;
    //private List<String> repositorioPacientes;
    private RepositorioPacientes repositorioPacientes;
    private RepositorioMedicos repositorioMedicos;
    private RepositorioExames repositorioExames;
    JTable table;

	public ControladorPanelRelatorios(PanelRelatorios panelRelatorios) {
		this.panelRelatorios = panelRelatorios;
		this.repositorioPacientes = ControladorFrame.repositorioPacientes;
		this.repositorioMedicos = ControladorFrame.repositorioMedicos;
		this.repositorioExames = ControladorFrame.repositorioExames;
		
		this.table = panelRelatorios.getTable();
		
		addEventos();
	}


	void addEventos() {
		this.panelRelatorios.getBTConsultas().addActionListener(this);
        this.panelRelatorios.getBTExames().addActionListener(this);
        this.panelRelatorios.getBTFinan().addActionListener(this);
        
        panelRelatorios.getPescPac1().addActionListener(this);
        panelRelatorios.getPescMed().addActionListener(this);
	}//do addEventos
	
	
	 @Override
	    public void actionPerformed(ActionEvent e) {
	        CorNormal();
	        
	        if (e.getSource() == panelRelatorios.getBTConsultas()) {
	            panelRelatorios.getBTConsultas().setBackground(new Color(0, 128, 255));  //////////CONSULTAS
	            configurarRelatorioConsultas();
	            panelRelatorios.getPescMed().setVisible(true);
	            panelRelatorios.getPescPac1().setVisible(true);
	            
	            panelRelatorios.getBTExames().setEnabled(true);
	        } 
	        else if (e.getSource() == panelRelatorios.getBTExames()) {
	            panelRelatorios.getBTExames().setBackground(new Color(0, 128, 255));  //////////EXAMES
	            configurarRelatorioExames();
	            panelRelatorios.getBTExames().setEnabled(false);
	        } 
	        else if (e.getSource() == panelRelatorios.getBTFinan()) {
	            panelRelatorios.getBTFinan().setBackground(new Color(0, 128, 255));  //////////FINANCEIRO
	            configurarRelatorioFinanceiro();
	            panelRelatorios.getBTExames().setEnabled(true);
	        }  
	        else if (e.getSource() == panelRelatorios.getPescMed()) {
	            /*DefaultTableModel model = (DefaultTableModel) panelRelatorios.getTable().getModel();
	           
	            repositorioMedicos.repositorioMedicos.forEach((chave, medico) -> {
	                model.addRow(new Object[]{
	                    medico.getNome(),
	                    medico.getEspecialidade(),
	                    medico.getCrm(),
	                    medico.getContato(),
	                    medico.getValorConsulta(),
	                    chave
	                });
	            });*/
	        }
	        else if (e.getSource() == panelRelatorios.getPescPac1()) {
	            /*DefaultTableModel model = (DefaultTableModel) panelRelatorios.getTable().getModel();
	            model.setRowCount(0);
	            
	                model.addRow(new Object[]{
	                    paciente.getNome(),
	                    paciente.getDataNasc(),
	                    paciente.getContato(),
	                    paciente.getTipoSang(),
	                    paciente.getConvenio();
	                }
	            }*/
	        }
	 }

//da classe ////////////////////////////
        

    private void CorNormal() {
        panelRelatorios.getBTConsultas().setBackground(null);
        panelRelatorios.getBTExames().setBackground(null);
        panelRelatorios.getBTFinan().setBackground(null);
    }
    private void configurarRelatorioConsultas() {
        panelRelatorios.getBTConsultas().setBackground(new Color(0, 128, 255));/////////////////////CONSULTAS
       mostrarBotoes(true);
    }

    private void configurarRelatorioExames() {
        panelRelatorios.getBTExames().setBackground(new Color(0, 128, 255)); /////////////////////EXAMES
        mostrarBotoes(false);
        atualizarTabelaExames();
    }

    private void configurarRelatorioFinanceiro() {
        panelRelatorios.getBTFinan().setBackground(new Color(0, 128, 255));/////////////////////FINANCEIRO
        mostrarBotoes(false);
        // Lógica para exibir relatórios financeiros
        //atualizarTabelaFinanceiro();
    }

    private void mostrarBotoes(boolean visivel) {
        panelRelatorios.getPescMed().setVisible(visivel);
        panelRelatorios.getPescPac1().setVisible(visivel);
    }
////////////////////////////////

    private void atualizarTabelaExames() {
    	System.out.println("Atualizando tabela de exames... eu acho2");
    	String[] colunas = {"NOME DO EXAME", "TIPO DE EXAME", "VALOR", "DESCRICAO", "MEDICO"};
    	DefaultTableModel model = (DefaultTableModel) table.getModel();
    	
    	model.setRowCount(0);
    	model.setColumnCount(colunas.length);
        
        model.setColumnIdentifiers(colunas);
        
        table.setModel(model);
        panelRelatorios.repaint();
        panelRelatorios.revalidate();
        
        repositorioExames.getExames().forEach(exame -> {
            model.addRow(new Object[]{
                exame.getNomeExame(),
                exame.getTipo(),
                exame.getValorParticular(),
                exame.getDescricao(),
                exame.getMedico().getNome()
            });
        });
        
        
    }


    /*private void atualizarTabelaFinanceiro() {
        DefaultTableModel model = (DefaultTableModel) panelRelatorios.getTable().getModel();
        model.setRowCount(0); // Limpar tabela antes de preencher
        
        double totalGastos = 0;
        double totalGanhos = 0;
        
        // Aqui, você somaria os custos de materiais e exames e os ganhos de consultas realizadas
        for (Exame exame : repositorioExames) {
            totalGastos += exame.getValor();
        }
        
        for (Consulta consulta : repositorioConsultas) {
            totalGanhos += consulta.getValor();
        }
        
        model.addRow(new Object[]{"Total de Gastos", totalGastos});
        model.addRow(new Object[]{"Total de Ganhos", totalGanhos});
        model.addRow(new Object[]{"Lucro", totalGanhos - totalGastos});
    }*/

    
    
    /*private void abrirRelatorio() {
        // Lógica para abrir e exibir o relatório filtrado na tabela
       // String filtroMedico = panelRelatorios.getTxFMedico().getText();
        //String filtroPaciente = panelRelatorios.getTxFPaciente().getText();

        if (!filtroMedico.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Exibindo consultas do médico: " + filtroMedico);
        } else if (!filtroPaciente.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Exibindo consultas do paciente: " + filtroPaciente);
        } else {
            JOptionPane.showMessageDialog(null, "Seleção inválida!");
        }
    }*/
} 
