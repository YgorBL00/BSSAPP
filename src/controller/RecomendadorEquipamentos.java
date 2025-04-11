package controller;

public class RecomendadorEquipamentos {
    public static String recomendar(double cargaTermica, String tipoCamara, String fase) {
        StringBuilder sb = new StringBuilder();

        // Exemplo de recomendação baseada na carga térmica
        if (tipoCamara.equalsIgnoreCase("Congelado")) {
            if (cargaTermica <= 5000) {
                sb.append("Motor: 2HP ").append(fase).append(" - Gás: R404A\n");
                sb.append("Evaporadora: Modelo EV0040 - 3 Ventiladores\n");
            } else if (cargaTermica <= 8000) {
                sb.append("Motor: 3HP ").append(fase).append(" - Gás: R404A\n");
                sb.append("Evaporadora: Modelo EV0060 - 4 Ventiladores\n");
            } else {
                sb.append("Motor: 5HP ").append(fase).append(" - Gás: R404A\n");
                sb.append("Evaporadora: Modelo EV0080 - 5 Ventiladores\n");
            }
        } else {
            if (cargaTermica <= 3000) {
                sb.append("Motor: 1.5HP ").append(fase).append(" - Gás: R134A\n");
                sb.append("Evaporadora: Modelo EV0020 - 2 Ventiladores\n");
            } else if (cargaTermica <= 6000) {
                sb.append("Motor: 2.5HP ").append(fase).append(" - Gás: R134A\n");
                sb.append("Evaporadora: Modelo EV0050 - 3 Ventiladores\n");
            } else {
                sb.append("Motor: 4HP ").append(fase).append(" - Gás: R134A\n");
                sb.append("Evaporadora: Modelo EV0070 - 4 Ventiladores\n");
            }
        }

        return sb.toString();
    }
}
