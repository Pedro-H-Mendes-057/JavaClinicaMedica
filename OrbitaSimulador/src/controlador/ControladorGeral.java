package controlador;
import visual.PanelObjetos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import javax.swing.JLabel;

public class ControladorGeral {

	private JLabel sol, terra, marte;
	private double angTerra = 0, angMarte = 0;
	private int RTerra = 60, RMarte = 130;
	private int centroX = 250, centroY = 250;
	
	public ControladorGeral(PanelObjetos panel) {
		
		terra = panel.getTerra();
		marte = panel.getMarte();
		
		Timer timer = new Timer(25, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				novaPos();
			}
		});
		timer.start();
	}//do controlador
	
	private void novaPos() {
		int xTerra = (int) (centroX + RTerra * Math.cos(angTerra));
		int yTerra = (int) (centroY + RTerra * Math.sin(angTerra));
		terra.setLocation(xTerra, yTerra);
		
		int xMarte = (int) (centroX + RMarte * Math.cos(angMarte));
		int yMarte = (int) (centroY + RMarte * Math.sin(angMarte));
		marte.setLocation(xMarte, yMarte);
		
		angTerra += 0.05;
		angMarte += 0.03;
	}
	
}//da classe
