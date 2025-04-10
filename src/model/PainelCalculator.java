package model;

import java.util.ArrayList;
import java.util.List;

public class PainelCalculator {
    public static List<ResultadoParte> calcularDetalhado(double largura, double comprimento, double altura, double larguraPainel, boolean incluirPiso) {
        List<ResultadoParte> resultados = new ArrayList<>();

        double perimetro = 2 * (largura + comprimento);
        double areaParedes = perimetro * altura;
        int qtdParedes = (int) Math.ceil(perimetro / larguraPainel);
        resultados.add(new ResultadoParte("Painéis Parede", qtdParedes, altura, qtdParedes * altura * larguraPainel));

        double areaTeto = largura * comprimento;
        double areaPainelTeto = larguraPainel * comprimento;
        int qtdTeto = (int) Math.ceil(areaTeto / areaPainelTeto);
        resultados.add(new ResultadoParte("Painéis Teto", qtdTeto, comprimento, qtdTeto * larguraPainel));

        if (incluirPiso) {
            double areaPainelPiso = larguraPainel * comprimento;
            int qtdPiso = (int) Math.ceil(areaTeto / areaPainelPiso);
            resultados.add(new ResultadoParte("Painéis Piso", qtdPiso, comprimento, qtdPiso * larguraPainel));
        }

        return resultados;
    }
}
