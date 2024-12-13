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
import java.util.stream.Collectors;

public class ControladorPanelRelatorios implements ActionListener{
	
    private PanelRelatorios panelRelatorios;
    //private List<String> repositorioPacientes;
    private RepositorioPacientes repositorioPacientes;
    private RepositorioMedicos repositorioMedicos;
    private RepositorioExames repositorioExames;
    JTextArea textArea;

	public ControladorPanelRelatorios(PanelRelatorios panelRelatorios) {
		this.panelRelatorios = panelRelatorios;
	    this.repositorioPacientes = ControladorFrame.repositorioPacientes;
	    this.repositorioMedicos = ControladorFrame.repositorioMedicos;
	    this.repositorioExames = ControladorFrame.repositorioExames;

	    this.textArea = panelRelatorios.getTextArea();
	    
	    panelRelatorios.getComboBoxTipo().setVisible(false);
		
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
	            panelRelatorios.getBTConsultas().setBackground(new Color(0, 128, 255));
	            configurarRelatorioConsultas();
	            
	            panelRelatorios.getPescMed().setVisible(true);
	            panelRelatorios.getPescPac1().setVisible(true);
	            panelRelatorios.getComboBoxTipo().setVisible(false);
	            
	        }  else if (e.getSource() == panelRelatorios.getBTFinan()) {
	            panelRelatorios.getBTFinan().setBackground(new Color(0, 128, 255));
	            configurarRelatorioFinanceiro();
	            
	            panelRelatorios.getComboBoxTipo().setVisible(false);
	            panelRelatorios.getPescMed().setVisible(false);
	            panelRelatorios.getPescPac1().setVisible(false);
	        } 
	        else if (e.getSource() == panelRelatorios.getPescPac1()) {
	            if (panelRelatorios.getComboBoxTipo().getSelectedItem().toString().isEmpty()) {
	                JOptionPane.showMessageDialog(panelRelatorios, "Selecione um filtro.", "Erro", JOptionPane.ERROR_MESSAGE);
	                return;
	            }
	        }
	        
	        else if (e.getSource() == panelRelatorios.getBTExames()) {
	        	panelRelatorios.getBTExames().setBackground(new Color(0, 128, 255));
	            configurarRelatorioExames();
	            
	            panelRelatorios.getComboBoxTipo().setVisible(true);
	            panelRelatorios.getComboBoxTipo().setEnabled(true);
	            panelRelatorios.getPescMed().setVisible(false);
	            panelRelatorios.getPescPac1().setVisible(false);

	            String tipoSelecionado = (String) panelRelatorios.getComboBoxTipo().getSelectedItem();

	            if (tipoSelecionado == null || tipoSelecionado.isEmpty()) {
	                JOptionPane.showMessageDialog(panelRelatorios, "Selecione um filtro.", "Erro", JOptionPane.ERROR_MESSAGE);
	                return;
	            }

	            List<Exame> examesFiltrados = ControladorFrame.repositorioExames.getExames()
	            	    .stream()
	            	    .filter(exame -> exame.getTipo().equalsIgnoreCase(tipoSelecionado))
	            	    .collect(Collectors.toList());

	            	textArea.setText("");
	            	if (examesFiltrados.isEmpty()) {
	            	    textArea.append("Nenhume exame encontrado..\n");
	            	    return;
	            	}

	            	for (Exame exame : examesFiltrados) {
	            	    textArea.append("Nome: " + exame.getNomeExame() + "\n");
	            	    textArea.append("Tipo: " + exame.getTipo() + "\n");
	            	    textArea.append("Valor: " + exame.getValorParticular() + "\n");
	            	    textArea.append("Descrição: " + exame.getDescricao() + "\n");
	            	    textArea.append("Médico: " + exame.getMedico().getNome() + "\n\n");
	            	}
	        }

	        else if (e.getSource() == panelRelatorios.getPesq()) {
	            pesquisar();
	        }
	 }//da classe ////////////////////////////
        
	 void pesquisar() {
		    if (panelRelatorios.getComboBoxTipo().isVisible()) {
		        String tipoSelecionado = (String) panelRelatorios.getComboBoxTipo().getSelectedItem();
		        if (tipoSelecionado == null || tipoSelecionado.isEmpty()) {
		            mostrarTodosOsExames();
		        } 
		    } else {
		        JOptionPane.showMessageDialog(panelRelatorios, "Selecione um filtro.");
		    }
		}

	 void mostrarTodosOsExames() {
		    List<Exame> todosOsExames = ControladorFrame.repositorioExames.getExames();

		    textArea.setText("");
		    if (todosOsExames.isEmpty()) {
		        textArea.append("Nenhum exame cadastrado.\n");
		        return;
		    }

		    for (Exame exame : todosOsExames) {
		        textArea.append("Nome: " + exame.getNomeExame() + "\n");
		        textArea.append("Tipo: " + exame.getTipo() + "\n");
		        textArea.append("Valor: " + exame.getValorParticular() + "\n");
		        textArea.append("Descrição: " + exame.getDescricao() + "\n");
		        textArea.append("Médico: " + exame.getMedico().getNome() + "\n\n");
		    }
		}

    private void CorNormal() {
        panelRelatorios.getBTConsultas().setBackground(null);
        panelRelatorios.getBTExames().setBackground(null);
        panelRelatorios.getBTFinan().setBackground(null);
    }
    private void configurarRelatorioConsultas() {   /////////////////////CONSULTAS
        mostrarBotoes(true);
        panelRelatorios.getComboBoxTipo().setVisible(false);
    }


    private void configurarRelatorioExames() {
        mostrarBotoes(false);
        panelRelatorios.getComboBoxTipo().setVisible(true);  /////////////////////EXAMES
    }


    private void configurarRelatorioFinanceiro() {
        mostrarBotoes(false);
        panelRelatorios.getComboBoxTipo().setVisible(false);  /////////////////////FINANCEIRO
    }


    private void mostrarBotoes(boolean visivel) {
        panelRelatorios.getPescMed().setVisible(visivel);
        panelRelatorios.getPescPac1().setVisible(visivel);
        panelRelatorios.getComboBoxTipo().setVisible(!visivel);
    }
}

////////////////////////////////

    /*private void atualizarTabelaExames() {
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
        
        
    }*/


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
