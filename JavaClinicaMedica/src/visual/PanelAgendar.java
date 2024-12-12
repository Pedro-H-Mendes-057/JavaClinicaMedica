package visual;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.util.Locale;
import java.time.format.TextStyle;

public class PanelAgendar extends JPanel { // Alterado para herdar de JPanel
    private Frame frame;
    private JTable tabelaSemana;
    private JLabel labelPesquisar;
    private JTextField txFPesquisar;
    private JButton btnNovo;
    private JButton btnEditar;
    private JButton btnCancelar;
    private JButton btnPesquisar;
     private JButton btnNovoExame;
    private JPanel panelBotoesAgendar;
    private JPanel panelBotoes;
    private JPanel panelPesquisar;
    private JButton btnAvancar, btnVoltar;
    private JLabel labelMes;
    private JLabel labelAno;
    private JLabel labelTitulo;
    private JScrollPane scrollPane;
    private LocalDate dataAtual = LocalDate.now();
    private String[] horarios = { "08:00", "09:00", "10:00", "11:00", "12:00","13:00", "14:00", "15:00", "16:00", "17:00", "18:00" };
    LocalDate inicioSemana;    
    
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
        gbcBotes.fill = GridBagConstraints.HORIZONTAL;
        gbcBotes.insets = new Insets(0, 100, 50, 100);        
        add(getPanelBotoes(), gbcBotes);

        atualizarTabelaSemana();
    }

    private void atualizarTabelaSemana() {
        LocalDate inicioSemana = dataAtual.with(java.time.DayOfWeek.MONDAY);
        this.inicioSemana = inicioSemana;
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
        getLabelMes().setText(dataAtual.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault()));
        getLabelAno().setText(String.valueOf(dataAtual.getYear()));
    }

    public void mudarSemana(int nav) {
        dataAtual = dataAtual.plusWeeks(nav); // Muda a semana de acordo com navegaçao (-1 ou +1)
        atualizarTabelaSemana();
    }
    
    // este método será útil nas consultas 
    public LocalDate getInicioSemana() {
        return inicioSemana;
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
            this.panelPesquisar.add(getBTNBuscar(), c3);
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
            this.labelPesquisar = new JLabel("Médico: ");
        }
        return this.labelPesquisar;
    }

    public JTextField getTxFPesquisar() {
        if (this.txFPesquisar == null) {
            this.txFPesquisar = new JTextField();
            this.txFPesquisar.setEditable(false);
        }
        return this.txFPesquisar;
    }    
       
    public JPanel getPanelBotoes() {
        if (this.panelBotoes == null) {
            this.panelBotoes = new JPanel(new GridBagLayout());

            GridBagConstraints c1 = new GridBagConstraints();
            c1.insets = new Insets(0, 0, 0, 10);
            c1.gridx = 0;
            c1.weightx = 0.1;
            c1.ipady = 10;
            c1.anchor = GridBagConstraints.LINE_START;
            this.panelBotoes.add(getBTNNovaConsulta(), c1);
            
            /*GridBagConstraints c2 = new GridBagConstraints();
            c2.insets = new Insets(0, 0, 0, 10);
            c2.gridx = 1;
            c2.ipady = 10;
            c2.anchor = GridBagConstraints.LINE_START;
            this.panelBotoes.add(getBTNNovoExame(), c2);

            GridBagConstraints c3 = new GridBagConstraints();
            c3.insets = new Insets(0, 0, 0, 10);
            c3.gridx = 2; 
            c3.ipady = 10;
            c3.anchor = GridBagConstraints.LINE_START;
            this.panelBotoes.add(getBTNEditar(), c3);

            GridBagConstraints c4 = new GridBagConstraints();
            c4.gridx = 3;
            c4.ipady = 10;
            c4.anchor = GridBagConstraints.LINE_START;
            this.panelBotoes.add(getBTNCancelar(), c4); */
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
    
    public JButton getBTNNovaConsulta() {
        if (this.btnNovo == null) {
            this.btnNovo = new JButton("NOVA CONSULTA");
            this.btnNovo.setBackground(new Color(50, 205, 101));
            this.btnNovo.setForeground(Color.WHITE);
        }
        return this.btnNovo;
    }
    
    /*public JButton getBTNNovoExame() {
        if (this.btnNovoExame == null) {
            this.btnNovoExame = new JButton("NOVO EXAME");
            this.btnNovoExame.setBackground(new Color(50, 205, 101));
            this.btnNovoExame.setForeground(Color.WHITE);
        }
        return this.btnNovoExame;
    } */
    
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

    /*public JButton getBTNEditar() {
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
    } */
    
     public JButton getBTNBuscar() {
        if (this.btnPesquisar == null) {
            this.btnPesquisar = new JButton("BUSCAR");
        }
        return this.btnPesquisar;
    }
     
    public JTable getTableSemana() {
        if (this.tabelaSemana == null) {            
            this.tabelaSemana = new JTable() {
                @Override 
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
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
