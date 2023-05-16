package br.com.alura.screenmatch.conexao;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexaoHttp {

    private HttpClient client;
    private HttpRequest request;
    private HttpResponse<String> response;

    public ConexaoHttp(String endereco) throws IOException, InterruptedException {
        this.client = HttpClient.newHttpClient();
        this.request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        this.response = this.client
                .send(this.request, HttpResponse.BodyHandlers.ofString());
    }

    public String getResponseBody() {
        return this.response.body();
    }
}
