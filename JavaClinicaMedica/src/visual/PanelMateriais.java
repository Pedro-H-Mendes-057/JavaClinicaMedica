package visual;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelMateriais extends JPanel {
    public PanelMateriais(JFrame frame) {
        this.setLayout(new BorderLayout());
        JLabel label = new JLabel("Painel de Materiais", JLabel.CENTER);
        this.add(label, BorderLayout.CENTER);
    }
}

