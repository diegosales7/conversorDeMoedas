public class Moeda {
    private String nome;
    public double taxaConversao; // taxa em relação ao real (BRL)

    public Moeda(String nome, double taxaConversao) {
        this.nome = nome;
        this.taxaConversao = taxaConversao;
    }



    public Moeda(double taxa) {
    }

    public double converter(double valor) {
        return valor * taxaConversao;
    }

    public String getNome() {
        return nome;
    }

    public void setTaxaConversao(double taxa) {
        this.taxaConversao = taxa;
    }
}