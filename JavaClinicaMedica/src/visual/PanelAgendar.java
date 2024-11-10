package visual;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class PanelAgendar extends TemplatePanel { // Alterado para herdar de JPanel
    private Frame frame;
    private JTable tabelaSemana;
    private JButton btnAvancar, btnVoltar;
    private JLabel labelMes;
    private JLabel labelTitulo;
    private LocalDate dataAtual = LocalDate.now();
    private String[] horarios = { "08:00", "09:00", "10:00", "11:00", "13:00", "14:00", "15:00" };

    public PanelAgendar(Frame frame) {
    	super();
        this.frame = frame;
        setLayout(null); // usei o layout null pra editar o panel no windowbuilder :P

        labelTitulo = new JLabel("AGENDAMENTOS");
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelTitulo.setBounds(600, 21, 184, 20);
        add(labelTitulo);

        btnVoltar = new JButton("< Voltar ");
        btnVoltar.setBounds(503, 51, 100, 30);
        add(btnVoltar);

        btnAvancar = new JButton(" Avançar >");
        btnAvancar.setBounds(777, 51, 100, 30);
        add(btnAvancar);

        labelMes = new JLabel();
        labelMes.setHorizontalAlignment(SwingConstants.CENTER);
        labelMes.setBounds(636, 51, 100, 30);
        add(labelMes);

        tabelaSemana = new JTable();
        JScrollPane scrollPane = new JScrollPane(tabelaSemana);
        scrollPane.setBounds(190, 109, 1094, 475);
        add(scrollPane);

        atualizarTabelaSemana();

        // EVento dos botoes
        btnVoltar.addActionListener(e -> mudarSemana(-1));
        btnAvancar.addActionListener(e -> mudarSemana(1));
    }

    private void atualizarTabelaSemana() {
        // Atualiza o cabeçalho com os dias da semana
        LocalDate inicioSemana = dataAtual.with(java.time.DayOfWeek.MONDAY);
        String[] colunas = new String[8];
        colunas[0] = "HORÁRIOS";
        for (int i = 1; i < 8; i++) {
            LocalDate dia = inicioSemana.plusDays(i - 1);
            String nomeDia = dia.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.getDefault()).toUpperCase();
            colunas[i] = nomeDia + " " + dia.getDayOfMonth();
        }

        DefaultTableModel modeloTabela = new DefaultTableModel(colunas, horarios.length);
        for (int i = 0; i < horarios.length; i++) {
            modeloTabela.setValueAt(horarios[i], i, 0); //primeira coluna
        }
        tabelaSemana.setModel(modeloTabela);

        // muda o Mes
        labelMes.setText(dataAtual.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault()).toUpperCase());
    }

    private void mudarSemana(int nav) {
        dataAtual = dataAtual.plusWeeks(nav); // Muda a semana de acordo com navegaçao (-1 ou +1)
        atualizarTabelaSemana(); // Atualiza a tabela pra mostrar semana nova
    }
}
