package dev.emanoel.converter.currency.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class FormatNumber {
    public static String formatDecimal(double number) {
        return String.format("%.2f", number).replace(",", ".");
    }
}
