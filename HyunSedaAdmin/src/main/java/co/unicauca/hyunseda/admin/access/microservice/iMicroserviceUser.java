package co.unicauca.hyunseda.admin.access.microservice;

import co.unicauca.hyunseda.admin.domain.entities.AuthResponse;
import co.unicauca.hyunseda.admin.domain.entities.LoginRequest;
import co.unicauca.hyunseda.admin.domain.entities.RegisterRequest;
import co.unicauca.hyunseda.admin.domain.entities.Role;
import co.unicauca.hyunseda.admin.domain.entities.User;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;

/**
 *
 * @author dizu8
 */
public interface iMicroserviceUser {
    public abstract AuthResponse login(LoginRequest request);
    public abstract AuthResponse register(RegisterRequest request);
}