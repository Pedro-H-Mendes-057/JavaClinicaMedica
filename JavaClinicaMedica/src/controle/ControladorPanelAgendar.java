/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import dialogCadastroPanels.DialogBuscarMedico;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import visual.PanelAgendar;
import dialogCadastroPanels.DialogCadastrarConsulta;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import modelo.Medico;

/**
 *
 * @author fonfon
 */
public class ControladorPanelAgendar implements ActionListener {
    PanelAgendar panelAgendar;
    DialogCadastrarConsulta dialogCadastrarConsulta;
    DialogBuscarMedico dialogBuscarMedico;
    ControladorDialogBuscarMedico controladorDialogBuscarMedico;
    private int chaveMedico;
    
    public ControladorPanelAgendar(PanelAgendar panelAgendar) {
        this.panelAgendar = panelAgendar;
        chaveMedico = -1; 
        addEventos();
    }
    
    public void addEventos() {
        this.panelAgendar.getBTNNovaConsulta().addActionListener(this);
        this.panelAgendar.getBTNNovoExame().addActionListener(this);
        this.panelAgendar.getBTNBuscar().addActionListener(this);
        this.panelAgendar.getBTNVoltar().addActionListener(this);
        this.panelAgendar.getBTNAvancar().addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() ==  this.panelAgendar.getBTNNovaConsulta()) {            
            dialogCadastrarConsulta = new DialogCadastrarConsulta(ControladorFrame.frame);
        } else if (e.getSource() == this.panelAgendar.getBTNNovoExame()) {
            
        } else if (e.getSource() ==  this.panelAgendar.getBTNBuscar()) {
            limparAgenda();
            dialogBuscarMedico = new DialogBuscarMedico(ControladorFrame.frame);
            controladorDialogBuscarMedico = new ControladorDialogBuscarMedico(dialogBuscarMedico);
            chaveMedico = controladorDialogBuscarMedico.getChaveMedico();
            atualizarAgenda(chaveMedico);
        } else if (e.getSource() == this.panelAgendar.getBTNVoltar()) {
            this.panelAgendar.mudarSemana(-1);
            limparAgenda();
            atualizarAgenda(chaveMedico);
        } else if (e.getSource() == this.panelAgendar.getBTNAvancar()) {
            this.panelAgendar.mudarSemana(1);
            limparAgenda();
            atualizarAgenda(chaveMedico);
        }
    }
    
    // depois que o usuario escolhe um medico, o nome do medico sera atualizado aqui
    void atualizarAgenda(int chaveMedico) {
        if (chaveMedico >= 0) {
            Medico medico = ControladorFrame.repositorioMedicos.getMedicos().get(chaveMedico);
            this.panelAgendar.getTxFPesquisar().setText(medico.getNome());
            for (int col = 1; col < 6; col++) {
                for (int row = 0; row < 11; row++) {
                    if (medico.getHorasAtend()[row][col - 1] == 1) {
                        this.panelAgendar.getTableSemana().getModel().setValueAt("DISPONÍVEL", row, col);   
                       
                    }
                }
            }
        }
        for (int i = 1; i < 6; i++) {
            this.panelAgendar.getTableSemana().getColumnModel().getColumn(i).setCellRenderer(new Renderer());
        }
                
    }

    void limparAgenda() {
        for (int col = 1; col < 6; col++) {
                for (int row = 0; row < 11; row++) {                    
                        this.panelAgendar.getTableSemana().getModel().setValueAt("", row, col);                        
                }
           }       
         for (int i = 1; i < 6; i++) {
            this.panelAgendar.getTableSemana().getColumnModel().getColumn(i).setCellRenderer(new Renderer());
        }
    }

    
}

 class Renderer extends JLabel implements TableCellRenderer
{

    public Renderer()
    {
        super.setOpaque(true);
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, 
        boolean hasFocus, int row, int column)
    {
       
        String texto = (String) value;
        
        if (texto != null) {
            if (texto.equals("DISPONÍVEL")) {
                super.setBackground(new Color(50, 205, 101));
                super.setText("DISPONÍVEL");
                super.setForeground(new Color(255, 255, 255));
            } else {
                super.setBackground(Color.WHITE);
                super.setText("");
            }
        }

        
        return this;        
    }
    
}



/*


import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
public class JTableColumnColorTest extends JFrame {
   private JTable table;
   private TableColumn tColumn;
   public JTableColumnColorTest() {
      setTitle("JTableColumnColor Test");
      table = new JTable(10, 5);
      tColumn = table.getColumnModel().getColumn(2);
      tColumn.setCellRenderer(new ColorRenderer(Color.lightGray, Color.red));
      add(new JScrollPane(table), BorderLayout.CENTER);
      setSize(400, 300);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      setVisible(true);
   }
   public static void main(String [] args) {
      new JTableColumnColorTest();
   }
}
// Customize the code to set the background and foreground color for each column of a JTable
class ColorRenderer extends DefaultTableCellRenderer {
   Color backgroundColor, foregroundColor;
   public ColorRenderer(Color backgroundColor, Color foregroundColor) {
      super();
      this.backgroundColor = backgroundColor;
      this.foregroundColor = foregroundColor;
   }
   public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,   boolean hasFocus, int row, int column) {
      Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
      cell.setBackground(backgroundColor);
      cell.setForeground(foregroundColor);
      return cell;
   }
}




*/
