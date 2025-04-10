package controller;

import model.RecomendacaoEquipamento;

import java.util.ArrayList;
import java.util.List;

public class RecomendadorEquipamentos {
    private final List<RecomendacaoEquipamento> banco = new ArrayList<>();

    public RecomendadorEquipamentos() {
        // Congelado - Trifásico
        banco.add(new RecomendacaoEquipamento("Congelado", "Trifásico", 0, 3000, "1,5HP", "EVP-0015", 2, "R404A"));
        banco.add(new RecomendacaoEquipamento("Congelado", "Trifásico", 3001, 5000, "2HP", "EVP-0025", 3, "R404A"));
        banco.add(new RecomendacaoEquipamento("Congelado", "Trifásico", 5001, 8000, "3HP", "EVP-0040", 4, "R404A"));

        // Resfriado - Trifásico
        banco.add(new RecomendacaoEquipamento("Resfriado", "Trifásico", 0, 3000, "1HP", "EVP-RS15", 2, "R134a"));
        banco.add(new RecomendacaoEquipamento("Resfriado", "Trifásico", 3001, 5000, "1,5HP", "EVP-RS30", 3, "R134a"));

        // Resfriado - Monofásico
        banco.add(new RecomendacaoEquipamento("Resfriado", "Monofásico", 0, 3000, "1HP", "EVP-RS15M", 2, "R134a"));
        banco.add(new RecomendacaoEquipamento("Resfriado", "Monofásico", 3001, 5000, "1,5HP", "EVP-RS30M", 3, "R134a"));

        // Congelado - Monofásico
        banco.add(new RecomendacaoEquipamento("Congelado", "Monofásico", 0, 3000, "1,5HP", "EVP-0015M", 2, "R404A"));
        banco.add(new RecomendacaoEquipamento("Congelado", "Monofásico", 3001, 5000, "2HP", "EVP-0025M", 3, "R404A"));
    }

    public RecomendacaoEquipamento recomendar(String tipoProduto, String fase, double cargaTermica) {
        for (RecomendacaoEquipamento rec : banco) {
            if (rec.tipoProduto.equalsIgnoreCase(tipoProduto)
                    && rec.fase.equalsIgnoreCase(fase)
                    && cargaTermica >= rec.cargaMin
                    && cargaTermica <= rec.cargaMax) {
                return rec;
            }
        }
        return new RecomendacaoEquipamento(tipoProduto, fase, 0, 0,
                "Não encontrado", "Consultar técnico", 0, "N/A");
    }
}
