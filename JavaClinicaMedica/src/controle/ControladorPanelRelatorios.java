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

import modelo.Material;
import modelo.Paciente;
 

import dialogCadastroPanels.DialogPesquisa;
import modelo.Paciente;
import repositorio.RepositorioExames;
import repositorio.RepositorioMateriais;
import repositorio.RepositorioMedicos;
import repositorio.RepositorioPacientes;

import java.util.Map;

public class ControladorPanelRelatorios implements ActionListener{
	
    private PanelRelatorios panelRelatorios;
    private List<String> repositorioPacientes;
    private List<String> repositorioMedicos;
    private List<String> repositorioMateriais;
    private List<String> repositorioExames;
	
    public ControladorPanelRelatorios(PanelRelatorios panelRelatorios,
							            List<String> repositorioPacientes,
							            List<String> repositorioMedicos,
							            List<String> repositorioMateriais,
							            List<String> repositorioExames) {
    	
		this.panelRelatorios = panelRelatorios;
		this.repositorioPacientes = repositorioPacientes;
		this.repositorioMedicos = repositorioMedicos;
		this.repositorioMateriais = repositorioMateriais;
		this.repositorioExames = repositorioExames;
		
		addEventos();
		
	}//ControladorPanelRelatorios
	

	void addEventos() {
		this.panelRelatorios.getBTConsultas().addActionListener(this);
		
        this.panelRelatorios.getBTExames().addActionListener(this);
        this.panelRelatorios.getBTFinan().addActionListener(this);
        
        this.panelRelatorios.getBTMateriais().addActionListener(this);
        
        panelRelatorios.getPescPac1().addActionListener(this);
        panelRelatorios.getPescMed().addActionListener(this);
	}//do addEventos
	
	
	 @Override
	    public void actionPerformed(ActionEvent e) {
	        CorNormal();
	        
	        if (e.getSource() == panelRelatorios.getBTConsultas()) {
	            panelRelatorios.getBTConsultas().setBackground(new Color(0, 128, 255));  //////////CONSULTAS
	            configurarRelatorioConsultas();
	        } 
	        else if (e.getSource() == panelRelatorios.getBTExames()) {
	            panelRelatorios.getBTExames().setBackground(new Color(0, 128, 255));  //////////EXAMES
	            configurarRelatorioExames();
	        } 
	        else if (e.getSource() == panelRelatorios.getBTFinan()) {
	            panelRelatorios.getBTFinan().setBackground(new Color(0, 128, 255));  //////////FINANCEIRO
	            configurarRelatorioFinanceiro();
	        } 
	        else if (e.getSource() == panelRelatorios.getBTMateriais()) {
	            panelRelatorios.getBTMateriais().setBackground(new Color(0, 128, 255));  ////////////MATERIAIS
	            configurarRelatorioMateriais();
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
        panelRelatorios.getBTMateriais().setBackground(null);
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

    private void configurarRelatorioMateriais() {
        panelRelatorios.getBTMateriais().setBackground(new Color(0, 128, 255));/////////////////////MATERIAIS
        mostrarBotoes(false);
        // Lógica para exibir todos os materiais
        atualizarTabelaMateriais();
    }

    private void mostrarBotoes(boolean visivel) {
        panelRelatorios.getPescMed().setVisible(visivel);
        panelRelatorios.getPescPac1().setVisible(visivel);
    }
////////////////////////////////

    private void atualizarTabelaExames() {
    	System.out.println("Atualizando tabela de exames...");
    	DefaultTableModel model = (DefaultTableModel) panelRelatorios.getTable().getModel();
        model.setRowCount(0); 
        
        model.setColumnIdentifiers(new Object[] { "Tipo", "Descrição", "Valor", "Médico" });

        for (int i = 0; i < repositorioExames.size(); i++) {
        	
            //Pega a string formatada do repositório
            String exameString = repositorioExames.get(i);

            //Divide a string para extrair os dados
            String[] dadosExame = exameString.split(",");

            //Verifica se a string tem a quantidade certa de dados
            if (dadosExame.length == 4) {
                model.addRow(new Object[]{
                    dadosExame[0],  // Tipo
                    dadosExame[1],  // Descrição
                    dadosExame[2],  // Valor
                    dadosExame[3]   // Médico
                });
            }
        }
        panelRelatorios.getTable().revalidate();
        panelRelatorios.getTable().repaint();
    }

    private void atualizarTabelaMateriais() {
        DefaultTableModel model = (DefaultTableModel) panelRelatorios.getTable().getModel();
        model.setRowCount(0); // Limpar tabela antes de preencher
        
        /*repositorioMateriais.forEach(material -> {
            model.addRow(new Object[]{
                material.getNome(),
                material.getQuantidade(),
                material.getValor()
            });
        });*/
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
