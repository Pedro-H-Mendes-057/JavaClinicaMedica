package visual;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Teste extends TemplatePanel {
    private Frame frame;
    private JTable tabelaSemana;
    private JButton btnAvancar, btnVoltar;
    private JLabel labelMes;
    private JLabel labelTitulo;
    private LocalDate dataAtual = LocalDate.now();
    private String[] horarios = { "08:00", "09:00", "10:00", "11:00", "13:00", "14:00", "15:00" };

    public Teste(Frame frame) {
        super();
        this.frame = frame;
        setLayout(null); // ainda permite o controle manual

        // Inicializar componentes com proporções relativas
        labelTitulo = new JLabel("AGENDAMENTOS", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelTitulo);

        btnVoltar = new JButton("< Voltar ");
        add(btnVoltar);

        btnAvancar = new JButton(" Avançar >");
        add(btnAvancar);

        labelMes = new JLabel("", SwingConstants.CENTER);
        add(labelMes);

        tabelaSemana = new JTable();
        JScrollPane scrollPane = new JScrollPane(tabelaSemana);
        add(scrollPane);

        atualizarTabelaSemana();

        btnVoltar.addActionListener(e -> mudarSemana(-1));
        btnAvancar.addActionListener(e -> mudarSemana(1));

        // Adicionar o ComponentListener para redimensionamento
        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                ajustarComponentes();
            }
        });

        ajustarComponentes(); // chamada inicial
    }

    private void ajustarComponentes() {
        int largura = getWidth();
        int altura = getHeight();

        labelTitulo.setBounds((int)(largura * 0.4), (int)(altura * 0.02), (int)(largura * 0.2), 30);
        btnVoltar.setBounds((int)(largura * 0.3), (int)(altura * 0.1), 100, 30);
        btnAvancar.setBounds((int)(largura * 0.6), (int)(altura * 0.1), 100, 30);
        labelMes.setBounds((int)(largura * 0.45), (int)(altura * 0.1), 100, 30);
        tabelaSemana.setBounds((int)(largura * 0.1), (int)(altura * 0.2), (int)(largura * 0.8), (int)(altura * 0.6));
    }

    private void atualizarTabelaSemana() {
        // Atualiza cabeçalho e conteúdo da tabela
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

        // Atualiza o mês
        labelMes.setText(dataAtual.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault()).toUpperCase());
    }

    private void mudarSemana(int nav) {
        dataAtual = dataAtual.plusWeeks(nav); // Muda semana com base na navegação
        atualizarTabelaSemana(); // Atualiza a tabela para mostrar nova semana
    }
}

