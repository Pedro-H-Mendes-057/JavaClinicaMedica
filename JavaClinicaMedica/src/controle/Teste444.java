package controle;

import java.awt.Color;
import java.awt.Component;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

public class Teste444 extends JFrame {

    public Teste444() {
        // Cabeçalhos da tabela
        String[] colunas = {"Nome", "Segunda", "Terça", "Quarta", "Quinta", "Sexta"};

        // Dados da tabela
        String[][] dados = {
            {"Ana", "9-15", "9-15", "9-15", "9-15", "9-15"},
            {"João", "10-16", "10-16", "10-16", "10-16", "10-16"},
            {"Maria", "7-13", "7-13", "7-13", "7-13", "7-13"}
        };

        // Criar a tabela
        JTable tabela = new JTable(dados, colunas);

        // Aplicar o renderer customizado
        tabela.setDefaultRenderer(Object.class, new SpecificCellHighlighter());

        // Configurar a janela
        JScrollPane scrollPane = new JScrollPane(tabela);
        add(scrollPane);
        setTitle("Destacar Célula Específica");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Renderer customizado para destacar célula específica
    static class SpecificCellHighlighter extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Condição para destacar a célula específica (linha 0, coluna 3 - "Quarta")
            if (row == 0 && column == 3 && "9-15".equals(value)) {
                cell.setBackground(Color.RED);
                cell.setForeground(Color.WHITE);
            } else {
                // Restaurar as cores padrão para outras células
                if (row % 2 == 0) {
                    cell.setBackground(Color.LIGHT_GRAY);
                } else {
                    cell.setBackground(Color.WHITE);
                }
                cell.setForeground(Color.BLACK);
            }

            return cell;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Teste444::new);
    }
}
