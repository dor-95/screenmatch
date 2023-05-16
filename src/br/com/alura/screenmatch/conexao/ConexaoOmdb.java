package br.com.alura.screenmatch.conexao;

public class ConexaoOmdb {
    private String busca;
    private String endereco;

    public void setBusca(String busca) {
        this.busca = busca;
    }

    public String getBusca() {
        return busca;
    }

    public String getEndereco() {
        return "http://www.omdbapi.com/?t=" + this.busca.replace(" ", "+") + "&apikey=f7131c4f";
    }
}
