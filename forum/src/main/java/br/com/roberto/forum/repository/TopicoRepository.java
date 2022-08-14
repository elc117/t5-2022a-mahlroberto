package br.com.roberto.forum.repository;

import br.com.roberto.forum.modelo.Topico;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> { /* JpaRepository implementa métodos de busca mais comuns */

    List<Topico> findByCursoNome(String nomeCurso); /* Busca no banco de dados implementada automaticamente de acordo com a assinatura do método aqui descrita */

}
