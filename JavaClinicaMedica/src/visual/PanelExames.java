package visual;

import javax.swing.*;
import java.awt.*;

public class PanelExames extends JPanel {
    public PanelExames(JFrame frame) {
        this.setLayout(new BorderLayout());
        JLabel label = new JLabel("Painel de Exames", JLabel.CENTER);
        this.add(label, BorderLayout.CENTER);
    }
}
