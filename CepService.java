import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class CepService {

    public static Endereco buscarCep(String cep) {

        try {

            URL url = new URL("https://viacep.com.br/ws/" + cep + "/json/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));

            String linha;
            StringBuilder resposta = new StringBuilder();

            while ((linha = reader.readLine()) != null) {
                resposta.append(linha);
            }

            reader.close();

            JSONObject json = new JSONObject(resposta.toString());

            return new Endereco(
                    json.getString("cep"),
                    json.getString("logradouro"),
                    json.getString("bairro"),
                    json.getString("localidade"),
                    json.getString("uf")
            );

        } catch (Exception e) {
            System.out.println("Erro ao buscar CEP");
            return null;
        }
    }
}
