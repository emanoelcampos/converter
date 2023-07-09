package dev.emanoel.converter.currency.view;

import javax.swing.*;

public class CurrencyResultView {

    public static void showExchangeResult(double exchangeResult, String currencySymbol) {
        JOptionPane.showMessageDialog(
                null,
                "O valor da conversão é de: " + currencySymbol + " " + exchangeResult,
                "Conversão Concluída",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
