package com.nika.checkcarprices.principal;

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
            System.out.println("2 - Buscar modelos");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opção");

            opcao = input.nextInt();
            input.nextLine();

            switch (opcao){
                case 1 -> buscarVeiculos();
                case 2 -> buscarModelos();
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
        System.out.println("Digite uma das opções para consultar marcas:");

        String veiculo = input.nextLine();
        veiculoService.listarVeiculos(veiculo);
    }

    private void buscarModelos(){
        System.out.println("Qual é o tipo de veículo?");
        System.out.println("1 - Carro");
        System.out.println("2 - Moto");
        System.out.println("3 - Caminhão");
        System.out.println("Digite uma das opções acima:");

        int veiculo = input.nextInt();
        input.nextLine();

        System.out.println("Agora digite o código da marca que você deseja consultar:");

        int codMarca = input.nextInt();
        input.nextLine();

        veiculoService.listarModelos(veiculo, codMarca);
    }
}
