package model;

public class RecomendacaoEquipamento {
    public final String tipoProduto; // Resfriado ou Congelado
    public final String fase; // Monofásico ou Trifásico
    public final double cargaMin;
    public final double cargaMax;
    public final String compressor;
    public final String evaporadora;
    public final int ventiladores;
    public final String gas;

    public RecomendacaoEquipamento(String tipoProduto, String fase, double cargaMin, double cargaMax,
                                   String compressor, String evaporadora, int ventiladores, String gas) {
        this.tipoProduto = tipoProduto;
        this.fase = fase;
        this.cargaMin = cargaMin;
        this.cargaMax = cargaMax;
        this.compressor = compressor;
        this.evaporadora = evaporadora;
        this.ventiladores = ventiladores;
        this.gas = gas;
    }
}