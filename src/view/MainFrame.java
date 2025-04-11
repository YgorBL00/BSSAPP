package view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Calculadora de Câmaras Frigoríficas");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();
        PainelCalculatorPanel painelCalculatorPanel = new PainelCalculatorPanel(tabbedPane);
        tabbedPane.addTab("Cálculo de Painéis", painelCalculatorPanel);
        //tabbedPane.addTab("Carga Térmica", new CargaTermicaPanel(painelCalculatorPanel));

        add(tabbedPane, BorderLayout.CENTER);
        setVisible(true);
    }
}
