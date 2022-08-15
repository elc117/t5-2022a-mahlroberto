package br.com.roberto.forum.config.validacao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/* O intuito da classe é prover um melhor tratamento de erros no caso de falhas de validação */
@RestControllerAdvice
public class ErroDeValidacaoHandler {

    /* Provê mensagens dinâmicas de acordo com o idioma da requisição */
    @Autowired
    private MessageSource messageSource;

    /* Indica o status HTTP que queremos retornar */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    /* Indica a exceção que queremos interceptar caso seja jogada */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroDeFormularioDto> handle(MethodArgumentNotValidException exception) {
        /* Para cada erro, deseja-se retornar o nome do campo que o causou e qual é a mensagem
        correspondente. Sendo assim, foi criado uma classe Data Transfer Object adicional que contém
        esses dois dados apenas. */
        List<ErroDeFormularioDto> dto = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach((e) -> {
            String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            dto.add(new ErroDeFormularioDto(e.getField(), mensagem));
        });
        return dto;
    }
}
