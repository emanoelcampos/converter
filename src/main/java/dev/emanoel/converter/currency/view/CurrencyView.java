package dev.emanoel.converter.currency.view;

import dev.emanoel.converter.view.Converter;

/**
 * Classe responsável por exibir a interface de conversão de moedas ao usuário.
 */
public class CurrencyView implements Converter {

    private CurrencyProcessResult currencyProcessResult;

    public CurrencyView( ) {
        this.currencyProcessResult = new CurrencyProcessResult();
    }

    @Override
    public String getName() {
        return "Conversor de Moedas";
    }

    @Override
    public void getConverterMenu() {
        showCurrencyMenu();
    }

    public void showCurrencyMenu() {

        double inputValue = CurrencyInputView.promptValue();

        String inputCurrencyChoice = CurrencySelectionView.promptCurrency();

        String currencies = CurrencyChoiceUtil.getCurrencies(inputCurrencyChoice);
        String currencySymbol = CurrencyChoiceUtil.getCurrencySymbol(inputCurrencyChoice);

        double exchangeResult = currencyProcessResult.performConversion(currencies, inputValue);

        CurrencyResultView.showExchangeResult(exchangeResult, currencySymbol);

        CurrencyConfirmationView.showConfirmationMenu();
    }
}

