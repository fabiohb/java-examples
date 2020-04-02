package org.example.exemples;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import java.math.BigDecimal;

public class BigDecimalUtilTest {

    @ParameterizedTest
    @CsvSource({
        "10.24, '10,24'",
        "-10.24, '-10,24'",
        "1023510.24, '1.023.510,24'",
        "987856991023510.24, '987.856.991.023.510,24'",
    })
    public void testConvert(String expected, String value) {
        BigDecimal bd1 = BigDecimalUtil.convert(value);
        assertEquals(new BigDecimal(expected), bd1);
    }

    @ParameterizedTest
    @CsvSource({
        "10.24, '10,24'",
        "-10.24, '-10,24'",
        "1023510.24, '1.023.510,24'",
        "987856991023510.2, '987.856.991.023.510,24'", // Aqui existe perda de precisão
    })
    public void testConvert2(String expected, String value) {
        BigDecimal bd2 = BigDecimalUtil.convert2(value);
        assertEquals(new BigDecimal(expected), bd2);
    }
}
