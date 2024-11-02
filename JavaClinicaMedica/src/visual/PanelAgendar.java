package visual;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelAgendar extends JPanel {
    private JTextField txFPesquisar;
    private JTable table;
    private JScrollPane tableAgendar;

    public PanelAgendar(JFrame frame) {
        setLayout(null);

        JLabel lblNewLabel = new JLabel("Agendamentos");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(625, 40, 150, 24);
        add(lblNewLabel);

        JButton btNovo = new JButton("NOVO");
        btNovo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btNovo.setBounds(192, 92, 91, 36);
        add(btNovo);

        JButton btReagendar = new JButton("REAGENDAR");
        btReagendar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btReagendar.setBounds(293, 92, 120, 36);
        add(btReagendar);

        JButton btExcluir = new JButton("EXCLUIR");
        btExcluir.setBounds(423, 92, 101, 36);
        add(btExcluir);

        JButton btPesquisar = new JButton("PESQUISAR");
        btPesquisar.setBounds(1101, 92, 144, 36);
        add(btPesquisar);

        txFPesquisar = new JTextField();
        txFPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txFPesquisar.setBounds(534, 92, 557, 36);
        add(txFPesquisar);
        txFPesquisar.setColumns(10);

        JButton btCalendario = new JButton("Calendario");
        btCalendario.setBounds(1255, 92, 58, 36);
        add(btCalendario);

        add(getTableAgendar());
    } //do Panel Agendar

    public JScrollPane getTableAgendar() {
        if (this.tableAgendar == null) {
            String[] colunas = {"DIA", "HORA", "PACIENTE", "EXAME/CONSULTA", "MEDICO"};
            int numLinhas = 10;
            DefaultTableModel model = new DefaultTableModel(numLinhas, colunas.length);
            model.setColumnIdentifiers(colunas);

            table = new JTable(model);
            tableAgendar = new JScrollPane(table);
            tableAgendar.setBounds(192, 138, 1121, 492); // Define a posição e o tamanho da tabela
        }//do if
        return this.tableAgendar;
    }//do getTable
}// da classe
