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
        setLayout(new GridBagLayout());
        
        // Botão NOVO
        JButton btNovo = new JButton("NOVO");
        btNovo.setFont(new Font("Tahoma", Font.PLAIN, 16));
        GridBagConstraints gbcNovo = new GridBagConstraints();
        gbcNovo.gridx = 0;
        gbcNovo.gridy = 0;
        gbcNovo.insets = new Insets(10, 10, 10, 10);
        gbcNovo.fill = GridBagConstraints.HORIZONTAL;
        add(btNovo, gbcNovo);
        btNovo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DialogCadastroExames(frame).setVisible(true); // Abre o JDialog como modal
            }
        });

        // Botão REAGENDAR
        JButton btReagendar = new JButton("REAGENDAR");
        btReagendar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        GridBagConstraints gbcReagendar = new GridBagConstraints();
        gbcReagendar.gridx = 1;
        gbcReagendar.gridy = 0;
        gbcReagendar.insets = new Insets(10, 10, 10, 10);
        gbcReagendar.fill = GridBagConstraints.HORIZONTAL;
        add(btReagendar, gbcReagendar);
    
        // Botão CANCELAR
        JButton btCancelar = new JButton("CANCELAR");
        btCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        GridBagConstraints gbcCancelar = new GridBagConstraints();
        gbcCancelar.gridx = 2;
        gbcCancelar.gridy = 0;
        gbcCancelar.insets = new Insets(10, 10, 10, 10);
        gbcCancelar.fill = GridBagConstraints.HORIZONTAL;
        add(btCancelar, gbcCancelar);

        // Campo de Pesquisa txFPsqExame
        txFPsqExame = new JTextField();
        txFPsqExame.setFont(new Font("Tahoma", Font.PLAIN, 16));
        GridBagConstraints gbcPsqExame = new GridBagConstraints();
        gbcPsqExame.gridx = 3;
        gbcPsqExame.gridy = 0;
        gbcPsqExame.gridwidth = 3;
        gbcPsqExame.insets = new Insets(10, 10, 10, 10);
        gbcPsqExame.fill = GridBagConstraints.HORIZONTAL;
        gbcPsqExame.weightx = 1.0;
        add(txFPsqExame, gbcPsqExame);

        // Botão CONFIRMAR
        JButton btConfirmar = new JButton("CONFIRMAR");
        btConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        GridBagConstraints gbcConfirmar = new GridBagConstraints();
        gbcConfirmar.gridx = 6;
        gbcConfirmar.gridy = 0;
        gbcConfirmar.insets = new Insets(10, 10, 10, 10);
        gbcConfirmar.fill = GridBagConstraints.HORIZONTAL;
        add(btConfirmar, gbcConfirmar);

        // Botão Calendário
        JButton btCalendario = new JButton("Calendário");
        btCalendario.setFont(new Font("Tahoma", Font.PLAIN, 16));
        GridBagConstraints gbcCalendario = new GridBagConstraints();
        gbcCalendario.gridx = 7;
        gbcCalendario.gridy = 0;
        gbcCalendario.insets = new Insets(10, 10, 10, 10);
        gbcCalendario.fill = GridBagConstraints.HORIZONTAL;
        add(btCalendario, gbcCalendario);

        // Tabela
        tabela = new JTable();
        tabela.setFont(new Font("Tahoma", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(tabela);
        GridBagConstraints gbcTabela = new GridBagConstraints();
        gbcTabela.gridx = 0;
        gbcTabela.gridy = 1;
        gbcTabela.gridwidth = 8;
        gbcTabela.insets = new Insets(10, 10, 10, 10);
        gbcTabela.fill = GridBagConstraints.BOTH;
        gbcTabela.weightx = 1.0;
        gbcTabela.weighty = 1.0;
        add(scrollPane, gbcTabela);
    }
}
