package dev.emanoel.converter.currency.view;

import javax.swing.*;

public class CurrencyInputView {

    public static double promptValue() {

        // Solicita ao usuário que insira um valor válido
        while (true) {
            String inputValue = JOptionPane.showInputDialog(
                    null,
                    "Insira um valor:",
                    "Moedas",
                    JOptionPane.PLAIN_MESSAGE);

            try {
                return Double.parseDouble(inputValue);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "Valor inválido! Insira um valor numérico.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
