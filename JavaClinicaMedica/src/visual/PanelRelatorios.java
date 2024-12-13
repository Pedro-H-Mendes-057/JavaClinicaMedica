package visual;

import java.awt.Component;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelRelatorios extends JPanel {
    private Frame frame;
    private JButton btConsultas, btExames, btFinan;
    private JLabel lbTitulo;
    private JTextField txFMedico;
    private JTextField txFPaciente;
    private JButton pescPac1;
    private JButton pescMed;
    private JButton pesq;
    private JRadioButton rBFiltrarMedico;
    private JRadioButton rBtFiltrarPaciente;
    private JButton btnPesquisar;
    private JComboBox<String> comboBoxTipo;
    private JTextArea textArea;
    
    public PanelRelatorios(Frame frame) {
        this.frame = frame;
        setLayout(null);

        this.add(getLbTitulo());
        this.add(getBTConsultas());
        this.add(getBTExames());
        this.add(getBTFinan());
        this.add(getComboBoxTipo());
        this.add(getPescMed());
        this.add(getPescPac1());
        this.add(getPesq());
        add(getTextArea());
        
       // getBTConsultas().setVisible(false);
      //  getBTFinan().setVisible(false);
    }


	public JLabel getLbTitulo() {
        if (this.lbTitulo == null) {
            this.lbTitulo = new JLabel("RELATÓRIOS");
            lbTitulo.setBounds(171, 5, 190, 70);
            lbTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
        }
        return this.lbTitulo;
    }

    public JButton getBTConsultas() {
        if (this.btConsultas == null) {
            this.btConsultas = new JButton("CONSULTAS");
            btConsultas.setBounds(35, 131, 270, 69);
            btConsultas.setFont(new Font("Tahoma", Font.PLAIN, 20));
        }
        return this.btConsultas;
    }

    public JButton getBTExames() {
        if (this.btExames == null) {
            this.btExames = new JButton("EXAMES");
            btExames.setBounds(34, 228, 270, 69);
            btExames.setFont(new Font("Tahoma", Font.PLAIN, 20));
        }
        return this.btExames;
    }

    public JButton getBTFinan() {
        if (this.btFinan == null) {
            this.btFinan = new JButton("FINANCEIRO");
            btFinan.setBounds(35, 325, 270, 69);
            btFinan.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            	}
            });
            btFinan.setFont(new Font("Tahoma", Font.PLAIN, 20));
        }
        return this.btFinan;
    }
    
    public JComboBox<String> getComboBoxTipo() {
        if (this.comboBoxTipo == null) {
            this.comboBoxTipo = new JComboBox<>(new String[]{"", "Exame físico", "Exame laboratorial", "Imagem",
            												"Biópsia", "Patologia", "Análise clínica"});
            this.comboBoxTipo.setBounds(325, 246, 167, 40);
        }
        return this.comboBoxTipo;
    }

    //////////////////////////////////////////////////////////////////////

    public JButton getPescMed() {
        if (this.pescMed == null) {
            this.pescMed = new JButton("Medicos");
            pescMed.setBounds(125, 420, 169, 54);
            pescMed.setVisible(false);
        }
        return pescMed;
    }
    public JButton getPesq() {
    	if (this.pesq== null) {
            this.pesq= new JButton("Pesquisar");
            pesq.setBounds(125, 420, 169, 54);
            pesq.setVisible(true);
            pesq.setEnabled(true);
        }
        return pesq;
    }

    public JButton getPescPac1() {
        if (this.pescPac1 == null) {
            this.pescPac1 = new JButton("Exames");
            pescPac1.setBounds(125, 480, 169, 54);
            pescPac1.setVisible(false);
        }
        return pescPac1;
    }
	public JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setBounds(531, 53, 792, 593);
		}
		return textArea;
	}
}