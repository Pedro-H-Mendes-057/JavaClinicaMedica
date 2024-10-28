package visual;

import javax.swing.*;
import java.awt.*;

public class PanelMedicos extends JPanel {
    public PanelMedicos(JFrame frame) {
        this.setLayout(new BorderLayout());
        JLabel label = new JLabel("Painel de Médicos", JLabel.CENTER);
        this.add(label, BorderLayout.CENTER);
    }
}
