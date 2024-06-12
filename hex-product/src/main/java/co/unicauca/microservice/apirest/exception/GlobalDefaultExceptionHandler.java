package co.unicauca.microservice.apirest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * Clase para manejar excepciones globales.
 *
 * Esta clase proporciona métodos para manejar excepciones específicas y devolver respuestas JSON apropiadas.
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    /**
     * Maneja la excepción ResourceNotFoundException.
     *
     * @param e La excepción ResourceNotFoundException.
     * @return La respuesta de error en formato JSON.
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    @RequestMapping(produces = "application/json")
    @ResponseBody
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException e) {
        return new ResponseEntity<>("{\"errors\":[{\"code\":\"NOT_FOUND\"}]}", HttpStatus.NOT_FOUND);
    }

    /**
     * Maneja la excepción ProductDomainException.
     *
     * @param e La excepción ProductDomainException.
     * @return La respuesta de error en formato JSON.
     */
    @ExceptionHandler(ProductDomainException.class)
    @RequestMapping(produces = "application/json")
    @ResponseBody
    public ResponseEntity<ErrorsPayload> handleTodoDomainException(ProductDomainException e) {
        return new ResponseEntity<>(new ErrorsPayload(e.errors), HttpStatus.UNPROCESSABLE_ENTITY);
    }
}