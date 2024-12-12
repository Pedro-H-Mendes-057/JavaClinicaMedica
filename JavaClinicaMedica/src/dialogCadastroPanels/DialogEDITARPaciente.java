package dialogCadastroPanels;

import javax.swing.*;

import modelo.Endereco;
import modelo.Paciente;
import visual.Frame;

import java.text.ParseException;

import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogEDITARPaciente extends JDialog {
    private JTextField txFNomePaciente;
    private JTextField txFDataNasc;
    private JTextField txFContato;
    private JTextField txFAltura;
    private JTextField txFTipoSang;
    private JComboBox<String> cbTipoSang;
    private JTextField txFPeso;
    private JTextArea txFHistMedic;
    private JTextField txFConvenio;
    private JComboBox<String> cbConvenio;
    private JTextField txFNumero;
    private JTextField txFRua;
    private JTextField txFBairro;
    private JTextField txFCidade;
    private JTextField txFCEP;
    private JComboBox<String> cbEstado;
    private JButton btCancelar;
    private JButton btSalvar;
    
    private Paciente pacienteAlterado;
    /**
     * @wbp.parser.constructor
     */
    public DialogEDITARPaciente(JFrame parent, Paciente pacienteAlterado) {
        super(parent, "Cadastrar Paciente", true);
        this.setSize(1300, 650);
        this.setResizable(false);
        this.setLocationRelativeTo(parent);
        getContentPane().setLayout(null);
        
       
        //NOME PACIENTE
        JLabel lblNomePaciente = new JLabel("Nome do Paciente:");
        lblNomePaciente.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNomePaciente.setBounds(63, 44, 452, 29);
        getContentPane().add(lblNomePaciente);
        
        txFNomePaciente = new JTextField();
        txFNomePaciente.setBounds(62, 83, 1170, 40);
        getContentPane().add(txFNomePaciente);
        txFNomePaciente.setColumns(10);
        txFNomePaciente.setEnabled(false);
        
        //DATA NASCIMENTO
        JLabel lblDataNasc = new JLabel("Data de Nascimento");
        lblDataNasc.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblDataNasc.setBounds(64, 133, 452, 29);
        getContentPane().add(lblDataNasc);
     
        try {
            MaskFormatter mascDataNasc = new MaskFormatter("##/##/####");
            mascDataNasc.setPlaceholderCharacter(' ');

            txFDataNasc = new JFormattedTextField(mascDataNasc);
            txFDataNasc.setBounds(63, 172, 493, 40);
            txFDataNasc.setFont(new Font("Tahoma", Font.PLAIN, 16));
            getContentPane().add(txFDataNasc);
        } catch (ParseException e) {
            e.printStackTrace();
        }
       txFDataNasc.setEnabled(false);
        
        //CONTATO
        JLabel lblContato = new JLabel("Contato");
        lblContato.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblContato.setBounds(64, 222, 452, 29);
        getContentPane().add(lblContato);
        
        try {
            MaskFormatter mascContato = new MaskFormatter("(##)#####-####");
            mascContato.setPlaceholderCharacter(' ');
            txFContato = new JFormattedTextField(mascContato);
            txFContato.setBounds(63, 261, 493, 40);
            getContentPane().add(txFContato);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        //ALTURA
        JLabel lblAltura = new JLabel("Altura (em cm):");
        lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblAltura.setBounds(64, 330, 204, 29);
        getContentPane().add(lblAltura);
        
        try {
            MaskFormatter mascAltura = new MaskFormatter("###");
            mascAltura.setPlaceholderCharacter(' ');

            txFAltura = new JFormattedTextField(mascAltura);
            txFAltura.setBounds(63, 369, 205, 40);
            txFAltura.setFont(new Font("Tahoma", Font.PLAIN, 16));
            getContentPane().add(txFAltura);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //txFAltura.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        txFAltura.setCaretPosition(3);

		//TIPO SANGUINEO
        JLabel lblTipoSang = new JLabel("Tipo Sanguíneo:");
        lblTipoSang.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblTipoSang.setBounds(278, 330, 204, 29);
        getContentPane().add(lblTipoSang);
        cbTipoSang = new JComboBox<>(new String[] { "", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" });
        cbTipoSang.setBounds(278, 369, 277, 40);
        getContentPane().add(cbTipoSang);
        cbTipoSang.setEnabled(false);
        
        txFTipoSang = new JTextField();
        txFTipoSang.setColumns(10);
        txFTipoSang.setBounds(278, 369, 277, 40);
        getContentPane().add(txFTipoSang);
        
        //PESO
        JLabel lblPeso = new JLabel("Peso:");
        lblPeso.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblPeso.setBounds(64, 419, 204, 29);
        getContentPane().add(lblPeso);
        
        try {
            MaskFormatter mascPeso = new MaskFormatter("###.##");
            mascPeso.setPlaceholderCharacter(' ');

            txFPeso = new JFormattedTextField(mascPeso);
            txFPeso.setBounds(63, 458, 205, 40);
            txFPeso.setFont(new Font("Tahoma", Font.PLAIN, 16));
            getContentPane().add(txFPeso);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        txFPeso.setCaretPosition(3);
        
        //HISTORICO MEDICO
        JLabel lblHistMedic = new JLabel("Histórico Médico:");
        lblHistMedic.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblHistMedic.setBounds(634, 330, 710, 29);
        getContentPane().add(lblHistMedic);
        
        txFHistMedic = new JTextArea();
        txFHistMedic.setColumns(10);
        txFHistMedic.setBounds(634, 369, 598, 159);
        getContentPane().add(txFHistMedic);
        
        //CONVENIO
        JLabel lblConvenio = new JLabel("Convenio:");
        lblConvenio.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblConvenio.setBounds(278, 419, 204, 29);
        getContentPane().add(lblConvenio);
        
        cbConvenio = new JComboBox<>(new String[] { "", "Mais Saúde", "Bem-Estar", "Premium Care", "Vida Melhor", "Saúde para Todos" });
        cbConvenio.setBounds(278, 458, 277, 40);
        getContentPane().add(cbConvenio);
        
        //NUMERO
        JLabel lblNumero = new JLabel("Numero:");
        lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNumero.setBounds(612, 133, 80, 29);
        getContentPane().add(lblNumero);
        
        txFNumero = new JTextField();
        txFNumero.setBounds(612, 172, 80, 40);
        getContentPane().add(txFNumero);
        txFNumero.setColumns(10);
        
        //RUA
        JLabel lblRua = new JLabel("Rua:");
        lblRua.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblRua.setBounds(717, 133, 152, 29);
        getContentPane().add(lblRua);
        
        txFRua = new JTextField();
        txFRua.setColumns(10);
        txFRua.setBounds(717, 172, 228, 40);
        getContentPane().add(txFRua);
        
        //BAIRRO
        JLabel lblBairro = new JLabel("Bairro:");
        lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblBairro.setBounds(969, 133, 152, 29);
        getContentPane().add(lblBairro);
        
        txFBairro = new JTextField();
        txFBairro.setColumns(10);
        txFBairro.setBounds(969, 172, 263, 40);
        getContentPane().add(txFBairro);
        
        //CIDADE
        txFCidade = new JTextField();
        txFCidade.setColumns(10);
        txFCidade.setBounds(612, 261, 117, 40);
        getContentPane().add(txFCidade);
        
        JLabel lblCidade = new JLabel("Cidade:");
        lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblCidade.setBounds(612, 222, 117, 29);
        getContentPane().add(lblCidade);
        
        //CEP
        JLabel lblCep = new JLabel("CEP:");
        lblCep.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblCep.setBounds(754, 222, 117, 29);
        getContentPane().add(lblCep);
        
         try {
            MaskFormatter mascCEP = new MaskFormatter("#####-###");
            mascCEP.setPlaceholderCharacter('_');
            txFCEP = new JFormattedTextField(mascCEP);
            txFCEP.setBounds(752, 261, 117, 40);
            getContentPane().add(txFCEP);
        } catch (ParseException e) {
            e.printStackTrace();
        }
       
       //ESTADO
        JLabel lblEstado = new JLabel("Estado:");
        lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblEstado.setBounds(904, 222, 152, 29);
        getContentPane().add(lblEstado);
        
        cbEstado = new JComboBox<>(new String[] {"", "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Espírito Santo",
                                                 "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais",
                                                 "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte",
                                                 "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins"});
        cbEstado.setBounds(904, 261, 117, 40);
        getContentPane().add(cbEstado);
        
        //?????????????????????????
        JLabel lblNewLabel = new JLabel("LABELA DESCONHECIDA?");
        lblNewLabel.setBounds(608, 160, 60, -10);
        getContentPane().add(lblNewLabel);
        
        //BOTAO SALVAR
        btSalvar = new JButton("SALVAR");
        btSalvar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btSalvar.setBackground(new Color(50, 205, 101));
        btSalvar.setForeground(new Color(255, 255, 255));
        btSalvar.setBounds(844, 538, 177, 55);
        getContentPane().add(btSalvar);
        
        //BOTAO CANCELAR
        btCancelar = new JButton("CANCELAR");
        btCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btCancelar.setBackground(new Color(253, 2, 90));
        btCancelar.setBounds(1055, 538, 177, 55);
        getContentPane().add(btCancelar);
        
        this.pacienteAlterado = pacienteAlterado;

        preencherCampos();
    }//do ConstrutorDialogEDITAR
    
   
   
    public String getNomePaciente() {
        return txFNomePaciente.getText(); 
    }
    
    public String getDataNascimento() {
        return txFDataNasc.getText(); 
    }
    
    public String getContato() {
        return txFContato.getText(); 
    }
    
    public double getAltura() {
        return parseDouble(txFAltura.getText(), 0.0); 
    }
    
    public String getTipoSang() {
        return (String) cbTipoSang.getSelectedItem(); 
    }
    
    public double getPeso() {
        return parseDouble(txFPeso.getText(), 0.0); 
    }
    
    public String getHistoricoMedico() {
        return txFHistMedic.getText(); 
    }
    
    public String getConvenio() {
        return (String) cbConvenio.getSelectedItem(); 
    }
    
    public JButton getBtSalvar() {
        return btSalvar; 
    }
    
    public JButton getBtCancelar() {
        return btCancelar;
    }
    
    private int parseInt(String text, int defaultValue) {
        try { return Integer.parseInt(text); }
        catch (NumberFormatException e) { return defaultValue; }
    }

    private double parseDouble(String text, double defaultValue) {
        try { return Double.parseDouble(text); }
        catch (NumberFormatException e) { return defaultValue; }
    }

    public JTextField getTxFNomePaciente() {
            return txFNomePaciente;
    }

    public JTextField getTxFDataNasc() {
            return txFDataNasc;
    }

    public JTextField getTxFContato() {
            return txFContato;
    }

    public JTextField getTxFAltura() {
            return txFAltura;
    }

    public JComboBox<String> getCbTipoSang() {
            return cbTipoSang;
    }

    public JTextField getTxFPeso() {
            return txFPeso;
    }

    public JTextArea getTxFHistMedic() {
            return txFHistMedic;
    }

    public JTextField getTxFConvenio() {
            return txFConvenio;
    }

    public JComboBox<String> getCbConvenio() {
            return cbConvenio;
    }

    public JTextField getTxFNumero() {
            return txFNumero;
    }

    public JTextField getTxFRua() {
            return txFRua;
    }

    public JTextField getTxFBairro() {
            return txFBairro;
    }

    public JTextField getTxFCidade() {
            return txFCidade;
    }

    public JTextField getTxFCEP() {
            return txFCEP;
    }

    public JComboBox getCBEstado() {
            return cbEstado;
    }

    public String getEstado() {
         return (String) cbEstado.getSelectedItem(); 
     }
    
    void preencherCampos() {
        if (pacienteAlterado != null) {
            txFNomePaciente.setText(pacienteAlterado.getNome());
            txFDataNasc.setText(pacienteAlterado.getDataNasc());
            txFContato.setText(pacienteAlterado.getContato());
            txFAltura.setText(String.valueOf(pacienteAlterado.getAltura()));
            txFPeso.setText(String.valueOf(pacienteAlterado.getPeso()));
            cbTipoSang.setSelectedItem(pacienteAlterado.getTipoSang());
            //txFHistMedic.setText(pacienteAlterado.getHistMed().toString());
            cbConvenio.setSelectedItem(pacienteAlterado.getConvenio());
            txFNumero.setText(String.valueOf(pacienteAlterado.getEndereco().getNumero()));
            txFRua.setText(pacienteAlterado.getEndereco().getRua());
            txFBairro.setText(pacienteAlterado.getEndereco().getBairro());
            txFCidade.setText(pacienteAlterado.getEndereco().getCidade());
            txFCEP.setText(pacienteAlterado.getEndereco().getCep());
            cbEstado.setSelectedItem(pacienteAlterado.getEndereco().getEstado());
        } else {
            JOptionPane.showMessageDialog(this, "Paciente não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}