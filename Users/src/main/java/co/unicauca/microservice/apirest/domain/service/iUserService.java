package co.unicauca.microservice.apirest.domain.service;

import java.util.List;

import co.unicauca.microservice.apirest.domain.entity.User;
import co.unicauca.microservice.apirest.domain.entity.Role;

public interface iUserService {
    /**
     * Obtiene todos los usuarios
     * @return
     */
    List<User> getUsers();

    /**
     * Obtiene un usuario especifico por su ID
     * @param id El Id del usuario a buscar
     * @return El usuario correspondiente al Id ingresado
     */
    User getUserById(Long id);

    /**
     * Obtiene el rol de un usuario
     * @param username Nombre de usuario del usuario
     * @param password Contraseña del usuario
     * @return Una lista de los roles que posea un determinado usuario
     */
    List<Role> getRole(String username, String password);

    /**
     * Obtiene el Id de un usuario
     * @param username Nombre de usuario del usuario
     * @param password Contraseña del usuario
     * @return El Id del usuario con el respectivo username y password
     */
    Long getUserId(String username, String password);

    /**
     * Elimina un usuario especifico por su Id
     * @param id El Id del usuario que se desea eliminar
     * @return Un mensaje indicando la elemininación exitosa del usuario
     */
    String deleteUser(Long id);

    /**
     * Crea un nuevo Usuario
     * @param user El usuario a crear
     * @return Un mensaje indicando que el usuario se creó correctamente
     */
    String postUser(User user);

    /**
     * Actualiza la información del usuario
     * @param user La nueva información del usuario a actualizar
     * @param id El Id del usuario que se quiere actualizar
     * @return Un mensaje indicando que se actualizó correctamente el usuario
     */
    String putUser(User user, Long id);
}
