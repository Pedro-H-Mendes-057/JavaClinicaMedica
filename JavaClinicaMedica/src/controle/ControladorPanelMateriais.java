package controle;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import dialogCadastroPanels.DialogCadastrarMaterial;
import dialogCadastroPanels.DialogEDITARMaterial;
import exportacoes.ExportarDados;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import visual.PanelMateriais;
import visual.TemplatePanel;
import modelo.Material;
import repositorio.RepositorioMateriais;

public class ControladorPanelMateriais implements ActionListener {
    PanelMateriais panelMateriais;
    DialogCadastrarMaterial  dialogCadastrarMaterial;
    ControladorDialogCadastrarMaterial controladorDialogCadastrarMaterial;
    RepositorioMateriais repositorioMateriais;
    ControladorDialogEDITARMaterial controladorDialogEditarMaterial;
    DialogEDITARMaterial dialogEditarMaterial;
    

    public ControladorPanelMateriais(PanelMateriais panelMateriais, RepositorioMateriais repositorioMateriais) {
        this.panelMateriais = panelMateriais;
        this.repositorioMateriais = repositorioMateriais;
        try {
            ExportarDados.recuperarMateriais();
        } catch (IOException ex) {
           System.out.println("Falha na criação do arquivo Materiais.txt");
        }
        atualizarTabela();
        addEventos();
        
    }

