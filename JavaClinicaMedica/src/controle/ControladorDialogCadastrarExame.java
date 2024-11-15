package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import dialogCadastroPanels.DialogCadastrarExames;
import modelo.Exame;
import modelo.Paciente;

public class ControladorDialogCadastrarExame implements ActionListener {
    DialogCadastrarExames dialogCadastrarExames;
    private Exame exame;

    public ControladorDialogCadastrarExame(DialogCadastrarExames dialogCadastrarExames) {
        this.dialogCadastrarExames = dialogCadastrarExames;
        
        
        addEventos();
        this.dialogCadastrarExames.setVisible(true);
    }

    void addEventos() {
        this.dialogCadastrarExames.getBTSalvar().addActionListener(this);
    	this.dialogCadastrarExames.getBTCancelar().addActionListener(this);
    }//do AddEventos
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource() == this.dialogCadastrarExames.getBTCancelar()){
    		this.dialogCadastrarExames.dispose();
    		};
        if (e.getSource() == this.dialogCadastrarExames.getBTSalvar()) {
            try {
            	//Nome, descrição, tipo, valor, medico, materiais usados
                String nomeExame = this.dialogCadastrarExames.getTxFNomeExame().getText();
                String descricao = this.dialogCadastrarExames.getTxFDescricao().getText();
                String tipo = this.dialogCadastrarExames.getComboBoxTipo().getSelectedItem().toString();
                int valorParticular = Integer.parseInt(this.dialogCadastrarExames.getTxFValor().getText());
                String medico = this.dialogCadastrarExames.getCBMedico().getSelectedItem().toString();
              //String materiaisUsar = this.dialogCadastrarExames.getCBMateriaisUsar().getSelectedItem().toString();

                if (ValidosCamposVazios() == false) {
                    return;
                } else {
                    JOptionPane.showMessageDialog(this.dialogCadastrarExames,
                            "Exame salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    addExame();
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
    } //actionPerformed
    
    private boolean ValidosCamposVazios() {
    String nomeExame = dialogCadastrarExames.getTxFNomeExame().getText().trim();
    String tipo = dialogCadastrarExames.getComboBoxTipo().getSelectedItem().toString().trim();
    String descricao = dialogCadastrarExames.getTxFDescricao().getText().trim();
    int valorParticular = Integer.parseInt(this.dialogCadastrarExames.getTxFValor().getText());
    String medico = dialogCadastrarExames.getCBMedico().getSelectedItem().toString().trim();
    //String materiaisUsar = dialogCadastrarExames.getCBMateriaisUsar().getSelectedItem().toString().trim();
        
        		//Depois adicione materiaisUsados.isEmpty()
        if (nomeExame.isEmpty() || descricao.isEmpty() || tipo.isEmpty() || medico.isEmpty()) {
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

    public void addExame() {
    	this.exame = new Exame();
        this.exame.setNomeExame(this.dialogCadastrarExames.getTxFNomeExame().getText());
        this.exame.setTipo(this.dialogCadastrarExames.getComboBoxTipo().getSelectedItem().toString());
        this.exame.setValorParticular(Integer.parseInt(this.dialogCadastrarExames.getTxFValor().getText()));
        this.exame.setMedico(this.dialogCadastrarExames.getCBMedico().getSelectedItem().toString());
        // this.exame.setMateriaisUsar(this.dialogCadastrarExames.getComboBoxMateriaisUsar().getSelectedItem().toString());

        ControladorFrame.repositorioExames.addExame(this.exame);
    }
    

}
