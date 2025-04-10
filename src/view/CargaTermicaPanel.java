package view;

import javax.swing.*;
import java.awt.*;

public class CargaTermicaPanel extends JPanel {
    private final JTextField txtLargura, txtComprimento, txtAltura;
    private final JComboBox<String> comboTipo, comboFase;

    public CargaTermicaPanel(PainelCalculatorPanel painelCalculatorPanel) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        txtLargura = new JTextField(painelCalculatorPanel.getLargura());
        txtComprimento = new JTextField(painelCalculatorPanel.getComprimento());
        txtAltura = new JTextField(painelCalculatorPanel.getAltura());

        comboTipo = new JComboBox<>(new String[]{"Resfriado", "Congelado"});
        comboFase = new JComboBox<>(new String[]{"Monofásico", "Trifásico"});

        String[] labels = {"Largura (m):", "Comprimento (m):", "Altura (m):", "Tipo:", "Fase:"};
        JComponent[] inputs = {txtLargura, txtComprimento, txtAltura, comboTipo, comboFase};

        for (int i = 0; i < labels.length; i++) {
            gbc.gridx = 0;
            gbc.gridy = i;
            add(new JLabel(labels[i]), gbc);

            gbc.gridx = 1;
            add(inputs[i], gbc);
        }
    }
}