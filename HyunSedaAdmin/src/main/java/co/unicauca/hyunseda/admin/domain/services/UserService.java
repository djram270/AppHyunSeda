package co.unicauca.hyunseda.admin.domain.services;

import co.unicauca.hyunseda.admin.access.microservice.iMicroserviceUser;
import co.unicauca.hyunseda.admin.access.microservice.implementation.MicroserviceUser;
import co.unicauca.hyunseda.admin.domain.entities.LoginRequest;
import co.unicauca.hyunseda.admin.domain.entities.RegisterRequest;
import co.unicauca.hyunseda.admin.domain.entities.Role;
import co.unicauca.hyunseda.admin.domain.entities.User;
import java.util.List;

/**
 *
 * @author dizu8
 */
public class UserService {
    private static UserService userService;
    private final iMicroserviceUser microserviceUser;
    
    private UserService ()
    {
        microserviceUser = new MicroserviceUser();
    }
    
    public static UserService getUserService ()
    {
        if (userService == null)
        {
            userService = new UserService();
        }
        return userService;
    }
    
    public String login (String username, String password)
    {
        LoginRequest request = new LoginRequest(username, password);
        return microserviceUser.login(request).getToken();
    }
    
    public boolean register (String username, String password, String firstname, String lastname, String country)
    {
        RegisterRequest request = new RegisterRequest(username, password, firstname, lastname, country);
        return microserviceUser.register(request) != null;
    }
}
