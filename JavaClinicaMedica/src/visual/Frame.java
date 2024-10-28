package visual;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

import visual.PanelPacientes;
import visual.PanelMedicos;
import visual.PanelAgendar;
import visual.PanelExames;
import visual.PanelMateriais;
import visual.PanelRelatorios;

public class Frame extends JFrame {
    private JTabbedPane tabbedPane;
    private JLabel iconClinicaLogo;

    public Frame() {
        super();
        this.setSize(1920, 1080);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Clínica Médica");

        tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Pacientes", resizeIcon("resources/Pacientes.png", 30, 30), new PanelPacientes(this), "Gerenciar Pacientes");
        tabbedPane.addTab("Médicos", resizeIcon("resources/Medico.png", 30, 30), new PanelMedicos(this), "Gerenciar Médicos");
        tabbedPane.addTab("Agendar", resizeIcon("resources/Agenda.png", 30, 30), new PanelAgendar(this), "Agendar Consultas");
        tabbedPane.addTab("Exames", resizeIcon("resources/Exames.png", 30, 30), new PanelExames(this), "Gerenciar Exames");
        tabbedPane.addTab("Materiais", resizeIcon("resources/Materiais.png", 30, 30), new PanelMateriais(this), "Gerenciar Materiais");
        tabbedPane.addTab("Relatórios", resizeIcon("resources/Relatorio.png", 30, 30), new PanelRelatorios(this), "Visualizar Relatórios");

        // ESSA LOGO ME DEU UM TRABALHO DO KARAIOOOOOOOO
        iconClinicaLogo = new JLabel(resizeIcon("resources/ClinicaLogo.png", 30, 30));

        // CRIA UM PAINEL PRA ALINHAR COM A LOGO E JTABBED AAAAAAAAAAA
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // Alinha tudo pra esquerda
        headerPanel.add(iconClinicaLogo);
        headerPanel.add(tabbedPane);

        // Bota o painel no frame
        add(headerPanel, BorderLayout.WEST); // NAO MUDAR A ORIENTAÇÃO (LOGO DA CLINICA DEPENDE DISSO)

        add(tabbedPane, BorderLayout.CENTER);

        setVisible(true);
    }
    
    private ImageIcon getIcon(String path) {
        URL iconURL = this.getClass().getResource(path);
        if (iconURL != null) {
            return new ImageIcon(iconURL);
        } else {
            return null; // Retornar nulo se n tiver o icone
        }
    }

    private ImageIcon resizeIcon(String path, int width, int height) {
        ImageIcon icon = getIcon(path);
        if (icon != null) {
            Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(img);
        }
        return null;
    }

    public static void main(String[] args) {
        new Frame();
    }
}
