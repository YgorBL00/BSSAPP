package model;

public class ThermalLoadCalculator {
    public static double calcularCargaTermica(double largura, double comprimento, double altura, double tempInterna, double tempExterna, String tipoCamara, String produto) {
        double volume = largura * comprimento * altura;
        double deltaT = tempExterna - tempInterna;
        double fator = tipoCamara.equals("Congelado") ? 25 : 18;

        return volume * deltaT * fator;
    }

    public static String sugerirEquipamento(double carga, String fase) {
        String hp = "";
        String modeloEvap = "";
        String vent = "";

        if (carga < 3000) {
            hp = "1 HP";
            modeloEvap = "EV-0020";
            vent = "1 ventilador";
        } else if (carga < 5000) {
            hp = "2 HP";
            modeloEvap = "EV-0040";
            vent = "2 ventiladores";
        } else if (carga < 8000) {
            hp = "3 HP";
            modeloEvap = "EV-0060";
            vent = "3 ventiladores";
        } else {
            hp = "5 HP";
            modeloEvap = "EV-0100";
            vent = "4 ventiladores";
        }

        return String.format("Sugestão: Compressor %s %s, Gás R404A, Evaporadora %s com %s.", hp, fase, modeloEvap, vent);
    }
}