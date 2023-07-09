package dev.emanoel.converter.view;

import dev.emanoel.converter.currency.view.CurrencyView;
import dev.emanoel.converter.temperature.view.TemperatureView;

import javax.swing.*;

public class MainView {

    private final Converter[] converters;

    public MainView() {
        this.converters = initializeConverters();
    }

    private Converter[] initializeConverters() {
        return new Converter[]{
                new CurrencyView(),
                new TemperatureView()
        };
    }

    public void showConverterMenu() {
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
                converter.getConverterMenu();
                break;
            }
        }

    }
}
