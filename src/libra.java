public class libra extends Moeda {

    public libra(double taxaConversao) {
        super("GBP", taxaConversao);
    }

    @Override
    public double converter(double valor) {
        System.out.println("Convertendo para Libra...");
        return super.converter(valor);
    }
}