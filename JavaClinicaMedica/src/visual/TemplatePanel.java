package visual;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TemplatePanel extends JPanel {
	
    JLabel labelPesquisar;
    JTextField txFPesquisar;
    JButton btnPesquisar;
    JTable table;
    JButton btnNovo;
    JButton btnEditar;
    JButton btnExcluir;
    JPanel panelBotoes;
    JPanel panelPesquisar;
    JScrollPane jscrollPane;

    public TemplatePanel() {
        setLayout(new GridBagLayout());

        GridBagConstraints gbcPesquisar = new GridBagConstraints();
        gbcPesquisar.anchor = GridBagConstraints.SOUTH;
        gbcPesquisar.weighty = 0.3;
        gbcPesquisar.insets = new Insets(0, 100, 20, 100);
        gbcPesquisar.gridx = 0;
        gbcPesquisar.gridy = 0;
        gbcPesquisar.fill = GridBagConstraints.HORIZONTAL;
        this.add(getPanelPesquisar(), gbcPesquisar);

        GridBagConstraints gbcTabela = new GridBagConstraints();
        gbcTabela.weightx = 1.0;
        gbcTabela.insets = new Insets(0, 100, 0, 100);
        gbcTabela.gridx = 0;
        gbcTabela.gridy = 1;
        gbcTabela.fill = GridBagConstraints.BOTH;
        gbcTabela.weighty = 0.3;
        this.add(getJScrollPane(), gbcTabela);

        GridBagConstraints gbcBotoes = new GridBagConstraints();
        gbcBotoes.weighty = 1.2;
        gbcBotoes.insets = new Insets(15, 100, 20, 100);
        gbcBotoes.gridx = 0;
        gbcBotoes.gridy = 2;
	gbcBotoes.anchor = GridBagConstraints.NORTHWEST;
        this.add(getPanelBotoes(), gbcBotoes);
    }

    public JPanel getPanelPesquisar() {
        if (this.panelPesquisar == null) {
            this.panelPesquisar = new JPanel(new GridBagLayout());
            GridBagConstraints c1 = new GridBagConstraints();
            c1.insets = new Insets(0, 10, 0, 0);
            c1.anchor = GridBagConstraints.WEST;
            c1.gridx = 0;
            c1.gridy = 0;
            c1.weighty = 0.6;
            this.panelPesquisar.add(getLabelPesquisar(), c1);

            GridBagConstraints c2 = new GridBagConstraints();
            c2.weighty = 1.0;
            c2.gridx = 0;
            c2.gridy = 1;
            c2.weightx = 1.0;
            c2.fill = GridBagConstraints.BOTH;
            this.panelPesquisar.add(getTxFPesquisar(), c2);

            GridBagConstraints c3 = new GridBagConstraints();
            c3.gridx = 1;
            c3.gridy = 1;
            c3.fill = GridBagConstraints.BOTH;
            this.panelPesquisar.add(getBTNPesquisar(), c3);
        }
        return this.panelPesquisar;
    }

    public JPanel getPanelBotoes() {
        if (this.panelBotoes == null) {
            this.panelBotoes = new JPanel(new GridBagLayout());

            GridBagConstraints c1 = new GridBagConstraints();
            c1.insets = new Insets(0, 0, 0, 10);
            c1.gridx = 0;
            c1.ipady = 10;
            c1.anchor = GridBagConstraints.LINE_START;
            this.panelBotoes.add(getBTNNovo(), c1);

            GridBagConstraints c2 = new GridBagConstraints();
            c2.insets = new Insets(0, 0, 0, 10);
            c2.gridx = 1; 
            c2.ipady = 10;
            c2.anchor = GridBagConstraints.LINE_START;
            this.panelBotoes.add(getBTNEditar(), c2);

            GridBagConstraints c3 = new GridBagConstraints();
            c3.gridx = 2;
            c3.ipady = 10;
            c3.anchor = GridBagConstraints.LINE_START;
            this.panelBotoes.add(getBTNExcluir(), c3);
        }
        return this.panelBotoes;
    }


    public JScrollPane getJScrollPane() {
        if (this.jscrollPane == null) {
            this.jscrollPane = new JScrollPane(getTable());
        }
        return this.jscrollPane;
    }

    public JTable getTable() {
        if (this.table == null) {
            String[] colunas = {"NOME", "QTD ESTOQUE", "QTD MÍNIMA", "FORNECEDOR", "PREÇO"};
            DefaultTableModel model = new DefaultTableModel(0, colunas.length);
            model.setColumnIdentifiers(colunas);
            this.table = new JTable(model);
            this.table.setDefaultEditor(Object.class, null);
        }
        return this.table;
    }
    
    public void setTableColunas(String[] colunas) {
        DefaultTableModel model = (DefaultTableModel) getTable().getModel();
        model.setColumnIdentifiers(colunas);
    }

    public JLabel getLabelPesquisar() {
        if (this.labelPesquisar == null) {
            this.labelPesquisar = new JLabel("Pesquisar por material:");
        }
        return this.labelPesquisar;
    }

    public JTextField getTxFPesquisar() {
        if (this.txFPesquisar == null) {
            this.txFPesquisar = new JTextField();
        }
        return this.txFPesquisar;
    }

    public JButton getBTNPesquisar() {
        if (this.btnPesquisar == null) {
            this.btnPesquisar = new JButton("PESQUISAR");
        }
        return this.btnPesquisar;
    }

    public JButton getBTNNovo() {
        if (this.btnNovo == null) {
            this.btnNovo = new JButton("NOVO");
            this.btnNovo.setBackground(new Color(50, 205, 101));
            this.btnNovo.setForeground(Color.WHITE);
        }
        return this.btnNovo;
    }

    public JButton getBTNEditar() {
        if (this.btnEditar == null) {
            this.btnEditar = new JButton("EDITAR");
            this.btnEditar.setBackground(new Color(100, 149, 237));
            this.btnEditar.setForeground(Color.WHITE);
        }
        return this.btnEditar;
    }

    public JButton getBTNExcluir() {
        if (this.btnExcluir == null) {
            this.btnExcluir = new JButton("EXCLUIR");
            this.btnExcluir.setBackground(new Color(244, 0, 9));
            this.btnExcluir.setForeground(Color.WHITE);
        }
        return this.btnExcluir;
    }
    
      public boolean getMessageDialogExcluirItem(JPanel panel) {
        	int resposta = JOptionPane.showConfirmDialog(panel, "Tem certeza que deseja excluir este item?");
        
        	if (resposta == JOptionPane.YES_OPTION){  
        		return true;  
        	} else {
        		return false;
        	}
        }
}
