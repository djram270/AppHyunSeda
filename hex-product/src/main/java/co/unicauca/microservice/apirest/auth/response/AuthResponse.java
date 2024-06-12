package co.unicauca.microservice.apirest.auth.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Respuesta de autenticación.
 *
 * Esta clase representa la respuesta devuelta después de una operación de autenticación exitosa.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {

    /**
     * El token de autenticación generado.
     */
    private String token;
}