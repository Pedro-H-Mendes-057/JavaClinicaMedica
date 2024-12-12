package controle;

import java.awt.Color;


import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JOptionPane;
import dialogCadastroPanels.DialogCadastrarExames;
import modelo.Exame;
import modelo.Medico;
import modelo.Material;
import modelo.Paciente;
import visual.PanelMateriais;
import controle.ControladorPanelMateriais;
import java.awt.Component;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import controle.ControladorPanelMateriais;
import repositorio.RepositorioMateriais;

public class ControladorDialogCadastrarExame implements ActionListener {
    private DialogCadastrarExames dialogCadastrarExames;
    private ControladorPanelMateriais controlePanelMateriais;
    private RepositorioMateriais repositorioMateriais;

    //Construtor 1
    public ControladorDialogCadastrarExame(DialogCadastrarExames dialogCadastrarExames, ControladorPanelMateriais controlePanelMateriais) {
        this.controlePanelMateriais = controlePanelMateriais;
        this.dialogCadastrarExames = dialogCadastrarExames;

        addEventos();
        this.dialogCadastrarExames.setVisible(true);
    }

    //Construtor 2 (pra garantir)
    public ControladorDialogCadastrarExame(DialogCadastrarExames dialogCadastrarExames) {
        this.dialogCadastrarExames = dialogCadastrarExames;

        addEventos();
        this.dialogCadastrarExames.setVisible(true);
    }

