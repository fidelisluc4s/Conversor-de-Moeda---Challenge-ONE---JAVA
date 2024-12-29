package br.com.alura.conversor.model;

import java.util.HashMap;
import java.util.Map;

public class MoedaFiltrada {
        private final String base_code;
        private final String time_last_update_utc;
        private final double USD, EUR, ARS, BRL, BOB, CLP, COP, CHF,CNY;

        public MoedaFiltrada(String base_code, String time_last_update_utc, double USD, double EUR, double ARS, double BRL, double BOB, double CLP, double COP, double CHF, double CNY) {
                this.base_code = base_code;
                this.time_last_update_utc = time_last_update_utc;
                this.USD = USD;
                this.EUR = EUR;
                this.ARS = ARS;
                this.BRL = BRL;
                this.BOB = BOB;
                this.CLP = CLP;
                this.COP = COP;
                this.CHF = CHF;
                this.CNY = CNY;
        }

        public String getBase_code() {
                return base_code;
        }

        public String getTime_last_update_utc() {
                return time_last_update_utc;
        }

        public double getUSD() {
                return USD;
        }

        public double getEUR() {
                return EUR;
        }

        public double getARS() {
                return ARS;
        }

        public double getBRL() {
                return BRL;
        }

        public double getBOB() {
                return BOB;
        }

        public double getCLP() {
                return CLP;
        }

        public double getCOP() {
                return COP;
        }

        public double getCHF() {
                return CHF;
        }

        public double getCNY() {
                return CNY;
        }

        public Map<String, Double> getConversionRates(){
                Map<String, Double> taxas = new HashMap<>();
                taxas.put("USD", USD);
                taxas.put("EUR", EUR);
                taxas.put("ARS", ARS);
                taxas.put("BRL", BRL);
                taxas.put("BOB", BOB);
                taxas.put("CLP", CLP);
                taxas.put("COP", COP);
                taxas.put("CHF", CHF);
                taxas.put("CNY", CNY);
                return taxas;
        }
}

