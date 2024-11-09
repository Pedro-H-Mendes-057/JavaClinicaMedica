package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import dialogCadastroPanels.DialogCadastroExames;
import dialogCadastroPanels.DialogReagendarExame;
import visual.PanelExame;
import javax.swing.JFrame;

public class ControladorPanelExame implements ActionListener {
    private PanelExame panelExame;
    private JFrame frame;
    
    public ControladorPanelExame(PanelExame panelExame, JFrame frame) {
        this.panelExame = panelExame;
        this.frame = frame;
        addEventos();
    }
    
    private void addEventos() {
        this.panelExame.getBTNNovo().addActionListener(this);
        this.panelExame.getBTNEditar().addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == panelExame.getBTNNovo()) {
            new DialogCadastroExames(frame).setVisible(true);
        } else if (e.getSource() == panelExame.getBTNEditar()) {
            new DialogReagendarExame(frame).setVisible(true);
        }
    }
}
