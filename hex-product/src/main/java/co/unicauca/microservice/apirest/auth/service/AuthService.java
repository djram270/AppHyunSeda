package co.unicauca.microservice.apirest.auth.service;

import co.unicauca.microservice.apirest.auth.entity.Role;
import co.unicauca.microservice.apirest.auth.entity.User;
import co.unicauca.microservice.apirest.auth.jwt.JwtService;
import co.unicauca.microservice.apirest.auth.repository.UserRepository;
import co.unicauca.microservice.apirest.auth.response.AuthResponse;
import co.unicauca.microservice.apirest.auth.response.LoginRequest;
import co.unicauca.microservice.apirest.auth.response.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
/**
 * Servicio de autenticación.
 *
 * Este servicio proporciona métodos para realizar operaciones de autenticación, como inicio de sesión, registro de usuarios y búsqueda de usuarios por nombre.
 */
@Service
@RequiredArgsConstructor
public class AuthService {

    /** Repositorio para la entidad de usuario */
    private final UserRepository userRepository;

    /** Servicio para la gestión de tokens JWT */
    private final JwtService jwtService;

    /** Codificador de contraseñas */
    private final PasswordEncoder passwordEncoder;

    /** Administrador de autenticación */
    private final AuthenticationManager authenticationManager;

    /**
     * Realiza la autenticación del usuario con las credenciales proporcionadas.
     *
     * @param request La solicitud de inicio de sesión que contiene las credenciales del usuario.
     * @return La respuesta de autenticación con el token generado.
     */
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    /**
     * Registra un nuevo usuario en el sistema.
     *
     * @param request La solicitud de registro que contiene la información del nuevo usuario.
     * @return La respuesta de autenticación con el token generado para el nuevo usuario.
     */
    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .country(request.getCountry())
                .role(Role.USER)
                .build();

        userRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }

    /**
     * Busca un usuario por su nombre de usuario.
     *
     * @param name El nombre de usuario del usuario a buscar.
     * @return El usuario encontrado.
     */
    public User name(String name)
    {
        return userRepository.findByUsername(name).orElseThrow();
    }
}
