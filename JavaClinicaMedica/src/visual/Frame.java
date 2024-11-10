package visual;

import controle.ControladorPanelAgendar;
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
import controle.ControladorPanelPacientes;
import controle.ControladorPanelExame;
import controle.ControladorPanelMateriais;

public class Frame extends JFrame {
    private JTabbedPane tabbedPane;
    private JLabel iconClinicaLogo;
    JPanel panelInicial;
    PanelPacientes panelPacientes;
    PanelMedicos panelMedicos;
    PanelAgendar panelAgendar;
    PanelExame panelExame;
    PanelMateriais panelMateriais;
    PanelRelatorios panelRelatorios;
    ControladorPanelPacientes controladorPanelPacientes; 
    ControladorPanelMedicos controladorPanelMedicos; 
    ControladorPanelExame controladorPanelExame;
    ControladorPanelMateriais controladorPanelMateriais; 
    ControladorPanelAgendar controladorPanelAgendar;
    
    
    public Frame() {
        super();
        this.setSize(1280, 720);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Clínica Médica");
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        tabbedPane = new JTabbedPane();

        // 														 Painel inicial
        panelInicial = new JPanel();
        panelInicial.setLayout(new BorderLayout());

        //														imagem de fundo
        JLabel backgroundLabel = new JLabel(new ImageIcon(getClass().getResource("resources/Background.png"))); 
        panelInicial.add(backgroundLabel, BorderLayout.CENTER);
        
        //										inicialização dos respectivos paineis e controladores
        //OBS.: FALTA CRIAR OS CONTROLADORES DE MUITOS PAINEIS
        this.panelPacientes = new PanelPacientes();
        this.controladorPanelPacientes = new ControladorPanelPacientes(this.panelPacientes);
        this.panelMedicos = new PanelMedicos();
        this.controladorPanelMedicos = new ControladorPanelMedicos(this.panelMedicos);
        this.panelAgendar = new PanelAgendar(this);
        this.controladorPanelAgendar = new ControladorPanelAgendar(this.panelAgendar);
        this.panelExame = new PanelExame();
//      this.controladorPanelExame = new ControladorPanelExame(this.panelExame);
        this.panelMateriais = new PanelMateriais();
        this.controladorPanelMateriais = new ControladorPanelMateriais(this.panelMateriais);
        this.panelRelatorios = new PanelRelatorios(this);
//      this.controladorPanelRelatorios = new ControladorPanelRelatorios(this.panelRelatorios);
        
        tabbedPane.addTab("Home", resizeIcon("resources/Pacientes.png", 30, 30), this.panelInicial, "BEM VINDE A ZELOCUIDAR");
        tabbedPane.addTab("Pacientes", resizeIcon("resources/Pacientes.png", 30, 30), this.panelPacientes);
        tabbedPane.addTab("Médicos", resizeIcon("resources/Medico.png", 30, 30), this.panelMedicos);
        tabbedPane.addTab("Agendar", resizeIcon("resources/Agenda.png", 30, 30), this.panelAgendar);
        tabbedPane.addTab("Exames", resizeIcon("resources/Exames.png", 30, 30), this.panelExame);
        tabbedPane.addTab("Materiais", resizeIcon("resources/Materiais.png", 30, 30), this.panelMateriais);
        tabbedPane.addTab("Relatórios", resizeIcon("resources/Relatorio.png", 30, 30), this.panelRelatorios, "Visualizar Relatórios");

        //cabeçalho
        ImageIcon headerIcon = new ImageIcon(getClass().getResource("resources/HEADER.png"));
        Image headerImage = headerIcon.getImage().getScaledInstance(1920, 50, Image.SCALE_SMOOTH);
        JLabel headerLabel = new JLabel(new ImageIcon(headerImage));

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
