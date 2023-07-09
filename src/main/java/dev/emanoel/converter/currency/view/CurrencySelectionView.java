package dev.emanoel.converter.currency.view;

import javax.swing.*;

public class CurrencySelectionView {

    public static String promptCurrency() {
        String[] currencyOptions = {
                "De Real para Dólar",
                "De Real para Euro",
                "De Real para Libra Esterlina",
                "De Real para Peso Argentino",
                "De Real para Peso Chileno",
                "De Dólar para Real",
                "De Euro para Real",
                "De Libra Esterlina para Real",
                "De Peso Argentino para Real",
                "De Peso Chileno para Real"
        };

        return (String) JOptionPane.showInputDialog(
                null,
                "Escolha uma moeda para a qual você deseja girar seu dinheiro:",
                "Moedas",
                JOptionPane.PLAIN_MESSAGE,
                null,
                currencyOptions,
                currencyOptions[0]);
    }
}
