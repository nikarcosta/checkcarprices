package com.nika.checkcarprices.service;

public class VeiculoService {
    private final String BASE_URI = "https://parallelum.com.br/fipe/api/v1/";
    private ConsumoAPI consumoAPI = new ConsumoAPI();

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

        System.out.println(json);
    }
}
