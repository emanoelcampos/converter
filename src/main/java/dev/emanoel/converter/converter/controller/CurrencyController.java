package dev.emanoel.converter.converter.controller;

import dev.emanoel.converter.converter.service.CurrencyService;

import java.io.IOException;

/**
 * Classe responsável por controlar a lógica de conversão de moedas.
 */
public class CurrencyController {

    private static final String API_URL = "https://economia.awesomeapi.com.br/last/BRL-USD,BRL-EUR,BRL-GBP,BRL-ARS,BRL-CLP,USD-BRL,EUR-BRL,GBP-BRL,ARS-BRL,CLP-BRL";

    private final CurrencyService currencyService;

    public CurrencyController() {
        this.currencyService = new CurrencyService();
    }

    /**
     * Processa a conversão de moeda com base nas moedas e no valor fornecidos.
     *
     * @param currencies As moedas a serem usadas na conversão.
     * @param value      O valor a ser convertido.
     * @return O resultado da conversão.
     */
    public double processExchange(String currencies, double value) throws IOException, InterruptedException {
        return currencyService.calculateExchange(API_URL, currencies, value);
    }

}
