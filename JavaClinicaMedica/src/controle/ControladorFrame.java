package controle;
import ctrlRepositorios.controladorCadastroPacientes;
import repositorio.RepositorioPacientes;
import dialogCadastroPanels.DialogCadastroPaciente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import visual.Frame;

public class ControladorFrame {
    public static Frame frame;

    public ControladorFrame() {
        frame = new Frame();
        addEventos();
    }

    void addEventos() {
        frame.getTabbedPane().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                atualizIconPintado(frame.getTabbedPane().getSelectedIndex());
            }
        });
    }

    private void atualizIconPintado(int abaSelecionada) {
        if (abaSelecionada < 1) return; // Ignora a Home
        switch (abaSelecionada) {
            case 1: // Pacientes
                frame.getTabbedPane().setIconAt(1, frame.resizeIcon("resources/Pintados/Pacientes2.png", 30, 30));
                break;
            case 2: // Médicos
                frame.getTabbedPane().setIconAt(2, frame.resizeIcon("resources/Pintados/Medico2.png", 30, 30));
                break;
            case 3: // Agendar
                frame.getTabbedPane().setIconAt(3, frame.resizeIcon("resources/Pintados/Agenda2.png", 30, 30));
                break;
            case 4: // Exames
                frame.getTabbedPane().setIconAt(4, frame.resizeIcon("resources/Pintados/Exames2.png", 30, 30));
                break;
            case 5: // Materiais
                frame.getTabbedPane().setIconAt(5, frame.resizeIcon("resources/Pintados/Materiais2.png", 30, 30));
                break;
            case 6: // Relatórios
                frame.getTabbedPane().setIconAt(6, frame.resizeIcon("resources/Pintados/Relatorio2.png", 30, 30));
                break;
        }
        mudaRestoIcones(abaSelecionada);
    }

    private void mudaRestoIcones(int selectedIndex) {
        // Muda o icone das abas não selecionadas
        if (selectedIndex != 1) {
            frame.getTabbedPane().setIconAt(1, frame.resizeIcon("resources/Pacientes.png", 30, 30));
        }
        if (selectedIndex != 2) {
            frame.getTabbedPane().setIconAt(2, frame.resizeIcon("resources/Medico.png", 30, 30));
        }
        if (selectedIndex != 3) {
            frame.getTabbedPane().setIconAt(3, frame.resizeIcon("resources/Agenda.png", 30, 30));
        }
        if (selectedIndex != 4) {
            frame.getTabbedPane().setIconAt(4, frame.resizeIcon("resources/Exames.png", 30, 30));
        }
        if (selectedIndex != 5) {
            frame.getTabbedPane().setIconAt(5, frame.resizeIcon("resources/Materiais.png", 30, 30));
        }
        if (selectedIndex != 6) {
            frame.getTabbedPane().setIconAt(6, frame.resizeIcon("resources/Relatorio.png", 30, 30));
        }
    }

    public static void main(String[] args) {
        new ControladorFrame();
controladorCadastroPacientes controlador = new controladorCadastroPacientes();
        
       
    }
}
