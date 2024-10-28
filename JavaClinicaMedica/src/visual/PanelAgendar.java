package visual;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelAgendar extends JPanel {
    public PanelAgendar(JFrame frame) {
        this.setLayout(new BorderLayout());
        JLabel label = new JLabel("Painel de Agendamentos", JLabel.CENTER);
        this.add(label, BorderLayout.CENTER);
    }
}

