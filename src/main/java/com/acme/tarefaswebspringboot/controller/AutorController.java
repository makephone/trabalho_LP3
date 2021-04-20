package com.acme.tarefaswebspringboot.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import com.acme.tarefaswebspringboot.model.Cotacao;


@Controller
@RequestMapping("/")
public class AutorController {

    RestTemplate rest = new RestTemplate();

    @GetMapping
    String index() {
      
        return "autores/index";
    }



    @GetMapping("/realDolar")
    String novo(Model model) {
    	List<Cotacao> realDolar = rest.getForObject("https://economia.awesomeapi.com.br/BRL-USD/1" , List.class);
       	System.out.print(realDolar);
       	 model.addAttribute("objetos", realDolar);
        return "autores/form";
    }
    
    
    @GetMapping("/dolarReal")
    String novo1(Model model) {
    	List<Cotacao> dolarReal = rest.getForObject("https://economia.awesomeapi.com.br/USD-BRL/1" , List.class);
       	System.out.print(dolarReal);
       	 model.addAttribute("objetos", dolarReal);
        return "autores/form";
    }



}
