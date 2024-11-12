package dialogCadastroPanels;

import javax.swing.*;

import controle.controladorCadastrarPacientes;
import modelo.Endereco;
import modelo.Paciente;
import visual.Frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogCadastrarPaciente extends JDialog {
    private JTextField txFNomePaciente;
    private JTextField txFDataNasc;
    private JTextField txFContato;
    private JTextField txFAltura;
    private JTextField txFTipoSang;
    private JComboBox<String> cbTipoSang;
    private JTextField txFPeso;
    private JTextField txFHistMedic;
    private JTextField txFConvenio;
    private JComboBox<String> cbConvenio;
    private JButton btSalvar; 
    private controladorCadastrarPacientes controlador;
    private JTextField txFNumero;
    private JTextField txFRua;
    private JTextField txFBairro;
    private JTextField txFCidade;
    private JTextField txFCEP;
    private JTextField txFEstado;

    /**
     * @wbp.parser.constructor
     */
    public DialogCadastrarPaciente(JFrame parent) {
        super(parent, "Cadastrar Paciente", true);
        this.setSize(1300, 650);
        this.setResizable(false);
        this.setLocationRelativeTo(parent);
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
        cbTipoSang = new JComboBox<>(new String[] { "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" });
        cbTipoSang.setBounds(278, 369, 277, 40);
        getContentPane().add(cbTipoSang);
        
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
        cbConvenio = new JComboBox<>(new String[] { "Convênio Saúde", "Bem-Estar", "Premium Care", "Vida Melhor", "Saúde para Todos" });
        cbConvenio.setBounds(278, 458, 277, 40);
        getContentPane().add(cbConvenio);
        
        txFConvenio = new JTextField();
        txFConvenio.setColumns(10);
        txFConvenio.setBounds(278, 458, 277, 40);
        getContentPane().add(txFConvenio);
        
        btSalvar = new JButton("SALVAR");
        btSalvar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btSalvar.setBackground(new Color(50, 205, 101));
        btSalvar.setForeground(new Color(255, 255, 255));
        btSalvar.setBounds(844, 538, 177, 55);
        getContentPane().add(btSalvar);
        btSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = txFNomePaciente.getText();
                String dataNasc = txFDataNasc.getText();
                String contato = txFContato.getText();
                String tipoSang = txFTipoSang.getText();
                int altura = Integer.parseInt(txFAltura.getText());
                double peso = Double.parseDouble(txFPeso.getText());
                String convenio = txFConvenio.getText();
                Endereco endereco = null;
                
                controlador.cadastrarNovoPaciente(nome, dataNasc, contato, tipoSang, altura, peso, convenio, endereco);
                JOptionPane.showMessageDialog(DialogCadastrarPaciente.this, "Paciente salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        });
        
        JButton btCancelar = new JButton("CANCELAR");
        btCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btCancelar.setBackground(new Color(253, 2, 90));
        btCancelar.setBounds(1055, 538, 177, 55);
        getContentPane().add(btCancelar);
        
        txFNumero = new JTextField();
        txFNumero.setBounds(612, 172, 80, 40);
        getContentPane().add(txFNumero);
        txFNumero.setColumns(10);
        
        txFRua = new JTextField();
        txFRua.setColumns(10);
        txFRua.setBounds(717, 172, 228, 40);
        getContentPane().add(txFRua);
        
        txFBairro = new JTextField();
        txFBairro.setColumns(10);
        txFBairro.setBounds(969, 172, 263, 40);
        getContentPane().add(txFBairro);
        
        txFCidade = new JTextField();
        txFCidade.setColumns(10);
        txFCidade.setBounds(612, 261, 117, 40);
        getContentPane().add(txFCidade);
        
        txFCEP = new JTextField();
        txFCEP.setColumns(10);
        txFCEP.setBounds(752, 261, 117, 40);
        getContentPane().add(txFCEP);
        
        txFEstado = new JTextField();
        txFEstado.setColumns(10);
        txFEstado.setBounds(904, 261, 117, 40);
        getContentPane().add(txFEstado);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setBounds(608, 160, 60, -10);
        getContentPane().add(lblNewLabel);
        
        JLabel lblNumero = new JLabel("Numero:");
        lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNumero.setBounds(612, 133, 80, 29);
        getContentPane().add(lblNumero);
        
        JLabel lblRua = new JLabel("Rua:");
        lblRua.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblRua.setBounds(717, 133, 152, 29);
        getContentPane().add(lblRua);
        
        JLabel lblBairro = new JLabel("Bairro:");
        lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblBairro.setBounds(969, 133, 152, 29);
        getContentPane().add(lblBairro);
        
        JLabel lblCidade = new JLabel("Cidade:");
        lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblCidade.setBounds(612, 222, 117, 29);
        getContentPane().add(lblCidade);
        
        JLabel lblCep = new JLabel("CEP:");
        lblCep.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblCep.setBounds(754, 222, 117, 29);
        getContentPane().add(lblCep);
        
        JLabel lblEstado = new JLabel("Estado:");
        lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblEstado.setBounds(904, 222, 152, 29);
        getContentPane().add(lblEstado);
    }
    
    public String getNomePaciente() { return txFNomePaciente.getText(); }
    public String getDataNascimento() { return txFDataNasc.getText(); }
    public String getContato() { return txFContato.getText(); }
    public int getAltura() { return parseInt(txFAltura.getText(), 0); }
    public String getTipoSang() { return (String) cbTipoSang.getSelectedItem(); }
    public double getPeso() { return parseDouble(txFPeso.getText(), 0.0); }
    public String getHistoricoMedico() { return txFHistMedic.getText(); }
    public String getConvenio() { return (String) cbConvenio.getSelectedItem(); }
    public JButton getBtSalvar() { return btSalvar; }
    
    private int parseInt(String text, int defaultValue) {
        try { return Integer.parseInt(text); }
        catch (NumberFormatException e) { return defaultValue; }
    }

    private double parseDouble(String text, double defaultValue) {
        try { return Double.parseDouble(text); }
        catch (NumberFormatException e) { return defaultValue; }
    }
}