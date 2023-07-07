package dev.emanoel.converter.converter.controller;

import dev.emanoel.converter.converter.service.CurrencyService;

import java.io.IOException;

/**
 * Classe responsável por controlar a lógica de conversão de moedas.
 */
public class CurrencyController {

    private static final String API_URL = "https://economia.awesomeapi.com.br/last/BRL-USD,BRL-EUR,BRL-GBP,BRL-ARS,BRL-CLP,USD-BRL,USD-EUR,USD-GBP,USD-ARS,USD-CLP,EUR-BRL,EUR-USD,EUR-GBP,EUR-ARS,EUR-CLP,GBP-BRL,GBP-USD,GBP-EUR,ARS-BRL,ARS-USD,ARS-EUR,CLP-BRL,CLP-USD";

    private CurrencyService currencyService;

    public CurrencyController() {
        this.currencyService = new CurrencyService();
    }

    /**
     * Processa a conversão de moeda com base nas moedas e no valor fornecidos.
     *
     * @param currencies As moedas a serem usadas na conversão.
     * @param value O valor a ser convertido.
     * @return O resultado da conversão.
     * @throws IOException se ocorrer um erro de I/O durante a chamada à API
     * @throws InterruptedException se a thread for interrompida durante a chamada à API
     */
    public double processExchange(String currencies, double value) throws IOException, InterruptedException {
        return currencyService.calculateExchange(API_URL, currencies, value);
    }

}
