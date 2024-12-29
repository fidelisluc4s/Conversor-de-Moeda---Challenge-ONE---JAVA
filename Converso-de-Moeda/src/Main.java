import br.com.alura.conversor.model.ConsultaMoeda;
import br.com.alura.conversor.model.ConversorMoeda;
import br.com.alura.conversor.model.Moeda;
import br.com.alura.conversor.model.MoedaFiltrada;
import com.google.gson.Gson;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);
        ConsultaMoeda m = new ConsultaMoeda();

        //String jsonResposta = m.buscaMoeda("BRL");

        //System.out.println(jsonResposta);

        try {
            //Moeda moe = m.buscaMoeda("BRL");
            //System.out.println(moe);
            //System.out.println("base do codigo: "+moe.base_code());
            //System.out.println("taxa de conversao para eur: "+moe.conversion_rates().EUR());
            //System.out.println("ultima atualização: "+moe.time_last_update_utc());

            MoedaFiltrada moedafiltro = m.buscaMoedasFiltradas("EUR");

            //conversao o objeto para json
            //Gson gson = new Gson();
            //String json = gson.toJson(moedafiltro);

            //System.out.println("Obj no formato JSON");
            //System.out.println(json);

            //System.out.println(moedafiltro);
            System.out.println("Informe o valor a se convertido $ ");
            double valor = leitura.nextDouble();

            System.out.println("Informe a moeda de origem (ex: BRL): ");
            String origem = leitura.next();

            System.out.println("Inforem a moeda destino: ");
            String destino = leitura.next();

            double resultado = ConversorMoeda.converter(moedafiltro, origem, destino, valor);

            System.out.printf("O valor convertido de %s para %s  é: %.2f%n",origem, destino, resultado);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}