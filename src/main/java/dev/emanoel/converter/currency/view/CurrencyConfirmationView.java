package dev.emanoel.converter.currency.view;

import dev.emanoel.converter.view.MainView;

import javax.swing.*;

public class CurrencyConfirmationView {

    public static void showConfirmationMenu() {

        int confirmOption = JOptionPane.showConfirmDialog(
                null,
                "Deseja continuar convertendo moedas?",
                "Conversor",
                JOptionPane.YES_NO_CANCEL_OPTION);

        if (confirmOption == JOptionPane.YES_OPTION) {
            CurrencyView currencyView = new CurrencyView();
            currencyView.showCurrencyMenu();
        } else if (confirmOption == JOptionPane.NO_OPTION) {
            MainView mainView = new MainView();
            mainView.showConverterMenu();
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Programa finalizado.",
                    null,
                    JOptionPane.PLAIN_MESSAGE);
        }
    }

}
