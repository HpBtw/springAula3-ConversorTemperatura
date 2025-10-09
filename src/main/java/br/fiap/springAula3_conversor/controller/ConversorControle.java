package br.fiap.springAula3_conversor.controller;

import br.fiap.springAula3_conversor.service.ConversorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
public class ConversorControle {
    private final ConversorService service;

    public ConversorControle(ConversorService service) {
        this.service = service;
    }

    @PostMapping("/converter")
    public String converter(@RequestParam double celsius, Model model) {
        double fahrenheit = service.celsiusToFahren(celsius);
        model.addAttribute("fahrenheit", fahrenheit);

        return "index";
    }

    @PostMapping("/calculadora")
    public String calculadora(@RequestParam String op,
                              @RequestParam String x,
                              @RequestParam String y,
                              Model model) {
        BigDecimal resultado = null;
        String erro = "";

        try {
            resultado = service.calcular(x, y, op);
        } catch (Exception e) {
            erro = e.getMessage();
        }
        System.out.println("11111111111111");
        model.addAttribute("resultado", resultado);
        model.addAttribute("erro", erro);
        return "index";
    }
}
