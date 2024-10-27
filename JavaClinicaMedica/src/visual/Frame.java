package visual;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Frame extends JFrame {
    JMenuBar menuBar;
    JMenu menuAgendamentos;
    JMenu menuPacientes;
    JMenu menuMedicos;
    JMenu menuExames;
    JMenu menuMateriais;
    JMenu menuRelatorios;
    JLabel iconAgendamento; 
    JLabel iconPaciente; 
    
    public Frame() {
        super();
        this.setVisible(true);
        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Clínica Médica");
        this.setJMenuBar(getBarraMenu());
    }
    
     public JMenuBar getBarraMenu() {
        if (this.menuBar == null) {
            this.menuBar = new JMenuBar(); 
            this.menuBar.add(getIconAgendamento()); // apenas pra teste
            this.menuBar.add(getIconPaciente()); // apenas pra teste
            this.menuBar.add(getMenuMedicos());
            this.menuBar.add(getMenuExames());
            this.menuBar.add(getMenuMateriais());
            this.menuBar.add(getMenuRelatorios());
            
        }
        
        return this.menuBar;
    }
     
    public JMenu getMenuAgendamentos() {
        if (this.menuAgendamentos == null) {
            this.menuAgendamentos = new JMenu();
            this.menuAgendamentos.add(getIconAgendamento());
            
        }
        
        return this.menuAgendamentos;
    }
    
    public JLabel getIconAgendamento() {
        if (this.iconAgendamento == null) {
            URL agendamentoIconURL = this.getClass().getResource("resources/calendar.png");
            ImageIcon teste = new ImageIcon(new ImageIcon(agendamentoIconURL).getImage().getScaledInstance(70, 70, 70));
            this.iconAgendamento = new JLabel("Agendamento", teste, JLabel.CENTER);
            this.iconAgendamento.setVerticalTextPosition(JLabel.BOTTOM);
            this.iconAgendamento.setHorizontalTextPosition(JLabel.CENTER);
            //this.iconAgendamento = new JLabel("Teste");
            
        }
        
        return this.iconAgendamento;
    }
    
    
    public JLabel getIconPaciente() {
        if (this.iconPaciente == null) {
            URL agendamentoIconURL = this.getClass().getResource("resources/patient.png");
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
    
    public JMenu getMenuMedicos() {
        if (this.menuMedicos == null) {
            this.menuMedicos = new JMenu("Médicos");
        }
        
        return this.menuMedicos;
    }
    
 
    public JMenu getMenuExames() {
        if (this.menuExames == null) {
            this.menuExames = new JMenu("Exames");
        }
        
        return this.menuExames;
    }
    
    public JMenu getMenuMateriais() {
        if (this.menuMateriais == null) {
            this.menuMateriais = new JMenu("Materiais");
        }
        
        return this.menuMateriais;
    }
    
    public JMenu getMenuRelatorios() {
        if (this.menuRelatorios == null) {
            this.menuRelatorios = new JMenu("Relatórios");
        }
        
        return this.menuRelatorios;
    }
 }
