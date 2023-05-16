package br.com.alura.screenmatch.leitura;

import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Json {

    private  Gson gson;

    public Json() {
        this.gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
    }

    public TituloOmdb getFromJson(String json, Class<TituloOmdb> tituloOmdbClass) {
        return this.gson.fromJson(json, tituloOmdbClass);
    }

    public void criarArquivoJson(String nome, List nomeTitulo) throws IOException {
        FileWriter escrita = new FileWriter(nome);
        escrita.write(this.gson.toJson(nomeTitulo));
        escrita.close();
    }
}
