import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class jsonUtils {

    public static void salvarConsulta(String moedaOrigem, String moedaDestino, double valor, double taxa, double valorConvertido) {
        try {

            Map<String, Object> dados = new HashMap<>();
            dados.put("moedaOrigem", moedaOrigem);
            dados.put("moedaDestino", moedaDestino);
            dados.put("valorOriginal", valor);
            dados.put("taxa", taxa);
            dados.put("valorConvertido", valorConvertido);
            dados.put("dataHora", new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));


            Gson gson = new Gson();
            String json = gson.toJson(dados);


            String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
            String nomeArquivo = "conversao_" + moedaOrigem + "_" + moedaDestino + "_" + timestamp + ".json";


            FileWriter writer = new FileWriter(nomeArquivo);
            writer.write(json);
            writer.close();

            System.out.println(" Conversão salva em: " + nomeArquivo);

        } catch (IOException e) {
            System.out.println(" Erro ao salvar arquivo JSON: " + e.getMessage());
        }
    }
}