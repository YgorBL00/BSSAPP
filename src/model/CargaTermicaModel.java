package model;

public class CargaTermicaModel {
    private final double largura, comprimento, altura;
    private final String tipoCamara, faseEletrica, produto;
    private final double tempInterna, tempExterna;
    private final int horasOperacao;
    private final boolean renovacaoAr;
    private final double cargaEquipamentos;

    public CargaTermicaModel(double largura, double comprimento, double altura, String tipoCamara, String faseEletrica,
                             String produto, double tempInterna, double tempExterna,
                             int horasOperacao, boolean renovacaoAr, double cargaEquipamentos) {
        this.largura = largura;
        this.comprimento = comprimento;
        this.altura = altura;
        this.tipoCamara = tipoCamara;
        this.faseEletrica = faseEletrica;
        this.produto = produto;
        this.tempInterna = tempInterna;
        this.tempExterna = tempExterna;
        this.horasOperacao = horasOperacao;
        this.renovacaoAr = renovacaoAr;
        this.cargaEquipamentos = cargaEquipamentos;
    }

    public double calcularCargaTermica() {
        double volume = largura * comprimento * altura;
        double cargaBase = volume * 45; // kcal/m³ — valor base genérico

        if (tipoCamara.equalsIgnoreCase("Congelado")) {
            cargaBase *= 1.2;
        }

        double cargaRenovacao = renovacaoAr ? volume * 0.5 : 0;
        double cargaEquip = cargaEquipamentos;

        return cargaBase + cargaRenovacao + cargaEquip;
    }

    public RecomendacaoEquipamento gerarRecomendacao() {
        double cargaTotal = calcularCargaTermica();
        String modeloCondensadora, modeloEvaporadora, gas;
        int ventiladores;
        String potencia;

        if (cargaTotal <= 3000) {
            modeloCondensadora = "CPR-01";
            modeloEvaporadora = "EV-01";
            potencia = "1HP";
            ventiladores = 1;
            gas = "R404A";
        } else if (cargaTotal <= 6000) {
            modeloCondensadora = "CPR-02";
            modeloEvaporadora = "EV-02";
            potencia = "2HP";
            ventiladores = 2;
            gas = "R404A";
        } else {
            modeloCondensadora = "CPR-03";
            modeloEvaporadora = "EV-03";
            potencia = "3HP";
            ventiladores = 3;
            gas = "R404A";
        }

        return new RecomendacaoEquipamento(modeloCondensadora, modeloEvaporadora, potencia, ventiladores, gas, faseEletrica);
    }
}