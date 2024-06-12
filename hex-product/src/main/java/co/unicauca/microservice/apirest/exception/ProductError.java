package co.unicauca.microservice.apirest.exception;

/**
 * Clase para representar un error relacionado con productos.
 *
 * Esta clase define la estructura de un error específico relacionado con productos en la aplicación.
 */
public class ProductError {

    /** El código del error. */
    public final EnumErrorCodes code;

    /** El campo relacionado con el error. */
    public final String field;

    /** La descripción del error. */
    public final String description;

    /**
     * Constructor de la clase ProductError.
     *
     * @param code El código del error.
     * @param field El campo relacionado con el error.
     * @param description La descripción del error.
     */
    public ProductError(EnumErrorCodes code, String field, String description) {
        this.code = code;
        this.field = field;
        this.description = description;
    }
}
