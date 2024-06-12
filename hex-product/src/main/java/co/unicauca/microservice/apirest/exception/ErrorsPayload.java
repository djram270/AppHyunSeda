package co.unicauca.microservice.apirest.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase para representar una carga útil de errores.
 *
 * Esta clase define la estructura de una carga útil que contiene una lista de errores ocurridos en la aplicación.
 */
public class ErrorsPayload {

    /** La lista de errores. */
    public final List<ErrorJSON> errors;

    /**
     * Constructor de la clase ErrorsPayload.
     *
     * @param applicationErrors La lista de errores de la aplicación.
     */
    public ErrorsPayload(List<ProductError> applicationErrors) {
        this.errors = new ArrayList<>();
        applicationErrors.forEach(applicationError -> errors.add(fromApplicationError(applicationError)));
    }

    /**
     * Convierte un error de la aplicación a un objeto ErrorJSON.
     *
     * @param error El error de la aplicación.
     * @return El objeto ErrorJSON creado a partir del error de la aplicación.
     */
    private ErrorJSON fromApplicationError(ProductError error) {
        return new ErrorJSON(error.code, error.field, error.description);
    }
}