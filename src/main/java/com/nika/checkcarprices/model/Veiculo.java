package com.nika.checkcarprices.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record Veiculo(
        @JsonAlias("Valor") String valor,
        @JsonAlias("Marca") String marca,
        @JsonAlias("Modelo") String modelo,
        @JsonAlias("AnoModelo") Integer ano,
        @JsonAlias("Combustível") String tipoCombustível
) {
}
