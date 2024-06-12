package co.unicauca.microservice.apirest.auth.config;

import co.unicauca.microservice.apirest.auth.jwt.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
/**
 * Configuración de seguridad para la aplicación.
 *
 * Esta clase configura la seguridad web de la aplicación, incluyendo la gestión de autenticación y autorización.
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;

	@Autowired
	private AuthenticationProvider authProvider;

	/**
	 * Configura la cadena de filtros de seguridad.
	 *
	 * @param http El objeto HttpSecurity utilizado para configurar la seguridad de las solicitudes HTTP.
	 * @return El objeto SecurityFilterChain configurado.
	 * @throws Exception Si ocurre un error durante la configuración de la seguridad.
	 */
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.authorizeHttpRequests(authRequest -> authRequest
								//.requestMatchers("/auth/authorize").permitAll()  // Usar requestMatchers en lugar de antMatchers
								//.requestMatchers("/doc/**").permitAll()
								.requestMatchers("/auth/**").permitAll()
								.requestMatchers("/h2-ui/**").permitAll()
								.requestMatchers(HttpMethod.GET, "/Products/get/**").permitAll()
								.requestMatchers(HttpMethod.GET, "/Categories/get/**").permitAll()
								.anyRequest().permitAll()
						///swagger-ui.html
				)
				.csrf(AbstractHttpConfigurer::disable)
				.sessionManagement(sessionManager -> sessionManager
						.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authenticationProvider(authProvider)
				.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
				.headers(AbstractHttpConfigurer::disable);

		return http.build();
	}
}