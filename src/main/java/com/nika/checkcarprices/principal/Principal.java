package com.nika.checkcarprices.principal;

import com.nika.checkcarprices.service.ConsumoAPI;
import com.nika.checkcarprices.service.VeiculoService;

import java.util.Scanner;

public class Principal {
    private VeiculoService veiculoService = new VeiculoService();
    private Scanner input = new Scanner(System.in);

    public void ExibeMenu(){
        int opcao = -1;

        while(opcao != 0){
            System.out.println("Menu");
            System.out.println("1 - Buscar veículos");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opção");

            opcao = input.nextInt();
            input.nextLine();

            switch (opcao){
                case 1 -> buscarVeiculos();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private void buscarVeiculos(){
        System.out.println("****OPÇÕES****");
        System.out.println("Carros");
        System.out.println("Motos");
        System.out.println("Caminhões");
        System.out.println("Digite uma das opções para consultar valores:");

        String veiculo = input.nextLine();
        veiculoService.listarVeiculos(veiculo);
    }
}
