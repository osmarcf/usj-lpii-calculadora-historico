package br.edu.usj.ads.lpii.calculadorahistorico;

import static org.springframework.http.ResponseEntity.ok;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculadoraController {

    Historico historico = new Historico();

    @GetMapping(value="/operacoes")
    public ResponseEntity<List<String>> getOperacoes() {
        return ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(historico.lerOperacoes());
    }

    @PostMapping(value="/calcula")
    public ModelAndView postCalcula(@RequestParam String numero1, @RequestParam String numero2) {
        Double numero1Double = Double.parseDouble(numero1);
        Double numero2Double = Double.parseDouble(numero2);
        Double resultado = numero1Double + numero2Double;

        String operacao = numero1 + " + " + numero2 + " = " + resultado.toString();
        historico.adicionar(operacao);

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("resultado", resultado);
        modelAndView.addObject("historico", historico.lerOperacoes());
        return modelAndView;
    }

}