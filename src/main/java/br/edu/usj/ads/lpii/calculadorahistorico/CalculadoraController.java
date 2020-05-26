package br.edu.usj.ads.lpii.calculadorahistorico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CalculadoraController {

    @Autowired
    OperacaoRepository operacaoRepository;

    @GetMapping(value="/")
    public ModelAndView getHistorico() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("historico", operacaoRepository.findAll());
        return modelAndView;
    }

    @PostMapping(value="/calcula")
    public ModelAndView postCalcula(@RequestParam String numero1, @RequestParam String numero2) {
        Double numero1Double = Double.parseDouble(numero1);
        Double numero2Double = Double.parseDouble(numero2);
        Double resultado = numero1Double + numero2Double;

        String operacaoString = numero1 + " + " + numero2 + " = " + resultado.toString();

        Operacao operacao = new Operacao();
        operacao.setOperacao(operacaoString);

        operacaoRepository.save(operacao);

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("resultado", resultado);
        modelAndView.addObject("historico", operacaoRepository.findAll());
        return modelAndView;
    }

}