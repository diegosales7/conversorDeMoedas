public class francoSuico extends Moeda {

    public francoSuico(double taxaConversao) {
        super("CHF", taxaConversao);
    }

    @Override
    public double converter(double valor) {
        System.out.println("Convertendo para Franco Suiço...");
        return super.converter(valor);
    }
}
