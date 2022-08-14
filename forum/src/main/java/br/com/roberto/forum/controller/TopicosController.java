package br.com.roberto.forum.controller;

import br.com.roberto.forum.controller.dto.TopicoDto;
import br.com.roberto.forum.modelo.Topico;
import br.com.roberto.forum.repository.TopicoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/* Substitui @Controller e permite que se deixe de usar a anotação @ResponseBody em cada um de seus endpoints */
@RestController
public class TopicosController {

    @Autowired /* Injeta/insere uma implementação da interface na declaração. Faz com que não seja necessário instanciar manualmente através de um método construtor */
    private TopicoRepository topicoRepository;

    @RequestMapping("/topicos")
    public List<TopicoDto> lista(String nomeCurso) { /* nomeCurso é um parâmetro enviado na requisição. Na URL, é enviado como ?nomeCurso=x */
        List<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso);
        return TopicoDto.converter(topicos);
    }

}
