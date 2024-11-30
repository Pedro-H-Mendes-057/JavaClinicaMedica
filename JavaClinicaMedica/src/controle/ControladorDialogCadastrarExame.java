package controle;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import dialogCadastroPanels.DialogCadastrarExames;
import modelo.Exame;
import modelo.Medico;
import modelo.Paciente;
import java.awt.Component;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

public class ControladorDialogCadastrarExame implements ActionListener {
    DialogCadastrarExames dialogCadastrarExames;
    //private Exame exame;

    public ControladorDialogCadastrarExame(DialogCadastrarExames dialogCadastrarExames) {
        this.dialogCadastrarExames = dialogCadastrarExames;        
        addEventos();
        this.dialogCadastrarExames.setVisible(true);
    }

    void addEventos() {
        this.dialogCadastrarExames.getBTSalvar().addActionListener(this);
    	this.dialogCadastrarExames.getBTCancelar().addActionListener(this);
    	this.dialogCadastrarExames.getBTConfSelect().addActionListener(this);
    }//do AddEventos
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource() == this.dialogCadastrarExames.getBTCancelar()){
    		this.dialogCadastrarExames.dispose();
        }
        if (e.getSource() == this.dialogCadastrarExames.getBTSalvar()) {           
            try {
              //String materiaisUsar = this.dialogCadastrarExames.getCBMateriaisUsar().getSelectedItem().toString();

            	if (ValidosCamposVazios()) {
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
            atualizarCoresLinha();
        }
    } //actionPerformed
    
    private boolean ValidosCamposVazios() {
        int valorParticular = Integer.parseInt(this.dialogCadastrarExames.getTxFValor().getText());
        String nomeExame = dialogCadastrarExames.getTxFNomeExame().getText().trim();
        String descricao = dialogCadastrarExames.getTxFDescricao().getText().trim();
        try {            
            String tipo = dialogCadastrarExames.getComboBoxTipo().getSelectedItem().toString().trim();            
            String medico = dialogCadastrarExames.getCBMedico().getSelectedItem().toString().trim();            
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(dialogCadastrarExames, "Preencha todos os campos!");
            return false;
        }
   
    //String materiaisUsar = dialogCadastrarExames.getCBMateriaisUsar().getSelectedItem().toString().trim();
        
        		//Depois adicione materiaisUsados.isEmpty()
        if (nomeExame.isEmpty() || descricao.isEmpty()) {
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
        return true;
    }//fim do validarcampos

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
    	            
    
    
    public void addExame() {
    	Exame exame = new Exame();
        exame.setNomeExame(this.dialogCadastrarExames.getTxFNomeExame().getText());
        exame.setTipo(this.dialogCadastrarExames.getComboBoxTipo().getSelectedItem().toString());
        exame.setValorParticular(Integer.parseInt(this.dialogCadastrarExames.getTxFValor().getText()));
        exame.setMedico(atribuiMedico());
        //exame.setMateriasUsar(null);
        exame.setDescricao(this.dialogCadastrarExames.getTxFDescricao().getText());
        //this.exame.setMedico(this.dialogCadastrarExames.getCBMedico().getSelectedItem().toString());
        // this.exame.setMateriaisUsar(this.dialogCadastrarExames.getComboBoxMateriaisUsar().getSelectedItem().toString());

        ControladorFrame.repositorioExames.addExame(exame);
        //ControladorFrame.atualizarTabelas(); /////////////////////////
    }



	private Medico atribuiMedico() {
		for(int i = 0; i<ControladorFrame.repositorioExames.getExames().size();i++) {
			if(ControladorFrame.repositorioMedicos.getMedicos().get(i).getNome() == 
					this.dialogCadastrarExames.getCBMedico().getSelectedItem()) {
				return ControladorFrame.repositorioMedicos.getMedicos().get(i);
			}
		}
		return null;
	}
    

}
