package view;

import controller.CargaTermicaController;
import model.CargaTermicaModel;

import javax.swing.*;
import java.awt.*;

public class CargaTermicaPanel extends JPanel {
    private final JComboBox<String> tipoCamaraCombo;
    private final JComboBox<String> faseCombo;
    private final JTextArea resultadoArea;
    private final PainelCalculatorPanel painelCalculatorPanel;
    private final JComboBox<String> isolamentoCombo;
    private final JComboBox<String> tempAmbiente;
    private final JTextField espessuraIsolamentoField;
    private final JTextField txtLargura, txtComprimento, txtAltura ;




    public CargaTermicaPanel(PainelCalculatorPanel painelCalculatorPanel) {
        this.painelCalculatorPanel = painelCalculatorPanel;
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 4, 15, 15));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        inputPanel.add(new JLabel("Tipo de Câmara:"));
        tipoCamaraCombo = new JComboBox<>(new String[]{"Resfriado", "Congelado"});
        inputPanel.add(tipoCamaraCombo);

        inputPanel.add(new JLabel("Fase Elétrica:"));
        faseCombo = new JComboBox<>(new String[]{"Monofásico", "Trifásico"});
        inputPanel.add(faseCombo);

        inputPanel.add(new JLabel("Isolamento:"));
        isolamentoCombo = new JComboBox<>(new String[]{"PIR", "EPS", "PUR"});
        inputPanel.add(isolamentoCombo);

        inputPanel.add(new JLabel("Espessura do Isolamento (mm):"));
        espessuraIsolamentoField = new JTextField("100");
        inputPanel.add(espessuraIsolamentoField);

        inputPanel.add(new JLabel("Largura (m):"));
        txtLargura = new JTextField(String.format("%.2f", Double.parseDouble(painelCalculatorPanel.getLargura())));
        inputPanel.add(txtLargura);

        inputPanel.add(new JLabel("Comprimento (m):"));
        txtComprimento = new JTextField(String.format("%.2f", Double.parseDouble(painelCalculatorPanel.getComprimento())));
        inputPanel.add(txtComprimento);

        inputPanel.add(new JLabel("Altura (m):"));
        txtAltura = new JTextField(String.format("%.2f", Double.parseDouble(painelCalculatorPanel.getAltura())));
        inputPanel.add(txtAltura);

        inputPanel.add(new JLabel("Temperatura Ambiente:"));
        tempAmbiente = new JComboBox<>(new String[]{"32", "35", "38", "43"});
        inputPanel.add(tempAmbiente);

        JButton calcularBtn = new JButton("Calcular Carga Térmica");
        inputPanel.add(new JLabel());
        inputPanel.add(calcularBtn);

        resultadoArea = new JTextArea(10, 40);
        resultadoArea.setEditable(false);
        resultadoArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultadoArea), BorderLayout.CENTER);
        calcularBtn.addActionListener(e -> {
            try {
                double largura = Double.parseDouble(txtLargura.getText());
                double comprimento = Double.parseDouble(txtComprimento.getText());
                double altura = Double.parseDouble(txtAltura.getText());

                // Aqui você pode colocar valores padrão para o restante por enquanto
                CargaTermicaModel model = new CargaTermicaModel(
                        largura,
                        comprimento,
                        altura,
                        (String) tipoCamaraCombo.getSelectedItem(),
                        (String) faseCombo.getSelectedItem(),
                        "Carne",         // Produto padrão por enquanto
                        -18.0,           // Temperatura interna
                        32.0,            // Temperatura externa
                        12,              // Horas de operação
                        true,            // Renovação de ar
                        500.0            // Carga de equipamentos
                );

                CargaTermicaController controller = new CargaTermicaController(
                        largura,
                        comprimento,
                        altura,
                        (String) tipoCamaraCombo.getSelectedItem(),
                        (String) faseCombo.getSelectedItem(),
                        model
                );

                resultadoArea.setText(controller.getResultadoCalculo());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Verifique os valores de largura, comprimento e altura.", "Erro de entrada", JOptionPane.ERROR_MESSAGE);
            }
        });


    }
}
