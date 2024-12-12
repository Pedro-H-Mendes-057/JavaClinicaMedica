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
        add(getTxFMedico());
        add(getTxFPaciente());
        add(getRBTFiltrarMedico());
        add(getRBTFiltrarPaciente());
        add(getBTPesquisar());
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
    public JRadioButton getRBTFiltrarMedico() {
        if (this.rBFiltrarMedico == null) {
            this.rBFiltrarMedico = new JRadioButton("Filtrar por médico");
            rBFiltrarMedico.setFont(new Font("Tahoma", Font.PLAIN, 15));
            rBFiltrarMedico.setBounds(21, 505, 146, 39);
            rBFiltrarMedico.setVisible(false);
        }
        return rBFiltrarMedico;
    }

    public JRadioButton getRBTFiltrarPaciente() {
        if (this.rBtFiltrarPaciente == null) {
            this.rBtFiltrarPaciente = new JRadioButton("Filtrar por paciente");
            rBtFiltrarPaciente.setFont(new Font("Tahoma", Font.PLAIN, 15));
            rBtFiltrarPaciente.setBounds(21, 563, 159, 39);
            rBtFiltrarPaciente.setVisible(false);
        }
        return rBtFiltrarPaciente;
    }

    public JTextField getTxFMedico() {
        if (this.txFMedico == null) {
            this.txFMedico = new JTextField();
            txFMedico.setBounds(182, 507, 224, 39);
            txFMedico.setColumns(10);
            txFMedico.setVisible(false);
            txFMedico.setEnabled(false);
        }
        return txFMedico;
    }

    public JTextField getTxFPaciente() {
        if (this.txFPaciente == null) {
            this.txFPaciente = new JTextField();
            txFPaciente.setBounds(182, 563, 224, 39);
            txFPaciente.setColumns(10);
            txFPaciente.setVisible(false);
            txFPaciente.setEnabled(false);
        }
        return txFPaciente;
    }

    public JButton getBTPesquisar() {
        if (this.btnPesquisar == null) {
            this.btnPesquisar = new JButton("Abrir Relatório");
            btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 15));
            btnPesquisar.setBounds(220, 612, 159, 39);
            btnPesquisar.setVisible(false);
        }
        return btnPesquisar;
    }

    public JButton getPescMed() {
        if (this.pescMed == null) {
            this.pescMed = new JButton("Pesquisar");
            pescMed.setBounds(416, 504, 95, 44);
            pescMed.setVisible(false);
        }
        return pescMed;
    }

    public JButton getPescPac1() {
        if (this.pescPac1 == null) {
            this.pescPac1 = new JButton("Pesquisar");
            pescPac1.setBounds(416, 563, 95, 44);
            pescPac1.setVisible(false);
        }
        return pescPac1;
    }
}