package dev.emanoel.converter.currency.view;

public class CurrencyChoiceUtil {

    public static String getCurrencies(String currencyChoice) {
        return switch (currencyChoice) {
            case "De Real para Dólar" -> "BRLUSD";
            case "De Real para Euro" -> "BRLEUR";
            case "De Real para Libra Esterlina" -> "BRLGBP";
            case "De Real para Peso Argentino" -> "BRLARS";
            case "De Real para Peso Chileno" -> "BRLCLP";
            case "De Dólar para Real" -> "USDBRL";
            case "De Euro para Real" -> "EURBRL";
            case "De Libra Esterlina para Real" -> "GBPBRL";
            case "De Peso Argentino para Real" -> "ARSBRL";
            case "De Peso Chileno para Real" -> "CLPBRL";
            default -> "";
        };
    }

    public static String getCurrencySymbol(String currencies) {
        return switch (currencies) {
            case    "De Real para Dólar",
                    "De Real para Euro",
                    "De Real para Libra Esterlina",
                    "De Real para Peso Argentino",
                    "De Real para Peso Chileno" -> "R$";
            case    "De Dólar para Real" -> "$";
            case    "De Euro para Real" -> "€";
            case    "De Libra Esterlina para Real" -> "£";
            case    "De Peso Argentino para Real",
                    "De Peso Chileno para Real" -> "$";
            default -> "";
        };
    }
}
