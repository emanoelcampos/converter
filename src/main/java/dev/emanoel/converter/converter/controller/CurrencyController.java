package dev.emanoel.converter.converter.controller;

import dev.emanoel.converter.converter.service.CurrencyService;

import java.io.IOException;

public class CurrencyController {

    private static final String API_URL = "https://economia.awesomeapi.com.br/last/BRL-USD,BRL-EUR,BRL-GBP,BRL-ARS,BRL-CLP,USD-BRL,USD-EUR,USD-GBP,USD-ARS,USD-CLP,EUR-BRL,EUR-USD,EUR-GBP,EUR-ARS,EUR-CLP,GBP-BRL,GBP-USD,GBP-EUR,ARS-BRL,ARS-USD,ARS-EUR,CLP-BRL,CLP-USD";

    private CurrencyService currencyService;

    public CurrencyController() {
        this.currencyService = new CurrencyService();
    }

    public double processExchange(String currencies, double value){
        try {
            return currencyService.calculateExchange(API_URL, currencies, value);
        } catch (IOException e) {
            throw new RuntimeException("Erro de IO ao obter cotações de moeda. Verifique sua conexão de internet e tente novamente.", e);
        } catch (InterruptedException e) {
            throw new RuntimeException("A solicitação de cotações de moeda foi interrompida. Tente novamente mais tarde.", e);
        }
    }

}
