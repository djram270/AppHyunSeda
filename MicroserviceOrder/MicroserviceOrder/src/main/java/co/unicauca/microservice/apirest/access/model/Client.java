package co.unicauca.microservice.apirest.access.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Clase que representa un cliente.
 *
 * Esta clase modela un cliente con un identificador, un nombre, un apellido y una dirección.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Client {

    /** Identificador del cliente */
    private Integer clientId;

    /** Nombre del cliente */
    private String firstName;

    /** Apellido del cliente */
    private String lastName;

    /** Dirección del cliente */
    private String address;
}