package dialogCadastroPanels;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;

public class DialogRelatorios extends JDialog {
	
	 public DialogRelatorios(JFrame parent) {
	        super(parent, "Visualizar Relatório", true);
	        this.setSize(1300, 650);
	        this.setResizable(false);
	        this.setLocationRelativeTo(parent);         
	        getContentPane().setLayout(null); 
	        
	        JTextArea textArea = new JTextArea();
	        textArea.setBounds(28, 100, 1220, 503);
	        getContentPane().add(textArea);
	        
	        JLabel lblTitulo = new JLabel("RELATÓRIO DE X");
	        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 40));
	        lblTitulo.setBounds(292, 23, 707, 58);
	        getContentPane().add(lblTitulo);
	 }
}
