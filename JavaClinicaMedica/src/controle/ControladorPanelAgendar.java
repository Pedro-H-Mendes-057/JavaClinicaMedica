/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import dialogCadastroPanels.DialogBuscar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import visual.PanelAgendar;
import dialogCadastroPanels.DialogCadastrarConsulta;
import dialogCadastroPanels.DialogEditarConsulta;
import exportacoes.ExportarDados;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    DialogEditarConsulta  dialogEditarConsulta;
    DialogBuscar dialogBuscarMedico;
    ControladorDialogBuscarMedico controladorDialogBuscarMedico;
    ControladorDialogCadastrarConsulta controladorDialogCadastrarConsulta;
    private int chaveMedico;
    private String [][] simularTabela;
    
    public ControladorPanelAgendar(PanelAgendar panelAgendar) {
        this.panelAgendar = panelAgendar;
        this.panelAgendar.getBTNNovaConsulta().setEnabled(false);
        this.simularTabela = new String[11][5];
        this.chaveMedico = -1; // alteracao
        try {
            ExportarDados.recuperarConsultas();
        } catch (IOException ex) {
           System.out.println("Falha na criação do arquivo Consultas.txt");
        }
        
        addEventos();
    }
    
    public void addEventos() {
        this.panelAgendar.getBTNNovaConsulta().addActionListener(this);        
        this.panelAgendar.getBTNBuscar().addActionListener(this);
        this.panelAgendar.getBTNVoltar().addActionListener(this);
        this.panelAgendar.getBTNAvancar().addActionListener(this);
        this.panelAgendar.getTableSemana().addMouseListener(new MouseAdapter() {
            @Override 
            public void mouseClicked(MouseEvent e) {
                int linha = panelAgendar.getTableSemana().rowAtPoint(e.getPoint());
                int coluna = panelAgendar.getTableSemana().columnAtPoint(e.getPoint());                
                if (linha >= 0 && linha <= 11 && coluna >= 1 && coluna <= 5) {
                    //System.out.println("linha = " + linha + " coluna = " + coluna);
                    String chaveConsulta = simularTabela[linha][coluna - 1];
                    System.out.println("CHAVE CONSULTA " + chaveConsulta);
                    //alteracao
                    if (chaveMedico != -1 && ControladorFrame.repositorioConsultas.procurarConsulta(chaveConsulta) == true) { 
                        dialogEditarConsulta = new DialogEditarConsulta(ControladorFrame.frame);
                        controladorDialogCadastrarConsulta = new ControladorDialogCadastrarConsulta(dialogEditarConsulta, chaveMedico, chaveConsulta);
                    }                   
                }
            }
        });
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() ==  this.panelAgendar.getBTNNovaConsulta()) {            
            dialogCadastrarConsulta = new DialogCadastrarConsulta(ControladorFrame.frame);
            controladorDialogCadastrarConsulta = new ControladorDialogCadastrarConsulta(dialogCadastrarConsulta, chaveMedico);
            atualizarAgenda(chaveMedico);
        } else if (e.getSource() ==  this.panelAgendar.getBTNBuscar()) {
            this.panelAgendar.getTxFPesquisar().setText("");
            this.panelAgendar.getBTNNovaConsulta().setEnabled(false);
            limparAgenda();
            dialogBuscarMedico = new DialogBuscar(ControladorFrame.frame);
            controladorDialogBuscarMedico = new ControladorDialogBuscarMedico(dialogBuscarMedico);
            chaveMedico = controladorDialogBuscarMedico.getChaveMedico();  
            System.out.println("chave = " +chaveMedico);
            if (chaveMedico != -1) {
                atualizarAgenda(chaveMedico);
                this.panelAgendar.getBTNNovaConsulta().setEnabled(true);
            }            
        } else if (e.getSource() == this.panelAgendar.getBTNVoltar()) {
            this.panelAgendar.mudarSemana(-1);
            limparAgenda();
            if (chaveMedico != -1) {
                atualizarAgenda(chaveMedico);
            }            
        } else if (e.getSource() == this.panelAgendar.getBTNAvancar()) {
            this.panelAgendar.mudarSemana(1);
            limparAgenda();
            if (chaveMedico != -1) {
                atualizarAgenda(chaveMedico);
            }
        }
    }
    
    // depois que o usuario escolhe um medico, o nome do medico sera atualizado aqui
    void atualizarAgenda(int chaveMedico) {        
        if (chaveMedico >= 0) {
            String[] options = { "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00" };
            LocalDate inicioSemana = this.panelAgendar.getInicioSemana();
            
            Medico medico = ControladorFrame.repositorioMedicos.getMedicos().get(chaveMedico);
            this.panelAgendar.getTxFPesquisar().setText(medico.getNome());
            for (int col = 1; col < 6; col++) {
                for (int row = 0; row < 11; row++) {
                    if (medico.getHorasAtend()[row][col - 1] == 1) {
                        LocalDate dia = inicioSemana.plusDays(col - 1);
                        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        String dataFormatada = dia.format(formatador);
                        String procurarChave = "M=" + chaveMedico + "#D=" + dataFormatada + "#H=" + options[row];
                        //System.out.println(procurarChave);
                        if (ControladorFrame.repositorioConsultas.procurarConsulta(procurarChave) == true) {
                            this.panelAgendar.getTableSemana().getModel().setValueAt(procurarChave, row, col);
                            this.simularTabela[row][col -1] = procurarChave;
                        } else {
                            this.panelAgendar.getTableSemana().getModel().setValueAt("DISPONÍVEL", row, col);                           
                        }                        
                    } else {
                        this.simularTabela[row][col -1] = null;
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
            } else if (texto.startsWith("M=")) {
                super.setBackground(new Color(128, 128, 128));
                super.setText(ControladorFrame.repositorioConsultas.getConsulta(texto).getPaciente());                
                super.setForeground(new Color(255, 255, 255));
            }
            else {
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
