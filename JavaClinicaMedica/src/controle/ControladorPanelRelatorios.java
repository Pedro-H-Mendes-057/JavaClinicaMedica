package controle;
import visual.PanelRelatorios;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.JOptionPane;
public class ControladorPanelRelatorios implements ActionListener{
	
	private PanelRelatorios panelRelatorios;
	
	public ControladorPanelRelatorios(PanelRelatorios panelRelatorios){
		
		this.panelRelatorios = panelRelatorios;
		
		addEventos();
		
	}//ControladorPanelRelatorios

	void addEventos() {
		this.panelRelatorios.getBTConsultas().addActionListener(this);
        this.panelRelatorios.getBTExames().addActionListener(this);
        this.panelRelatorios.getBTFinan().addActionListener(this);
        this.panelRelatorios.getBTMateriais().addActionListener(this);
	}//do addEventos
	
	@Override
    public void actionPerformed(ActionEvent e) {
        CorNormal();
        if (e.getSource() == panelRelatorios.getBTConsultas()) {
            panelRelatorios.getBTConsultas().setBackground(new Color(0, 128, 255));
            System.out.println("CONSULTAS APERTADO");
            // COLOCAR O CODIGO PRA MOSTRAR TABELA DE CADA
        } else if (e.getSource() == panelRelatorios.getBTExames()) {
            panelRelatorios.getBTExames().setBackground(new Color(0, 128, 255));
            System.out.println("EXAMES APERTADO");
            // TABELA
        } else if (e.getSource() == panelRelatorios.getBTFinan()) {
            panelRelatorios.getBTFinan().setBackground(new Color(0, 128, 255));
            // TABELA
        } else if (e.getSource() == panelRelatorios.getBTMateriais()) {
            panelRelatorios.getBTMateriais().setBackground(new Color(0, 128, 255));
            // TABELA
        }
    }

    private void CorNormal() {
        // Resetar a cor dos botoes pro normal
        panelRelatorios.getBTConsultas().setBackground(null);
        panelRelatorios.getBTExames().setBackground(null);
        panelRelatorios.getBTFinan().setBackground(null);
        panelRelatorios.getBTMateriais().setBackground(null);
    }

}//da Classe
