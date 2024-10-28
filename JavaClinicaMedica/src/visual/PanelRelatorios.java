package visual;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelRelatorios extends JPanel {
    public PanelRelatorios(JFrame frame) {
        this.setLayout(new BorderLayout());
        JLabel label = new JLabel("Painel de Relatorios", JLabel.CENTER);
        this.add(label, BorderLayout.CENTER);
    }
}
