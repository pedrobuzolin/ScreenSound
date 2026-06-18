package br.com.desafio.musicas.principal;

import java.util.Scanner;

public class Principal {
    private Scanner leitor = new Scanner(System.in);

    public void exibirMenu() {

        String menu = """
                      1 - Cadastrar Artista
                      2 - Cadastrar Música
                      
                      0 - Sair
                      """;

        int opcao = -1;
        while (opcao != 0) {
            System.out.println(menu);
            opcao = leitor.nextInt();
            leitor.nextLine();

            switch (opcao) {
                case 0:
                    System.out.println("Saindo.....");
                    break;
                case 1:
                    cadastrarArtista();
                    break;
                case 2:
                    cadastrarMusica();
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    private void cadastrarArtista() {
        System.out.println("Digite o nome do Artista: ");
        String nome = leitor.nextLine();
        System.out.println("Artista " + nome + " cadastrado!");
    }

    private void cadastrarMusica() {
        System.out.println("Digite a musica: ");
        String musica = leitor.nextLine();
        System.out.println("Musica " + musica + " cadastrado!");
    }
}
