import com.google.gson.Gson;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ApiService {

    public static double buscarTaxa(String moedaOrigem, String moedaDestino) {
        try {

            String urlStr = "https://v6.exchangerate-api.com/v6/74b70dd9658bc57bd79e35c6/pair/"
                    + moedaOrigem + "/" + moedaDestino;

            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");


            Gson gson = new Gson();
            InputStreamReader reader = new InputStreamReader(conn.getInputStream());
            taxaCambio resposta = gson.fromJson(reader, taxaCambio.class);


            if (!"success".equalsIgnoreCase(resposta.getResult())) {
                System.out.println("❌ Erro na resposta da API!");
                return 0;
            }


            System.out.println(" Moeda Origem: " + resposta.getBase_code());
            System.out.println(" Moeda Destino: " + resposta.getTarget_code());
            System.out.println(" Taxa: " + resposta.getConversion_rate());


            salvarConsultaComoJson(resposta);

            return resposta.getConversion_rate();

        } catch (Exception e) {
            System.out.println(" Erro ao buscar taxa: " + e.getMessage());
            return 0;
        }
    }


    private static void salvarConsultaComoJson(taxaCambio resposta) {
        try {

            LocalDateTime agora = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
            String nomeArquivo = "consulta_" + resposta.getBase_code() + "_" + resposta.getTarget_code()
                    + "_" + agora.format(formatter) + ".json";


            String json = new Gson().toJson(resposta);
            Files.writeString(Paths.get(nomeArquivo), json);

            System.out.println(" Arquivo salvo com sucesso: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println(" Erro ao salvar arquivo JSON: " + e.getMessage());
        }
    }
}