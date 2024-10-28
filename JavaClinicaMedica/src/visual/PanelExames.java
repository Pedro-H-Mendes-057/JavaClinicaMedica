package visual;

import dialogCadastroPanels.DialogCadastroExames;
import dialogCadastroPanels.DialogReagendarExame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelExames extends JPanel {
    private JTextField txFPsqExame;
    private JTable tabela;

    public PanelExames(JFrame frame) {
        // Definindo o layout
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 158, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0}; // 5 colunas
        gridBagLayout.rowWeights = new double[]{0.0, 1.0}; // 3 linhas
        setLayout(gridBagLayout);

        // Botão NOVO
        GridBagConstraints gbcNovo = new GridBagConstraints();
        gbcNovo.insets = new Insets(10, 10, 10, 10); // Espaçamento
        gbcNovo.gridx = 0; // Coluna 0
        gbcNovo.gridy = 0; // Linha 0
        JButton btNovo = new JButton("NOVO");
        btNovo.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(btNovo, gbcNovo);
        btNovo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DialogCadastroExames(frame).setVisible(true);
            }
        });

        // Botão REAGENDAR
        GridBagConstraints gbcReagendar = new GridBagConstraints();
        gbcReagendar.insets = new Insets(10, 10, 10, 10); // Espaçamento
        gbcReagendar.gridx = 1; // Coluna 1
        gbcReagendar.gridy = 0; // Linha 0
        JButton btReagendar = new JButton("REAGENDAR");
        btReagendar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(btReagendar, gbcReagendar);
        btReagendar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DialogReagendarExame(frame).setVisible(true);
            }
        });

        // Botão CANCELAR
        GridBagConstraints gbcCancelar = new GridBagConstraints();
        gbcCancelar.insets = new Insets(10, 10, 10, 10); // Espaçamento
        gbcCancelar.gridx = 2; // Coluna 2
        gbcCancelar.gridy = 0; // Linha 0
        JButton btCancelar = new JButton("CANCELAR");
        btCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(btCancelar, gbcCancelar);

        // Campo de texto
        GridBagConstraints gbcTexto = new GridBagConstraints();
        gbcTexto.insets = new Insets(10, 10, 10, 10); // Espaçamento
        gbcTexto.gridx = 3; // Coluna 3
        gbcTexto.gridy = 0; // Linha 0
        txFPsqExame = new JTextField(50); // Tamanho padrão de 50
        txFPsqExame.setMinimumSize(new Dimension(200, 30)); // Tamanho mínimo
        txFPsqExame.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(txFPsqExame, gbcTexto);
        
        // Botão CONFIRMAR
        GridBagConstraints gbcConfirmar = new GridBagConstraints();
        gbcConfirmar.insets = new Insets(10, 10, 10, 10); // Espaçamento
        gbcConfirmar.gridx = 4; // Coluna 4
        gbcConfirmar.gridy = 0; // Linha 0
        JButton btConfirmar = new JButton("CONFIRMAR");
        btConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(btConfirmar, gbcConfirmar);

        // Botão CALENDÁRIO
        GridBagConstraints gbcCalendario = new GridBagConstraints();
        gbcCalendario.insets = new Insets(10, 10, 10, 10); // Espaçamento
        gbcCalendario.gridx = 4; // Coluna 4
        gbcCalendario.gridy = 0; // Linha 0
        JButton btCalendario = new JButton("CALENDÁRIO");
        btCalendario.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(btCalendario, gbcCalendario);

        // Segunda linha: Tabela ocupando todas as colunas
        GridBagConstraints gbcTabela = new GridBagConstraints();
        gbcTabela.gridx = 0; // Começa na coluna 0
        gbcTabela.gridy = 1; // Linha 1
        gbcTabela.gridwidth = 5; // Ocupa 5 colunas
        gbcTabela.weighty = 1.0; // Expande para preencher o espaço
        gbcTabela.fill = GridBagConstraints.BOTH;

        tabela = new JTable(); // Coloque seus dados e modelo aqui
        JScrollPane scrollPane = new JScrollPane(tabela);
        add(scrollPane, gbcTabela);

        // Terceira linha: vazia
        GridBagConstraints gbcVazio = new GridBagConstraints();
        gbcVazio.gridy = 2; // Linha 2
        gbcVazio.gridwidth = 5; // Ocupa 5 colunas, mas não adiciona nada
        // Se desejar, adicione novos botões ou componentes aqui
    }
}
