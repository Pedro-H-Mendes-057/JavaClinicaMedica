package visual;

import controle.ControladorPanelMateriais;
import javax.swing.*;
import java.awt.*;
import java.net.URL;

import visual.PanelPacientes;
import visual.PanelMedicos;
import visual.PanelAgendar;
import visual.PanelExame;
import visual.PanelMateriais;
import visual.PanelRelatorios;
import controle.ControladorPanelMedicos; //temporario 

public class Frame extends JFrame {
    private JTabbedPane tabbedPane;
    private JLabel iconClinicaLogo;
    PanelMedicos panelMedicos; // temporario
    ControladorPanelMedicos controladorPanelMedicos; // temporario
    PanelMateriais panelMateriais; // temporario
    ControladorPanelMateriais controladorPanelMateriais; // temporario
    
    public Frame() {
        super();
        this.setSize(1920, 1080);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Clínica Médica");

        tabbedPane = new JTabbedPane();

        // Painel neutro
        JPanel panelInicial = new JPanel();
        panelInicial.setLayout(new BorderLayout());

        //imagem de fundo
        JLabel backgroundLabel = new JLabel(new ImageIcon(getClass().getResource("resources/Background.png"))); 
        panelInicial.add(backgroundLabel, BorderLayout.CENTER);

        this.panelMedicos = new PanelMedicos(this); // temporario
        this.controladorPanelMedicos = new ControladorPanelMedicos(this.panelMedicos); // temporario
        this.panelMateriais = new PanelMateriais(this);
        this.controladorPanelMateriais = new ControladorPanelMateriais(this.panelMateriais);
        
        tabbedPane.addTab("Home", resizeIcon("resources/Pacientes.png", 30, 30), panelInicial, "Tela inicial");
        tabbedPane.addTab("Pacientes", resizeIcon("resources/Pacientes.png", 30, 30), new PanelPacientes(this), "Gerenciar Pacientes");
        tabbedPane.addTab("Médicos", resizeIcon("resources/Medico.png", 30, 30), this.panelMedicos, "Gerenciar Médicos");
        tabbedPane.addTab("Agendar", resizeIcon("resources/Agenda.png", 30, 30), new PanelAgendar(this), "Agendar Consultas");
        tabbedPane.addTab("Exames", resizeIcon("resources/Exames.png", 30, 30), new PanelExame(this), "Gerenciar Exames");
        tabbedPane.addTab("Materiais", resizeIcon("resources/Materiais.png", 30, 30), this.panelMateriais, "Gerenciar Materiais");
        tabbedPane.addTab("Relatórios", resizeIcon("resources/Relatorio.png", 30, 30), new PanelRelatorios(this), "Visualizar Relatórios");

        //cabeçalho
        ImageIcon headerIcon = new ImageIcon(getClass().getResource("resources/HEADER.png"));
        Image headerImage = headerIcon.getImage().getScaledInstance(1920, 50, Image.SCALE_SMOOTH); // Defina a largura e altura desejadas
        JLabel headerLabel = new JLabel(new ImageIcon(headerImage)); // Adiciona a imagem redimensionada

        // cabeçalho e o tabbed pane
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BorderLayout()); 
        headerPanel.add(headerLabel, BorderLayout.NORTH); 
        headerPanel.add(tabbedPane, BorderLayout.CENTER); 
        add(headerPanel, BorderLayout.NORTH); 

        setVisible(true);
    }
    
    public JTabbedPane getTabbedPane() {
        return tabbedPane; // Mudar cor dos icones
    }

    private ImageIcon getIcon(String path) {
        URL iconURL = this.getClass().getResource(path);
        if (iconURL != null) {
            return new ImageIcon(iconURL);
        } else {
            return null; // Retorna nulo se n tiver o ícone
        }
    }

    public ImageIcon resizeIcon(String path, int width, int height) {
        ImageIcon icon = getIcon(path);
        if (icon != null) {
            Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(img);
        }
        return null;
    }

  }
