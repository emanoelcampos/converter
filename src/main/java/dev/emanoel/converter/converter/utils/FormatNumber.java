package dev.emanoel.converter.converter.utils;

public class FormatNumber {
    public static String formatDecimal(double number) {
        return String.format("%.2f", number).replace(",", ".");
    }
}
