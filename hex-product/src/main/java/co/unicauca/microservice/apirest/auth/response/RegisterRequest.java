package co.unicauca.microservice.apirest.auth.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Solicitud de registro de usuario.
 *
 * Esta clase representa la solicitud enviada para registrar un nuevo usuario en el sistema.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    /**
     * El nombre de usuario deseado para el nuevo usuario.
     */
    private String username;

    /**
     * La contraseña deseada para el nuevo usuario.
     */
    private String password;

    /**
     * El nombre del nuevo usuario.
     */
    private String firstname;

    /**
     * El apellido del nuevo usuario.
     */
    private String lastname;

    /**
     * El país de residencia del nuevo usuario.
     */
    private String country;
}
