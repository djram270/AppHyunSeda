package co.unicauca.microservice.apirest.access.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties({"username", "password", "email", "role"})
public class Client {
    private String username;
    private String password;
    private String email;
    private String role;
    /**
     * Identificador único del cliente.
     */
    private Integer clientId;

    /**
     * Primer nombre del cliente.
     */
    private String firstName;

    /**
     * Apellido del cliente.
     */
    private String lastName;

    /**
     * Dirección del cliente.
     */
    private String address;
}
