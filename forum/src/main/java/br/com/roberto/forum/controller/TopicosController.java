package br.com.roberto.forum.controller;

import br.com.roberto.forum.controller.dto.DetalhesDoTopicoDto;
import br.com.roberto.forum.controller.dto.TopicoDto;
import br.com.roberto.forum.controller.form.TopicoForm;
import br.com.roberto.forum.modelo.Topico;
import br.com.roberto.forum.repository.CursoRepository;
import br.com.roberto.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/* Substitui @Controller e permite que se deixe de usar a anotação @ResponseBody em cada um de seus endpoints */
@RestController
@RequestMapping(name = "/topicos") /* Implica que todos os métodos nessa classe começarão com este mapeamento */
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

    /* @RequestBody indica que desta vez o conteúdo não vem pela URL */
    /* @Valid faz com que as anotações de validação nos atributos da classe sejam checadas efetivamente para o parâmetro */
    @PostMapping
    public ResponseEntity<TopicoDto> cadastra(@RequestBody @Valid TopicoForm form,
                                              UriComponentsBuilder uriBuilder /* Injetado pelo Spring Boot */) {
        Topico topico = topicoRepository.save(form.converter(cursoRepository));

        /* Boas práticas do REST: retornar código 201 quando um recurso é criado com sucesso,
        contendo a localização dele e uma representação no corpo do retorno */
        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDto(topico));
    }

    /* @GetMapping aqui deve indicar o caminho do endpoint, porque se isso não for feito, será o mesmo caminho do método lista */
    /* @PathVariable indica que o parâmetro vem na URL, e não como parâmetro no formato ?id=x */
    @GetMapping(name = "/{id}")
    public DetalhesDoTopicoDto detalha(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        return new DetalhesDoTopicoDto(topico);
    }

}
