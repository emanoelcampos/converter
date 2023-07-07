package dev.emanoel.converter;

import dev.emanoel.converter.converter.view.CurrencyFrame;
import dev.emanoel.converter.temperature.view.TemperatureFrame;

import javax.swing.*;

public class MainFrame {


    private final CurrencyFrame currencyFrame;
    private final TemperatureFrame temperatureFrame;

    public MainFrame() {
        this.currencyFrame = new CurrencyFrame();
        this.temperatureFrame = new TemperatureFrame();
    }

    public void showMenu() {
        String[] converterOptions = {
                "Conversor de Moedas",
                "Conversor de Temperatura"
        };

        String conversorChoice = (String) JOptionPane.showInputDialog(
                null,
                "Escolha uma opção:",
                "Conversor",
                JOptionPane.PLAIN_MESSAGE,
                null,
                converterOptions,
                converterOptions[0]);

        if (conversorChoice.equals("Conversor de Moedas")) {
            currencyFrame.currencyMenu();

        } else if (conversorChoice.equals("Conversor de Temperatura")) {
            temperatureFrame.temperatureMenu();
        }

    }
}
