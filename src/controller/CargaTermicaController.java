package controller;

import model.CargaTermicaModel;
import model.RecomendacaoEquipamento;

public class CargaTermicaController {
    private final CargaTermicaModel model;

    public CargaTermicaController(double largura, double comprimento, double altura,
                                  String tipoCamara, String faseEletrica,
                                  String produto, double tempInterna, double tempExterna,
                                  int horasOperacao, boolean renovacaoAr, double cargaEquipamentos) {

        model = new CargaTermicaModel(largura, comprimento, altura, tipoCamara, faseEletrica,
                produto, tempInterna, tempExterna, horasOperacao, renovacaoAr, cargaEquipamentos);
    }

    public CargaTermicaController(String largura, String comprimento, String altura, String selectedItem, String selectedItem1, CargaTermicaModel model) {
        this.model = model;
    }

    public CargaTermicaController(double largura, double comprimento, double altura, String selectedItem, String selectedItem1, CargaTermicaModel model) {
        this.model = model;
    }

    public double calcularCargaTermica() {
        return model.calcularCargaTermica();
    }

    public RecomendacaoEquipamento getRecomendacao() {
        return model.gerarRecomendacao();
    }

    public String getResultadoCalculo() {
        return "";
    };
}
