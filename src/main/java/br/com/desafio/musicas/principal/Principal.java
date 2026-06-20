package br.com.desafio.musicas.principal;

import br.com.desafio.musicas.model.Artista;
import br.com.desafio.musicas.model.Categoria;
import br.com.desafio.musicas.model.Musica;
import br.com.desafio.musicas.repository.ArtistaRepository;
import br.com.desafio.musicas.service.ConsultaGemini;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private final ArtistaRepository repositorio;
    private Scanner leitor = new Scanner(System.in);

    public Principal(ArtistaRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void exibirMenu() {

        String menu = """
                      1 - Cadastrar Artista
                      2 - Cadastrar Música
                      3 - Listar musicas
                      4 - Buscar musicas por Artista
                      5 - Buscar informações sobre o Artista com Gemini
                      
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
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicasPorArtista();
                    break;
                case 5:
                    buscarInformacoesComGemini();
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    private void cadastrarArtista() {
        String cadastrarNovo = "S";
        while(cadastrarNovo.equalsIgnoreCase("s")) {
            System.out.println("Digite o nome do Artista: ");
            String nome = leitor.nextLine();
            System.out.println("Digite o tipo do artista (solo, dupla, banda): ");
            String tipo = leitor.nextLine();
            Categoria categoria = Categoria.valueOf(tipo.toUpperCase());
            Artista artista = new Artista(nome, categoria);
            repositorio.save(artista);
            System.out.println("Cadastrar novo artista? (S/N)");
            cadastrarNovo = leitor.nextLine();
        }
    }

    private Artista buscarArtista() {
        System.out.println("Digite o nome do Artista: ");
        String nome = leitor.nextLine();
        Optional<Artista> artista = repositorio.findByNomeContainingIgnoreCase(nome);
        if(artista.isPresent()) {
            return artista.get();
        }
        return null;
    }

    private void cadastrarMusica() {
        Artista artista = buscarArtista();
        if(artista != null) {
            System.out.println("Digite a musica: ");
            String titulo = leitor.nextLine();
            Musica musica = new Musica(titulo);
            musica.setArtista(artista);
            artista.getMusicas().add(musica);
            repositorio.save(artista);
        } else {
            System.out.println("Artista não encontrado!");
        }

    }

    private void listarMusicas() {
        List<Artista> artistas = repositorio.findAll();
        artistas.forEach(a -> a.getMusicas().forEach(System.out::println));
    }

    private void buscarMusicasPorArtista() {
        System.out.println("Digite o nome do Artista: ");
        String nome = leitor.nextLine();
        List<Musica> musicas = repositorio.buscarMusicasPorArtista(nome);
        musicas.forEach(System.out::println);
    }

    private void buscarInformacoesComGemini() {
        System.out.println("Digite o artista que deseja saber mais sobre: ");
        String nome = leitor.nextLine();
        String buscaInformacoes = ConsultaGemini.obterInformacaoSobreArtista(nome);
        System.out.println(buscaInformacoes);
    }
}
