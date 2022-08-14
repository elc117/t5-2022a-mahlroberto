package br.com.roberto.forum.controller;

import br.com.roberto.forum.controller.dto.TopicoDto;
import br.com.roberto.forum.modelo.Curso;
import br.com.roberto.forum.modelo.Topico;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/* Substitui @Controller e permite que se deixe de usar a anotação @ResponseBody em cada um de seus endpoints */
@RestController
public class TopicosController {

    @RequestMapping("/topicos")
    public List<TopicoDto> lista() {
        Topico topico = new Topico("a", "b", new Curso("c", "d"));
        return TopicoDto.converter(Arrays.asList(topico, topico, topico));
    }

}
