package view;

import controller.PainelCalculatorController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PainelCalculatorPanel extends JPanel {
    private final JTextField txtEspessura, txtLargura, txtComprimento, txtAltura, txtLarguraPainel;
    private final JComboBox<String> comboPiso;
    private final DefaultTableModel resultadoModel;
    private final JLabel lblTotal;

    public PainelCalculatorPanel() {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        txtEspessura = new JTextField("50");
        txtLargura = new JTextField("3.45");
        txtComprimento = new JTextField("3.65");
        txtAltura = new JTextField("2.50");
        comboPiso = new JComboBox<>(new String[]{"Sim", "Não"});
        txtLarguraPainel = new JTextField("1.15");

        String[] labels = {"Espessura (mm):", "Largura (m):", "Comprimento (m):", "Altura (m):", "Piso com painel:", "Largura Painel (m):"};
        JComponent[] inputs = {
                txtEspessura, txtLargura, txtComprimento, txtAltura, comboPiso, txtLarguraPainel
        };

        for (int i = 0; i < labels.length; i++) {
            gbc.gridx = 0;
            gbc.gridy = i;
            inputPanel.add(new JLabel(labels[i]), gbc);

            gbc.gridx = 1;
            inputPanel.add(inputs[i], gbc);
        }

        JButton calcularBtn = new JButton("Calcular");
        gbc.gridx = 0;
        gbc.gridy = labels.length;
        gbc.gridwidth = 2;
        inputPanel.add(calcularBtn, gbc);

        add(inputPanel, BorderLayout.WEST);

        JPanel resultPanel = new JPanel(new BorderLayout());
        resultadoModel = new DefaultTableModel(new String[]{"Painéis", "Quant", "Altura", "M²"}, 0);
        JTable resultadoTable = new JTable(resultadoModel);
        resultPanel.add(new JScrollPane(resultadoTable), BorderLayout.CENTER);

        lblTotal = new JLabel("Total: 0.00 m²");
        lblTotal.setFont(lblTotal.getFont().deriveFont(Font.BOLD, 16f));
        lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
        lblTotal.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel totalPanel = new JPanel(new BorderLayout());
        totalPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        totalPanel.add(lblTotal, BorderLayout.EAST);

        resultPanel.add(totalPanel, BorderLayout.SOUTH);

        add(resultPanel, BorderLayout.CENTER);

        calcularBtn.addActionListener(e -> calcular());
    }

    private void calcular() {
        PainelCalculatorController controller = new PainelCalculatorController(
                txtEspessura.getText(),
                txtLargura.getText(),
                txtComprimento.getText(),
                txtAltura.getText(),
                (String) comboPiso.getSelectedItem(),
                txtLarguraPainel.getText()
        );

        resultadoModel.setRowCount(0);
        controller.getResultadoCalculo().forEach(resultado ->
                resultadoModel.addRow(new Object[]{resultado.parte, resultado.quantidade, resultado.altura, String.format("%.2f", resultado.area)})
        );

        lblTotal.setText("Total: " + String.format("%.2f", controller.getTotalArea()) + " m²");
    }

    public String getLargura() {
        return txtLargura.getText();
    }

    public String getComprimento() {
        return txtComprimento.getText();
    }

    public String getAltura() {
        return txtAltura.getText();
    }
}