package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import visual.Frame;

public class ControladorFrame {
    Frame frame;

    public ControladorFrame() {
        frame = new Frame();
        addEventos();
    }

    void addEventos() {
        frame.getTabbedPane().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateTabIcon(frame.getTabbedPane().getSelectedIndex());
            }
        });
    }

    private void updateTabIcon(int selectedIndex) {
        if (selectedIndex < 1) return; // Ignora a Home

        // Atualiza o ícone da aba selecionada
        switch (selectedIndex) {
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

        // Atualiza os ícones das outras abas para os ícones normais
        updateOtherTabIcons(selectedIndex);
    }

    private void updateOtherTabIcons(int selectedIndex) {
        // Atualiza os ícones das abas não selecionadas
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
    }
}
