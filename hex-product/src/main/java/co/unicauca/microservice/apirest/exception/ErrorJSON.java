package co.unicauca.microservice.apirest.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Clase para representar un error en formato JSON.
 *
 * Esta clase define la estructura de un objeto JSON que representa un error ocurrido en la aplicación.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorJSON {

    /** El código de error. */
    public final EnumErrorCodes code;

    /** El campo relacionado con el error, si corresponde. */
    public final String field;

    /** El mensaje de error. */
    public final String message;

    /**
     * Constructor de la clase ErrorJSON.
     *
     * @param code El código de error.
     * @param field El campo relacionado con el error, o null si no aplica.
     * @param message El mensaje de error.
     */
    public ErrorJSON(EnumErrorCodes code, String field, String message) {
        this.code = code;
        this.field = field;
        this.message = message;
    }
}