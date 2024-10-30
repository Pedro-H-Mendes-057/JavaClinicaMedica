package dialogCadastroPanels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogReagendarExame extends JDialog {
	private JTextField txFNomeExame;
	private JTextField txFDescricao;
	private JTextField txFValor;
	private JTextField txFMedico;
	private JTextField txFNomePaciente;
	private JTextField textField;
	private JTextField txFData;
	private JTextField txFHora;
	private JTextField txFMedicoResponsavel;
	private JTextField txFValorParticular;
 
    public DialogReagendarExame(JFrame parent) {
        super(parent, "Reagendar Exame", true); // True para torná-lo modal

        this.setSize(1300, 650);

        this.setLocationRelativeTo(parent);
        getContentPane().setLayout(null);
        
        JLabel lblNomePaciente = new JLabel("Nome do Paciente");
        lblNomePaciente.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNomePaciente.setBounds(43, 44, 395, 34);
        getContentPane().add(lblNomePaciente);
        
        txFNomePaciente = new JTextField();
        txFNomePaciente.setBounds(43, 81, 1142, 40);
        getContentPane().add(txFNomePaciente);
        txFNomePaciente.setColumns(10);
        
        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(43, 165, 1142, 40);
        getContentPane().add(textField);
        
        JLabel lblNomeExame = new JLabel("Nome do Exame:");
        lblNomeExame.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNomeExame.setBounds(43, 128, 395, 34);
        getContentPane().add(lblNomeExame);
        
        txFData = new JTextField();
        txFData.setColumns(10);
        txFData.setBounds(43, 252, 201, 40);
        getContentPane().add(txFData);
        
        JLabel lblData = new JLabel("Data");
        lblData.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblData.setBounds(43, 215, 106, 34);
        getContentPane().add(lblData);
        
        JLabel lblHora = new JLabel("Hora");
        lblHora.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblHora.setBounds(254, 215, 106, 34);
        getContentPane().add(lblHora);
        
        txFHora = new JTextField();
        txFHora.setColumns(10);
        txFHora.setBounds(254, 252, 201, 40);
        getContentPane().add(txFHora);
        
        JComboBox comboBoxTipo = new JComboBox();
        comboBoxTipo.setBounds(43, 346, 412, 40);
        getContentPane().add(comboBoxTipo);
        
        JLabel lblTipo = new JLabel("Tipo");
        lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblTipo.setBounds(43, 302, 106, 34);
        getContentPane().add(lblTipo);
        
        JLabel lblMateriaisUsados = new JLabel("Materiais Usados");
        lblMateriaisUsados.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblMateriaisUsados.setBounds(43, 396, 348, 34);
        getContentPane().add(lblMateriaisUsados);
        
        JLabel lblMedicoResponsvel = new JLabel("Médico Responsável:");
        lblMedicoResponsvel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblMedicoResponsvel.setBounds(520, 215, 657, 34);
        getContentPane().add(lblMedicoResponsvel);
        
        txFMedicoResponsavel = new JTextField();
        txFMedicoResponsavel.setColumns(10);
        txFMedicoResponsavel.setBounds(520, 252, 665, 40);
        getContentPane().add(txFMedicoResponsavel);
        
        JLabel lblValor = new JLabel("Valor Particular");
        lblValor.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblValor.setBounds(520, 309, 657, 34);
        getContentPane().add(lblValor);
        
        txFValorParticular = new JTextField();
        txFValorParticular.setColumns(10);
        txFValorParticular.setBounds(520, 346, 665, 40);
        getContentPane().add(txFValorParticular);
        
        JButton btnSalvar = new JButton("SALVAR");
        btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnSalvar.setBounds(840, 514, 152, 48);
        getContentPane().add(btnSalvar);
        
        JButton btnCancelar = new JButton("CANCELAR");
        btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnCancelar.setBounds(1033, 514, 152, 48);
        getContentPane().add(btnCancelar);
    }
}
