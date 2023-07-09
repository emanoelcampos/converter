package dev.emanoel.converter.currency.view;

import javax.swing.*;

public class CurrencyErrorView {

    public static void showError(String errorMessage) {
        JOptionPane.showMessageDialog(
                null,
                errorMessage,
                "Erro",
                JOptionPane.ERROR_MESSAGE);
    }
}
