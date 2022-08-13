package br.com.roberto.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping("/")
    @ResponseBody /* Para retornar a String como corpo, e não como indicador de nome de página a renderizar */
    public String hello() {
        return "Hello World!";
    }
}
