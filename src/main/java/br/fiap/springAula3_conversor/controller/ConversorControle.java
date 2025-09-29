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

    @PostMapping("/somar")
    public String somar(@RequestParam BigDecimal x, @RequestParam BigDecimal y, Model model) {
        BigDecimal result = service.somar(x, y);
        model.addAttribute("result", result);

        return "index";
    }

    @PostMapping("/calculadora")
    public String calcular(@RequestParam String op, @RequestParam BigDecimal x, @RequestParam BigDecimal y, Model model) {
        BigDecimal resultado = null;
        boolean valid = true;

        switch (op.toUpperCase()) {
            case "SOMAR":
                resultado = service.somar(x, y);
                break;
            case "SUBTRAIR":
                resultado = service.subtrair(x, y);
                break;
            case "DIVIDIR":
                if (y == 0) valid = false;
                else resultado = service.dividir(x, y);
                break;
            case "MULTIPLICAR":
                resultado = service.multiplicar(x, y);
                break;
            default:
                valid = false;
                break;
        };
        model.addAttribute("resultado", valid ? resultado : "Os dados fornecidos estão inválidos");
        return "index";
    }
}
