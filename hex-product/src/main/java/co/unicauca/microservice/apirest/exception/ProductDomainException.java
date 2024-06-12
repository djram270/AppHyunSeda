package co.unicauca.microservice.apirest.exception;

import java.util.List;
/**
 * Excepción de dominio para productos.
 *
 * Esta excepción se utiliza para representar errores específicos del dominio relacionados con productos en la aplicación.
 */
public class ProductDomainException extends Exception {

    /** Listado de errores. */
    public final List<ProductError> errors;

    /**
     * Constructor de la clase ProductDomainException.
     *
     * @param errors El listado de errores que provocaron la excepción.
     */
    public ProductDomainException(List<ProductError> errors) {
        this.errors = errors;
    }
}