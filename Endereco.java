public class Endereco {

    String cep;
    String logradouro;
    String bairro;
    String localidade;
    String uf;

    public Endereco(String cep, String logradouro, String bairro, String localidade, String uf) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "CEP: " + cep +
                "\nLogradouro: " + logradouro +
                "\nBairro: " + bairro +
                "\nCidade: " + localidade +
                "\nUF: " + uf;
    }
}
