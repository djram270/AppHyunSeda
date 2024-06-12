package co.unicauca.microservice.apirest.auth.controller;

import co.unicauca.microservice.apirest.auth.entity.User;
import co.unicauca.microservice.apirest.auth.response.AuthResponse;
import co.unicauca.microservice.apirest.auth.response.LoginRequest;
import co.unicauca.microservice.apirest.auth.response.RegisterRequest;
import co.unicauca.microservice.apirest.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;
/**
 * Controlador REST para la autenticación de usuarios.
 *
 * Este controlador maneja las solicitudes de inicio de sesión, registro y búsqueda de usuario por nombre.
 */
@Configuration
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private AuthService authService;

    /**
     * Maneja la solicitud de inicio de sesión.
     *
     * @param request La solicitud de inicio de sesión que contiene las credenciales del usuario.
     * @return La respuesta de autenticación.
     */
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    /**
     * Maneja la solicitud de registro.
     *
     * @param request La solicitud de registro que contiene la información del nuevo usuario.
     * @return La respuesta de autenticación.
     */
    @Secured("SUPER_ADMIN")
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    /**
     * Maneja la solicitud para obtener un usuario por nombre.
     *
     * @param name El nombre del usuario a buscar.
     * @return El usuario encontrado.
     */
    @GetMapping("/name/{name}")
    public ResponseEntity<User> getUserByName(@PathVariable String name) {
        return ResponseEntity.ok(authService.name(name));
    }
}