    public void addEventos() {
        this.panelMateriais.getBTNNovo().addActionListener(this);
        this.panelMateriais.getBTNExcluir().addActionListener(this);       
        this.panelMateriais.getBTNEditar().addActionListener(this);
        
        this.panelMateriais.getTable().getSelectionModel().addListSelectionListener(event -> {
            boolean itemSelecionado = this.panelMateriais.getTable().getSelectedRow() != -1;
            this.panelMateriais.getBTNEditar().setEnabled(itemSelecionado);
            
            this.panelMateriais.getBTNPesquisar().addActionListener(this);
        });
        
        this.panelMateriais.getTable().getSelectionModel().addListSelectionListener(event -> {
            boolean itemSelecionado = this.panelMateriais.getTable().getSelectedRow() != -1;
            this.panelMateriais.getBTNExcluir().setEnabled(itemSelecionado);
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.panelMateriais.getBTNNovo()) {
           this.dialogCadastrarMaterial = new DialogCadastrarMaterial(ControladorFrame.frame);
           this.controladorDialogCadastrarMaterial = new ControladorDialogCadastrarMaterial(this.dialogCadastrarMaterial);
           atualizarTabela();

        }
        
        if (e.getSource() == this.panelMateriais.getBTNExcluir()) {
            if(this.panelMateriais.getMessageDialogExcluirItem(panelMateriais) &&
            		(this.panelMateriais.getTable().getSelectedRowCount()) == 1) {
            	ControladorFrame.repositorioMateriais.getMateriais().remove(this.panelMateriais.getTable().getSelectedRow());
            	atualizarTabela();
            }
        }//if
        if (e.getSource() == this.panelMateriais.getBTNEditar()) {
            int indexLinhaItem = this.panelMateriais.getTable().getSelectedRow();
            if (indexLinhaItem != -1) {
                Material materialSeleciona = ControladorFrame.repositorioMateriais.getMateriais().get(indexLinhaItem);
                this.dialogEditarMaterial = new DialogEDITARMaterial(ControladorFrame.frame, materialSeleciona);
                this.controladorDialogEditarMaterial = new ControladorDialogEDITARMaterial(this.dialogEditarMaterial, materialSeleciona);
                atualizarTabela();
            }
        }
        if (e.getSource() == this.panelMateriais.getBTNPesquisar()) {
        	panelMateriais.getTxFPesquisar().getInputContext().endComposition();
            buscarNome();
        }
        
    }//actionPerformed
    
    void buscarNome() {
        panelMateriais.getTxFPesquisar().getInputContext().endComposition();

        String termoBusca = panelMateriais.getTxFPesquisar().getText().trim().toLowerCase();

        if (termoBusca.isEmpty()) {
            atualizarTabela();
            return;
        }

        DefaultTableModel tabela = (DefaultTableModel) panelMateriais.getTable().getModel();
        tabela.setRowCount(0);

        boolean encontrou = false;

        File arquivo = new File("src/exportacoes/Materiais.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");

                //Validação
                if (dados.length >= 5) {
                	 
                	String nome = dados[0].trim().toLowerCase();
                	
                	String qntEstoque;
                	if (dados[1].trim().isEmpty()) {
                	    qntEstoque = "0";}
                	else {
                	    qntEstoque = dados[1].trim();}

                	String qntMinima;
                	if (dados[2].trim().isEmpty()) {
                	    qntMinima = "0";}
                	else {
                	    qntMinima = dados[2].trim();}

                	String fornecedor;
                	if (dados[3].trim().isEmpty()) {
                	    fornecedor = "Desconhecido";} 
                	else {
                	    fornecedor = dados[3].trim();}

                	String preco;
                	if (dados[4].trim().isEmpty()) {
                	    preco = "0.0";}
                	else {
                	    preco = dados[4].trim();}
                	
                		/////////////////////
                    if (nome.contains(termoBusca)) {
                        encontrou = true;

                        tabela.addRow(new Object[]{
                            dados[0],           		 //Nome
                            Integer.parseInt(qntEstoque),//Quant estoque
                            Integer.parseInt(qntMinima), //Quant mínima
                            fornecedor,         		 //Fornecedor
                            Double.parseDouble(preco)    //Preço
                        });
                    }
                } else {
                    System.out.println("Linha mal formatada " + linha);
                }
            }

            if (!encontrou) {
                JOptionPane.showMessageDialog(null, "Nenhum material encontrado.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao processar os dados: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar o arquivo: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    public void atualizarEstoque(List<Material> materiaisUsados) { //cálculos 
        for (int i = 0; i < materiaisUsados.size(); i++) {
            Material materialUsado = materiaisUsados.get(i);

            //Procurar material
            for (int j = 0; j < ControladorFrame.repositorioMateriais.getMateriais().size(); j++) {
                Material estoqueMaterial = ControladorFrame.repositorioMateriais.getMateriais().get(j);

                if (estoqueMaterial.getNome().equals(materialUsado.getNome())) {
               // Subtrair a qnt usada
                    int novaQuantidade = estoqueMaterial.getQuant() - materialUsado.getQuant();
               //Impedir dar negativo
                    if (novaQuantidade < 0) {
                        JOptionPane.showMessageDialog(panelMateriais,
                                "Estoque baixo de " + materialUsado.getNome(),
                                "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    estoqueMaterial.setQuant(novaQuantidade);
                    break; //Material encontrado, prar n continuar o loop interno
                }
            }
        }
        atualizarTabela();
    }


    public void atualizarTabela() {
        DefaultTableModel model = (DefaultTableModel) this.panelMateriais.getTable().getModel(); 
        
        //System.out.println("size = " + ControladorFrame.repositorioMateriais.getMateriais().size());
        model.setRowCount(0); // apaga todos os itens da tabela para que ela seja refeita
        
        for (int i = 0; i < ControladorFrame.repositorioMateriais.getMateriais().size(); i++) {
            //System.out.println("OI " + i);
            model.addRow(new Object [] {
                ControladorFrame.repositorioMateriais.getMateriais().get(i).getNome(),
                String.valueOf(ControladorFrame.repositorioMateriais.getMateriais().get(i).getQuant()),
                String.valueOf(ControladorFrame.repositorioMateriais.getMateriais().get(i).getQuantMin()),
                ControladorFrame.repositorioMateriais.getMateriais().get(i).getFornecedor(),
                ControladorFrame.repositorioMateriais.getMateriais().get(i).getPreco(),
            });
        } 
        atualizarCoresLinha();
    }
    public void atualizarCoresLinha() {
        JTable tabela = this.panelMateriais.getTable();

        tabela.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
          
            public Component getTableCellRendererComponent(JTable tabela, Object value, boolean isSelected,
                                                           boolean hasFocus, int linha, int coluna) {
            	
                Component cell = super.getTableCellRendererComponent(tabela, value, isSelected, hasFocus, linha, coluna);
                
                DefaultTableModel model = (DefaultTableModel) tabela.getModel();
                int qntEstoque = Integer.parseInt(model.getValueAt(linha, 1).toString());
                int qutMin = Integer.parseInt(model.getValueAt(linha, 2).toString());

                if (qntEstoque < qutMin) {
                    cell.setBackground(Color.WHITE);
                    cell.setForeground(Color.RED);
                } else {
                    //Reseta as cores 
                    cell.setBackground(Color.WHITE);
                    cell.setForeground(Color.BLACK);
                }

                return cell;
            }
        });

        tabela.repaint();
    }
    
}
