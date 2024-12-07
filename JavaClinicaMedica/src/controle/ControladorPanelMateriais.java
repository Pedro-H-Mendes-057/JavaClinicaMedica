package controle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import dialogCadastroPanels.DialogCadastrarMaterial;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import visual.PanelMateriais;
import visual.TemplatePanel;
import modelo.Material;
import repositorio.RepositorioMateriais;
/**
 *
 * @author fonfon
 */
public class ControladorPanelMateriais implements ActionListener {
    PanelMateriais panelMateriais;
    DialogCadastrarMaterial  dialogCadastrarMaterial;
    ControladorDialogCadastrarMaterial controladorDialogCadastrarMaterial;
    RepositorioMateriais repositorioMateriais;
    

    public ControladorPanelMateriais(PanelMateriais panelMateriais, RepositorioMateriais repositorioMateriais) {
        this.panelMateriais = panelMateriais;
        this.repositorioMateriais = repositorioMateriais;
        addEventos();
        
    }

    public void addEventos() {
        this.panelMateriais.getBTNNovo().addActionListener(this);
        this.panelMateriais.getBTNExcluir().addActionListener(this);
        this.panelMateriais.addComponentListener(new ComponentListener() {
            @Override
                public void componentShown(ComponentEvent e) {
                    atualizarTabela();
                    System.out.println("teste");
                }
                @Override
                public void componentHidden(ComponentEvent e) {
                   
                }
                @Override
                public void componentResized(ComponentEvent e) {}

                @Override
                public void componentMoved(ComponentEvent e) {}
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
                    break; // Material encontrado, não precisa continuar o loop interno
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
    }
}