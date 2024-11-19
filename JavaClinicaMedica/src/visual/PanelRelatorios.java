package visual;

import java.awt.BorderLayout;

import javax.swing.*;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JTable;

public class PanelRelatorios extends JPanel { //aaaaaaaaaaaaaaaaaaa
	private Frame frame;
	private JTable table;
	private JButton btConsultas, btExames, btFinan,
					btMateriais, btDownload, btReserva;
	private JLabel lbTitulo;

    public PanelRelatorios(Frame frame) {
    	this.frame = frame;
    	setLayout(null);
    	
    	getBTConsultas();
        getBTExames();
        getBTFinan();
        getBTMateriais();
        getBTDownload();
        getBTReserva();
        getLbTitulo();
        getTable();
    }
    
    public JLabel getLbTitulo() {
        if (this.lbTitulo == null) {
            this.lbTitulo = new JLabel("RELATÓRIOS");
            lbTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
            lbTitulo.setBounds(171, 5, 190, 70);
            add(lbTitulo);
        }
        return this.lbTitulo;
    }
    	
    public JButton getBTConsultas() {
        if (this.btConsultas == null) {
            this.btConsultas = new JButton("CONSULTAS");
            btConsultas.setFont(new Font("Tahoma", Font.PLAIN, 20));
            btConsultas.setBounds(125, 130, 270, 69);
            add(btConsultas);
        }
        return this.btConsultas;
    }

    public JButton getBTExames() {
        if (this.btExames == null) {
            this.btExames = new JButton("EXAMES");
            btExames.setFont(new Font("Tahoma", Font.PLAIN, 20));
            btExames.setBounds(124, 227, 270, 69);
            add(btExames);
        }
        return this.btExames;
    }

    public JButton getBTFinan() {
        if (this.btFinan == null) {
            this.btFinan = new JButton("FINANCEIRO");
            btFinan.setFont(new Font("Tahoma", Font.PLAIN, 20));
            btFinan.setBounds(124, 419, 270, 69);
            add(btFinan);
        }
        return this.btFinan;
    }

    public JButton getBTMateriais() {
        if (this.btMateriais == null) {
            this.btMateriais = new JButton("MATERIAIS");
            btMateriais.setFont(new Font("Tahoma", Font.PLAIN, 20));
            btMateriais.setBounds(126, 325, 270, 69);
            add(btMateriais);
        }
        return this.btMateriais;
    }

    public JTable getTable() {
        if (this.table == null) {
            this.table = new JTable();
            table.setBounds(503, 41, 951, 561);
            add(table);
        }
        return this.table;
    }
    
    public JButton getBTDownload() {
        if (this.btDownload == null) {
            this.btDownload = new JButton("");
            btDownload.setBounds(1208, 612, 62, 62);
            add(btDownload);
        }
        return this.btDownload;
    }

    public JButton getBTReserva() {
        if (this.btReserva == null) {
            this.btReserva = new JButton("");
            btReserva.setBounds(1280, 612, 62, 62);
            add(btReserva);
        }
        return this.btReserva;
    }


}// da classe
