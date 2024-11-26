package dialogCadastroPanels;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import repositorio.RepositorioMateriais; 
import controle.ControladorFrame;
import modelo.Material;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class DialogCadastrarExames extends JDialog {
    private JTextField txFNomeExame;
    private JTextField txFDescricao;
    private JTextField txFValor;
    private JTextField txFMedico;
    private JButton btSalvar;
    private JButton btCancelar;
    private JComboBox<String> comboBoxTipo;
    private JComboBox<String> cbMedico;
    private JTable table;
    private JButton btConfSelect;
    private Material material;

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
	        getTabela();
	        getBTConfSelect();
	        
	       
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
	        lblDescricao.setBounds(63, 133, 108, 29);
	        getContentPane().add(lblDescricao);
	        return lblDescricao;
	    }
	
	    public JTextField getTxFDescricao() {
	        if (this.txFDescricao == null) {
	            this.txFDescricao = new JTextField();
	            this.txFDescricao.setBounds(62, 172, 453, 149);
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
	            this.comboBoxTipo.setBounds(63, 370, 167, 40);
	            getContentPane().add(this.comboBoxTipo);
	        }
	        return this.comboBoxTipo;
	    }
	
	    public JLabel getLblMedicoResponsavel() {
	        JLabel lblMedicoResponsavel = new JLabel("Médico Responsável:");
	        lblMedicoResponsavel.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblMedicoResponsavel.setBounds(253, 331, 251, 29);
	        getContentPane().add(lblMedicoResponsavel);
	        return lblMedicoResponsavel;
	    }
	    
	    public JComboBox<String> getCBMedico() {
	        if (this.cbMedico == null) {
	            this.cbMedico = new JComboBox<>(ControladorFrame.repositorioMedicos.getNomesMedicos());
	            this.cbMedico.setBounds(252, 370, 263, 40);
	            getContentPane().add(this.cbMedico);
	        }
	        return this.cbMedico;
	    }
	
	    public JLabel getLblMateriaisUsados() {
	        JLabel lblMateriaisUsados = new JLabel("Materiais Usados:");
	        lblMateriaisUsados.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblMateriaisUsados.setBounds(547, 133, 167, 29);
	        getContentPane().add(lblMateriaisUsados);
	        return lblMateriaisUsados;
	    }
	    
	    public JTable getTabela() {
	        if (this.table == null) {
	            DefaultTableModel modeloTabela = new DefaultTableModel(new Object[]{"Material", "Quantidade"}, 0) {
	                @Override
	                public boolean isCellEditable(int row, int column) {
	                    return column == 1; //Só QNT é editavel
	                }
	            };

	            for (Material material : ControladorFrame.repositorioMateriais.getMateriais()) { //Materiais cadastrados
	                modeloTabela.addRow(new Object[]{material.getNome(), 0}); // QNT inicial = 0
	            }

	            this.table = new JTable(modeloTabela);

	            //
	            //ADICIONAR A LOGICA PRA LINHA MUDAR DE COR (atualizCor(); SE QNT < 0
	            //
	            JScrollPane scrollPane = new JScrollPane(this.table);
	            scrollPane.setBounds(547, 172, 684, 298);
	            getContentPane().add(scrollPane);
	        }
	        return this.table;
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
	            this.txFValor.setBounds(63, 459, 167, 40);
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
	    
	    public JButton getBTConfSelect() {
	    	if (this.btConfSelect == null) {
			   this.btConfSelect = new JButton("Confirmar Seleção");
			   this.btConfSelect.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btConfSelect.setBounds(547, 480, 167, 40);
        getContentPane().add(btConfSelect);
	    	}//DO IF
	    	return this.btConfSelect;
	    }
}//da classe
