package co.unicauca.hyunseda.client.access.microservice;

import co.unicauca.hyunseda.client.access.model.Role;
import co.unicauca.hyunseda.client.access.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;

/**
 *
 * @author dizu8
 */
public interface iMicroserviceUser {
    List<User> getUsers ();
    User getUser (String strId);
    List<Role> getUserRole (String usermname, String password);
    Long getUserId (String username, String password);
    String postUser (User p);
    String deleteUser (String strId);
    String putUser (User p, String strId);
    <T> T getData (String json, TypeReference<T> reference);
}