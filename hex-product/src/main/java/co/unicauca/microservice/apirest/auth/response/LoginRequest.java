package co.unicauca.microservice.apirest.auth.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Solicitud de inicio de sesión.
 *
 * Esta clase representa la solicitud enviada para iniciar sesión en el sistema.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

    /**
     * El nombre de usuario del usuario que intenta iniciar sesión.
     */
    private String username;

    /**
     * La contraseña del usuario que intenta iniciar sesión.
     */
    private String password;
}
