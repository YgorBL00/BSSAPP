package model;

public class RecomendacaoEquipamento {
    public final String condensadora, evaporadora, potencia, gas, fase;
    public final int ventiladores;

    public RecomendacaoEquipamento(String condensadora, String evaporadora, String potencia,
                                   int ventiladores, String gas, String fase) {
        this.condensadora = condensadora;
        this.evaporadora = evaporadora;
        this.potencia = potencia;
        this.ventiladores = ventiladores;
        this.gas = gas;
        this.fase = fase;
    }
}
