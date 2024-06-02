package co.unicauca.hyunseda.admin.domain.services;

import co.unicauca.hyunseda.admin.access.microservice.iMicroserviceUser;
import co.unicauca.hyunseda.admin.access.microservice.implementation.MicroserviceUser;
import co.unicauca.hyunseda.admin.access.model.Role;
import java.util.List;

/**
 *
 * @author dizu8
 */
public class UserService {
    private static UserService userService;
    private iMicroserviceUser microserviceUser;
    
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
    
    public boolean getUserByPassAndEmail (String username, String password)
    {
        List<Role> roles = microserviceUser.getUserRole(username, password);
        if (roles.isEmpty())
        {
            return false;
        }
        
        for (Role r : roles)
        {
            if (r.getName().compareTo("admin") == 0)
            {
                return true;
            }
        }
        
        return false;
    }
    
    public long getUserIdByPassAndEmail (String username, String password)
    {
        Long userID = microserviceUser.getUserId(username, password);
        
        return userID;
    }
}
