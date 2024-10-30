package visual;

import dialogCadastroPanels.DialogCadastroExames;
import dialogCadastroPanels.DialogReagendarExame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelExame extends JPanel {
    private JTextField txFPesquisa;
    private JTable tabela;

    public PanelExame(JFrame frame) {
    	
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{65, 65, 65, 200, 65}; // coluna
        gridBagLayout.rowHeights = new int[]{0, 0};                      // linha
        gridBagLayout.columnWeights = new double[]{0.1, 0.1, 0.1, 1.0, 0.1};
        gridBagLayout.rowWeights = new double[]{0.1, 1.0};
        setLayout(gridBagLayout);

        // Botão "NOVO"
        JButton btNovo = new JButton("NOVO");
        btNovo.setFont(new Font("Tahoma", Font.PLAIN, 16));
        GridBagConstraints gbc_btNovo = new GridBagConstraints();
        gbc_btNovo.anchor = GridBagConstraints.EAST;
        gbc_btNovo.insets = new Insets(0, 0, 5, 5); // Menor espaçamento
        gbc_btNovo.gridx = 0;
        gbc_btNovo.gridy = 0;
        add(btNovo, gbc_btNovo);
        btNovo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DialogCadastroExames(frame).setVisible(true);
            }
        });

        // Botão "REAGENDAR"
        JButton btReagendar = new JButton("REAGENDAR");
        btReagendar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        GridBagConstraints gbc_btReagendar = new GridBagConstraints();
        gbc_btReagendar.anchor = GridBagConstraints.CENTER;
        gbc_btReagendar.insets = new Insets(0, 0, 5, 5);
        gbc_btReagendar.gridx = 1;
        gbc_btReagendar.gridy = 0;
        add(btReagendar, gbc_btReagendar);
        btReagendar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DialogReagendarExame(frame).setVisible(true);
            }
        });

        // Botão "CANCELAR"
        JButton btCancelar = new JButton("CANCELAR");
        btCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        GridBagConstraints gbc_btCancelar = new GridBagConstraints();
        gbc_btCancelar.anchor = GridBagConstraints.WEST;
        gbc_btCancelar.insets = new Insets(0, 0, 5, 5);
        gbc_btCancelar.gridx = 2;
        gbc_btCancelar.gridy = 0;
        add(btCancelar, gbc_btCancelar);

        // Campo de texto "Pesquisa"
        txFPesquisa = new JTextField();
        txFPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 20));
        GridBagConstraints gbc_txFPesquisa = new GridBagConstraints();
        gbc_txFPesquisa.insets = new Insets(0, 0, 5, 5);
        gbc_txFPesquisa.fill = GridBagConstraints.HORIZONTAL;
        gbc_txFPesquisa.gridx = 3;
        gbc_txFPesquisa.gridy = 0;
        add(txFPesquisa, gbc_txFPesquisa);
        txFPesquisa.setColumns(10);

        // Botão "CONFIRMAR"
        JButton btConfirmar = new JButton("CONFIRMAR");
        btConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        GridBagConstraints gbc_btConfirmar = new GridBagConstraints();
        gbc_btConfirmar.anchor = GridBagConstraints.CENTER;
        gbc_btConfirmar.insets = new Insets(0, 0, 5, 0);
        gbc_btConfirmar.gridx = 4;
        gbc_btConfirmar.gridy = 0;
        add(btConfirmar, gbc_btConfirmar);
        
        tabela = new JTable();
        GridBagConstraints gbc_tabela = new GridBagConstraints();
        gbc_tabela.insets = new Insets(0, 0, 0, 0);
        gbc_tabela.fill = GridBagConstraints.BOTH;
        gbc_tabela.gridx = 0;
        gbc_tabela.gridy = 1;
        gbc_tabela.gridwidth = 5;         // Ocupa as 5 colunas
        add(tabela, gbc_tabela);
    }
}
