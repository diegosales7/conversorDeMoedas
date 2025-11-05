import java.util.Scanner;

public class euro extends Moeda {
    public euro(double taxaConversao) {
        super("Euro", taxaConversao);
    }

    @Override
    public double converter(double valor) {
        System.out.println("Convertendo para Euro...");
        return super.converter(valor);
    }
}