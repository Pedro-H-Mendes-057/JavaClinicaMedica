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
    
    
    public ControladorPanelExames(PanelExames panelExames) {
        this.panelExames = panelExames;       
        addEventos();
    }
    
    private void addEventos() {
        this.panelExames.getBTNNovo().addActionListener(this);
        this.panelExames.getBTNEditar().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == panelExames.getBTNNovo()) {
            System.out.println("TESTE");
            dialogCadastrarExames = new DialogCadastrarExames(ControladorFrame.frame);
            dialogCadastrarExames.setVisible(true);
            
            
        } else if (e.getSource() == panelExames.getBTNEditar()) {
            new DialogReagendarExames(ControladorFrame.frame).setVisible(true);
        }
    }//do actionperformed

    

}//da classe
