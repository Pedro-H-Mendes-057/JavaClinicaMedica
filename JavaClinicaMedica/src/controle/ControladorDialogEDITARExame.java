package controle;

import java.awt.Color;



import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JOptionPane;
import dialogCadastroPanels.DialogEDITARExames;
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

public class ControladorDialogEDITARExame implements ActionListener {
    private DialogEDITARExames dialogEditarExames;
    private Exame exame;
    private ControladorPanelMateriais controlePanelMateriais;

    public ControladorDialogEDITARExame(DialogEDITARExames dialogEditarExames, Exame exameSelecionado) {
        this.dialogEditarExames = dialogEditarExames;
        this.exame = exameSelecionado;

        preencherCampos(exameSelecionado);
        addEventos(); 
        this.dialogEditarExames.setVisible(true);
    }

    //Construtor alternativo
    public ControladorDialogEDITARExame(DialogEDITARExames dialogEditarExames, ControladorPanelMateriais controlePanelMateriais) {
        this.dialogEditarExames = dialogEditarExames;
        this.controlePanelMateriais = controlePanelMateriais;

        addEventos();
        this.dialogEditarExames.setVisible(true);
    }
    
    private void preencherCampos(Exame exameSelecionado) {
    	if (exameSelecionado != null) {
            this.dialogEditarExames.getTxFNomeExame().setText(exameSelecionado.getNomeExame());
            this.dialogEditarExames.getTxArDescricao().setText(exameSelecionado.getDescricao());
            this.dialogEditarExames.getComboBoxTipo().setSelectedItem(exameSelecionado.getTipo());
            this.dialogEditarExames.getCBMedico().setSelectedItem(exameSelecionado.getMedico().getNome());
            this.dialogEditarExames.getTxFValor().setText(String.valueOf(exameSelecionado.getValorParticular()));
        }
    }
    
	void addEventos() {
        this.dialogEditarExames.getBTSalvar().addActionListener(this);
        this.dialogEditarExames.getBTCancelar().addActionListener(this);
        this.dialogEditarExames.getBTConfSelect().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource() == this.dialogEditarExames.getBTCancelar()){
    		this.dialogEditarExames.dispose();
        }
        if (e.getSource() == this.dialogEditarExames.getBTSalvar()) {           
            try {
              //String materiaisUsar = this.dialogCadastrarExames.getCBMateriaisUsar().getSelectedItem().toString();

            	if (ValidosCamposVazios()) {
                    System.out.println(controlePanelMateriais);
            		 if (controlePanelMateriais != null) {
                         controlePanelMateriais.atualizarTabela();
                         System.out.println("teste");
                     }
                    atualizarExame();
                    JOptionPane.showMessageDialog(this.dialogEditarExames,
                            "Exame atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    this.dialogEditarExames.dispose();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this.dialogEditarExames, 
                        "Preenchimento inválido!");
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this.dialogEditarExames, 
                        "Preenchimento inválido!");
            }
        }//Do salvar
        if (e.getSource() == this.dialogEditarExames.getBTConfSelect()) {
            atualizarCoresLinha();
        }
    } //actionPerformed
    
    private boolean ValidosCamposVazios() {
        int valorParticular = Integer.parseInt(this.dialogEditarExames.getTxFValor().getText());
        String nomeExame = dialogEditarExames.getTxFNomeExame().getText().trim();
        String descricao = dialogEditarExames.getTxArDescricao().getText().trim();

        try {            
            String tipo = dialogEditarExames.getComboBoxTipo().getSelectedItem().toString().trim();            
            String medico = dialogEditarExames.getCBMedico().getSelectedItem().toString().trim();            
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(dialogEditarExames, "Preencha todos os campos!");
            return false;
        }
        
        if (nomeExame.isEmpty() || descricao.isEmpty()) {
            JOptionPane.showMessageDialog(dialogEditarExames, "Preencha todos os campos!");
            return false;
        }
        //TRATAMENTO DE VALOR PARTICULAR
        try {
	            if (valorParticular <= 0) {
	            	JOptionPane.showMessageDialog(dialogEditarExames, "Valor Invalido!");
	                return false;
            }
        } catch (NumberFormatException e) {
        	JOptionPane.showMessageDialog(dialogEditarExames, "Valor deve conter numeros!");
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
        JTable tabela = dialogEditarExames.getTabela();
        DefaultTableModel modeloTabela = (DefaultTableModel) tabela.getModel();

        boolean algumMaterialUsado = false;

        // Ler a coluna de Qnt
        for (int i = 0; i < modeloTabela.getRowCount(); i++) {
            Object valorQuantidade = modeloTabela.getValueAt(i, 1);

            try {
                int quantidade = Integer.parseInt(valorQuantidade.toString());
                if (quantidade > 0) {
                    algumMaterialUsado = true; // Encontrou um material com qnt> 0
                    break;
                }
            } catch (NumberFormatException e) { //impedir letras
                JOptionPane.showMessageDialog(dialogEditarExames, 
                        "Preenchimento inválido!", 
                        "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        
        if (!algumMaterialUsado) {
            JOptionPane.showMessageDialog(dialogEditarExames,
                    "Insira pelo menos um material!",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true; 
    }
    
    public void atualizarCoresLinha() { ////////////////////
        JTable tabela = this.dialogEditarExames.getTabela();
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
        JTable tabela = this.dialogEditarExames.getTabela();
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

    
    public void atualizarExame() {
    	exame.setValorParticular(Integer.parseInt(dialogEditarExames.getTxFValor().getText()));
        exame.setDescricao(dialogEditarExames.getTxArDescricao().getText());
        exame.setMedico(atribuiMedico());
        
        // Atualizar os materiais usados
        List<Material> materiaisUsados = getMateriaisUsados();
        exame.setMateriasUsar(materiaisUsados);

        ControladorFrame.repositorioExames.atualizarExame(exame);
    	
        //ControladorPanelMateriais controladorMateriais = new ControladorPanelMateriais(new PanelMateriais(), ControladorFrame.repositorioMateriais);
        //controlePanelMateriais.atualizarEstoque(materiaisUsados);
        //controlePanelMateriais.atualizarTabela();
        //ControladorFrame.atualizarTabelaEstoque(materiaisUsar); /////////////////////////
        

    }


	private Medico atribuiMedico() {
		String medicoSelecionado = (String) this.dialogEditarExames.getCBMedico().getSelectedItem();

	    for (int i = 0; i < ControladorFrame.repositorioMedicos.getMedicos().size(); i++) { // Procura o indice na lista de medicos
	        if (ControladorFrame.repositorioMedicos.getMedicos().get(i).getNome().equals(medicoSelecionado)) {
	            return ControladorFrame.repositorioMedicos.getMedicos().get(i);
	        }
	    }
	    return null;
	}
    

}