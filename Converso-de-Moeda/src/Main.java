import br.com.alura.conversor.model.ConsultaMoeda;
import br.com.alura.conversor.model.Moeda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ConsultaMoeda m = new ConsultaMoeda();

        //String jsonResposta = m.buscaMoeda("BRL");

        //System.out.println(jsonResposta);

        try {
            Moeda moe = m.buscaMoeda("BRL");
            //System.out.println(moe);
            System.out.println("base do codigo: "+moe.base_code());
            System.out.println("taxa de conversao para eur: "+moe.conversion_rates().EUR());
            System.out.println("ultima atualização: "+moe.time_last_update_utc());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}