package dev.emanoel.converter;

import dev.emanoel.converter.converter.view.CurrencyFrame;
import dev.emanoel.converter.temperature.view.TemperatureFrame;

import javax.swing.*;

public class MainFrame {

    private final Converter[] converters;

    public MainFrame() {
        this.converters = initializeConverters();
    }

    private Converter[] initializeConverters() {
        return new Converter[]{
                new CurrencyFrame(),
                new TemperatureFrame()
        };
    }

    public void showMainMenu() {
        String[] converterOptions = new String[converters.length];
        for (int i = 0; i < converters.length; i++) {
            converterOptions[i] = converters[i].getName();
        }

        String converterChoice = (String) JOptionPane.showInputDialog(
                null,
                "Escolha uma opção:",
                "Conversor",
                JOptionPane.PLAIN_MESSAGE,
                null,
                converterOptions,
                converterOptions[0]);

        for (Converter converter : converters) {
            if (converter.getName().equals(converterChoice)) {
                converter.showMenu();
                break;
            }
        }

    }
}
