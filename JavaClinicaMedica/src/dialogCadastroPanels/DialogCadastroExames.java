package dialogCadastroPanels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogCadastroExames extends JDialog {
	private JTextField txFNomeExame;
	private JTextField txFDescricao;
	private JTextField txFValor;
	private JTextField txFMedico;

	  
    public DialogCadastroExames(JFrame parent) {
        super(parent, "Cadastrar Exame", true); // True para torná-lo modal

        this.setSize(1300, 650);
        this.setResizable(false);
        this.setLocationRelativeTo(parent); // Centraliza o diálogo em relação ao Frame principal
        getContentPane().setLayout(null);
        
        JLabel lblNomeExame = new JLabel("Nome do Exame:");
        lblNomeExame.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNomeExame.setBounds(63, 44, 452, 29);
        getContentPane().add(lblNomeExame);
        
        txFNomeExame = new JTextField();
        txFNomeExame.setBounds(62, 83, 1170, 40);
        getContentPane().add(txFNomeExame);
        txFNomeExame.setColumns(10);
        
        JButton btSalvar = new JButton("SALVAR");
        btSalvar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btSalvar.setBackground(new Color(0, 128, 255));
        btSalvar.setBounds(844, 538, 177, 55);
        getContentPane().add(btSalvar);
        
        JButton btCancelar = new JButton("CANCELAR");
        btCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btCancelar.setBackground(new Color(253, 2, 90));
        btCancelar.setBounds(1055, 538, 177, 55);
        getContentPane().add(btCancelar);
        
        txFDescricao = new JTextField();
        txFDescricao.setColumns(10);
        txFDescricao.setBounds(62, 172, 1170, 149);
        getContentPane().add(txFDescricao);
        
        JLabel lblDescricao = new JLabel("Descrição:");
        lblDescricao.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblDescricao.setBounds(63, 133, 240, 29);
        getContentPane().add(lblDescricao);
        
        JComboBox comboBoxTipo = new JComboBox();
        comboBoxTipo.setBounds(63, 370, 240, 40);
        getContentPane().add(comboBoxTipo);
        
        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblTipo.setBounds(63, 331, 240, 29);
        getContentPane().add(lblTipo);
        
        JLabel lblMateriaisUsados = new JLabel("Materiais Usados:");
        lblMateriaisUsados.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblMateriaisUsados.setBounds(737, 331, 240, 29);
        getContentPane().add(lblMateriaisUsados);
        
        JLabel lblValor = new JLabel("Valor Particular:");
        lblValor.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblValor.setBounds(64, 420, 167, 29);
        getContentPane().add(lblValor);
        
        txFValor = new JTextField();
        txFValor.setColumns(10);
        txFValor.setBounds(63, 459, 240, 40);
        getContentPane().add(txFValor);
        
        txFMedico = new JTextField();
        txFMedico.setColumns(10);
        txFMedico.setBounds(355, 370, 335, 40);
        getContentPane().add(txFMedico);
        
        JLabel lblMedicoResponsvel = new JLabel("Médico Responsável:");
        lblMedicoResponsvel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblMedicoResponsvel.setBounds(356, 331, 335, 29);
        getContentPane().add(lblMedicoResponsvel);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(736, 370, 496, 132);
        getContentPane().add(lblNewLabel);
    }
}
