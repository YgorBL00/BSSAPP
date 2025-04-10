package controller;

import model.PainelCalculator;
import model.ResultadoParte;

import java.util.List;

public class PainelCalculatorController {
    private final double largura, comprimento, altura, larguraPainel;
    private final boolean incluirPiso;
    private List<ResultadoParte> resultado;

    public PainelCalculatorController(String espessura, String largura, String comprimento, String altura, String piso, String larguraPainel) {
        this.largura = Double.parseDouble(largura);
        this.comprimento = Double.parseDouble(comprimento);
        this.altura = Double.parseDouble(altura);
        this.larguraPainel = Double.parseDouble(larguraPainel);
        this.incluirPiso = piso.equalsIgnoreCase("Sim");
    }

    public List<ResultadoParte> getResultadoCalculo() {
        resultado = PainelCalculator.calcularDetalhado(largura, comprimento, altura, larguraPainel, incluirPiso);
        return resultado;
    }

    public double getTotalArea() {
        return resultado.stream().mapToDouble(r -> r.area).sum();
    }
}