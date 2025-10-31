package com.nika.checkcarprices.service;

import com.nika.checkcarprices.model.Dados;
import com.nika.checkcarprices.model.Modelos;
import com.nika.checkcarprices.model.Veiculo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VeiculoService {
    private final String BASE_URI = "https://parallelum.com.br/fipe/api/v1/";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConverteDados converteDados = new ConverteDados();

    public void listarVeiculos(String veiculo){
        var json = "";
        if(veiculo.toLowerCase().contains("car")){
            json = consumoAPI.obterDados(BASE_URI + "carros/marcas");
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

    public void listarModelos(int veiculo, int codMarca){
        var json = "";

        switch (veiculo){
            case 1 -> json = consumoAPI.obterDados(BASE_URI + "carros/marcas/" + codMarca + "/modelos");
            case 2 -> json = consumoAPI.obterDados(BASE_URI + "motos/marcas/" + codMarca + "/modelos");
            case 3 -> json = consumoAPI.obterDados(BASE_URI + "caminhoes/marcas/" + codMarca + "/modelos");
            default -> {
                System.out.println("Opção inválida!");
                return;
            }
        }

        System.out.println("Modelos dessa marca:");
        var modeloLista = converteDados.obterDados(json, Modelos.class);
        modeloLista.modelos().stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);
    }

    public void listarVeiculosPorNome(int veiculo, int codMarca, String nomeVeiculo){
        var json = "";

        switch (veiculo){
            case 1 -> json = consumoAPI.obterDados(BASE_URI + "carros/marcas/" + codMarca + "/modelos");
            case 2 -> json = consumoAPI.obterDados(BASE_URI + "motos/marcas/" + codMarca + "/modelos");
            case 3 -> json = consumoAPI.obterDados(BASE_URI + "caminhoes/marcas/" + codMarca + "/modelos");
            default -> {
                System.out.println("Opção inválida!");
                return;
            }
        }

        System.out.println("Veículos encontrados sob o nome '" + nomeVeiculo + "':");
        var modeloLista = converteDados.obterDados(json, Modelos.class);

        List<Dados> modelosFiltrados = modeloLista.modelos().stream()
                .filter(m -> m.nome().toLowerCase().contains(nomeVeiculo.toLowerCase()))
                .collect(Collectors.toList());

        modelosFiltrados.forEach(System.out::println);

    }
}
