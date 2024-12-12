package visual;

import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionListener;

public class PanelRelatorios extends JPanel {
    private Frame frame;
    private JTable table;
    private JButton btConsultas, btExames, btFinan, btMateriais, btDownload, btReserva;
    private JLabel lbTitulo;
    private JTextField txFMedico;
    private JTextField txFPaciente;
    private JButton pescPac1;
    private JButton pescMed;
    private JRadioButton rBFiltrarMedico;
    private JRadioButton rBtFiltrarPaciente;
    private JButton btnPesquisar;

    public PanelRelatorios(Frame frame) {
        this.frame = frame;
        setLayout(null);

        add(getLbTitulo());
        add(getBTConsultas());
        add(getBTExames());
        add(getBTFinan());
        add(getBTMateriais());
        add(getTable());
        add(getPescMed());
        add(getPescPac1());
        
       
    }

    public JLabel getLbTitulo() {
        if (this.lbTitulo == null) {
            this.lbTitulo = new JLabel("RELATÓRIOS");
            lbTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
            lbTitulo.setBounds(171, 5, 190, 70);
        }
        return this.lbTitulo;
    }

    public JButton getBTConsultas() {
        if (this.btConsultas == null) {
            this.btConsultas = new JButton("CONSULTAS");
            btConsultas.setFont(new Font("Tahoma", Font.PLAIN, 20));
            btConsultas.setBounds(125, 130, 270, 69);
        }
        return this.btConsultas;
    }

    public JButton getBTExames() {
        if (this.btExames == null) {
            this.btExames = new JButton("EXAMES");
            btExames.setFont(new Font("Tahoma", Font.PLAIN, 20));
            btExames.setBounds(124, 227, 270, 69);
        }
        return this.btExames;
    }

    public JButton getBTFinan() {
        if (this.btFinan == null) {
            this.btFinan = new JButton("FINANCEIRO");
            btFinan.setFont(new Font("Tahoma", Font.PLAIN, 20));
            btFinan.setBounds(124, 419, 270, 69);
        }
        return this.btFinan;
    }

    public JButton getBTMateriais() {
        if (this.btMateriais == null) {
            this.btMateriais = new JButton("MATERIAIS");
            btMateriais.setFont(new Font("Tahoma", Font.PLAIN, 20));
            btMateriais.setBounds(126, 325, 270, 69);
        }
        return this.btMateriais;
    }

    public JTable getTable() {
        if (this.table == null) {
            this.table = new JTable();
            table.setBounds(592, 41, 862, 561);
        }
        return this.table;
    }

    //////////////////////////////////////////////////////////////////////

    public JButton getPescMed() {
        if (this.pescMed == null) {
            this.pescMed = new JButton("Medicos");
            pescMed.setBounds(125, 522, 169, 54);
            pescMed.setVisible(false);
        }
        return pescMed;
    }

    public JButton getPescPac1() {
        if (this.pescPac1 == null) {
            this.pescPac1 = new JButton("Exames");
            pescPac1.setBounds(125, 589, 169, 54);
            pescPac1.setVisible(false);
        }
        return pescPac1;
    }
}