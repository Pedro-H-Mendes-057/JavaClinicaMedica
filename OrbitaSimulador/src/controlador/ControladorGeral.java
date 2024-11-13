package controlador;

import visual.PanelObjetos;
import javax.swing.JLabel;

public class ControladorGeral extends Thread {

    private JLabel sol, terra, marte;
    private double angTerra = 0, angMarte = 0;
    private int RTerra = 60, RMarte = 130;
    private int centroX = 250, centroY = 250;

    public ControladorGeral(PanelObjetos panel) {
        terra = panel.getTerra();
        marte = panel.getMarte();

        this.start();
    }

    public void run() {
        while (true) {
            for (int i = 0; i < 360; i++) {
                novaPos();
                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                	// TODO: handle exception
                }
            }
        }
    }

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
}
