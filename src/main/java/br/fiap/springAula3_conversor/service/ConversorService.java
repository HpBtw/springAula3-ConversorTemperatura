package br.fiap.springAula3_conversor.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static com.fasterxml.jackson.datatype.jsr310.DecimalUtils.toBigDecimal;

@Service
public class ConversorService {
    public double celsiusToFahren(double c) {
        return c * 9/5 + 32;
    }

    public BigDecimal calcular(String x, String y, String op) {
        BigDecimal v1 = toBigDecimal(x);
        BigDecimal v2 = toBigDecimal(y);

        return switch (op.toUpperCase()) {
            case "SOMAR" -> v1.add(v2);
            case "SUBTRAIR" -> v1.subtract(v2);
            case "DIVIDIR" -> {
                if (v2.compareTo(BigDecimal.ZERO) == 0) {
                    throw new IllegalArgumentException("Não existe divisão por zero");
                } else {
                    yield v1.divide(v2);
                }
            }
            case "MULTIPLICAR" -> v1.multiply(v2);
            default -> null;
        };
    }

    public BigDecimal toBigDecimal(String v) {
        String aux = v.trim().replace(",", ".");
        try {
            return new BigDecimal(aux);
        } catch (Exception e) {
            throw new IllegalArgumentException("Insira números!");
        }
    }
}
