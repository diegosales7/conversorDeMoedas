public class ieneJapones extends Moeda {

    public ieneJapones(double taxaConversao) {
        super("JPY", taxaConversao);
    }

    @Override
    public double converter(double valor) {
        System.out.println("Convertendo para iene Japones...");
        return super.converter(valor);
    }
}