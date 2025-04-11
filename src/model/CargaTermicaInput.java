package model;

public class CargaTermicaInput {
    public final String tipo;
    public final String fase;
    public final String produto;
    public final double tempInterna;
    public final double tempExterna;
    public final int horas;
    public final boolean renovacao;
    public final double cargaEquipamentos;

    public CargaTermicaInput(String tipo, String fase, String produto,
                             double tempInterna, double tempExterna,
                             int horas, boolean renovacao, double cargaEquipamentos) {
        this.tipo = tipo;
        this.fase = fase;
        this.produto = produto;
        this.tempInterna = tempInterna;
        this.tempExterna = tempExterna;
        this.horas = horas;
        this.renovacao = renovacao;
        this.cargaEquipamentos = cargaEquipamentos;
    }
}
