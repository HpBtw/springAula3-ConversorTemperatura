package br.fiap.springAula3_conversor.service;

import org.springframework.stereotype.Service;

@Service
public class ConversorService {
    public double celsiusToFahren(double c) {
        return c * 9/5 + 32;
    }
}
