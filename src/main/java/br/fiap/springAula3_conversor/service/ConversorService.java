package br.fiap.springAula3_conversor.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static com.fasterxml.jackson.datatype.jsr310.DecimalUtils.toBigDecimal;

@Service
public class ConversorService {
    public double celsiusToFahren(double c) {
        return c * 9/5 + 32;
    }

    public double somar(double x, double y) { return x + y; }

    public BigDecimal calcular(String x, String y, String op) {
        BigDecimal v1 = new BigDecimal(Double.valueOf(x));
        BigDecimal v2 = toBigDecimal(y);
    }
}
