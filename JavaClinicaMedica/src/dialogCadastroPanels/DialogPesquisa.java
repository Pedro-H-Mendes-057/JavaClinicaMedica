package dialogCadastroPanels;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.util.List;

public class DialogPesquisa extends JDialog {
	    JTable pesquisa;
	    JScrollPane jscrollPane;
	    
	    public DialogPesquisa(Container container) {
	    	super((JFrame) container, "Pesquisar", true);    
	        this.setSize(1000, 650);
	        this.setResizable(false);
	        this.setLocationRelativeTo(container);      
	        this.setLayout(new GridBagLayout());       
	        GridBagConstraints constraints = new GridBagConstraints();
	        constraints.weightx=1;
	        constraints.weighty=1;
	        constraints.fill=GridBagConstraints.HORIZONTAL;
	        constraints.insets = new Insets(10,5,10,5); // espaçamentos entre as células
	        
	        constraints.gridx=0; // coluna 0
	        constraints.gridy=0; // linha 0
	        this.add(getJScrollPane(), constraints);        
	        
	        pack();
	    }
	    
	     public JScrollPane getJScrollPane() {
	        if (this.jscrollPane == null) {
	            this.jscrollPane = new JScrollPane(getTable());
	        }
	        return this.jscrollPane;
	    }

	    public JTable getTable() {
	        if (this.pesquisa == null) {
	            String[] colunas = {"NOME"};
	            DefaultTableModel model = new DefaultTableModel(0, colunas.length);
	            model.setColumnIdentifiers(colunas);
	            this.pesquisa = new JTable(model) {
	                @Override 
	                public boolean isCellEditable(int row, int column) {
	                    return false;
	                }
	            };            
	        }
	        return this.pesquisa;
	    }
	    
	    /**
	     * Atualiza a tabela com o nome digitado
	     *
	     * @param nomes Lista de nomes a serem exibidos na tabela
	     */
	    public void atualizarTabela(List<String> nomes) {
	        DefaultTableModel model = (DefaultTableModel) this.pesquisa.getModel();
	        model.setRowCount(0);
	        for (int i = 0; i < nomes.size(); i++) {
	            model.addRow(new Object[]{nomes.get(i)});
	        }
	    }
}
