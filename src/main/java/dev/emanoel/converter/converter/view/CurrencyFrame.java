package dev.emanoel.converter.converter.view;

import dev.emanoel.converter.Converter;
import dev.emanoel.converter.MainFrame;
import dev.emanoel.converter.converter.controller.CurrencyController;

import javax.swing.*;
import java.io.IOException;

/**
 * Classe responsável por exibir a interface de conversão de moedas ao usuário.
 */
public class CurrencyFrame implements Converter {

    private final CurrencyController currencyController;

    public CurrencyFrame() {
        this.currencyController = new CurrencyController();
    }

    @Override
    public String getName() {
        return "Conversor de Moedas";
    }

    @Override
    public void showMenu() {
        currencyMenu();
    }

    /**
     * Exibe o menu de conversão de moedas para o usuário.
     */
    public void currencyMenu() {

        double exchangeValue;

        // Solicita ao usuário que insira um valor válido
        while (true) {
            String inputValue = JOptionPane.showInputDialog(
                    null,
                    "Insira um valor:",
                    "Moedas",
                    JOptionPane.PLAIN_MESSAGE);

            try {
                exchangeValue = Double.parseDouble(inputValue);
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "Valor inválido! Insira um valor numérico.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        final String BRL_USD = "De Real para Dólar";
        final String BRL_EUR = "De Real para Euro";
        final String BRL_GBP = "De Real para Libra Esterlina";
        final String BRL_ARS = "De Real para Peso Argentino";
        final String BRL_CLP = "De Real para Peso Chileno";
        final String USD_BRL = "De Dólar para Real";
        final String EUR_BRL = "De Euro para Real";
        final String GBP_BRL = "De Libra Esterlina para Real";
        final String ARS_BRL = "De Peso Argentino para Real";
        final String CLP_BRL = "De Peso Chileno para Real";

        // Solicita ao usuário que escolha uma moeda de conversão
        String[] currencyOptions = {
                BRL_USD,
                BRL_EUR,
                BRL_GBP,
                BRL_ARS,
                BRL_CLP,
                USD_BRL,
                EUR_BRL,
                GBP_BRL,
                ARS_BRL,
                CLP_BRL
        };

        String currencyChoice = (String) JOptionPane.showInputDialog(
                null,
                "Escolha uma moeda para a qual você deseja girar seu dinheiro:",
                "Moedas",
                JOptionPane.PLAIN_MESSAGE,
                null,
                currencyOptions,
                currencyOptions[0]);

        String currencies = " ";
        String currencySymbol = " ";

        switch (currencyChoice) {
            case BRL_USD -> {
                currencies = "BRLUSD";
                currencySymbol = "R$";
            }
            case BRL_EUR -> {
                currencies = "BRLEUR";
                currencySymbol = "R$";
            }
            case BRL_GBP -> {
                currencies = "BRLGBP";
                currencySymbol = "R$";
            }
            case BRL_ARS -> {
                currencies = "BRLARS";
                currencySymbol = "R$";
            }
            case BRL_CLP -> {
                currencies = "BRLCLP";
                currencySymbol = "R$";
            }
            case USD_BRL -> {
                currencies = "USDBRL";
                currencySymbol = "$";
            }
            case EUR_BRL -> {
                currencies = "EURBRL";
                currencySymbol = "€";
            }
            case GBP_BRL -> {
                currencies = "GBPBRL";
                currencySymbol = "£";
            }
            case ARS_BRL -> {
                currencies = "ARSBRL";
                currencySymbol = "$";
            }
            case CLP_BRL -> {
                currencies = "CLPBRL";
                currencySymbol = "$";
            }
        }

        double exchangeResult = 0;

        // Obtém as informações da moeda selecionada a partir do CurrencyFrameController
        try {
            exchangeResult = currencyController.processExchange(currencies, exchangeValue);
        } catch (IOException e) {
            // Log do erro
            e.printStackTrace();

            // Exibição de mensagem de erro detalhada
            String errorMessage = "Ocorreu um erro na solicitação da API: " + e.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        } catch (InterruptedException e) {
            // Log do erro
            e.printStackTrace();

            // Exibição de mensagem de erro
            JOptionPane.showMessageDialog(null, "A operação foi interrompida devido a uma ação do usuário ou uma situação inesperada. Por favor, tente novamente mais tarde.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        } catch (Exception e) {
            // Outras exceções não esperadas
            e.printStackTrace();

            // Exibição de mensagem de erro genérica
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }


        // Exibe o resultado da conversão em um diálogo de mensagem
        JOptionPane.showMessageDialog(
                null,
                "O valor da conversão é de: " + currencySymbol + " " + exchangeResult,
                "Conversão Concluída",
                JOptionPane.INFORMATION_MESSAGE);

        int confirmOption = JOptionPane.showConfirmDialog(
                null,
                "Deseja continuar?",
                "Conversão Concluída",
                JOptionPane.YES_NO_CANCEL_OPTION);

        if (confirmOption == JOptionPane.YES_OPTION) {
            MainFrame mainFrame = new MainFrame();
            mainFrame.showMainMenu();
        } else if (confirmOption == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(
                    null,
                    "Programa finalizado.",
                    null,
                    JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Programa concluído.",
                    null,
                    JOptionPane.PLAIN_MESSAGE);
        }
    }
}

