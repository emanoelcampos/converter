package dev.emanoel.converter.temperature.view;

import dev.emanoel.converter.Converter;

import javax.swing.*;

public class TemperatureFrame implements Converter {

    @Override
    public String getName() {
        return "Conversor de Temperatura";
    }

    @Override
    public void showMenu() {
        temperatureMenu();
    }

    public void temperatureMenu() {
        JOptionPane.showMessageDialog(null, "Em desenvolvimento!",
                "Temperatura", JOptionPane.WARNING_MESSAGE);
    }
}
