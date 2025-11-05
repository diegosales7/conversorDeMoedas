import java.io.IOException;

public class conversor {

    /**
     * Cria um objeto Moeda baseado no tipo da moeda de destino
     * @param moedaOrigem - código da moeda de origem (ex: BRL)
     * @param moedaDestino - código da moeda de destino (ex: USD, EUR)
     * @return objeto Moeda com a taxa correta
     * @throws IOException
     */
    public static Moeda criarMoeda(String moedaOrigem, String moedaDestino) throws IOException {
        // Busca taxa usando API: moedaOrigem -> moedaDestino
        double taxa = ApiService.buscarTaxa(moedaOrigem, moedaDestino);

        if (taxa == 0) {
            throw new IllegalArgumentException("Não foi possível obter a taxa de conversão.");
        }

        switch (moedaDestino.toUpperCase()) {
            case "USD":
                return new dolar(taxa);
            case "EUR":
                return new euro(taxa);
            case "GBP":
                return new libra(taxa);
            case "CNY":
                return new yuanChines(taxa);
            case "JPY":
                return new ieneJapones(taxa);
            case "CHF":
                return new francoSuico(taxa);
            default:
                throw new IllegalArgumentException("Tipo de moeda não suportado: " + moedaDestino);
        }
    }
}