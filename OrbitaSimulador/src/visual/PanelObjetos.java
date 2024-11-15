package visual;
import javax.swing.*;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class PanelObjetos extends JPanel{
	JLabel sol, terra, marte;
	private JLabel galaxia;
	
	public PanelObjetos() {
		this.setLayout(null);
		
		galaxia = new JLabel(".");
		galaxia.setBounds(0, 0, 500, 500);
		ImageIcon icGAX = new ImageIcon("src/visual/galaxia.png");
        Image dimGAX = icGAX.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        galaxia.setIcon(new ImageIcon(dimGAX));
		add(galaxia);
		
		//////////SOL
		sol = new JLabel("");
		sol.setBounds(225, 225, 57, 55);
		
		ImageIcon icsol = new ImageIcon("src/visual/sol1.png");
        Image dimSol = icsol.getImage().getScaledInstance(57, 57, Image.SCALE_SMOOTH);
        sol.setIcon(new ImageIcon(dimSol));
		add(sol);
		
		//////////TERRA
		terra = new JLabel("");
		terra.setBounds(203, 136, 36, 38);
		
		ImageIcon icTerra = new ImageIcon("src/visual/terra1.png");
        Image dimTerra = icTerra.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        terra.setIcon(new ImageIcon(dimTerra));
		add(terra);
		
		///////////MARTE
		marte = new JLabel("");
		marte.setBounds(203, 74, 36, 38);
		
		ImageIcon icMarte = new ImageIcon("src/visual/marte1.png");
        Image dimMarte = icMarte.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        marte.setIcon(new ImageIcon(dimMarte));
		add(marte);
		
		setComponentZOrder(galaxia, getComponentCount() - 1); //camada pra botar pro fundo
		
	}
	public JLabel getSol() {
		return sol;
	}
	
	public JLabel getTerra() {
		return terra;
	}
	public JLabel getMarte() {
		return marte;
	}
}
