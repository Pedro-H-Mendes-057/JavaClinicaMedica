package visual;

import javax.swing.*;
import dialogCadastroPanels.DialogCadastroPaciente;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelPacientes extends JPanel {
    private JButton novoButton;
    private JTextField txFPsqPaciente;
    private JButton btnNewButton;
    private JTable table;
    private JButton btEditar;
    private JButton btnCancelar;
    private JLabel lblPsqPaciente;
    private GridBagConstraints gbc_1;
    private GridBagConstraints gbc_2;

    public PanelPacientes(JFrame frame) {
        // Configurando o GridBagLayout
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{65, 65, 65, 65, 65, 65, 65}; // 7 colunas
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0}; // 4 linhas
        gridBagLayout.columnWeights = new double[]{0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
        gridBagLayout.rowWeights = new double[]{0.1, 0.1, 1.0, 0.1};
        setLayout(gridBagLayout);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL; // Preenche horizontalmente as células

        // Label "Pesquisar por paciente" na linha 0, coluna 1
        lblPsqPaciente = new JLabel("Pesquisar por paciente");
        lblPsqPaciente.setFont(new Font("Tahoma", Font.PLAIN, 20));
        gbc_1 = new GridBagConstraints();
        gbc_1.anchor = GridBagConstraints.SOUTHWEST;
        gbc_1.gridx = 1; // coluna 1
        gbc_1.gridy = 0; // linha 0
        gbc_1.insets = new Insets(10, 10, 10, 10); // Espaçamento
        add(lblPsqPaciente, gbc_1);

        // Campo de texto na linha 1, coluna 1
        txFPsqPaciente = new JTextField();
        txFPsqPaciente.setToolTipText("  Pesquisar por paciente ");
        txFPsqPaciente.setForeground(new Color(0, 0, 0));
        txFPsqPaciente.setFont(new Font("Tahoma", Font.PLAIN, 20));
        gbc_2 = new GridBagConstraints();
        gbc_2.gridx = 1; // coluna 1
        gbc_2.gridy = 1; // linha 1
        gbc_2.gridwidth = 4; // Ocupa 4 colunas
        add(txFPsqPaciente, gbc_2);
        txFPsqPaciente.setColumns(90);

        // Botão "PESQUISAR" na linha 1, coluna 5
        btnNewButton = new JButton("PESQUISAR");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        gbc = new GridBagConstraints(); ///////////////////////////
        gbc.gridx = 5; // coluna 5
        gbc.gridy = 1; // linha 1
        gbc.gridwidth = 1; // Ocupa 1 coluna
        txFPsqPaciente.setMinimumSize(new Dimension(1200, 40));
        add(btnNewButton, gbc);

        // Tabela na linha 2, colunas 1 a 5
        table = new JTable();
        gbc = new GridBagConstraints(); ///////////////////////////
        gbc.gridx = 1; // coluna 1
        gbc.gridy = 2; // linha 2
        gbc.gridwidth = 4; // Ocupa 4 colunas
        gbc.weighty = 1; // Permite que a tabela cresça
        gbc.fill = GridBagConstraints.BOTH; // Preenche tanto horizontal quanto verticalmente
        add(new JScrollPane(table), gbc); // Usando JScrollPane para a tabela

        // Botão "NOVO" na linha 3, coluna 1
        novoButton = new JButton("NOVO");
        novoButton.setBackground(new Color(0, 128, 255));
        novoButton.setForeground(new Color(255, 255, 255));
        novoButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        gbc = new GridBagConstraints(); ///////////////////////////
        gbc.gridx = 1; // coluna 1
        gbc.gridy = 3; // linha 3
        gbc.gridwidth = 1; // Ocupa 1 coluna
        gbc.weighty = 0; // Resetando o peso
        add(novoButton, gbc);
        novoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DialogCadastroPaciente(frame).setVisible(true); // Abre o JDialog como modal
            }
        });

        // Botão "EDITAR" na linha 3, coluna 2
        btEditar = new JButton("EDITAR");
        btEditar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        gbc = new GridBagConstraints(); ///////////////////////////
        gbc.gridx = 2; // coluna 2
        gbc.gridy = 3; // linha 3
        add(btEditar, gbc);

        // Botão "CANCELAR" na linha 3, coluna 3
        btnCancelar = new JButton("CANCELAR");
        btnCancelar.setBackground(new Color(253, 2, 90));
        btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        gbc = new GridBagConstraints(); ///////////////////////////
        gbc.gridx = 3; // coluna 3
        gbc.gridy = 3; // linha 3
        add(btnCancelar, gbc);
    }
}
