package com.alura.musicas.AluraMusicas.Principal;

import com.alura.musicas.AluraMusicas.model.Artista;
import com.alura.musicas.AluraMusicas.model.TipoArtista;
import com.alura.musicas.AluraMusicas.repository.ArtistaRepository;

import java.util.Scanner;

public class Principal {
    private final ArtistaRepository repositorio;
    private Scanner leitura = new Scanner(System.in);
    Integer opcao = -1;

    public Principal(ArtistaRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void exibeMenu(){


        while (opcao !=9){
            var menu = """
                    1 - Cadastrar artistas
                    2 - Cadastrar músicas
                    3 - Listar músicas
                    4 - Buscar músicas por artista
                    5 - pesquisar dados sobre um artista
                    
                    
                    9 - Sair
                    
                    """;
            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao){
                case 1:
                    cadastrarArtistas();
                    break;
                case 2:
                    //cadastrarMusicas();
                    break;
                case 3:
                    //listarMusicas();
                    break;
                case 4:
                    //buscarMusicasPorArtista();
                    break;
                case 5:
                    //pesquisarDadosDoArtista();
                    break;
                case 9:
                    System.out.println("Encerrando a aplicação");
                    break;
                default:
                    System.out.println("Opção Inválida");

            }

        }

    }
    private void cadastrarArtistas(){
        var cadastrarNovo = "S";
        while (cadastrarNovo.equalsIgnoreCase("s")) {
            System.out.println("Informe o nome desse artista");
            var nome = leitura.nextLine();
            System.out.println("Informe o tipo de artista: (Solo, Dupla ou banda)");
            var tipo = leitura.nextLine();
            TipoArtista tipoArtista = TipoArtista.valueOf(tipo.toUpperCase());
            Artista artista = new Artista(nome, tipoArtista);
            repositorio.save(artista);
            System.out.println("Cadastrar novo artista? (S/N)");
            cadastrarNovo = leitura.nextLine();

        }
    }
}
