package dialogCadastroPanels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogCadastroPaciente extends JDialog {
	private JTextField txFNomePaciente;
	private JTextField txFDataNasc;
	private JTextField txFContato;
	private JTextField txFAltura;
	private JTextField txFTipoSang;
	private JTextField txFPeso;
	private JTextField txFHistMedic;
	private JTextField txFConvenio;
 
    public DialogCadastroPaciente(JFrame parent) {
        super(parent, "Cadastrar Paciente", true); // True para torná-lo modal

        this.setSize(1300, 650);

        this.setLocationRelativeTo(parent); // Centraliza o diálogo em relação ao Frame principal
        getContentPane().setLayout(null);
        
        JLabel lblNomePaciente = new JLabel("Nome do Paciente:");
        lblNomePaciente.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNomePaciente.setBounds(63, 44, 452, 29);
        getContentPane().add(lblNomePaciente);
        
        txFNomePaciente = new JTextField();
        txFNomePaciente.setBounds(62, 83, 1170, 40);
        getContentPane().add(txFNomePaciente);
        txFNomePaciente.setColumns(10);
        
        txFDataNasc = new JTextField();
        txFDataNasc.setColumns(10);
        txFDataNasc.setBounds(63, 172, 493, 40);
        getContentPane().add(txFDataNasc);
        
        JLabel lblDataNasc = new JLabel("Data de Nascimento");
        lblDataNasc.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblDataNasc.setBounds(64, 133, 452, 29);
        getContentPane().add(lblDataNasc);
        
        JLabel lblContato = new JLabel("Contato");
        lblContato.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblContato.setBounds(64, 222, 452, 29);
        getContentPane().add(lblContato);
        
        txFContato = new JTextField();
        txFContato.setColumns(10);
        txFContato.setBounds(63, 261, 493, 40);
        getContentPane().add(txFContato);
        
        JLabel lblAltura = new JLabel("Altura:");
        lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblAltura.setBounds(64, 330, 204, 29);
        getContentPane().add(lblAltura);
        
        txFAltura = new JTextField();
        txFAltura.setColumns(10);
        txFAltura.setBounds(63, 369, 205, 40);
        getContentPane().add(txFAltura);
        
        JLabel lblTipoSang = new JLabel("Tipo Sanguíneo:");
        lblTipoSang.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblTipoSang.setBounds(278, 330, 204, 29);
        getContentPane().add(lblTipoSang);
        
        txFTipoSang = new JTextField();
        txFTipoSang.setColumns(10);
        txFTipoSang.setBounds(278, 369, 277, 40);
        getContentPane().add(txFTipoSang);
        
        JLabel lblPeso = new JLabel("Peso:");
        lblPeso.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPeso.setBounds(64, 419, 204, 29);
        getContentPane().add(lblPeso);
        
        txFPeso = new JTextField();
        txFPeso.setColumns(10);
        txFPeso.setBounds(63, 458, 205, 40);
        getContentPane().add(txFPeso);
        
        JLabel lblHistMedic = new JLabel("Histórico Médico:");
        lblHistMedic.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblHistMedic.setBounds(634, 330, 710, 29);
        getContentPane().add(lblHistMedic);
        
        txFHistMedic = new JTextField();
        txFHistMedic.setColumns(10);
        txFHistMedic.setBounds(634, 369, 598, 159);
        getContentPane().add(txFHistMedic);
        
        JLabel lblConvenio = new JLabel("Convenio:");
        lblConvenio.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblConvenio.setBounds(278, 419, 204, 29);
        getContentPane().add(lblConvenio);
        
        txFConvenio = new JTextField();
        txFConvenio.setColumns(10);
        txFConvenio.setBounds(278, 458, 277, 40);
        getContentPane().add(txFConvenio);
        
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
    }
}
