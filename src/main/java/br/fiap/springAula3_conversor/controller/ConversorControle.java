package br.fiap.springAula3_conversor.controller;

import br.fiap.springAula3_conversor.service.ConversorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
