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

    public PanelPacientes(JFrame frame) {
        
        txFPsqPaciente = new JTextField();
        txFPsqPaciente.setToolTipText("  Pesquisar por paciente ");
        txFPsqPaciente.setForeground(new Color(0, 0, 0));
        txFPsqPaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txFPsqPaciente.setBounds(184, 78, 893, 46);
        add(txFPsqPaciente);
        txFPsqPaciente.setColumns(10);
        
        btnNewButton = new JButton("PESQUISAR");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton.setBounds(1144, 78, 123, 45);
        add(btnNewButton);
        
        table = new JTable();
        table.setBounds(184, 153, 1083, 449);
        add(table);
        
        ////// BOTAO NOVO ----> CADASTRAR PACIENTE
        novoButton = new JButton("NOVO");
        novoButton.setBackground(new Color(0, 128, 255));
        novoButton.setForeground(new Color(255, 255, 255));
        novoButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        novoButton.setBounds(184, 639, 151, 39);
        novoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DialogCadastroPaciente(frame).setVisible(true); // Abre o JDialog como modal
            }
        }); setLayout(null);
        this.add(novoButton);
        
        btEditar = new JButton("EDITAR");
        btEditar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btEditar.setBounds(345, 639, 151, 39);
        add(btEditar);
        
        btnCancelar = new JButton("CANCELAR");
        btnCancelar.setBackground(new Color(253, 2, 90));
        btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnCancelar.setBounds(506, 639, 151, 39);
        add(btnCancelar);
        
        lblPsqPaciente = new JLabel("Pesquisar por paciente");
        lblPsqPaciente.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPsqPaciente.setBounds(184, 45, 223, 31);
        add(lblPsqPaciente);
    }
}
