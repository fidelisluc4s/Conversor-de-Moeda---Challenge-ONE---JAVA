import br.com.alura.conversor.model.ConsultaMoeda;
import br.com.alura.conversor.model.Moeda;
import br.com.alura.conversor.model.MoedaFiltrada;
import com.google.gson.Gson;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ConsultaMoeda m = new ConsultaMoeda();

        //String jsonResposta = m.buscaMoeda("BRL");

        //System.out.println(jsonResposta);

        try {
            //Moeda moe = m.buscaMoeda("BRL");
            //System.out.println(moe);
            //System.out.println("base do codigo: "+moe.base_code());
            //System.out.println("taxa de conversao para eur: "+moe.conversion_rates().EUR());
            //System.out.println("ultima atualização: "+moe.time_last_update_utc());

            MoedaFiltrada moedafiltro = m.buscaMoedasFiltradas("BRL");

            //conversao o objeto para json
            Gson gson = new Gson();
            String json = gson.toJson(moedafiltro);

            System.out.println("Obj no formato JSON");
            System.out.println(json);

            System.out.println(moedafiltro);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}