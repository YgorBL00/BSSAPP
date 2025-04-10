package model;

public class ResultadoParte {
    public final String parte;
    public final int quantidade;
    public final double altura;
    public final double area;

    public ResultadoParte(String parte, int quantidade, double altura, double area) {
        this.parte = parte;
        this.quantidade = quantidade;
        this.altura = altura;
        this.area = area;
    }
}
