package lib;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;

public class FlatLafTestApp {
    public static void main(String[] args) {
        // Tenta aplicar o tema FlatLaf
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        // Cria a janela principal
        JFrame frame = new JFrame("App Câmara Fria - Teste FlatLaf");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);

        // Cria um painel com abas
        JTabbedPane tabbedPane = new JTabbedPane();

        // Aba 1
        JPanel painel1 = new JPanel();
        painel1.add(new JLabel("Bem-vindo à aba 1"));
        painel1.add(new JButton("Clique aqui"));

        // Aba 2
        JPanel painel2 = new JPanel();
        painel2.add(new JLabel("Esta é a aba 2"));

        // Adiciona as abas ao painel
        tabbedPane.addTab("Início", painel1);
        tabbedPane.addTab("Configurações", painel2);

        // Adiciona o painel de abas à janela
        frame.getContentPane().add(tabbedPane);

        // Exibe a janela
        frame.setVisible(true);
    }
}

