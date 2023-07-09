package dev.emanoel.converter.currency.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dev.emanoel.converter.currency.model.CurrencyModel;
import dev.emanoel.converter.currency.utils.ApiResponse;
import dev.emanoel.converter.currency.utils.FormatNumber;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * Classe responsável por lidar com operações relacionadas a moedas.
 */
public class CurrencyService {

    /**
     * Obtém o objeto CurrencyModel a partir de uma API, com base no URL e nas moedas especificadas.
     *
     * @param apiUrl     URL da API de cotações de moedas
     * @param currencies Moedas desejadas
     * @return Objeto CurrencyModel contendo as informações da moeda
     */
    public CurrencyModel getCurrencyModelFromAPI(String apiUrl, String currencies) throws IOException, InterruptedException {
        ApiResponse apiResponse = new ApiResponse();
        String response = apiResponse.getApiResponse(apiUrl);

        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, CurrencyModel>>() {
        }.getType();
        Map<String, CurrencyModel> currencyMap = gson.fromJson(response, type);
        return currencyMap.get(currencies);
    }

    /**
     * Obtém o valor de bid a partir do objeto CurrencyModel.
     *
     * @param currencyModel Objeto CurrencyModel contendo as informações da moeda
     * @return Valor do bid da moeda
     */
    public double getBidFromCurrencyModel(CurrencyModel currencyModel) {
        return currencyModel.getBid();
    }

    /**
     * Calcula a conversão de moedas com base no valor de bid, moedas desejadas e valor a ser convertido.
     *
     * @param apiUrl     URL da API de cotações de moedas
     * @param currencies Moedas desejadas
     * @param value      Valor a ser convertido
     * @return Valor convertido
     */
    public double calculateExchange(String apiUrl, String currencies, double value) throws IOException, InterruptedException {
        CurrencyModel currencyModel = getCurrencyModelFromAPI(apiUrl, currencies);
        double bid = getBidFromCurrencyModel(currencyModel);
        double result = (bid * value);
        return Double.parseDouble(FormatNumber.formatDecimal(result));
    }
}
