package dialogCadastroPanels;

import javax.swing.*;
import java.awt.*;

public class DialogCadastrarExames extends JDialog {
    private JTextField txFNomeExame;
    private JTextField txFDescricao;
    private JTextField txFValor;
    private JTextField txFMedico;
    private JButton btSalvar;
    private JButton btCancelar;
    private JComboBox<String> comboBoxTipo;
    private JComboBox<String> cbMedico;

    public DialogCadastrarExames(JFrame parent) {
	        super(parent, "Cadastrar Exame", true);
	
	        this.setSize(1300, 650);
	        this.setResizable(false);
	        this.setLocationRelativeTo(parent);
	        getContentPane().setLayout(null);
	       
	        //(tentei copiar a organização de Isis e me embananei rs)
	        //isso é pra chamar os metodos no construtor e aparecer na tela
	        getLblNomeExame();
	        getTxFNomeExame();
	        getLblDescricao();
	        getTxFDescricao();
	        getLblTipo();
	        getComboBoxTipo();
	        getLblMedicoResponsavel();
	        getCBMedico();
	        getLblMateriaisUsados();
	        getLblValor();
	        getTxFValor();
	        getBTSalvar();
	        getBTCancelar();
    }
	    public JLabel getLblNomeExame() {
	        JLabel lblNomeExame = new JLabel("Nome do Exame:");
	        lblNomeExame.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblNomeExame.setBounds(63, 44, 452, 29);
	        getContentPane().add(lblNomeExame);
	        return lblNomeExame;
	    }
	
	    public JTextField getTxFNomeExame() {
	        if (this.txFNomeExame == null) {
	            this.txFNomeExame = new JTextField();
	            this.txFNomeExame.setBounds(62, 83, 1170, 40);
	            this.txFNomeExame.setColumns(10);
	            getContentPane().add(this.txFNomeExame);
	        }
	        return this.txFNomeExame;
	    }
	
	    public JLabel getLblDescricao() {
	        JLabel lblDescricao = new JLabel("Descrição:");
	        lblDescricao.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblDescricao.setBounds(63, 133, 240, 29);
	        getContentPane().add(lblDescricao);
	        return lblDescricao;
	    }
	
	    public JTextField getTxFDescricao() {
	        if (this.txFDescricao == null) {
	            this.txFDescricao = new JTextField();
	            this.txFDescricao.setBounds(62, 172, 1170, 149);
	            this.txFDescricao.setColumns(10);
	            getContentPane().add(this.txFDescricao);
	        }
	        return this.txFDescricao;
	    }
	
	    public JLabel getLblTipo() {
	        JLabel lblTipo = new JLabel("Tipo:");
	        lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblTipo.setBounds(63, 331, 240, 29);
	        getContentPane().add(lblTipo);
	        return lblTipo;
	    }
	
	    public JComboBox<String> getComboBoxTipo() {
	        if (this.comboBoxTipo == null) {
	            this.comboBoxTipo = new JComboBox<>(new String[]{"", "Exame físico", "Exame laboratorial", "Imagem",
	            												"Biópsia", "Patologia", "Análise clínica"});
	            this.comboBoxTipo.setBounds(63, 370, 240, 40);
	            getContentPane().add(this.comboBoxTipo);
	        }
	        return this.comboBoxTipo;
	    }
	
	    public JLabel getLblMedicoResponsavel() {
	        JLabel lblMedicoResponsavel = new JLabel("Médico Responsável:");
	        lblMedicoResponsavel.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblMedicoResponsavel.setBounds(356, 331, 335, 29);
	        getContentPane().add(lblMedicoResponsavel);
	        return lblMedicoResponsavel;
	    }
	    
	    public JComboBox<String> getCBMedico() {
	        if (this.cbMedico == null) {
	            this.cbMedico = new JComboBox<>(new String[]{"", "a", "b"});
	            this.cbMedico.setBounds(355, 370, 335, 40);
	            getContentPane().add(this.cbMedico);
	        }
	        return this.cbMedico;
	    }
	
	    public JLabel getLblMateriaisUsados() {
	        JLabel lblMateriaisUsados = new JLabel("Materiais Usados:");
	        lblMateriaisUsados.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblMateriaisUsados.setBounds(737, 331, 240, 29);
	        getContentPane().add(lblMateriaisUsados);
	        return lblMateriaisUsados;
	    }
	
	    public JLabel getLblValor() {
	        JLabel lblValor = new JLabel("Valor Particular:");
	        lblValor.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblValor.setBounds(64, 420, 167, 29);
	        getContentPane().add(lblValor);
	        return lblValor;
	    }
	
	    public JTextField getTxFValor() {
	        if (this.txFValor == null) {
	            this.txFValor = new JTextField();
	            this.txFValor.setBounds(63, 459, 240, 40);
	            this.txFValor.setColumns(10);
	            getContentPane().add(this.txFValor);
	        }
	        return this.txFValor;
	    }
	
	    public JButton getBTSalvar() {
	        if (this.btSalvar == null) {
	            this.btSalvar = new JButton("SALVAR");
	            this.btSalvar.setFont(new Font("Tahoma", Font.PLAIN, 20));
	            this.btSalvar.setBackground(new Color(50, 205, 101));
	            this.btSalvar.setForeground(new Color(255, 255, 255));
	            this.btSalvar.setBounds(844, 538, 177, 55);
	            getContentPane().add(this.btSalvar);
	        }
	        return this.btSalvar;
	    }
	
	    public JButton getBTCancelar() {
	        if (this.btCancelar == null) {
	            this.btCancelar = new JButton("CANCELAR");
	            this.btCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
	            this.btCancelar.setBackground(new Color(253, 2, 90));
	            this.btCancelar.setBounds(1055, 538, 177, 55);
	            getContentPane().add(this.btCancelar);
	        }
	        return this.btCancelar;
	    }//DO BTCANCELAR
}//da classe
