package visual;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.*;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Frame extends JFrame {
    JMenuBar menuBar;
    JMenu menuClinicaLogo;
    JMenu menuAgendar;
    JMenu menuPacientes;
    JMenu menuMedicos;
    JMenu menuExames;
    JMenu menuMateriais;
    JMenu menuRelatorios;
    JLabel iconClinicaLogo;
    JLabel iconAgendar; 
    JLabel iconPaciente; 
    private JMenu menuClinica;
    private JLabel backgroundLabel; 
    
    public Frame() {
        super();
        this.setVisible(true);
        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Clínica Médica");
        this.setJMenuBar(getBarraMenu());
        getContentPane().setLayout(new BorderLayout());
        setBackgroundLabel();
    }
    
     public JMenuBar getBarraMenu() {
        if (this.menuBar == null) {
            this.menuBar = new JMenuBar(); 
            menuBar.add(getMenuClinicaLogo());
            this.menuBar.add(getMenuClinicaLogo()); //aaaaaaaaa
            menuBar.add(getIconClinicaLogo());
            this.menuBar.add(getIconAgendar()); // apenas pra teste
            this.menuBar.add(getIconPaciente()); // apenas pra teste
            this.menuBar.add(getMenuMedicos());
            this.menuBar.add(getMenuExames());
            this.menuBar.add(getMenuMateriais());
            this.menuBar.add(getMenuRelatorios());          
        }
        
        return this.menuBar;
    }
     ///////////CLINICA LOGO
     public JMenu getMenuClinicaLogo() {
         if (this.menuClinicaLogo == null) {
             this.menuClinicaLogo = new JMenu();
         }
         return this.menuClinicaLogo;
     }
     public JLabel getIconClinicaLogo() {
         if (this.iconClinicaLogo == null) {
             URL clinicaLogoIconURL = this.getClass().getResource("resources/Pintados/ClinicaLogo2.png");
             ImageIcon teste = new ImageIcon(new ImageIcon(clinicaLogoIconURL).getImage().getScaledInstance(70, 70, 70));
             this.iconClinicaLogo = new JLabel("ZeloCuidar", teste, JLabel.CENTER);
             this.iconClinicaLogo.setVerticalTextPosition(JLabel.BOTTOM);
             this.iconClinicaLogo.setHorizontalTextPosition(JLabel.CENTER);
             //this.ClinicaLogo = new JLabel("Teste");
         }
         return this.iconClinicaLogo;
     }
 	
     //////////////////AGENDAR
    public JMenu getMenuAgendar() {
        if (this.menuAgendar == null) {
            this.menuAgendar = new JMenu();
            this.menuAgendar.add(getIconAgendar());
        }
        return this.menuAgendar;
    }
    public JLabel getIconAgendar() {
        if (this.iconAgendar == null) {
            URL agendarIconURL = this.getClass().getResource("resources/Agenda.png");
            ImageIcon teste = new ImageIcon(new ImageIcon(agendarIconURL).getImage().getScaledInstance(60, 60, 60));
            this.iconAgendar = new JLabel("Agendamento", teste, JLabel.CENTER);
            this.iconAgendar.setVerticalTextPosition(JLabel.BOTTOM);
            this.iconAgendar.setHorizontalTextPosition(JLabel.CENTER);
            //this.iconAgendamento = new JLabel("Teste");
        }
        return this.iconAgendar;
    }
    
    ///////////////PACIENTES
    public JLabel getIconPaciente() {
        if (this.iconPaciente == null) {
            URL agendamentoIconURL = this.getClass().getResource("resources/Pacientes.png");
            ImageIcon teste = new ImageIcon(new ImageIcon(agendamentoIconURL).getImage().getScaledInstance(70, 70, 70));
            this.iconPaciente = new JLabel("Paciente", teste, JLabel.CENTER);
            this.iconPaciente.setVerticalTextPosition(JLabel.BOTTOM);
            this.iconPaciente.setHorizontalTextPosition(JLabel.CENTER);
            //this.iconAgendamento = new JLabel("Teste");
        }
        return this.iconPaciente;
    }
    
    public JMenu getMenuPacientes() {
        if (this.menuPacientes == null) {
            this.menuPacientes = new JMenu("Pacientes");
        }
        return this.menuPacientes;
    }
    /////////////////MEDICOS
    public JMenu getMenuMedicos() {
        if (this.menuMedicos == null) {
            this.menuMedicos = new JMenu("Médicos");
        }
        return this.menuMedicos;
    }
    
 ////////////////////EXAMES
    public JMenu getMenuExames() {
        if (this.menuExames == null) {
            this.menuExames = new JMenu("Exames");
        }  
        return this.menuExames;
    }
   ///////////////////MATERIAIS
    public JMenu getMenuMateriais() {
        if (this.menuMateriais == null) {
            this.menuMateriais = new JMenu("Materiais");
        }
        return this.menuMateriais;
    }
   /////////////////RELATORIOS
    public JMenu getMenuRelatorios() {
        if (this.menuRelatorios == null) {
            this.menuRelatorios = new JMenu("Relatórios");
        }
        return this.menuRelatorios;
    }
    
    private void setBackgroundLabel() {
        URL backgroundURL = getClass().getResource("/JavaClinicaMedica/src/visual/resources/Background.png");
        if (backgroundURL != null) {
            ImageIcon backgroundIcon = new ImageIcon(
                new ImageIcon(backgroundURL).getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH)
            );
            backgroundLabel = new JLabel(backgroundIcon);
            backgroundLabel.setLayout(new BorderLayout());
            this.setContentPane(backgroundLabel);
        }
  }
public static void main(String[] args) {
    new Frame();
}

 }
