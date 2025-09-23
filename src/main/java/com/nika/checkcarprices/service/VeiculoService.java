package com.nika.checkcarprices.service;

import com.nika.checkcarprices.model.Dados;

import java.util.Comparator;

public class VeiculoService {
    private final String BASE_URI = "https://parallelum.com.br/fipe/api/v1/";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConverteDados converteDados = new ConverteDados();

    public void listarVeiculos(String veiculo){
        var json = "";
        if(veiculo.toLowerCase().contains("car")){
            json = consumoAPI.obterDados(BASE_URI + "carros/marcas");
            System.out.println();
        } else if(veiculo.toLowerCase().contains("mot")){
            json = consumoAPI.obterDados(BASE_URI + "motos/marcas");
        } else {
            json = consumoAPI.obterDados(BASE_URI + "caminhoes/marcas");
        }

        var marcas = converteDados.obterLista(json, Dados.class);
        marcas.stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);
    }
}
