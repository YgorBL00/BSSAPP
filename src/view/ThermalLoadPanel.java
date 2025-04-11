package view;

import model.ThermalLoadCalculator;

import javax.swing.*;
import java.awt.*;

public class ThermalLoadPanel extends JPanel {
    private final JTextField txtTempInterna, txtTempExterna;
    private final JComboBox<String> comboTipoProduto, comboTipoCamara, comboFase;
    private final JLabel lblResultado;

    private final PainelCalculatorPanel painelCalculatorPanel;

    public ThermalLoadPanel(PainelCalculatorPanel painelCalculatorPanel) {
        this.painelCalculatorPanel = painelCalculatorPanel;

        setLayout(new BorderLayout());
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        txtTempInterna = new JTextField("-18");
        txtTempExterna = new JTextField("32");
        comboTipoProduto = new JComboBox<>(new String[]{"Carnes", "Frutas", "Peixes", "Laticínios"});
        comboTipoCamara = new JComboBox<>(new String[]{"Congelado", "Resfriado"});
        comboFase = new JComboBox<>(new String[]{"Monofásico", "Trifásico"});

        String[] labels = {"Temperatura Interna (°C):", "Temperatura Externa (°C):", "Produto Armazenado:", "Tipo de Câmara:", "Fase Elétrica:"};
        JComponent[] fields = {txtTempInterna, txtTempExterna, comboTipoProduto, comboTipoCamara, comboFase};

        for (int i = 0; i < labels.length; i++) {
            gbc.gridx = 0;
            gbc.gridy = i;
            formPanel.add(new JLabel(labels[i]), gbc);

            gbc.gridx = 1;
            formPanel.add(fields[i], gbc);
        }

        JButton calcularBtn = new JButton("Calcular Carga Térmica");
        gbc.gridx = 0;
        gbc.gridy = labels.length;
        gbc.gridwidth = 2;
        formPanel.add(calcularBtn, gbc);

        lblResultado = new JLabel("Resultado: -");
        lblResultado.setFont(lblResultado.getFont().deriveFont(Font.BOLD, 16f));
        lblResultado.setHorizontalAlignment(SwingConstants.CENTER);

        add(formPanel, BorderLayout.NORTH);
        add(lblResultado, BorderLayout.CENTER);

        calcularBtn.addActionListener(e -> calcular());
    }

    private void calcular() {
        double largura = Double.parseDouble(painelCalculatorPanel.getLargura());
        double comprimento = Double.parseDouble(painelCalculatorPanel.getComprimento());
        double altura = Double.parseDouble(painelCalculatorPanel.getAltura());

        double tempInterna = Double.parseDouble(txtTempInterna.getText());
        double tempExterna = Double.parseDouble(txtTempExterna.getText());
        String produto = (String) comboTipoProduto.getSelectedItem();
        String tipo = (String) comboTipoCamara.getSelectedItem();
        String fase = (String) comboFase.getSelectedItem();

        double carga = ThermalLoadCalculator.calcularCargaTermica(largura, comprimento, altura, tempInterna, tempExterna, tipo, produto);

        String sugestao = ThermalLoadCalculator.sugerirEquipamento(carga, fase);
        lblResultado.setText("Carga Térmica: " + String.format("%.2f", carga) + " kcal/h\n" + sugestao);
    }
}
