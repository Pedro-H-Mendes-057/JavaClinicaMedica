package visual;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class PanelAgendar extends JPanel { // Alterado para herdar de JPanel
    private Frame frame;
    private JTable tabelaSemana;
    private JLabel labelPesquisar;
    private JTextField txFPesquisar;
    private JButton btnNovo;
    private JButton btnEditar;
    private JButton btnCancelar;
    private JButton btnPesquisar;
    private JPanel panelBotoesAgendar;
    private JPanel panelBotoes;
    private JPanel panelPesquisar;
    private JButton btnAvancar, btnVoltar;
    private JLabel labelMes;
    private JLabel labelAno;
    private JLabel labelTitulo;
    private JScrollPane scrollPane;
    private LocalDate dataAtual = LocalDate.now();
    private String[] horarios = { "08:00", "09:00", "10:00", "11:00", "13:00", "14:00", "15:00" };

    public PanelAgendar(Frame frame) {
        this.frame = frame;
        setLayout(new GridBagLayout());
        
        GridBagConstraints gbcPesquisar = new GridBagConstraints();        
        gbcPesquisar.weighty = 0.3;
        gbcPesquisar.anchor = GridBagConstraints.PAGE_START;
        gbcPesquisar.gridx = 0;
        gbcPesquisar.gridy = 0;
        gbcPesquisar.weightx = 0.1;
        gbcPesquisar.fill = GridBagConstraints.HORIZONTAL;
        gbcPesquisar.insets = new Insets(20, 100, 20, 100);        
        this.add(getPanelPesquisar(), gbcPesquisar);
        
        GridBagConstraints gbcBotesAgenda = new GridBagConstraints();
        gbcBotesAgenda.gridx = 0;
        gbcBotesAgenda.gridy = 1;
        gbcBotesAgenda.weightx = 0.1;        
        add(getPanelBotesAgenda(), gbcBotesAgenda);  
        
        GridBagConstraints gbcTabelaAgendamento = new GridBagConstraints();
        gbcTabelaAgendamento.weighty = 0.7;
        gbcTabelaAgendamento.gridx = 0;
        gbcTabelaAgendamento.gridy = 2;
        gbcTabelaAgendamento.weightx = 1.0;
        gbcTabelaAgendamento.fill = GridBagConstraints.HORIZONTAL;
        gbcTabelaAgendamento.insets = new Insets(0, 100, 0, 100);
               add(getJScrollPane(), gbcTabelaAgendamento);
        
        GridBagConstraints gbcBotes = new GridBagConstraints();
        gbcBotes.weighty = 1.2;
        gbcBotes.anchor = GridBagConstraints.NORTH;
        gbcBotes.gridx = 0;
        gbcBotes.gridy = 3;
        gbcBotes.weightx = 0.1;
        gbcBotes.insets = new Insets(0, 100, 50, 100);        
        add(getPanelBotoes(), gbcBotes);

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
        getTableSemana().setModel(modeloTabela);

        // muda o Mes
        getLabelMes().setText(dataAtual.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault()).toUpperCase());
        getLabelAno().setText(String.valueOf(dataAtual.getYear()));
    }

    private void mudarSemana(int nav) {
        dataAtual = dataAtual.plusWeeks(nav); // Muda a semana de acordo com navegaçao (-1 ou +1)
        atualizarTabelaSemana(); // Atualiza a tabela pra mostrar semana nova
    }
    
    public JPanel getPanelPesquisar() {
        if (this.panelPesquisar == null) {
            this.panelPesquisar = new JPanel(new GridBagLayout());
            GridBagConstraints c1 = new GridBagConstraints();
            c1.insets = new Insets(0, 10, 0, 0);
            c1.anchor = GridBagConstraints.WEST;
            c1.gridx = 0;
            c1.gridy = 0;
            c1.weighty = 0.6;
            this.panelPesquisar.add(getLabelPesquisar(), c1);

            GridBagConstraints c2 = new GridBagConstraints();
            c2.weighty = 0.3;
            c2.gridx = 0;
            c2.gridy = 1;
            c2.weightx = 1.0;
            c2.fill = GridBagConstraints.BOTH;
            this.panelPesquisar.add(getTxFPesquisar(), c2);

            GridBagConstraints c3 = new GridBagConstraints();
            c3.gridx = 1;
            c3.gridy = 1;
            c3.fill = GridBagConstraints.BOTH;
            this.panelPesquisar.add(getBTNPesquisar(), c3);
        }
        return this.panelPesquisar;
    }
    
     public JPanel getPanelBotesAgenda() {
        if (this.panelBotoesAgendar == null) { 
            this.panelBotoesAgendar = new JPanel();
            this.panelBotoesAgendar.add(getBTNVoltar());
            this.panelBotoesAgendar.add(getLabelMes());
            this.panelBotoesAgendar.add(getLabelAno());
            this.panelBotoesAgendar.add(getBTNAvancar());
        }
        return this.panelBotoesAgendar;
    }
    
    public JLabel getLabelPesquisar() {
        if (this.labelPesquisar == null) {
            this.labelPesquisar = new JLabel("Pesquisar agendamentos por médico:");
        }
        return this.labelPesquisar;
    }

    public JTextField getTxFPesquisar() {
        if (this.txFPesquisar == null) {
            this.txFPesquisar = new JTextField();
        }
        return this.txFPesquisar;
    }
    
    public JPanel getPanelBotoes() {
        if (this.panelBotoes == null) {
            this.panelBotoes = new JPanel(new GridBagLayout());

            GridBagConstraints c1 = new GridBagConstraints();
            c1.insets = new Insets(0, 0, 0, 10);
            c1.gridx = 0;
            c1.ipady = 10;
            c1.anchor = GridBagConstraints.LINE_START;
            this.panelBotoes.add(getBTNNovo(), c1);

            GridBagConstraints c2 = new GridBagConstraints();
            c2.insets = new Insets(0, 0, 0, 10);
            c2.gridx = 1; 
            c2.ipady = 10;
            c2.anchor = GridBagConstraints.LINE_START;
            this.panelBotoes.add(getBTNEditar(), c2);

            GridBagConstraints c3 = new GridBagConstraints();
            c3.gridx = 2;
            c3.ipady = 10;
            c3.anchor = GridBagConstraints.LINE_START;
            this.panelBotoes.add(getBTNCancelar(), c3);
        }
        return this.panelBotoes;
    }
    
    public JLabel getLabelMes() {
        if (this.labelMes == null) {
            this.labelMes = new JLabel();
        }
        
        return this.labelMes;
    }
    
    public JLabel getLabelAno() {
        if (this.labelAno == null) {
            this.labelAno = new JLabel();
        }
        
        return this.labelAno;
    }
    
    public JButton getBTNNovo() {
        if (this.btnNovo == null) {
            this.btnNovo = new JButton("NOVO");
            this.btnNovo.setBackground(new Color(50, 205, 101));
            this.btnNovo.setForeground(Color.WHITE);
        }
        return this.btnNovo;
    }
    
    public JButton getBTNVoltar() {
        if (this.btnVoltar == null) {
            this.btnVoltar = new JButton("< Voltar ");
        }
        return this.btnVoltar;
    }
    
    public JButton getBTNAvancar() {
        if (this.btnAvancar == null) {
            this.btnAvancar = new JButton(" Avançar >");            
        }
        return this.btnAvancar;
    }

    public JButton getBTNEditar() {
        if (this.btnEditar == null) {
            this.btnEditar = new JButton("EDITAR");
            this.btnEditar.setBackground(new Color(100, 149, 237));
            this.btnEditar.setForeground(Color.WHITE);
        }
        return this.btnEditar;
    }

    public JButton getBTNCancelar() {
        if (this.btnCancelar == null) {
            this.btnCancelar = new JButton("CANCELAR");
            this.btnCancelar.setBackground(new Color(244, 0, 9));
            this.btnCancelar.setForeground(Color.WHITE);
        }
        return this.btnCancelar;
    }
    
     public JButton getBTNPesquisar() {
        if (this.btnPesquisar == null) {
            this.btnPesquisar = new JButton("PESQUISAR");
        }
        return this.btnPesquisar;
    }
     
    public JTable getTableSemana() {
        if (this.tabelaSemana == null) {            
            this.tabelaSemana = new JTable();
        }
        return this.tabelaSemana;
    }
    
    public JScrollPane getJScrollPane() {
        if (this.scrollPane == null) {
            this.scrollPane = new JScrollPane(getTableSemana());
        }
        return this.scrollPane;
    }
}
