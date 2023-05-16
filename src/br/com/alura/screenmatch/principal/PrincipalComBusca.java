package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.conexao.ConexaoHttp;
import br.com.alura.screenmatch.conexao.ConexaoOmdb;
import br.com.alura.screenmatch.leitura.Json;
import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        List<Titulo> titulos = new ArrayList<>();

        Json json = new Json();
        ConexaoOmdb conexaoOmdb = new ConexaoOmdb();

        do {

            System.out.println("Digite um filme para busca: ");
            conexaoOmdb.setBusca(leitura.nextLine());

            if(conexaoOmdb.getBusca().equalsIgnoreCase("sair")) {
                break;
            }

            try {
                ConexaoHttp conexaoHttp = new ConexaoHttp(conexaoOmdb.getEndereco());
                String jsonBody = conexaoHttp.getResponseBody();

                TituloOmdb meuTituloOmdb = json.getFromJson(jsonBody, TituloOmdb.class);
                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                titulos.add(meuTitulo);

            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Algum erro de argumento na busca, verifique o endereço");
            } catch (ErroDeConversaoDeAnoException e) {
                System.out.println(e.getMessage());
            }

        } while (!conexaoOmdb.getBusca().equalsIgnoreCase("sair"));

        System.out.println(titulos);
        json.criarArquivoJson("filmes.json", titulos);
        System.out.println("O programa finalizou corretamente!");

    }
}
