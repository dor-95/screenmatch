package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso chefão", 1970);
        meuFilme.avalia(9);
        Filme outroFilme = new Filme("Avatar", 2023);
        outroFilme.avalia(7);
        var filmeDoPaulo = new Filme("Dogville", 2003);
        filmeDoPaulo.avalia(10);
        Serie lost = new Serie("Lost", 2000);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(filmeDoPaulo);
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(lost);

        for (Titulo item: lista) {
            System.out.println(item.getNome());
            if (item instanceof Filme filme && filme.getClassificacao() > 2) {
                System.out.println(filme.getClassificacao());
            }
        }

        ArrayList<String> buscaPorNome = new ArrayList<>();
        buscaPorNome.add("Paulo");
        buscaPorNome.add("Jacqueline");
        buscaPorNome.add("Rafaella");
        buscaPorNome.add("Guilherme");

        System.out.println("Antes da comparação: " + buscaPorNome);
        Collections.sort(buscaPorNome);
        System.out.println("Depois da comparação: " + buscaPorNome);

        System.out.println("Antes da comparação: " + lista);
        Collections.sort(lista);
        System.out.println("Depois da comparação: " + lista);
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Ordenando por ano:");
        System.out.println(lista);


    }
}
