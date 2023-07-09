package dev.emanoel.converter;


import dev.emanoel.converter.view.MainView;

import javax.swing.*;

public class Application {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            MainView window = new MainView();
            window.showConverterMenu();
        });
    }
}
