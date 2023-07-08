package dev.emanoel.converter;


import javax.swing.*;

public class Application {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            MainFrame window = new MainFrame();
            window.showMainMenu();
        });
    }
}
