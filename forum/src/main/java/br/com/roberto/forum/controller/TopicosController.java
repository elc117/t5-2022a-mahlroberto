package br.com.roberto.forum.controller;

import br.com.roberto.forum.controller.dto.TopicoDto;
import br.com.roberto.forum.controller.form.TopicoForm;
import br.com.roberto.forum.modelo.Topico;
import br.com.roberto.forum.repository.CursoRepository;
import br.com.roberto.forum.repository.TopicoRepository;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/* Substitui @Controller e permite que se deixe de usar a anotação @ResponseBody em cada um de seus endpoints */
@RestController
@RequestMapping("/topicos") /* Implica que todos os métodos nessa classe começarão com este mapeamento */
public class TopicosController {

    @Autowired /* Injeta/insere uma implementação da interface na declaração. Faz com que não seja necessário instanciar manualmente através de um método construtor */
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public List<TopicoDto> lista(String nomeCurso) { /* nomeCurso é um parâmetro enviado na requisição. Na URL, é enviado como ?nomeCurso=x */
        List<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso);
        return TopicoDto.converter(topicos);
    }

    @PostMapping
    public ResponseEntity<TopicoDto> cadastra(@RequestBody TopicoForm form, UriComponentsBuilder uriBuilder) {
        Topico topico = topicoRepository.save(form.converter(cursoRepository));

        /* Boas práticas do REST, retornar código 201 quando um recurso é criado com sucesso,
        contendo a localização dele e uma representação no corpo do retorno */
        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDto(topico));
    }

}