    void addEventos() {
        this.dialogCadastrarExames.getBTSalvar().addActionListener(this);
        this.dialogCadastrarExames.getBTCancelar().addActionListener(this);
        this.dialogCadastrarExames.getBTConfSelect().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource() == this.dialogCadastrarExames.getBTCancelar()){
    		this.dialogCadastrarExames.dispose();
        }
        if (e.getSource() == this.dialogCadastrarExames.getBTSalvar()) {           
            try {
              //String materiaisUsar = this.dialogCadastrarExames.getCBMateriaisUsar().getSelectedItem().toString();

            	if (ValidosCamposVazios()) {
                    System.out.println(controlePanelMateriais);
            		 if (controlePanelMateriais != null) {
                         controlePanelMateriais.atualizarTabela();
                         System.out.println("teste");
                     }
                    addExame();
                    JOptionPane.showMessageDialog(this.dialogCadastrarExames,
                            "Exame salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    this.dialogCadastrarExames.dispose();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this.dialogCadastrarExames, 
                        "Preenchimento inválido!");
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this.dialogCadastrarExames, 
                        "Preenchimento inválido!");
            }
        }//Do salvar
        if (e.getSource() == this.dialogCadastrarExames.getBTConfSelect()) {
        	 JTable tabela = dialogCadastrarExames.getTabela();
        	    if (tabela.isEditing()) {
        	        tabela.getCellEditor().stopCellEditing();
        	    }
        	    atualizarCoresLinha();
        }
    } //actionPerformed
    
    private boolean ValidosCamposVazios() {
        int valorParticular = Integer.parseInt(this.dialogCadastrarExames.getTxFValor().getText());
        String nomeExame = dialogCadastrarExames.getTxFNomeExame().getText().trim();
        String descricao = dialogCadastrarExames.getTxArDescricao().getText().trim();
        String tipo = dialogCadastrarExames.getComboBoxTipo().getSelectedItem().toString().trim();            
        String medico = dialogCadastrarExames.getCBMedico().getSelectedItem().toString().trim();            
        /*
        try {	
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(dialogCadastrarExames, "Preencha todos os campos!");
            return false;
        }*/
        
        if (nomeExame.isEmpty() || descricao.isEmpty() || tipo == "") {
            JOptionPane.showMessageDialog(dialogCadastrarExames, "Preencha todos os campos!");
            return false;
        }
        //TRATAMENTO DE VALOR PARTICULAR
        try {
	            if (valorParticular <= 0) {
	            	JOptionPane.showMessageDialog(dialogCadastrarExames, "Valor Invalido!");
	                return false;
            }
        } catch (NumberFormatException e) {
        	JOptionPane.showMessageDialog(dialogCadastrarExames, "Valor deve conter numeros!");
            return false;
        }
        
        /*List<Material> materiaisUsados = getMateriaisUsados();
        if (materiaisUsados.isEmpty()) {
            JOptionPane.showMessageDialog(dialogCadastrarExames,
                    "Insira ao menos 1 material");
            return false;
        }*/
        if (!validarQntMateriais()) { 
            return false;
        }
        return true;
    }//fim do validarcampos

    public boolean validarQntMateriais() {
        JTable tabela = dialogCadastrarExames.getTabela();
        DefaultTableModel modeloTabela = (DefaultTableModel) tabela.getModel();

        boolean algumMaterialUsado = false;

        // Ler a coluna de Qnt
        for (int i = 0; i < modeloTabela.getRowCount(); i++) {
            Object valorQuantidade = modeloTabela.getValueAt(i, 1);

            try {
                int quantidade = Integer.parseInt(valorQuantidade.toString());
                String nomeMaterial = modeloTabela.getValueAt(i, 0).toString(); 
                int qntEstoque = ControladorFrame.repositorioMateriais.getQuantPorNome(nomeMaterial);
                
                if (quantidade > qntEstoque) {
                    JOptionPane.showMessageDialog(dialogCadastrarExames,
                            "Quantidade para o material '" + nomeMaterial + "' excede o estoque disponível (" + qntEstoque + ").",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                if (quantidade > 0) {
                    algumMaterialUsado = true; // Encontrou um material com qnt> 0
                    break;
                }
            } catch (NumberFormatException e) { //impedir letras
                JOptionPane.showMessageDialog(dialogCadastrarExames, 
                        "Preenchimento inválido!", 
                        "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        
        if (!algumMaterialUsado) {
            JOptionPane.showMessageDialog(dialogCadastrarExames,
                    "Insira pelo menos um material!",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true; 
    }
    
    public void atualizarCoresLinha() { ////////////////////
        JTable tabela = this.dialogCadastrarExames.getTabela();
        DefaultTableModel modeloTabela = (DefaultTableModel) tabela.getModel();
        
        tabela.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable tabela, Object qnt, boolean selecionado,
                                                           boolean foco, int linha, int coluna) {
                Component cell = super.getTableCellRendererComponent(tabela, qnt, selecionado, foco, linha, coluna);
                
                if (coluna == 1) {
                    try {
                        int quantidade = Integer.parseInt(qnt.toString());
                        if (quantidade > 0) {
                            cell.setBackground(new Color(100, 149, 237)); 
                            cell.setForeground(Color.WHITE); 
                        } else {
                            throw new NumberFormatException(); 
                        }
                    } catch (NumberFormatException e) {
                        cell.setBackground(Color.WHITE);
                        cell.setForeground(Color.BLACK); 
                    }
                } else {
                    cell.setBackground(Color.WHITE);
                    cell.setForeground(Color.BLACK); 
                }

                return cell;
            }
        }); 

        tabela.repaint();
    } // atualizarCoresLinha
    	            
    private List<Material> getMateriaisUsados() {
        List<Material> materiaisUsados = new ArrayList<>();
        JTable tabela = this.dialogCadastrarExames.getTabela();
        DefaultTableModel modeloTabela = (DefaultTableModel) tabela.getModel();

        for (int i = 0; i < modeloTabela.getRowCount(); i++) {
            Object valorQuantidade = modeloTabela.getValueAt(i, 1);
            Object nomeMaterial = modeloTabela.getValueAt(i, 0);

            try {
                int quantidade = Integer.parseInt(valorQuantidade.toString());
                if (quantidade > 0) {
                    Material material = new Material();
                    material.setNome(nomeMaterial.toString());
                    material.setQuant(quantidade);
                    materiaisUsados.add(material);
                }
            } catch (NumberFormatException e) {
            	
            }
        }

        return materiaisUsados;
    }

    
    public void addExame() {
    	Exame exame = new Exame();
        exame.setNomeExame(this.dialogCadastrarExames.getTxFNomeExame().getText());
        exame.setTipo(this.dialogCadastrarExames.getComboBoxTipo().getSelectedItem().toString());
        exame.setValorParticular(Integer.parseInt(this.dialogCadastrarExames.getTxFValor().getText()));
        exame.setMedico(atribuiMedico());
        
        List<Material> materiaisUsados = getMateriaisUsados();
        //ControladorPanelMateriais controladorMateriais = new ControladorPanelMateriais(new PanelMateriais(), ControladorFrame.repositorioMateriais);
        controlePanelMateriais.atualizarEstoque(materiaisUsados);
        controlePanelMateriais.atualizarTabela();
        exame.setMateriasUsar(materiaisUsados);
        
        exame.setDescricao(this.dialogCadastrarExames.getTxArDescricao().getText());
        ControladorFrame.repositorioExames.addExame(exame);
        
        //ControladorFrame.atualizarTabelaEstoque(materiaisUsar); /////////////////////////
    }


	private Medico atribuiMedico() {
		String medicoSelecionado = (String) this.dialogCadastrarExames.getCBMedico().getSelectedItem();

	    for (int i = 0; i < ControladorFrame.repositorioMedicos.getMedicos().size(); i++) { // Procura o indice na lista de medicos
	        if (ControladorFrame.repositorioMedicos.getMedicos().get(i).getNome().equals(medicoSelecionado)) {
	            return ControladorFrame.repositorioMedicos.getMedicos().get(i);
	        }
	    }
	    return null;
	}
    

}