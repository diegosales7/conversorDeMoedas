public class dolar extends Moeda {
    public dolar(double taxaConversao) {
        super("Dólar", taxaConversao);
    }

    @Override
    public double converter(double valor) {
        System.out.println("Convertendo para Dólar...");
        return super.converter(valor);
    }
}