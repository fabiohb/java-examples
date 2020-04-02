package org.example.exemples;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Currency;
import java.util.Locale;

public class BigDecimalUtil {

    private static final Locale ptBR = new Locale("pt", "BR");

    public static final String DECIMAL_PATTERN = "###,###,###,###,###,##0.00";

    private static final DecimalFormat df = new DecimalFormat(DECIMAL_PATTERN, new DecimalFormatSymbols(ptBR));

    private static final NumberFormat nf = NumberFormat.getInstance(ptBR);

    static {
        df.setCurrency(Currency.getInstance(ptBR));
        df.setParseBigDecimal(true);
    }

    public static BigDecimal convert(String value) {
        try {
            return (BigDecimal) df.parseObject(value);
        } catch (ParseException e) {
            // Throw your exception here
            throw new RuntimeException("", e);
        }
    }

    public static BigDecimal convert2(String value) {
        try {
            Number parsed = nf.parse(value);
            String parsedString = parsed.toString();
            return new BigDecimal(parsedString);
        } catch (ParseException e) {
            // Throw your exception here
            throw new RuntimeException("", e);
        }
    }

}