package visual;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Frame extends JFrame {
    JMenuBar menuBar;
    JMenu menuAgendamentos;
    JMenu menuPacientes;
    JMenu menuMedicos;
    JMenu menuExames;
    JMenu menuMateriais;
    JMenu menuRelatorios;
    
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
            this.menuBar.add(getMenuAgendamentos());
            this.menuBar.add(getMenuPacientes());
            this.menuBar.add(getMenuMedicos());
            this.menuBar.add(getMenuExames());
            this.menuBar.add(getMenuMateriais());
            this.menuBar.add(getMenuRelatorios());
            
        }
        
        return this.menuBar;
    }
     
    public JMenu getMenuAgendamentos() {
        if (this.menuAgendamentos == null) {
            this.menuAgendamentos = new JMenu("Agendamentos");
        }
        
        return this.menuAgendamentos;
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
