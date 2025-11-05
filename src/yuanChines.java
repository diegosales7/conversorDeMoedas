public class yuanChines extends Moeda {

        public yuanChines(double taxaConversao) {
            super("CNY", taxaConversao);
        }

        @Override
        public double converter(double valor) {
            System.out.println("Convertendo para Yuan Chines...");
            return super.converter(valor);
        }
    }

