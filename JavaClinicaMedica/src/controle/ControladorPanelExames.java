package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import dialogCadastroPanels.DialogCadastrarExames;
import dialogCadastroPanels.DialogCadastrarPaciente;
import dialogCadastroPanels.DialogReagendarExames;
import visual.PanelExames;
import javax.swing.JFrame;

public class ControladorPanelExames implements ActionListener {
    private PanelExames panelExames;
    private DialogCadastrarExames dialogCadastrarExames;
    private JFrame frame;
    
    public ControladorPanelExames(PanelExames panelExames, JFrame frame) {
        this.panelExames = panelExames;
        this.frame = frame;
        addEventos();
    }
    
    private void addEventos() {
        this.panelExames.getBTNNovo().addActionListener(this);
        this.panelExames.getBTNEditar().addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == panelExames.getBTNNovo()) {
           
            dialogCadastrarExames = new DialogCadastrarExames(ControladorFrame.frame);
            dialogCadastrarExames.setVisible(true);
            
        } else if (e.getSource() == panelExames.getBTNEditar()) {
            new DialogReagendarExames(frame).setVisible(true);
        }
    }//do actionperformed

    

}//da classe
