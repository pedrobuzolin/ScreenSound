package br.com.desafio.musicas.principal;

import br.com.desafio.musicas.model.Artista;
import br.com.desafio.musicas.model.Musica;

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
        System.out.println("Digite o tipo do artista (solo, dupla, banda): ");
        String tipo = leitor.nextLine();
        try {
            Artista artista = new Artista(nome, tipo);
            System.out.println(artista);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao cadastrar Artista!");
        }

    }

    private void cadastrarMusica() {
        System.out.println("Digite a musica: ");
        String titulo = leitor.nextLine();
        try {
            Musica musica = new Musica(titulo);
            System.out.println(musica);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao cadastrar Musica!");
        }

    }
}
