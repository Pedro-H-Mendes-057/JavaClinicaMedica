package controle;
import visual.PanelRelatorios;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import dialogCadastroPanels.DialogPesquisa;
import modelo.Paciente;
import repositorio.RepositorioExames;
import repositorio.RepositorioMateriais;
import repositorio.RepositorioMedicos;
import repositorio.RepositorioPacientes;

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
        
        this.panelRelatorios.getBTPesquisar().addActionListener(this);   
        
        panelRelatorios.getPescPac1().addActionListener(this);
        panelRelatorios.getPescMed().addActionListener(this);
        panelRelatorios.getRBTFiltrarMedico().addActionListener(this);
        panelRelatorios.getRBTFiltrarPaciente().addActionListener(this);
        panelRelatorios.getBTPesquisar().addActionListener(this);
	}//do addEventos
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	    CorNormal();
	    if (e.getSource() == panelRelatorios.getBTConsultas()) {
	        panelRelatorios.getBTConsultas().setBackground(new Color(0, 128, 255));  //////////CONSULTAS
	        System.out.println("CONSULTAS APERTADO");
	        configurarRelatorioConsultas();
	    } else if (e.getSource() == panelRelatorios.getBTExames()) {
	        panelRelatorios.getBTExames().setBackground(new Color(0, 128, 255));  //////////EXAMES
	        System.out.println("EXAMES APERTADO");
	        configurarRelatorioExames();
	    } else if (e.getSource() == panelRelatorios.getBTFinan()) {
	        panelRelatorios.getBTFinan().setBackground(new Color(0, 128, 255));  //////////FINANCEIRO
	        configurarRelatorioFinanceiro();
	    } else if (e.getSource() == panelRelatorios.getBTMateriais()) {
	        panelRelatorios.getBTMateriais().setBackground(new Color(0, 128, 255));  ////////////MATERIAIS
	        configurarRelatorioMateriais();
	        
	    } else if (e.getSource() == panelRelatorios.getBTPesquisar()) {
	        String tipo = FiltroSelect();
	        if (tipo != null) {
	            String textoPesquisa = obterTextoPesquisa(tipo);
	            if (textoPesquisa != null && !textoPesquisa.isEmpty()) {
	                pesquisar(panelRelatorios.getParent(), tipo, textoPesquisa);
	            } else {
	                JOptionPane.showMessageDialog(panelRelatorios, "Digite um nome para pesquisar", "Erro", JOptionPane.WARNING_MESSAGE);
	            }
	        } 
	    }
	    
	    ////// EM CONSUTLAS
	    if (e.getSource() == panelRelatorios.getRBTFiltrarMedico()) {
	        configurarFiltroMedico();
	    } else if (e.getSource() == panelRelatorios.getRBTFiltrarPaciente()) {
	        configurarFiltroPaciente();
	    } else if (e.getSource() == panelRelatorios.getPescMed()) {
	        pesquisarMedico();
	    } else if (e.getSource() == panelRelatorios.getPescPac1()) {
	        pesquisarPaciente();
	    } else if (e.getSource() == panelRelatorios.getBTPesquisar()) {
	        abrirRelatorio();
	    }
}////ACTION PERFORMER
	



//da classe ////////////////////////////
        

    private void CorNormal() {
        panelRelatorios.getBTConsultas().setBackground(null);
        panelRelatorios.getBTExames().setBackground(null);
        panelRelatorios.getBTFinan().setBackground(null);
        panelRelatorios.getBTMateriais().setBackground(null);
    }
    private void configurarRelatorioConsultas() {
        panelRelatorios.getBTConsultas().setBackground(new Color(0, 128, 255));
        mostrarFiltros(true);
        limparCamposFiltros();
    }

    private void configurarRelatorioExames() {
        panelRelatorios.getBTExames().setBackground(new Color(0, 128, 255));
        mostrarFiltros(false);
        // Lógica para exibir todos os exames na tabela
    }

    private void configurarRelatorioFinanceiro() {
        panelRelatorios.getBTFinan().setBackground(new Color(0, 128, 255));
        mostrarFiltros(false);
        // Lógica para exibir relatórios financeiros
    }

    private void configurarRelatorioMateriais() {
        panelRelatorios.getBTMateriais().setBackground(new Color(0, 128, 255));
        mostrarFiltros(false);
        // Lógica para exibir todos os materiais
    }

    private void mostrarFiltros(boolean visivel) {
        panelRelatorios.getRBTFiltrarMedico().setVisible(visivel);
        panelRelatorios.getRBTFiltrarPaciente().setVisible(visivel);
        panelRelatorios.getTxFMedico().setVisible(visivel);
        panelRelatorios.getTxFPaciente().setVisible(visivel);
        panelRelatorios.getPescMed().setVisible(visivel);
        panelRelatorios.getPescPac1().setVisible(visivel);
        panelRelatorios.getBTPesquisar().setVisible(visivel);
    }

    private void limparCamposFiltros() {
        panelRelatorios.getTxFMedico().setText("");
        panelRelatorios.getTxFPaciente().setText("");
        panelRelatorios.getTxFMedico().setEditable(true);
        panelRelatorios.getTxFPaciente().setEditable(true);
        panelRelatorios.getBTPesquisar().setEnabled(false);
    }

    private void configurarFiltroMedico() {
        panelRelatorios.getRBTFiltrarPaciente().setSelected(false);
        panelRelatorios.getTxFPaciente().setEditable(false);
        panelRelatorios.getTxFMedico().setEditable(true);
        panelRelatorios.getPescMed().setVisible(true);
        panelRelatorios.getPescPac1().setVisible(false);
        panelRelatorios.getTxFPaciente().setText("");
    }

    private void configurarFiltroPaciente() {
        panelRelatorios.getRBTFiltrarMedico().setSelected(false);
        panelRelatorios.getTxFMedico().setEditable(false);
        panelRelatorios.getTxFPaciente().setEditable(true);
        panelRelatorios.getPescPac1().setVisible(true);
        panelRelatorios.getPescMed().setVisible(false);
        panelRelatorios.getTxFMedico().setText("");
    }


    private void abrirRelatorio() {
        // Lógica para abrir e exibir o relatório filtrado na tabela
        String filtroMedico = panelRelatorios.getTxFMedico().getText();
        String filtroPaciente = panelRelatorios.getTxFPaciente().getText();

        if (!filtroMedico.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Exibindo consultas do médico: " + filtroMedico);
        } else if (!filtroPaciente.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Exibindo consultas do paciente: " + filtroPaciente);
        } else {
            JOptionPane.showMessageDialog(null, "Seleção inválida!");
        }
    }
}//da Classe
