package dev.emanoel.converter.currency.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dev.emanoel.converter.currency.model.Currency;
import dev.emanoel.converter.currency.util.GetApiResponse;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

public class CurrencyService {

    public double getBidFromAPI(String apiUrl, String currencies) throws IOException, InterruptedException {

        GetApiResponse getApiResponse = new GetApiResponse();
        String apiResponse = getApiResponse.getApiResponse(apiUrl);

        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, Currency>>(){}.getType();
        Map<String, Currency> currencyMap = gson.fromJson(apiResponse, type);
        return currencyMap.get(currencies).getBid();
    }

    public double calculateExchange(String apiUrl, String currencies, double value) throws IOException, InterruptedException {
        double bid = getBidFromAPI(apiUrl, currencies);
        return bid * value;
    }

}
