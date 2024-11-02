package visual;
import visual.PanelObjetos;
import controlador.ControladorGeral;

import javax.swing.JFrame;

public class Frame extends JFrame{
	public Frame() {
		setTitle("Simulador Órbita :P");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		PanelObjetos panelObjetos = new PanelObjetos();
		add(panelObjetos);
		 
        new ControladorGeral(panelObjetos);
    }

    public static void main(String[] args) {
        new Frame().setVisible(true);
    }
}//da Classe
