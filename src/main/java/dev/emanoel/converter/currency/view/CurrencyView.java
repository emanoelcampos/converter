package dev.emanoel.converter.currency.view;

import dev.emanoel.converter.view.Converter;

/**
 * Classe responsável por exibir a interface de conversão de moedas ao usuário.
 */
public class CurrencyView implements Converter {

    private final String currencyName;
    private CurrencyProcessResult currencyProcessResult;

    public CurrencyView() {
        this.currencyProcessResult = new CurrencyProcessResult();
        this.currencyName = "Conversor de Moedas";
    }

    @Override
    public String getName() {
        return currencyName;
    }

    @Override
    public void getConverterMenu() {
        showCurrencyMenu();
    }

    public void showCurrencyMenu() {

        //tela de entrada de valor para conversão
        double inputValue = CurrencyInputView.promptValue();

        //tela de opçÕes de escolha de de moedas para conversão
        String inputCurrencyChoice = CurrencySelectionView.promptCurrency();

        //retorna as moedas e o simbolo com base na escolha de moedas para conversão
        String currencies = CurrencyChoiceUtil.getCurrencies(inputCurrencyChoice);
        String currencySymbol = CurrencyChoiceUtil.getCurrencySymbol(inputCurrencyChoice);

        //guarda o valor da conversão recebendo as moedas e o valor para calculo da conversão
        double exchangeResult = currencyProcessResult.performConversion(currencies, inputValue);

        //tela de resultado com a conversão feita e com o simbolo da moeda
        CurrencyResultView.showExchangeResult(exchangeResult, currencySymbol);

        //tela de confirmação para decidir o que fazer após a conversão
        CurrencyConfirmationView.showConfirmationMenu();
    }
}

